package com.udbac.csvparser.repo.impl;

import com.udbac.csvparser.entity.*;
import com.udbac.csvparser.repo.FlowDailyRepo;
import com.udbac.csvparser.service.FlowDailyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by 43890 on 2016/10/17.
 */
@Component
public class FlowDailyRepoImpl implements FlowDailyRepo {
    private static final Logger logger = LoggerFactory.getLogger(FlowDailyRepoImpl.class);
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    FlowDailyService flowDailyService;

    @Override
    public void insertFlowMarketPage() throws Exception {
        String tableName = "tb_amp_flow_marketing_page_daily ";
        Map<CustomerKey, TbAmpFlowMarketingPageDaily> marketingPageMap = flowDailyService.getFlowMarketingPage();
        if (marketingPageMap.isEmpty()) {
            logger.error("***INSERT INTO TABLE:*" + tableName + "*FAILED， CAUSE BY EMPTY SET FROM CSV FILE ***");
            throw new RuntimeException();
        }

        Iterator iter = marketingPageMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            TbAmpFlowMarketingPageDaily tbAmpFlowMarketingPageDaily = (TbAmpFlowMarketingPageDaily) entry.getValue();
            if (tbAmpFlowMarketingPageDaily.getMic().length() > 100) {
                continue;
            }
            String sql = "INSERT INTO " + tableName + " VALUES(" + tbAmpFlowMarketingPageDaily.toString() + ") ";
            jdbcTemplate.execute(sql);
        }
        logger.info("---INSERT INTO TABLE:-" + tableName + "-SUCCEED---");
    }

    @Override
    public void insertFlowMarket() throws Exception {
        String tableName = "tb_amp_flow_marketing_daily ";
        Map<CustomerKey, TbAmpFlowMarketingDaily> marketingMap = flowDailyService.getFlowMarketing();
        if (marketingMap.isEmpty()) {
            logger.error("***INSERT INTO TABLE:*" + tableName + "*FAILED， CAUSE BY EMPTY SET FROM CSV FILE ***");
            throw new RuntimeException();
        }

        Iterator iter = marketingMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            TbAmpFlowMarketingDaily tbAmpFlowMarketingDaily = (TbAmpFlowMarketingDaily) entry.getValue();
            if (tbAmpFlowMarketingDaily.getMic().length() > 100) {
                continue;
            }
            String sql = "INSERT INTO " + tableName + " VALUES(" + tbAmpFlowMarketingDaily.toString() + ") ";
            jdbcTemplate.execute(sql);
        }
        logger.info("---INSERT INTO TABLE:-" + tableName + "-SUCCEED---");
    }


    @Override
    public void insertFlowNature() throws Exception {
        String tableName = "tb_amp_flow_nature_daily ";
        Map<CustomerKey, TbAmpFlowNatureDaily> natureMap = flowDailyService.getFlowNature();
        if (natureMap.isEmpty()) {
            logger.error("***INSERT INTO TABLE:*" + tableName + "*FAILED， CAUSE BY EMPTY SET FROM CSV FILE ***");
            throw new RuntimeException();
        }

        Iterator iter = natureMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            TbAmpFlowNatureDaily tbAmpFlowNatureDaily = (TbAmpFlowNatureDaily) entry.getValue();
            String sql = "INSERT INTO " + tableName + " VALUES(" + tbAmpFlowNatureDaily.toString() + ") ";
            jdbcTemplate.execute(sql);
        }
        logger.info("---INSERT INTO TABLE:-" + tableName + "-SUCCEED---");
    }

    @Override
    public void insertFlowTotalDaily() throws Exception {

        String tableName = "tb_amp_flow_total_daily ";
        Map<CustomerKey, TbAmpFlowTotalDaily> totalMap = null;

        totalMap = flowDailyService.getFlowTotal();

        if (totalMap.isEmpty()) {
            logger.error("***INSERT INTO TABLE:*" + tableName + "*FAILED， CAUSE BY EMPTY SET FROM CSV FILE ***");
            throw new RuntimeException();
        }

        Iterator iter = totalMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            TbAmpFlowTotalDaily tbAmpFlowTotalDaily = (TbAmpFlowTotalDaily) entry.getValue();
            String sql = "INSERT INTO " + tableName + " VALUES(" + tbAmpFlowTotalDaily.toString() + ") ";
            jdbcTemplate.execute(sql);
        }
        logger.info("---INSERT INTO TABLE:-" + tableName + "-SUCCEED---");
    }
}
