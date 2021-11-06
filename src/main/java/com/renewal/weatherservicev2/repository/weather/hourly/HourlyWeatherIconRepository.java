package com.renewal.weatherservicev2.repository.weather.hourly;

import com.renewal.weatherservicev2.domain.entity.external.weather.hourly.HourlyWeatherIcon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HourlyWeatherIconRepository extends JpaRepository<HourlyWeatherIcon, Long> {
}
