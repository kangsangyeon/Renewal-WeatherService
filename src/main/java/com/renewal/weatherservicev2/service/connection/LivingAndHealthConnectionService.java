package com.renewal.weatherservicev2.service.connection;

import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthRes;
import com.renewal.weatherservicev2.service.parser.json.LivingAndHealthJsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URL;

@Slf4j
@Service
@RequiredArgsConstructor
public class LivingAndHealthConnectionService {

    private final ApiConnection apiConnection;
    private final LivingAndHealthJsonParser livingAndHealthJsonParser;

    public LivingAndHealthRes connectAndGetParsedResponse(OpenApiRequestInterface request) {
        URL url = request.makeUrl();
        String  data = apiConnection.connect(url);
        return livingAndHealthJsonParser.parseFrom(data);
    }
}
