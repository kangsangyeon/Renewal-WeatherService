package com.renewal.weatherservicev2.service.parser.json;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CommonJsonParser {

    public static JSONParser jsonParser = new JSONParser();

    public JSONObject parseObjectFrom(JSONObject object, String field) {
        return (JSONObject) object.get(field);
    }

    public JSONObject parseObjectFrom(JSONArray array, int index) {
        return (JSONObject) array.get(index);
    }

    public JSONArray parseArrayFrom(JSONObject object, String field) {
        return (JSONArray) object.get(field);
    }

    public String parseStringFrom(JSONObject object, String field) {
        return (String) object.get(field);
    }

    public Number parseNumberFrom(JSONObject object, String field) {
        return (Number) object.get(field);
    }
}
