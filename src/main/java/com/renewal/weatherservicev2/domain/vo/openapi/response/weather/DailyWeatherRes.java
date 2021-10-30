package com.renewal.weatherservicev2.domain.vo.openapi.response.weather;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DailyWeatherRes {
    private String weatherIcon;
    private String weatherMain;
    private String weatherDescription;

    private String tempDay;
    private String tempMin;
    private String tempMax;

    private String rainPer;
    private String humidity;
    private String windSpeed;
}
