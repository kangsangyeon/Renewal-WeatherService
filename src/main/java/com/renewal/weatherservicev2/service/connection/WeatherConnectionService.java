package com.renewal.weatherservicev2.service.connection;

import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.DailyWeatherRes;
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

    public DailyWeatherRes connectAndGetParsedResponse(OpenApiRequestInterface request) {
        URL url = request.makeUrl();
        String data = apiConnection.connect(url);
        return dailyWeatherJsonParser.parseFrom(data);
    }
}
