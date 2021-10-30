package com.renewal.weatherservicev2.domain.vo;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CoordinateReq {
    private String latitude;
    private String longitude;
}
