package com.rummycircle.com.tests;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.json.JSONArray;
import org.json.JSONObject;

import com.rummycircle.wsclient.Action;
import com.rummycircle.wsclient.ClientClass;
import com.rummycircle.wsclient.MessageHandler;

public class GameTest {

	private static Action[] executeAction;
	private static ClientClass[] client;
	private static TableStatus[] aastatus;
	private static GameStatus[] gmstatus;
	private static ClientUpgradeRequest[] upgradeRequest;
	private static Logger Log = Logger.getLogger(GameTest.class.getName());
	private static int actionCounter, playerIndex_File, noOfPlayers, playerTurn;
	private static String action, request;
	private static List<String> actionSequence = new ArrayList<String>();
	private static List<String> NoActionTriggeredResponseList = new ArrayList<String>();
	private static Map<String, List<String>> playerTurnMap = new HashMap<String, List<String>>();
	private static Map<String, List<String>> opponentMap = new HashMap<String, List<String>>();
	private static ScheduledExecutorService executor;
	private static Map<Integer,Integer> playerSeqMap = new HashMap<Integer,Integer>();
	private static Map<Long,Integer> playerIndex_vs_MplayerID = new HashMap<Long,Integer>();
	private static Map<Long,JSONArray> cardMap = new HashMap<Long,JSONArray>();
	private static long playerID;
	private static boolean playerseqFlag = false, plrmoveFlag=false, fmgFlag=false, tossWinnerFlag=false;
	private static String[] sessionId = {"10001","10002","10003","10004","10005","10006"};
	//private static String[] sessionId = {"SSID92fb7513-c837-4c6a-8fbf-a80c038376a7","SSIDedc6935f-46e9-4693-b3bb-5f950fa41246"};
	private static Map<String,Integer> getResponseCount = new HashMap<String,Integer>();
	private static Map<String,List<String>> actionResponse = new HashMap<String,List<String>>();
	private static Map<Integer,Map<String,List<String>>> responseMap = new HashMap<Integer,Map<String,List<String>>>();
	
	public static void main(String[] args) throws Exception {
		
		PropertyConfigurator.configure("log4j.properties");
		String env = "PT";
		
		// reading url from prop file
		Properties prop = new Properties();
		String envFileName = "file_"+env+".properties";
		String envFileLoc = System.getProperty("user.dir")+ "/conf/"+envFileName;
		prop.load(new FileInputStream(envFileLoc));
		
		// getting base playerID
		playerID = Long.parseLong(prop.getProperty("playerID"));
		
		//loading action sequence in a list from prop file
		buildActionList("actionlist_"+env+".properties", actionSequence);

		// building unprecedented response list
		buildActionList("serverTriggeredResponse.properties", NoActionTriggeredResponseList);

		// playerturn response map
		buildActionResponseMap("playerTurnResponse.properties", playerTurnMap);

		// opponent response map
		buildActionResponseMap("opponentResponse.properties", opponentMap);

		// create setup for test to run
		String url = prop.getProperty("url");
		Log.info("URL :" + url);
		createSetup(url,env);
	}

	private static void buildActionList(String fileName, List<String> actionList) throws IOException {
		
		String fileLoc = System.getProperty("user.dir")+ "/conf/"+fileName;
		FileReader fileReader = new FileReader(fileLoc);
		BufferedReader reader = new BufferedReader(fileReader);
		String line = "";
		while ((line = reader.readLine()) != null)
			actionList.add(line);
	}

	private static void buildActionResponseMap(String fileName, Map<String,List<String>> map) throws IOException{
		
		String fileLoc = System.getProperty("user.dir")+ "/conf/"+fileName;
		FileReader fileReader = new FileReader(fileLoc);
		BufferedReader reader = new BufferedReader(fileReader);
		String line = "";
		while ((line = reader.readLine()) != null) {
			String[] split = line.split("=");
			map.put(split[0], Arrays.asList(split[1].split(",")));
		}
	}
	
	public static void createSetup(String url, String env) throws Exception {
		
		// creating instances
		noOfPlayers = Integer.parseInt(actionSequence.get(actionCounter).split("=")[1]);
		Log.info("noOfPlayers :" + noOfPlayers);
		client = new ClientClass[noOfPlayers];
		upgradeRequest = new ClientUpgradeRequest[noOfPlayers];
		executeAction = new Action[noOfPlayers];
		aastatus = new TableStatus[noOfPlayers];
		gmstatus = new GameStatus[noOfPlayers];
		
		// instantiating n instances for client and corresponding listener 
		for (int playerCounter = 0; playerCounter < noOfPlayers; playerCounter++) {
			client[playerCounter] = new ClientClass();
			upgradeRequest[playerCounter] = new ClientUpgradeRequest();
			executeAction[playerCounter] = new Action(env,client[playerCounter], url, upgradeRequest[playerCounter], playerCounter, sessionId[playerCounter]);
			playerSeqMap.put(playerCounter+1,playerCounter+1);
			aastatus[playerCounter] = new TableStatus();
			gmstatus[playerCounter] = new GameStatus();
			startListener(client[playerCounter], playerCounter);
		}
		
		//starting the action sequence
		startDefaultTask();
	}

	private static void startDefaultTask() {

		Runnable runTask = new Runnable() {
			public void run() {
				try {
					actionCounter++;
					request = actionSequence.get(actionCounter);
					playerIndex_File = Integer.parseInt(request.split(",")[0]);
					playerTurn = playerSeqMap.get(playerIndex_File)-1;
					action = request.split(",")[1];
					Log.info("EXECUTED ACTION : " + action + " PLAYER : "+ (playerID+playerTurn+1));
					executeAction[playerTurn].doAction(action);
					if (actionCounter == (noOfPlayers*3)){
						Log.info("#####DEFAULT TASKS FINISHED#####");
						executor.shutdown();
						printResponseList();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		executor = Executors.newScheduledThreadPool(30);
		executor.scheduleAtFixedRate(runTask, 0, 1, TimeUnit.SECONDS);
	}
	
	public static void startListener(ClientClass client, int playerIndex_Listener) {
		client.addMessageHandler(new MessageHandler() {
			public void handleMessage(String responseMessage) {
					processMessage(responseMessage, playerIndex_Listener);	
			}
		});
	}

	private static void processMessage(String responseMessage, int playerIndex_Listener){
		
	  	JSONObject responseJson = new JSONObject(responseMessage);
		String responseType = responseJson.getString("type");
			
			if(!responseType.equals("heartbeatres"))
				Log.info("RESPONSE RECEIVED : "+(playerID+playerIndex_Listener+1)+" : "+responseMessage);
			
			switch (responseType) {
			
			//check for fmg request
			case "handshakeresponse":
				checkResponse(action, responseType, playerIndex_Listener);
				break;	
			
			case "startgametimer":
				checkResponse(action, responseType, playerIndex_Listener);
				break;
			
			case "buyinsucc":
				checkResponse(action, responseType, playerIndex_Listener);
				break;
			
			case "fmgresponse":
				if(!fmgFlag)
					getReceiverId(responseJson, playerIndex_Listener);
				executeAction[playerIndex_Listener].heartBeatTask();
				checkResponse(action, responseType, playerIndex_Listener);
				break;
			
			case "aastatus":
				getAastatus(responseJson, playerIndex_Listener);
				checkResponse(action, responseType, playerIndex_Listener);
				break;	
				
			//check for setup request response	
			case "autodropcancelsuccess":
				checkResponse(action, responseType, playerIndex_Listener);
				break;	
			
			case "setupres":
				checkResponse(action, responseType, playerIndex_Listener);
				break;	
			
			case "disconprotectionpref":
				checkResponse(action, responseType, playerIndex_Listener);
				break;					
			
			case "plrdisconnect":
				checkResponse(action, responseType, playerIndex_Listener);
				break;	
			
			case "autobuyinpref":
				checkResponse(action, responseType, playerIndex_Listener);
				break;	
			
			//check for ready request response	
			case "seatsetup":
				checkResponse(action, responseType, playerIndex_Listener);
				break;	
			
			case "themechange":
				checkResponse(action, responseType, playerIndex_Listener);
				break;	
			
			case "hud":
				checkResponse(action, responseType, playerIndex_Listener);
				break;	
			
			case "lpinfo":
				checkResponse(action, responseType, playerIndex_Listener);
				break;	
			
			//check for server triggered responses	
			case "matchinfo":
				getMatchInfo(responseJson);
				checkResponse(responseType, playerIndex_Listener);
				break;
			
			case "gmstatus":
				getGmstatus(responseJson,playerIndex_Listener);
				checkResponse(responseType, playerIndex_Listener);
				break;
			
			case "tosscard":
				getGameId(responseJson, playerIndex_Listener);
				checkResponse(responseType, playerIndex_Listener);
				break;
			
			case "tosswinner":
				if(!tossWinnerFlag)
					getTossWinner(responseJson);
				checkResponse(responseType, playerIndex_Listener);
				break;
			
			case "gmsetup":
				checkResponse(responseType, playerIndex_Listener);
				break;
			
			case "playerseq":
				if(!playerseqFlag)
					getPlayerSeq(responseJson);
				checkResponse(responseType, playerIndex_Listener);
				break;
			
			case "dealer":
				checkResponse(responseType, playerIndex_Listener);
				break;
			
			case "closeddecksize":
				checkResponse(responseType, playerIndex_Listener);
				break;
			
			case "jkrcard":
				checkResponse(responseType, playerIndex_Listener);
				break;
			
			case "oprcard":
				checkResponse(responseType, playerIndex_Listener);
				break;
			
			case "plrhandcard":
				getPlayerHandCards(responseJson, playerIndex_Listener);
				checkResponse(responseType, playerIndex_Listener);
				break;
			
			case "discards":
				checkResponse(responseType, playerIndex_Listener);
				break;
			
			case "plrmove":
				if(!plrmoveFlag)
					getPlayerTurn();
				checkResponse(responseType, playerIndex_Listener);
				break;
			
			default:
				break;
			}
			responseCount(responseType);
			buildResponseMapping(responseType, playerIndex_Listener);
	}
	
	private static void buildResponseMapping(String responseType, int playerIndex_Listener) {
		
		if(actionResponse.containsKey(action)){
			List<String> tempList = actionResponse.get(action);
			tempList.add(responseType);
			actionResponse.put(action, tempList);
		}else{
			List<String> tempList = new ArrayList<String>();
			tempList.add(responseType);
			actionResponse.put(action, tempList);
		}
		responseMap.put(playerIndex_Listener, actionResponse);
	}

	private static void responseCount(String responseType) {
		
		if(getResponseCount.containsKey(responseType))
			getResponseCount.put(responseType,getResponseCount.get(responseType)+1);
		else
			getResponseCount.put(responseType,1);
	}

	private static void getPlayerTurn() {
		
		plrmoveFlag=true;
		for(Map.Entry<Integer, Integer> x:playerSeqMap.entrySet())
			Log.info("#####Turn :"+x.getKey()+" : PlayerIndex : "+x.getValue());
		Log.info("#####START GAME#####");
		startPlayingGame();
	}

	private static void getPlayerHandCards(JSONObject responseJson,	int playerIndex_Listener) {
		
		JSONObject value = responseJson.getJSONObject("value");
		long playerid = value.getLong("playerid");
		JSONArray cardList = value.getJSONArray("cards").getJSONArray(0);
		String disCard = cardList.getString(0);
		Log.info("#########DisCard : "+disCard);
		cardMap.put(playerid,cardList);
		executeAction[playerIndex_Listener].cardId=disCard;
		Log.info(disCard+" : ######CARD ID THAT SHOULD BE DISCARDED FOR PLAYER : "+playerIndex_Listener);
	}

	private static void getPlayerSeq(JSONObject responseJson) {
		
		JSONArray mplayeridOrderArray = responseJson.getJSONObject("value").getJSONArray("orderedmplayerids");
		for(int playerCounter=0;playerCounter<mplayeridOrderArray.length();playerCounter++){
			long mplayerid = mplayeridOrderArray.getLong(playerCounter);
			int index = playerIndex_vs_MplayerID.get(mplayerid);
			playerSeqMap.put(playerCounter+1,index);
		}
		playerseqFlag=true;
	}

	private static void getTossWinner(JSONObject responseJson) {
		
		long winner = responseJson.getJSONObject("value").getLong("mplayerid");
		Log.info("#####TOSSWINNER :"+winner);
	}

	private static void getGameId(JSONObject responseJson, int playerIndex_Listener) {
		
		long gameId = responseJson.getJSONObject("value").getLong("gameid");
		executeAction[playerIndex_Listener].gameId = gameId;
		Log.info(gameId+" #####GameID for Player : "+playerIndex_Listener);	
	}

	private static void getGmstatus(JSONObject responseJson, int playerIndex_Listener) {
		
		int statusid = responseJson.getJSONObject("value").getInt("statusid");
		gmstatus[playerIndex_Listener].status = statusid;	
	}

	private static void getMatchInfo(JSONObject responseJson) {
		
		JSONArray matchseataray = responseJson.getJSONObject("value").getJSONArray("matchseataray");
		Iterator<Object> itr = matchseataray.iterator();
		while(itr.hasNext()){	
			JSONObject json = (JSONObject)itr.next();
			long mplayerID = json.getLong("matchplayerid");
			long matchId = json.getLong("matchid");
			long matchinfo_playerID = json.getJSONObject("player").getLong("id");
			int playerIndex = (int)Math.abs(playerID-matchinfo_playerID);
			executeAction[playerIndex-1].mplayerID = mplayerID;
			executeAction[playerIndex-1].matchId = matchId;
			Log.info(mplayerID+" #####mplayerID for Player : "+(playerIndex-1));
			Log.info(matchId+" #####MatchId for Player : "+(playerIndex-1));
			playerIndex_vs_MplayerID.put(mplayerID,playerIndex);
		}
	}

	private static void getAastatus(JSONObject responseJson, int playerIndex_Listener) {
		
		int astatus = responseJson.getJSONObject("value").getInt("aastatus");
		aastatus[playerIndex_Listener].status=astatus;
	}

	private static void getReceiverId(JSONObject responseJson, int playerIndex_Listener) {
		
		fmgFlag=true;
		JSONObject value = responseJson.getJSONObject("value");
		for(int counter=0;counter<noOfPlayers;counter++)
			executeAction[counter].receiverID=value.getLong("receiverid");
	}

	private static void startPlayingGame() {
		
		Runnable playMoves = new Runnable() {
			public void run() {
				try {
					actionCounter++;
					request = actionSequence.get(actionCounter);
					playerIndex_File = Integer.parseInt(request.split(",")[0]);
					playerTurn = playerSeqMap.get(playerIndex_File)-1;
					action = request.split(",")[1];
					Log.info(" ");
					Log.info("Executed Action : " + action + " For Player : "+ (playerID+playerTurn+1));
					executeAction[playerTurn].doAction(action);
					if (actionCounter == (actionSequence.size()-1)){
						Log.info("#####ALL TASKS FINISHED#####");
						executor.shutdown();
						shutDown();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		executor = Executors.newScheduledThreadPool(30);
		executor.scheduleAtFixedRate(playMoves, 0, 3, TimeUnit.SECONDS);
	}
	
	protected static void checkResponse(String responseType, int playerIndex_Listener) {
		
		// check if the game state is such that this response is expected to arrive
		Log.info("Message Received by All :" + (playerIndex_Listener+1) + " : "+(playerID+playerIndex_Listener+1)+" : " + responseType);
		
		switch(responseType){
		
		case "matchinfo":
			if(aastatus[playerIndex_Listener].status==6)
				Log.info(responseType+" FOR PLAYER "+playerIndex_Listener+ " Pass");
			else
				Log.info(responseType+" FOR PLAYER "+playerIndex_Listener+ " Pass");
			break;
		
		case "tosscard":
			if(gmstatus[playerIndex_Listener].status==0)
				Log.info(responseType+" FOR PLAYER "+playerIndex_Listener+ " Pass");
			else
				Log.info(responseType+" FOR PLAYER "+playerIndex_Listener+ " Pass");
			break;
		
		case "tosswinner":
			if(gmstatus[playerIndex_Listener].status==0)
				Log.info(responseType+" FOR PLAYER "+playerIndex_Listener+ " Pass");
			else
				Log.info(responseType+" FOR PLAYER "+playerIndex_Listener+ " Pass");
			break;
		}
		
		Log.info("--------------------------------------------------------------------------------------------------------------------");
	}

	private static void checkResponse(String action, String responseType, int playerIndex_Listener) {
		
		if (playerIndex_Listener == playerTurn) {
			if (playerTurnMap.get(action).contains(responseType))
				Log.info(action + " For Player Turn: " + (playerIndex_Listener+1) +" : "+(playerID + playerIndex_Listener+1) + " Pass");
			else
				Log.info(action + " For Player Turn: " + (playerIndex_Listener+1) +" : "+(playerID + playerIndex_Listener+1) + " Fail");
		} else {
			if (opponentMap.get(action).contains(responseType))
				Log.info(action + " For Opponent : " + (playerIndex_Listener+1) +" : "+(playerID + playerIndex_Listener+1) + " Pass");
			else
				Log.info(action + " For Opponent : " + (playerIndex_Listener+1) +" : "+(playerID + playerIndex_Listener+1) + " Fail");
		}
		Log.info("--------------------------------------------------------------------------------------------------------------------");
	}

	private static void shutDown() throws Exception {
		
		Log.info("#####SHUTTING DOWN#####");
		Thread.sleep(3000);
		for (int playerCounter = 0; playerCounter < noOfPlayers; playerCounter++) {
			Log.info("Closing connection for Player :" + (playerID+playerCounter+1));
			executeAction[playerCounter].executor.shutdown();
			client[playerCounter].close();
		}
		printResponseList();
		printResponseMap();
	}
	

	private static void printResponseMap() {
		
		for(Map.Entry<Integer, Map<String, List<String>>> loop1:responseMap.entrySet()){
			int playerIndex = loop1.getKey();
			Map<String,List<String>> tempMap = loop1.getValue();
			for(Map.Entry<String, List<String>> loop2:tempMap.entrySet()){
				List<String> tempList = loop2.getValue();
				for(String resp:tempList)
					Log.info(playerIndex+" : "+loop2.getKey()+" : "+resp);
			}
		}
		
	}

	private static void printResponseList() {

		for(Map.Entry<String, Integer> message:getResponseCount.entrySet())
			Log.info(message.getKey()+" = "+message.getValue());
	}
}