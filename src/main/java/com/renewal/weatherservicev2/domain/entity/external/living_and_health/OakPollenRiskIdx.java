package com.renewal.weatherservicev2.domain.entity.external.living_and_health;

import com.renewal.weatherservicev2.domain.entity.common.BaseTime;
import com.renewal.weatherservicev2.domain.entity.common.BigRegion;
import com.renewal.weatherservicev2.domain.entity.external.abstr.LivingAndHealthIdx;
import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthRes;
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
public class OakPollenRiskIdx extends BaseTime implements LivingAndHealthIdx {

    @Id
    @Column(name = "oak_pollen_risk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dateTime;

    @ManyToOne
    @JoinColumn(name = "big_region_id")
    private BigRegion bigRegion;

    @Column
    private String oakPollenRiskIdxDay1;

    @Column
    private String oakPollenRiskIdxDay2;

    @Column
    private String oakPollenRiskIdxDay3;

    @Column
    private String oakPollenRiskIdxDay4;

    public OakPollenRiskIdx from(LivingAndHealthRes response) {
        return OakPollenRiskIdx.builder()
                .dateTime(response.getDateTime())
                .oakPollenRiskIdxDay1(response.getDay1())
                .oakPollenRiskIdxDay2(response.getDay2())
                .oakPollenRiskIdxDay3(response.getDay3())
                .oakPollenRiskIdxDay4(response.getDay4())
                .build();
    }

    public void joinRegion(BigRegion region) {
        this.bigRegion = region;
    }
}
