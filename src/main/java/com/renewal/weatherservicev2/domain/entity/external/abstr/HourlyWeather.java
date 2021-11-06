package com.renewal.weatherservicev2.domain.entity.external.abstr;

import com.renewal.weatherservicev2.domain.entity.common.BaseTime;
import lombok.Getter;

import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
public abstract class HourlyWeather extends BaseTime {
    private String hour1;
    private String hour2;
    private String hour3;
    private String hour4;
    private String hour5;
    private String hour6;
    private String hour7;
    private String hour8;
    private String hour9;
    private String hour10;
    private String hour11;
    private String hour12;
    private String hour13;
    private String hour14;
    private String hour15;
    private String hour16;
    private String hour17;
    private String hour18;
    private String hour19;
    private String hour20;
    private String hour21;
    private String hour22;
    private String hour23;
    private String hour24;
}
