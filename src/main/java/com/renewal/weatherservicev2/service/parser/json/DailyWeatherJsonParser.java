package com.renewal.weatherservicev2.service.parser.json;

import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.common.DailyWeatherJsonRes;
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

    /**
     * @param day 1 - 첫쨰날, 2 - 둘째날 etc.
     */
    public DailyWeatherJsonRes parseFrom(String data, int day) throws RuntimeException {
        try {
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

            return DailyWeatherJsonRes.builder()
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

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException();
        }
    }

    private JSONObject parseContentFrom(String data, int day) throws ParseException {
        JSONObject jsonObject = (JSONObject) CommonJsonParser.jsonParser.parse(data);
        JSONArray dailyWeathers = jsonParser.parseArrayFrom(jsonObject, "daily");
        return jsonParser.parseObjectFrom(dailyWeathers, day-1);
    }
}
