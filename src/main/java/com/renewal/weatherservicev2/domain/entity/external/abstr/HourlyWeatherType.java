package com.renewal.weatherservicev2.domain.entity.external.abstr;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HourlyWeatherType {
    RAIN_PER,
    TEMP_HOUR,
    WEATHER_MAIN,
    WEATHER_ICON,
    WEATHER_DESCRIPTION;
}
