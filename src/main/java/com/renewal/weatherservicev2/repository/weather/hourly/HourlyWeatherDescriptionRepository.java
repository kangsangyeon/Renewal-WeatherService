package com.renewal.weatherservicev2.repository.weather.hourly;

import com.renewal.weatherservicev2.domain.entity.external.weather.hourly.HourlyWeatherDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HourlyWeatherDescriptionRepository extends JpaRepository<HourlyWeatherDescription, Long> {
}
