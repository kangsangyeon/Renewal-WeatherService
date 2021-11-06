package com.renewal.weatherservicev2.controller;

import com.renewal.weatherservicev2.domain.entity.common.BigRegion;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.weather.WeatherReq;
import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.WeatherRes;
import com.renewal.weatherservicev2.repository.common.BigRegionRepository;
import com.renewal.weatherservicev2.service.connection.WeatherConnectionService;
import com.renewal.weatherservicev2.service.raw_data.living_and_health.common.LivingAndHealthIdxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DevController {

    private final BigRegionRepository bigRegionRepository;
    private final LivingAndHealthIdxService livingAndHealthIdxService;

    private final WeatherConnectionService weatherConnectionService;

    @PostMapping("/dev/living_and_health_idx")
    public void saveLivingAndHealthIdx(@RequestBody TestVO request) {
        BigRegion bigRegion = bigRegionRepository.findByAdmCode(request.getAdmCode());
        livingAndHealthIdxService.callDataFromOpenApiAndSaveByRegion(request.getDate(), bigRegion);
    }

    @GetMapping("/dev/weathers")
    public WeatherRes test() {

        OpenApiRequestInterface request = WeatherReq.builder()
                .latitude("37.5638")
                .longitude("126.9084")
                .build();

        return weatherConnectionService.connectAndGetParsedResponse(request);
    }
}
