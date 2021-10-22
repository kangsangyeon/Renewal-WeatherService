package com.renewal.weatherservicev2.service.parser.csv;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class CommonCsvParser {

    public <T> List<T> parseObjectFrom(File file, CsvSchema schema, Class<T> responseClass) throws IOException {
        List<T> results = new ArrayList<>();

        CsvMapper csvMapper = new CsvMapper();
        MappingIterator<T> mappingIterator = csvMapper.readerFor(responseClass).with(schema).readValues(file);

        results = mappingIterator.readAll();
        return results;
    }

    public <T> List<T> parseObjectFrom(InputStream inputStream, CsvSchema schema, Class<T> responseClass) throws IOException {
        List<T> results = new ArrayList<>(150);

        CsvMapper csvMapper = new CsvMapper();
        MappingIterator<T> mappingIterator = csvMapper.readerFor(responseClass).with(schema).readValues(inputStream);

        results = mappingIterator.readAll();
        return results;
    }
}
