package com.renewal.weatherservicev2.service.parser.json;

import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.HourlyOpenApiRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class HourlyWeatherJsonParser {

    private final CommonJsonParser jsonParser;



    private HourlyOpenApiRes parseFromByHour(String data, int hour) throws RuntimeException {
        try {
            JSONObject response = parseContentFrom(data, hour);

            JSONArray weatherArray = jsonParser.parseArrayFrom(response, "weather");
            JSONObject weather = jsonParser.parseObjectFrom(weatherArray, 0);
            String icon = jsonParser.parseStringFrom(weather, "icon");
            String main = jsonParser.parseStringFrom(weather, "main");
            String description = jsonParser.parseStringFrom(weather, "description");

            String temp = jsonParser.parseNumberFrom(response, "temp").toString();
            String rainPer = jsonParser.parseNumberFrom(response, "pop").toString();

            return HourlyOpenApiRes.builder()
                    .rainPer(rainPer)
                    .temp(temp)
                    .weatherIcon(icon)
                    .weatherMain(main)
                    .weatherDescription(description)
                    .build();

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException();
        }
    }

    private JSONObject parseContentFrom(String data, int hour) throws ParseException {
        JSONObject jsonObject = (JSONObject) CommonJsonParser.jsonParser.parse(data);
        JSONArray hourlyWeathers = jsonParser.parseArrayFrom(jsonObject, "hourly");
        return jsonParser.parseObjectFrom(hourlyWeathers, hour-1);
    }
}
