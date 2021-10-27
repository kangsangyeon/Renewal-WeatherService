package com.renewal.weatherservicev2.service.connection;

import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health.UVIdxRequestVO;
import com.renewal.weatherservicev2.util.DateTimeUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.MalformedURLException;
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

        OpenApiRequestInterface request = UVIdxRequestVO.builder()
                .admCode("1100000000")
                .date(dateTimeUtil.getYesterdayYYYYMMDD())
                .build();

        URL url = request.makeUrl();
        System.out.println(apiConnection.connect(url));
    }

    @Test
    @DisplayName("기상정보 API 연결 테스트")
    void connectWeatherApi() throws MalformedURLException {
        String lat = "37.5638";
        String lon = "126.9084";
        String urlStr = "https://api.openweathermap.org/data/2.5/onecall?lat=" + lat + "&lon=" + lon + "&exclude=minutely,current&appid=0479c3d98eb03e0a92d9a69ce53b631f&units=metric";
        URL url = new URL(urlStr);
        System.out.println(apiConnection.connect(url));
    }
}