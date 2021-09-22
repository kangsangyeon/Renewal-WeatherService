package com.renewal.weatherservicev2.service;

import com.renewal.weatherservicev2.util.Const;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import static org.junit.jupiter.api.Assertions.*;

class HealthUrlServiceTest {

    @Test
    void makeUrlTest() throws Exception {

        String areaNo = "1100000000";
        String time = "20210706";

        String url = Const.OPEN_API_URL_FOR_HEALTH + Const.SUB_URL_FOR_ASTHMA_IDX +
                "?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + "인증키" +                                       /*서비스키*/
                "&" + URLEncoder.encode("areaNo", "UTF-8") + "=" + URLEncoder.encode(areaNo, "UTF-8") +           /*서울지점*/
                "&" + URLEncoder.encode("time", "UTF-8") + "=" + URLEncoder.encode(time + "06", "UTF-8") +     /*2017년 6월 8일 6시*/
                "&" + URLEncoder.encode("dataType", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8");       /*xml, json 선택(미입력시 xml)*/

        String result = "http://apis.data.go.kr/1360000/HealthWthrIdxServiceV2/getAsthmaIdxV2?serviceKey=인증키&areaNo=1100000000&time=2021070606&dataType=json";
        assertEquals(result, url);
    }
}