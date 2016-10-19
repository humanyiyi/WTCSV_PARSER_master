package com.udbac.csvparser.repo.impl;

import com.udbac.csvparser.entity.TbAmpBackendTransDaily;
import com.udbac.csvparser.repo.BackendTransRepo;
import com.udbac.csvparser.service.BackendTransService;
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
public class BackendTransRepoImpl implements BackendTransRepo {

    private static final Logger logger = LoggerFactory.getLogger(BackendBaseRepoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BackendTransService backendTransService;

    @Override
    public void insertBackendTrans() {
            String tableName = "tb_amp_backend_trans_daily_table";
            List<TbAmpBackendTransDaily> list = backendTransService.getBackendTrans();
            if(list.isEmpty()){
                logger.error("***插入表"+tableName+"失败***，获取数据为空");
                return;
            }
            for (TbAmpBackendTransDaily tbAmpBackendTransDaily : list) {
                String sql = "INSERT INTO " + tableName + " VALUES(" + tbAmpBackendTransDaily.toString() + ")";
                try {
                    jdbcTemplate.execute(sql);
                } catch (Exception e) {
                    logger.error("*表"+tableName+"插入语句异常*"+e);
                    e.printStackTrace();
                }
            }
        logger.info("插入数据到表" + tableName + "完成");
    }
}

