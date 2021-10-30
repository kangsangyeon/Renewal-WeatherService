package com.renewal.weatherservicev2.service.raw_data.living_and_health.common;

import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health.UVIdxReq;
import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthRes;
import com.renewal.weatherservicev2.service.connection.ApiConnection;
import com.renewal.weatherservicev2.service.parser.json.LivingAndHealthJsonParser;
import com.renewal.weatherservicev2.util.DateTimeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;

@SpringBootTest
class LivingAndHealthIdxServiceTest {

    @Autowired
    private DateTimeUtil dateTimeUtil;

    @Autowired
    private ApiConnection apiConnection;

    @Autowired
    private LivingAndHealthJsonParser livingAndHealthJsonParser;

    @Test
    void connectAndParsedResponse() {

        OpenApiRequestInterface request = UVIdxReq.builder()
                .admCode("1100000000")
                .date(dateTimeUtil.getYesterdayYYYYMMDD())
                .build();

        URL url = request.makeUrl();
        String  data = apiConnection.connect(url);

        LivingAndHealthRes response = livingAndHealthJsonParser.parseFrom(data);
        System.out.println(response.toString());
    }
}
