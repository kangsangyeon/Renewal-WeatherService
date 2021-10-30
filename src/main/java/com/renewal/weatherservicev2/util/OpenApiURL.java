package com.renewal.weatherservicev2.util;

public interface OpenApiURL {

    // 서비스 키 모음
    String URL_ENCODED_KEY_FOR_DATA_GO_KR = "zhvzvF5vNC7ufu7H%2BQnPJtEQbF2QdNZ0qdvZWLeR%2BnL0UwxwnCgrkmxKB9oqCXVSJp95YTliRHwzxvGdrvjetg%3D%3D";
    String URL_DECODED_KEY_FOR_DATA_GO_KR = "zhvzvF5vNC7ufu7H+QnPJtEQbF2QdNZ0qdvZWLeR+nL0UwxwnCgrkmxKB9oqCXVSJp95YTliRHwzxvGdrvjetg==";
    String URL_KEY_FOR_OPEN_WEATHER_MAP_ORG = "9a7b20a6b2f22e3ad28e7a16a19ae5de";

    // 보건기상지수 조회서비스 - 공공데이터포털
    String OPEN_API_URL_FOR_HEALTH = "http://apis.data.go.kr/1360000/HealthWthrIdxServiceV2";

    String SUB_URL_FOR_ASTHMA_IDX = "/getAsthmaIdxV2";
    String SUB_URL_FOR_STROKE_IDX = "/getStrokeIdxV2";
    String SUB_URL_FOR_FOOD_POISONING_IDX = "/getFoodPoisoningIdxV2";
    String SUB_URL_FOR_OAK_POLLEN_RISK_IDX = "/getOakPollenRiskIdxV2";
    String SUB_URL_FOR_PINE_POLLEN_RISK_IDX = "/getPinePollenRiskIdxV2";
    String SUB_URL_FOR_WEEDS_POLLEN_RISK_IDX = "/getWeedsPollenRiskndxV2";
    String SUB_URL_FOR_COLD_IDX = "/getColdIdxV2";

    // 생활기상지수 조회서비스 - 공공데이터포털
    String OPEN_API_URL_FOR_LIVING = "http://apis.data.go.kr/1360000/LivingWthrIdxServiceV2";

    String SUB_URL_FOR_FREEZE_IDX = "/getFreezeIdxV2";
    String SUB_URL_FOR_UV_IDX = "/getUVIdxV2";
    String SUB_URL_FOR_AIR_DIFFUSION_IDX = "/getAirDiffusionIdxV2";
    String SUB_URL_FOR_SEN_TA_IDX = "/getSenTaIdxV2";

    // 시간별, 일별 기상데이터 - 오픈웨더
    String OPEN_API_URL_FOR_WEATHER = "https://api.openweathermap.org/data/2.5/onecall";
}
