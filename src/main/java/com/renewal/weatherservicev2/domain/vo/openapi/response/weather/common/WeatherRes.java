package com.renewal.weatherservicev2.domain.vo.openapi.response.weather.common;

import com.renewal.weatherservicev2.domain.entity.external.weather.daily.DailyWeatherMain;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiResponseInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.daily.*;
import lombok.*;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@ToString
@MappedSuperclass
@NoArgsConstructor
public class WeatherRes implements OpenApiResponseInterface {
    public final DailyHumidityRes humidity = new DailyHumidityRes();
    public final DailyRainPerRes rainPer = new DailyRainPerRes();
    public final DailyTempDayRes tempDay = new DailyTempDayRes();
    public final DailyTempMaxRes tempMax = new DailyTempMaxRes();
    public final DailyTempMinRes tempMin = new DailyTempMinRes();
    public final DailyWeatherDescriptionRes weatherDescription = new DailyWeatherDescriptionRes();
    public final DailyWeatherMainRes weatherMain = new DailyWeatherMainRes();
    public final DailyWeatherIconRes weatherIcon = new DailyWeatherIconRes();
    public final DailyWindRes wind = new DailyWindRes();
}
