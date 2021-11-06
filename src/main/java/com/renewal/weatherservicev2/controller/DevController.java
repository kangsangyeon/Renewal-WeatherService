package com.renewal.weatherservicev2.controller;

import com.renewal.weatherservicev2.domain.entity.common.BigRegion;
import com.renewal.weatherservicev2.domain.entity.common.SmallRegion;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.weather.WeatherReq;
import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.WeatherRes;
import com.renewal.weatherservicev2.repository.common.BigRegionRepository;
import com.renewal.weatherservicev2.repository.common.SmallRegionRepository;
import com.renewal.weatherservicev2.service.connection.WeatherConnectionService;
import com.renewal.weatherservicev2.service.raw_data.living_and_health.common.LivingAndHealthIdxService;
import com.renewal.weatherservicev2.service.raw_data.weather.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DevController {

    private final BigRegionRepository bigRegionRepository;
    private final SmallRegionRepository smallRegionRepository;
    private final LivingAndHealthIdxService livingAndHealthIdxService;

    private final WeatherService weatherService;

    @PostMapping("/dev/living_and_health_idx")
    public void saveLivingAndHealthIdx(@RequestBody TestVO request) {
        BigRegion bigRegion = bigRegionRepository.findByAdmCode(request.getAdmCode());
        livingAndHealthIdxService.callDataFromOpenApiAndSaveByRegion(request.getDate(), bigRegion);
    }

    @GetMapping("/dev/weathers")
    public WeatherRes test() {
        SmallRegion smallRegion = smallRegionRepository.findById(1L).orElseThrow(null);

        return weatherService.callDataFromOpenApiAndSaveByRegionAfterReturnResult(smallRegion);
    }
}
