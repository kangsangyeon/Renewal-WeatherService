package com.renewal.weatherservicev2.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "scheduling")
public class SchedulingConfig {

    private String livingAndHealthIdxScheduler;

    @Bean
    public String livingAndHealthIdxScheduler() {
        return livingAndHealthIdxScheduler;
    }
}
