package com.renewal.weatherservicev2.service.parser.csv;

import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.renewal.weatherservicev2.domain.vo.csv.RegionRequestVO;
import com.renewal.weatherservicev2.util.RegionUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegionCsvParser {

    private final CommonCsvParser csvParser;

    public List<RegionRequestVO> parseFromCsv() throws IOException {
        CsvSchema schema = getSchema();
        return csvParser.parseObjectFrom(RegionUtil.csvResource.getInputStream(), schema, RegionRequestVO.class);
    }

    private CsvSchema getSchema() {
        return CsvSchema.builder()
                .addColumn("admCode", CsvSchema.ColumnType.STRING)
                .addColumn("bigRegion", CsvSchema.ColumnType.STRING)
                .addColumn("smallRegion", CsvSchema.ColumnType.STRING)
                .addColumn("longitude", CsvSchema.ColumnType.STRING)
                .addColumn("latitude", CsvSchema.ColumnType.STRING)
                .build().withHeader();
    }

}
