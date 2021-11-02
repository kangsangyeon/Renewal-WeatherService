package com.renewal.weatherservicev2.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OpenApiType {

    // 생활기상지수, 보건기상지수
    public static final String ASTHMA = "ASTHMA";
    public static final String COLD = "COLD";
    public static final String FOOD_POISONING = "FOOD_POISONING";
    public static final String OAK_POLLEN_RISK = "OAK_POLLEN_RISK";
    public static final String PINE_POLLEN_RISK = "PINE_POLLEN_RISK";
    public static final String STROKE = "STROKE";
    public static final String UV = "UV";
    public static final String WEEDS_POLLEN_RISK = "WEEDS_POLLEN_RISK";

    public static List<String> livingAndHealthOpenApiTypeList = new ArrayList<>(8);

    static {
        initializeLivingAndHealthOpenApiTypeList();
    }

    public static void initializeLivingAndHealthOpenApiTypeList() {
        livingAndHealthOpenApiTypeList.add(ASTHMA);
        livingAndHealthOpenApiTypeList.add(COLD);
        livingAndHealthOpenApiTypeList.add(FOOD_POISONING);
        livingAndHealthOpenApiTypeList.add(OAK_POLLEN_RISK);
        livingAndHealthOpenApiTypeList.add(PINE_POLLEN_RISK);
        livingAndHealthOpenApiTypeList.add(STROKE);
        livingAndHealthOpenApiTypeList.add(UV);
        livingAndHealthOpenApiTypeList.add(WEEDS_POLLEN_RISK);
    }

    // 날씨
    public static final String HUMIDITY = "HUMIDITY";
    public static final String RAIN_PER = "RAIN_PER";
    public static final String WIND = "WIND";
    public static final String TEMP_DAY = "TEMP_DAY";
    public static final String TEMP_MAX = "TEMP_MAX";
    public static final String TEMP_MIN = "TEMP_MIN";
    public static final String TEMP_HOUR = "TEMP_HOUR";
    public static final String WEATHER_MAIN = "WEATHER_MAIN";
    public static final String WEATHER_ICON = "WEATHER_ICON";
    public static final String WEATHER_DESCRIPTION = "WEATHER_DESCRIPTION";
}
