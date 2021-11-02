package com.renewal.weatherservicev2.service.raw_data.living_and_health.common;

import com.renewal.weatherservicev2.domain.entity.common.BigRegion;
import com.renewal.weatherservicev2.util.OpenApiType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class LivingAndHealthIdxService {

    private final LivingAndHealthIdxFactory livingAndHealthIdxFactory;

    @Transactional
    public void callDataFromOpenApiAndSaveByRegion(String date, BigRegion bigRegion) {
        log.info("## start calling {} region open api data!", bigRegion.getId());
        List<String> types = OpenApiType.livingAndHealthOpenApiTypeList;

        for (String type : types) {
            livingAndHealthIdxFactory.callDataFromOpenApiAndSave(type, date, bigRegion);
        }
    }
}
