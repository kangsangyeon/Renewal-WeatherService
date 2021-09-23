package com.renewal.weatherservicev2.service.raw_data;

import com.renewal.weatherservicev2.domain.entity.external.AsthmaIdx;
import com.renewal.weatherservicev2.domain.vo.HealthResponseVO;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.repository.AsthmaIdxRepository;
import com.renewal.weatherservicev2.service.connection.ConnectionService;
import com.renewal.weatherservicev2.service.parser.HealthJsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.net.URL;

@Slf4j
@Service
@RequiredArgsConstructor
public class AsthmaIdxService {

    private final AsthmaIdxRepository asthmaIdxRepository;
    private final ConnectionService connectionService;
    private final HealthJsonParser healthJsonParser;

    @Transactional
    public void connectAndSave(OpenApiRequestInterface request) {
        URL url = request.makeUrl();
        String data = connectionService.connect(url);

        HealthResponseVO response = healthJsonParser.parseFrom(data);
        AsthmaIdx asthmaIdx = response.makeAsthmaIdx();
        asthmaIdxRepository.save(asthmaIdx);
    }
}
