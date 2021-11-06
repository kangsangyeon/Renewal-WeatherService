package com.renewal.weatherservicev2.domain.entity.external.weather.daily;

import com.renewal.weatherservicev2.domain.entity.external.abstr.DailyWeather;
import com.renewal.weatherservicev2.domain.entity.external.abstr.DailyWeatherInterface;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DailyWeatherDescription extends DailyWeather implements DailyWeatherInterface {

    @Id
    @Column(name = "daily_weather_description_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
