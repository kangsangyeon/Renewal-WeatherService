package com.renewal.weatherservicev2.repository.weather.daily;

import com.renewal.weatherservicev2.domain.entity.external.weather.daily.DailyWeatherMain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyWeatherMainRepository extends JpaRepository<DailyWeatherMain, Long> {
}
