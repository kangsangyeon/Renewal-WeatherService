package com.renewal.weatherservicev2.repository.weather.daily;

import com.renewal.weatherservicev2.domain.entity.external.weather.daily.DailyTempMin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyTempMinRepository extends JpaRepository<DailyTempMin, Long> {
}
