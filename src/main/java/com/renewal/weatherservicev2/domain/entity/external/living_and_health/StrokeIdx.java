package com.renewal.weatherservicev2.domain.entity.external.living_and_health;

import com.renewal.weatherservicev2.domain.entity.external.abstr.DomainDataFromExternal;
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
public class StrokeIdx implements DomainDataFromExternal {

    @Id
    @Column(name = "stroke_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dateTime;

    @Column
    private String strokeIdxDay1;

    @Column
    private String strokeIdxDay2;

    @Column
    private String strokeIdxDay3;

    @Column
    private String strokeIdxDay4;

    public StrokeIdx from(LivingAndHealthResponseVO response) {
        return StrokeIdx.builder()
                .dateTime(response.getDateTime())
                .strokeIdxDay1(response.getDay1())
                .strokeIdxDay2(response.getDay2())
                .strokeIdxDay3(response.getDay3())
                .strokeIdxDay4(response.getDay4())
                .build();
    }
}
