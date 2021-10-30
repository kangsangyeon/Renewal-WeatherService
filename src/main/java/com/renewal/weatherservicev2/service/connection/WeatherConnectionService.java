package com.renewal.weatherservicev2.service.connection;

import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiResponseInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.DailyWeatherRes;
import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.HourlyWeatherRes;
import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.WeatherRes;
import com.renewal.weatherservicev2.service.parser.json.DailyWeatherJsonParser;
import com.renewal.weatherservicev2.service.parser.json.HourlyWeatherJsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherConnectionService {

    private final ApiConnection apiConnection;
    private final DailyWeatherJsonParser dailyWeatherJsonParser;
    private final HourlyWeatherJsonParser hourlyWeatherJsonParser;

    public WeatherRes connectAndGetParsedResponse(OpenApiRequestInterface request) {
        URL url = request.makeUrl();
        String data = apiConnection.connect(url);

        List<DailyWeatherRes> dailyWeathers = new ArrayList<>(10);
        List<HourlyWeatherRes> hourlyWeathers = new ArrayList<>(30);

        for(int day = 1; day <= 7; day++) {
            DailyWeatherRes dailyWeatherRes = dailyWeatherJsonParser.parseFrom(data, day);
            dailyWeathers.add(dailyWeatherRes);
        }

        for(int hour = 1; hour <= 24; hour++) {
            HourlyWeatherRes hourlyWeatherRes = hourlyWeatherJsonParser.parseFrom(data, hour);
            hourlyWeathers.add(hourlyWeatherRes);
        }

        return WeatherRes.builder()
                .dailyWeathers(dailyWeathers)
                .hourlyWeathers(hourlyWeathers)
                .build();
    }
}
