package com.renewal.weatherservicev2.domain.vo.openapi.request;

import com.renewal.weatherservicev2.domain.vo.openapi.abstr.HealthIdxRequestVO;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.util.Const;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;

@Slf4j
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PinePollenRiskIdxRequestVO extends HealthIdxRequestVO implements OpenApiRequestInterface {

    private String admCode;      // 행정동코드
    private String date;         // YYYYMMDD

    public URL makeUrl() {
        try {
            String url = Const.OPEN_API_URL_FOR_HEALTH + Const.SUB_URL_FOR_PINE_POLLEN_RISK_IDX + makeCommonSubUrl(admCode, date);
            return new URL(url);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
