package com.renewal.weatherservicev2.service;

import com.renewal.weatherservicev2.util.Const;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.SystemException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Slf4j
@Service
@RequiredArgsConstructor
public class HealthUrlService {

    public URL makeUrl(String areaNo, String time) throws Exception {
        String url = Const.OPEN_API_URL_FOR_HEALTH + Const.SUB_URL_FOR_ASTHMA_IDX +
                "?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + Const.URL_ENCODED_KEY_FOR_DATA_GO_KR +              /*서비스키*/
                "&" + URLEncoder.encode("areaNo", "UTF-8") + "=" + URLEncoder.encode(areaNo, "UTF-8") +               /*서울지점*/
                "&" + URLEncoder.encode("time", "UTF-8") + "=" + URLEncoder.encode(time + "06", "UTF-8") +         /*2017년 6월 8일 6시*/
                "&" + URLEncoder.encode("dataType", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8");           /*xml, json 선택(미입력시 xml)*/
        return new URL(url);
    }

}
