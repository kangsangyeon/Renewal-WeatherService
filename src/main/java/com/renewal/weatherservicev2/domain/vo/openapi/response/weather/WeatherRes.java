package com.renewal.weatherservicev2.domain.vo.openapi.response.weather;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WeatherRes {
    private DailyWeatherRes dailyWeatherRes;
    private HourlyWeatherRes hourlyWeatherRes;
}
