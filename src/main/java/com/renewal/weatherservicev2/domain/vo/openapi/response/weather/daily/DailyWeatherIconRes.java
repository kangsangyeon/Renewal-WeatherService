package com.renewal.weatherservicev2.domain.vo.openapi.response.weather.daily;

import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.common.DailyWeatherJsonRes;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DailyWeatherIconRes {

    private String day1;
    private String day2;
    private String day3;
    private String day4;
    private String day5;
    private String day6;
    private String day7;

    public void setDataByDay(DailyWeatherJsonRes request, int day) {
        switch (day) {
            case 1:
                this.day1 = request.getWeatherIcon();
                break;
            case 2:
                this.day2 = request.getWeatherIcon();
                break;
            case 3:
                this.day3 = request.getWeatherIcon();
                break;
            case 4:
                this.day4 = request.getWeatherIcon();
                break;
            case 5:
                this.day5 = request.getWeatherIcon();
                break;
            case 6:
                this.day6 = request.getWeatherIcon();
                break;
            case 7:
                this.day7 = request.getWeatherIcon();
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
