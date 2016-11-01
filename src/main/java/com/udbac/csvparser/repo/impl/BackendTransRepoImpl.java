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
    public void insertBackendTrans() throws Exception{
        String tableName = "tb_amp_backend_trans_daily ";
        List<TbAmpBackendTransDaily> list = backendTransService.getBackendTrans();
        if (list.isEmpty()) {
            logger.error("***INSERT INTO TABLE:*" + tableName + "*FAILED， CAUSE BY EMPTY SET FROM CSV FILE ***");
            throw new RuntimeException();
        }
        for (TbAmpBackendTransDaily tbAmpBackendTransDaily : list) {
            if (tbAmpBackendTransDaily.getMic().length() > 24) {
                continue;
            }
            String sql = "INSERT INTO " + tableName + " VALUES(" + tbAmpBackendTransDaily.toString() + ") on conflict do nothing";
            jdbcTemplate.execute(sql);
        }
        logger.info("---INSERT INTO TABLE:-" + tableName + "-SUCCEED---");
    }
}

