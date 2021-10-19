package com.renewal.weatherservicev2.service.raw_data.living_and_health.specific;

import com.renewal.weatherservicev2.domain.entity.external.living_and_health.FoodPoisoningIdx;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health.AsthmaIdxRequestVO;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health.FoodPoisoningIdxRequestVO;
import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthResponseVO;
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

    public void getAndSaveData(String admCode, String date) {
        FoodPoisoningIdx foodPoisoningIdx = getData(admCode, date);
        saveData(foodPoisoningIdx);
    }

    public FoodPoisoningIdx getData(String admCode, String date) {
        OpenApiRequestInterface request = FoodPoisoningIdxRequestVO.builder()
                .admCode(admCode)
                .date(date)
                .build();

        LivingAndHealthResponseVO response = connectionService.connectAndGetParsedResponse(request);
        FoodPoisoningIdx data = new FoodPoisoningIdx();
        return data.from(response);
    }

    private void saveData(FoodPoisoningIdx foodPoisoningIdx) {
        foodPoisoningIdxRepository.save(foodPoisoningIdx);
    }
}
