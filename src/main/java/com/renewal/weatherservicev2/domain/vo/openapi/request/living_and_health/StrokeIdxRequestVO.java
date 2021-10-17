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
 * 뇌졸중가능지수
 * 낮음 0, 보통 1, 높음 2, 매우 높음 3
 * 자료제공기간 : 연중
 */
@Slf4j
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StrokeIdxRequestVO extends LivingAndHealthIdxRequestVO implements OpenApiRequestInterface {

    private String admCode;      // 행정동코드
    private String date;         // YYYYMMDD

    public URL makeUrl() {
        try {
            String url = OpenApiURL.OPEN_API_URL_FOR_HEALTH + OpenApiURL.SUB_URL_FOR_STROKE_IDX + makeCommonSubUrl(admCode, date);
            return new URL(url);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
