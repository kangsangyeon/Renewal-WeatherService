package com.renewal.weatherservicev2.domain.entity.external.abstr;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LivingAndHealthIdxType {
    ASTHMA,
    COLD,
    FOOD_POISONING,
    OAK_POLLEN_RISK,
    PINE_POLLEN_RISK,
    STROKE,
    UV,
    WEEDS_POLLEN_RISK;
}
