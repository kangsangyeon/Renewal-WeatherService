package com.renewal.weatherservicev2.service.raw_data.living_and_health.specific;

import com.renewal.weatherservicev2.domain.entity.external.living_and_health.ColdIdx;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health.ColdIdxRequestVO;
import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthResponseVO;
import com.renewal.weatherservicev2.repository.living_and_health.ColdIdxRepository;
import com.renewal.weatherservicev2.service.connection.LivingAndHealthConnectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ColdIdxService {

    private final ColdIdxRepository coldIdxRepository;
    private final LivingAndHealthConnectionService connectionService;

    public void getAndSaveData(String admCode, String date) {
        ColdIdx coldIdx = getData(admCode, date);
        saveData(coldIdx);
    }

    public ColdIdx getData(String admCode, String date) {
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
