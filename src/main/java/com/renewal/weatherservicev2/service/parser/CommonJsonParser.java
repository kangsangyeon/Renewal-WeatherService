package com.renewal.weatherservicev2.service.parser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommonJsonParser {

    public JSONObject parseObjectFrom(JSONObject object, String field) {
        return (JSONObject) object.get(field);
    }

    public JSONObject parseObjectFromFirst(JSONArray array) {
        return (JSONObject) array.get(0);
    }

    public JSONArray parseArrayFrom(JSONObject object, String field) {
        return (JSONArray) object.get(field);
    }

    public String parseStringFrom(JSONObject object, String field) {
        return (String) object.get(field);
    }
}
