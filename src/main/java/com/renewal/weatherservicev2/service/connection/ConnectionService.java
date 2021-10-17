package com.renewal.weatherservicev2.service.connection;

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
public class ConnectionService {

    // 연결
    public String connect(URL url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");

            BufferedReader readerData = makeResponseFromApiConnection(connection);

            StringBuilder data = new StringBuilder();
            String readerDataLine;
            while ((readerDataLine = readerData.readLine()) != null) {
                data.append(readerDataLine);
            }
            readerData.close();
            connection.disconnect();
            return data.toString();

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

