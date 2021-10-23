package com.renewal.weatherservicev2.service.scheduler;

import com.renewal.weatherservicev2.config.SchedulingConfig;
import com.renewal.weatherservicev2.service.raw_data.living_and_health.common.LivingAndHealthIdxBatch;
import com.renewal.weatherservicev2.util.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchedulingService {

    private final LivingAndHealthIdxBatch livingAndHealthIdxBatch;

    @Scheduled(cron = "#{@livingAndHealthIdxScheduler}", zone = DateTimeUtil.ASIA_SEOUL)
    public void livingAndHealthIdxScheduler() {
        log.info("## start livingAndHealthIdx batch!");
        livingAndHealthIdxBatch.callDataFromOpenApiAndSave();
        log.info("## end livingAndHealthIdx batch!");
    }
}
