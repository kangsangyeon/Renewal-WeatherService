package com.renewal.weatherservicev2.controller;

import com.renewal.weatherservicev2.domain.entity.common.BigRegion;
import com.renewal.weatherservicev2.domain.entity.common.SmallRegion;
import com.renewal.weatherservicev2.domain.vo.CoordinateVO;
import com.renewal.weatherservicev2.domain.vo.RegionVO;
import com.renewal.weatherservicev2.domain.vo.TMCoordinateVO;
import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.WeatherRes;
import com.renewal.weatherservicev2.repository.common.BigRegionRepository;
import com.renewal.weatherservicev2.repository.common.SmallRegionRepository;
import com.renewal.weatherservicev2.service.raw_data.geo.GeoService;
import com.renewal.weatherservicev2.service.raw_data.living_and_health.common.LivingAndHealthIdxBatch;
import com.renewal.weatherservicev2.service.raw_data.living_and_health.common.LivingAndHealthIdxService;
import com.renewal.weatherservicev2.service.raw_data.weather.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class DevController {

    private final BigRegionRepository bigRegionRepository;
    private final SmallRegionRepository smallRegionRepository;
    private final LivingAndHealthIdxService livingAndHealthIdxService;
    private final WeatherService weatherService;

    private final LivingAndHealthIdxBatch livingAndHealthIdxBatch;

    private final GeoService geoService;

    @GetMapping("/dev/api/do_batch/living_and_health")
    public void devDoBatchLivingAndHealth() {
        livingAndHealthIdxBatch.callDataFromOpenApiAndSave();
    }

    @PostMapping("/dev/living_and_health_idx")
    public void saveLivingAndHealthIdx(@RequestBody TestVO request) {
        BigRegion bigRegion = bigRegionRepository.findByAdmCode(request.getAdmCode());
        livingAndHealthIdxService.callDataFromOpenApiAndSaveByRegion(request.getDate(), bigRegion);
    }

    @GetMapping("/dev/api/simplify/weather")
    public WeatherRes devSimplifyWeather(CoordinateVO coordinateVO) {

        SmallRegion smallRegion = null;

        if (coordinateVO.isNotNull()) {
            RegionVO region = geoService.reverseGeocoding(coordinateVO);
            BigRegion bigRegion = bigRegionRepository.findByName(region.getBigRegion());
            smallRegion = smallRegionRepository.findByBigRegionAndName(bigRegion, region.getSmallRegion()).orElseThrow(null);
        }
        else {
            smallRegion = smallRegionRepository.findById(1L).orElseThrow(null);
        }

        return weatherService.callDataFromOpenApiAndSaveByRegionAfterReturnResult(smallRegion);
    }

    @GetMapping("/dev/api/open_api/reverse_geocoding")
    public RegionVO devReverseGeocoding(CoordinateVO coordinateDto) {
        return geoService.reverseGeocoding(coordinateDto);
    }

    @GetMapping("/dev/api/open_api/convert_wgs84_to_wtm")
    public TMCoordinateVO devConvertWGS84ToWTM(CoordinateVO coordinateVO) {
        return geoService.convertWGS84ToWTM(coordinateVO);
    }

}
