package com.renewal.weatherservicev2.controller;

import com.renewal.weatherservicev2.service.raw_data.living_and_health.common.LivingAndHealthIdxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DevController {

    private final LivingAndHealthIdxService livingAndHealthIdxService;

    @PostMapping("/dev/living_and_health_idx")
    public void saveLivingAndHealthIdx(@RequestBody TestVO request) {
        livingAndHealthIdxService.getDataFromOpenApiAndSaveByRegion(request.getAdmCode(), request.getDate());
    }

}
