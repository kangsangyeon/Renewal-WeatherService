package com.renewal.weatherservicev2.service.parser.json;

import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthResponseVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class LivingAndHealthJsonParser {

    private final CommonJsonParser jsonParser;

    public LivingAndHealthResponseVO parseFrom(String data) throws RuntimeException {
        try {
            JSONObject response = parseContentFrom(data);

            String dateTime = jsonParser.parseStringFrom(response, "date");
            String day1 = jsonParser.parseStringFrom(response, "today");
            String day2 = jsonParser.parseStringFrom(response, "tomorrow");
            String day3 = jsonParser.parseStringFrom(response, "dayaftertomorrow");
            String day4 = jsonParser.parseStringFrom(response, "twodaysaftertomorrow");

            return LivingAndHealthResponseVO.builder()
                    .dateTime(dateTime)
                    .day1(day1)
                    .day2(day2)
                    .day3(day3)
                    .day4(day4)
                    .build();

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException();
        }
    }

    public JSONObject parseContentFrom(String data) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(data);
        JSONObject response = jsonParser.parseObjectFrom(jsonObject, "response");
        JSONObject body = jsonParser.parseObjectFrom(response, "body");
        JSONObject items = jsonParser.parseObjectFrom(body, "items");
        JSONArray item = jsonParser.parseArrayFrom(items, "item");

        return jsonParser.parseObjectFromFirst(item);
    }
}

