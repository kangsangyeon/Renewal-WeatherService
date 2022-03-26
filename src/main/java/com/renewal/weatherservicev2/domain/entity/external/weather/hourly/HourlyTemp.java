package com.renewal.weatherservicev2.domain.entity.external.weather.hourly;

import com.renewal.weatherservicev2.domain.entity.external.abstr.HourlyWeather;
import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.HourlyRes;
import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.WeatherRes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class HourlyTemp extends HourlyWeather {

    @Id
    @Column(name = "houly_temp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public static HourlyTemp createFrom(WeatherRes weatherRes) {
        HourlyRes response = weatherRes.getHourly().getTempHour();
        return HourlyTemp.builder()
                         .hour1(response.getHour1())
                         .hour2(response.getHour2())
                         .hour3(response.getHour3())
                         .hour4(response.getHour4())
                         .hour5(response.getHour5())
                         .hour6(response.getHour6())
                         .hour7(response.getHour7())
                         .hour8(response.getHour8())
                         .hour9(response.getHour9())
                         .hour10(response.getHour10())
                         .hour11(response.getHour11())
                         .hour12(response.getHour12())
                         .hour13(response.getHour13())
                         .hour14(response.getHour14())
                         .hour15(response.getHour15())
                         .hour16(response.getHour16())
                         .hour17(response.getHour17())
                         .hour18(response.getHour18())
                         .hour19(response.getHour19())
                         .hour20(response.getHour20())
                         .hour21(response.getHour21())
                         .hour22(response.getHour22())
                         .hour23(response.getHour23())
                         .hour24(response.getHour24())
                         .build();
    }
}
