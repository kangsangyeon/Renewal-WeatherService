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
public class ColdIdx extends BaseTime implements LivingAndHealthIdx {

    @Id
    @Column(name = "cold_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dateTime;

    @ManyToOne
    @JoinColumn(name = "big_region_id")
    private BigRegion bigRegion;

    @Column
    private String coldIdxDay1;

    @Column
    private String coldIdxDay2;

    @Column
    private String coldIdxDay3;

    @Column
    private String coldIdxDay4;

    public ColdIdx from(LivingAndHealthResponseVO response) {
        return ColdIdx.builder()
                .dateTime(response.getDateTime())
                .coldIdxDay1(response.getDay1())
                .coldIdxDay2(response.getDay2())
                .coldIdxDay3(response.getDay3())
                .coldIdxDay4(response.getDay4())
                .build();
    }

    public void joinRegion(BigRegion region) {
        this.bigRegion = region;
    }
}
