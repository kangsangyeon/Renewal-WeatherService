package com.renewal.weatherservicev2.service;

import com.renewal.weatherservicev2.domain.vo.openapi.HealthAsthmaIdxUrlRequestVO;
import com.renewal.weatherservicev2.service.connection.ConnectionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HealthServiceTest {

    @Autowired
    private ConnectionService connectionService;

    @Test
    void connectTest() {

        HealthAsthmaIdxUrlRequestVO request = HealthAsthmaIdxUrlRequestVO.builder()
                .admCode("1100000000")
                .date("20210922")
                .build();

        URL url = request.makeUrl();
        String data = connectionService.connect(url);
        System.out.println(data);
    }

}