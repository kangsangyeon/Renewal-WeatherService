package com.renewal.weatherservicev2.domain.vo.openapi.response.weather;

import com.renewal.weatherservicev2.domain.entity.external.abstr.HourlyWeatherType;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HourlyWeatherRes {

    public HourlyRes rainPer;
    public HourlyRes tempHour;
    public HourlyRes weatherDescription;
    public HourlyRes weatherMain;
    public HourlyRes weatherIcon;

    public static HourlyWeatherRes create() {
        return HourlyWeatherRes.builder()
                .rainPer(HourlyRes.create(HourlyWeatherType.RAIN_PER))
                .tempHour(HourlyRes.create(HourlyWeatherType.TEMP_HOUR))
                .weatherDescription(HourlyRes.create(HourlyWeatherType.WEATHER_DESCRIPTION))
                .weatherMain(HourlyRes.create(HourlyWeatherType.WEATHER_MAIN))
                .weatherIcon(HourlyRes.create(HourlyWeatherType.WEATHER_ICON))
                .build();
    }

    public void setRainPerFrom(HourlyOpenApiRes openApiRes, int hour) {
        this.getRainPer().setDateByHour(openApiRes.getRainPer(), hour);
    }

    public void setTempHourFrom(HourlyOpenApiRes openApiRes, int hour) {
        this.getTempHour().setDateByHour(openApiRes.getTemp(), hour);
    }

    public void setWeatherDescriptionFrom(HourlyOpenApiRes openApiRes, int hour) {
        this.getWeatherDescription().setDateByHour(openApiRes.getWeatherDescription(), hour);
    }

    public void setWeatherMainFrom(HourlyOpenApiRes openApiRes, int hour) {
        this.getWeatherMain().setDateByHour(openApiRes.getWeatherMain(), hour);
    }

    public void setWeatherIconFrom(HourlyOpenApiRes openApiRes, int hour) {
        this.getWeatherIcon().setDateByHour(openApiRes.getWeatherIcon(), hour);
    }
}
