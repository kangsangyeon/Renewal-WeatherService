package com.renewal.weatherservicev2.service.connection;

import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.HourlyWeatherRes;
import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.WeatherRes;
import com.renewal.weatherservicev2.service.parser.json.DailyWeatherJsonParser;
import com.renewal.weatherservicev2.service.parser.json.HourlyWeatherJsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URL;

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
        return WeatherRes.builder()
                .dailyWeatherRes(dailyWeatherJsonParser.parseFrom(data))
                .hourlyWeatherRes(new HourlyWeatherRes())
                .build();
    }
}
