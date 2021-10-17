package com.renewal.weatherservicev2.domain.vo.openapi.response;

import com.renewal.weatherservicev2.domain.entity.external.AsthmaIdx;
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

    public AsthmaIdx makeAsthmaIdx() {
        return AsthmaIdx.builder()
                .dateTime(this.getDateTime())
                .asthmaIdxDay1(this.getDay1())
                .asthmaIdxDay2(this.getDay2())
                .asthmaIdxDay3(this.getDay3())
                .asthmaIdxDay4(this.getDay4())
                .build();
    }
}
