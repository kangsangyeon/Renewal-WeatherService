package com.renewal.weatherservicev2.service.raw_data.living_and_health.common;

import com.renewal.weatherservicev2.domain.entity.common.BigRegion;
import com.renewal.weatherservicev2.repository.common.BigRegionRepository;
import com.renewal.weatherservicev2.util.OpenApiTypeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class LivingAndHealthIdxService {

    private final BigRegionRepository bigRegionRepository;
    private final LivingAndHealthIdxFactory factory;

    public void getDataFromOpenApiAndSaveByRegion(String admCode, String date) {
        List<String> apiTypes = OpenApiTypeUtil.livingAndHealthOpenApiTypeList;
        BigRegion bigRegion = bigRegionRepository.findByAdmCode(admCode);

        for (String type : apiTypes) {
            factory.getDataFromOpenApiAndSaveLivingAndHealthIdx(type, date, bigRegion);
        }
    }
}
