package com.renewal.weatherservicev2.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    // String result
    public static String getNowYYYYMMDD() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public static String getYesterdayYYYYMMDD() {
        return LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    // LocalDate result
    public static LocalDate ParserYYYYMMDD(String YYYYMMDD) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.parse(YYYYMMDD, formatter);
    }

    // etc. result
    public static int getMonthYYYYMMDD(String YYYYMMDD) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate = LocalDate.parse(YYYYMMDD, formatter);
        return localDate.getMonthValue();
    }
}
