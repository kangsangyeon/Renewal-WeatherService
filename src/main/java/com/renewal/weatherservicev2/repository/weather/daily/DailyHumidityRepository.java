package com.renewal.weatherservicev2.repository.weather.daily;

import com.renewal.weatherservicev2.domain.entity.external.weather.daily.DailyHumidity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyHumidityRepository extends JpaRepository<DailyHumidity, Long> {
}
