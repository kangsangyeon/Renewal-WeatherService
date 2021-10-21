package com.renewal.weatherservicev2.service.raw_data.living_and_health.common;

import com.renewal.weatherservicev2.service.raw_data.living_and_health.specific.*;
import com.renewal.weatherservicev2.util.OpenApiType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class LivingAndHealthIdxFactory {

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
                case OpenApiType.ASTHMA:
                    asthmaIdxService.callAndSaveData(admCode, date);
                    break;
                case OpenApiType.COLD:
                    coldIdxService.callAndSaveData(admCode, date);
                    break;
                case OpenApiType.FOOD_POISONING:
                    foodPoisoningIdxService.callAndSaveData(admCode, date);
                    break;
                case OpenApiType.OAK_POLLEN_RISK:
                    oakPollenIdxService.callAndSaveData(admCode, date);
                    break;
                case OpenApiType.PINE_POLLEN_RISK:
                    pinePollenIdxService.callAndSaveData(admCode, date);
                    break;
                case OpenApiType.STROKE:
                    strokeIdxService.callAndSaveData(admCode, date);
                    break;
                case OpenApiType.UV:
                    uvIdxService.callAndSaveData(admCode, date);
                    break;
                case OpenApiType.WEEDS_POLLEN_RISK:
                    weedsPollenRiskIdxService.callAndSaveData(admCode, date);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
