package com.renewal.weatherservicev2.domain.entity.external.living_and_health;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.renewal.weatherservicev2.domain.entity.common.BigRegion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LivingAndHealthInfo {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "big_region_id")
    private BigRegion bigRegion;

    @JsonIgnore
    @Column
    private LocalDate date;

    /*
    천식질환 지수 입니다.
     */

    @Column
    private Integer asthmaToday;

    @Column
    private Integer asthmaTomorrow;

    @Column
    private Integer asthmaTheDayAfterTomorrow;

    /*
    식중독 지수입니다.
     */

    @Column
    private Integer foodPoisonToday;

    @Column
    private Integer foodPoisonTomorrow;

    @Column
    private Integer foodPoisonTheDayAfterTomorrow;

    /*
    뇌졸중 가능지수입니다.
     */

    @Column
    private Integer strokeToday;

    @Column
    private Integer strokeTomorrow;

    @Column
    private Integer strokeTheDayAfterTomorrow;

    /*
    자외선 지수입니다.
     */

    @Column
    private Integer uvToday;

    @Column
    private Integer uvTomorrow;

    @Column
    private Integer uvTheDayAfterTomorrow;

    /*
    감기지수 입니다.
    9-4월 사이에만 자료가 제공됩니다.
     */

    @Column
    private Integer coldToday;

    @Column
    private Integer coldTomorrow;

    @Column
    private Integer coldTheDayAfterTomorrow;

    /*
    꽃가루농도위험지수(참나무) 입니다.
    4-6월 사이에만 자료가 제공됩니다.
     */

    @Column
    private Integer oakPollenRiskToday;

    @Column
    private Integer oakPollenRiskTomorrow;

    @Column
    private Integer oakPollenRiskTheDayAfterTomorrow;

    /*
    꽃가루농도위험지수(소나무) 입니다.
    4-6월 사이에만 자료가 제공됩니다.
     */

    @Column
    private Integer pinePollenRiskToday;

    @Column
    private Integer pinePollenRiskTomorrow;

    @Column
    private Integer pinePollenRiskTheDayAfterTomorrow;

    /*
    꽃가루농도위험지수(잡초류) 입니다.
    8-10월 사이에만 자료가 제공됩니다.
     */

    @Column
    private Integer weedsPollenRiskToday;

    @Column
    private Integer weedsPollenRiskTomorrow;

    @Column
    private Integer weedsPollenRiskTheDayAfterTomorrow;
    
}
