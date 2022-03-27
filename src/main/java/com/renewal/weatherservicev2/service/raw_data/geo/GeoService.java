package com.renewal.weatherservicev2.service.raw_data.geo;

import com.renewal.weatherservicev2.domain.vo.CoordinateReq;
import com.renewal.weatherservicev2.domain.vo.RegionVO;
import com.renewal.weatherservicev2.domain.vo.openapi.request.geo.ReverseGeocodingReq;
import com.renewal.weatherservicev2.service.connection.GeoApiConnectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class GeoService {

    private final GeoApiConnectionService geoApiConnectionService;

    public RegionVO reverseGeocoding(CoordinateReq coordinate) {

        ReverseGeocodingReq request = new ReverseGeocodingReq(coordinate.getLongitude(), coordinate.getLatitude());

        return geoApiConnectionService.connectAndGetParsedResponse(request);
    }
}
