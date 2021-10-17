package com.renewal.weatherservicev2.service.connection;

import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.health.ColdIdxRequestVO;
import com.renewal.weatherservicev2.util.DateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;

@SpringBootTest
class ConnectionServiceTest {

    @Autowired
    private ConnectionService connectionService;

    @Test
    @DisplayName("API 연결 테스트")
    void connect() {

        OpenApiRequestInterface request = ColdIdxRequestVO.builder()
                .admCode("1100000000")
                .date(DateTime.getYesterdayYYYYMMDD())
                .build();

        URL url = request.makeUrl();
        System.out.println(connectionService.connect(url));
    }
}