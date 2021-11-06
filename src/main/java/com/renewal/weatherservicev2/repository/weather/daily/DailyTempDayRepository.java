package com.renewal.weatherservicev2.repository.weather.daily;

import com.renewal.weatherservicev2.domain.entity.external.weather.daily.DailyTempDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyTempDayRepository extends JpaRepository<DailyTempDay, Long> {
}
