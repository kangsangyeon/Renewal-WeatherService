package com.renewal.weatherservicev2.service.raw_data.living_and_health.specific;

import com.renewal.weatherservicev2.domain.entity.common.BigRegion;
import com.renewal.weatherservicev2.domain.entity.external.living_and_health.StrokeIdx;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health.StrokeIdxReq;
import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthRes;
import com.renewal.weatherservicev2.repository.living_and_health.StrokeIdxRepository;
import com.renewal.weatherservicev2.service.connection.LivingAndHealthConnectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StrokeIdxService {

    private final StrokeIdxRepository strokeIdxRepository;
    private final LivingAndHealthConnectionService connectionService;

    public void callAndSaveData(String date, BigRegion bigRegion) {
        StrokeIdx strokeIdx = callData(date, bigRegion.getAdmCode());
        strokeIdx.joinRegion(bigRegion);
        saveData(strokeIdx);
    }

    public StrokeIdx callData(String date, String admCode) {
        OpenApiRequestInterface request = StrokeIdxReq.builder()
                .admCode(admCode)
                .date(date)
                .build();

        LivingAndHealthRes response = connectionService.connectAndGetParsedResponse(request);
        StrokeIdx data = new StrokeIdx();
        return data.from(response);
    }

    private void saveData(StrokeIdx strokeIdx) {
        strokeIdxRepository.save(strokeIdx);
    }

}
