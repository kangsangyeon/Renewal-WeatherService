package com.renewal.weatherservicev2.repository.weather.daily;

import com.renewal.weatherservicev2.domain.entity.external.weather.daily.DailyWeatherIcon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyWeatherIconRepository extends JpaRepository<DailyWeatherIcon, Long> {
}
