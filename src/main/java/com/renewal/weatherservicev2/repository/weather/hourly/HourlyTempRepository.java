package com.renewal.weatherservicev2.repository.weather.hourly;

import com.renewal.weatherservicev2.domain.entity.external.weather.hourly.HourlyTemp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HourlyTempRepository extends JpaRepository<HourlyTemp, Long> {
}
