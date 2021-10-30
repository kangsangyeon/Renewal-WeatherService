package com.renewal.weatherservicev2.domain.vo.openapi.response.weather;

import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiResponseInterface;
import lombok.*;

import java.util.List;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WeatherRes implements OpenApiResponseInterface {
    private List<DailyWeatherRes> dailyWeathers;
    private List<HourlyWeatherRes> hourlyWeathers;
}
