package com.rummycircle.wsclient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;

import com.games24x7.service.cs.messages.FMGRequest;
import com.games24x7.service.cs.messages.HeartBeat;
import com.games24x7.service.message.Frame;
import com.games24x7.service.message.Message;
import com.games24x7.service.te.messages.Discard;
import com.games24x7.service.te.messages.DiscardRes;
import com.games24x7.service.te.messages.LeaveTable;
import com.games24x7.service.te.messages.Pickc;
import com.games24x7.service.te.messages.PickcRes;
import com.games24x7.service.te.messages.Ready;
import com.games24x7.service.te.messages.Setup;

public class Action {

	public long receiverID, playerID, mplayerID, aaid, matchId, gameId;
	private long mpid,excludeTableId,oldTableId;
	private int prizeType, formatType, noOfPlayer, includeInProgress, id = 0,
			clientvariant, playerIndex;
	private double prizePerPoint, entryFee;
	private boolean fmgOnTable, emptyTable, interimTableSettlement;
	private String message, sessionId, destination, EOM = "\r", ipAddress, env;
	public String cardId;
	Frame frame;
	ClientClass client;
	ClientUpgradeRequest upgrade;
	public ScheduledExecutorService executor;
	private static Logger Log = Logger.getLogger(Action.class.getName());
	
	public Action(String env, ClientClass client, String url, ClientUpgradeRequest upgrade,
			int playerIndex, String sessionId) throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		this.env=env;
		this.playerIndex = playerIndex;
		loadConfig(sessionId);
		this.client = client;
		this.upgrade = upgrade;
		client.start(url, upgrade);
	}

	public void doAction(String action) throws Exception {
		switch (action) {
		case "fmg":
			FMG();
			break;
		case "setup":
			setUp();
			break;
		case "ready":
			ready();
			break;
		case "heartbeat":
			heartBeatTask();
			break;
		case "leave":
			leaveTable();
			break;
		case "pickdeck":
			pickDeck();
			break;
		case "discard":
			discard();
			break;
		default:
		}
	}

	public String serializeMessage(Message message) throws Exception {
		frame = WSMessageFactory.getFactory().serialize(message);
		String jsonToString = WebSocketMessageFactory.convertFrameToJson(
				frame,
				WSMessageFactory.getFactory().getMessageType(
						frame.getMessageClassID()), receiverID, playerID)
				.toString()
				+ EOM;
		return jsonToString;
	}

	public void loadConfig(String session) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		String fileName = "file_"+env+".properties";
		String envFileLoc = System.getProperty("user.dir")
				+ "/conf/"+fileName;
		prop.load(new FileInputStream(envFileLoc));
		receiverID = Long.parseLong(prop.getProperty("receiverID"));
		playerID = Long.parseLong(prop.getProperty("playerID")) + (playerIndex+1);
		mpid = Long.parseLong(prop.getProperty("mpid"));
		excludeTableId = Long.parseLong(prop.getProperty("excludeTableId"));
		prizeType = Integer.parseInt(prop.getProperty("prizeType"));
		formatType = Integer.parseInt(prop.getProperty("formatType"));
		noOfPlayer = Integer.parseInt(prop.getProperty("noOfPlayer"));
		prizePerPoint = Double.parseDouble(prop.getProperty("prizePerPoint"));
		entryFee = Double.parseDouble(prop.getProperty("entryFee"));
		includeInProgress = Integer.parseInt(prop
				.getProperty("includeInProgress"));
		ipAddress = prop.getProperty("ipAddress");
		oldTableId = Long.parseLong(prop.getProperty("oldTableId"));
		fmgOnTable = Boolean.parseBoolean(prop.getProperty("fmgOnTable"));
		emptyTable = Boolean.parseBoolean(prop.getProperty("emptyTable"));
		interimTableSettlement = Boolean.parseBoolean(prop
				.getProperty("interimTableSettlement"));
		clientvariant = Integer.parseInt(prop.getProperty("clientvariant"));
		sessionId = session;
		destination = prop.getProperty("destination");
	}

	public void FMG() throws Exception {
		FMGRequest fmg = new FMGRequest(receiverID, playerID, mpid,
				excludeTableId, prizeType, formatType, noOfPlayer,
				prizePerPoint, entryFee, includeInProgress, ipAddress,
				oldTableId, fmgOnTable, emptyTable, interimTableSettlement);
		fmg.setDest(destination);
		fmg.setSessionId(sessionId);
		fmg.setSource(String.valueOf(playerID));
		message = serializeMessage(fmg);
		client.sendMessage(message);
	}

	public void setUp() throws Exception {
		Setup setup = new Setup(receiverID, playerID, "", clientvariant);
		setup.setSessionId(sessionId);
		setup.setDest(destination);
		message = serializeMessage(setup);
		client.sendMessage(message);
	}

	public void ready() throws Exception {
		Ready ready = new Ready(receiverID, playerID, "");
		ready.setSessionId(sessionId);
		ready.setDest(destination);
		message = serializeMessage(ready);
		matchId = ready.getMatchid();
		gameId = ready.getGameid();
		client.sendMessage(message);
	}

	public void pickDeck() throws Exception{
		Pickc pickc = new Pickc(receiverID, playerID, mplayerID, matchId);
		message = serializeMessage(pickc);
		client.sendMessage(message);
	}
	
	public void discard() throws Exception{
		Discard discard = new Discard(receiverID, playerID, cardId, mplayerID, matchId);
		message = serializeMessage(discard);
		Log.info("######CARD ID Actually DISCARDED : "+cardId);
		client.sendMessage(message);
	}
	
	public void heartBeat() throws Exception {
		HeartBeat heartbeat = new HeartBeat(receiverID, playerID, id++);
		heartbeat.setSessionId(sessionId);
		heartbeat.setDest(destination);
		message = serializeMessage(heartbeat);
		client.sendMessage(message);
	}

	public void leaveTable() throws Exception {
		LeaveTable leaveTable = new LeaveTable(receiverID, playerID, mplayerID, matchId, gameId);
		leaveTable.setSessionId(sessionId);
		leaveTable.setDest(destination);
		message = serializeMessage(leaveTable);
		client.sendMessage(message);
	}

	public void heartBeatTask() {
		Runnable runHeartBeat = new Runnable() {
			public void run() {
				try {
					heartBeat();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		executor = Executors.newScheduledThreadPool(10);
		executor.scheduleAtFixedRate(runHeartBeat, 0, 1, TimeUnit.SECONDS);
	}
}