package com.renewal.weatherservicev2.service.raw_data.living_and_health.specific;

import com.renewal.weatherservicev2.domain.entity.external.living_and_health.AsthmaIdx;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health.AsthmaIdxRequestVO;
import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthResponseVO;
import com.renewal.weatherservicev2.repository.living_and_health.AsthmaIdxRepository;
import com.renewal.weatherservicev2.service.connection.LivingAndHealthConnectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AsthmaIdxService {

    private final AsthmaIdxRepository asthmaIdxRepository;
    private final LivingAndHealthConnectionService connectionService;

    public void callAndSaveData(String admCode, String date) {
        AsthmaIdx asthmaIdx = callData(admCode, date);
        saveData(asthmaIdx);
    }

    private AsthmaIdx callData(String admCode, String date) {
        OpenApiRequestInterface request = AsthmaIdxRequestVO.builder()
                .admCode(admCode)
                .date(date)
                .build();

        LivingAndHealthResponseVO response = connectionService.connectAndGetParsedResponse(request);
        AsthmaIdx data = new AsthmaIdx();
        return data.from(response);
    }

    private void saveData(AsthmaIdx asthmaIdx) {
        asthmaIdxRepository.save(asthmaIdx);
    }
}
