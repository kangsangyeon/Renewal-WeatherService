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
public class PinePollenRiskIdx extends BaseTime implements LivingAndHealthIdx {

    @Id
    @Column(name = "pine_pollen_risk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dateTime;

    @ManyToOne
    @JoinColumn(name = "big_region_id")
    private BigRegion bigRegion;

    @Column
    private String pinePollenRiskIdxDay1;

    @Column
    private String pinePollenRiskIdxDay2;

    @Column
    private String pinePollenRiskIdxDay3;

    @Column
    private String pinePollenRiskIdxDay4;

    public PinePollenRiskIdx from(LivingAndHealthRes response) {
        return PinePollenRiskIdx.builder()
                .dateTime(response.getDateTime())
                .pinePollenRiskIdxDay1(response.getDay1())
                .pinePollenRiskIdxDay2(response.getDay2())
                .pinePollenRiskIdxDay3(response.getDay3())
                .pinePollenRiskIdxDay4(response.getDay4())
                .build();
    }

    public void joinRegion(BigRegion region) {
        this.bigRegion = region;
    }
}
