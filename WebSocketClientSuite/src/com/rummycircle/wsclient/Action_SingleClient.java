package com.rummycircle.wsclient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import com.games24x7.service.te.messages.LeaveTable;
import com.games24x7.service.te.messages.Ready;
import com.games24x7.service.te.messages.Setup;

public class Action_SingleClient {

	public long receiverID;
	long playerID;
	long mpid;
	long excludeTableId;
	long oldTableId;
	long gameId;
	long matchId;
	long player;
	public long winner;
	String ipAddress, env;
	int prizeType, formatType, noOfPlayer, includeInProgress, id = 0,
			clientvariant;
	double prizePerPoint, entryFee;
	boolean fmgOnTable, emptyTable, interimTableSettlement, flag = false,
			leaveTable = false;
	String EOM = "\r";
	String url, message, sessionId, destination, respMesg = "";
	Frame fr;
	ClientClass client;
	ClientUpgradeRequest upgrade;
	public List<String> mesgList = new ArrayList<String>();
	private static Logger Log = Logger.getLogger(Action_SingleClient.class.getName());
	Map<String, String> map;
	String sentType = "";
	public ScheduledExecutorService executor;
	
	public Action_SingleClient(ClientClass client, String url, ClientUpgradeRequest upgrade) throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		this.url = url;
		loadConfig();
		this.client = client;
		this.upgrade = upgrade;
		client.start(url, upgrade);
	}

	public void doAction(String action, long receiverID, long playerID, String sessionId) throws Exception {
		switch (action) {
		case "fmg":
			FMG(receiverID,playerID,sessionId);
			break;
		case "setup":
			setUp(receiverID,playerID,sessionId);
			break;
		case "ready":
			ready(receiverID,playerID,sessionId);
			break;
		case "heartbeat":
			heartBeatTask(receiverID,playerID,sessionId);
			break;
		case "leave":
			leaveTable();
			break;
		default:
		}
	}

	public String serializeMessage(Message message) throws Exception {
		fr = WSMessageFactory.getFactory().serialize(message);
		String jsonToString = WebSocketMessageFactory.convertFrameToJson(
				fr,
				WSMessageFactory.getFactory().getMessageType(
						fr.getMessageClassID()), receiverID, playerID)
				.toString()
				+ EOM;
		return jsonToString;
	}

	public void loadConfig() throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		String file = System.getProperty("user.dir")
				+ "/conf/file_stage.properties";
		prop.load(new FileInputStream(file));
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
		destination = prop.getProperty("destination");
	}

	public void FMG(long receiverID, long playerID, String sessionId) throws Exception {
		FMGRequest fmg = new FMGRequest(receiverID, playerID, mpid,
				excludeTableId, prizeType, formatType, noOfPlayer,
				prizePerPoint, entryFee, includeInProgress, ipAddress,
				oldTableId, fmgOnTable, emptyTable, interimTableSettlement);
		this.playerID=playerID;
		fmg.setDest(destination);
		fmg.setSessionId(sessionId);
		fmg.setSource(String.valueOf(playerID));
		message = serializeMessage(fmg);
		client.sendMessage(message);
	}

	public void setUp(long receiverID, long playerID, String sessionId) throws Exception {
		this.receiverID=receiverID;
		Setup setup = new Setup(receiverID, playerID, "", clientvariant);
		setup.setSessionId(sessionId);
		setup.setDest(destination);
		message = serializeMessage(setup);
		client.sendMessage(message);

	}

	public void ready(long receiverID, long playerID, String sessionId) throws Exception {
		Ready ready = new Ready(receiverID, playerID, "");
		ready.setSessionId(sessionId);
		ready.setDest(destination);
		message = serializeMessage(ready);
		matchId = ready.getMatchid();
		gameId = ready.getGameid();
		client.sendMessage(message);
	}

	public void heartBeat(long receiverID,long playerID, String sessionId) throws Exception {
		HeartBeat heartbeat = new HeartBeat(receiverID, playerID, id++);
		heartbeat.setSessionId(sessionId);
		heartbeat.setDest(destination);
		message = serializeMessage(heartbeat);
		Log.info("Executing HeartBeat for "+playerID);
		client.sendMessage(message);

	}

	public void leaveTable() throws Exception {
		LeaveTable lt = new LeaveTable(receiverID, playerID, playerID, matchId,
				gameId);
		lt.setSessionId(sessionId);
		lt.setDest(destination);
		message = serializeMessage(lt);
		client.sendMessage(message);

	}

	public void heartBeatTask(long receiverID, long playerID, String sessionId) {
		Runnable runTask = new Runnable() {
			public void run() {
				try {
					heartBeat(receiverID,playerID,sessionId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		executor = Executors.newScheduledThreadPool(6);
		executor.scheduleAtFixedRate(runTask, 0, 3, TimeUnit.SECONDS);
	}
}