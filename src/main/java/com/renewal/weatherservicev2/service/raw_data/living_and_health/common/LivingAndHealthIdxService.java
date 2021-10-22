package com.renewal.weatherservicev2.service.raw_data.living_and_health.common;

import com.renewal.weatherservicev2.util.OpenApiTypeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class LivingAndHealthIdxService {

    private final LivingAndHealthIdxFactory factory;

    public void getDataFromOpenApiAndSaveByRegion(String admCode, String date) {
        List<String> apiTypes = OpenApiTypeUtil.livingAndHealthOpenApiTypeList;

        for (String type : apiTypes) {
            factory.getDataFromOpenApiAndSaveLivingAndHealthIdx(type, admCode, date);
        }
    }
}
