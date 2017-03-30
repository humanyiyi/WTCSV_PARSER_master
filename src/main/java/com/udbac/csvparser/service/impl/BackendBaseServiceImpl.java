package com.udbac.csvparser.service.impl;

import com.udbac.csvparser.entity.CustomerKey;
import com.udbac.csvparser.entity.TbAmpBackendBaseDaily;
import com.udbac.csvparser.service.BackendBaseService;
import com.udbac.csvparser.utils.CsvParseUtil;
import com.udbac.csvparser.utils.ExitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 43890 on 2016/10/11.
 */
@Service
public class BackendBaseServiceImpl implements BackendBaseService {

    @Autowired
    CsvParseUtil csvParseUtil;

    @Override
    public Map<CustomerKey, TbAmpBackendBaseDaily> getBaseDaily() throws Exception {
        CustomerKey baseTableKey;
        TbAmpBackendBaseDaily baseTable;
        HashMap<CustomerKey, TbAmpBackendBaseDaily> baseTableMap = new HashMap<>();
        List<String[]> visitRows = csvParseUtil.parseCSV2Rows("营销活动(访次).csv");
        List<String[]> avisitRows = csvParseUtil.parseCSV2Rows("营销活动(访客).csv");
        List<String[]> activityRows = csvParseUtil.parseCSV2Rows("营销活动(clicks).csv");
        List<String[]> jumpRows = csvParseUtil.parseCSV2Rows("营销活动(跳出).csv");

        if (visitRows.isEmpty() && activityRows.isEmpty()
                && activityRows.isEmpty() && jumpRows.isEmpty()) {
            return null;
        } else {
            for (String[] row1 : visitRows) {
                try {
                    baseTable = new TbAmpBackendBaseDaily();
                    if (row1.length != 6 || null == row1[0]) {
                        continue;
                    }
                    baseTable.setCreateDate(csvParseUtil.getTime(visitRows));
                    baseTable.setMic(row1[1]);
                    baseTableKey = new CustomerKey(baseTable.getMic(), null, null, null);
                    baseTable.setVisits(Integer.valueOf(row1[2]));
                    baseTable.setPv(Integer.valueOf(row1[4]));
                    baseTable.setViewTime(row1[5]);
                    for (String[] row2 : avisitRows) {
                        if (row2.length == 4 && row2[1].equals(baseTable.getMic())) {
                            baseTable.setVisitor(Integer.valueOf(row2[2]));
                        }
                    }
                    for (String[] row3 : activityRows) {
                        if (row3.length == 5 && row3[1].equals(baseTable.getMic())) {
                            baseTable.setClick(Integer.valueOf(row3[2]));
                        }
                    }
                    for (String[] row4 : jumpRows) {
                        if (row4.length == 8 && row4[1].equals(baseTable.getMic())) {
                            baseTable.setBounceVisit(Integer.valueOf(row4[4]));
                        }
                    }
                    baseTableMap.put(baseTableKey, baseTable);
                } catch (NumberFormatException e) {
//                    e.printStackTrace();
                }
            }
        }
        return baseTableMap;
    }

}
