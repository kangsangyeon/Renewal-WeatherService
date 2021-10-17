package com.renewal.weatherservicev2.service.parser;

import com.renewal.weatherservicev2.domain.vo.openapi.response.HealthResponseVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LivingAndHealthJsonParser {

    private final CommonJsonParser commonJsonParser;

    public HealthResponseVO parseFrom(String data) throws RuntimeException {
        try {
            JSONObject response = parseContentFrom(data);

            String dateTime = commonJsonParser.parseStringFrom(response, "date");
            String day1 = commonJsonParser.parseStringFrom(response, "today");
            String day2 = commonJsonParser.parseStringFrom(response, "tomorrow");
            String day3 = commonJsonParser.parseStringFrom(response, "dayaftertomorrow");
            String day4 = commonJsonParser.parseStringFrom(response, "twodaysaftertomorrow");

            return HealthResponseVO.builder()
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
        JSONObject response = commonJsonParser.parseObjectFrom(jsonObject, "response");
        JSONObject body = commonJsonParser.parseObjectFrom(response, "body");
        JSONObject items = commonJsonParser.parseObjectFrom(body, "items");
        JSONArray item = commonJsonParser.parseArrayFrom(items, "item");

        return commonJsonParser.parseObjectFromFirst(item);
    }
}
