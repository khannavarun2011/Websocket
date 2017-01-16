package com.rummycircle.wsclient;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class GlobalData  {

	private static final GlobalData instance = new GlobalData();
	
	protected GlobalData() {
		// This is used to stop instantiating from outside
	}

	public static GlobalData getInstance() {		
		return GlobalData.instance;
	}

	public Queue<String> mesgQueue = new ConcurrentLinkedQueue<String>();
	public List<String> mesgList = new ArrayList<String>();
	public long receiverID;
	public boolean ready=false;
}