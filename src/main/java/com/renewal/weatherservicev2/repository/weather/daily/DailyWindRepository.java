package com.renewal.weatherservicev2.repository.weather.daily;

import com.renewal.weatherservicev2.domain.entity.external.weather.daily.DailyWind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyWindRepository extends JpaRepository<DailyWind, Long> {
}
