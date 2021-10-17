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
public class UVIdx implements DomainDataFromExternal {

    @Id
    @Column(name = "uv_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dateTime;

    @Column
    private String uvIdxDay1;

    @Column
    private String uvIdxDay2;

    @Column
    private String uvIdxDay3;

    @Column
    private String uvIdxDay4;

    public UVIdx from(LivingAndHealthResponseVO response) {
        return UVIdx.builder()
                .dateTime(response.getDateTime())
                .uvIdxDay1(response.getDay1())
                .uvIdxDay2(response.getDay2())
                .uvIdxDay3(response.getDay3())
                .uvIdxDay4(response.getDay4())
                .build();
    }
}
