package com.renewal.weatherservicev2.repository.weather.daily;

import com.renewal.weatherservicev2.domain.entity.external.weather.daily.DailyTempMax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyTempMaxRepository extends JpaRepository<DailyTempMax, Long> {
}
