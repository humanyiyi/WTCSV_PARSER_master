package com.udbac.csvparser.service.impl;

import com.udbac.csvparser.entity.*;
import com.udbac.csvparser.service.FlowDailyService;
import com.udbac.csvparser.utils.CsvParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 43890 on 2016/10/16.
 */
@Service
public class FlowDailyServiceImpl implements FlowDailyService {

    @Autowired
    CsvParseUtil csvParseUtil;

    @Override
    public Map<CustomerKey, TbAmpFlowMarketingPageDaily> getFlowMarketingPage() throws Exception {
        CustomerKey customerKey;
        TbAmpFlowMarketingPageDaily tbAmpFlowMarketingPageDaily;
        List<String[]> ampFlowMarketPageRows = csvParseUtil.parseCSV2Rows("营销活动allhits_page.csv");
        HashMap<CustomerKey, TbAmpFlowMarketingPageDaily> tbAmpFlowMarketingPageDailyMap = new HashMap<>();

        for (String[] row1 : ampFlowMarketPageRows) {
            tbAmpFlowMarketingPageDaily = new TbAmpFlowMarketingPageDaily();
            if (row1.length != 8 || null == row1[0]) {
                continue;
            }
            if (row1[2] != null &&row1[2].equals("Total")) {
                continue;
            }
            try {
                tbAmpFlowMarketingPageDaily.setCreateDate(csvParseUtil.getTime(ampFlowMarketPageRows));
                tbAmpFlowMarketingPageDaily.setMic(row1[1]);
                tbAmpFlowMarketingPageDaily.setUrl(row1[3]);
                customerKey = new CustomerKey(tbAmpFlowMarketingPageDaily.getMic(), tbAmpFlowMarketingPageDaily.getUrl(), null, null);
                tbAmpFlowMarketingPageDaily.setVisits(Integer.valueOf(row1[5]));
                tbAmpFlowMarketingPageDaily.setPv(Integer.valueOf(row1[7]));

                tbAmpFlowMarketingPageDailyMap.put(customerKey, tbAmpFlowMarketingPageDaily);
            }catch(NumberFormatException e){
//                e.printStackTrace();
            }
        }
        return tbAmpFlowMarketingPageDailyMap;
    }

    @Override
    public Map<CustomerKey, TbAmpFlowMarketingDaily> getFlowMarketing() throws Exception {
        CustomerKey customerKey;
        TbAmpFlowMarketingDaily tbAmpFlowMarketingDaily;
        List<String[]> ampFlowMarketRows = csvParseUtil.parseCSV2Rows("营销流量allhits_WT.es-new.csv");
        HashMap<CustomerKey, TbAmpFlowMarketingDaily> tbAmpFlowMarketingDailyMap = new HashMap<>();

        for (String[] row1 : ampFlowMarketRows) {
            tbAmpFlowMarketingDaily = new TbAmpFlowMarketingDaily();
            if (row1.length != 6 || null == row1[0]) {
                continue;
            }
            if (row1[2].equals("Total")) {
                continue;
            }try {
                tbAmpFlowMarketingDaily.setCreateDate(csvParseUtil.getTime(ampFlowMarketRows));
                tbAmpFlowMarketingDaily.setMic(row1[1]);
                tbAmpFlowMarketingDaily.setUrl(row1[2]);
                customerKey = new CustomerKey(tbAmpFlowMarketingDaily.getMic(), tbAmpFlowMarketingDaily.getUrl(), null, null);
                tbAmpFlowMarketingDaily.setVisits(Integer.valueOf(row1[3]));
                tbAmpFlowMarketingDaily.setPv(Integer.valueOf(row1[5]));

                tbAmpFlowMarketingDailyMap.put(customerKey, tbAmpFlowMarketingDaily);
            }catch(NumberFormatException e){
//                e.printStackTrace();
            }
        }
        return tbAmpFlowMarketingDailyMap;
    }

    @Override
    public Map<CustomerKey, TbAmpFlowNatureDaily> getFlowNature() throws Exception {
        List<String[]> mcidPortalRows = csvParseUtil.parseCSV2Rows("访前网站_入站页(排除mcid)门户pc.csv");
        List<String[]> mcidPortalTouchRows = csvParseUtil.parseCSV2Rows("访前网站_入站页(排除mcid)门户mobile.csv");
        List<String[]> mcidShopRows = csvParseUtil.parseCSV2Rows("访前网站_入站页(排除mcid)shop.csv");
        List<String[]> mcidTouchRows = csvParseUtil.parseCSV2Rows("访前网站_入站页(排除mcid)touch.csv");

        Map<CustomerKey, TbAmpFlowNatureDaily> tbAmpFlowNatureDailyMap = new HashMap<>();

        if (mcidPortalRows.isEmpty() && mcidPortalTouchRows.isEmpty()
                && mcidShopRows.isEmpty() && mcidTouchRows.isEmpty()) {
            return null;
        } else {
            handleNature(mcidPortalRows, tbAmpFlowNatureDailyMap, "PORTAL_PC");
            handleNature(mcidPortalTouchRows, tbAmpFlowNatureDailyMap, "PORTAL_MOBILE");
            handleNature(mcidShopRows, tbAmpFlowNatureDailyMap, "SHOP");
            handleNature(mcidTouchRows, tbAmpFlowNatureDailyMap, "TOUCH");
        }
        return tbAmpFlowNatureDailyMap;
    }

    private void handleNature(List<String[]> rows, Map<CustomerKey, TbAmpFlowNatureDaily> map, String classfy) {

        CustomerKey customerKey;
        TbAmpFlowNatureDaily tbAmpFlowNatureDaily;
        for (String[] row1 : rows) {
            tbAmpFlowNatureDaily = new TbAmpFlowNatureDaily();
            if (row1.length != 10 || null == row1[0]) {
                continue;
            }
            if (row1[4] != null && row1[4].equals("Total")) {
                continue;
            }
            try {
                tbAmpFlowNatureDaily.setCreateDate(csvParseUtil.getTime(rows));
                tbAmpFlowNatureDaily.setClassfy(classfy);
                tbAmpFlowNatureDaily.setUrl(row1[2]);
                tbAmpFlowNatureDaily.setEntryPage(row1[5]);
                customerKey = new CustomerKey(null, tbAmpFlowNatureDaily.getUrl(),
                        tbAmpFlowNatureDaily.getEntryPage(), tbAmpFlowNatureDaily.getClassfy());
                tbAmpFlowNatureDaily.setVisits(Integer.valueOf(row1[7]));
                tbAmpFlowNatureDaily.setPv(Integer.valueOf(row1[9]));
                map.put(customerKey, tbAmpFlowNatureDaily);
            } catch (NumberFormatException e) {
//                e.printStackTrace();
            }
        }

    }


    @Override
    public Map<CustomerKey, TbAmpFlowTotalDaily> getFlowTotal() throws Exception {
        List<String[]> portalRows = csvParseUtil.parseCSV2Rows("门户_页.csv");
        List<String[]> shopRows = csvParseUtil.parseCSV2Rows("shop_页.csv");
        List<String[]> touchRows = csvParseUtil.parseCSV2Rows("touch_页.csv");

        Map<CustomerKey, TbAmpFlowTotalDaily> tbAmpFlowTotalDailyMap = new HashMap<>();
        if (portalRows.isEmpty() && shopRows.isEmpty() && touchRows.isEmpty()) {
            return null;
        } else {
            handleTotal(portalRows, tbAmpFlowTotalDailyMap, "PORTAL");
            handleTotal(shopRows, tbAmpFlowTotalDailyMap, "SHOP");
            handleTotal(touchRows, tbAmpFlowTotalDailyMap, "TOUCH");
        }
        return tbAmpFlowTotalDailyMap;
    }

    private void handleTotal(List<String[]> rows, Map<CustomerKey, TbAmpFlowTotalDaily> map, String classfy) {

        CustomerKey customerKey;
        TbAmpFlowTotalDaily tbAmpFlowTotalDaily;
        for (String[] row1 : rows) {
            tbAmpFlowTotalDaily = new TbAmpFlowTotalDaily();
            if (row1.length != 8 || null == row1[0]) {
                continue;
            }
            try {
                tbAmpFlowTotalDaily.setCreateDate(csvParseUtil.getTime(rows));
                tbAmpFlowTotalDaily.setClassfy(classfy);
                tbAmpFlowTotalDaily.setUrl(row1[2]);
                customerKey = new CustomerKey(null, tbAmpFlowTotalDaily.getUrl(), null, tbAmpFlowTotalDaily.getClassfy());
                tbAmpFlowTotalDaily.setVisits(Integer.valueOf(row1[4]));
                tbAmpFlowTotalDaily.setPv(Integer.valueOf(row1[5]));
                tbAmpFlowTotalDaily.setViewTime(row1[6]);
                map.put(customerKey, tbAmpFlowTotalDaily);
            } catch (NumberFormatException e) {
//                e.printStackTrace();
            }
        }

    }
}
