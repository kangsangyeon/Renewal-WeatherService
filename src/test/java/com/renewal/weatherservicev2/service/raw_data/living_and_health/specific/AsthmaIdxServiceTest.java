package com.renewal.weatherservicev2.service.raw_data.living_and_health.specific;

import com.renewal.weatherservicev2.util.DateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class AsthmaIdxServiceTest {

    @Autowired
    private AsthmaIdxService asthmaIdxService;

    @Test
    @Rollback(value = false)
    void getAndSaveData() {

        String admCode = "1100000000";
        String date = DateTime.getYesterdayYYYYMMDD();

        asthmaIdxService.callAndSaveData(admCode, date);
    }
}