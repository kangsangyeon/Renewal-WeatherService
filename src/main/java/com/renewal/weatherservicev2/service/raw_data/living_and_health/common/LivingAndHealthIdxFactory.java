package com.renewal.weatherservicev2.service.raw_data.living_and_health.common;

import com.renewal.weatherservicev2.exception.NonServicePeriodException;
import com.renewal.weatherservicev2.service.raw_data.living_and_health.specific.*;
import com.renewal.weatherservicev2.util.OpenApiTypeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class LivingAndHealthIdxFactory {

    private OpenApiTypeUtil openApiTypeUtil;
    private final AsthmaIdxService asthmaIdxService;
    private final ColdIdxService coldIdxService;
    private final FoodPoisoningIdxService foodPoisoningIdxService;
    private final OakPollenIdxService oakPollenIdxService;
    private final PinePollenIdxService pinePollenIdxService;
    private final StrokeIdxService strokeIdxService;
    private final UvIdxService uvIdxService;
    private final WeedsPollenRiskIdxService weedsPollenRiskIdxService;

    public void getDataFromOpenApiAndSaveLivingAndHealthIdx(String type, String admCode, String date) {
        try {
            switch (type.toUpperCase()) {
                case OpenApiTypeUtil.ASTHMA:
                    asthmaIdxService.callAndSaveData(admCode, date);
                    break;
                case OpenApiTypeUtil.COLD:
                    coldIdxService.callAndSaveData(admCode, date);
                    break;
                case OpenApiTypeUtil.FOOD_POISONING:
                    foodPoisoningIdxService.callAndSaveData(admCode, date);
                    break;
                case OpenApiTypeUtil.OAK_POLLEN_RISK:
                    oakPollenIdxService.callAndSaveData(admCode, date);
                    break;
                case OpenApiTypeUtil.PINE_POLLEN_RISK:
                    pinePollenIdxService.callAndSaveData(admCode, date);
                    break;
                case OpenApiTypeUtil.STROKE:
                    strokeIdxService.callAndSaveData(admCode, date);
                    break;
                case OpenApiTypeUtil.UV:
                    uvIdxService.callAndSaveData(admCode, date);
                    break;
                case OpenApiTypeUtil.WEEDS_POLLEN_RISK:
                    weedsPollenRiskIdxService.callAndSaveData(admCode, date);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (NonServicePeriodException e) {
            log.error(e.getMessage());

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}
