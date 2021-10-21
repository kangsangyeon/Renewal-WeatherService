package com.renewal.weatherservicev2.exception;

public class NonServicePeriodException extends RuntimeException {
    public static final String LOG_PREFIX = "API 서비스 기간이 아닙니다.";

    public NonServicePeriodException() {
        super(LOG_PREFIX);
    }
    public NonServicePeriodException(String message) {
        super(LOG_PREFIX + " " + message);
    }
}
