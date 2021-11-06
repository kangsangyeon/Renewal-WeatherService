package com.renewal.weatherservicev2.repository.weather.hourly;

import com.renewal.weatherservicev2.domain.entity.external.weather.hourly.HourlyWeatherMain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HourlyWeatherMainRepository extends JpaRepository<HourlyWeatherMain, Long> {
}
