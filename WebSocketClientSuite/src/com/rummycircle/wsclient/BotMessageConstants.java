package com.rummycircle.wsclient;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Auto Generated Message Constants Interface. THIS FILE SHOULD NOT BE EDITED
 * MANUALLY.
 */
public interface BotMessageConstants {
	public static final int ACCEPTSPLIT = 1048577;
	public static final int AUTODROP = 1048578;
	public static final int AUTODROPCANCEL = 1048579;
	public static final int AUTOPLAYRES = 1048580;
	public static final int BONBONUSUPDATEREQ = 1048581;
	public static final int BUYIN = 1048582;
	public static final int CHAT = 1048583;
	public static final int DEALSLEFT = 1048584;
	public static final int DEALSLEFTRES = 1048585;
	public static final int DECLARE = 1048586;
	public static final int DISCARD = 1048587;
	public static final int DISCARDCS = 1048588;
	public static final int DISCONPROTECTIONPREFUPDATE = 1048589;
	public static final int DROP = 1048590;
	public static final int FINISH = 1048591;
	public static final int FIRSTCASHGAMEACK = 1048592;
	public static final int FMGSEARCH = 1048593;
	public static final int HANDPROGRESSBARSTATE = 1048594;
	public static final int INITIATESPLIT = 1048596;
	public static final int LASTDEALREQ = 1048597;
	public static final int LEAVETABLE = 1048598;
	public static final int NEWROUNDCONNECTION = 1048599;
	public static final int PICKC = 1048600;
	public static final int PICKO = 1048601;
	public static final int RAP = 1048602;
	public static final int READY = 1048603;
	public static final int REBUYIN = 1048604;
	public static final int RECON = 1048605;
	public static final int REJECTSPLIT = 1048606;
	public static final int REJOINSTATUS = 1048607;
	public static final int UPDATETHEME = 1048608;
	public static final int SCORECARD = 1048609;
	public static final int SETCARDS = 1048610;
	public static final int SETUP = 1048611;
	public static final int TAKESEAT = 1048612;
	public static final int THEMEREQ = 1048613;
	public static final int WITHDRAW = 1048614;
	public static final int WITHDRAWREBUY = 1048615;
	public static final int MOVETIMEOUT = 1048616;
	public static final int OPNCARD = 1048617;
	public static final int OPPDECLARE = 1048618;
	public static final int OPPDISCARD = 1048619;
	public static final int OPPDROP = 1048620;
	public static final int OPPFINISH = 1048621;
	public static final int OPPPICKC = 1048622;
	public static final int OPPPICKO = 1048623;
	public static final int PFINISHRESP = 1048624;
	public static final int PICKCRES = 1048625;
	public static final int PICKORES = 1048626;
	public static final int PLAYERELIMINATED = 1048627;
	public static final int PLAYERSCORES = 1048628;
	public static final int SCORELIST = 1048629;
	public static final int PLAYERSEQ = 1048630;
	public static final int PLAYERUPDATE = 1048631;
	public static final int SEATS = 1048632;
	public static final int PLAYER = 1048633;
	public static final int PLRDISCONNECT = 1048634;
	public static final int PLRHANDCARD = 1048635;
	public static final int PLRMOVE = 1048636;
	public static final int PREPAREFORNEXTROUND = 1048637;
	public static final int PRIZEPOOL = 1048638;
	public static final int REBUYWINDOWBAL = 1048639;
	public static final int REJECTSPLITSUCCESS = 1048640;
	public static final int REJOINFAIL = 1048641;
	public static final int REJOININGPLAYERELIMINATED = 1048642;
	public static final int REJOINSUCCESS = 1048643;
	public static final int RESETCONNECTION = 1048644;
	public static final int RESHUFFLE = 1048645;
	public static final int SCORECARDRESP = 1048646;
	public static final int SCORELISTRESP = 1048647;
	public static final int SCOREWINDOW = 1048648;
	public static final int SCOREWINDOWVALUE = 1048649;
	public static final int SCOREWINDOWCHANGE = 1048650;
	public static final int SEATSETUP = 1048651;
	public static final int SERVERDISCARD = 1048652;
	public static final int SETUPRES = 1048653;
	public static final int SHOWREJOIN = 1048654;
	public static final int SPLITDETAILS = 1048655;
	public static final int PLAYERLIST = 1048656;
	public static final int SPLITSTATUS = 1048657;
	public static final int SPLITSTATUSPLAYERLIST = 1048658;
	public static final int STARTDECLARE = 1048659;
	public static final int STARTGAMETIMER = 1048660;
	public static final int TAKESEATBAL = 1048661;
	public static final int THEMECHANGE = 1048662;
	public static final int THEME = 1048663;
	public static final int THEMERES = 1048664;
	public static final int TIEBREAKER = 1048665;
	public static final int TOSSCARD = 1048666;
	public static final int TOSSCARDOBJ = 1048667;
	public static final int TOSSWINNER = 1048668;
	public static final int TOURNAMENTCOMPLETE = 1048669;
	public static final int TOURNAMENTINFO = 1048670;
	public static final int TOURNAMENTINFOOBJ = 1048671;
	public static final int CURRENTROUNDOBJ = 1048672;
	public static final int RANK = 1048673;
	public static final int ROUND = 1048674;
	public static final int VALCARDSINFO = 1048676;
	public static final int VALCARDTXNS = 1048677;
	public static final int WINNERMSG = 1048678;
	public static final int WRONGFINISHPLAYER = 1048679;
	public static final int AAINFO = 1048680;
	public static final int GPROPERTY = 1048681;
	public static final int TPROPERTY = 1048682;
	public static final int AASTATUS = 1048683;
	public static final int ACCEPTSPLITSUCCESS = 1048684;
	public static final int ACK = 1048685;
	public static final int AMOUNTWON = 1048686;
	public static final int AMOUNTWONOBJ = 1048687;
	public static final int AUTODROPCANCELSUCCESS = 1048688;
	public static final int AUTODROPSTATUS = 1048689;
	public static final int AUTODROPSUCCESS = 1048690;
	public static final int AUTOPLAYREQ = 1048691;
	public static final int AUTOPLAYRESPACK = 1048692;
	public static final int BALUPDATE = 1048693;
	public static final int BALUPDATEOBJ = 1048694;
	public static final int BONTOURNAMENTINFO = 1048695;
	public static final int RANKOBJ = 1048696;
	public static final int BUYINSUCC = 1048697;
	public static final int CLOSEALLCONNECTIONS = 1048698;
	public static final int CLOSECONNECTION = 1048699;
	public static final int CLOSEDDECKSIZE = 1048700;
	public static final int DEALER = 1048702;
	public static final int DECLARECONF = 1048704;
	public static final int DECLARERESP = 1048705;
	public static final int DISCARDRES = 1048706;
	public static final int DISCARDS = 1048707;
	public static final int DISCONPROTECTIONPREFUPDATERES = 1048708;
	public static final int DROPPLAYER = 1048709;
	public static final int DROPRES = 1048710;
	public static final int ENABLESPLIT = 1048711;
	public static final int ERRORMSG = 1048712;
	public static final int ERRORPICKO = 1048713;
	public static final int FINISHSTAGE = 1048714;
	public static final int GMSETUP = 1048715;
	public static final int GMSTATUS = 1048716;
	public static final int GRACEMOVE = 1048717;
	public static final int HUD = 1048719;
	public static final int BONUSVALUEOBJ = 1048720;
	public static final int MDROPPLAYER = 1048721;
	public static final int LPINFO = 1048722;
	public static final int CLUBINFOARRAYOBJ = 1048723;
	public static final int LASTDEALERR = 1048724;
	public static final int JKRCARD = 1048725;
	public static final int MATCHINFO = 1048726;
	public static final int MATCHSEATARRAYOBJ = 1048727;
	public static final int PLAYEROBJ = 1048728;
	public static final int INVALIDFINISH21CARD = 1048729;
	public static final int GRPSINFOOBJ = 1048730;
	public static final int FMGERROR = 1048731;
	public static final int DISPLAYMSG = 1048732;
	public static final int DISCONPROTECTIONPREF = 1048733;
	public static final int DISABLESPLIT = 1048734;
	public static final int CHATRES = 1048735;
	public static final int BONUSINDICATOR = 1048736;
	public static final int PENDINGBONUSOBJ = 1048737;
	public static final int TAKESEATFAIL = 1048738;
	public static final int BONUSES = 1048739;
	public static final int RMVALUE = 1048740;
	public static final int AUTOREBUYINSUCCESS = 1048741;
	public static final int BUYINFAIL = 1048742;
	public static final int VALCARDSTR = 1048743;
	public static final int PLAYERTXN = 1048744;
	public static final int BONTOURNAMENTCOMPLETE = 1048745;
	public static final int MECRASH = 1048746;
	public static final int BREAKSTRUCTUREOBJ = 1048747;
	public static final int MATCHCREATED = 1048748;
	public static final int POOLTOURNAMENTCOMPLETE = 1048749;
	public static final int TECRASH = 1048750;
	public static final int MATCHSETUP = 1048751;
	public static final int AUTOREBUYINPREF = 1048752;
	public static final int SCORESOBJ = 1048753;
	public static final int REMATCHREQUEST = 1048754;
	public static final int REMATCHRESPONSE = 1048755;
	public static final int SCOREWINDOW21CARD = 1048756;
	public static final int AUTOREBUYINREQ = 1048757;
	public static final int SAVETHEME = 1048758;
	public static final int MTTSCORECARDRESP = 1048759;
	public static final int MTTSCORELISTRESP = 1048760;
	public static final int CHANGETABLEID = 1048761;
	public static final int HEARTBEAT = 2097153;
	public static final int HEARTBEATRESPONSE = 2097154;
	public static final int HANDSHAKE = 2097155;
	public static final int HANDSHAKERESPONSE = 2097156;
	public static final int MTTTABLEMAP = 2097157;
	public static final int MTTTABLEMAPRESP = 2097158;
	public static final int FMGRESPONSE = 2097162;
	public static final int FMGREQUEST = 2097161;
	public static final int MOVETOTABLE = 1048773;
	public static final int DOUBLEWINDOW = 2097157;

	public static Map<String, Integer> getMessageTypeClassIdMap() {

		List<Field> finalFields = getFinalFields();

		Map<String, Integer> map = new ConcurrentHashMap<String, Integer>(
				finalFields.size());
		for (Field field : finalFields) {
			try {
				map.put(field.getName(), field.getInt(null));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public static Map<Integer, String> getClassIdMessageTypeMap() {

		List<Field> finalFields = getFinalFields();

		Map<Integer, String> map = new HashMap<>(finalFields.size());
		for (Field field : finalFields) {
			try {
				map.put(field.getInt(null), field.getName().toLowerCase());
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public static List<Field> getFinalFields() {
		Field[] declaredFields = BotMessageConstants.class.getDeclaredFields();
		List<Field> staticFields = new ArrayList<Field>();
		for (Field field : declaredFields) {
			if (java.lang.reflect.Modifier.isFinal(field.getModifiers())) {
				staticFields.add(field);
			}
		}
		return staticFields;
	}
}
