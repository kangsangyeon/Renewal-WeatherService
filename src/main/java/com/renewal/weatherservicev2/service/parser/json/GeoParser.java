package com.renewal.weatherservicev2.service.parser.json;

import com.renewal.weatherservicev2.domain.vo.RegionVO;
import com.renewal.weatherservicev2.domain.vo.TMCoordinateVO;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import java.io.StringReader;

@Slf4j
@Component
@RequiredArgsConstructor
public class GeoParser {

    private final CommonJsonParser jsonParser;

    public RegionVO parseNaverReverseGeocoding(String data) {

        try {

            DOMParser parser = new DOMParser();
            parser.parse(new InputSource(new StringReader(data)));

            Document doc = parser.getDocument();

            // optional, but recommended
            // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            Element resultsElem = (Element) doc.getElementsByTagName("results").item(0);
            Element orderElem = (Element) resultsElem.getElementsByTagName("order").item(1);
            Element regionElem = (Element) orderElem.getElementsByTagName("region").item(0);
            Element area1Elem = (Element) regionElem.getElementsByTagName("area1").item(0);
            Element area2Elem = (Element) regionElem.getElementsByTagName("area2").item(0);

            String area1Value = area1Elem.getElementsByTagName("name").item(0).getTextContent();
            String area2Value = area2Elem.getElementsByTagName("name").item(0).getTextContent();

            return new RegionVO(area1Value, area2Value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException();
        }
    }

    public TMCoordinateVO parseKakaoConvertWGS84ToWTM(String data) {

        try {

            JSONObject jsonObject = (JSONObject) CommonJsonParser.jsonParser.parse(data);
            JSONArray documentsElem = jsonParser.parseArrayFrom(jsonObject, "documents");
            JSONObject documentsItemElem = jsonParser.parseObjectFrom(documentsElem, 0);

            double x = jsonParser.parseDoubleFrom(documentsItemElem, "x");
            double y = jsonParser.parseDoubleFrom(documentsItemElem, "y");

            return new TMCoordinateVO(x, y);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException();
        }

    }
}
