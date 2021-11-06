package com.renewal.weatherservicev2.domain.entity.external.weather.daily;

import com.renewal.weatherservicev2.domain.entity.external.abstr.DailyWeather;
import com.renewal.weatherservicev2.domain.entity.external.abstr.DailyWeatherInterface;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyHumidity extends DailyWeather implements DailyWeatherInterface {

    @Id
    @Column(name = "daily_humidity_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
