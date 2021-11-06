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
public class HourlyRainPer extends HourlyWeather {

    @Id
    @Column(name = "hourly_rain_per_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
