package com.renewal.weatherservicev2.domain.entity.external.abstr;

import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthResponseVO;

public interface LivingAndHealthIdx {
    LivingAndHealthIdx from(LivingAndHealthResponseVO response);
}
