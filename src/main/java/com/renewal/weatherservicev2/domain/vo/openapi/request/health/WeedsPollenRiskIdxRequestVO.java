package com.renewal.weatherservicev2.domain.vo.openapi.request.health;

import com.renewal.weatherservicev2.domain.vo.openapi.abstr.LivingAndHealthIdxRequestVO;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.util.Const;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;

/**
 * 꽃가루농도위험지수(잡초류)
 * 낮음 0, 보통 1, 높음 2, 매우 높음 3
 * 자료제공기간 : 8월 ~ 10월
 */
@Slf4j
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeedsPollenRiskIdxRequestVO extends LivingAndHealthIdxRequestVO implements OpenApiRequestInterface {

    private String admCode;      // 행정동코드
    private String date;         // YYYYMMDD

    public URL makeUrl() {
        try {
            String url = Const.OPEN_API_URL_FOR_HEALTH + Const.SUB_URL_FOR_WEEDS_POLLEN_RISK_IDX + makeCommonSubUrl(admCode, date);
            return new URL(url);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
