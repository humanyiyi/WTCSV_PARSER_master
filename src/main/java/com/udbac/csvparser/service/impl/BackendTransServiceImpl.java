package com.udbac.csvparser.service.impl;

import com.udbac.csvparser.entity.TbAmpBackendTransDaily;
import com.udbac.csvparser.service.BackendTransService;
import com.udbac.csvparser.utils.CsvParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 43890 on 2016/10/16.
 */
@Service
public class BackendTransServiceImpl implements BackendTransService {
    @Autowired
    CsvParseUtil csvParseUtil;
    @Autowired
    TbAmpBackendTransDaily tbAmpBackendTransDaily;

    @Override
    public List<TbAmpBackendTransDaily> getBackendTrans() throws Exception{
        List<TbAmpBackendTransDaily> tbAmpBackendTransDailyList=new ArrayList<TbAmpBackendTransDaily>();;
        List<String[]> pageClickRows = csvParseUtil.parseCSV2Rows("营销活动(落地页元素点击)去掉nv.csv");
        List<String[]> serviceRows = csvParseUtil.parseCSV2Rows("营销活动_办业务转化.csv");
        List<String[]> phonBuyRows = csvParseUtil.parseCSV2Rows("营销活动_买手机转化.csv");
        List<String[]> setMealRows = csvParseUtil.parseCSV2Rows("营销活动_办套餐转化.csv");
        List<String[]> partsRows = csvParseUtil.parseCSV2Rows("营销活动_挑配件转化.csv");
        if (pageClickRows.isEmpty() && serviceRows.isEmpty() && phonBuyRows.isEmpty()
                &&setMealRows.isEmpty() && partsRows.isEmpty()) {
            return null;
        }else {
            for (String[] row1 : pageClickRows) {
                tbAmpBackendTransDaily = new TbAmpBackendTransDaily();
                if (row1.length != 6 || null == row1[0]) {
                    continue;
                } else {
                    if (row1[2].equals("Total")) {
                        tbAmpBackendTransDaily.setCreateDate(csvParseUtil.getTime(pageClickRows));
                        tbAmpBackendTransDaily.setMic(row1[1]);
                        tbAmpBackendTransDaily.setBehaviorVV(row1[5]);
                        for (String[] row2 : serviceRows) {
                            if (row2.length == 6 && row2[1].equals(tbAmpBackendTransDaily.getMic())) {
                                if (row2[2].equals("办理成功"))
                                    tbAmpBackendTransDaily.setTransactionVV(row2[3]);
                            }
                        }

                        for (String[] row3 : phonBuyRows) {
                            if (row3.length == 6 && row3[1].equals(tbAmpBackendTransDaily.getMic())) {
                                if (row3[2].equals("提交订单按钮"))
                                    tbAmpBackendTransDaily.setPhonBuyVV(row3[3]);
                            }
                        }

                        for (String[] row4 : setMealRows) {
                            if (row4.length == 6 && row4[1].equals(tbAmpBackendTransDaily.getMic())) {
                                if (row4[2].equals("办理成功"))
                                    tbAmpBackendTransDaily.setSetMealVV(row4[3]);
                            }
                        }

                        for (String[] row5 : partsRows) {
                            if (row5.length == 6 && row5[1].equals(tbAmpBackendTransDaily.getMic())) {
                                if (row5[2].equals("提交订单按钮"))
                                    tbAmpBackendTransDaily.setPartsVV(row5[3]);
                            }
                        }

                        tbAmpBackendTransDailyList.add(tbAmpBackendTransDaily);
                    }
                }
            }

        }
        return tbAmpBackendTransDailyList;
    }
}
