package com.rummycircle.com.tests;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.json.JSONObject;

import com.rummycircle.wsclient.Action;
import com.rummycircle.wsclient.ClientClass;
import com.rummycircle.wsclient.MessageHandler;

public class ConcurrencyTest {

	private static Action[] executeAction;
	private static ClientClass[] client;
	private static ClientUpgradeRequest[] upgradeRequest;
	private static Logger Log = Logger.getLogger(ConcurrencyTest.class
			.getName());
	private static int actionCounter = 1, playerNo, noOfPlayers;
	private static String action, responseType;
	private static List<String> actionSequence = new CopyOnWriteArrayList<String>();
	private static List<String> NoActionTriggeredResponseList = new CopyOnWriteArrayList<String>();
	private static Map<String, List<String>> playerTurnMap = new ConcurrentHashMap<String, List<String>>();
	private static Map<String, List<String>> spectatorMap = new ConcurrentHashMap<String, List<String>>();
	private static ScheduledExecutorService[] executor;
	private static String[] sessionId = {"SSID1b6fff9f-a8c1-4b41-9143-76ecfb05d5f3","SSIDed88f6d7-b158-4ea5-9345-c53a097c3726"};
	private static Map<Integer,Integer> playerSeqMap = new HashMap<Integer,Integer>();
	
	public static void main(String[] args) throws Exception {
		// reading url from prop file
		Properties prop = new Properties();
		String envfileloc = System.getProperty("user.dir")
				+ "/conf/file_Stage.properties";
		prop.load(new FileInputStream(envfileloc));
		String url = prop.getProperty("url");

		// loading action sequence in a list from prop file
		String actionFileLoc = System.getProperty("user.dir")
				+ "/conf/concurrentActions.properties";
		FileReader fileReader = new FileReader(actionFileLoc);
		BufferedReader reader = new BufferedReader(fileReader);
		String line = "";
		while ((line = reader.readLine()) != null)
			actionSequence.add(line);

		// building unexpected response list
		String serverResponseFileLoc = System.getProperty("user.dir")
				+ "/conf/NoActionTriggeredResponse.properties";
		fileReader = new FileReader(serverResponseFileLoc);
		reader = new BufferedReader(fileReader);
		line = "";
		while ((line = reader.readLine()) != null)
			NoActionTriggeredResponseList.add(line);

		// playerturn response map
		String playerTurnFileLoc = System.getProperty("user.dir")
				+ "/conf/playerTurnResponse.properties";
		fileReader = new FileReader(playerTurnFileLoc);
		reader = new BufferedReader(fileReader);
		line = "";
		while ((line = reader.readLine()) != null) {
			String[] split = line.split("=");
			playerTurnMap.put(split[0], Arrays.asList(split[1].split(",")));
		}

		// spectator response map
		String spectatorFileLoc = System.getProperty("user.dir")
				+ "/conf/spectatorResponse.properties";
		fileReader = new FileReader(spectatorFileLoc);
		reader = new BufferedReader(fileReader);
		line = "";
		while ((line = reader.readLine()) != null) {
			String[] split = line.split("=");
			spectatorMap.put(split[0], Arrays.asList(split[1].split(",")));
		}

		// create setup for test to run
		Log.info("URL :" + url);
		createSetup(url);
	}

	public static void createSetup(String url) throws Exception {
		// loading log4j property
		PropertyConfigurator.configure("log4j.properties");

		// creating instances
		noOfPlayers = Integer.parseInt(actionSequence.get(0).split("=")[1]);
		Log.info("noOfPlayers :" + noOfPlayers);
		client = new ClientClass[noOfPlayers];
		upgradeRequest = new ClientUpgradeRequest[noOfPlayers];
		executeAction = new Action[noOfPlayers];
		for (int playerIndex = 0; playerIndex < noOfPlayers; playerIndex++) {
			client[playerIndex] = new ClientClass();
			upgradeRequest[playerIndex] = new ClientUpgradeRequest();
			executeAction[playerIndex] = new Action("PT",client[playerIndex], url, upgradeRequest[playerIndex], playerIndex, sessionId[playerIndex]);
			playerSeqMap.put(playerIndex+1,playerIndex);
			startListener(client[playerIndex], playerIndex);
		}
		// starting the action sequence
		for (int playerIndex = 0; playerIndex < noOfPlayers; playerIndex++)
			sendMessageTask(playerIndex);
	}

	private static void sendMessageTask(int playerIndex) {
		Runnable runTask = new Runnable() {
			public void run() {
				if (actionCounter == actionSequence.size())
					try {
						Log.info("Shutting down");
						shutDown();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				action = actionSequence.get(actionCounter++);
				playerNo = playerIndex + 1;
				Log.info("Executed Action_Working : " + action + " For Player : "
						+ (playerNo));
				try {
					executeAction[playerIndex].doAction(action);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		executor[playerIndex] = Executors.newScheduledThreadPool(10);
		Log.info("Starting executor");
		executor[playerIndex].scheduleAtFixedRate(runTask, 0, 4, TimeUnit.SECONDS);
	}

	public static void startListener(ClientClass client, int playerIndex) {
		client.addMessageHandler(new MessageHandler() {
			public void handleMessage(String responseMessage) {
				try {
					responseType = new JSONObject(responseMessage).getString("type");
					Log.info("Response Received for Player : " + (playerIndex + 1)
							+ " : " + responseType);
					boolean flag = NoActionTriggeredResponseList.contains(responseType);
					if (!flag) {
						switch (responseType) {
						case "fmgresponse":
							JSONObject fmgRespJson = new JSONObject(responseMessage);
							JSONObject value = fmgRespJson.getJSONObject("value");
							executeAction[playerIndex].receiverID = value
									.getLong("receiverid");
							checkResponse(action, responseType, playerIndex);
							executeAction[playerIndex].heartBeatTask();
							break;
						case "heartbeatres":
							Log.info("HeartBeat Response Received for Player : "
									+ responseType);
							break;
						default:
							checkResponse(action, responseType, playerIndex);
						}
					} else
						checkResponse(responseType, playerIndex);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected static void checkResponse(String responseType, int playerIndex) {
		// check if the game state is such that this response is expected to
		// arrive
		Log.info("Message Received by Spectator :" + playerIndex + " : " + responseType);
	}

	private static void checkResponse(String action, String responseType, int playerIndex) {
		// TODO Auto-generated method stub
		if (playerIndex == (playerNo - 1)) {
			if (playerTurnMap.get(action).contains(responseType))
				Log.info(action + " For Player " + (playerIndex + 1) + " Pass");
			else
				Log.info(action + " For Player " + (playerIndex + 1) + " Fail");
		} /*else {
			if (spectatorMap.get(action).contains(response))
				Log.info(action + " For Spectator " + (p + 1) + " Pass");
			else
				Log.info(action + " For Spectator " + (p + 1) + " Fail");
		}*/
	}

	private static void shutDown() throws Exception {
		for (int playerIndex = 0; playerIndex < noOfPlayers; playerIndex++) {
			Log.info("Closing connection for Player :" + playerIndex);
			executor[playerIndex].shutdown();
			executeAction[playerIndex].executor.shutdown();
			client[playerIndex].close();
		}
	}
}