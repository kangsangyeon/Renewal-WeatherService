package com.renewal.weatherservicev2.service.raw_data;

import com.renewal.weatherservicev2.domain.entity.external.AsthmaIdx;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.health.AsthmaIdxRequestVO;
import com.renewal.weatherservicev2.domain.vo.openapi.response.health.abstr.LivingAndHealthResponseVO;
import com.renewal.weatherservicev2.service.connection.ConnectionService;
import com.renewal.weatherservicev2.service.parser.LivingAndHealthJsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URL;

@Slf4j
@Service
@RequiredArgsConstructor
public class LivingAndHealthIdxService {

    private final ConnectionService connectionService;
    private final LivingAndHealthJsonParser livingAndHealthJsonParser;

    public AsthmaIdx getData(String admCode, String date) {
        OpenApiRequestInterface request = AsthmaIdxRequestVO.builder()
                .admCode(admCode)
                .date(date)
                .build();

        LivingAndHealthResponseVO response = connectAndGetParsedResponse(request);
        AsthmaIdx data = new AsthmaIdx();
        return data.from(response);
    }

    public LivingAndHealthResponseVO connectAndGetParsedResponse(OpenApiRequestInterface request) {
        URL url = request.makeUrl();
        String  data = connectionService.connect(url);
        return livingAndHealthJsonParser.parseFrom(data);
    }
}
