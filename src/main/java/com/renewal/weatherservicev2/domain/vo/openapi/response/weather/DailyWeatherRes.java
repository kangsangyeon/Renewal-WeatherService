package com.renewal.weatherservicev2.domain.vo.openapi.response.weather;

import com.renewal.weatherservicev2.domain.entity.external.abstr.DailyWeatherType;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiResponseInterface;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DailyWeatherRes implements OpenApiResponseInterface {

    public DailyRes humidity;
    public DailyRes rainPer;
    public DailyRes tempDay;
    public DailyRes tempMax;
    public DailyRes tempMin;
    public DailyRes weatherDescription;
    public DailyRes weatherMain;
    public DailyRes weatherIcon;
    public DailyRes wind;

    public static DailyWeatherRes create() {
        return DailyWeatherRes.builder()
                .humidity(DailyRes.create(DailyWeatherType.HUMIDITY))
                .rainPer(DailyRes.create(DailyWeatherType.RAIN_PER))
                .tempDay(DailyRes.create(DailyWeatherType.TEMP_DAY))
                .tempMax(DailyRes.create(DailyWeatherType.TEMP_MAX))
                .tempMin(DailyRes.create(DailyWeatherType.TEMP_MIN))
                .weatherDescription(DailyRes.create(DailyWeatherType.WEATHER_DESCRIPTION))
                .weatherMain(DailyRes.create(DailyWeatherType.WEATHER_MAIN))
                .weatherIcon(DailyRes.create(DailyWeatherType.WEATHER_ICON))
                .wind(DailyRes.create(DailyWeatherType.WIND))
                .build();
    }

    public void setHumidityFrom(DailyOpenApiRes openApiRes, int day) {
        this.getHumidity().setDataByDay(openApiRes.getHumidity(), day);
    }

    public void setRainPerFrom(DailyOpenApiRes openApiRes, int day) {
        this.getRainPer().setDataByDay(openApiRes.getRainPer(), day);
    }

    public void setTempDayFrom(DailyOpenApiRes openApiRes, int day) {
        this.getTempDay().setDataByDay(openApiRes.getTempDay(), day);
    }

    public void setTempMaxFrom(DailyOpenApiRes openApiRes, int day) {
        this.getTempMax().setDataByDay(openApiRes.getTempMax(), day);
    }

    public void setTempMinFrom(DailyOpenApiRes openApiRes, int day) {
        this.getTempMin().setDataByDay(openApiRes.getTempMin(), day);
    }

    public void setWeatherDescriptionFrom(DailyOpenApiRes openApiRes, int day) {
        this.getWeatherDescription().setDataByDay(openApiRes.getWeatherDescription(), day);
    }

    public void setWeatherMainFrom(DailyOpenApiRes openApiRes, int day) {
        this.getWeatherMain().setDataByDay(openApiRes.getWeatherMain(), day);
    }

    public void setWeatherIconFrom(DailyOpenApiRes openApiRes, int day) {
        this.getWeatherIcon().setDataByDay(openApiRes.getWeatherIcon(), day);
    }

    public void setWindFrom(DailyOpenApiRes openApiRes, int day) {
        this.getWind().setDataByDay(openApiRes.getWindSpeed(), day);
    }
}
