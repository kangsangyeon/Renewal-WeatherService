package com.renewal.weatherservicev2.service.raw_data.living_and_health.common;

import com.renewal.weatherservicev2.domain.entity.common.BigRegion;
import com.renewal.weatherservicev2.repository.common.BigRegionRepository;
import com.renewal.weatherservicev2.util.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class LivingAndHealthIdxBatch {

    private final BigRegionRepository bigRegionRepository;
    private final DateTimeUtil dateTimeUtil;
    private final LivingAndHealthIdxService livingAndHealthIdxService;

    public void callDataFromOpenApiAndSave() {
        String date = dateTimeUtil.getNowYYYYMMDD();
        List<BigRegion> bigRegions = bigRegionRepository.findAll();

        for (BigRegion bigRegion : bigRegions) {
            livingAndHealthIdxService.callDataFromOpenApiAndSaveByRegion(date, bigRegion);
        }
    }
}
