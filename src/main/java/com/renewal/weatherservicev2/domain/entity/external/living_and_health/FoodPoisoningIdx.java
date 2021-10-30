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
public class FoodPoisoningIdx extends BaseTime implements LivingAndHealthIdx {

    @Id
    @Column(name = "food_poisoning_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dateTime;

    @ManyToOne
    @JoinColumn(name = "big_region_id")
    private BigRegion bigRegion;

    @Column
    private String foodPoisoningIdxDay1;

    @Column
    private String foodPoisoningIdxDay2;

    @Column
    private String foodPoisoningIdxDay3;

    @Column
    private String foodPoisoningIdxDay4;

    public FoodPoisoningIdx from(LivingAndHealthRes response) {
        return FoodPoisoningIdx.builder()
                .dateTime(response.getDateTime())
                .foodPoisoningIdxDay1(response.getDay1())
                .foodPoisoningIdxDay2(response.getDay2())
                .foodPoisoningIdxDay3(response.getDay3())
                .foodPoisoningIdxDay4(response.getDay4())
                .build();
    }

    public void joinRegion(BigRegion region) {
        this.bigRegion = region;
    }
}
