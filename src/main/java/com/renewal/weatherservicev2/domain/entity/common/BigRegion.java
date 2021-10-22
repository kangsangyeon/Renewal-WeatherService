package com.renewal.weatherservicev2.domain.entity.common;

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
public class BigRegion extends BaseTime {

    @Id
    @Column(name = "big_region_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    String name;

    @Column
    String admCode;

    @Column
    String longitude;

    @Column
    String latitude;

}
