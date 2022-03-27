package com.renewal.weatherservicev2.service.connection;

import com.renewal.weatherservicev2.domain.vo.RegionVO;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.service.parser.json.GeoParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@Slf4j
@Service
@RequiredArgsConstructor
public class GeoApiConnectionService {

    private final GeoParser geoParser;

    public RegionVO connectAndGetParsedResponse(OpenApiRequestInterface request) {
        URL url = request.makeUrl();

        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");

            connection.addRequestProperty("X-NCP-APIGW-API-KEY-ID", "et23d38qwi");
            connection.addRequestProperty("X-NCP-APIGW-API-KEY", "6RmECdY1MD4qhrXo7UNCFIzkfBr2XmheawWfrB8Y");

            BufferedReader readerData = makeResponseFromApiConnection(connection);

            StringBuilder data = new StringBuilder();
            String readerDataLine;
            while ((readerDataLine = readerData.readLine()) != null) {
                data.append(readerDataLine);
            }
            readerData.close();
            connection.disconnect();

            RegionVO regionVO = geoParser.parseNaverReverseGeocoding(data.toString());
            return regionVO;

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            log.error("## [connect] end. error occurred! url = {}", url);
            throw new RuntimeException(e.getMessage());
        }

    }

    // 상태코드에 따른 응답값 가져오기
    private BufferedReader makeResponseFromApiConnection(HttpURLConnection connection) throws IOException {
        if (connection.getResponseCode() >= 200 && connection.getResponseCode() <= 300) {
            return new BufferedReader(new InputStreamReader(connection.getInputStream()));
        }
        return new BufferedReader(new InputStreamReader(connection.getErrorStream()));
    }

}
