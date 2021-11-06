package com.renewal.weatherservicev2.repository.weather.hourly;

import com.renewal.weatherservicev2.domain.entity.external.weather.hourly.HourlyRainPer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HourlyRainPerRepository extends JpaRepository<HourlyRainPer, Long> {
}
