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
import org.springframework.transaction.annotation.Transactional;

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
    public void insertFlowMarket() {
        String tableName = "tb_amp_flow_marketing_daily_table";
        List<TbAmpFlowMarketingDaily> marketingDailyList = flowDailyService.getFlowMarketing();
        if (marketingDailyList.isEmpty()) {
            logger.error("***插入表" + tableName + "失败***，获取数据为空");
            return;
        }
        for (TbAmpFlowMarketingDaily tbAmpFlowMarketingDaily : marketingDailyList) {
            String sql = "INSERT INTO " + tableName + " VALUES(" + tbAmpFlowMarketingDaily.toString() + ")";
            try {
                jdbcTemplate.execute(sql);
            } catch (Exception e) {
                logger.error("*表" + tableName + "插入语句异常*" + e);
                e.printStackTrace();
            }
        }
        logger.info("插入数据到" + tableName + "完成");
    }


    @Override
    public void insertFlowNature() {
        String tableName = "tb_amp_flow_nature_daily_table";
        List<TbAmpFlowNatureDaily> natureDailyList = flowDailyService.getFlowNature();
        if (natureDailyList.isEmpty()) {
            logger.error("***插入表" + tableName + "失败***，获取数据为空");
            return;
        }
        for (TbAmpFlowNatureDaily tbAmpFlowNatureDaily : natureDailyList) {
            String sql = "INSERT INTO " + tableName + " VALUES(" + tbAmpFlowNatureDaily.toString() + ")";
            try {
                jdbcTemplate.execute(sql);
            }catch (Exception e) {
                logger.error("*表" + tableName + "插入语句异常*" + e);
                e.printStackTrace();
            }
        }
        logger.info("插入数据到" + tableName + "完成");
    }

    @Override
    public void insertFlowTotalDaily() {
        String tableName = "tb_amp_flow_total_daily_table";
        List<TbAmpFlowTotalDaily> totalDailyList = flowDailyService.getFlowTotal();
        if (totalDailyList.isEmpty()) {
            logger.error("***插入表" + tableName + "失败***，获取数据为空");
            return;
        }
        for (TbAmpFlowTotalDaily tbAmpFlowTotalDaily : totalDailyList) {
            String sql = "INSERT INTO " + tableName + " VALUES(" + tbAmpFlowTotalDaily.toString() + ")";
            try {
                jdbcTemplate.execute(sql);
            } catch (Exception e) {
                logger.error("*表" + tableName + "插入语句异常*"+sql+ e);
                e.printStackTrace();
            }
        }
        logger.info("插入数据到" + tableName + "完成");
    }
}
