package com.renewal.weatherservicev2.domain.entity.external;

import com.renewal.weatherservicev2.domain.entity.external.living_and_health.AsthmaIdx;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health.AsthmaIdxRequestVO;
import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthResponseVO;
import com.renewal.weatherservicev2.service.connection.LivingAndHealthConnectionService;
import com.renewal.weatherservicev2.util.DateTimeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AsthmaIdxTest {

    @Autowired
    private DateTimeUtil dateTimeUtil;

    @Autowired
    LivingAndHealthConnectionService connectionService;

    @Test
    void from() {

        OpenApiRequestInterface request = AsthmaIdxRequestVO.builder()
                .admCode("1100000000")
                .date(dateTimeUtil.getYesterdayYYYYMMDD())
                .build();

        LivingAndHealthResponseVO response = connectionService.connectAndGetParsedResponse(request);
        AsthmaIdx asthmaIdx =  AsthmaIdx.builder()
                .dateTime(response.getDateTime())
                .asthmaIdxDay1(response.getDay1())
                .asthmaIdxDay2(response.getDay2())
                .asthmaIdxDay3(response.getDay3())
                .asthmaIdxDay4(response.getDay4())
                .build();

        assertEquals(response.getDateTime(), asthmaIdx.getDateTime());
        assertEquals(response.getDay1(), asthmaIdx.getAsthmaIdxDay1());
    }
}