package com.renewal.weatherservicev2.domain.entity.external;

import com.renewal.weatherservicev2.domain.vo.openapi.response.HealthResponseVO;
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
public class AsthmaIdx {

    @Id
    @Column(name = "asthma_idx_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dateTime;

    @Column
    private String asthmaIdxDay1;

    @Column
    private String asthmaIdxDay2;

    @Column
    private String asthmaIdxDay3;

    @Column
    private String asthmaIdxDay4;

    public AsthmaIdx from(HealthResponseVO apiResponse) {
        return AsthmaIdx.builder()
                .dateTime(apiResponse.getDateTime())
                .asthmaIdxDay1(apiResponse.getDay1())
                .asthmaIdxDay2(apiResponse.getDay2())
                .asthmaIdxDay3(apiResponse.getDay3())
                .asthmaIdxDay4(apiResponse.getDay4())
                .build();
    }

}
