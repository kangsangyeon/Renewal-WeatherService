package com.renewal.weatherservicev2.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class RegionUtil {
    public ClassPathResource csvResource = new ClassPathResource("data/region.csv");
}
