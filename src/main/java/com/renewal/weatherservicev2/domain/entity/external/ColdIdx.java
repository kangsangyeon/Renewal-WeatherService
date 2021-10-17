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
public class ColdIdx implements DomainDataFromExternal {

    @Id
    @Column(name = "cold_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dateTime;

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
}
