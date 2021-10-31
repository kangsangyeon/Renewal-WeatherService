package com.renewal.weatherservicev2.service.connection;

import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.DailyWeatherRes;
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
        try {
            URL url = request.makeUrl();
            String data = apiConnection.connect(url);

            WeatherRes weatherRes = new WeatherRes();

            for (int day = 1; day <= 7; day++) {
                DailyWeatherRes dailyWeatherRes = dailyWeatherJsonParser.parseFrom(data, day);

                weatherRes.getDailyHumidity().setDataByDay(dailyWeatherRes, day);
                weatherRes.getDailyRainPer().setDataByDay(dailyWeatherRes, day);
                weatherRes.getDailyTempDay().setDataByDay(dailyWeatherRes, day);
                weatherRes.getDailyTempMax().setDataByDay(dailyWeatherRes, day);
                weatherRes.getDailyTempMin().setDataByDay(dailyWeatherRes, day);
                weatherRes.getDailyWeatherDescription().setDataByDay(dailyWeatherRes, day);
                weatherRes.getDailyWeatherIcon().setDataByDay(dailyWeatherRes, day);
                weatherRes.getDailyWeatherMain().setDataByDay(dailyWeatherRes, day);
                weatherRes.getDailyWind().setDataByDay(dailyWeatherRes, day);
            }

//        for(int hour = 1; hour <= 24; hour++) {
//            HourlyWeatherRes hourlyWeatherRes = hourlyWeatherJsonParser.parseFrom(data, hour);
//        }

            return weatherRes;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException();
        }
    }
}
