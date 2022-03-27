package com.renewal.weatherservicev2.service.raw_data.living_and_health.common;

import com.renewal.weatherservicev2.domain.entity.common.BigRegion;
import com.renewal.weatherservicev2.domain.entity.external.abstr.LivingAndHealthIdxType;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health.*;
import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthRes;
import com.renewal.weatherservicev2.exception.NonServicePeriodException;
import com.renewal.weatherservicev2.repository.living_and_health.LivingAndHealthInfoRepository;
import com.renewal.weatherservicev2.service.connection.LivingAndHealthConnectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
public class LivingAndHealthService {

    private final LivingAndHealthIdxFactory livingAndHealthIdxFactory;

    private final LivingAndHealthInfoRepository repository;

    private final LivingAndHealthConnectionService connectionService;

    @Transactional
    public void callDataFromOpenApiAndSaveByRegion(String date, BigRegion bigRegion) {
        log.info("## start calling {} region open api data!", bigRegion.getName());
        LivingAndHealthIdxType[] types = LivingAndHealthIdxType.values();

        for (LivingAndHealthIdxType type : types) {
            livingAndHealthIdxFactory.callDataFromOpenApiAndSave(type, date, bigRegion);
        }


    }

    public LivingAndHealthRes getUsingOpenApi(LivingAndHealthIdxType type, String date, String admCode) {

        try {
            OpenApiRequestInterface request = makeRequest(type, date, admCode);

            LivingAndHealthRes response = connectionService.connectAndGetParsedResponse(request);
            return response;

        } catch (NonServicePeriodException e) {
            log.error(e.getMessage());

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }

    private OpenApiRequestInterface makeRequest(LivingAndHealthIdxType type, String date, String admCode) {

        OpenApiRequestInterface request = null;

        switch (type) {
            case ASTHMA:
                request = new AsthmaIdxReq(admCode, date);
                break;
            case COLD:
                request = new ColdIdxReq(admCode, date);
                break;
            case FOOD_POISONING:
                request = new FoodPoisoningIdxReq(admCode, date);
                break;
            case OAK_POLLEN_RISK:
                request = new OakPollenRiskIdxReq(admCode, date);
                break;
            case PINE_POLLEN_RISK:
                request = new PinePollenRiskIdxReq(admCode, date);
                break;
            case STROKE:
                request = new StrokeIdxReq(admCode, date);
                break;
            case UV:
                request = new UVIdxReq(admCode, date);
                break;
            case WEEDS_POLLEN_RISK:
                request = new WeedsPollenRiskIdxReq(admCode, date);
                break;
            default:
                throw new IllegalArgumentException();
        }

        return request;
    }


}
