package com.renewal.weatherservicev2.domain.vo.openapi.request.living;

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
 * 자외선지수
 * 낮음 0~2, 보통 3~5, 높음 6~7, 매우 높음 8~10, 위험 11이상
 * 자료제공기간 : 연중
 */
@Slf4j
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UVIdxRequestVO extends LivingAndHealthIdxRequestVO implements OpenApiRequestInterface {

    private String admCode;      // 행정동코드
    private String date;         // YYYYMMDD

    public URL makeUrl() {
        try {
            String url = OpenApiURL.OPEN_API_URL_FOR_LIVING + OpenApiURL.SUB_URL_FOR_UV_IDX + makeCommonSubUrl(admCode, date);
            return new URL(url);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
