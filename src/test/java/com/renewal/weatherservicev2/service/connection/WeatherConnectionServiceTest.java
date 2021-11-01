package com.renewal.weatherservicev2.service.connection;

import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiResponseInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.weather.WeatherReq;
import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.common.WeatherRes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeatherConnectionServiceTest {

    @Autowired
    private WeatherConnectionService weatherConnectionService;

    @Test
    void connectAndGetParsedResponse() {

        OpenApiRequestInterface request = WeatherReq.builder()
                .latitude("37.5638")
                .longitude("126.9084")
                .build();

        WeatherRes response = weatherConnectionService.connectAndGetParsedResponse(request);
        System.out.println(response.toString());
    }
}