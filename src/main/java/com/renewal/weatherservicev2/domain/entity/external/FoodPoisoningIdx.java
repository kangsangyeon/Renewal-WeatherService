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
public class FoodPoisoningIdx implements DomainDataFromExternal {

    @Id
    @Column(name = "food_poisoning_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dateTime;

    @Column
    private String foodPoisoningIdxDay1;

    @Column
    private String foodPoisoningIdxDay2;

    @Column
    private String foodPoisoningIdxDay3;

    @Column
    private String foodPoisoningIdxDay4;

    public FoodPoisoningIdx from(LivingAndHealthResponseVO response) {
        return FoodPoisoningIdx.builder()
                .dateTime(response.getDateTime())
                .foodPoisoningIdxDay1(response.getDay1())
                .foodPoisoningIdxDay2(response.getDay2())
                .foodPoisoningIdxDay3(response.getDay3())
                .foodPoisoningIdxDay4(response.getDay4())
                .build();
    }
}
