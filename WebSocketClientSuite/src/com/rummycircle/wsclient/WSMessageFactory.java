package com.rummycircle.wsclient;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.games24x7.service.cs.messages.FMGRequest;
import com.games24x7.service.cs.messages.FMGResponse;
import com.games24x7.service.cs.messages.HandShake;
import com.games24x7.service.cs.messages.HandShakeResponse;
import com.games24x7.service.cs.messages.HeartBeat;
import com.games24x7.service.cs.messages.HeartBeatResponse;
import com.games24x7.service.cs.messages.MttTableMap;
import com.games24x7.service.cs.messages.MttTableMapResp;
import com.games24x7.service.message.Frame;
import com.games24x7.service.message.Message;
import com.games24x7.service.message.serializer.AbstractSerializer;
import com.games24x7.service.message.serializer.io.taggedtext.MessageInputStream;
import com.games24x7.service.message.serializer.io.taggedtext.MessageOutputStream;
import com.games24x7.service.message.serializer.io.taggedtext.json.JSONMessageInputStream;
import com.games24x7.service.message.serializer.io.taggedtext.json.JSONMessageOutputStream;
import com.games24x7.service.te.messages.*;
/**
 * Auto Generated Message Serializer Class. THIS FILE SHOULD NOT BE EDITED
 * MANUALLY.
 */
public class WSMessageFactory extends AbstractSerializer implements BotMessageConstants {

	private static Logger logger = LoggerFactory
			.getLogger(WSMessageFactory.class);
	private static WSMessageFactory factory;
	private static Map<String, Integer> messageTypeClassIdMap = new HashMap<>();
	private static Map<Integer, String> classIdMessageTypeMap = new HashMap<>();

	public static WSMessageFactory getFactory() {
		if (factory == null) {
			synchronized (WSMessageFactory.class) {
				if (factory == null) {
					factory = new WSMessageFactory();
				}
			}
		}
		return factory;
	}

	private static Properties properties;

	private WSMessageFactory() {
		initMaps();
	}

	private WSMessageFactory(String propertyFileName) {
/*		super();
		properties = new Properties();
		try {
			properties.load(RummyBotMessageFactory.class.getClassLoader()
					.getResourceAsStream(propertyFileName));
		} catch (IOException e) {
			logger.error("Exception is loading the property file {}",
					propertyFileName);
		}*/
		initMaps();
	}

	private void initMaps() {
		messageTypeClassIdMap = BotMessageConstants.getMessageTypeClassIdMap();
		classIdMessageTypeMap = BotMessageConstants.getClassIdMessageTypeMap();
	}

	@Override
	protected void _initClassIDS() {
		idVsClassMapping.put(1048577, AcceptSplit.class);
		idVsClassMapping.put(1048578, AutoDrop.class);
		idVsClassMapping.put(1048579, AutoDropCancel.class);
		idVsClassMapping.put(1048580, AutoPlayRes.class);
		idVsClassMapping.put(1048581, BONBonusUpdateReq.class);
		idVsClassMapping.put(1048582, BuyIn.class);
		idVsClassMapping.put(1048583, Chat.class);
		idVsClassMapping.put(1048584, DealsLeft.class);
		idVsClassMapping.put(1048585, DealsLeftRes.class);
		idVsClassMapping.put(1048586, Declare.class);
		idVsClassMapping.put(1048587, Discard.class);
		idVsClassMapping.put(1048588, Discardcs.class);
		idVsClassMapping.put(1048589, DisconProtectionPrefUpdate.class);
		idVsClassMapping.put(1048590, Drop.class);
		idVsClassMapping.put(1048591, Finish.class);
		idVsClassMapping.put(1048592, FirstCashGameAck.class);
		idVsClassMapping.put(1048593, FMGSearch.class);
		idVsClassMapping.put(1048594, HandProgressBarState.class);
		idVsClassMapping.put(1048596, InitiateSplit.class);
		idVsClassMapping.put(1048597, LastDealReq.class);
		idVsClassMapping.put(1048598, LeaveTable.class);
		idVsClassMapping.put(1048599, NewRoundConnection.class);
		idVsClassMapping.put(1048600, Pickc.class);
		idVsClassMapping.put(1048601, Picko.class);
		idVsClassMapping.put(1048602, Rap.class);
		idVsClassMapping.put(1048603, Ready.class);
		idVsClassMapping.put(1048604, RebuyIn.class);
		idVsClassMapping.put(1048605, Recon.class);
		idVsClassMapping.put(1048606, RejectSplit.class);
		idVsClassMapping.put(1048607, RejoinStatus.class);
		idVsClassMapping.put(1048608, UpdateTheme.class);
		idVsClassMapping.put(1048609, ScoreCard.class);
		idVsClassMapping.put(1048610, SetCards.class);
		idVsClassMapping.put(1048611, Setup.class);
		idVsClassMapping.put(1048612, TakeSeat.class);
		idVsClassMapping.put(1048613, ThemeReq.class);
		idVsClassMapping.put(1048614, Withdraw.class);
		idVsClassMapping.put(1048615, WithdrawRebuy.class);
		idVsClassMapping.put(1048616, MoveTimeout.class);
		idVsClassMapping.put(1048617, OpnCard.class);
		idVsClassMapping.put(1048618, OppDeclare.class);
		idVsClassMapping.put(1048619, OppDiscard.class);
		idVsClassMapping.put(1048620, OppDrop.class);
		idVsClassMapping.put(1048621, OppFinish.class);
		idVsClassMapping.put(1048622, OppPickC.class);
		idVsClassMapping.put(1048623, OppPickO.class);
		idVsClassMapping.put(1048624, PFinishResp.class);
		idVsClassMapping.put(1048625, PickcRes.class);
		idVsClassMapping.put(1048626, PickORes.class);
		idVsClassMapping.put(1048627, PlayerEliminated.class);
		idVsClassMapping.put(1048628, PlayerScores.class);
		idVsClassMapping.put(1048629, ScoreList.class);
		idVsClassMapping.put(1048630, PlayerSeq.class);
		idVsClassMapping.put(1048631, PlayerUpdate.class);
		idVsClassMapping.put(1048632, Seats.class);
		idVsClassMapping.put(1048633, Player.class);
		idVsClassMapping.put(1048634, PlrDisconnect.class);
		idVsClassMapping.put(1048635, PlrHandCard.class);
		idVsClassMapping.put(1048636, PlrMove.class);
		idVsClassMapping.put(1048637, PrepareForNextRound.class);
		idVsClassMapping.put(1048638, PrizePool.class);
		idVsClassMapping.put(1048639, RebuyWindowBal.class);
		idVsClassMapping.put(1048640, RejectSplitSuccess.class);
		idVsClassMapping.put(1048641, RejoinFail.class);
		idVsClassMapping.put(1048642, RejoiningPlayerEliminated.class);
		idVsClassMapping.put(1048643, RejoinSuccess.class);
		idVsClassMapping.put(1048644, ResetConnection.class);
		idVsClassMapping.put(1048645, Reshuffle.class);
		idVsClassMapping.put(1048646, ScoreCardResp.class);
		idVsClassMapping.put(1048647, ScoreListResp.class);
		idVsClassMapping.put(1048648, ScoreWindow.class);
		idVsClassMapping.put(1048649, ScoreWindowValue.class);
		idVsClassMapping.put(1048650, ScoreWindowChange.class);
		idVsClassMapping.put(1048651, SeatSetup.class);
		idVsClassMapping.put(1048652, ServerDiscard.class);
		idVsClassMapping.put(1048653, SetupRes.class);
		idVsClassMapping.put(1048654, ShowRejoin.class);
		idVsClassMapping.put(1048655, SplitDetails.class);
		idVsClassMapping.put(1048656, PlayerList.class);
		idVsClassMapping.put(1048657, SplitStatus.class);
		idVsClassMapping.put(1048658, SplitStatusPlayerList.class);
		idVsClassMapping.put(1048659, StartDeclare.class);
		idVsClassMapping.put(1048660, StartGameTimer.class);
		idVsClassMapping.put(1048661, TakeSeatBal.class);
		idVsClassMapping.put(1048662, ThemeChange.class);
		idVsClassMapping.put(1048663, Theme.class);
		idVsClassMapping.put(1048664, ThemeRes.class);
		idVsClassMapping.put(1048665, TieBreaker.class);
		idVsClassMapping.put(1048666, TossCard.class);
		idVsClassMapping.put(1048667, TossCardObj.class);
		idVsClassMapping.put(1048668, TossWinner.class);
		idVsClassMapping.put(1048669, TournamentComplete.class);
		idVsClassMapping.put(1048670, TournamentInfo.class);
		idVsClassMapping.put(1048671, TournamentInfoObj.class);
		idVsClassMapping.put(1048672, CurrentRoundObj.class);
		idVsClassMapping.put(1048673, Rank.class);
		idVsClassMapping.put(1048674, Round.class);
		idVsClassMapping.put(1048676, ValCardsInfo.class);
		idVsClassMapping.put(1048677, ValCardTxns.class);
		idVsClassMapping.put(1048678, WinnerMsg.class);
		idVsClassMapping.put(1048679, WrongFinishPlayer.class);
		idVsClassMapping.put(1048680, AAInfo.class);
		idVsClassMapping.put(1048681, GProperty.class);
		idVsClassMapping.put(1048682, TProperty.class);
		idVsClassMapping.put(1048683, AAStatus.class);
		idVsClassMapping.put(1048684, AcceptSplitSuccess.class);
		idVsClassMapping.put(1048685, Ack.class);
		idVsClassMapping.put(1048686, AmountWon.class);
		idVsClassMapping.put(1048687, AmountWonObj.class);
		idVsClassMapping.put(1048688, AutoDropCancelSuccess.class);
		idVsClassMapping.put(1048689, AutoDropStatus.class);
		idVsClassMapping.put(1048690, AutoDropSuccess.class);
		idVsClassMapping.put(1048691, AutoPlayReq.class);
		idVsClassMapping.put(1048692, AutoPlayRespAck.class);
		idVsClassMapping.put(1048693, BalUpdate.class);
		idVsClassMapping.put(1048694, BalUpdateObj.class);
		idVsClassMapping.put(1048695, BONTournamentInfo.class);
		idVsClassMapping.put(1048696, RankObj.class);
		idVsClassMapping.put(1048697, BuyInSucc.class);
		idVsClassMapping.put(1048698, CloseAllConnections.class);
		idVsClassMapping.put(1048699, CloseConnection.class);
		idVsClassMapping.put(1048700, ClosedDeckSize.class);
		idVsClassMapping.put(1048702, Dealer.class);
		idVsClassMapping.put(1048704, DeclareConf.class);
		idVsClassMapping.put(1048705, DeclareResp.class);
		idVsClassMapping.put(1048706, DiscardRes.class);
		idVsClassMapping.put(1048707, DiscardS.class);
		idVsClassMapping.put(1048708, DisconProtectionPrefUpdateRes.class);
		idVsClassMapping.put(1048709, DropPlayer.class);
		idVsClassMapping.put(1048710, DropRes.class);
		idVsClassMapping.put(1048711, EnableSplit.class);
		idVsClassMapping.put(1048712, ErrorMsg.class);
		idVsClassMapping.put(1048713, ErrorPickO.class);
		idVsClassMapping.put(1048714, FinishStage.class);
		idVsClassMapping.put(1048715, GmSetup.class);
		idVsClassMapping.put(1048716, GmStatus.class);
		idVsClassMapping.put(1048717, GraceMove.class);
		idVsClassMapping.put(1048719, Hud.class);
		idVsClassMapping.put(1048720, BonusValueObj.class);
		idVsClassMapping.put(1048721, MdropPlayer.class);
		idVsClassMapping.put(1048722, LPInfo.class);
		idVsClassMapping.put(1048723, ClubInfoArrayObj.class);
		idVsClassMapping.put(1048724, LastDealErr.class);
		idVsClassMapping.put(1048725, JkrCard.class);
		idVsClassMapping.put(1048726, MatchInfo.class);
		idVsClassMapping.put(1048727, MatchSeatArrayObj.class);
		idVsClassMapping.put(1048728, PlayerObj.class);
		idVsClassMapping.put(1048729, InvalidFinish21Card.class);
		idVsClassMapping.put(1048730, GrpsInfoObj.class);
		idVsClassMapping.put(1048731, FmgError.class);
		idVsClassMapping.put(1048732, DisplayMsg.class);
		idVsClassMapping.put(1048733, DisconProtectionPref.class);
		idVsClassMapping.put(1048734, DisableSplit.class);
		idVsClassMapping.put(1048735, ChatRes.class);
		idVsClassMapping.put(1048736, BonusIndicator.class);
		idVsClassMapping.put(1048737, PendingBonusObj.class);
		idVsClassMapping.put(1048738, TakeSeatFail.class);
		idVsClassMapping.put(1048739, Bonuses.class);
		idVsClassMapping.put(1048740, RmValue.class);
		idVsClassMapping.put(1048741, AutoRebuyInSuccess.class);
		idVsClassMapping.put(1048742, BuyInFail.class);
		idVsClassMapping.put(1048743, ValCardStr.class);
		idVsClassMapping.put(1048744, PlayerTxn.class);
		idVsClassMapping.put(1048745, BonTournamentComplete.class);
		idVsClassMapping.put(1048746, MECrash.class);
		idVsClassMapping.put(1048747, BreakStructureObj.class);
		idVsClassMapping.put(1048748, MatchCreated.class);
		idVsClassMapping.put(1048749, PoolTournamentComplete.class);
		idVsClassMapping.put(1048750, TECrash.class);
		idVsClassMapping.put(1048751, MatchSetup.class);
		idVsClassMapping.put(1048752, AutoRebuyinPref.class);
		idVsClassMapping.put(1048753, ScoresObj.class);
		idVsClassMapping.put(1048754, RematchRequest.class);
		idVsClassMapping.put(1048755, RematchResponse.class);
		idVsClassMapping.put(1048756, ScoreWindow21Card.class);
		idVsClassMapping.put(1048757, AutoRebuyinReq.class);
		idVsClassMapping.put(1048758, SaveTheme.class);
		idVsClassMapping.put(1048759, MTTScoreCardResp.class);
		idVsClassMapping.put(1048760, MTTScoreListResp.class);
		idVsClassMapping.put(1048761, ChangeTableId.class);

		idVsClassMapping.put(2097153, HeartBeat.class);
		idVsClassMapping.put(2097154, HeartBeatResponse.class);
		idVsClassMapping.put(2097155, HandShake.class);
		idVsClassMapping.put(2097156, HandShakeResponse.class);
		idVsClassMapping.put(2097157, MttTableMap.class);
		idVsClassMapping.put(2097158, MttTableMapResp.class);
		idVsClassMapping.put(2097161, FMGRequest.class);
		idVsClassMapping.put(2097162, FMGResponse.class);
	}

	@Override
	public byte[] serialize(MessageOutputStream mos, Message message)
			throws IOException {
		String text = null;
		switch (message.getClassID()) {
		case ACCEPTSPLIT:
			text = serialize(mos, (AcceptSplit) message);
			break;
		case AUTODROP:
			text = serialize(mos, (AutoDrop) message);
			break;
		case AUTODROPCANCEL:
			text = serialize(mos, (AutoDropCancel) message);
			break;
		case AUTOPLAYRES:
			text = serialize(mos, (AutoPlayRes) message);
			break;
		case BONBONUSUPDATEREQ:
			text = serialize(mos, (BONBonusUpdateReq) message);
			break;
		case BUYIN:
			text = serialize(mos, (BuyIn) message);
			break;
		case CHAT:
			text = serialize(mos, (Chat) message);
			break;
		case DEALSLEFT:
			text = serialize(mos, (DealsLeft) message);
			break;
		case DEALSLEFTRES:
			text = serialize(mos, (DealsLeftRes) message);
			break;
		case DECLARE:
			text = serialize(mos, (Declare) message);
			break;
		case DISCARD:
			text = serialize(mos, (Discard) message);
			break;
		case DISCARDCS:
			text = serialize(mos, (Discardcs) message);
			break;
		case DISCONPROTECTIONPREFUPDATE:
			text = serialize(mos, (DisconProtectionPrefUpdate) message);
			break;
		case DROP:
			text = serialize(mos, (Drop) message);
			break;
		case FINISH:
			text = serialize(mos, (Finish) message);
			break;
		case FIRSTCASHGAMEACK:
			text = serialize(mos, (FirstCashGameAck) message);
			break;
		case FMGSEARCH:
			text = serialize(mos, (FMGSearch) message);
			break;
		case HANDPROGRESSBARSTATE:
			text = serialize(mos, (HandProgressBarState) message);
			break;
		case INITIATESPLIT:
			text = serialize(mos, (InitiateSplit) message);
			break;
		case LASTDEALREQ:
			text = serialize(mos, (LastDealReq) message);
			break;
		case LEAVETABLE:
			text = serialize(mos, (LeaveTable) message);
			break;
		case NEWROUNDCONNECTION:
			text = serialize(mos, (NewRoundConnection) message);
			break;
		case PICKC:
			text = serialize(mos, (Pickc) message);
			break;
		case PICKO:
			text = serialize(mos, (Picko) message);
			break;
		case RAP:
			text = serialize(mos, (Rap) message);
			break;
		case READY:
			text = serialize(mos, (Ready) message);
			break;
		case REBUYIN:
			text = serialize(mos, (RebuyIn) message);
			break;
		case RECON:
			text = serialize(mos, (Recon) message);
			break;
		case REJECTSPLIT:
			text = serialize(mos, (RejectSplit) message);
			break;
		case REJOINSTATUS:
			text = serialize(mos, (RejoinStatus) message);
			break;
		case UPDATETHEME:
			text = serialize(mos, (UpdateTheme) message);
			break;
		case SCORECARD:
			text = serialize(mos, (ScoreCard) message);
			break;
		case SETCARDS:
			text = serialize(mos, (SetCards) message);
			break;
		case SETUP:
			text = serialize(mos, (Setup) message);
			break;
		case TAKESEAT:
			text = serialize(mos, (TakeSeat) message);
			break;
		case THEMEREQ:
			text = serialize(mos, (ThemeReq) message);
			break;
		case WITHDRAW:
			text = serialize(mos, (Withdraw) message);
			break;
		case WITHDRAWREBUY:
			text = serialize(mos, (WithdrawRebuy) message);
			break;
		case MOVETIMEOUT:
			text = serialize(mos, (MoveTimeout) message);
			break;
		case OPNCARD:
			text = serialize(mos, (OpnCard) message);
			break;
		case OPPDECLARE:
			text = serialize(mos, (OppDeclare) message);
			break;
		case OPPDISCARD:
			text = serialize(mos, (OppDiscard) message);
			break;
		case OPPDROP:
			text = serialize(mos, (OppDrop) message);
			break;
		case OPPFINISH:
			text = serialize(mos, (OppFinish) message);
			break;
		case OPPPICKC:
			text = serialize(mos, (OppPickC) message);
			break;
		case OPPPICKO:
			text = serialize(mos, (OppPickO) message);
			break;
		case PFINISHRESP:
			text = serialize(mos, (PFinishResp) message);
			break;
		case PICKCRES:
			text = serialize(mos, (PickcRes) message);
			break;
		case PICKORES:
			text = serialize(mos, (PickORes) message);
			break;
		case PLAYERELIMINATED:
			text = serialize(mos, (PlayerEliminated) message);
			break;
		case PLAYERSCORES:
			text = serialize(mos, (PlayerScores) message);
			break;
		case SCORELIST:
			text = serialize(mos, (ScoreList) message);
			break;
		case PLAYERSEQ:
			text = serialize(mos, (PlayerSeq) message);
			break;
		case PLAYERUPDATE:
			text = serialize(mos, (PlayerUpdate) message);
			break;
		case SEATS:
			text = serialize(mos, (Seats) message);
			break;
		case PLAYER:
			text = serialize(mos, (Player) message);
			break;
		case PLRDISCONNECT:
			text = serialize(mos, (PlrDisconnect) message);
			break;
		case PLRHANDCARD:
			text = serialize(mos, (PlrHandCard) message);
			break;
		case PLRMOVE:
			text = serialize(mos, (PlrMove) message);
			break;
		case PREPAREFORNEXTROUND:
			text = serialize(mos, (PrepareForNextRound) message);
			break;
		case PRIZEPOOL:
			text = serialize(mos, (PrizePool) message);
			break;
		case REBUYWINDOWBAL:
			text = serialize(mos, (RebuyWindowBal) message);
			break;
		case REJECTSPLITSUCCESS:
			text = serialize(mos, (RejectSplitSuccess) message);
			break;
		case REJOINFAIL:
			text = serialize(mos, (RejoinFail) message);
			break;
		case REJOININGPLAYERELIMINATED:
			text = serialize(mos, (RejoiningPlayerEliminated) message);
			break;
		case REJOINSUCCESS:
			text = serialize(mos, (RejoinSuccess) message);
			break;
		case RESETCONNECTION:
			text = serialize(mos, (ResetConnection) message);
			break;
		case RESHUFFLE:
			text = serialize(mos, (Reshuffle) message);
			break;
		case SCORECARDRESP:
			text = serialize(mos, (ScoreCardResp) message);
			break;
		case SCORELISTRESP:
			text = serialize(mos, (ScoreListResp) message);
			break;
		case SCOREWINDOW:
			text = serialize(mos, (ScoreWindow) message);
			break;
		case SCOREWINDOWVALUE:
			text = serialize(mos, (ScoreWindowValue) message);
			break;
		case SCOREWINDOWCHANGE:
			text = serialize(mos, (ScoreWindowChange) message);
			break;
		case SEATSETUP:
			text = serialize(mos, (SeatSetup) message);
			break;
		case SERVERDISCARD:
			text = serialize(mos, (ServerDiscard) message);
			break;
		case SETUPRES:
			text = serialize(mos, (SetupRes) message);
			break;
		case SHOWREJOIN:
			text = serialize(mos, (ShowRejoin) message);
			break;
		case SPLITDETAILS:
			text = serialize(mos, (SplitDetails) message);
			break;
		case PLAYERLIST:
			text = serialize(mos, (PlayerList) message);
			break;
		case SPLITSTATUS:
			text = serialize(mos, (SplitStatus) message);
			break;
		case SPLITSTATUSPLAYERLIST:
			text = serialize(mos, (SplitStatusPlayerList) message);
			break;
		case STARTDECLARE:
			text = serialize(mos, (StartDeclare) message);
			break;
		case STARTGAMETIMER:
			text = serialize(mos, (StartGameTimer) message);
			break;
		case TAKESEATBAL:
			text = serialize(mos, (TakeSeatBal) message);
			break;
		case THEMECHANGE:
			text = serialize(mos, (ThemeChange) message);
			break;
		case THEME:
			text = serialize(mos, (Theme) message);
			break;
		case THEMERES:
			text = serialize(mos, (ThemeRes) message);
			break;
		case TIEBREAKER:
			text = serialize(mos, (TieBreaker) message);
			break;
		case TOSSCARD:
			text = serialize(mos, (TossCard) message);
			break;
		case TOSSCARDOBJ:
			text = serialize(mos, (TossCardObj) message);
			break;
		case TOSSWINNER:
			text = serialize(mos, (TossWinner) message);
			break;
		case TOURNAMENTCOMPLETE:
			text = serialize(mos, (TournamentComplete) message);
			break;
		case TOURNAMENTINFO:
			text = serialize(mos, (TournamentInfo) message);
			break;
		case TOURNAMENTINFOOBJ:
			text = serialize(mos, (TournamentInfoObj) message);
			break;
		case CURRENTROUNDOBJ:
			text = serialize(mos, (CurrentRoundObj) message);
			break;
		case RANK:
			text = serialize(mos, (Rank) message);
			break;
		case ROUND:
			text = serialize(mos, (Round) message);
			break;
		case VALCARDSINFO:
			text = serialize(mos, (ValCardsInfo) message);
			break;
		case VALCARDTXNS:
			text = serialize(mos, (ValCardTxns) message);
			break;
		case WINNERMSG:
			text = serialize(mos, (WinnerMsg) message);
			break;
		case WRONGFINISHPLAYER:
			text = serialize(mos, (WrongFinishPlayer) message);
			break;
		case AAINFO:
			text = serialize(mos, (AAInfo) message);
			break;
		case GPROPERTY:
			text = serialize(mos, (GProperty) message);
			break;
		case TPROPERTY:
			text = serialize(mos, (TProperty) message);
			break;
		case AASTATUS:
			text = serialize(mos, (AAStatus) message);
			break;
		case ACCEPTSPLITSUCCESS:
			text = serialize(mos, (AcceptSplitSuccess) message);
			break;
		case ACK:
			text = serialize(mos, (Ack) message);
			break;
		case AMOUNTWON:
			text = serialize(mos, (AmountWon) message);
			break;
		case AMOUNTWONOBJ:
			text = serialize(mos, (AmountWonObj) message);
			break;
		case AUTODROPCANCELSUCCESS:
			text = serialize(mos, (AutoDropCancelSuccess) message);
			break;
		case AUTODROPSTATUS:
			text = serialize(mos, (AutoDropStatus) message);
			break;
		case AUTODROPSUCCESS:
			text = serialize(mos, (AutoDropSuccess) message);
			break;
		case AUTOPLAYREQ:
			text = serialize(mos, (AutoPlayReq) message);
			break;
		case AUTOPLAYRESPACK:
			text = serialize(mos, (AutoPlayRespAck) message);
			break;
		case BALUPDATE:
			text = serialize(mos, (BalUpdate) message);
			break;
		case BALUPDATEOBJ:
			text = serialize(mos, (BalUpdateObj) message);
			break;
		case BONTOURNAMENTINFO:
			text = serialize(mos, (BONTournamentInfo) message);
			break;
		case RANKOBJ:
			text = serialize(mos, (RankObj) message);
			break;
		case BUYINSUCC:
			text = serialize(mos, (BuyInSucc) message);
			break;
		case CLOSEALLCONNECTIONS:
			text = serialize(mos, (CloseAllConnections) message);
			break;
		case CLOSECONNECTION:
			text = serialize(mos, (CloseConnection) message);
			break;
		case CLOSEDDECKSIZE:
			text = serialize(mos, (ClosedDeckSize) message);
			break;
		case DEALER:
			text = serialize(mos, (Dealer) message);
			break;
		case DECLARECONF:
			text = serialize(mos, (DeclareConf) message);
			break;
		case DECLARERESP:
			text = serialize(mos, (DeclareResp) message);
			break;
		case DISCARDRES:
			text = serialize(mos, (DiscardRes) message);
			break;
		case DISCARDS:
			text = serialize(mos, (DiscardS) message);
			break;
		case DISCONPROTECTIONPREFUPDATERES:
			text = serialize(mos, (DisconProtectionPrefUpdateRes) message);
			break;
		case DROPPLAYER:
			text = serialize(mos, (DropPlayer) message);
			break;
		case DROPRES:
			text = serialize(mos, (DropRes) message);
			break;
		case ENABLESPLIT:
			text = serialize(mos, (EnableSplit) message);
			break;
		case ERRORMSG:
			text = serialize(mos, (ErrorMsg) message);
			break;
		case ERRORPICKO:
			text = serialize(mos, (ErrorPickO) message);
			break;
		case FINISHSTAGE:
			text = serialize(mos, (FinishStage) message);
			break;
		case GMSETUP:
			text = serialize(mos, (GmSetup) message);
			break;
		case GMSTATUS:
			text = serialize(mos, (GmStatus) message);
			break;
		case GRACEMOVE:
			text = serialize(mos, (GraceMove) message);
			break;
		case HUD:
			text = serialize(mos, (Hud) message);
			break;
		case BONUSVALUEOBJ:
			text = serialize(mos, (BonusValueObj) message);
			break;
		case MDROPPLAYER:
			text = serialize(mos, (MdropPlayer) message);
			break;
		case LPINFO:
			text = serialize(mos, (LPInfo) message);
			break;
		case CLUBINFOARRAYOBJ:
			text = serialize(mos, (ClubInfoArrayObj) message);
			break;
		case LASTDEALERR:
			text = serialize(mos, (LastDealErr) message);
			break;
		case JKRCARD:
			text = serialize(mos, (JkrCard) message);
			break;
		case MATCHINFO:
			text = serialize(mos, (MatchInfo) message);
			break;
		case MATCHSEATARRAYOBJ:
			text = serialize(mos, (MatchSeatArrayObj) message);
			break;
		case PLAYEROBJ:
			text = serialize(mos, (PlayerObj) message);
			break;
		case INVALIDFINISH21CARD:
			text = serialize(mos, (InvalidFinish21Card) message);
			break;
		case GRPSINFOOBJ:
			text = serialize(mos, (GrpsInfoObj) message);
			break;
		case FMGERROR:
			text = serialize(mos, (FmgError) message);
			break;
		case DISPLAYMSG:
			text = serialize(mos, (DisplayMsg) message);
			break;
		case DISCONPROTECTIONPREF:
			text = serialize(mos, (DisconProtectionPref) message);
			break;
		case DISABLESPLIT:
			text = serialize(mos, (DisableSplit) message);
			break;
		case CHATRES:
			text = serialize(mos, (ChatRes) message);
			break;
		case BONUSINDICATOR:
			text = serialize(mos, (BonusIndicator) message);
			break;
		case PENDINGBONUSOBJ:
			text = serialize(mos, (PendingBonusObj) message);
			break;
		case TAKESEATFAIL:
			text = serialize(mos, (TakeSeatFail) message);
			break;
		case BONUSES:
			text = serialize(mos, (Bonuses) message);
			break;
		case RMVALUE:
			text = serialize(mos, (RmValue) message);
			break;
		case AUTOREBUYINSUCCESS:
			text = serialize(mos, (AutoRebuyInSuccess) message);
			break;
		case BUYINFAIL:
			text = serialize(mos, (BuyInFail) message);
			break;
		case VALCARDSTR:
			text = serialize(mos, (ValCardStr) message);
			break;
		case PLAYERTXN:
			text = serialize(mos, (PlayerTxn) message);
			break;
		case BONTOURNAMENTCOMPLETE:
			text = serialize(mos, (BonTournamentComplete) message);
			break;
		case MECRASH:
			text = serialize(mos, (MECrash) message);
			break;
		case BREAKSTRUCTUREOBJ:
			text = serialize(mos, (BreakStructureObj) message);
			break;
		case MATCHCREATED:
			text = serialize(mos, (MatchCreated) message);
			break;
		case POOLTOURNAMENTCOMPLETE:
			text = serialize(mos, (PoolTournamentComplete) message);
			break;
		case TECRASH:
			text = serialize(mos, (TECrash) message);
			break;
		case MATCHSETUP:
			text = serialize(mos, (MatchSetup) message);
			break;
		case AUTOREBUYINPREF:
			text = serialize(mos, (AutoRebuyinPref) message);
			break;
		case SCORESOBJ:
			text = serialize(mos, (ScoresObj) message);
			break;
		case REMATCHREQUEST:
			text = serialize(mos, (RematchRequest) message);
			break;
		case REMATCHRESPONSE:
			text = serialize(mos, (RematchResponse) message);
			break;
		case SCOREWINDOW21CARD:
			text = serialize(mos, (ScoreWindow21Card) message);
			break;
		case AUTOREBUYINREQ:
			text = serialize(mos, (AutoRebuyinReq) message);
			break;
		case SAVETHEME:
			text = serialize(mos, (SaveTheme) message);
			break;
		case MTTSCORECARDRESP:
			text = serialize(mos, (MTTScoreCardResp) message);
			break;
		case MTTSCORELISTRESP:
			text = serialize(mos, (MTTScoreListResp) message);
			break;
		case CHANGETABLEID:
			text = serialize(mos, (ChangeTableId) message);
			break;
		case HEARTBEAT:
			text = serialize(mos, (HeartBeat) message);
			break;
		case HEARTBEATRESPONSE:
			text = serialize(mos, (HeartBeatResponse) message);
			break;
		case HANDSHAKE:
			text = serialize(mos, (HandShake) message);
			break;
		case HANDSHAKERESPONSE:
			text = serialize(mos, (HandShakeResponse) message);
			break;
		case MTTTABLEMAP:
			text = serialize(mos, (MttTableMap) message);
			break;
		case MTTTABLEMAPRESP:
			text = serialize(mos, (MttTableMapResp) message);
			break;
		case FMGREQUEST:
			text = serialize(mos, (FMGRequest) message);
			break;
		}
		byte[] bytes = null;
		if (text != null) {
			bytes = text.getBytes();
		}
		return bytes;
	}

	private String serialize(MessageOutputStream mos, FMGRequest message)
			throws IOException {
		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("mpid", message.getMpid());
		mos.writeInt("prizeType", message.getPrizeType());
		mos.writeInt("formatType", message.getFormatType());
		mos.writeInt("noOfPlayer", message.getNoOfPlayer());
		mos.writeDouble("prizePerPoint", message.getPrizePerPoint());
		mos.writeDouble("entryFee", message.getEntryFee());
		mos.writeInt("includeInProgress", message.getIncludeInProgress());
		mos.writeString("ipAddress", message.getIpAddress());
		mos.writeLong("oldTableId", message.getOldTableId());
		mos.writeBoolean("fmgOnTable", message.isFmgOnTable());
		mos.writeBoolean("emptyTable", message.isEmptyTable());
		mos.writeBoolean("interimTableSettlement",
				message.isInterimTableSettlement());
		logger.info("Serialized message: " + mos.toText());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, AcceptSplit message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, AutoDrop message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("mplayerid", message.getMplayerid());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, AutoDropCancel message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, AutoPlayRes message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("mid", message.getMid());
		mos.writeLong("mpid", message.getMpid());
		mos.writeBoolean("isautoplay", message.isIsautoplay());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, BONBonusUpdateReq message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, BuyIn message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeDouble("customamnt", message.getCustomamnt());
		mos.writeDouble("bal", message.getBal());
		mos.writeDouble("tablemin", message.getTablemin());
		mos.writeInt("seatid", message.getSeatid());
		mos.writeDouble("tablemax", message.getTablemax());
		mos.writeInt("clientvariant", message.getClientvariant());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Chat message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("ctext", message.getCtext());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, DealsLeft message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, DealsLeftRes message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("dealsleft", message.getDealsleft());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Declare message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("mpid", message.getMpid());
		mos.writeLong("mid", message.getMid());
		mos.writeList("cards", message.getCards());
		mos.writeInt("topgroupscount", message.getTopgroupscount());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Discard message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("cardid", message.getCardid());
		mos.writeLong("mpid", message.getMpid());
		mos.writeLong("mid", message.getMid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Discardcs message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeString("cards", message.getCards());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos,
			DisconProtectionPrefUpdate message) throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("poolrummy", message.getPoolrummy());
		mos.writeInt("pointsrummy21", message.getPointsrummy21());
		mos.writeBoolean("messageshown", message.isMessageshown());
		mos.writeInt("ischecked", message.getIschecked());
		mos.writeInt("pointsrummy", message.getPointsrummy());
		mos.writeInt("mtt", message.getMtt());
		mos.writeInt("dealsrummy", message.getDealsrummy());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Drop message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("mpid", message.getMpid());
		mos.writeLong("mid", message.getMid());
		mos.writeBoolean("autodrop", message.isAutodrop());
		mos.writeBoolean("mdrop", message.isMdrop());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Finish message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("cardid", message.getCardid());
		mos.writeLong("mpid", message.getMpid());
		mos.writeLong("mid", message.getMid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, FirstCashGameAck message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, FMGSearch message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("fmgparams", message.getFmgparams());
		mos.writeString("fmg", message.getFmg());
		mos.writeInt("lastte", message.getLastte());
		mos.writeString("pptip", message.getPptip());
		mos.writeInt("clientvariant", message.getClientvariant());
		mos.writeLong("oldtid", message.getOldtid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos,
			HandProgressBarState message) throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeBoolean("progressbarmax", message.isProgressbarmax());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, InitiateSplit message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, LastDealReq message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, LeaveTable message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("mplayerid", message.getMplayerid());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, NewRoundConnection message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("fmgparams", message.getFmgparams());
		mos.writeString("sessionid", message.getSessionId());
		mos.writeInt("clientvariant", message.getClientvariant());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Pickc message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("mpid", message.getMpid());
		mos.writeLong("mid", message.getMid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Picko message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("mpid", message.getMpid());
		mos.writeLong("mid", message.getMid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Rap message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("category", message.getCategory());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeString("ptext", message.getPtext());
		mos.writeLong("gameid", message.getGameid());
		mos.writeLong("tournamentid", message.getTournamentid());
		mos.writeInt("settlementtype", message.getSettlementtype());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Ready message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, RebuyIn message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("seatid", message.getSeatid());
		mos.writeDouble("bal", message.getBal());
		mos.writeDouble("tablemax", message.getTablemax());
		mos.writeDouble("tablemin", message.getTablemin());
		mos.writeDouble("customamnt", message.getCustomamnt());
		mos.writeInt("clientvariant", message.getClientvariant());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Recon message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("fmgparams", message.getFmgparams());
		mos.writeString("sessionid", message.getSessionId());
		mos.writeString("pptip", message.getPptip());
		mos.writeInt("clientvariant", message.getClientvariant());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeLong("mplayerid", message.getMplayerid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, RejectSplit message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, RejoinStatus message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeBoolean("status", message.isStatus());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, UpdateTheme message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("tableid", message.getTableid());
		mos.writeInt("themeid", message.getThemeid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ScoreCard message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, SetCards message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("mpid", message.getMpid());
		mos.writeLong("mid", message.getMid());
		mos.writeList("cards", message.getCards());
		mos.writeInt("topgroupscount", message.getTopgroupscount());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Setup message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("sessionid", message.getSessionId());
		mos.writeString("fmgparams", message.getFmgparams());
		mos.writeInt("clientvariant", message.getClientvariant());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, TakeSeat message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("seatid", message.getSeatid());
		mos.writeString("pptip", message.getPptip());
		mos.writeInt("clientvariant", message.getClientvariant());
		mos.writeDouble("entryfee", message.getEntryfee());
		mos.writeInt("inprogress", message.getInprogress());
		mos.writeString("loginid", message.getLoginid());
		mos.writeString("sessionid", message.getSessionId());
		mos.writeInt("lastte", message.getLastte());
		mos.writeString("hashstr", message.getHashstr());
		mos.writeLong("aaid", message.getAaid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ThemeReq message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("game", message.getGame());
		mos.writeInt("value", message.getValue());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Withdraw message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("seatid", message.getSeatid());
		mos.writeString("sessionid", message.getSessionId());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, WithdrawRebuy message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("seatid", message.getSeatid());
		mos.writeString("sessionid", message.getSessionId());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, MoveTimeout message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeLong("mplayerid", message.getMplayerid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, OpnCard message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeString("cardid", message.getCardid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, OppDeclare message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("succ", message.getSucc());
		mos.writeInt("score", message.getScore());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeLong("mplayerid", message.getMplayerid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, OppDiscard message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeLong("mplayerid", message.getMplayerid());
		mos.writeString("cardid", message.getCardid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, OppDrop message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("point", message.getPoint());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeLong("mplayerid", message.getMplayerid());
		mos.writeInt("mdrop", message.getMdrop());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, OppFinish message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("extratime", message.getExtratime());
		mos.writeLong("timetodeclare", message.getTimetodeclare());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("totaltimetodeclare", message.getTotaltimetodeclare());
		mos.writeLong("gameid", message.getGameid());
		mos.writeLong("mplayerid", message.getMplayerid());
		mos.writeString("cardid", message.getCardid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, OppPickC message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeLong("mplayerid", message.getMplayerid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, OppPickO message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("nextocardid", message.getNextocardid());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeLong("mplayerid", message.getMplayerid());
		mos.writeString("cardid", message.getCardid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, PFinishResp message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("timetodeclare", message.getTimetodeclare());
		mos.writeLong("totaltimetodeclare", message.getTotaltimetodeclare());
		mos.writeLong("extratime", message.getExtratime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeLong("mplayerid", message.getMplayerid());
		mos.writeString("cardid", message.getCardid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, PickcRes message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeString("cardid", message.getCardid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, PickORes message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("nextocardid", message.getNextocardid());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeString("cardid", message.getCardid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, PlayerEliminated message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("title", message.getTitle());
		mos.writeBoolean("balanceverifed", message.isBalanceverifed());
		mos.writeBoolean("isactive", message.isIsactive());
		mos.writeBoolean("showfmgflag", message.isShowfmgflag());
		mos.writeString("msg", message.getMsg());
		mos.writeInt("rank", message.getRank());
		mos.writeInt("tranchrank", message.getTranchrank());
		mos.writeBoolean("initiateRematch", message.isInitiateRematch());
		mos.writeDouble("entryFee", message.getEntryFee());
		mos.writeInt("rematchCountDown", message.getRematchCountDown());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, PlayerScores message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("mid", message.getMid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeList("scorelist", message.getScorelist());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ScoreList message)
			throws IOException {

		mos.writeLong("score", message.getScore());
		mos.writeString("loginid", message.getLoginid());
		mos.writeLong("totalscore", message.getTotalscore());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, PlayerSeq message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeList("orderedmplayerids", message.getOrderedmplayerids());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, PlayerUpdate message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("aaid", message.getAaid());
		mos.writeList("seats", message.getSeats());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Seats message)
			throws IOException {

		mos.writeInt("id", message.getId());
		mos.writeBoolean("seatedout", message.isSeatedout());
		mos.writeInt("state", message.getState());
		mos.writeDouble("seatplayerbalance", message.getSeatplayerbalance());
		mos.writeInt("playerscore", message.getPlayerscore());
		mos.writeBoolean("autodrop", message.isAutodrop());
		mos.writeObject("player", message.getPlayer());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Player message)
			throws IOException {

		mos.writeBoolean("hasplayedpracticegame",
				message.isHasplayedpracticegame());
		mos.writeInt("status", message.getStatus());
		mos.writeInt("clientvariant", message.getClientvariant());
		mos.writeString("loginid", message.getLoginid());
		mos.writeString("emailid", message.getEmailid());
		mos.writeLong("id", message.getId());
		mos.writeBoolean("hasplayed21cardpracticegame",
				message.isHasplayed21cardpracticegame());
		mos.writeLong("timeofreg", message.getTimeofreg());
		mos.writeInt("absoluterank", message.getAbsoluterank());
		mos.writeLong("idlong", message.getIdlong());
		mos.writeString("rating", message.getRating());
		mos.writeInt("tranchrank", message.getTranchrank());
		mos.writeLong("lastpingreceivedtime", message.getLastpingreceivedtime());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, PlrDisconnect message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeList("playerid", message.getPlayerid());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, PlrHandCard message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeList("cards", message.getCards());
		mos.writeInt("topgroupscount", message.getTopgroupscount());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, PlrMove message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("totalgracetime", message.getTotalgracetime());
		mos.writeLong("gracetime", message.getGracetime());
		mos.writeLong("movetime", message.getMovetime());
		mos.writeBoolean("isfirstmove", message.isIsfirstmove());
		mos.writeInt("moveno", message.getMoveno());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeLong("mplayerid", message.getMplayerid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos,
			PrepareForNextRound message) throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("roundnumber", message.getRoundnumber());
		mos.writeLong("nextroundstarttime", message.getNextroundstarttime());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, PrizePool message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeDouble("prize", message.getPrize());
		mos.writeLong("aaid", message.getAaid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, RebuyWindowBal message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeDouble("bal", message.getBal());
		mos.writeLong("timer", message.getTimer());
		mos.writeDouble("tablemax", message.getTablemax());
		mos.writeDouble("tablemin", message.getTablemin());
		mos.writeBoolean("rebuy", message.isRebuy());
		mos.writeList("seats", message.getSeats());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, RejectSplitSuccess message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("aaid", message.getAaid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, RejoinFail message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("msg", message.getMsg());
		mos.writeString("title", message.getTitle());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos,
			RejoiningPlayerEliminated message) throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("title", message.getTitle());
		mos.writeBoolean("balanceverifed", message.isBalanceverifed());
		mos.writeBoolean("isactive", message.isIsactive());
		mos.writeBoolean("showfmgflag", message.isShowfmgflag());
		mos.writeString("msg", message.getMsg());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, RejoinSuccess message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("title", message.getTitle());
		mos.writeInt("rejoinscore", message.getRejoinscore());
		mos.writeString("msg", message.getMsg());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ResetConnection message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("nexttableid", message.getNexttableid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Reshuffle message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeInt("size", message.getSize());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ScoreCardResp message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("aaid", message.getAaid());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeList("scorelist", message.getScorelist());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ScoreListResp message)
			throws IOException {

		mos.writeList("scores", message.getScores());
		mos.writeString("loginid", message.getLoginid());
		mos.writeInt("total", message.getTotal());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ScoreWindow message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeInt("dealnumber", message.getDealnumber());
		mos.writeString("joker", message.getJoker());
		mos.writeBoolean("lastdeal", message.isLastdeal());
		mos.writeList("scorewindow", message.getScorewindow());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ScoreWindowValue message)
			throws IOException {

		mos.writeString("message", message.getMessage());
		mos.writeString("result", message.getResult());
		mos.writeInt("topgroupscount", message.getTopgroupscount());
		mos.writeString("username", message.getUsername());
		mos.writeInt("score", message.getScore());
		mos.writeLong("mplayerid", message.getMplayerid());
		mos.writeString("loginid", message.getLoginid());
		mos.writeInt("handcardgain", message.getHandcardgain());
		mos.writeObject("valuecardstr", message.getValuecardstr());
		mos.writeLong("id", message.getId());
		mos.writeList("cards", message.getCards());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ScoreWindowChange message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeObject("playerresult", message.getPlayerresult());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, SeatSetup message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("aaid", message.getAaid());
		mos.writeList("seats", message.getSeats());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ServerDiscard message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeString("cardid", message.getCardid());
		mos.writeBoolean("wrongf", message.isWrongf());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, SetupRes message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeBoolean("breplayer", message.isBreplayer());
		mos.writeInt("mp", message.getMp());
		mos.writeLong("tableid", message.getTableid());
		mos.writeString("swfmainpath", message.getSwfmainpath());
		mos.writeString("bgimgurl", message.getBgimgurl());
		mos.writeLong("aaid", message.getAaid());
		mos.writeBoolean("chatblocked", message.isChatblocked());
		mos.writeString("conifgfilepath", message.getConifgfilepath());
		mos.writeInt("maxplayer", message.getMaxplayer());
		mos.writeBoolean("showfmg", message.isShowfmg());
		mos.writeBoolean("mttChatBlock", message.isMttChatBlock());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ShowRejoin message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("title", message.getTitle());
		mos.writeDouble("bal", message.getBal());
		mos.writeLong("remainingtimeforrejoin",
				message.getRemainingtimeforrejoin());
		mos.writeInt("rejoinscore", message.getRejoinscore());
		mos.writeLong("aaid", message.getAaid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, SplitDetails message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeDouble("totalprize", message.getTotalprize());
		mos.writeDouble("timer", message.getTimer());
		mos.writeString("initiatedby", message.getInitiatedby());
		mos.writeLong("aaid", message.getAaid());
		mos.writeList("playerlist", message.getPlayerlist());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, PlayerList message)
			throws IOException {

		mos.writeDouble("amount", message.getAmount());
		mos.writeInt("dropsremaining", message.getDropsremaining());
		mos.writeString("loginid", message.getLoginid());
		mos.writeInt("totalscore", message.getTotalscore());
		mos.writeString("status", message.getStatus());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, SplitStatus message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("aaid", message.getAaid());
		mos.writeList("playerlist", message.getPlayerlist());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos,
			SplitStatusPlayerList message) throws IOException {

		mos.writeString("loginid", message.getLoginid());
		mos.writeString("status", message.getStatus());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, StartDeclare message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("timetodeclare", message.getTimetodeclare());
		mos.writeLong("totalgracetime", message.getTotalgracetime());
		mos.writeLong("gracetime", message.getGracetime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("totaltimetodeclare", message.getTotaltimetodeclare());
		mos.writeLong("gameid", message.getGameid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, StartGameTimer message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("timer", message.getTimer());
		mos.writeLong("aaid", message.getAaid());
		mos.writeList("rejoiningplayerarray", message.getRejoiningplayerarray());
		mos.writeString("sessionid", message.getSessionId());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, TakeSeatBal message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeDouble("bal", message.getBal());
		mos.writeLong("timer", message.getTimer());
		mos.writeDouble("tablemax", message.getTablemax());
		mos.writeDouble("tablemin", message.getTablemin());
		mos.writeBoolean("rebuy", message.isRebuy());
		mos.writeList("seats", message.getSeats());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ThemeChange message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeList("theme", message.getTheme());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Theme message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		// mos.writeInt("ackreq", message.getAckReq());
		// mos.writeLong("id", message.getMsgId());
		// mos.writeString("dest", message.getDest());
		// mos.writeLong("systime", message.getSysTime());
		mos.writeInt("id", message.getId());
		mos.writeString("thumbimage", message.getThumbimage());
		mos.writeString("name", message.getName());
		mos.writeString("bigimage", message.getBigimage());
		mos.writeString("configfile", message.getConfigfile());
		mos.writeInt("dealtype", message.getDealtype());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ThemeRes message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("swfmainpath", message.getSwfmainpath());
		mos.writeString("configfilepath", message.getConfigfilepath());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, TieBreaker message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("tienumber", message.getTienumber());
		mos.writeBoolean("iscurrent", message.isIscurrent());
		mos.writeInt("tietype", message.getTietype());
		mos.writeList("players", message.getPlayers());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, TossCard message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeList("tosscardarry", message.getTosscardarry());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, TossCardObj message)
			throws IOException {

		mos.writeLong("mplayerid", message.getMplayerid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeString("cardid", message.getCardid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, TossWinner message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("mplayerid", message.getMplayerid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeLong("matchid", message.getMatchid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, TournamentComplete message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, TournamentInfo message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeDouble("totalprize", message.getTotalprize());
		mos.writeBoolean("hasticket", message.isHasticket());
		mos.writeObject("tournamentinfo", message.getTournamentinfo());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, TournamentInfoObj message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		// mos.writeInt("ackreq", message.getAckReq());
		// mos.writeLong("id", message.getMsgId());
		// mos.writeString("dest", message.getDest());
		// mos.writeLong("systime", message.getSysTime());
		mos.writeInt("roundtotaltime", message.getRoundtotaltime());
		mos.writeString("tournamentname", message.getTournamentname());
		mos.writeList("breakstructure", message.getBreakstructure());
		mos.writeObject("currentround", message.getCurrentround());
		mos.writeList("rounds", message.getRounds());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, CurrentRoundObj message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("maxdeals", message.getMaxdeals());
		mos.writeLong("inprogresstime", message.getInprogresstime());
		mos.writeInt("dealmultiplier", message.getDealmultiplier());
		mos.writeInt("number", message.getNumber());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Rank message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		// mos.writeInt("ackreq", message.getAckReq());
		// mos.writeLong("id", message.getMsgId());
		// mos.writeString("dest", message.getDest());
		// mos.writeLong("systime", message.getSysTime());
		mos.writeInt("rank", message.getRank());
		mos.writeInt("status", message.getStatus());
		mos.writeDouble("cashprize", message.getCashprize());
		mos.writeBoolean("hasticket", message.isHasticket());
		mos.writeInt("ticketid", message.getTicketid());
		mos.writeString("ticketname", message.getTicketname());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Round message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		// mos.writeInt("ackreq", message.getAckReq());
		// mos.writeLong("id", message.getMsgId());
		// mos.writeString("dest", message.getDest());
		// mos.writeLong("systime", message.getSysTime());
		mos.writeInt("qualifiers", message.getQualifiers());
		mos.writeInt("roundnum", message.getRoundnum());
		mos.writeString("name", message.getName());
		mos.writeInt("prizes", message.getPrizes());
		mos.writeList("ranks", message.getRanks());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ValCardsInfo message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeBoolean("lastdeal", message.isLastdeal());
		mos.writeString("loginid", message.getLoginid());
		mos.writeObject("valcardtxns", message.getValcardtxns());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ValCardTxns message)
			throws IOException {

		mos.writeInt("pointsgiven", message.getPointsgiven());
		mos.writeInt("pointsrcd", message.getPointsrcd());
		mos.writeInt("netvaluecardgains", message.getNetvaluecardgains());
		mos.writeObject("valuecardstr", message.getValuecardstr());
		mos.writeLong("userid", message.getUserid());
		mos.writeString("loginid", message.getLoginid());
		mos.writeList("playertxns", message.getPlayertxns());
		mos.writeInt("handCardGain", message.getHandCardGain());
		mos.writeString("status", message.getStatus());
		mos.writeList("cards", message.getCards());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, WinnerMsg message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("rank", message.getRank());
		mos.writeDouble("amount", message.getAmount());
		mos.writeBoolean("split", message.isSplit());
		mos.writeBoolean("showfmgflag", message.isShowfmgflag());
		mos.writeBoolean("isactive", message.isIsactive());
		mos.writeBoolean("balanceverifed", message.isBalanceverifed());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, WrongFinishPlayer message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeList("players", message.getPlayers());
		mos.writeInt("score", message.getScore());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, AAInfo message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeObject("gproperty", message.getGproperty());
		mos.writeObject("tproperty", message.getTproperty());
		mos.writeInt("aanum", message.getAanum());
		mos.writeString("gametype", message.getGametype());
		mos.writeLong("aaid", message.getAaid());
		mos.writeBoolean("progressbarmax", message.isProgressbarmax());
		mos.writeInt("prizetype", message.getPrizetype());
		mos.writeInt("multiplier", message.getMultiplier());
		mos.writeInt("rewardpointsvalue", message.getRewardpointsvalue());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, GProperty message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		// mos.writeInt("ackreq", message.getAckReq());
		// mos.writeLong("id", message.getMsgId());
		// mos.writeString("dest", message.getDest());
		// mos.writeLong("systime", message.getSysTime());
		mos.writeInt("movetime", message.getMovetime());
		mos.writeInt("noofdeck", message.getNoofdeck());
		mos.writeInt("fullcountcfp", message.getFullcountcfp());
		mos.writeInt("maxbuyinmultiplier21cardcfp",
				message.getMaxbuyinmultiplier21cardcfp());
		mos.writeInt("noofdubleestobesafe21cardcfp",
				message.getNoofdubleestobesafe21cardcfp());
		mos.writeInt("maxplayer", message.getMaxplayer());
		mos.writeInt("blockedwords", message.getBlockedwords());
		mos.writeLong("extratime", message.getExtratime());
		mos.writeInt("nooftunnelastodeclare21cardcfp",
				message.getNooftunnelastodeclare21cardcfp());
		mos.writeInt("rptplmobserver", message.getRptplmobserver());
		mos.writeLong("mvtimefirstplayer", message.getMvtimefirstplayer());
		mos.writeInt("noofcardtodeal", message.getNoofcardtodeal());
		mos.writeLong("declaretime", message.getDeclaretime());
		mos.writeInt("dealbetweentime", message.getDealbetweentime());
		mos.writeInt("prizetype", message.getPrizetype());
		mos.writeLong("tosstimeout", message.getTosstimeout());
		mos.writeInt("cardperpureseq", message.getCardperpureseq());
		mos.writeInt("missedmovesdrop", message.getMissedmovesdrop());
		mos.writeInt("firstdropcfp", message.getFirstdropcfp());
		mos.writeInt("printedjokersperdeck", message.getPrintedjokersperdeck());
		mos.writeInt("observerchat", message.getObserverchat());
		mos.writeInt("settlementtype", message.getSettlementtype());
		mos.writeInt("minpointvalue21cardcfp",
				message.getMinpointvalue21cardcfp());
		mos.writeInt("maxpointvalue21cardcfp",
				message.getMaxpointvalue21cardcfp());
		mos.writeLong("autoplaytimeout", message.getAutoplaytimeout());
		mos.writeInt("timebtwround", message.getTimebtwround());
		mos.writeInt("noofdubleestodeclare21cardcfp",
				message.getNoofdubleestodeclare21cardcfp());
		mos.writeLong("sitouttimeout", message.getSitouttimeout());
		mos.writeInt("safescoreonplayerdeclaration21cardcfp",
				message.getSafescoreonplayerdeclaration21cardcfp());
		mos.writeBoolean("autoemail", message.isAutoemail());
		mos.writeInt("jokertype", message.getJokertype());
		mos.writeLong("extratimechunk", message.getExtratimechunk());
		mos.writeInt("middledropcfp", message.getMiddledropcfp());
		mos.writeInt("noofjokerstodeclare21cardcfp",
				message.getNoofjokerstodeclare21cardcfp());
		mos.writeInt("noofjokerstobesafe21cardcfp",
				message.getNoofjokerstobesafe21cardcfp());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, TProperty message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		// mos.writeInt("ackreq", message.getAckReq());
		// mos.writeLong("id", message.getMsgId());
		// mos.writeString("dest", message.getDest());
		// mos.writeLong("systime", message.getSysTime());
		mos.writeLong("splittimeout", message.getSplittimeout());
		mos.writeDouble("entryfee", message.getEntryfee());
		mos.writeLong("rejointimeout", message.getRejointimeout());
		mos.writeInt("settlementtype", message.getSettlementtype());
		mos.writeDouble("typezeroentryfeelimit",
				message.getTypezeroentryfeelimit());
		mos.writeDouble("maxbuyin", message.getMaxbuyin());
		mos.writeDouble("pointvalue", message.getPointvalue());
		mos.writeDouble("servicefee", message.getServicefee());
		mos.writeInt("mindropsforsplit", message.getMindropsforsplit());
		mos.writeInt("maxplayer", message.getMaxplayer());
		mos.writeBoolean("splitallowed", message.isSplitallowed());
		mos.writeBoolean("rejoinallowed", message.isRejoinallowed());
		mos.writeInt("poolmaxscore", message.getPoolmaxscore());
		mos.writeLong("countinbtwmatch", message.getCountinbtwmatch());
		mos.writeLong("buyintimeout", message.getBuyintimeout());
		mos.writeString("name", message.getName());
		mos.writeInt("mindealtoplay", message.getMindealtoplay());
		mos.writeInt("servicefeetype", message.getServicefeetype());
		mos.writeInt("prizetype", message.getPrizetype());
		mos.writeLong("countdwnstartgame", message.getCountdwnstartgame());
		mos.writeDouble("minbuyin", message.getMinbuyin());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, AAStatus message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("aastatus", message.getAastatus());
		mos.writeLong("aaid", message.getAaid());
		mos.writeLong("maxplayer", message.getMaxplayer());
		mos.writeInt("dealnumber", message.getDealnumber());
		mos.writeInt("roundnumber", message.getRoundnumber());
		mos.writeBoolean("tiebreaker", message.isTiebreaker());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, AcceptSplitSuccess message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("aaid", message.getAaid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Ack message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("lastrecmsgid", message.getLastrecmsgid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, AmountWon message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeList("amountownlist", message.getAmountownlist());
		mos.writeBoolean("lastdeal", message.isLastdeal());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, AmountWonObj message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		// mos.writeInt("ackreq", message.getAckReq());
		// mos.writeLong("id", message.getMsgId());
		// mos.writeString("dest", message.getDest());
		// mos.writeLong("systime", message.getSysTime());
		mos.writeDouble("amount", message.getAmount());
		mos.writeString("loginid", message.getLoginid());
		mos.writeInt("totalscore", message.getTotalscore());
		mos.writeDouble("tablebal", message.getTablebal());
		mos.writeLong("mpid", message.getMpid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos,
			AutoDropCancelSuccess message) throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("aaid", message.getAaid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, AutoDropStatus message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("mid", message.getMid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeBoolean("autodrop", message.isAutodrop());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, AutoDropSuccess message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("aaid", message.getAaid());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, AutoPlayReq message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("time", message.getTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, AutoPlayRespAck message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeBoolean("isautoplay", message.isIsautoplay());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, BalUpdate message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("aaid", message.getAaid());
		mos.writeList("balarray", message.getBalarray());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, BalUpdateObj message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		// mos.writeInt("ackreq", message.getAckReq());
		// mos.writeLong("id", message.getMsgId());
		// mos.writeString("dest", message.getDest());
		// mos.writeLong("systime", message.getSysTime());
		mos.writeDouble("bal", message.getBal());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, BONTournamentInfo message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeList("ranks", message.getRanks());
		mos.writeInt("totaldeals", message.getTotaldeals());
		mos.writeDouble("totalprize", message.getTotalprize());
		mos.writeInt("numofprizes", message.getNumofprizes());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, RankObj message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("rank", message.getRank());
		mos.writeDouble("cashprize", message.getCashprize());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, BuyInSucc message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("aaid", message.getAaid());
		mos.writeString("sessionid", message.getSessionId());
		mos.writeBoolean("rebuy", message.isRebuy());
		mos.writeBoolean("first21cardpracticegame",
				message.isFirst21cardpracticegame());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos,
			CloseAllConnections message) throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("aaid", message.getAaid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, CloseConnection message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("mid", message.getMid());
		mos.writeLong("gameid", message.getGameid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ClosedDeckSize message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("size", message.getSize());
		mos.writeLong("gameid", message.getGameid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Dealer message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeLong("mplayerid", message.getMplayerid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, DeclareConf message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeLong("mplayerid", message.getMplayerid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, DeclareResp message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeLong("mplayerid", message.getMplayerid());
		mos.writeInt("succ", message.getSucc());
		mos.writeInt("score", message.getScore());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, DiscardRes message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeString("cardid", message.getCardid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, DiscardS message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeList("cards", message.getCards());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos,
			DisconProtectionPrefUpdateRes message) throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeBoolean("flag", message.isFlag());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, DropPlayer message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeList("players", message.getPlayers());
		mos.writeInt("score", message.getScore());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, DropRes message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("message", message.getMessage());
		mos.writeInt("point", message.getPoint());
		mos.writeInt("result", message.getResult());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeInt("mdrop", message.getMdrop());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, EnableSplit message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("aaid", message.getAaid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ErrorMsg message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("msgid", message.getMsgid());
		mos.writeString("title", message.getTitle());
		mos.writeBoolean("bootout", message.isBootout());
		mos.writeString("msg", message.getMsg());
		mos.writeLong("aaid", message.getAaid());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ErrorPickO message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeString("msg", message.getMsg());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, FinishStage message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeString("fcard", message.getFcard());
		mos.writeInt("showdeclare", message.getShowdeclare());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, GmSetup message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeBoolean("isfirstpracticegame", message.isIsfirstpracticegame());
		mos.writeInt("currdeal", message.getCurrdeal());
		mos.writeLong("starttime", message.getStarttime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeInt("maxdeal", message.getMaxdeal());
		mos.writeLong("gameid", message.getGameid());
		mos.writeInt("movenumber", message.getMovenumber());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, GmStatus message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("statusid", message.getStatusid());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, GraceMove message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("totalgracetime", message.getTotalgracetime());
		mos.writeLong("gracetime", message.getGracetime());
		mos.writeBoolean("firstmove", message.isFirstmove());
		mos.writeLong("gameid", message.getGameid());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("mplayerid", message.getMplayerid());
		mos.writeLong("movetime", message.getMovetime());
		mos.writeInt("moveno", message.getMoveno());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Hud message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("nextclub", message.getNextclub());
		mos.writeInt("currentloyaltypoints", message.getCurrentloyaltypoints());
		mos.writeInt("currentrewardpoints", message.getCurrentrewardpoints());
		mos.writeInt("viployaltypoints", message.getViployaltypoints());
		mos.writeString("clubvalidity", message.getClubvalidity());
		mos.writeBoolean("isfirstcashgame", message.isIsfirstcashgame());
		mos.writeInt("currentclub", message.getCurrentclub());
		mos.writeBoolean("isvipuser", message.isIsvipuser());
		mos.writeString("superuserimageurl", message.getSuperuserimageurl());
		mos.writeObject("rmvalue", message.getRmvalue());
		mos.writeObject("bonusvalue", message.getBonusvalue());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, BonusValueObj message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		// mos.writeInt("ackreq", message.getAckReq());
		// mos.writeLong("id", message.getMsgId());
		// mos.writeString("dest", message.getDest());
		// mos.writeLong("systime", message.getSysTime());
		mos.writeBoolean("bonusactive", message.isBonusactive());
		mos.writeLong("userid", message.getUserid());
		mos.writeDouble("bonusreleasedincurrentsettlement",
				message.getBonusreleasedincurrentsettlement());
		mos.writeDouble("remainingamttoplayforcurrentchunk",
				message.getRemainingamttoplayforcurrentchunk());
		mos.writeInt("daystoexpire", message.getDaystoexpire());
		mos.writeDouble("chunkamount", message.getChunkamount());
		mos.writeInt("totalchunks", message.getTotalchunks());
		mos.writeInt("chunksreleased", message.getChunksreleased());
		mos.writeDouble("entryfeeperchunk", message.getEntryfeeperchunk());
		mos.writeString("bonuscode", message.getBonuscode());
		mos.writeDouble("remainingbonusamount",
				message.getRemainingbonusamount());
		mos.writeDouble("totalbonusamt", message.getTotalbonusamt());
		mos.writeObject("pendingbonus", message.getPendingbonus());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, MdropPlayer message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeList("players", message.getPlayers());
		mos.writeInt("score", message.getScore());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, LPInfo message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("rptospend", message.getRptospend());
		mos.writeInt("lptospend", message.getLptospend());
		mos.writeList("clubinfoarray", message.getClubinfoarray());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ClubInfoArrayObj message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		// mos.writeInt("ackreq", message.getAckReq());
		// mos.writeLong("id", message.getMsgId());
		// mos.writeString("dest", message.getDest());
		// mos.writeLong("systime", message.getSysTime());
		mos.writeDouble("bonuses", message.getBonuses());
		mos.writeDouble("rewardpoints", message.getRewardpoints());
		mos.writeInt("qualperiod", message.getQualperiod());
		mos.writeInt("validity", message.getValidity());
		mos.writeDouble("tournaments", message.getTournaments());
		mos.writeInt("clubid", message.getClubid());
		mos.writeInt("lpsneeded", message.getLpsneeded());
		mos.writeString("clubname", message.getClubname());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, LastDealErr message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("msg", message.getMsg());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, JkrCard message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("cardid", message.getCardid());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, MatchInfo message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeList("matchseataray", message.getMatchseataray());
		mos.writeInt("dealno", message.getDealno());
		mos.writeInt("meport", message.getMeport());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeString("meip", message.getMeip());
		mos.writeLong("mpid", message.getMpid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, MatchSeatArrayObj message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		// mos.writeInt("ackreq", message.getAckReq());
		// mos.writeLong("id", message.getMsgId());
		// mos.writeString("dest", message.getDest());
		// mos.writeLong("systime", message.getSysTime());
		mos.writeString("result", message.getResult());
		mos.writeLong("matchplayerid", message.getMatchplayerid());
		mos.writeInt("disconprefence", message.getDisconprefence());
		mos.writeObject("player", message.getPlayer());
		mos.writeInt("netvaluecardgains", message.getNetvaluecardgains());
		mos.writeInt("score", message.getScore());
		mos.writeBoolean("recon", message.isRecon());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeInt("seatid", message.getSeatid());
		mos.writeDouble("amountown", message.getAmountown());
		mos.writeString("sessionid", message.getSessionId());
		mos.writeInt("totalgains", message.getTotalgains());
		mos.writeBoolean("autodrop", message.isAutodrop());
		mos.writeBoolean("firstpracticegame", message.isFirstpracticegame());
		mos.writeInt("consmissmovecount", message.getConsmissmovecount());
		mos.writeInt("totalscore", message.getTotalscore());
		mos.writeInt("handcardgain", message.getHandcardgain());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, PlayerObj message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		// mos.writeInt("ackreq", message.getAckReq());
		// mos.writeLong("id", message.getMsgId());
		// mos.writeString("dest", message.getDest());
		// mos.writeLong("systime", message.getSysTime());
		mos.writeBoolean("hasplayedpracticegame",
				message.isHasplayedpracticegame());
		mos.writeInt("status", message.getStatus());
		mos.writeInt("clientvariant", message.getClientvariant());
		mos.writeString("loginid", message.getLoginid());
		mos.writeString("emailid", message.getEmailid());
		mos.writeLong("id", message.getId());
		mos.writeBoolean("hasplayed21cardpracticegame",
				message.isHasplayed21cardpracticegame());
		mos.writeInt("timeofreg", message.getTimeofreg());
		mos.writeInt("absoluterank", message.getAbsoluterank());
		mos.writeLong("idlong", message.getIdlong());
		mos.writeString("rating", message.getRating());
		mos.writeLong("tranchrank", message.getTranchrank());
		mos.writeLong("lastpingreceivedtime", message.getLastpingreceivedtime());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos,
			InvalidFinish21Card message) throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("dbltodclr", message.getDbltodclr());
		mos.writeInt("tnlcnt", message.getTnlcnt());
		mos.writeInt("tnltodclr", message.getTnltodclr());
		mos.writeBoolean("jkrsflag", message.isJkrsflag());
		mos.writeInt("pscount", message.getPscount());
		mos.writeInt("dblcnt", message.getDblcnt());
		mos.writeInt("jkrcnt", message.getJkrcnt());
		mos.writeInt("psreq", message.getPsreq());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeList("grpsinfo", message.getGrpsinfo());
		mos.writeLong("gameid", message.getGameid());
		mos.writeInt("jkrtodclr", message.getJkrtodclr());
		mos.writeBoolean("allvalidsets", message.isAllvalidsets());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, GrpsInfoObj message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		// mos.writeInt("ackreq", message.getAckReq());
		// mos.writeLong("id", message.getMsgId());
		// mos.writeString("dest", message.getDest());
		// mos.writeLong("systime", message.getSysTime());
		mos.writeString("code", message.getCode());
		mos.writeInt("type", message.getType());
		mos.writeList("cards", message.getCards());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, FmgError message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("title", message.getTitle());
		mos.writeString("swfmainpath", message.getSwfmainpath());
		mos.writeString("action", message.getAction());
		mos.writeString("errmsg", message.getErrmsg());
		mos.writeString("fmgparams", message.getFmgparams());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, DisplayMsg message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("msg", message.getMsg());
		mos.writeLong("aaid", message.getAaid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos,
			DisconProtectionPref message) throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("pointsrummy", message.getPointsrummy());
		mos.writeInt("mtt", message.getMtt());
		mos.writeInt("ischecked", message.getIschecked());
		mos.writeInt("pointsrummy21", message.getPointsrummy21());
		mos.writeInt("dealsrummy", message.getDealsrummy());
		mos.writeBoolean("messageshown", message.isMessageshown());
		mos.writeInt("poolrummy", message.getPoolrummy());
		mos.writeBoolean("dppflag", message.isDppflag());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, DisableSplit message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ChatRes message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("playername", message.getPlayername());
		mos.writeString("ctext", message.getCtext());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, BonusIndicator message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("userid", message.getUserid());
		mos.writeString("bonuscode", message.getBonuscode());
		mos.writeDouble("entryfeeperchunk", message.getEntryfeeperchunk());
		mos.writeInt("chunksreleased", message.getChunksreleased());
		mos.writeInt("totalchunks", message.getTotalchunks());
		mos.writeDouble("chunkamount", message.getChunkamount());
		mos.writeInt("daystoexpire", message.getDaystoexpire());
		mos.writeDouble("totalbonusamt", message.getTotalbonusamt());
		mos.writeDouble("remainingbonusamount",
				message.getRemainingbonusamount());
		mos.writeDouble("remainingamttoplayforcurrentchunk",
				message.getRemainingamttoplayforcurrentchunk());
		mos.writeDouble("bonusreleasedincurrentsettlement",
				message.getBonusreleasedincurrentsettlement());
		mos.writeBoolean("bonusactive", message.isBonusactive());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, PendingBonusObj message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		// mos.writeInt("ackreq", message.getAckReq());
		// mos.writeLong("id", message.getMsgId());
		// mos.writeString("dest", message.getDest());
		// mos.writeLong("systime", message.getSysTime());
		mos.writeInt("count", message.getCount());
		mos.writeList("bonuses", message.getBonuses());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, TakeSeatFail message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("msg", message.getMsg());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, Bonuses message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		// mos.writeInt("ackreq", message.getAckReq());
		// mos.writeLong("id", message.getMsgId());
		// mos.writeString("dest", message.getDest());
		// mos.writeLong("systime", message.getSysTime());
		mos.writeString("promocode", message.getPromocode());
		mos.writeString("expirydate", message.getExpirydate());
		mos.writeDouble("maxamount", message.getMaxamount());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, RmValue message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		// mos.writeInt("ackreq", message.getAckReq());
		// mos.writeLong("id", message.getMsgId());
		// mos.writeString("dest", message.getDest());
		// mos.writeLong("systime", message.getSysTime());
		mos.writeString("rmname", message.getRmname());
		mos.writeString("rmnumber", message.getRmnumber());
		mos.writeString("rmemail", message.getRmemail());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, AutoRebuyInSuccess message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeDouble("rebuyinamount", message.getRebuyinamount());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, BuyInFail message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("aaid", message.getAaid());
		mos.writeString("msg", message.getMsg());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ValCardStr message)
			throws IOException {

		mos.writeList("ujokers", message.getUjokers());
		mos.writeList("ljokers", message.getLjokers());
		mos.writeList("marraige", message.getMarraige());
		mos.writeList("jokers", message.getJokers());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, PlayerTxn message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		// mos.writeInt("ackreq", message.getAckReq());
		// mos.writeLong("id", message.getMsgId());
		// mos.writeString("dest", message.getDest());
		// mos.writeLong("systime", message.getSysTime());
		mos.writeLong("toplayer", message.getToplayer());
		mos.writeLong("toplayeruserid", message.getToplayeruserid());
		mos.writeString("fromplayerloginid", message.getFromplayerloginid());
		mos.writeString("toplayerloginid", message.getToplayerloginid());
		mos.writeInt("score", message.getScore());
		mos.writeLong("fromplayeruserid", message.getFromplayeruserid());
		mos.writeLong("fromplayer", message.getFromplayer());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos,
			BonTournamentComplete message) throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("aaid", message.getAaid());
		mos.writeList("winners", message.getWinners());
		mos.writeList("matchidlist", message.getMatchidlist());
		mos.writeLong("tournamentId", message.getTournamentId());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, MECrash message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeString("msg", message.getMsg());
		mos.writeString("title", message.getTitle());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, BreakStructureObj message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeString("id", message.getId());
		mos.writeLong("time", message.getTime());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, MatchCreated message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("aaid", message.getAaid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos,
			PoolTournamentComplete message) throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("aaid", message.getAaid());
		mos.writeList("winners", message.getWinners());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("tournamentId", message.getTournamentId());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, TECrash message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, MatchSetup message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("mplayerid", message.getMplayerid());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, AutoRebuyinPref message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeBoolean("autorebuyinenabled", message.isAutorebuyinenabled());
		mos.writeBoolean("autorebuyindonotshow",
				message.isAutorebuyindonotshow());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ScoresObj message)
			throws IOException {

		mos.writeInt("rank", message.getRank());
		mos.writeString("username", message.getUsername());
		mos.writeDouble("chips", message.getChips());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, RematchRequest message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeBoolean("rematchAccepted", message.isRematchAccepted());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, RematchResponse message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("rematchMessageType", message.getRematchMessageType());
		mos.writeLong("tournamentId", message.getTournamentId());
		mos.writeInt("rematchCountDown", message.getRematchCountDown());
		mos.writeString("playerLoginId", message.getPlayerLoginId());
		mos.writeString("opponentLoginId", message.getOpponentLoginId());
		mos.writeDouble("entreeFee", message.getEntreeFee());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ScoreWindow21Card message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeLong("gameid", message.getGameid());
		mos.writeInt("dealnumber", message.getDealnumber());
		mos.writeList("valcardtxns", message.getValcardtxns());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, AutoRebuyinReq message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeBoolean("autorebuyinenabled", message.isAutorebuyinenabled());
		mos.writeLong("tournamentid", message.getTournamentid());
		mos.writeBoolean("autorebuyindonotshow",
				message.isAutorebuyindonotshow());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, SaveTheme message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeInt("themeid", message.getThemeid());
		mos.writeLong("tournamentid", message.getTournamentid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, MTTScoreCardResp message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("matchid", message.getMatchid());
		mos.writeList("scores", message.getScores());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, MTTScoreListResp message)
			throws IOException {

		mos.writeInt("chips", message.getChips());
		mos.writeString("username", message.getUsername());
		mos.writeInt("rank", message.getRank());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, ChangeTableId message)
			throws IOException {

		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		mos.writeLong("newtableid", message.getNewtableid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, HeartBeat message)
			throws IOException {
		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, HeartBeatResponse message)
			throws IOException {
		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());

		mos.writeInt("lastrecmsgid", message.getLastrecmsgid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, HandShake message)
			throws IOException {
		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());

		// mos.writeString( "ipaddress", message.getIpaddress() );
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, HandShakeResponse message)
			throws IOException {
		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());

		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, MttTableMap message)
			throws IOException {
		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());

		mos.writeLong("tournamentid", message.getTournamentid());
		return mos.toText();
	}

	private String serialize(MessageOutputStream mos, MttTableMapResp message)
			throws IOException {
		mos.writeInt("classID", message.getClassID());
		mos.writeLong("receiverid", message.getReceiverID());
		mos.writeLong("playerid", message.getPlayerID());
		mos.writeString("source", message.getSource());
		mos.writeString("sessionid", message.getSessionId());
		/* mos.writeBoolean("fmg",message.isFmg()); */
		mos.writeInt("ackreq", message.getAckReq());
		mos.writeLong("id", message.getMsgId());
		mos.writeString("dest", message.getDest());
		mos.writeLong("systime", message.getSysTime());

		mos.writeList("mtttableid", message.getMtttableid());
		mos.writeList("mttplayerid", message.getMttplayerid());
		return mos.toText();
	}

	public Frame serialize(Message message) throws IOException {
		return new Frame(message.getClassID(), message.getReceiverID(),
				WSMessageFactory.getFactory().serialize(
						new JSONMessageOutputStream(
								WSMessageFactory.getFactory()), message));
	}

	public Message deserialize(Frame frame) throws IOException {
		return WSMessageFactory.getFactory().deserialize(
				new JSONMessageInputStream(WSMessageFactory.getFactory(),
						frame.getPayload()), frame.getMessageClassID());
	}

	@Override
	public Message deserialize(MessageInputStream mis, int msgClassID)
			throws IOException {
		Message message = null;
		switch (msgClassID) {
		case ACCEPTSPLIT:
			message = new AcceptSplit();
			return deserialize(mis, (AcceptSplit) message);
		case AUTODROP:
			message = new AutoDrop();
			return deserialize(mis, (AutoDrop) message);
		case AUTODROPCANCEL:
			message = new AutoDropCancel();
			return deserialize(mis, (AutoDropCancel) message);
		case AUTOPLAYRES:
			message = new AutoPlayRes();
			return deserialize(mis, (AutoPlayRes) message);
		case BONBONUSUPDATEREQ:
			message = new BONBonusUpdateReq();
			return deserialize(mis, (BONBonusUpdateReq) message);
		case BUYIN:
			message = new BuyIn();
			return deserialize(mis, (BuyIn) message);
		case CHAT:
			message = new Chat();
			return deserialize(mis, (Chat) message);
		case DEALSLEFT:
			message = new DealsLeft();
			return deserialize(mis, (DealsLeft) message);
		case DEALSLEFTRES:
			message = new DealsLeftRes();
			return deserialize(mis, (DealsLeftRes) message);
		case DECLARE:
			message = new Declare();
			return deserialize(mis, (Declare) message);
		case DISCARD:
			message = new Discard();
			return deserialize(mis, (Discard) message);
		case DISCARDCS:
			message = new Discardcs();
			return deserialize(mis, (Discardcs) message);
		case DISCONPROTECTIONPREFUPDATE:
			message = new DisconProtectionPrefUpdate();
			return deserialize(mis, (DisconProtectionPrefUpdate) message);
		case DROP:
			message = new Drop();
			return deserialize(mis, (Drop) message);
		case FINISH:
			message = new Finish();
			return deserialize(mis, (Finish) message);
		case FIRSTCASHGAMEACK:
			message = new FirstCashGameAck();
			return deserialize(mis, (FirstCashGameAck) message);
		case FMGSEARCH:
			message = new FMGSearch();
			return deserialize(mis, (FMGSearch) message);
		case HANDPROGRESSBARSTATE:
			message = new HandProgressBarState();
			return deserialize(mis, (HandProgressBarState) message);
		case INITIATESPLIT:
			message = new InitiateSplit();
			return deserialize(mis, (InitiateSplit) message);
		case LASTDEALREQ:
			message = new LastDealReq();
			return deserialize(mis, (LastDealReq) message);
		case LEAVETABLE:
			message = new LeaveTable();
			return deserialize(mis, (LeaveTable) message);
		case NEWROUNDCONNECTION:
			message = new NewRoundConnection();
			return deserialize(mis, (NewRoundConnection) message);
		case PICKC:
			message = new Pickc();
			return deserialize(mis, (Pickc) message);
		case PICKO:
			message = new Picko();
			return deserialize(mis, (Picko) message);
		case RAP:
			message = new Rap();
			return deserialize(mis, (Rap) message);
		case READY:
			message = new Ready();
			return deserialize(mis, (Ready) message);
		case REBUYIN:
			message = new RebuyIn();
			return deserialize(mis, (RebuyIn) message);
		case RECON:
			message = new Recon();
			return deserialize(mis, (Recon) message);
		case REJECTSPLIT:
			message = new RejectSplit();
			return deserialize(mis, (RejectSplit) message);
		case REJOINSTATUS:
			message = new RejoinStatus();
			return deserialize(mis, (RejoinStatus) message);
		case UPDATETHEME:
			message = new UpdateTheme();
			return deserialize(mis, (UpdateTheme) message);
		case SCORECARD:
			message = new ScoreCard();
			return deserialize(mis, (ScoreCard) message);
		case SETCARDS:
			message = new SetCards();
			return deserialize(mis, (SetCards) message);
		case SETUP:
			message = new Setup();
			return deserialize(mis, (Setup) message);
		case TAKESEAT:
			message = new TakeSeat();
			return deserialize(mis, (TakeSeat) message);
		case THEMEREQ:
			message = new ThemeReq();
			return deserialize(mis, (ThemeReq) message);
		case WITHDRAW:
			message = new Withdraw();
			return deserialize(mis, (Withdraw) message);
		case WITHDRAWREBUY:
			message = new WithdrawRebuy();
			return deserialize(mis, (WithdrawRebuy) message);
		case MOVETIMEOUT:
			message = new MoveTimeout();
			return deserialize(mis, (MoveTimeout) message);
		case OPNCARD:
			message = new OpnCard();
			return deserialize(mis, (OpnCard) message);
		case OPPDECLARE:
			message = new OppDeclare();
			return deserialize(mis, (OppDeclare) message);
		case OPPDISCARD:
			message = new OppDiscard();
			return deserialize(mis, (OppDiscard) message);
		case OPPDROP:
			message = new OppDrop();
			return deserialize(mis, (OppDrop) message);
		case OPPFINISH:
			message = new OppFinish();
			return deserialize(mis, (OppFinish) message);
		case OPPPICKC:
			message = new OppPickC();
			return deserialize(mis, (OppPickC) message);
		case OPPPICKO:
			message = new OppPickO();
			return deserialize(mis, (OppPickO) message);
		case PFINISHRESP:
			message = new PFinishResp();
			return deserialize(mis, (PFinishResp) message);
		case PICKCRES:
			message = new PickcRes();
			return deserialize(mis, (PickcRes) message);
		case PICKORES:
			message = new PickORes();
			return deserialize(mis, (PickORes) message);
		case PLAYERELIMINATED:
			message = new PlayerEliminated();
			return deserialize(mis, (PlayerEliminated) message);
		case PLAYERSCORES:
			message = new PlayerScores();
			return deserialize(mis, (PlayerScores) message);
		case SCORELIST:
			message = new ScoreList();
			return deserialize(mis, (ScoreList) message);
		case PLAYERSEQ:
			message = new PlayerSeq();
			return deserialize(mis, (PlayerSeq) message);
		case PLAYERUPDATE:
			message = new PlayerUpdate();
			return deserialize(mis, (PlayerUpdate) message);
		case SEATS:
			message = new Seats();
			return deserialize(mis, (Seats) message);
		case PLAYER:
			message = new Player();
			return deserialize(mis, (Player) message);
		case PLRDISCONNECT:
			message = new PlrDisconnect();
			return deserialize(mis, (PlrDisconnect) message);
		case PLRHANDCARD:
			message = new PlrHandCard();
			return deserialize(mis, (PlrHandCard) message);
		case PLRMOVE:
			message = new PlrMove();
			return deserialize(mis, (PlrMove) message);
		case PREPAREFORNEXTROUND:
			message = new PrepareForNextRound();
			return deserialize(mis, (PrepareForNextRound) message);
		case PRIZEPOOL:
			message = new PrizePool();
			return deserialize(mis, (PrizePool) message);
		case REBUYWINDOWBAL:
			message = new RebuyWindowBal();
			return deserialize(mis, (RebuyWindowBal) message);
		case REJECTSPLITSUCCESS:
			message = new RejectSplitSuccess();
			return deserialize(mis, (RejectSplitSuccess) message);
		case REJOINFAIL:
			message = new RejoinFail();
			return deserialize(mis, (RejoinFail) message);
		case REJOININGPLAYERELIMINATED:
			message = new RejoiningPlayerEliminated();
			return deserialize(mis, (RejoiningPlayerEliminated) message);
		case REJOINSUCCESS:
			message = new RejoinSuccess();
			return deserialize(mis, (RejoinSuccess) message);
		case RESETCONNECTION:
			message = new ResetConnection();
			return deserialize(mis, (ResetConnection) message);
		case RESHUFFLE:
			message = new Reshuffle();
			return deserialize(mis, (Reshuffle) message);
		case SCORECARDRESP:
			message = new ScoreCardResp();
			return deserialize(mis, (ScoreCardResp) message);
		case SCORELISTRESP:
			message = new ScoreListResp();
			return deserialize(mis, (ScoreListResp) message);
		case SCOREWINDOW:
			message = new ScoreWindow();
			return deserialize(mis, (ScoreWindow) message);
		case SCOREWINDOWVALUE:
			message = new ScoreWindowValue();
			return deserialize(mis, (ScoreWindowValue) message);
		case SCOREWINDOWCHANGE:
			message = new ScoreWindowChange();
			return deserialize(mis, (ScoreWindowChange) message);
		case SEATSETUP:
			message = new SeatSetup();
			return deserialize(mis, (SeatSetup) message);
		case SERVERDISCARD:
			message = new ServerDiscard();
			return deserialize(mis, (ServerDiscard) message);
		case SETUPRES:
			message = new SetupRes();
			return deserialize(mis, (SetupRes) message);
		case SHOWREJOIN:
			message = new ShowRejoin();
			return deserialize(mis, (ShowRejoin) message);
		case SPLITDETAILS:
			message = new SplitDetails();
			return deserialize(mis, (SplitDetails) message);
		case PLAYERLIST:
			message = new PlayerList();
			return deserialize(mis, (PlayerList) message);
		case SPLITSTATUS:
			message = new SplitStatus();
			return deserialize(mis, (SplitStatus) message);
		case SPLITSTATUSPLAYERLIST:
			message = new SplitStatusPlayerList();
			return deserialize(mis, (SplitStatusPlayerList) message);
		case STARTDECLARE:
			message = new StartDeclare();
			return deserialize(mis, (StartDeclare) message);
		case STARTGAMETIMER:
			message = new StartGameTimer();
			return deserialize(mis, (StartGameTimer) message);
		case TAKESEATBAL:
			message = new TakeSeatBal();
			return deserialize(mis, (TakeSeatBal) message);
		case THEMECHANGE:
			message = new ThemeChange();
			return deserialize(mis, (ThemeChange) message);
		case THEME:
			message = new Theme();
			return deserialize(mis, (Theme) message);
		case THEMERES:
			message = new ThemeRes();
			return deserialize(mis, (ThemeRes) message);
		case TIEBREAKER:
			message = new TieBreaker();
			return deserialize(mis, (TieBreaker) message);
		case TOSSCARD:
			message = new TossCard();
			return deserialize(mis, (TossCard) message);
		case TOSSCARDOBJ:
			message = new TossCardObj();
			return deserialize(mis, (TossCardObj) message);
		case TOSSWINNER:
			message = new TossWinner();
			return deserialize(mis, (TossWinner) message);
		case TOURNAMENTCOMPLETE:
			message = new TournamentComplete();
			return deserialize(mis, (TournamentComplete) message);
		case TOURNAMENTINFO:
			message = new TournamentInfo();
			return deserialize(mis, (TournamentInfo) message);
		case TOURNAMENTINFOOBJ:
			message = new TournamentInfoObj();
			return deserialize(mis, (TournamentInfoObj) message);
		case CURRENTROUNDOBJ:
			message = new CurrentRoundObj();
			return deserialize(mis, (CurrentRoundObj) message);
		case RANK:
			message = new Rank();
			return deserialize(mis, (Rank) message);
		case ROUND:
			message = new Round();
			return deserialize(mis, (Round) message);
		case VALCARDSINFO:
			message = new ValCardsInfo();
			return deserialize(mis, (ValCardsInfo) message);
		case VALCARDTXNS:
			message = new ValCardTxns();
			return deserialize(mis, (ValCardTxns) message);
		case WINNERMSG:
			message = new WinnerMsg();
			return deserialize(mis, (WinnerMsg) message);
		case WRONGFINISHPLAYER:
			message = new WrongFinishPlayer();
			return deserialize(mis, (WrongFinishPlayer) message);
		case AAINFO:
			message = new AAInfo();
			return deserialize(mis, (AAInfo) message);
		case GPROPERTY:
			message = new GProperty();
			return deserialize(mis, (GProperty) message);
		case TPROPERTY:
			message = new TProperty();
			return deserialize(mis, (TProperty) message);
		case AASTATUS:
			message = new AAStatus();
			return deserialize(mis, (AAStatus) message);
		case ACCEPTSPLITSUCCESS:
			message = new AcceptSplitSuccess();
			return deserialize(mis, (AcceptSplitSuccess) message);
		case ACK:
			message = new Ack();
			return deserialize(mis, (Ack) message);
		case AMOUNTWON:
			message = new AmountWon();
			return deserialize(mis, (AmountWon) message);
		case AMOUNTWONOBJ:
			message = new AmountWonObj();
			return deserialize(mis, (AmountWonObj) message);
		case AUTODROPCANCELSUCCESS:
			message = new AutoDropCancelSuccess();
			return deserialize(mis, (AutoDropCancelSuccess) message);
		case AUTODROPSTATUS:
			message = new AutoDropStatus();
			return deserialize(mis, (AutoDropStatus) message);
		case AUTODROPSUCCESS:
			message = new AutoDropSuccess();
			return deserialize(mis, (AutoDropSuccess) message);
		case AUTOPLAYREQ:
			message = new AutoPlayReq();
			return deserialize(mis, (AutoPlayReq) message);
		case AUTOPLAYRESPACK:
			message = new AutoPlayRespAck();
			return deserialize(mis, (AutoPlayRespAck) message);
		case BALUPDATE:
			message = new BalUpdate();
			return deserialize(mis, (BalUpdate) message);
		case BALUPDATEOBJ:
			message = new BalUpdateObj();
			return deserialize(mis, (BalUpdateObj) message);
		case BONTOURNAMENTINFO:
			message = new BONTournamentInfo();
			return deserialize(mis, (BONTournamentInfo) message);
		case RANKOBJ:
			message = new RankObj();
			return deserialize(mis, (RankObj) message);
		case BUYINSUCC:
			message = new BuyInSucc();
			return deserialize(mis, (BuyInSucc) message);
		case CLOSEALLCONNECTIONS:
			message = new CloseAllConnections();
			return deserialize(mis, (CloseAllConnections) message);
		case CLOSECONNECTION:
			message = new CloseConnection();
			return deserialize(mis, (CloseConnection) message);
		case CLOSEDDECKSIZE:
			message = new ClosedDeckSize();
			return deserialize(mis, (ClosedDeckSize) message);
		case DEALER:
			message = new Dealer();
			return deserialize(mis, (Dealer) message);
		case DECLARECONF:
			message = new DeclareConf();
			return deserialize(mis, (DeclareConf) message);
		case DECLARERESP:
			message = new DeclareResp();
			return deserialize(mis, (DeclareResp) message);
		case DISCARDRES:
			message = new DiscardRes();
			return deserialize(mis, (DiscardRes) message);
		case DISCARDS:
			message = new DiscardS();
			return deserialize(mis, (DiscardS) message);
		case DISCONPROTECTIONPREFUPDATERES:
			message = new DisconProtectionPrefUpdateRes();
			return deserialize(mis, (DisconProtectionPrefUpdateRes) message);
		case DROPPLAYER:
			message = new DropPlayer();
			return deserialize(mis, (DropPlayer) message);
		case DROPRES:
			message = new DropRes();
			return deserialize(mis, (DropRes) message);
		case ENABLESPLIT:
			message = new EnableSplit();
			return deserialize(mis, (EnableSplit) message);
		case ERRORMSG:
			message = new ErrorMsg();
			return deserialize(mis, (ErrorMsg) message);
		case ERRORPICKO:
			message = new ErrorPickO();
			return deserialize(mis, (ErrorPickO) message);
		case FINISHSTAGE:
			message = new FinishStage();
			return deserialize(mis, (FinishStage) message);
		case GMSETUP:
			message = new GmSetup();
			return deserialize(mis, (GmSetup) message);
		case GMSTATUS:
			message = new GmStatus();
			return deserialize(mis, (GmStatus) message);
		case GRACEMOVE:
			message = new GraceMove();
			return deserialize(mis, (GraceMove) message);
		case HUD:
			message = new Hud();
			return deserialize(mis, (Hud) message);
		case BONUSVALUEOBJ:
			message = new BonusValueObj();
			return deserialize(mis, (BonusValueObj) message);
		case MDROPPLAYER:
			message = new MdropPlayer();
			return deserialize(mis, (MdropPlayer) message);
		case LPINFO:
			message = new LPInfo();
			return deserialize(mis, (LPInfo) message);
		case CLUBINFOARRAYOBJ:
			message = new ClubInfoArrayObj();
			return deserialize(mis, (ClubInfoArrayObj) message);
		case LASTDEALERR:
			message = new LastDealErr();
			return deserialize(mis, (LastDealErr) message);
		case JKRCARD:
			message = new JkrCard();
			return deserialize(mis, (JkrCard) message);
		case MATCHINFO:
			message = new MatchInfo();
			return deserialize(mis, (MatchInfo) message);
		case MATCHSEATARRAYOBJ:
			message = new MatchSeatArrayObj();
			return deserialize(mis, (MatchSeatArrayObj) message);
		case PLAYEROBJ:
			message = new PlayerObj();
			return deserialize(mis, (PlayerObj) message);
		case INVALIDFINISH21CARD:
			message = new InvalidFinish21Card();
			return deserialize(mis, (InvalidFinish21Card) message);
		case GRPSINFOOBJ:
			message = new GrpsInfoObj();
			return deserialize(mis, (GrpsInfoObj) message);
		case FMGERROR:
			message = new FmgError();
			return deserialize(mis, (FmgError) message);
		case DISPLAYMSG:
			message = new DisplayMsg();
			return deserialize(mis, (DisplayMsg) message);
		case DISCONPROTECTIONPREF:
			message = new DisconProtectionPref();
			return deserialize(mis, (DisconProtectionPref) message);
		case DISABLESPLIT:
			message = new DisableSplit();
			return deserialize(mis, (DisableSplit) message);
		case CHATRES:
			message = new ChatRes();
			return deserialize(mis, (ChatRes) message);
		case BONUSINDICATOR:
			message = new BonusIndicator();
			return deserialize(mis, (BonusIndicator) message);
		case PENDINGBONUSOBJ:
			message = new PendingBonusObj();
			return deserialize(mis, (PendingBonusObj) message);
		case TAKESEATFAIL:
			message = new TakeSeatFail();
			return deserialize(mis, (TakeSeatFail) message);
		case BONUSES:
			message = new Bonuses();
			return deserialize(mis, (Bonuses) message);
		case RMVALUE:
			message = new RmValue();
			return deserialize(mis, (RmValue) message);
		case AUTOREBUYINSUCCESS:
			message = new AutoRebuyInSuccess();
			return deserialize(mis, (AutoRebuyInSuccess) message);
		case BUYINFAIL:
			message = new BuyInFail();
			return deserialize(mis, (BuyInFail) message);
		case VALCARDSTR:
			message = new ValCardStr();
			return deserialize(mis, (ValCardStr) message);
		case PLAYERTXN:
			message = new PlayerTxn();
			return deserialize(mis, (PlayerTxn) message);
		case BONTOURNAMENTCOMPLETE:
			message = new BonTournamentComplete();
			return deserialize(mis, (BonTournamentComplete) message);
		case MECRASH:
			message = new MECrash();
			return deserialize(mis, (MECrash) message);
		case BREAKSTRUCTUREOBJ:
			message = new BreakStructureObj();
			return deserialize(mis, (BreakStructureObj) message);
		case MATCHCREATED:
			message = new MatchCreated();
			return deserialize(mis, (MatchCreated) message);
		case POOLTOURNAMENTCOMPLETE:
			message = new PoolTournamentComplete();
			return deserialize(mis, (PoolTournamentComplete) message);
		case TECRASH:
			message = new TECrash();
			return deserialize(mis, (TECrash) message);
		case MATCHSETUP:
			message = new MatchSetup();
			return deserialize(mis, (MatchSetup) message);
		case AUTOREBUYINPREF:
			message = new AutoRebuyinPref();
			return deserialize(mis, (AutoRebuyinPref) message);
		case SCORESOBJ:
			message = new ScoresObj();
			return deserialize(mis, (ScoresObj) message);
		case REMATCHREQUEST:
			message = new RematchRequest();
			return deserialize(mis, (RematchRequest) message);
		case REMATCHRESPONSE:
			message = new RematchResponse();
			return deserialize(mis, (RematchResponse) message);
		case SCOREWINDOW21CARD:
			message = new ScoreWindow21Card();
			return deserialize(mis, (ScoreWindow21Card) message);
		case AUTOREBUYINREQ:
			message = new AutoRebuyinReq();
			return deserialize(mis, (AutoRebuyinReq) message);
		case SAVETHEME:
			message = new SaveTheme();
			return deserialize(mis, (SaveTheme) message);
		case MTTSCORECARDRESP:
			message = new MTTScoreCardResp();
			return deserialize(mis, (MTTScoreCardResp) message);
		case MTTSCORELISTRESP:
			message = new MTTScoreListResp();
			return deserialize(mis, (MTTScoreListResp) message);
		case CHANGETABLEID:
			message = new ChangeTableId();
			return deserialize(mis, (ChangeTableId) message);

		case HEARTBEAT:
			message = new HeartBeat();
			return deserialize(mis, (HeartBeat) message);
		case HEARTBEATRESPONSE:
			message = new HeartBeatResponse();
			return deserialize(mis, (HeartBeatResponse) message);
		case HANDSHAKE:
			message = new HandShake();
			return deserialize(mis, (HandShake) message);
		case HANDSHAKERESPONSE:
			message = new HandShakeResponse();
			return deserialize(mis, (HandShakeResponse) message);
		case MTTTABLEMAP:
			message = new MttTableMap();
			return deserialize(mis, (MttTableMap) message);
		case MTTTABLEMAPRESP:
			message = new MttTableMapResp();
			return deserialize(mis, (MttTableMapResp) message);
		case FMGRESPONSE:
			message = new FMGResponse();
			return deserialize(mis, (FMGResponse) message);

		}
		return message;
	}

	private Message deserialize(MessageInputStream mis, FMGResponse message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));
		message.setAaid(mis.readLong("aaid"));
		message.setTournamentId(mis.readLong("tournamentId"));
		message.setMaxplayer(mis.readInt("maxplayer"));
		message.setErrorMessage(mis.readString("errorMessage"));
		message.setStatus(mis.readInt("status"));
		message.setFmgOnTable(mis.readBoolean("fmgOnTable"));

		return message;
	}

	private Message deserialize(MessageInputStream mis, AcceptSplit message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		return message;
	}

	private Message deserialize(MessageInputStream mis, AutoDrop message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMplayerid(mis.readLong("mplayerid"));
		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, AutoDropCancel message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		return message;
	}

	private Message deserialize(MessageInputStream mis, AutoPlayRes message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMid(mis.readLong("mid"));
		message.setMpid(mis.readLong("mpid"));
		message.setIsautoplay(mis.readBoolean("isautoplay"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			BONBonusUpdateReq message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		return message;
	}

	private Message deserialize(MessageInputStream mis, BuyIn message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setCustomamnt(mis.readDouble("customamnt"));
		message.setBal(mis.readDouble("bal"));
		message.setTablemin(mis.readDouble("tablemin"));
		message.setSeatid(mis.readInt("seatid"));
		message.setTablemax(mis.readDouble("tablemax"));
		message.setClientvariant(mis.readInt("clientvariant"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Chat message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setCtext(mis.readString("ctext"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, DealsLeft message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		return message;
	}

	private Message deserialize(MessageInputStream mis, DealsLeftRes message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setDealsleft(mis.readInt("dealsleft"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Declare message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMpid(mis.readLong("mpid"));
		message.setMid(mis.readLong("mid"));
		message.setCards((List<List<String>>) mis.readList("cards"));
		message.setTopgroupscount(mis.readInt("topgroupscount"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Discard message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setCardid(mis.readString("cardid"));
		message.setMpid(mis.readLong("mpid"));
		message.setMid(mis.readLong("mid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Discardcs message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setCards(mis.readString("cards"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			DisconProtectionPrefUpdate message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setPoolrummy(mis.readInt("poolrummy"));
		message.setPointsrummy21(mis.readInt("pointsrummy21"));
		message.setMessageshown(mis.readBoolean("messageshown"));
		message.setIschecked(mis.readInt("ischecked"));
		message.setPointsrummy(mis.readInt("pointsrummy"));
		message.setMtt(mis.readInt("mtt"));
		message.setDealsrummy(mis.readInt("dealsrummy"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Drop message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMpid(mis.readLong("mpid"));
		message.setMid(mis.readLong("mid"));
		message.setAutodrop(mis.readBoolean("autodrop"));
		message.setMdrop(mis.readBoolean("mdrop"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Finish message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setCardid(mis.readString("cardid"));
		message.setMpid(mis.readLong("mpid"));
		message.setMid(mis.readLong("mid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, FirstCashGameAck message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		return message;
	}

	private Message deserialize(MessageInputStream mis, FMGSearch message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setFmgparams(mis.readString("fmgparams"));
		message.setFmg(mis.readString("fmg"));
		message.setLastte(mis.readInt("lastte"));
		message.setPptip(mis.readString("pptip"));
		message.setClientvariant(mis.readInt("clientvariant"));
		message.setOldtid(mis.readLong("oldtid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			HandProgressBarState message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setProgressbarmax(mis.readBoolean("progressbarmax"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, InitiateSplit message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		return message;
	}

	private Message deserialize(MessageInputStream mis, LastDealReq message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		return message;
	}

	private Message deserialize(MessageInputStream mis, LeaveTable message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMplayerid(mis.readLong("mplayerid"));
		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			NewRoundConnection message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setFmgparams(mis.readString("fmgparams"));
		message.setSessionId(mis.readString("sessionid"));
		message.setClientvariant(mis.readInt("clientvariant"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Pickc message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMpid(mis.readLong("mpid"));
		message.setMid(mis.readLong("mid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Picko message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMpid(mis.readLong("mpid"));
		message.setMid(mis.readLong("mid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Rap message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setCategory(mis.readString("category"));
		message.setMatchid(mis.readLong("matchid"));
		message.setPtext(mis.readString("ptext"));
		message.setGameid(mis.readLong("gameid"));
		message.setTournamentid(mis.readLong("tournamentid"));
		message.setSettlementtype(mis.readInt("settlementtype"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Ready message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		return message;
	}

	private Message deserialize(MessageInputStream mis, RebuyIn message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setSeatid(mis.readInt("seatid"));
		message.setBal(mis.readDouble("bal"));
		message.setTablemax(mis.readDouble("tablemax"));
		message.setTablemin(mis.readDouble("tablemin"));
		message.setCustomamnt(mis.readDouble("customamnt"));
		message.setClientvariant(mis.readInt("clientvariant"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Recon message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setFmgparams(mis.readString("fmgparams"));
		message.setSessionId(mis.readString("sessionid"));
		message.setPptip(mis.readString("pptip"));
		message.setClientvariant(mis.readInt("clientvariant"));
		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setMplayerid(mis.readLong("mplayerid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, RejectSplit message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		return message;
	}

	private Message deserialize(MessageInputStream mis, RejoinStatus message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setStatus(mis.readBoolean("status"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, UpdateTheme message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setTableid(mis.readLong("tableid"));
		message.setThemeid(mis.readInt("themeid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, ScoreCard message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		return message;
	}

	private Message deserialize(MessageInputStream mis, SetCards message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMpid(mis.readLong("mpid"));
		message.setMid(mis.readLong("mid"));
		message.setCards((List<List<String>>) mis.readList("cards"));
		message.setTopgroupscount(mis.readInt("topgroupscount"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Setup message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setSessionId(mis.readString("sessionid"));
		message.setFmgparams(mis.readString("fmgparams"));
		message.setClientvariant(mis.readInt("clientvariant"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, TakeSeat message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setSeatid(mis.readInt("seatid"));
		message.setPptip(mis.readString("pptip"));
		message.setClientvariant(mis.readInt("clientvariant"));
		message.setEntryfee(mis.readDouble("entryfee"));
		message.setInprogress(mis.readInt("inprogress"));
		message.setLoginid(mis.readString("loginid"));
		message.setSessionId(mis.readString("sessionid"));
		message.setLastte(mis.readInt("lastte"));
		message.setHashstr(mis.readString("hashstr"));
		message.setAaid(mis.readLong("aaid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, ThemeReq message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setGame(mis.readString("game"));
		message.setValue(mis.readInt("value"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Withdraw message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setSeatid(mis.readInt("seatid"));
		message.setSessionId(mis.readString("sessionid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, WithdrawRebuy message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setSeatid(mis.readInt("seatid"));
		message.setSessionId(mis.readString("sessionid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, MoveTimeout message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setMplayerid(mis.readLong("mplayerid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, OpnCard message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setCardid(mis.readString("cardid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, OppDeclare message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setSucc(mis.readInt("succ"));
		message.setScore(mis.readInt("score"));
		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setMplayerid(mis.readLong("mplayerid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, OppDiscard message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setMplayerid(mis.readLong("mplayerid"));
		message.setCardid(mis.readString("cardid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, OppDrop message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setPoint(mis.readInt("point"));
		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setMplayerid(mis.readLong("mplayerid"));
		message.setMdrop(mis.readInt("mdrop"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, OppFinish message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setExtratime(mis.readLong("extratime"));
		message.setTimetodeclare(mis.readLong("timetodeclare"));
		message.setMatchid(mis.readLong("matchid"));
		message.setTotaltimetodeclare(mis.readLong("totaltimetodeclare"));
		message.setGameid(mis.readLong("gameid"));
		message.setMplayerid(mis.readLong("mplayerid"));
		message.setCardid(mis.readString("cardid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, OppPickC message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setMplayerid(mis.readLong("mplayerid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, OppPickO message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setNextocardid(mis.readString("nextocardid"));
		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setMplayerid(mis.readLong("mplayerid"));
		message.setCardid(mis.readString("cardid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, PFinishResp message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setTimetodeclare(mis.readLong("timetodeclare"));
		message.setTotaltimetodeclare(mis.readLong("totaltimetodeclare"));
		message.setExtratime(mis.readLong("extratime"));
		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setMplayerid(mis.readLong("mplayerid"));
		message.setCardid(mis.readString("cardid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, PickcRes message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setCardid(mis.readString("cardid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, PickORes message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setNextocardid(mis.readString("nextocardid"));
		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setCardid(mis.readString("cardid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, PlayerEliminated message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setTitle(mis.readString("title"));
		message.setBalanceverifed(mis.readBoolean("balanceverifed"));
		message.setIsactive(mis.readBoolean("isactive"));
		message.setShowfmgflag(mis.readBoolean("showfmgflag"));
		message.setMsg(mis.readString("msg"));
		message.setRank(mis.readInt("rank"));
		message.setTranchrank(mis.readInt("tranchrank"));
		message.setInitiateRematch(mis.readBoolean("initiateRematch"));
		message.setEntryFee(mis.readDouble("entryFee"));
		message.setRematchCountDown(mis.readInt("rematchCountDown"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, PlayerScores message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setMid(mis.readLong("mid"));
		message.setGameid(mis.readLong("gameid"));
		message.setScorelist((List<ScoreList>) mis.readList("scorelist"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, ScoreList message)
			throws IOException {

		message.setScore(mis.readLong("score"));
		message.setLoginid(mis.readString("loginid"));
		message.setTotalscore(mis.readLong("totalscore"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, PlayerSeq message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setOrderedmplayerids((List<Long>) mis
				.readList("orderedmplayerids"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, PlayerUpdate message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setAaid(mis.readLong("aaid"));
		message.setSeats((List<Seats>) mis.readList("seats"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Seats message)
			throws IOException {

		message.setId(mis.readInt("id"));
		message.setSeatedout(mis.readBoolean("seatedout"));
		message.setState(mis.readInt("state"));
		message.setSeatplayerbalance(mis.readDouble("seatplayerbalance"));
		message.setPlayerscore(mis.readInt("playerscore"));
		message.setAutodrop(mis.readBoolean("autodrop"));
		message.setPlayer((Player) mis.readObject("player"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Player message)
			throws IOException {

		message.setHasplayedpracticegame(mis
				.readBoolean("hasplayedpracticegame"));
		message.setStatus(mis.readInt("status"));
		message.setClientvariant(mis.readInt("clientvariant"));
		message.setLoginid(mis.readString("loginid"));
		message.setEmailid(mis.readString("emailid"));
		message.setId(mis.readLong("id"));
		message.setHasplayed21cardpracticegame(mis
				.readBoolean("hasplayed21cardpracticegame"));
		message.setTimeofreg(mis.readLong("timeofreg"));
		message.setAbsoluterank(mis.readInt("absoluterank"));
		message.setIdlong(mis.readLong("idlong"));
		message.setRating(mis.readString("rating"));
		message.setTranchrank(mis.readInt("tranchrank"));
		message.setLastpingreceivedtime(mis.readLong("lastpingreceivedtime"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, PlrDisconnect message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setPlayerid((List<Long>) mis.readList("playerid"));
		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, PlrHandCard message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setCards((List<List<String>>) mis.readList("cards"));
		message.setTopgroupscount(mis.readInt("topgroupscount"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, PlrMove message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setTotalgracetime(mis.readLong("totalgracetime"));
		message.setGracetime(mis.readLong("gracetime"));
		message.setMovetime(mis.readLong("movetime"));
		message.setIsfirstmove(mis.readBoolean("isfirstmove"));
		message.setMoveno(mis.readInt("moveno"));
		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setMplayerid(mis.readLong("mplayerid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			PrepareForNextRound message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setRoundnumber(mis.readInt("roundnumber"));
		message.setNextroundstarttime(mis.readLong("nextroundstarttime"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, PrizePool message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setPrize(mis.readDouble("prize"));
		message.setAaid(mis.readLong("aaid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, RebuyWindowBal message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setBal(mis.readDouble("bal"));
		message.setTimer(mis.readLong("timer"));
		message.setTablemax(mis.readDouble("tablemax"));
		message.setTablemin(mis.readDouble("tablemin"));
		message.setRebuy(mis.readBoolean("rebuy"));
		message.setSeats((List<Seats>) mis.readList("seats"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			RejectSplitSuccess message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setAaid(mis.readLong("aaid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, RejoinFail message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMsg(mis.readString("msg"));
		message.setTitle(mis.readString("title"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			RejoiningPlayerEliminated message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setTitle(mis.readString("title"));
		message.setBalanceverifed(mis.readBoolean("balanceverifed"));
		message.setIsactive(mis.readBoolean("isactive"));
		message.setShowfmgflag(mis.readBoolean("showfmgflag"));
		message.setMsg(mis.readString("msg"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, RejoinSuccess message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setTitle(mis.readString("title"));
		message.setRejoinscore(mis.readInt("rejoinscore"));
		message.setMsg(mis.readString("msg"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, ResetConnection message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setNexttableid(mis.readLong("nexttableid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Reshuffle message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setSize(mis.readInt("size"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, ScoreCardResp message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setAaid(mis.readLong("aaid"));
		message.setMatchid(mis.readLong("matchid"));
		message.setScorelist((List<ScoreListResp>) mis.readList("scorelist"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, ScoreListResp message)
			throws IOException {

		message.setScores((List<String>) mis.readList("scores"));
		message.setLoginid(mis.readString("loginid"));
		message.setTotal(mis.readInt("total"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, ScoreWindow message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setDealnumber(mis.readInt("dealnumber"));
		message.setJoker(mis.readString("joker"));
		message.setLastdeal(mis.readBoolean("lastdeal"));
		message.setScorewindow((List<ScoreWindowValue>) mis
				.readList("scorewindow"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, ScoreWindowValue message)
			throws IOException {

		message.setMessage(mis.readString("message"));
		message.setResult(mis.readString("result"));
		message.setTopgroupscount(mis.readInt("topgroupscount"));
		message.setUsername(mis.readString("username"));
		message.setScore(mis.readInt("score"));
		message.setMplayerid(mis.readLong("mplayerid"));
		message.setLoginid(mis.readString("loginid"));
		message.setHandcardgain(mis.readInt("handcardgain"));
		message.setValuecardstr((ValCardStr) mis.readObject("valuecardstr"));
		message.setId(mis.readLong("id"));
		message.setCards((List<List<String>>) mis.readList("cards"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			ScoreWindowChange message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setPlayerresult((ScoreWindowValue) mis
				.readObject("playerresult"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, SeatSetup message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setAaid(mis.readLong("aaid"));
		message.setSeats((List<Seats>) mis.readList("seats"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, ServerDiscard message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setCardid(mis.readString("cardid"));
		message.setWrongf(mis.readBoolean("wrongf"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, SetupRes message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setBreplayer(mis.readBoolean("breplayer"));
		message.setMp(mis.readInt("mp"));
		message.setTableid(mis.readLong("tableid"));
		message.setSwfmainpath(mis.readString("swfmainpath"));
		message.setBgimgurl(mis.readString("bgimgurl"));
		message.setAaid(mis.readLong("aaid"));
		message.setChatblocked(mis.readBoolean("chatblocked"));
		message.setConifgfilepath(mis.readString("conifgfilepath"));
		message.setMaxplayer(mis.readInt("maxplayer"));
		message.setShowfmg(mis.readBoolean("showfmg"));
		message.setMttChatBlock(mis.readBoolean("mttChatBlock"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, ShowRejoin message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setTitle(mis.readString("title"));
		message.setBal(mis.readDouble("bal"));
		message.setRemainingtimeforrejoin(mis
				.readLong("remainingtimeforrejoin"));
		message.setRejoinscore(mis.readInt("rejoinscore"));
		message.setAaid(mis.readLong("aaid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, SplitDetails message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setTotalprize(mis.readDouble("totalprize"));
		message.setTimer(mis.readDouble("timer"));
		message.setInitiatedby(mis.readString("initiatedby"));
		message.setAaid(mis.readLong("aaid"));
		message.setPlayerlist((List<PlayerList>) mis.readList("playerlist"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, PlayerList message)
			throws IOException {

		message.setAmount(mis.readDouble("amount"));
		message.setDropsremaining(mis.readInt("dropsremaining"));
		message.setLoginid(mis.readString("loginid"));
		message.setTotalscore(mis.readInt("totalscore"));
		message.setStatus(mis.readString("status"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, SplitStatus message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setAaid(mis.readLong("aaid"));
		message.setPlayerlist((List<SplitStatusPlayerList>) mis
				.readList("playerlist"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			SplitStatusPlayerList message) throws IOException {

		message.setLoginid(mis.readString("loginid"));
		message.setStatus(mis.readString("status"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, StartDeclare message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setTimetodeclare(mis.readLong("timetodeclare"));
		message.setTotalgracetime(mis.readLong("totalgracetime"));
		message.setGracetime(mis.readLong("gracetime"));
		message.setMatchid(mis.readLong("matchid"));
		message.setTotaltimetodeclare(mis.readLong("totaltimetodeclare"));
		message.setGameid(mis.readLong("gameid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, StartGameTimer message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setTimer(mis.readLong("timer"));
		message.setAaid(mis.readLong("aaid"));
		message.setRejoiningplayerarray((List<String>) mis
				.readList("rejoiningplayerarray"));
		message.setSessionId(mis.readString("sessionid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, TakeSeatBal message)
			throws IOException {
		System.out
				.println("***************************************************************takeseat bal");
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setBal(mis.readDouble("bal"));
		message.setTimer(mis.readLong("timer"));
		message.setTablemax(mis.readDouble("tablemax"));
		message.setTablemin(mis.readDouble("tablemin"));
		message.setRebuy(mis.readBoolean("rebuy"));
		message.setSeats((List<Seats>) mis.readList("seats"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, ThemeChange message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setTheme((List<Theme>) mis.readList("theme"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Theme message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */

		message.setId(mis.readInt("id"));
		message.setThumbimage(mis.readString("thumbimage"));
		message.setName(mis.readString("name"));
		message.setBigimage(mis.readString("bigimage"));
		message.setConfigfile(mis.readString("configfile"));
		message.setDealtype(mis.readInt("dealtype"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, ThemeRes message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setSwfmainpath(mis.readString("swfmainpath"));
		message.setConfigfilepath(mis.readString("configfilepath"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, TieBreaker message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setTienumber(mis.readInt("tienumber"));
		message.setIscurrent(mis.readBoolean("iscurrent"));
		message.setTietype(mis.readInt("tietype"));
		message.setPlayers((List<String>) mis.readList("players"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, TossCard message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setTosscardarry((List<TossCardObj>) mis
				.readList("tosscardarry"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, TossCardObj message)
			throws IOException {

		message.setMplayerid(mis.readLong("mplayerid"));
		message.setGameid(mis.readLong("gameid"));
		message.setCardid(mis.readString("cardid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, TossWinner message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMplayerid(mis.readLong("mplayerid"));
		message.setGameid(mis.readLong("gameid"));
		message.setMatchid(mis.readLong("matchid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			TournamentComplete message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		return message;
	}

	private Message deserialize(MessageInputStream mis, TournamentInfo message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setTotalprize(mis.readDouble("totalprize"));
		message.setHasticket(mis.readBoolean("hasticket"));
		message.setTournamentinfo((TournamentInfoObj) mis
				.readObject("tournamentinfo"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			TournamentInfoObj message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */

		message.setRoundtotaltime(mis.readInt("roundtotaltime"));
		message.setTournamentname(mis.readString("tournamentname"));
		message.setBreakstructure((List<BreakStructureObj>) mis
				.readList("breakstructure"));
		message.setCurrentround((CurrentRoundObj) mis
				.readObject("currentround"));
		message.setRounds((List<Round>) mis.readList("rounds"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, CurrentRoundObj message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMaxdeals(mis.readInt("maxdeals"));
		message.setInprogresstime(mis.readLong("inprogresstime"));
		message.setDealmultiplier(mis.readInt("dealmultiplier"));
		message.setNumber(mis.readInt("number"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Rank message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */

		message.setRank(mis.readInt("rank"));
		message.setStatus(mis.readInt("status"));
		message.setCashprize(mis.readDouble("cashprize"));
		message.setHasticket(mis.readBoolean("hasticket"));
		message.setTicketid(mis.readInt("ticketid"));
		message.setTicketname(mis.readString("ticketname"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Round message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */

		message.setQualifiers(mis.readInt("qualifiers"));
		message.setRoundnum(mis.readInt("roundnum"));
		message.setName(mis.readString("name"));
		message.setPrizes(mis.readInt("prizes"));
		message.setRanks((List<Rank>) mis.readList("ranks"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, ValCardsInfo message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setLastdeal(mis.readBoolean("lastdeal"));
		message.setLoginid(mis.readString("loginid"));
		message.setValcardtxns((ValCardTxns) mis.readObject("valcardtxns"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, ValCardTxns message)
			throws IOException {

		message.setPointsgiven(mis.readInt("pointsgiven"));
		message.setPointsrcd(mis.readInt("pointsrcd"));
		message.setNetvaluecardgains(mis.readInt("netvaluecardgains"));
		message.setValuecardstr((ValCardStr) mis.readObject("valuecardstr"));
		message.setUserid(mis.readLong("userid"));
		message.setLoginid(mis.readString("loginid"));
		message.setPlayertxns((List<PlayerTxn>) mis.readList("playertxns"));
		message.setHandCardGain(mis.readInt("handCardGain"));
		message.setStatus(mis.readString("status"));
		message.setCards((List<List<String>>) mis.readList("cards"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, WinnerMsg message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setRank(mis.readInt("rank"));
		message.setAmount(mis.readDouble("amount"));
		message.setSplit(mis.readBoolean("split"));
		message.setShowfmgflag(mis.readBoolean("showfmgflag"));
		message.setIsactive(mis.readBoolean("isactive"));
		message.setBalanceverifed(mis.readBoolean("balanceverifed"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			WrongFinishPlayer message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setPlayers((List<Long>) mis.readList("players"));
		message.setScore(mis.readInt("score"));
		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, AAInfo message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setGproperty((GProperty) mis.readObject("gproperty"));
		message.setTproperty((TProperty) mis.readObject("tproperty"));
		message.setAanum(mis.readInt("aanum"));
		message.setGametype(mis.readString("gametype"));
		message.setAaid(mis.readLong("aaid"));
		message.setProgressbarmax(mis.readBoolean("progressbarmax"));
		message.setPrizetype(mis.readInt("prizetype"));
		message.setMultiplier(mis.readInt("multiplier"));
		message.setRewardpointsvalue(mis.readInt("rewardpointsvalue"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, GProperty message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */

		message.setMovetime(mis.readInt("movetime"));
		message.setNoofdeck(mis.readInt("noofdeck"));
		message.setFullcountcfp(mis.readInt("fullcountcfp"));
		message.setMaxbuyinmultiplier21cardcfp(mis
				.readInt("maxbuyinmultiplier21cardcfp"));
		message.setNoofdubleestobesafe21cardcfp(mis
				.readInt("noofdubleestobesafe21cardcfp"));
		message.setMaxplayer(mis.readInt("maxplayer"));
		message.setBlockedwords(mis.readInt("blockedwords"));
		message.setExtratime(mis.readLong("extratime"));
		message.setNooftunnelastodeclare21cardcfp(mis
				.readInt("nooftunnelastodeclare21cardcfp"));
		message.setRptplmobserver(mis.readInt("rptplmobserver"));
		message.setMvtimefirstplayer(mis.readLong("mvtimefirstplayer"));
		message.setNoofcardtodeal(mis.readInt("noofcardtodeal"));
		message.setDeclaretime(mis.readLong("declaretime"));
		message.setDealbetweentime(mis.readInt("dealbetweentime"));
		message.setPrizetype(mis.readInt("prizetype"));
		message.setTosstimeout(mis.readLong("tosstimeout"));
		message.setCardperpureseq(mis.readInt("cardperpureseq"));
		message.setMissedmovesdrop(mis.readInt("missedmovesdrop"));
		message.setFirstdropcfp(mis.readInt("firstdropcfp"));
		message.setPrintedjokersperdeck(mis.readInt("printedjokersperdeck"));
		message.setObserverchat(mis.readInt("observerchat"));
		message.setSettlementtype(mis.readInt("settlementtype"));
		message.setMinpointvalue21cardcfp(mis.readInt("minpointvalue21cardcfp"));
		message.setMaxpointvalue21cardcfp(mis.readInt("maxpointvalue21cardcfp"));
		message.setAutoplaytimeout(mis.readLong("autoplaytimeout"));
		message.setTimebtwround(mis.readInt("timebtwround"));
		message.setNoofdubleestodeclare21cardcfp(mis
				.readInt("noofdubleestodeclare21cardcfp"));
		message.setSitouttimeout(mis.readLong("sitouttimeout"));
		message.setSafescoreonplayerdeclaration21cardcfp(mis
				.readInt("safescoreonplayerdeclaration21cardcfp"));
		message.setAutoemail(mis.readBoolean("autoemail"));
		message.setJokertype(mis.readInt("jokertype"));
		message.setExtratimechunk(mis.readLong("extratimechunk"));
		message.setMiddledropcfp(mis.readInt("middledropcfp"));
		message.setNoofjokerstodeclare21cardcfp(mis
				.readInt("noofjokerstodeclare21cardcfp"));
		message.setNoofjokerstobesafe21cardcfp(mis
				.readInt("noofjokerstobesafe21cardcfp"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, TProperty message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */

		message.setSplittimeout(mis.readLong("splittimeout"));
		message.setEntryfee(mis.readDouble("entryfee"));
		message.setRejointimeout(mis.readLong("rejointimeout"));
		message.setSettlementtype(mis.readInt("settlementtype"));
		message.setTypezeroentryfeelimit(mis
				.readDouble("typezeroentryfeelimit"));
		message.setMaxbuyin(mis.readDouble("maxbuyin"));
		message.setPointvalue(mis.readDouble("pointvalue"));
		message.setServicefee(mis.readDouble("servicefee"));
		message.setMindropsforsplit(mis.readInt("mindropsforsplit"));
		message.setMaxplayer(mis.readInt("maxplayer"));
		message.setSplitallowed(mis.readBoolean("splitallowed"));
		message.setRejoinallowed(mis.readBoolean("rejoinallowed"));
		message.setPoolmaxscore(mis.readInt("poolmaxscore"));
		message.setCountinbtwmatch(mis.readLong("countinbtwmatch"));
		message.setBuyintimeout(mis.readLong("buyintimeout"));
		message.setName(mis.readString("name"));
		message.setMindealtoplay(mis.readInt("mindealtoplay"));
		message.setServicefeetype(mis.readInt("servicefeetype"));
		message.setPrizetype(mis.readInt("prizetype"));
		message.setCountdwnstartgame(mis.readLong("countdwnstartgame"));
		message.setMinbuyin(mis.readDouble("minbuyin"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, AAStatus message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setAastatus(mis.readInt("aastatus"));
		message.setAaid(mis.readLong("aaid"));
		message.setMaxplayer(mis.readLong("maxplayer"));
		message.setDealnumber(mis.readInt("dealnumber"));
		message.setRoundnumber(mis.readInt("roundnumber"));
		message.setTiebreaker(mis.readBoolean("tiebreaker"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			AcceptSplitSuccess message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setAaid(mis.readLong("aaid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Ack message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setLastrecmsgid(mis.readLong("lastrecmsgid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, AmountWon message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setAmountownlist((List<AmountWonObj>) mis
				.readList("amountownlist"));
		message.setLastdeal(mis.readBoolean("lastdeal"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, AmountWonObj message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */

		message.setAmount(mis.readDouble("amount"));
		message.setLoginid(mis.readString("loginid"));
		message.setTotalscore(mis.readInt("totalscore"));
		message.setTablebal(mis.readDouble("tablebal"));
		message.setMpid(mis.readLong("mpid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			AutoDropCancelSuccess message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setAaid(mis.readLong("aaid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, AutoDropStatus message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setMid(mis.readLong("mid"));
		message.setGameid(mis.readLong("gameid"));
		message.setAutodrop(mis.readBoolean("autodrop"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, AutoDropSuccess message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setAaid(mis.readLong("aaid"));
		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, AutoPlayReq message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setTime(mis.readLong("time"));
		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, AutoPlayRespAck message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setIsautoplay(mis.readBoolean("isautoplay"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, BalUpdate message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setAaid(mis.readLong("aaid"));
		message.setBalarray((List<BalUpdateObj>) mis.readList("balarray"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, BalUpdateObj message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */

		message.setBal(mis.readDouble("bal"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			BONTournamentInfo message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setRanks((List<RankObj>) mis.readList("ranks"));
		message.setTotaldeals(mis.readInt("totaldeals"));
		message.setTotalprize(mis.readDouble("totalprize"));
		message.setNumofprizes(mis.readInt("numofprizes"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, RankObj message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setRank(mis.readInt("rank"));
		message.setCashprize(mis.readDouble("cashprize"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, BuyInSucc message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setAaid(mis.readLong("aaid"));
		message.setSessionId(mis.readString("sessionid"));
		message.setRebuy(mis.readBoolean("rebuy"));
		message.setFirst21cardpracticegame(mis
				.readBoolean("first21cardpracticegame"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			CloseAllConnections message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setAaid(mis.readLong("aaid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, CloseConnection message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setMid(mis.readLong("mid"));
		message.setGameid(mis.readLong("gameid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, ClosedDeckSize message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setSize(mis.readLong("size"));
		message.setGameid(mis.readLong("gameid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Dealer message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setMplayerid(mis.readLong("mplayerid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, DeclareConf message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setMplayerid(mis.readLong("mplayerid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, DeclareResp message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setMplayerid(mis.readLong("mplayerid"));
		message.setSucc(mis.readInt("succ"));
		message.setScore(mis.readInt("score"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, DiscardRes message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setCardid(mis.readString("cardid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, DiscardS message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setCards((List<String>) mis.readList("cards"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			DisconProtectionPrefUpdateRes message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setFlag(mis.readBoolean("flag"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, DropPlayer message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setPlayers((List<Long>) mis.readList("players"));
		message.setScore(mis.readInt("score"));
		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, DropRes message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMessage(mis.readString("message"));
		message.setPoint(mis.readInt("point"));
		message.setResult(mis.readInt("result"));
		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setMdrop(mis.readInt("mdrop"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, EnableSplit message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setAaid(mis.readLong("aaid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, ErrorMsg message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMsgid(mis.readInt("msgid"));
		message.setTitle(mis.readString("title"));
		message.setBootout(mis.readBoolean("bootout"));
		message.setMsg(mis.readString("msg"));
		message.setAaid(mis.readLong("aaid"));
		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, ErrorPickO message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setMsg(mis.readString("msg"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, FinishStage message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setFcard(mis.readString("fcard"));
		message.setShowdeclare(mis.readInt("showdeclare"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, GmSetup message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setIsfirstpracticegame(mis.readBoolean("isfirstpracticegame"));
		message.setCurrdeal(mis.readInt("currdeal"));
		message.setStarttime(mis.readLong("starttime"));
		message.setMatchid(mis.readLong("matchid"));
		message.setMaxdeal(mis.readInt("maxdeal"));
		message.setGameid(mis.readLong("gameid"));
		message.setMovenumber(mis.readInt("movenumber"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, GmStatus message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setStatusid(mis.readInt("statusid"));
		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, GraceMove message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setTotalgracetime(mis.readLong("totalgracetime"));
		message.setGracetime(mis.readLong("gracetime"));
		message.setFirstmove(mis.readBoolean("firstmove"));
		message.setGameid(mis.readLong("gameid"));
		message.setMatchid(mis.readLong("matchid"));
		message.setMplayerid(mis.readLong("mplayerid"));
		message.setMovetime(mis.readLong("movetime"));
		message.setMoveno(mis.readInt("moveno"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Hud message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setNextclub(mis.readInt("nextclub"));
		message.setCurrentloyaltypoints(mis.readInt("currentloyaltypoints"));
		message.setCurrentrewardpoints(mis.readInt("currentrewardpoints"));
		message.setViployaltypoints(mis.readInt("viployaltypoints"));
		message.setClubvalidity(mis.readString("clubvalidity"));
		message.setIsfirstcashgame(mis.readBoolean("isfirstcashgame"));
		message.setCurrentclub(mis.readInt("currentclub"));
		message.setIsvipuser(mis.readBoolean("isvipuser"));
		message.setSuperuserimageurl(mis.readString("superuserimageurl"));
		message.setRmvalue((RmValue) mis.readObject("rmvalue"));
		message.setBonusvalue((BonusValueObj) mis.readObject("bonusvalue"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, BonusValueObj message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */

		message.setBonusactive(mis.readBoolean("bonusactive"));
		message.setUserid(mis.readLong("userid"));
		message.setBonusreleasedincurrentsettlement(mis
				.readDouble("bonusreleasedincurrentsettlement"));
		message.setRemainingamttoplayforcurrentchunk(mis
				.readDouble("remainingamttoplayforcurrentchunk"));
		message.setDaystoexpire(mis.readInt("daystoexpire"));
		message.setChunkamount(mis.readDouble("chunkamount"));
		message.setTotalchunks(mis.readInt("totalchunks"));
		message.setChunksreleased(mis.readInt("chunksreleased"));
		message.setEntryfeeperchunk(mis.readDouble("entryfeeperchunk"));
		message.setBonuscode(mis.readString("bonuscode"));
		message.setRemainingbonusamount(mis.readDouble("remainingbonusamount"));
		message.setTotalbonusamt(mis.readDouble("totalbonusamt"));
		message.setPendingbonus((PendingBonusObj) mis
				.readObject("pendingbonus"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, MdropPlayer message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setPlayers((List<Long>) mis.readList("players"));
		message.setScore(mis.readInt("score"));
		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, LPInfo message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setRptospend(mis.readInt("rptospend"));
		message.setLptospend(mis.readInt("lptospend"));
		message.setClubinfoarray((List<ClubInfoArrayObj>) mis
				.readList("clubinfoarray"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, ClubInfoArrayObj message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */

		message.setBonuses(mis.readDouble("bonuses"));
		message.setRewardpoints(mis.readDouble("rewardpoints"));
		message.setQualperiod(mis.readInt("qualperiod"));
		message.setValidity(mis.readInt("validity"));
		message.setTournaments(mis.readDouble("tournaments"));
		message.setClubid(mis.readInt("clubid"));
		message.setLpsneeded(mis.readInt("lpsneeded"));
		message.setClubname(mis.readString("clubname"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, LastDealErr message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMsg(mis.readString("msg"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, JkrCard message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setCardid(mis.readString("cardid"));
		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, MatchInfo message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchseataray((List<MatchSeatArrayObj>) mis
				.readList("matchseataray"));
		message.setDealno(mis.readInt("dealno"));
		message.setMeport(mis.readInt("meport"));
		message.setMatchid(mis.readLong("matchid"));
		message.setMeip(mis.readString("meip"));
		message.setMpid(mis.readLong("mpid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			MatchSeatArrayObj message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */

		message.setResult(mis.readString("result"));
		message.setMatchplayerid(mis.readLong("matchplayerid"));
		message.setDisconprefence(mis.readInt("disconprefence"));
		message.setPlayer((PlayerObj) mis.readObject("player"));
		message.setNetvaluecardgains(mis.readInt("netvaluecardgains"));
		message.setScore(mis.readInt("score"));
		message.setRecon(mis.readBoolean("recon"));
		message.setMatchid(mis.readLong("matchid"));
		message.setSeatid(mis.readInt("seatid"));
		message.setAmountown(mis.readDouble("amountown"));
		message.setSessionId(mis.readString("sessionid"));
		message.setTotalgains(mis.readInt("totalgains"));
		message.setAutodrop(mis.readBoolean("autodrop"));
		message.setFirstpracticegame(mis.readBoolean("firstpracticegame"));
		message.setConsmissmovecount(mis.readInt("consmissmovecount"));
		message.setTotalscore(mis.readInt("totalscore"));
		message.setHandcardgain(mis.readInt("handcardgain"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, PlayerObj message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */

		message.setHasplayedpracticegame(mis
				.readBoolean("hasplayedpracticegame"));
		message.setStatus(mis.readInt("status"));
		message.setClientvariant(mis.readInt("clientvariant"));
		message.setLoginid(mis.readString("loginid"));
		message.setEmailid(mis.readString("emailid"));
		message.setId(mis.readLong("id"));
		message.setHasplayed21cardpracticegame(mis
				.readBoolean("hasplayed21cardpracticegame"));
		message.setTimeofreg(mis.readInt("timeofreg"));
		message.setAbsoluterank(mis.readInt("absoluterank"));
		message.setIdlong(mis.readLong("idlong"));
		message.setRating(mis.readString("rating"));
		message.setTranchrank(mis.readLong("tranchrank"));
		message.setLastpingreceivedtime(mis.readLong("lastpingreceivedtime"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			InvalidFinish21Card message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setDbltodclr(mis.readInt("dbltodclr"));
		message.setTnlcnt(mis.readInt("tnlcnt"));
		message.setTnltodclr(mis.readInt("tnltodclr"));
		message.setJkrsflag(mis.readBoolean("jkrsflag"));
		message.setPscount(mis.readInt("pscount"));
		message.setDblcnt(mis.readInt("dblcnt"));
		message.setJkrcnt(mis.readInt("jkrcnt"));
		message.setPsreq(mis.readInt("psreq"));
		message.setMatchid(mis.readLong("matchid"));
		message.setGrpsinfo((List<GrpsInfoObj>) mis.readList("grpsinfo"));
		message.setGameid(mis.readLong("gameid"));
		message.setJkrtodclr(mis.readInt("jkrtodclr"));
		message.setAllvalidsets(mis.readBoolean("allvalidsets"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, GrpsInfoObj message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */

		message.setCode(mis.readString("code"));
		message.setType(mis.readInt("type"));
		message.setCards((List<String>) mis.readList("cards"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, FmgError message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setTitle(mis.readString("title"));
		message.setSwfmainpath(mis.readString("swfmainpath"));
		message.setAction(mis.readString("action"));
		message.setErrmsg(mis.readString("errmsg"));
		message.setFmgparams(mis.readString("fmgparams"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, DisplayMsg message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMsg(mis.readString("msg"));
		message.setAaid(mis.readLong("aaid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			DisconProtectionPref message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setPointsrummy(mis.readInt("pointsrummy"));
		message.setMtt(mis.readInt("mtt"));
		message.setIschecked(mis.readInt("ischecked"));
		message.setPointsrummy21(mis.readInt("pointsrummy21"));
		message.setDealsrummy(mis.readInt("dealsrummy"));
		message.setMessageshown(mis.readBoolean("messageshown"));
		message.setPoolrummy(mis.readInt("poolrummy"));
		message.setDppflag(mis.readBoolean("dppflag"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, DisableSplit message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		return message;
	}

	private Message deserialize(MessageInputStream mis, ChatRes message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setPlayername(mis.readString("playername"));
		message.setCtext(mis.readString("ctext"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, BonusIndicator message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setUserid(mis.readLong("userid"));
		message.setBonuscode(mis.readString("bonuscode"));
		message.setEntryfeeperchunk(mis.readDouble("entryfeeperchunk"));
		message.setChunksreleased(mis.readInt("chunksreleased"));
		message.setTotalchunks(mis.readInt("totalchunks"));
		message.setChunkamount(mis.readDouble("chunkamount"));
		message.setDaystoexpire(mis.readInt("daystoexpire"));
		message.setTotalbonusamt(mis.readDouble("totalbonusamt"));
		message.setRemainingbonusamount(mis.readDouble("remainingbonusamount"));
		message.setRemainingamttoplayforcurrentchunk(mis
				.readDouble("remainingamttoplayforcurrentchunk"));
		message.setBonusreleasedincurrentsettlement(mis
				.readDouble("bonusreleasedincurrentsettlement"));
		message.setBonusactive(mis.readBoolean("bonusactive"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, PendingBonusObj message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */

		message.setCount(mis.readInt("count"));
		message.setBonuses((List<Bonuses>) mis.readList("bonuses"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, TakeSeatFail message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMsg(mis.readString("msg"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, Bonuses message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */

		message.setPromocode(mis.readString("promocode"));
		message.setExpirydate(mis.readString("expirydate"));
		message.setMaxamount(mis.readDouble("maxamount"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, RmValue message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */

		message.setRmname(mis.readString("rmname"));
		message.setRmnumber(mis.readString("rmnumber"));
		message.setRmemail(mis.readString("rmemail"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			AutoRebuyInSuccess message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setRebuyinamount(mis.readDouble("rebuyinamount"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, BuyInFail message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setAaid(mis.readLong("aaid"));
		message.setMsg(mis.readString("msg"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, ValCardStr message)
			throws IOException {

		message.setUjokers((List<String>) mis.readList("ujokers"));
		message.setLjokers((List<String>) mis.readList("ljokers"));
		message.setMarraige((List<List<String>>) mis.readList("marraige"));
		message.setJokers((List<String>) mis.readList("jokers"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, PlayerTxn message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */

		message.setToplayer(mis.readLong("toplayer"));
		message.setToplayeruserid(mis.readLong("toplayeruserid"));
		message.setFromplayerloginid(mis.readString("fromplayerloginid"));
		message.setToplayerloginid(mis.readString("toplayerloginid"));
		message.setScore(mis.readInt("score"));
		message.setFromplayeruserid(mis.readLong("fromplayeruserid"));
		message.setFromplayer(mis.readLong("fromplayer"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			BonTournamentComplete message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setAaid(mis.readLong("aaid"));
		message.setWinners((List<String>) mis.readList("winners"));
		message.setMatchidlist((List<Long>) mis.readList("matchidlist"));
		message.setTournamentId(mis.readLong("tournamentId"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, MECrash message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMsg(mis.readString("msg"));
		message.setTitle(mis.readString("title"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			BreakStructureObj message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */

		message.setId(mis.readString("id"));
		message.setTime(mis.readLong("time"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, MatchCreated message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setAaid(mis.readLong("aaid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			PoolTournamentComplete message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setAaid(mis.readLong("aaid"));
		message.setWinners((List<String>) mis.readList("winners"));
		message.setMatchid(mis.readLong("matchid"));
		message.setTournamentId(mis.readLong("tournamentId"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, TECrash message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, MatchSetup message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMplayerid(mis.readLong("mplayerid"));
		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, AutoRebuyinPref message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setAutorebuyinenabled(mis.readBoolean("autorebuyinenabled"));
		message.setAutorebuyindonotshow(mis.readBoolean("autorebuyindonotshow"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, ScoresObj message)
			throws IOException {

		message.setRank(mis.readInt("rank"));
		message.setUsername(mis.readString("username"));
		message.setChips(mis.readDouble("chips"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, RematchRequest message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setRematchAccepted(mis.readBoolean("rematchAccepted"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, RematchResponse message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setRematchMessageType(mis.readInt("rematchMessageType"));
		message.setTournamentId(mis.readLong("tournamentId"));
		message.setRematchCountDown(mis.readInt("rematchCountDown"));
		message.setPlayerLoginId(mis.readString("playerLoginId"));
		message.setOpponentLoginId(mis.readString("opponentLoginId"));
		message.setEntreeFee(mis.readDouble("entreeFee"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			ScoreWindow21Card message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setGameid(mis.readLong("gameid"));
		message.setDealnumber(mis.readInt("dealnumber"));
		message.setValcardtxns((List<ValCardTxns>) mis.readList("valcardtxns"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, AutoRebuyinReq message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setAutorebuyinenabled(mis.readBoolean("autorebuyinenabled"));
		message.setTournamentid(mis.readLong("tournamentid"));
		message.setAutorebuyindonotshow(mis.readBoolean("autorebuyindonotshow"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, SaveTheme message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setThemeid(mis.readInt("themeid"));
		message.setTournamentid(mis.readLong("tournamentid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, MTTScoreCardResp message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMatchid(mis.readLong("matchid"));
		message.setScores((List<MTTScoreListResp>) mis.readList("scores"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, MTTScoreListResp message)
			throws IOException {

		message.setChips(mis.readInt("chips"));
		message.setUsername(mis.readString("username"));
		message.setRank(mis.readInt("rank"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, ChangeTableId message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setNewtableid(mis.readLong("newtableid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, HeartBeat message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			HeartBeatResponse message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setLastrecmsgid(mis.readInt("lastrecmsgid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, HandShake message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		// message.setIpaddress( mis.readString( "ipaddress" ) );
		return message;
	}

	private Message deserialize(MessageInputStream mis,
			HandShakeResponse message) throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		return message;
	}

	private Message deserialize(MessageInputStream mis, MttTableMap message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setTournamentid(mis.readLong("tournamentid"));
		return message;
	}

	private Message deserialize(MessageInputStream mis, MttTableMapResp message)
			throws IOException {
		message.setReceiverID(mis.readLong("receiverid"));
		message.setPlayerID(mis.readLong("playerid"));
		message.setSource(mis.readString("source"));
		message.setSessionId(mis.readString("sessionid"));
		/* mos.writeBoolean("fmg",message.isFmg()); */
		message.setAckReq(mis.readInt("ackreq"));
		message.setMsgId(mis.readLong("id"));
		message.setDest(mis.readString("dest"));
		message.setSysTime(mis.readLong("systime"));

		message.setMtttableid((List<Long>) mis.readList("mtttableid"));
		message.setMttplayerid((List<Long>) mis.readList("mttplayerid"));
		return message;
	}

	public String getMessageType(int classId) {
		return classIdMessageTypeMap.get(classId);
	}

	public Integer getMessageClassId(String msgClassName) {
		return messageTypeClassIdMap.get(msgClassName);
	}
}
