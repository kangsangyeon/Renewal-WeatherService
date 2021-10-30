package com.renewal.weatherservicev2.domain.vo.openapi.request.weather;

import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.util.OpenApiURL;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;

@Slf4j
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherReq implements OpenApiRequestInterface {

    private String latitude;
    private String longitude;

    @Override
    public URL makeUrl() {
        try {
            String url = OpenApiURL.OPEN_API_URL_FOR_WEATHER
                    + "?lat=" + this.getLatitude() + "&lon=" + this.getLatitude()
                    + "&exclude=current,minutely"
                    + "&appid=" + OpenApiURL.URL_KEY_FOR_OPEN_WEATHER_MAP_ORG
                    + "&units=metric";
            return new URL(url);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
