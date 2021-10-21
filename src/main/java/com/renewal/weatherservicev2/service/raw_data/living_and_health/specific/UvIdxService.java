package com.renewal.weatherservicev2.service.raw_data.living_and_health.specific;

import com.renewal.weatherservicev2.domain.entity.external.living_and_health.UvIdx;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health.UVIdxRequestVO;
import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthResponseVO;
import com.renewal.weatherservicev2.repository.living_and_health.UvIdxRepository;
import com.renewal.weatherservicev2.service.connection.LivingAndHealthConnectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UvIdxService {

    private final UvIdxRepository uvIdxRepository;
    private final LivingAndHealthConnectionService connectionService;

    public void callAndSaveData(String admCode, String date) {
        UvIdx uvIdx = callData(admCode, date);
        saveData(uvIdx);
    }

    public UvIdx callData(String admCode, String date) {
        OpenApiRequestInterface request = UVIdxRequestVO.builder()
                .admCode(admCode)
                .date(date)
                .build();

        LivingAndHealthResponseVO response = connectionService.connectAndGetParsedResponse(request);
        UvIdx data = new UvIdx();
        return data.from(response);
    }

    private void saveData(UvIdx uvIdx) {
        uvIdxRepository.save(uvIdx);
    }

}
