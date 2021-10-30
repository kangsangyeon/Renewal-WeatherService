package com.renewal.weatherservicev2.service.parser.json;

import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.HourlyWeatherRes;
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

    public HourlyWeatherRes parseFrom(String data, int day) throws RuntimeException {
        try {
            JSONObject response = parseContentFrom(data, day);

            JSONArray weatherArray = jsonParser.parseArrayFrom(response, "weather");
            JSONObject weather = jsonParser.parseObjectFrom(weatherArray, 0);
            String icon = jsonParser.parseStringFrom(weather, "icon");
            String main = jsonParser.parseStringFrom(weather, "main");
            String description = jsonParser.parseStringFrom(weather, "description");

            String temp = jsonParser.parseNumberFrom(response, "temp").toString();
            String rainPer = jsonParser.parseNumberFrom(response, "pop").toString();
            String humidity = jsonParser.parseNumberFrom(response, "humidity").toString();
            String windSpeed = jsonParser.parseNumberFrom(response, "wind_speed").toString();

            return HourlyWeatherRes.builder()
                    .weatherIcon(icon)
                    .weatherMain(main)
                    .weatherDescription(description)
                    .temp(temp)
                    .rainPer(rainPer)
                    .humidity(humidity)
                    .windSpeed(windSpeed)
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
