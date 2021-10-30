package com.renewal.weatherservicev2.domain.vo.openapi.abstr;

import com.renewal.weatherservicev2.util.OpenApiURL;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public abstract class LivingAndHealthIdxReq {

    public String makeCommonSubUrl(String admCode, String date) throws UnsupportedEncodingException {
        return "?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + OpenApiURL.URL_ENCODED_KEY_FOR_DATA_GO_KR +                            /*서비스키*/
                "&" + URLEncoder.encode("areaNo", "UTF-8") + "=" + URLEncoder.encode(admCode, "UTF-8") +                 /*서울지점*/
                "&" + URLEncoder.encode("time", "UTF-8") + "=" + URLEncoder.encode(date + "06", "UTF-8") +            /*2017년 6월 8일 6시*/
                "&" + URLEncoder.encode("dataType", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8");                        /*xml, json 선택(미입력시 xml)*/
    }
}
