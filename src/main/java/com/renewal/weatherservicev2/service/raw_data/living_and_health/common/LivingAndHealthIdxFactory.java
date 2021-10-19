package com.renewal.weatherservicev2.service.raw_data.living_and_health.common;

import com.renewal.weatherservicev2.service.raw_data.living_and_health.specific.*;
import com.renewal.weatherservicev2.util.OpenApiType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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

    public void getDataFromOpenApiAndSaveLivingAndHealthIdx(String type, String admCode, String date) throws IllegalArgumentException {
        switch (type.toUpperCase()) {
            case OpenApiType.ASTHMA: asthmaIdxService.getAndSaveData(admCode, date); break;
            case OpenApiType.COLD: coldIdxService.getAndSaveData(admCode, date); break;
            case OpenApiType.FOOD_POISONING: foodPoisoningIdxService.getAndSaveData(admCode, date); break;
            case OpenApiType.OAK_POLLEN_RISK: oakPollenIdxService.getAndSaveData(admCode, date); break;
            case OpenApiType.PINE_POLLEN_RISK: pinePollenIdxService.getAndSaveData(admCode, date); break;
            case OpenApiType.STROKE: strokeIdxService.getAndSaveData(admCode, date); break;
            case OpenApiType.UV: uvIdxService.getAndSaveData(admCode, date); break;
            case OpenApiType.WEEDS_POLLEN_RISK: weedsPollenRiskIdxService.getAndSaveData(admCode, date); break;
            default: throw new IllegalArgumentException();
        }
    }

}
