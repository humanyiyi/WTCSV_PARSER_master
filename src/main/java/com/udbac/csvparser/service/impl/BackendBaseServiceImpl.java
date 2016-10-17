package com.udbac.csvparser.service.impl;

import com.udbac.csvparser.entity.TbAmpBackendBaseDaily;
import com.udbac.csvparser.service.BackendBaseService;

import com.udbac.csvparser.utils.CsvParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 43890 on 2016/10/11.
 */
@Service
public class BackendBaseServiceImpl implements BackendBaseService {

    @Autowired
    CsvParseUtil csvParseUtil;
    @Autowired
    TbAmpBackendBaseDaily baseTable;

    @Override
    public List<TbAmpBackendBaseDaily> getBaseDaily() {
        List<TbAmpBackendBaseDaily> baseTableList;
        List<String[]> visitRows = csvParseUtil.parseCSV2Rows("营销活动(访次).csv");
        List<String[]> avisitRows = csvParseUtil.parseCSV2Rows("营销活动(访客).csv");
        List<String[]> activityRows = csvParseUtil.parseCSV2Rows("营销活动(clicks).csv");
        List<String[]> jumpRows = csvParseUtil.parseCSV2Rows("营销活动(跳出).csv");
        if (visitRows.isEmpty() && activityRows.isEmpty()
                && activityRows.isEmpty() && jumpRows.isEmpty()) {
            return null;
        } else {
            baseTableList = new ArrayList<TbAmpBackendBaseDaily>();
            for (String[] row1 : visitRows) {
                baseTable = new TbAmpBackendBaseDaily();
                if (row1.length != 6 || null == row1[0]) {
                    continue;
                }
                baseTable.setCreateDate(csvParseUtil.getTime(visitRows));
                baseTable.setMic(row1[1]);
                baseTable.setVisits(row1[2]);
                baseTable.setPv(row1[4]);
                baseTable.setViewTime(row1[5]);
                for (String[] row2 : avisitRows) {
                    if (row2.length == 4 && row2[1].equals(baseTable.getMic())) {
                        baseTable.setVisitor(row2[2]);
                    }
                }
                for (String[] row3 : activityRows) {
                    if (row3.length == 4 && row3[1].equals(baseTable.getMic())) {
                        baseTable.setClick(row3[2]);
                    }
                }
                for (String[] row4 : jumpRows) {
                    if (row4.length == 4 && row4[1].equals(baseTable.getMic())) {
                        baseTable.setBounceVisit(row4[2]);
                    }
                }
                baseTableList.add(baseTable);
            }
        }
        return baseTableList;
    }

}
