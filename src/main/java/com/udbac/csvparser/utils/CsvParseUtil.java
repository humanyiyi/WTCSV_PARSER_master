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

    public  List<String[]> parseCSV2Rows(String filename) {
        return parseCSV2Rows(filename,"GB2312");
    }

    public  List<String[]> parseCSV2Rows(String filename,String encoding) {
        List<String[]> allRows = null;
        CsvParserSettings visitsSetting = new CsvParserSettings();
        visitsSetting.getFormat().setLineSeparator("\n");
        CsvParser parser = new CsvParser(visitsSetting);
        String filePath = parserProperties.getCsvPath() + "\\" + filename;
        File csvfile = new File(filePath);
        if (!csvfile.exists()) {
            logger.error("找不到文件，文件名："+filename);
            return null;
        } else {
            allRows = parser.parseAll(csvfile, encoding);
            if (allRows.size() < 1000) {
                logger.error("文件行数太少，文件名："+filename);
                return null;
//            } else if (!getTime(allRows).equals(timeUtil.getYesterday())) {
//                logger.error("文件日期不是昨天日期，文件名" + filename);
//                return null;
            } else {
                return allRows;
            }
        }
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
