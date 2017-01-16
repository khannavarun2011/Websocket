package com.rummycircle.wsclient;

import static com.games24x7.service.message.serializer.io.binary.EntityTypes.ELEMENT_TYPE_DOUBLE;
import static com.games24x7.service.message.serializer.io.binary.EntityTypes.ELEMENT_TYPE_FLOAT;
import static com.games24x7.service.message.serializer.io.binary.EntityTypes.ELEMENT_TYPE_INTEGER;
import static com.games24x7.service.message.serializer.io.binary.EntityTypes.ELEMENT_TYPE_LIST;
import static com.games24x7.service.message.serializer.io.binary.EntityTypes.ELEMENT_TYPE_LONG;
import static com.games24x7.service.message.serializer.io.binary.EntityTypes.ELEMENT_TYPE_OBJECT;
import static com.games24x7.service.message.serializer.io.binary.EntityTypes.ELEMENT_TYPE_STRING;
import static com.games24x7.service.message.serializer.io.binary.EntityTypes.TAG_ELEMENT_TYPE;

import java.io.IOException;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.games24x7.service.message.Frame;

public class WebSocketMessageFactory {

	public static final String RECEIVER_ID = "receiverid";
	public static final String TOURNAMENT_ID = "tournamentid";
	public static final String TYPE = "type";
	public static final String VALUE = "value";
	public static final String JSON_OBJ = "jsonObj";
	public static final String CLASS_ID = "classID";
	public static final String PLAYER_ID = "playerid";
	public static final String TAG_CLASS_ID = "messageType";

	private static Logger logger = LoggerFactory
			.getLogger(WebSocketMessageFactory.class);

	public static Frame convertJsonToFrame(JSONObject json) {
		json.put(
				WebSocketMessageFactory.CLASS_ID,
				WSMessageFactory.getFactory().getMessageClassId(
						json.getString(TYPE).toUpperCase()));
		JSONObject valueObject = null;
		try {
			valueObject = json.getJSONObject(VALUE);
			for (String key : valueObject.keySet()) {
				JSONObject subObject = new JSONObject();
				if (valueObject.get(key) instanceof JSONArray) {
					if (((JSONArray) valueObject.get(key)).length() > 0) {
						JSONArray jsonArray = valueObject.getJSONArray(key);
						Object elem = jsonArray.get(0);

						if (elem instanceof JSONArray) {
							subObject.put(TAG_ELEMENT_TYPE, ELEMENT_TYPE_LIST);
							JSONArray finalArray = new JSONArray();
							for (int j = 0; j < jsonArray.length(); j++) {
								JSONObject subObject2 = new JSONObject();
								if (((JSONArray) elem).get(0) instanceof String) {
									subObject2.put(TAG_ELEMENT_TYPE,
											ELEMENT_TYPE_STRING);
								} else if (((JSONArray) elem).get(0) instanceof Integer) {
									subObject2.put(TAG_ELEMENT_TYPE,
											ELEMENT_TYPE_INTEGER);
								} else if (((JSONArray) elem).get(0) instanceof Double) {
									subObject2.put(TAG_ELEMENT_TYPE,
											ELEMENT_TYPE_DOUBLE);
								} else if (((JSONArray) elem).get(0) instanceof Float) {
									subObject2.put(TAG_ELEMENT_TYPE,
											ELEMENT_TYPE_FLOAT);
								} else if (((JSONArray) elem).get(0) instanceof Long) {
									subObject2.put(TAG_ELEMENT_TYPE,
											ELEMENT_TYPE_LONG);
								} else if (((JSONArray) elem).get(0) instanceof Object) {
									subObject2.put(TAG_ELEMENT_TYPE,
											ELEMENT_TYPE_OBJECT);
								}
								subObject2.put(JSON_OBJ,
										jsonArray.getJSONArray(j));
								finalArray.put(subObject2);
							}
							subObject.put(JSON_OBJ, finalArray);
						} else {
							if (elem instanceof String) {
								subObject.put(TAG_ELEMENT_TYPE,
										ELEMENT_TYPE_STRING);
							} else if (elem instanceof Integer) {
								subObject.put(TAG_ELEMENT_TYPE,
										ELEMENT_TYPE_INTEGER);
							} else if (elem instanceof Double) {
								subObject.put(TAG_ELEMENT_TYPE,
										ELEMENT_TYPE_DOUBLE);
							} else if (elem instanceof Float) {
								subObject.put(TAG_ELEMENT_TYPE,
										ELEMENT_TYPE_FLOAT);
							} else if (elem instanceof Long) {
								subObject.put(TAG_ELEMENT_TYPE,
										ELEMENT_TYPE_LONG);
							} else if (elem instanceof Object) {
								subObject.put(TAG_ELEMENT_TYPE,
										ELEMENT_TYPE_OBJECT);
								JSONObject innerObj = (JSONObject) elem;
								subObject.put(TAG_CLASS_ID,
										innerObj.get(CLASS_ID));
							}
							subObject.put(JSON_OBJ, jsonArray);
						}
						valueObject.put(key, subObject);
					} else {
						JSONObject obj = new JSONObject();
						obj.put(TAG_ELEMENT_TYPE, -1);
						obj.put(JSON_OBJ, new JSONArray());
						valueObject.put(key, obj);
					}
				}
			}

			long actionAreaId = 0;

			if (json.has(VALUE)) {
				JSONObject value = json.getJSONObject(VALUE);
				actionAreaId = value.optLong("aaid");
				for (String key : JSONObject.getNames(value)) {
					json.put(key, value.get(key));
				}
			}
			json.remove(VALUE);
			json.put(RECEIVER_ID, actionAreaId);
			// logger.debug("Client message after processing {}",
			// json.toString());
			return new Frame(WSMessageFactory.getFactory()
					.getMessageClassId(json.getString(TYPE).toUpperCase()),
					actionAreaId, false, json.toString().getBytes());

		} catch (Exception e) {
			if (!json.toString().contains("heartbeatres")) {
				logger.info("Exception in converting to frame: "
						+ json.toString());
				logger.error("Unable to convertJsonToFrame.", e);
			}
			return null;
		}
	}

	public static JSONObject convertFrameToJson(Frame frame,
			String messageType, long receiverId, long playerId) {
		JSONObject response = new JSONObject();
		response.put(TYPE, messageType);
		JSONObject jsonObj = convertServerToClient(new JSONObject(new String(
				frame.getPayload())));
		jsonObj.put(TOURNAMENT_ID, receiverId);
		jsonObj.put(RECEIVER_ID, receiverId);
		jsonObj.put(PLAYER_ID, playerId);
		response.put(VALUE, jsonObj);
		// logger.debug("Server message after processing {}", response);
		return response;
	}

	private static JSONObject convertServerToClient(JSONObject json) {
		try {
			Iterator<String> itr = json.keys();
			while (itr.hasNext()) {
				String key = itr.next();
				if (json.get(key) instanceof JSONObject) {
					JSONObject candidateObj = (JSONObject) json.get(key);
					if (candidateObj.has(JSON_OBJ)) {
						JSONArray jsonArray = (JSONArray) candidateObj
								.get(JSON_OBJ);

						if (jsonArray.length() > 0
								&& jsonArray.get(0) instanceof JSONObject) {
							JSONArray newArr = new JSONArray();

							for (int i = 0; i < jsonArray.length(); i++) {
								JSONObject subJsonObj = jsonArray
										.getJSONObject(i);
								if (subJsonObj.has(JSON_OBJ)) {
									newArr.put(subJsonObj
											.getJSONArray(JSON_OBJ));
								} else {
									newArr.put(convertServerToClient(subJsonObj));
								}
							}
							json.put(key, newArr);
						} else {
							json.put(key, candidateObj.getJSONArray(JSON_OBJ));
						}
					} else {
						json.put(key, convertServerToClient(candidateObj));
					}
				}
			}
			return json;
		} catch (Exception e) {
			logger.error("Unable to convertFrameToJson.", e);
			return null;
		}
	}
}
