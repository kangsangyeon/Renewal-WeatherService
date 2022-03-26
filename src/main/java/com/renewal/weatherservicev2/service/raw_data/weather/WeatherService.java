package com.renewal.weatherservicev2.service.raw_data.weather;

import com.renewal.weatherservicev2.domain.entity.common.SmallRegion;
import com.renewal.weatherservicev2.domain.entity.external.weather.daily.*;
import com.renewal.weatherservicev2.domain.entity.external.weather.hourly.*;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.weather.WeatherReq;
import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.WeatherRes;
import com.renewal.weatherservicev2.repository.weather.daily.*;
import com.renewal.weatherservicev2.repository.weather.hourly.*;
import com.renewal.weatherservicev2.service.common.AsyncService;
import com.renewal.weatherservicev2.service.connection.WeatherConnectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherService {

    private final DailyHumidityRepository dailyHumidityRepository;
    private final DailyRainPerRepository dailyRainPerRepository;
    private final DailyTempDayRepository dailyTempDayRepository;
    private final DailyTempMaxRepository dailyTempMaxRepository;
    private final DailyTempMinRepository dailyTempMinRepository;
    private final DailyWeatherDescriptionRepository dailyWeatherDescriptionRepository;
    private final DailyWeatherIconRepository dailyWeatherIconRepository;
    private final DailyWeatherMainRepository dailyWeatherMainRepository;
    private final DailyWindRepository dailyWindRepository;

    private final HourlyWeatherMainRepository hourlyWeatherMainRepository;
    private final HourlyWeatherDescriptionRepository hourlyWeatherDescriptionRepository;
    private final HourlyWeatherIconRepository hourlyWeatherIconRepository;
    private final HourlyTempRepository hourlyTempRepository;
    private final HourlyRainPerRepository hourlyRainPerRepository;

    private final AsyncService asyncService;
    private final WeatherConnectionService weatherConnectionService;

    public WeatherRes callDataFromOpenApiAndSaveByRegionAfterReturnResult(SmallRegion smallRegion) {
        WeatherRes response = callData(smallRegion.getLatitude(), smallRegion.getLongitude());
        asyncService.run(() -> saveData(response));
        return response;
    }

    private WeatherRes callData(String latitude, String longitude) {
        OpenApiRequestInterface request = WeatherReq.builder()
                                                    .latitude(latitude)
                                                    .longitude(longitude)
                                                    .build();

        return weatherConnectionService.connectAndGetParsedResponse(request);
    }

    @Async
    public void saveData(WeatherRes weatherRes) {
        dailyHumidityRepository.save(DailyHumidity.createFrom(weatherRes));
        dailyRainPerRepository.save(DailyRainPer.createFrom(weatherRes));
        dailyTempDayRepository.save(DailyTempDay.createFrom(weatherRes));
        dailyTempMaxRepository.save(DailyTempMax.createFrom(weatherRes));
        dailyTempMinRepository.save(DailyTempMin.createFrom(weatherRes));
        dailyWeatherDescriptionRepository.save(DailyWeatherDescription.createFrom(weatherRes));
        dailyWeatherMainRepository.save(DailyWeatherMain.createFrom(weatherRes));
        dailyWeatherIconRepository.save(DailyWeatherIcon.createFrom(weatherRes));
        dailyWindRepository.save(DailyWind.createFrom(weatherRes));

        hourlyWeatherMainRepository.save(HourlyWeatherMain.createFrom(weatherRes));
        hourlyWeatherDescriptionRepository.save(HourlyWeatherDescription.createFrom(weatherRes));
        hourlyWeatherIconRepository.save(HourlyWeatherIcon.createFrom(weatherRes));
        hourlyTempRepository.save(HourlyTemp.createFrom(weatherRes));
        hourlyRainPerRepository.save(HourlyRainPer.createFrom(weatherRes));
    }

}
