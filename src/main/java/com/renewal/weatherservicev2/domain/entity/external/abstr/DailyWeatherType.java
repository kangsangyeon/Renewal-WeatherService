package com.renewal.weatherservicev2.domain.entity.external.abstr;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DailyWeatherType {
    HUMIDITY,
    RAIN_PER,
    WIND,
    TEMP_DAY,
    TEMP_MAX,
    TEMP_MIN,
    WEATHER_MAIN,
    WEATHER_ICON,
    WEATHER_DESCRIPTION;
}
