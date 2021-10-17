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
 * 식중독가능지수
 * 관심 55미만, 주의 55이상 71미만, 경고 71이상 86미만, 위험 86이상
 * 자료제공기간 : 연중
 */
@Slf4j
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodPoisoningIdxRequestVO extends LivingAndHealthIdxRequestVO implements OpenApiRequestInterface {

    private String admCode;      // 행정동코드
    private String date;         // YYYYMMDD

    public URL makeUrl() {
        try {
            String url = Const.OPEN_API_URL_FOR_HEALTH + Const.SUB_URL_FOR_FOOD_POISONING_IDX + makeCommonSubUrl(admCode, date);
            return new URL(url);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
