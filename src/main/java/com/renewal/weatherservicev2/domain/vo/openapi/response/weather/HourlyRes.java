package com.renewal.weatherservicev2.domain.vo.openapi.response.weather;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.renewal.weatherservicev2.domain.entity.external.abstr.HourlyWeatherType;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HourlyRes {

    @JsonIgnore
    private HourlyWeatherType type;

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

    public static HourlyRes create(HourlyWeatherType type) {
        return HourlyRes.builder()
                .type(type)
                .build();
    }

    public void setDateByHour(String value, int hour) {
        switch (hour) {
            case 1:
                this.hour1 = value;
                break;
            case 2:
                this.hour2 = value;
                break;
            case 3:
                this.hour3 = value;
                break;
            case 4:
                this.hour4 = value;
                break;
            case 5:
                this.hour5 = value;
                break;
            case 6:
                this.hour6 = value;
                break;
            case 7:
                this.hour7 = value;
                break;
            case 8:
                this.hour8 = value;
                break;
            case 9:
                this.hour9 = value;
                break;
            case 10:
                this.hour10 = value;
                break;
            case 11:
                this.hour11 = value;
                break;
            case 12:
                this.hour12 = value;
                break;
            case 13:
                this.hour13 = value;
                break;
            case 14:
                this.hour14 = value;
                break;
            case 15:
                this.hour15 = value;
                break;
            case 16:
                this.hour16 = value;
                break;
            case 17:
                this.hour17 = value;
                break;
            case 18:
                this.hour18 = value;
                break;
            case 19:
                this.hour19 = value;
                break;
            case 20:
                this.hour20 = value;
                break;
            case 21:
                this.hour21 = value;
                break;
            case 22:
                this.hour22 = value;
                break;
            case 23:
                this.hour23 = value;
                break;
            case 24:
                this.hour24 = value;
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
