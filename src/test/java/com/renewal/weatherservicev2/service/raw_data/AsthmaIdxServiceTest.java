package com.renewal.weatherservicev2.service.raw_data;

import com.renewal.weatherservicev2.domain.entity.external.AsthmaIdx;
import com.renewal.weatherservicev2.domain.vo.HealthResponseVO;
import com.renewal.weatherservicev2.domain.vo.openapi.HealthAsthmaIdxUrlRequestVO;
import com.renewal.weatherservicev2.repository.AsthmaIdxRepository;
import com.renewal.weatherservicev2.service.connection.ConnectionService;
import com.renewal.weatherservicev2.service.parser.HealthJsonParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AsthmaIdxServiceTest {

    @Autowired
    private ConnectionService connectionService;

    @Autowired
    private HealthJsonParser healthJsonParser;

    @Autowired
    private AsthmaIdxRepository asthmaIdxRepository;

    @Test
    void connectAndSave() {

        HealthAsthmaIdxUrlRequestVO request = HealthAsthmaIdxUrlRequestVO.builder()
                .admCode("1100000000")
                .date("20210922")
                .build();

        URL url = request.makeUrl();
        String data = connectionService.connect(url);

        HealthResponseVO response = healthJsonParser.parseFrom(data);
        AsthmaIdx asthmaIdx = response.makeAsthmaIdx();
        asthmaIdxRepository.save(asthmaIdx);
    }
}