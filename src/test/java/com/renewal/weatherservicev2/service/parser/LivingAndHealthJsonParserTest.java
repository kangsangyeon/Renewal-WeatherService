package com.renewal.weatherservicev2.service.parser;

import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthResponseVO;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LivingAndHealthJsonParserTest {

    @Autowired
    private CommonJsonParser commonJsonParser;

    @Autowired
    private LivingAndHealthJsonParser livingAndHealthJsonParser;

    @Test
    void parseFrom() {

        String data = "{\"response\":{\"header\":{\"resultCode\":\"00\",\"resultMsg\":\"NORMAL_SERVICE\"},\"body\":{\"dataType\":\"JSON\",\"items\":{\"item\":[{\"code\":\"A07_1\",\"areaNo\":\"1100000000\",\"date\":\"2021101606\",\"today\":\"3\",\"tomorrow\":\"4\",\"dayaftertomorrow\":\"2\",\"twodaysaftertomorrow\":\"\"}]},\"pageNo\":1,\"numOfRows\":10,\"totalCount\":1}}}\n";

        try {
            JSONObject response = livingAndHealthJsonParser.parseContentFrom(data);

            String dateTime = commonJsonParser.parseStringFrom(response, "date");
            String day1 = commonJsonParser.parseStringFrom(response, "today");
            String day2 = commonJsonParser.parseStringFrom(response, "tomorrow");
            String day3 = commonJsonParser.parseStringFrom(response, "dayaftertomorrow");
            String day4 = commonJsonParser.parseStringFrom(response, "twodaysaftertomorrow");

            LivingAndHealthResponseVO result = LivingAndHealthResponseVO.builder()
                    .dateTime(dateTime)
                    .day1(day1)
                    .day2(day2)
                    .day3(day3)
                    .day4(day4)
                    .build();
            String expected = "HealthResponseVO(dateTime=2021101606, day1=3, day2=4, day3=2, day4=)";

            assertEquals(expected, result.toString());

        } catch (Exception e) {
            throw new RuntimeException();
        }

    }
}