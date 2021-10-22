package com.renewal.weatherservicev2.domain.entity.external.living_and_health;

import com.renewal.weatherservicev2.domain.entity.common.BaseTime;
import com.renewal.weatherservicev2.domain.entity.common.BigRegion;
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
public class AsthmaIdx extends BaseTime implements LivingAndHealthIdx {

    @Id
    @Column(name = "asthma_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dateTime;

    @ManyToOne
    @JoinColumn(name = "big_region_id")
    private BigRegion bigRegion;

    @Column
    private String asthmaIdxDay1;

    @Column
    private String asthmaIdxDay2;

    @Column
    private String asthmaIdxDay3;

    @Column
    private String asthmaIdxDay4;

    public AsthmaIdx from(LivingAndHealthResponseVO response) {
        return AsthmaIdx.builder()
                .dateTime(response.getDateTime())
                .asthmaIdxDay1(response.getDay1())
                .asthmaIdxDay2(response.getDay2())
                .asthmaIdxDay3(response.getDay3())
                .asthmaIdxDay4(response.getDay4())
                .build();
    }

    public void joinRegion(BigRegion region) {
        this.bigRegion = region;
    }
}
