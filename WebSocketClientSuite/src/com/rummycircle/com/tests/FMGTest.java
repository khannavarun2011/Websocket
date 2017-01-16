/*package com.rummycircle.com.tests;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rummycircle.wsclient.Action;
import com.rummycircle.wsclient.ClientClass;
import com.rummycircle.wsclient.Listener;
import com.rummycircle.wsclient.MessageHandler;

@Listeners(Listener.class)
public class FMGTest {

	private static Action executeAction;
	private static ClientClass client;
	private static ClientUpgradeRequest upgradeRequest;
	private static Logger Log = Logger.getLogger(FMGTest.class.getName());
	private static Map<String,String> map;
	private static Map<Integer,String> action;
	private int counter;
	@BeforeClass
	@Parameters({ "url" })
	public void createConnection(String url) throws Exception {
		map = new ConcurrentHashMap<String,String>();
		map.put("fmgrequest","fmgresponse");
		map.put("setup","setupres");
		map.put("ready","hud");
		map.put("heartbeat", "heartbeatres");
		map.put("leave", "seatsetup");
		PropertyConfigurator.configure("log4j.properties");
		client = new ClientClass();
		upgradeRequest =  new ClientUpgradeRequest();
		executeAction = new Action(client, url, upgradeRequest);
		startListener();
	}

	public void startListener() {
		client.addMessageHandler(new MessageHandler() {
			public void handleMessage(String response) {
				Log.info("Response Received....." + response);
				try {
					processMessage(response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void processMessage(String response) throws Exception {
		String responseType = new JSONObject(response).getString("type");
		Assert.assertEquals(map.get(""), responseType);
	}
	
	@Parameters({ "receiverID", "playerID", "mpid", "excludeTableId",
			"prizeType", "formatType", "noOfPlayer", "prizePerPoint",
			"entryFee", "includeInProgress", "ipAddress", "oldTableId",
			"fmgOnTable", "emptyTable", "interimTableSettlement", "sessionId",
			"destination" })
	public void fmgTest(String receiverID, String playerID, String mpid,
			String excludeTableId, String prizeType, String formatType,
			String noOfPlayer, String prizePerPoint, String entryFee,
			String includeInProgress, String ipAddress, String oldTableId,
			String fmgOnTable, String emptyTable,
			String interimTableSettlement, String sessionId, String destination)
			throws Exception {

		executeAction.FMG(Long.parseLong(receiverID),
				Long.parseLong(playerID), Long.parseLong(mpid),
				Long.parseLong(excludeTableId), Integer.parseInt(prizeType),
				Integer.parseInt(formatType), Integer.parseInt(noOfPlayer),
				Double.parseDouble(prizePerPoint),
				Double.parseDouble(entryFee),
				Integer.parseInt(includeInProgress), ipAddress,
				Long.parseLong(oldTableId), Boolean.parseBoolean(fmgOnTable),
				Boolean.parseBoolean(emptyTable),
				Boolean.parseBoolean(interimTableSettlement), sessionId,
				destination);
	}
	
	@Parameters("clientvariant")
	public void setUpTest(String clientvariant) throws NumberFormatException,
			Exception {
		executeAction.setup(Integer.parseInt(clientvariant));
	}
	
	public void readyTest() throws Exception {
		executeAction.ready();
	}	

	public void heartBeatTest() throws Exception {
		executeAction.heartBeat();
	}	
	
	public void leaveTableTest() throws Exception {
		executeAction.leaveTable();
	}

	@AfterClass
	public void closeConnection() throws Exception {
		executeAction.closeConnection();
	}
}
*/