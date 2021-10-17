package com.renewal.weatherservicev2.domain.entity.external;

import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.health.AsthmaIdxRequestVO;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living.UVIdxRequestVO;
import com.renewal.weatherservicev2.domain.vo.openapi.response.health.abstr.LivingAndHealthResponseVO;
import com.renewal.weatherservicev2.service.raw_data.LivingAndHealthIdxService;
import com.renewal.weatherservicev2.util.DateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AsthmaIdxTest {

    @Autowired
    LivingAndHealthIdxService livingAndHealthIdxService;

    @Test
    void from() {

        OpenApiRequestInterface request = AsthmaIdxRequestVO.builder()
                .admCode("1100000000")
                .date(DateTime.getYesterdayYYYYMMDD())
                .build();

        LivingAndHealthResponseVO response = livingAndHealthIdxService.connectAndGetParsedResponse(request);
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