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
public class SmallRegion extends BaseTime {

    @Id
    @Column(name = "small_region_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "big_region_id")
    private BigRegion bigRegion;

    @Column
    String name;

    @Column
    String admCode;

    @Column
    String longitude;

    @Column
    String latitude;

}
