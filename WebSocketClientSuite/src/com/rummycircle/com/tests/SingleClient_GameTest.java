package com.rummycircle.com.tests;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.json.JSONArray;
import org.json.JSONObject;

import com.rummycircle.wsclient.Action_SingleClient;
import com.rummycircle.wsclient.ClientClass;
import com.rummycircle.wsclient.MessageHandler;

public class SingleClient_GameTest {

	private static Action_SingleClient executeAction;
	private static ClientClass client;
	private static ClientUpgradeRequest upgradeRequest;
	private static Logger Log = Logger.getLogger(SingleClient_GameTest.class.getName());
	private static int i = 1, noOfPlayers, p = -1;
	private static long[] playerID, receiverID;
	private static long playerIDTurn, playerIDReceived, startingPlayerID,
			startingReceiverID, receiverIDReceived;
	private static String action, type, request;
	private static List<String> actionSequence = new ArrayList<String>();
	private static List<String> NoActionTriggeredResponseList = new ArrayList<String>();
	private static Map<String, List<String>> playerTurnMap = new HashMap<String, List<String>>();
	private static Map<String, List<String>> spectatorMap = new HashMap<String, List<String>>();
	private static ScheduledExecutorService executor;
	static JSONObject response, value;
	private static boolean flag = false;
	private static String[] sessionId = {"SSID8060b028-54df-49c8-a307-1737fcf88016","SSIDed781e3e-7abf-4b66-819a-300df01fc58b"};

	public static void main(String[] args) throws Exception {

		// reading url from prop file
		Properties prop = new Properties();
		String file = System.getProperty("user.dir")
				+ "/conf/file_stage.properties";
		prop.load(new FileInputStream(file));
		String url = prop.getProperty("url");
		startingPlayerID = Long.parseLong(prop.getProperty("playerID"));
		startingReceiverID = Long.parseLong(prop.getProperty("receiverID"));

		// loading action sequence in a list from prop file
		String fileLoc = System.getProperty("user.dir")
				+ "/conf/actionlist_stage.properties";
		FileReader fileReader = new FileReader(fileLoc);
		BufferedReader reader = new BufferedReader(fileReader);

		String line = "";
		while ((line = reader.readLine()) != null)
			actionSequence.add(line);

		// building unprecedented response list
		String fileLoc1 = System.getProperty("user.dir")
				+ "/conf/NoActionTriggeredResponse.properties";
		fileReader = new FileReader(fileLoc1);
		reader = new BufferedReader(fileReader);
		line = "";
		while ((line = reader.readLine()) != null)
			NoActionTriggeredResponseList.add(line);

		// playerturn response map
		String fileLoc2 = System.getProperty("user.dir")
				+ "/conf/playerturn.properties";
		fileReader = new FileReader(fileLoc2);
		reader = new BufferedReader(fileReader);
		line = "";
		while ((line = reader.readLine()) != null) {
			String[] split = line.split("=");
			playerTurnMap.put(split[0], Arrays.asList(split[1].split(",")));
		}

		// spectator response map
		String fileLoc3 = System.getProperty("user.dir")
				+ "/conf/spectator.properties";
		fileReader = new FileReader(fileLoc3);
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
		client = new ClientClass();// creating n clients
		upgradeRequest = new ClientUpgradeRequest();// creating n requests
		executeAction = new Action_SingleClient(client, url, upgradeRequest);
		startListener(client);
		
		playerID = new long[noOfPlayers];
		receiverID = new long[noOfPlayers];
		
		for (int i = 0; i < noOfPlayers; i++) {
			playerID[i] = startingPlayerID + i;
			receiverID[i] = startingReceiverID;
		}
		
		defaultTask(noOfPlayers);
	}

	private static void defaultTask(int noOfPlayers) {
		Runnable runTask = new Runnable() {
			public void run() {
				if (i == 3) {
					p = 0;
					Log.info("Shutting down default task");
					executor.shutdown();
				}
				try {
					p++;
					if (p == noOfPlayers) {
						p = 0;
						i++;
					}
					action = actionSequence.get(i);
					playerIDTurn = playerID[p];
					Log.info("Executed Action : " + action + " For : "
							+ playerID[p]+","+receiverID[p]+","+sessionId[p]);
					executeAction.doAction(action, receiverID[p], playerID[p], sessionId[p]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		executor = Executors.newScheduledThreadPool(20);
		Log.info("Starting executor");
		executor.scheduleAtFixedRate(runTask, 0, 4, TimeUnit.SECONDS);
	}

	private static void sendMessageTask(int noOfPlayers) {
		Runnable runTask = new Runnable() {
			public void run() {
				if (i == actionSequence.size()){
						Log.info("Shutting down default task");
						try {
							shutDown();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				try {
					request = actionSequence.get(i++);
					action = request.split(",")[1];
					p = Integer.parseInt(request.split(",")[0])-1;
					playerIDTurn = playerID[p];
					Log.info("Executed Action : " + action + " For : "+ playerID[p]+","+receiverID[p]+","+sessionId[p]);
					executeAction.doAction(action, receiverID[p], playerID[p], sessionId[p]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		executor = Executors.newScheduledThreadPool(20);
		executor.scheduleAtFixedRate(runTask, 0, 4, TimeUnit.SECONDS);
	}

	public static void startListener(ClientClass client) {
		client.addMessageHandler(new MessageHandler() {
			public void handleMessage(String message) {

				try {
					Log.info("Response Received Against "+action+" For Player : "+playerID[p]+","+receiverID[p]+" : "+message);
					response = new JSONObject(message);
					type = response.getString("type");
					
					if (!NoActionTriggeredResponseList.contains(type)) {

						switch (type) {
						case "fmgresponse":
							value = response.getJSONObject("value");
							playerIDReceived = value.getLong("playerid");
							receiverIDReceived = value.getLong("receiverid");
							receiverID[p] = receiverIDReceived;
							checkResponse(action, type, playerIDReceived);
							executeAction.heartBeatTask(receiverID[p], playerIDReceived, sessionId[p]);
							break;
						case "heartbeatres":
							break;
						case "playerseq":
							flag = true;
							if (!flag) {
								JSONObject orderedmplayerids = response
										.getJSONObject("orderedmplayerids");
								JSONArray order = orderedmplayerids
										.getJSONArray("jsonObj");
								long[] playerID1 = new long[noOfPlayers];
								long[] receiverID1 = new long[noOfPlayers];
								for (int i = 0; i < order.length(); i++){
									int k=0;
									while(k<noOfPlayers){
										if(playerID[k]==order.getLong(i)){
											playerID1[i]=playerID[k];
											receiverID1[i]=receiverID[k];
											break;
										}
										k++;
									}
								}
								receiverID=receiverID1;
								playerID=playerID1;
								checkResponse(action, type, playerIDReceived);
								sendMessageTask(noOfPlayers);
							}
							break;
						default:
							/*checkResponse(action, type, playerID[p]);
							break;*/
						}
					} else
						checkResponse(type);// check for game state dependent
											// response
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void checkResponse(String type) {
		// TODO Auto-generated method stub
		// check state of game
	}

	private static void checkResponse(String action, String response,
			long playerIDReceived) {
		// TODO Auto-generated method stub
		if (playerIDReceived == playerIDTurn) {
			if (playerTurnMap.get(action).contains(response))
				Log.info(action + " For Player " + playerIDReceived
						+ " Pass");
			else
				Log.info(action + " For Player " + playerIDReceived
						+ " Fail");
		} else {
			if (spectatorMap.get(action).contains(response))
				Log.info(action + " For Spectator " + playerIDReceived
						+ " Pass");
			else
				Log.info(action + " For Spectator " + playerIDReceived
						+ " Fail");
		}
	}

	private static void shutDown() throws Exception {
		Log.info("Closing connection");
		executor.shutdown();
		executeAction.executor.shutdown();
		client.close();
	}
}