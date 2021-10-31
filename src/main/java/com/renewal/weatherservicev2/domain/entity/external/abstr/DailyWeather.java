package com.renewal.weatherservicev2.domain.entity.external.abstr;

import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.DailyWeatherRes;

public interface DailyWeather {
    public void setDataByDay(DailyWeatherRes request, int day);
}
