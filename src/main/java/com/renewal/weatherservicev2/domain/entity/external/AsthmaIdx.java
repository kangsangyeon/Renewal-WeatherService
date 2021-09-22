package com.renewal.weatherservicev2.domain.entity.external;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class AsthmaIdx {

    @Id
    @Column(name = "asthma_idx_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int asthmaIdxDay1;

    @Column
    private int asthmaIdxDay2;

    @Column
    private int asthmaIdxDay3;

    @Column
    private int asthmaIdxDay4;

}
