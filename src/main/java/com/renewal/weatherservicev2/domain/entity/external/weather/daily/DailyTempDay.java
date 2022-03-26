package com.renewal.weatherservicev2.domain.entity.external.weather.daily;

import com.renewal.weatherservicev2.domain.entity.external.abstr.DailyWeather;
import com.renewal.weatherservicev2.domain.entity.external.abstr.DailyWeatherInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.DailyRes;
import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.WeatherRes;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DailyTempDay extends DailyWeather implements DailyWeatherInterface {

    @Id
    @Column(name = "daily_temp_day_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public static DailyTempDay createFrom(WeatherRes weatherRes) {
        DailyRes response = weatherRes.getDaily().getTempDay();
        return DailyTempDay.builder()
                           .day1(response.getDay1())
                           .day2(response.getDay2())
                           .day3(response.getDay3())
                           .day4(response.getDay4())
                           .day5(response.getDay5())
                           .day6(response.getDay6())
                           .day7(response.getDay7())
                           .build();
    }
}
