package com.renewal.weatherservicev2.domain.vo.openapi.response.weather;

import com.renewal.weatherservicev2.domain.entity.external.weather.daily.*;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiResponseInterface;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public class WeatherRes implements OpenApiResponseInterface {
    private final DailyHumidity dailyHumidity = new DailyHumidity();
    private final DailyRainPer dailyRainPer = new DailyRainPer();
    private final DailyTempDay dailyTempDay = new DailyTempDay();
    private final DailyTempMax dailyTempMax = new DailyTempMax();
    private final DailyTempMin dailyTempMin = new DailyTempMin();
    private final DailyWeatherDescription dailyWeatherDescription = new DailyWeatherDescription();
    private final DailyWeatherIcon dailyWeatherIcon = new DailyWeatherIcon();
    private final DailyWeatherMain dailyWeatherMain = new DailyWeatherMain();
    private final DailyWind dailyWind = new DailyWind();
}
