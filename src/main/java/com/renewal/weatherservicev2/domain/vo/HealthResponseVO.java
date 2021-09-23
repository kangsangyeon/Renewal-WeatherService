package com.renewal.weatherservicev2.domain.vo;

import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiResponseInterface;
import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HealthResponseVO implements OpenApiResponseInterface {

    private String dateTime;
    private String day1;
    private String day2;
    private String day3;
    private String day4;
}
