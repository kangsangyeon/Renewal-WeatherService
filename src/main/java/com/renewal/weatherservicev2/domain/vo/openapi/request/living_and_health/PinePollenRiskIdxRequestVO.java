package com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health;

import com.renewal.weatherservicev2.domain.vo.openapi.abstr.LivingAndHealthIdxRequestVO;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.util.OpenApiURL;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;

/**
 * 꽃가루농도위험지수(소나무)
 * 낮음 0, 보통 1, 높음 2, 매우 높음 3
 * 자료제공기간 : 4 ~ 6월
 */
@Slf4j
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PinePollenRiskIdxRequestVO extends LivingAndHealthIdxRequestVO implements OpenApiRequestInterface {

    private String admCode;      // 행정동코드
    private String date;         // YYYYMMDD

    public URL makeUrl() {
        try {
            String url = OpenApiURL.OPEN_API_URL_FOR_HEALTH + OpenApiURL.SUB_URL_FOR_PINE_POLLEN_RISK_IDX + makeCommonSubUrl(admCode, date);
            return new URL(url);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
