package com.renewal.weatherservicev2.domain.vo.openapi.response.weather;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HourlyOpenApiRes {
    private String rainPer;
    private String temp;
    private String weatherIcon;
    private String weatherMain;
    private String weatherDescription;
}
