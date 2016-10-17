package com.udbac.csvparser.repo.impl;

import com.udbac.csvparser.entity.TbAmpBackendBaseDaily;
import com.udbac.csvparser.repo.BackendBaseRepo;
import com.udbac.csvparser.service.BackendBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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
        try {
            List<TbAmpBackendBaseDaily> list = backendBaseService.getBaseDaily();
            for (TbAmpBackendBaseDaily baseTable : list) {
                String sql = "INSERT INTO " + tableName + " VALUES(" + baseTable.toString() + ")";
                jdbcTemplate.execute(sql);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("插入表"+tableName+"失败"+e);
        }
        logger.info("插入数据到tb_amp_backend_base _daily完成");
    }
}
