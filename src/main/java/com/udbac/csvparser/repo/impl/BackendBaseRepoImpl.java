package com.udbac.csvparser.repo.impl;

import com.udbac.csvparser.entity.TbAmpBackendBaseDaily;
import com.udbac.csvparser.repo.BackendBaseRepo;
import com.udbac.csvparser.service.BackendBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 43890 on 2016/10/16.
 */
@Component
public class BackendBaseRepoImpl implements BackendBaseRepo {
    private static final Logger logger = LoggerFactory.getLogger(BackendBaseRepoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BackendBaseService backendBaseService;
    @Override
    public void insertBackendBase() {
            String tableName = "tb_amp_backend_base_daily_table";
            List<TbAmpBackendBaseDaily> list = backendBaseService.getBaseDaily();
            if(list.isEmpty()){
                logger.error("***插入表"+tableName+"失败***，获取数据为空");
                return;
            }
            for (TbAmpBackendBaseDaily tbAmpBackendBaseDaily : list) {
                String sql = "INSERT INTO " + tableName + " VALUES(" + tbAmpBackendBaseDaily.toString() + ")";
                try {
                    jdbcTemplate.execute(sql);
                } catch (Exception e) {
                    logger.error("*表"+tableName+"插入语句异常*"+e);
                    e.printStackTrace();
                }
            }
        logger.info("插入数据到" + tableName + "完成");
    }
}
