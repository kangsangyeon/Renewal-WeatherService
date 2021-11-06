package com.renewal.weatherservicev2.domain.entity.external.abstr;

import com.renewal.weatherservicev2.domain.entity.common.BaseTime;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;

@Getter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
public abstract class LivingAndHealthIdx extends BaseTime {
    private String dateTime;
    private String day1;
    private String day2;
    private String day3;
    private String day4;
}
