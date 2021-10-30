package com.renewal.weatherservicev2.service.raw_data.living_and_health.specific;

import com.renewal.weatherservicev2.domain.entity.common.BigRegion;
import com.renewal.weatherservicev2.domain.entity.external.living_and_health.ColdIdx;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health.ColdIdxReq;
import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthRes;
import com.renewal.weatherservicev2.exception.NonServicePeriodException;
import com.renewal.weatherservicev2.repository.living_and_health.ColdIdxRepository;
import com.renewal.weatherservicev2.service.connection.LivingAndHealthConnectionService;
import com.renewal.weatherservicev2.util.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ColdIdxService {

    private final ColdIdxRepository coldIdxRepository;
    private final DateTimeUtil dateTimeUtil;
    private final LivingAndHealthConnectionService connectionService;

    public void callAndSaveData(String date, BigRegion bigRegion) throws NonServicePeriodException {
        ColdIdx coldIdx = callData(date, bigRegion.getAdmCode());
        coldIdx.joinRegion(bigRegion);
        saveData(coldIdx);
    }

    private ColdIdx callData(String date, String admCode) throws NonServicePeriodException {

        if(dateTimeUtil.getMonthYYYYMMDD(date) >= 5 && dateTimeUtil.getMonthYYYYMMDD(date) <= 8) {
            throw new NonServicePeriodException("감기가능지수 자료제공기간인 4-9월이 아닙니다.");
        }

        OpenApiRequestInterface request = ColdIdxReq.builder()
                .admCode(admCode)
                .date(date)
                .build();

        LivingAndHealthRes response = connectionService.connectAndGetParsedResponse(request);
        ColdIdx data = new ColdIdx();
        return data.from(response);
    }

    private void saveData(ColdIdx coldIdx) {
        coldIdxRepository.save(coldIdx);
    }

}
