package com.renewal.weatherservicev2.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeTest {

    @Test
    void getNowYYYYMMDD() {
    }

    @Test
    void getYesterdayYYYYMMDD() {
    }

    @Test
    void parserYYYYMMDD() {
    }

    @Test
    void getMonthYYYYMMDD() {

        String YYYYMMDD = "20211022";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate = LocalDate.parse(YYYYMMDD, formatter);
        int result = localDate.getMonthValue();

        assertEquals(10, result);
    }
}