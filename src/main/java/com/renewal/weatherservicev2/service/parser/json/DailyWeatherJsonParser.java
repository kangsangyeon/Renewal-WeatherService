package com.renewal.weatherservicev2.service.parser.json;

import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.DailyOpenApiRes;
import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.DailyWeatherRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DailyWeatherJsonParser {

    private final CommonJsonParser jsonParser;

    public DailyWeatherRes parseFrom(String data) {
        DailyWeatherRes response = DailyWeatherRes.create();

        try {
            for (int day = 1; day <= 7; day++) {
                DailyOpenApiRes openApiRes = parseFromByDay(data, day);

                response.setHumidityFrom(openApiRes, day);
                response.setRainPerFrom(openApiRes, day);
                response.setTempDayFrom(openApiRes, day);
                response.setTempMaxFrom(openApiRes, day);
                response.setTempMinFrom(openApiRes, day);
                response.setWeatherDescriptionFrom(openApiRes, day);
                response.setWeatherMainFrom(openApiRes, day);
                response.setWeatherIconFrom(openApiRes, day);
                response.setWindFrom(openApiRes, day);
            }
            return response;

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException();
        }
    }

    /**
     * @param day 1 - 첫쨰날, 2 - 둘째날 etc.
     */
    private DailyOpenApiRes parseFromByDay(String data, int day) throws ParseException {
        JSONObject response = parseContentFrom(data, day);

        JSONArray weatherArray = jsonParser.parseArrayFrom(response, "weather");
        JSONObject weather = jsonParser.parseObjectFrom(weatherArray, 0);
        String icon = jsonParser.parseStringFrom(weather, "icon");
        String main = jsonParser.parseStringFrom(weather, "main");
        String description = jsonParser.parseStringFrom(weather, "description");

        JSONObject temp = jsonParser.parseObjectFrom(response, "temp");
        String tempDay = jsonParser.parseNumberFrom(temp, "day").toString();
        String tempMin = jsonParser.parseNumberFrom(temp, "min").toString();
        String tempMax = jsonParser.parseNumberFrom(temp, "max").toString();

        String rainPer = jsonParser.parseNumberFrom(response, "pop").toString();
        String humidity = jsonParser.parseNumberFrom(response, "humidity").toString();
        String windSpeed = jsonParser.parseNumberFrom(response, "wind_speed").toString();

        return DailyOpenApiRes.builder()
                .weatherIcon(icon)
                .weatherMain(main)
                .weatherDescription(description)
                .tempDay(tempDay)
                .tempMin(tempMin)
                .tempMax(tempMax)
                .rainPer(rainPer)
                .humidity(humidity)
                .windSpeed(windSpeed)
                .build();
    }

    private JSONObject parseContentFrom(String data, int day) throws ParseException {
        JSONObject jsonObject = (JSONObject) CommonJsonParser.jsonParser.parse(data);
        JSONArray dailyWeathers = jsonParser.parseArrayFrom(jsonObject, "daily");
        return jsonParser.parseObjectFrom(dailyWeathers, day-1);
    }
}
