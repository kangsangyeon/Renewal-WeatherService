package com.renewal.weatherservicev2.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimeUtil {

    // String result
    public String getNowYYYYMMDD() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public String getYesterdayYYYYMMDD() {
        return LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    // LocalDate result
    public LocalDate ParserYYYYMMDD(String YYYYMMDD) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.parse(YYYYMMDD, formatter);
    }

    // etc. result
    public int getMonthYYYYMMDD(String YYYYMMDD) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate = LocalDate.parse(YYYYMMDD, formatter);
        return localDate.getMonthValue();
    }
}
