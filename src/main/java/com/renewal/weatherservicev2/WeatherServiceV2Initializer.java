package com.renewal.weatherservicev2;

import com.renewal.weatherservicev2.service.raw_data.region.RegionInitializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class WeatherServiceV2Initializer implements ApplicationRunner {

    private final RegionInitializer regionInitializer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("## WeatherServiceV2Application started! start initialize.");
//        regionInitializer.initialize();
    }
}
