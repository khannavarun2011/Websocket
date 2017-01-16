package com.rummycircle.wsclient;

import java.util.List;
import java.util.Timer;

public class PlayerInfo {
	long playerId;
	long mPlayerId;
	long matchId;
	long gameId;
//	PlayerObj plObj = null;
	private List<List<String>> cards = null;
	String jkrCard = null;
	String openCard = null;
	int score = -1;
	int channelId;
	int seatId;
	boolean isSeated = false;
	int settlementType;
//	long tableId;
	Timer timer = null;
	int playerMoveCount = 0;
	long receiverId;
	String sessionKey;
	String gameType;
	private long tournamentId;


	public PlayerInfo(long playerId, int channelId, String sessionKey) {
		this.playerId = playerId;
		this.channelId = channelId;
		this.sessionKey = sessionKey;
	}
	
	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}


	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public long getMPlayerId() {
		return mPlayerId;
	}

	public void setMPlayerId(long mPlayerId) {
		this.mPlayerId = mPlayerId;
	}

	public List<List<String>> getCards() {
		return cards;
	}

	public void setCards(List<List<String>> cards) {
		this.cards = cards;
	}

	public String getJkrCard() {
		return jkrCard;
	}

	public void setJkrCard(String jkrCard) {
		this.jkrCard = jkrCard;
	}

	public long getMatchId() {
		return matchId;
	}

	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}

	public String getOpenCard() {
		return openCard;
	}

	public void setOpenCard(String openCard) {
		this.openCard = openCard;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannel(int channelId) {
		this.channelId = channelId;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public boolean isSeated() {
		return isSeated;
	}

	public void setSeated(boolean isSeated) {
		this.isSeated = isSeated;
	}

	public int getSettlementType() {
		return settlementType;
	}

	public void setSettlementType(int settlementType) {
		this.settlementType = settlementType;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer setTimer) {
		System.out
				.println("SETTING TIMER VALUE TO=============================================== "
						+ setTimer);
		this.timer = setTimer;
	}

	public int getPlayerMoveCount() {
		return playerMoveCount;
	}

	public void setPlayerMoveCount(int playerMoveCount) {
		this.playerMoveCount = playerMoveCount;
	}

	public long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(long receiverId) {
		this.receiverId = receiverId;
	}

	public long getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(long tournamentId) {
		this.tournamentId = tournamentId;
	}

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

}
