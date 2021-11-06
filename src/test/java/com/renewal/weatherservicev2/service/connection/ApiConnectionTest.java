package com.renewal.weatherservicev2.service.connection;

import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health.UVIdxReq;
import com.renewal.weatherservicev2.domain.vo.openapi.request.weather.WeatherReq;
import com.renewal.weatherservicev2.util.DateTimeUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;

@SpringBootTest
class ApiConnectionTest {

    @Autowired
    private DateTimeUtil dateTimeUtil;

    @Autowired
    private ApiConnection apiConnection;

    @Test
    @DisplayName("생활기상지수 API 연결 테스트")
    void connectLivingWeatherIdxApi() {

        OpenApiRequestInterface request = UVIdxReq.builder()
                .admCode("1100000000")
                .date(dateTimeUtil.getYesterdayYYYYMMDD())
                .build();

        URL url = request.makeUrl();
        System.out.println(apiConnection.connect(url));
    }

    @Test
    @DisplayName("기상정보 API 연결 테스트")
    void connectWeatherApi() {

        OpenApiRequestInterface request = WeatherReq.builder()
                .latitude("37.5638")
                .longitude("126.9084")
                .build();

        URL url = request.makeUrl();
        System.out.println(apiConnection.connect(url));
    }
}