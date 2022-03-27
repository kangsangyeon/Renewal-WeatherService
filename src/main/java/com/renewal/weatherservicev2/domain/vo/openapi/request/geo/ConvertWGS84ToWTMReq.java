package com.renewal.weatherservicev2.domain.vo.openapi.request.geo;


import com.renewal.weatherservicev2.domain.vo.CoordinateVO;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.util.OpenApiURL;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConvertWGS84ToWTMReq implements OpenApiRequestInterface {

    /**
     * 경도입니다. 경도는 지구 위 X 위치를 나타내는 값입니다.
     */
    private String longitude;

    /**
     * 위도입니다. 위도는 지구 위 Y 위치를 나타내는 값입니다.
     */
    private String latitude;

    public ConvertWGS84ToWTMReq(CoordinateVO coordinate) {
        this.longitude = coordinate.getLongitude();
        this.latitude = coordinate.getLatitude();
    }

    public URL makeUrl() {
        try {
            String url = OpenApiURL.OPEN_API_URL_FOR_KAKAO_TRANSCOORD + "&x=" + longitude + "&y=" + latitude;
            return new URL(url);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }

}
