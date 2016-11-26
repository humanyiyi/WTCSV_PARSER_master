package com.udbac.csvparser.utils;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;


/**
 * Created by 43890 on 2016/10/11.
 */
@Component
public class CsvParseUtil {
    private final static Logger logger = LoggerFactory.getLogger(CsvParseUtil.class);
    @Autowired
    ParserProperties parserProperties;
    @Autowired
    TimeUtil timeUtil;

    public List<String[]> parseCSV2Rows(String filename) throws Exception{
        return parseCSV2Rows(filename, "GB2312");
    }

    public List<String[]> parseCSV2Rows(String filename, String encoding) throws Exception{
        List<String[]> allRows = null;
        CsvParserSettings visitsSetting = new CsvParserSettings();
        visitsSetting.getFormat().setLineSeparator("\n");
        CsvParser parser = new CsvParser(visitsSetting);
        String filePath = parserProperties.getCsvPath() + "/" + filename;
        File csvfile = new File(filePath);
        if (!csvfile.exists()) {
            logger.error("***CAN NOT FIND FILE：" + filename + "  PLEASE CHECK THE CSV FILE IS EXIST***");
            return null;
        } else {
            allRows = parser.parseAll(csvfile, encoding);
            if (allRows.size() < 200) {
                logger.error("***CSV FILE ROWS SIZE < 500, FILENAME：" + filename + "  PLEASE CHECK FILE ROWS SIZE***");
                return null;
//                } else if (!getTime(allRows).equals(timeUtil.getYesterday())) {
//                    logger.error("***CSV FILE DATE IS NOT YESTERDAY" + filename + "PLEASE CHECK FILE DATE***");
//                    return null;
            }
        }
        return allRows;
    }

    public String getTime(List<String[]> ampRows) {
        String date = null;
        for (int i = 0; i <= 50; i++) {
            String[] row1 = ampRows.get(i);
            if (row1.length == 2) {
                date = row1[0].substring(0, 10);
            }
        }
        return date;
    }
}
