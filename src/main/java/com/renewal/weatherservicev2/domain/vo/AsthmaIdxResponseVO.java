package com.renewal.weatherservicev2.domain.vo;

import com.renewal.weatherservicev2.domain.vo.openapi.OpenApiResponseVO;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AsthmaIdxResponseVO implements OpenApiResponseVO {

    private int uvDay1;
    private int uvDay2;
    private int uvDay3;
    private int uvDay4;

}
