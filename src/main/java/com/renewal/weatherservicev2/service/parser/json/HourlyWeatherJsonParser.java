package com.renewal.weatherservicev2.service.parser.json;

import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.HourlyOpenApiRes;
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

    public HourlyWeatherRes parseFrom(String data) {
        HourlyWeatherRes response = HourlyWeatherRes.create();

        try {
            for (int hour = 1; hour <= 24; hour++) {
                HourlyOpenApiRes openApiRes = parseFromByHour(data, hour);

                response.setRainPerFrom(openApiRes, hour);
                response.setTempHourFrom(openApiRes, hour);
                response.setWeatherDescriptionFrom(openApiRes, hour);
                response.setWeatherMainFrom(openApiRes, hour);
                response.setWeatherIconFrom(openApiRes, hour);
            }
            return response;

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException();
        }
    }

    public HourlyOpenApiRes parseFromByHour(String data, int hour) throws ParseException {
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
    }

    private JSONObject parseContentFrom(String data, int hour) throws ParseException {
        JSONObject jsonObject = (JSONObject) CommonJsonParser.jsonParser.parse(data);
        JSONArray hourlyWeathers = jsonParser.parseArrayFrom(jsonObject, "hourly");
        return jsonParser.parseObjectFrom(hourlyWeathers, hour-1);
    }
}
