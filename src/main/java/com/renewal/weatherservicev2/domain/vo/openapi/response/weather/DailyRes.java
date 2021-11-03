package com.renewal.weatherservicev2.domain.vo.openapi.response.weather;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.renewal.weatherservicev2.domain.entity.external.abstr.DailyWeatherType;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DailyRes {

    @JsonIgnore
    private DailyWeatherType type;

    private String day1;
    private String day2;
    private String day3;
    private String day4;
    private String day5;
    private String day6;
    private String day7;

    public static DailyRes create(DailyWeatherType type) {
        return DailyRes.builder()
                .type(type)
                .build();
    }

    public void setDataByDay(String value, int day) {
        switch (day) {
            case 1:
                this.day1 = value;
            case 2:
                this.day2 = value;
                break;
            case 3:
                this.day3 = value;
                break;
            case 4:
                this.day4 = value;
                break;
            case 5:
                this.day5 = value;
                break;
            case 6:
                this.day6 = value;
                break;
            case 7:
                this.day7 = value;
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
