package com.renewal.weatherservicev2.service.raw_data.living_and_health.specific;

import com.renewal.weatherservicev2.domain.entity.external.living_and_health.OakPollenRiskIdx;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health.OakPollenRiskIdxRequestVO;
import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthResponseVO;
import com.renewal.weatherservicev2.exception.NonServicePeriodException;
import com.renewal.weatherservicev2.repository.living_and_health.OakPollenRiskIdxRepository;
import com.renewal.weatherservicev2.service.connection.LivingAndHealthConnectionService;
import com.renewal.weatherservicev2.util.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OakPollenIdxService {

    private final OakPollenRiskIdxRepository oakPollenRiskIdxRepository;
    private final LivingAndHealthConnectionService connectionService;

    public void callAndSaveData(String admCode, String date) throws NonServicePeriodException {
        OakPollenRiskIdx oakPollenRiskIdx = callData(admCode, date);
        saveData(oakPollenRiskIdx);
    }

    public OakPollenRiskIdx callData(String admCode, String date) throws NonServicePeriodException {

        if(DateTimeUtil.getMonthYYYYMMDD(date) <= 3 || DateTimeUtil.getMonthYYYYMMDD(date) >= 7) {
            throw new NonServicePeriodException("꽃가루농도위험지수(참나무) 자료제공기간인 4-6월이 아닙니다.");
        }

        OpenApiRequestInterface request = OakPollenRiskIdxRequestVO.builder()
                .admCode(admCode)
                .date(date)
                .build();

        LivingAndHealthResponseVO response = connectionService.connectAndGetParsedResponse(request);
        OakPollenRiskIdx data = new OakPollenRiskIdx();
        return data.from(response);
    }

    private void saveData(OakPollenRiskIdx oakPollenRiskIdx) {
        oakPollenRiskIdxRepository.save(oakPollenRiskIdx);
    }

}
