package com.renewal.weatherservicev2.service.raw_data.living_and_health.specific;

import com.renewal.weatherservicev2.domain.entity.external.living_and_health.ColdIdx;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health.ColdIdxRequestVO;
import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthResponseVO;
import com.renewal.weatherservicev2.exception.NonServicePeriodException;
import com.renewal.weatherservicev2.repository.living_and_health.ColdIdxRepository;
import com.renewal.weatherservicev2.service.connection.LivingAndHealthConnectionService;
import com.renewal.weatherservicev2.util.DateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ColdIdxService {

    private final ColdIdxRepository coldIdxRepository;
    private final LivingAndHealthConnectionService connectionService;

    public void callAndSaveData(String admCode, String date) throws NonServicePeriodException {
        ColdIdx coldIdx = callData(admCode, date);
        saveData(coldIdx);
    }

    public ColdIdx callData(String admCode, String date) throws NonServicePeriodException {

        if(DateTime.getMonthYYYYMMDD(date) >= 5 && DateTime.getMonthYYYYMMDD(date) <= 8) {
            throw new NonServicePeriodException("감기가능지수 자료제공기간인 4-9월이 아닙니다.");
        }

        OpenApiRequestInterface request = ColdIdxRequestVO.builder()
                .admCode(admCode)
                .date(date)
                .build();

        LivingAndHealthResponseVO response = connectionService.connectAndGetParsedResponse(request);
        ColdIdx data = new ColdIdx();
        return data.from(response);
    }

    private void saveData(ColdIdx coldIdx) {
        coldIdxRepository.save(coldIdx);
    }

}
