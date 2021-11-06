package com.renewal.weatherservicev2.domain.entity.external.abstr;

import com.renewal.weatherservicev2.domain.entity.common.BaseTime;
import lombok.Getter;

import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
public abstract class DailyWeather extends BaseTime {
    private String day1;
    private String day2;
    private String day3;
    private String day4;
    private String day5;
    private String day6;
    private String day7;
}
