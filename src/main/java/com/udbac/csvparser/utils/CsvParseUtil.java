package com.udbac.csvparser.utils;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * Created by 43890 on 2016/10/11.
 */
@Component
public class CsvParseUtil {

    @Autowired
    ParserProperties parserProperties;

    public  List<String[]> parseCSV2Rows(String filename) {
        return parseCSV2Rows(filename,"GB2312");
    }

    public  List<String[]> parseCSV2Rows(String filename,String encoding) {
        CsvParserSettings visitsSetting = new CsvParserSettings();
        visitsSetting.getFormat().setLineSeparator("\n");
        CsvParser parser = new CsvParser(visitsSetting);

        String filePath = parserProperties.getCsvPath() +"\\"+ filename;
        List<String[]> allRows = parser.parseAll(new File(filePath), encoding);
        return allRows;
    }
}
