package com.renewal.weatherservicev2.domain.entity.external.abstr;

import com.renewal.weatherservicev2.domain.entity.common.BigRegion;
import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthRes;

public interface LivingAndHealthIdx {

    LivingAndHealthIdx from(LivingAndHealthRes response);

    void joinRegion(BigRegion bigRegion);

}
