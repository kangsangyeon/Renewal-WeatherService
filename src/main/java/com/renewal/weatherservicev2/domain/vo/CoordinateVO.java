package com.renewal.weatherservicev2.domain.vo;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CoordinateVO {

    private String longitude;

    private String latitude;

    public boolean isNotNull() {
        return longitude != null && latitude != null;
    }
}
