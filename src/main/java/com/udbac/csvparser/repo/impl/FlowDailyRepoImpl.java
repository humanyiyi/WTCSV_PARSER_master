package com.udbac.csvparser.repo.impl;

import com.udbac.csvparser.entity.TbAmpFlowMarketingDaily;
import com.udbac.csvparser.entity.TbAmpFlowNatureDaily;
import com.udbac.csvparser.entity.TbAmpFlowTotalDaily;
import com.udbac.csvparser.repo.FlowDailyRepo;
import com.udbac.csvparser.service.FlowDailyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public void insertFlowMarket() throws Exception{
        String tableName = "tb_amp_flow_marketing_daily_table";
        List<TbAmpFlowMarketingDaily> marketingDailyList = flowDailyService.getFlowMarketing();
        if (marketingDailyList.isEmpty()) {
            logger.error("***INSERT INTO TABLE:*" + tableName + "*FAILED， CAUSE BY EMPTY SET FROM CSV FILE ***");
            return;
        }
        for (TbAmpFlowMarketingDaily tbAmpFlowMarketingDaily : marketingDailyList) {
            if (tbAmpFlowMarketingDaily.getMic().length() >24) {continue;}
            String sql = "INSERT INTO " + tableName + " VALUES(" + tbAmpFlowMarketingDaily.toString() + ") on conflict do nothing";
                jdbcTemplate.execute(sql);
        }
        logger.info("---INSERT INTO TABLE:-" + tableName + "-SUCCEED---");
    }


    @Override
    public void insertFlowNature() throws Exception{
        String tableName = "tb_amp_flow_nature_daily_table";
        List<TbAmpFlowNatureDaily> natureDailyList = flowDailyService.getFlowNature();
        if (natureDailyList.isEmpty()) {
            logger.error("***INSERT INTO TABLE:*" + tableName + "*FAILED， CAUSE BY EMPTY SET FROM CSV FILE ***");
            return;
        }
        for (TbAmpFlowNatureDaily tbAmpFlowNatureDaily : natureDailyList) {
            String sql = "INSERT INTO " + tableName + " VALUES(" + tbAmpFlowNatureDaily.toString() + ") on conflict do nothing";
                jdbcTemplate.execute(sql);
            }
        logger.info("---INSERT INTO TABLE:-" + tableName + "-SUCCEED---");
    }

    @Override
    public void insertFlowTotalDaily() throws Exception{
        String tableName = "tb_amp_flow_total_daily_table";
        List<TbAmpFlowTotalDaily> totalDailyList = flowDailyService.getFlowTotal();
        if (totalDailyList.isEmpty()) {
            logger.error("***INSERT INTO TABLE:*" + tableName + "*FAILED， CAUSE BY EMPTY SET FROM CSV FILE ***");
            return;
        }
        for (TbAmpFlowTotalDaily tbAmpFlowTotalDaily : totalDailyList) {
            String sql = "INSERT INTO " + tableName + " VALUES(" + tbAmpFlowTotalDaily.toString() + ") on conflict do nothing";
                jdbcTemplate.execute(sql);
        }
        logger.info("---INSERT INTO TABLE:-" + tableName + "-SUCCEED---");
    }
}
