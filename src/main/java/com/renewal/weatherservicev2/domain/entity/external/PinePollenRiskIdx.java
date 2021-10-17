package com.renewal.weatherservicev2.domain.entity.external;

import com.renewal.weatherservicev2.domain.entity.external.abstr.DomainDataFromExternal;
import com.renewal.weatherservicev2.domain.vo.openapi.response.health.abstr.LivingAndHealthResponseVO;
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
public class PinePollenRiskIdx implements DomainDataFromExternal {

    @Id
    @Column(name = "pine_pollen_risk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dateTime;

    @Column
    private String pinePollenRiskIdxDay1;

    @Column
    private String pinePollenRiskIdxDay2;

    @Column
    private String pinePollenRiskIdxDay3;

    @Column
    private String pinePollenRiskIdxDay4;

    public PinePollenRiskIdx from(LivingAndHealthResponseVO response) {
        return PinePollenRiskIdx.builder()
                .dateTime(response.getDateTime())
                .pinePollenRiskIdxDay1(response.getDay1())
                .pinePollenRiskIdxDay2(response.getDay2())
                .pinePollenRiskIdxDay3(response.getDay3())
                .pinePollenRiskIdxDay4(response.getDay4())
                .build();
    }
}
