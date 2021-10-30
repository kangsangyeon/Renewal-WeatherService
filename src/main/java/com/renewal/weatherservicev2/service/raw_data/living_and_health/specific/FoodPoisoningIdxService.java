package com.renewal.weatherservicev2.service.raw_data.living_and_health.specific;

import com.renewal.weatherservicev2.domain.entity.common.BigRegion;
import com.renewal.weatherservicev2.domain.entity.external.living_and_health.FoodPoisoningIdx;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health.FoodPoisoningIdxReq;
import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthRes;
import com.renewal.weatherservicev2.repository.living_and_health.FoodPoisoningIdxRepository;
import com.renewal.weatherservicev2.service.connection.LivingAndHealthConnectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FoodPoisoningIdxService {

    private final FoodPoisoningIdxRepository foodPoisoningIdxRepository;
    private final LivingAndHealthConnectionService connectionService;

    public void callAndSaveData(String date, BigRegion bigRegion) {
        FoodPoisoningIdx foodPoisoningIdx = callData(date, bigRegion.getAdmCode());
        foodPoisoningIdx.joinRegion(bigRegion);
        saveData(foodPoisoningIdx);
    }

    private FoodPoisoningIdx callData(String date, String admCode) {
        OpenApiRequestInterface request = FoodPoisoningIdxReq.builder()
                .admCode(admCode)
                .date(date)
                .build();

        LivingAndHealthRes response = connectionService.connectAndGetParsedResponse(request);
        FoodPoisoningIdx data = new FoodPoisoningIdx();
        return data.from(response);
    }

    private void saveData(FoodPoisoningIdx foodPoisoningIdx) {
        foodPoisoningIdxRepository.save(foodPoisoningIdx);
    }
}
