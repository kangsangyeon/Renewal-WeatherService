package com.renewal.weatherservicev2.domain.vo.csv;

import com.renewal.weatherservicev2.domain.entity.common.BigRegion;
import com.renewal.weatherservicev2.domain.entity.common.SmallRegion;
import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegionReq {

    private String admCode;
    private String bigRegion;
    private String smallRegion;
    private String longitude;
    private String latitude;

    public boolean isBigRegion() {
        return smallRegion.trim().length() == 0;
    }

    public BigRegion createBigRegion() {
        return BigRegion.builder()
                .name(this.getBigRegion())
                .admCode(this.getAdmCode())
                .longitude(this.getLongitude())
                .latitude(this.getLatitude())
                .build();
    }

    public SmallRegion createSmallRegionWith(BigRegion bigRegion) {
        return SmallRegion.builder()
                .bigRegion(bigRegion)
                .name(this.getSmallRegion())
                .admCode(this.getAdmCode())
                .longitude(this.getLongitude())
                .latitude(this.getLatitude())
                .build();
    }
}
