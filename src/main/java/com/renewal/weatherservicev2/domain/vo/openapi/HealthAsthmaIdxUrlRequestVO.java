package com.renewal.weatherservicev2.domain.vo.openapi;

import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.util.Const;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.net.URLEncoder;

@Slf4j
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HealthAsthmaIdxUrlRequestVO implements OpenApiRequestInterface {

    private String admCode;      // 행정동코드
    private String date;         // YYYYMMDD

    @Override
    public URL makeUrl() {
        try {
            String url = Const.OPEN_API_URL_FOR_HEALTH + Const.SUB_URL_FOR_ASTHMA_IDX +
                    "?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + Const.URL_ENCODED_KEY_FOR_DATA_GO_KR +              /*서비스키*/
                    "&" + URLEncoder.encode("areaNo", "UTF-8") + "=" + URLEncoder.encode(this.getAdmCode(), "UTF-8") +               /*서울지점*/
                    "&" + URLEncoder.encode("time", "UTF-8") + "=" + URLEncoder.encode(this.getDate() + "06", "UTF-8") +         /*2017년 6월 8일 6시*/
                    "&" + URLEncoder.encode("dataType", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8");           /*xml, json 선택(미입력시 xml)*/
            return new URL(url);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
