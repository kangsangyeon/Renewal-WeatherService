package com.renewal.weatherservicev2.domain.vo;

import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiResponseInterface;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AsthmaIdxResponseVO implements OpenApiResponseInterface {

    private int asthmaIdxDay1;
    private int asthmaIdxDay2;
    private int asthmaIdxDay3;
    private int asthmaIdxDay4;
}
