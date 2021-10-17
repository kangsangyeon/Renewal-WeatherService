package com.renewal.weatherservicev2.domain.entity.external.living_and_health;

import com.renewal.weatherservicev2.domain.entity.common.BaseTime;
import com.renewal.weatherservicev2.domain.entity.external.abstr.LivingAndHealthIdx;
import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthResponseVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeedsPollenRiskIdx extends BaseTime implements LivingAndHealthIdx {

    @Id
    @Column(name = "weeds_pollen_risk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dateTime;

    @Column
    private String weedsPollenRiskIdxDay1;

    @Column
    private String weedsPollenRiskIdxDay2;

    @Column
    private String weedsPollenRiskIdxDay3;

    @Column
    private String weedsPollenRiskIdxDay4;

    public WeedsPollenRiskIdx from(LivingAndHealthResponseVO response) {
        return WeedsPollenRiskIdx.builder()
                .dateTime(response.getDateTime())
                .weedsPollenRiskIdxDay1(response.getDay1())
                .weedsPollenRiskIdxDay2(response.getDay2())
                .weedsPollenRiskIdxDay3(response.getDay3())
                .weedsPollenRiskIdxDay4(response.getDay4())
                .build();
    }
}
