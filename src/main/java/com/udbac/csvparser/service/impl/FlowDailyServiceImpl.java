package com.udbac.csvparser.service.impl;

import com.udbac.csvparser.entity.TbAmpFlowMarketingDaily;
import com.udbac.csvparser.entity.TbAmpFlowNatureDaily;
import com.udbac.csvparser.entity.TbAmpFlowTotalDaily;
import com.udbac.csvparser.service.FlowDailyService;
import com.udbac.csvparser.utils.CsvParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 43890 on 2016/10/16.
 */
@Component
public class FlowDailyServiceImpl implements FlowDailyService {

    @Autowired
    CsvParseUtil csvParseUtil;

    @Autowired
    TbAmpFlowMarketingDaily tbAmpFlowMarketingDaily;
    @Autowired
    TbAmpFlowNatureDaily tbAmpFlowNatureDaily;
    @Autowired
    TbAmpFlowTotalDaily tbAmpFlowTotalDaily;

    @Override
    public List<TbAmpFlowMarketingDaily> getFlowMarketing() {
        List<String[]> ampFlowMarketRows = csvParseUtil.parseCSV2Rows("营销流量allhits_WT.es-new.csv");
        List<TbAmpFlowMarketingDaily> tbAmpFlowMarketingDailyList = new ArrayList<TbAmpFlowMarketingDaily>();

        for (String[] row1 : ampFlowMarketRows) {
            tbAmpFlowMarketingDaily = new TbAmpFlowMarketingDaily();
            if (row1.length != 6 || null == row1[0]) {
                continue;
            }
            if (row1[2].equals("合计")) {
                continue;
            }
            tbAmpFlowMarketingDaily.setCreateDate(csvParseUtil.getTime(ampFlowMarketRows));
            tbAmpFlowMarketingDaily.setMic(row1[1]);
            tbAmpFlowMarketingDaily.setUrl(row1[2]);
            tbAmpFlowMarketingDaily.setVisits(row1[3]);
            tbAmpFlowMarketingDaily.setPv(row1[5]);

            tbAmpFlowMarketingDailyList.add(tbAmpFlowMarketingDaily);

        }
        return tbAmpFlowMarketingDailyList;
    }

    @Override
    public List<TbAmpFlowNatureDaily> getFlowNature() {
        List<String[]> mcidPortalRows = csvParseUtil.parseCSV2Rows("访前网站_入站页(排除mcid)门户pc.csv");
        List<String[]> mcidPortalTouchRows = csvParseUtil.parseCSV2Rows("访前网站_入站页(排除mcid)门户mobile.csv");
        List<String[]> mcidShopRows = csvParseUtil.parseCSV2Rows("访前网站_入站页(排除mcid)shop.csv");
        List<String[]> mcidTouchRows = csvParseUtil.parseCSV2Rows("访前网站_入站页(排除mcid)touch.csv");

        List<TbAmpFlowNatureDaily> tbAmpFlowNatureDailyList = new ArrayList<TbAmpFlowNatureDaily>();
        if (mcidPortalRows.isEmpty() && mcidPortalTouchRows.isEmpty()
                && mcidShopRows.isEmpty() && mcidTouchRows.isEmpty()) {
            return null;
        } else {
            for (String[] row1 : mcidPortalRows) {

                tbAmpFlowNatureDaily = new TbAmpFlowNatureDaily();
                if (row1.length != 10 || null == row1[0]) {
                    continue;
                }
                if (row1[4] != null && row1[4].equals("合计")) {
                    continue;
                }
                tbAmpFlowNatureDaily.setCreateDate(csvParseUtil.getTime(mcidPortalRows));
                tbAmpFlowNatureDaily.setClassfy("PORTAL_PC");
                tbAmpFlowNatureDaily.setUrl(row1[2]);
                tbAmpFlowNatureDaily.setEntryPage(row1[5]);
                tbAmpFlowNatureDaily.setVisits(row1[7]);
                tbAmpFlowNatureDaily.setPv(row1[9]);
                tbAmpFlowNatureDailyList.add(tbAmpFlowNatureDaily);
            }

            for (String[] row4 : mcidPortalRows) {

                tbAmpFlowNatureDaily = new TbAmpFlowNatureDaily();
                if (row4.length != 10 || null == row4[0]) {
                    continue;
                }
                if (row4[4] != null && row4[4].equals("合计")) {
                    continue;
                }
                tbAmpFlowNatureDaily.setCreateDate(csvParseUtil.getTime(mcidPortalRows));
                tbAmpFlowNatureDaily.setClassfy("PORTAL_MOBILE");
                tbAmpFlowNatureDaily.setUrl(row4[2]);
                tbAmpFlowNatureDaily.setEntryPage(row4[5]);
                tbAmpFlowNatureDaily.setVisits(row4[7]);
                tbAmpFlowNatureDaily.setPv(row4[9]);
                tbAmpFlowNatureDailyList.add(tbAmpFlowNatureDaily);
            }

            for (String[] row2 : mcidShopRows) {

                tbAmpFlowNatureDaily = new TbAmpFlowNatureDaily();
                if (row2.length != 10 || null == row2[0]) {
                    continue;
                }
                if (row2[4] != null && row2[4].equals("合计")) {
                    continue;
                }
                tbAmpFlowNatureDaily.setCreateDate(csvParseUtil.getTime(mcidPortalRows));
                tbAmpFlowNatureDaily.setClassfy("SHOP");
                tbAmpFlowNatureDaily.setUrl(row2[2]);
                tbAmpFlowNatureDaily.setEntryPage(row2[5]);
                tbAmpFlowNatureDaily.setVisits(row2[7]);
                tbAmpFlowNatureDaily.setPv(row2[9]);
                tbAmpFlowNatureDailyList.add(tbAmpFlowNatureDaily);
            }

            for (String[] row3 : mcidTouchRows) {

                tbAmpFlowNatureDaily = new TbAmpFlowNatureDaily();
                if (row3.length != 10 || null == row3[0]) {
                    continue;
                }
                if (row3[4] != null && row3[4].equals("合计")) {
                    continue;
                }
                tbAmpFlowNatureDaily.setCreateDate(csvParseUtil.getTime(mcidPortalRows));
                tbAmpFlowNatureDaily.setClassfy("TOUCH");
                tbAmpFlowNatureDaily.setUrl(row3[2]);
                tbAmpFlowNatureDaily.setEntryPage(row3[5]);
                tbAmpFlowNatureDaily.setVisits(row3[7]);
                tbAmpFlowNatureDaily.setPv(row3[9]);

                tbAmpFlowNatureDailyList.add(tbAmpFlowNatureDaily);
            }
        }
        return tbAmpFlowNatureDailyList;
    }

    @Override
    public List<TbAmpFlowTotalDaily> getFlowTotal() {
        List<String[]> portalRows = csvParseUtil.parseCSV2Rows("门户_页.csv");
        List<String[]> shopRows = csvParseUtil.parseCSV2Rows("shop_页.csv");
        List<String[]> touchRows = csvParseUtil.parseCSV2Rows("touch_页.csv");

        List<TbAmpFlowTotalDaily> tbAmpFlowTotalDailyList = new ArrayList<TbAmpFlowTotalDaily>();
        if (portalRows.isEmpty() && shopRows.isEmpty() && touchRows.isEmpty()) {
            return null;
        } else {
            for (String[] row1 : portalRows) {
                tbAmpFlowTotalDaily = new TbAmpFlowTotalDaily();
                if (row1.length != 8 || null == row1[0]) {
                    continue;
                }
                tbAmpFlowTotalDaily.setCreateDate(csvParseUtil.getTime(portalRows));
                tbAmpFlowTotalDaily.setClassfy("PORTAL");
                tbAmpFlowTotalDaily.setUrl(row1[2]);
                tbAmpFlowTotalDaily.setVisits(row1[5]);
                tbAmpFlowTotalDaily.setPv(row1[6]);
                tbAmpFlowTotalDaily.setViewTime(row1[7]);

                tbAmpFlowTotalDailyList.add(tbAmpFlowTotalDaily);
            }
            for (String[] row2 : shopRows) {

                tbAmpFlowTotalDaily = new TbAmpFlowTotalDaily();
                if (row2.length != 8 || null == row2[0]) {
                    continue;
                }
                tbAmpFlowTotalDaily.setCreateDate(csvParseUtil.getTime(portalRows));
                tbAmpFlowTotalDaily.setClassfy("SHOP");
                tbAmpFlowTotalDaily.setUrl(row2[2]);
                tbAmpFlowTotalDaily.setVisits(row2[5]);
                tbAmpFlowTotalDaily.setPv(row2[6]);
                tbAmpFlowTotalDaily.setViewTime(row2[7]);

                tbAmpFlowTotalDailyList.add(tbAmpFlowTotalDaily);
            }
            for (String[] row3 : touchRows) {
                tbAmpFlowTotalDaily = new TbAmpFlowTotalDaily();
                if (row3.length != 8 || null == row3[0]) {
                    continue;
                }
                tbAmpFlowTotalDaily.setCreateDate(csvParseUtil.getTime(portalRows));
                tbAmpFlowTotalDaily.setClassfy("TOUCH");
                tbAmpFlowTotalDaily.setUrl(row3[2]);
                tbAmpFlowTotalDaily.setVisits(row3[5]);
                tbAmpFlowTotalDaily.setPv(row3[6]);
                tbAmpFlowTotalDaily.setViewTime(row3[7]);
                tbAmpFlowTotalDailyList.add(tbAmpFlowTotalDaily);
            }
            return tbAmpFlowTotalDailyList;
        }
    }
}
