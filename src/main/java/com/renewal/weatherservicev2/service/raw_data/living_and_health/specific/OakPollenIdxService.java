package com.renewal.weatherservicev2.service.raw_data.living_and_health.specific;

import com.renewal.weatherservicev2.domain.entity.external.living_and_health.AsthmaIdx;
import com.renewal.weatherservicev2.domain.entity.external.living_and_health.OakPollenRiskIdx;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health.AsthmaIdxRequestVO;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health.OakPollenRiskIdxRequestVO;
import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthResponseVO;
import com.renewal.weatherservicev2.repository.living_and_health.OakPollenRiskIdxRepository;
import com.renewal.weatherservicev2.service.connection.LivingAndHealthConnectionService;
import com.renewal.weatherservicev2.service.raw_data.living_and_health.common.LivingAndHealthIdxService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OakPollenIdxService {

    private final OakPollenRiskIdxRepository oakPollenRiskIdxRepository;
    private final LivingAndHealthConnectionService connectionService;

    public void getAndSaveData(String admCode, String date) {
        OakPollenRiskIdx oakPollenRiskIdx = getData(admCode, date);
        saveData(oakPollenRiskIdx);
    }

    public OakPollenRiskIdx getData(String admCode, String date) {
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
