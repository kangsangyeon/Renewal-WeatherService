package com.renewal.weatherservicev2.repository.weather.daily;

import com.renewal.weatherservicev2.domain.entity.external.weather.daily.DailyRainPer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyRainPerRepository extends JpaRepository<DailyRainPer, Long> {
}
