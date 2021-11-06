package com.renewal.weatherservicev2.domain.entity.external.weather.hourly;

import com.renewal.weatherservicev2.domain.entity.external.abstr.HourlyWeather;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HourlyWeatherIcon extends HourlyWeather {

    @Id
    @Column(name = "houly_weather_icon_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
