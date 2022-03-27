package com.renewal.weatherservicev2.service.raw_data.geo;

import com.renewal.weatherservicev2.domain.vo.CoordinateVO;
import com.renewal.weatherservicev2.domain.vo.RegionVO;
import com.renewal.weatherservicev2.domain.vo.TMCoordinateVO;
import com.renewal.weatherservicev2.domain.vo.openapi.request.geo.ConvertWGS84ToWTMReq;
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

    public RegionVO reverseGeocoding(CoordinateVO coordinate) {

        ReverseGeocodingReq request = new ReverseGeocodingReq(coordinate.getLongitude(), coordinate.getLatitude());

        return geoApiConnectionService.reverseGeocoding(request);
    }

    public TMCoordinateVO convertWGS84ToWTM(CoordinateVO coordinateVO) {

        ConvertWGS84ToWTMReq request = new ConvertWGS84ToWTMReq(coordinateVO);

        return geoApiConnectionService.convertWGS84ToWTM(request);
    }
}
