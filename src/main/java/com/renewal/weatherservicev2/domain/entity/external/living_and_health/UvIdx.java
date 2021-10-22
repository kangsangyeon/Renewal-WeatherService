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
public class UvIdx extends BaseTime implements LivingAndHealthIdx {

    @Id
    @Column(name = "uv_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dateTime;

    @ManyToOne
    @JoinColumn(name = "big_region_id")
    private BigRegion bigRegion;

    @Column
    private String uvIdxDay1;

    @Column
    private String uvIdxDay2;

    @Column
    private String uvIdxDay3;

    @Column
    private String uvIdxDay4;

    public UvIdx from(LivingAndHealthResponseVO response) {
        return UvIdx.builder()
                .dateTime(response.getDateTime())
                .uvIdxDay1(response.getDay1())
                .uvIdxDay2(response.getDay2())
                .uvIdxDay3(response.getDay3())
                .uvIdxDay4(response.getDay4())
                .build();
    }

    public void joinRegion(BigRegion region) {
        this.bigRegion = region;
    }
}
