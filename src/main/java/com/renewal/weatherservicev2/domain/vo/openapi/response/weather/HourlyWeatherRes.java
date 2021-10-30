package com.renewal.weatherservicev2.domain.vo.openapi.response.weather;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HourlyWeatherRes {
    private String weatherIcon;
    private String weatherMain;
    private String weatherDescription;

    private String temp;
    private String rainPer;
    private String humidity;
    private String windSpeed;
}
