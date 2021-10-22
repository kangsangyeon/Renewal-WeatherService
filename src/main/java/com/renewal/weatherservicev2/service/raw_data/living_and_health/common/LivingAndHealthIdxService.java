package com.renewal.weatherservicev2.service.raw_data.living_and_health.common;

import com.renewal.weatherservicev2.service.connection.LivingAndHealthConnectionService;
import com.renewal.weatherservicev2.util.OpenApiType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class LivingAndHealthIdxService {

    private final LivingAndHealthIdxFactory factory;

    // TODO : stream 처리하거나, 최소 for 문 돌리는 걸로 처리하자
    public void getDataFromOpenApiAndSaveByRegion(String admCode, String date) {
        factory.getDataFromOpenApiAndSaveLivingAndHealthIdx(OpenApiType.ASTHMA, admCode, date);
        factory.getDataFromOpenApiAndSaveLivingAndHealthIdx(OpenApiType.COLD, admCode, date);
        factory.getDataFromOpenApiAndSaveLivingAndHealthIdx(OpenApiType.FOOD_POISONING, admCode, date);
        factory.getDataFromOpenApiAndSaveLivingAndHealthIdx(OpenApiType.OAK_POLLEN_RISK, admCode, date);
        factory.getDataFromOpenApiAndSaveLivingAndHealthIdx(OpenApiType.PINE_POLLEN_RISK, admCode, date);
        factory.getDataFromOpenApiAndSaveLivingAndHealthIdx(OpenApiType.STROKE, admCode, date);
        factory.getDataFromOpenApiAndSaveLivingAndHealthIdx(OpenApiType.UV, admCode, date);
        factory.getDataFromOpenApiAndSaveLivingAndHealthIdx(OpenApiType.WEEDS_POLLEN_RISK, admCode, date);
    }
}
