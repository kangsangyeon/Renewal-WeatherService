package com.renewal.weatherservicev2.service.raw_data.living_and_health.specific;

import com.renewal.weatherservicev2.domain.entity.external.living_and_health.AsthmaIdx;
import com.renewal.weatherservicev2.domain.entity.external.living_and_health.PinePollenRiskIdx;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health.AsthmaIdxRequestVO;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health.PinePollenRiskIdxRequestVO;
import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthResponseVO;
import com.renewal.weatherservicev2.repository.living_and_health.PinePollenRiskIdxRepository;
import com.renewal.weatherservicev2.service.connection.LivingAndHealthConnectionService;
import com.renewal.weatherservicev2.service.raw_data.living_and_health.common.LivingAndHealthIdxService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PinePollenIdxService {

    private final PinePollenRiskIdxRepository pinePollenRiskIdxRepository;
    private final LivingAndHealthConnectionService connectionService;

    public void getAndSaveData(String admCode, String date) {
        PinePollenRiskIdx pinePollenRiskIdx = getData(admCode, date);
        saveData(pinePollenRiskIdx);
    }

    public PinePollenRiskIdx getData(String admCode, String date) {
        OpenApiRequestInterface request = PinePollenRiskIdxRequestVO.builder()
                .admCode(admCode)
                .date(date)
                .build();

        LivingAndHealthResponseVO response = connectionService.connectAndGetParsedResponse(request);
        PinePollenRiskIdx data = new PinePollenRiskIdx();
        return data.from(response);
    }

    private void saveData(PinePollenRiskIdx pinePollenRiskIdx) {
        pinePollenRiskIdxRepository.save(pinePollenRiskIdx);
    }

}
