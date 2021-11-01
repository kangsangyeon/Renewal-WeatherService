package com.renewal.weatherservicev2.service.connection;

import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.common.DailyWeatherJsonRes;
import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.common.WeatherRes;
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
        try {
            URL url = request.makeUrl();
            String data = apiConnection.connect(url);

            WeatherRes weatherRes = new WeatherRes();

            for (int day = 1; day <= 7; day++) {
                DailyWeatherJsonRes jsonRes = dailyWeatherJsonParser.parseFrom(data, day);

                weatherRes.getHumidity().setDataByDay(jsonRes, day);
                weatherRes.getRainPer().setDataByDay(jsonRes, day);
                weatherRes.getTempDay().setDataByDay(jsonRes, day);
                weatherRes.getTempMax().setDataByDay(jsonRes, day);
                weatherRes.getTempMin().setDataByDay(jsonRes, day);
                weatherRes.getWeatherDescription().setDataByDay(jsonRes, day);
                weatherRes.getWeatherIcon().setDataByDay(jsonRes, day);
                weatherRes.getWeatherMain().setDataByDay(jsonRes, day);
                weatherRes.getWind().setDataByDay(jsonRes, day);
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
