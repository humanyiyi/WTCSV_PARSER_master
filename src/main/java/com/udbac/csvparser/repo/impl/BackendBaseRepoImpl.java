package com.udbac.csvparser.repo.impl;

import com.udbac.csvparser.entity.CustomerKey;
import com.udbac.csvparser.entity.TbAmpBackendBaseDaily;
import com.udbac.csvparser.repo.BackendBaseRepo;
import com.udbac.csvparser.service.BackendBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by 43890 on 2016/10/16.
 */
@Repository
public class BackendBaseRepoImpl implements BackendBaseRepo {
    private static final Logger logger = LoggerFactory.getLogger(BackendBaseRepoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BackendBaseService backendBaseService;

    @Override
    public void insertBackendBase() throws Exception {
        String tableName = "tb_amp_backend_base_daily ";
        Map<CustomerKey, TbAmpBackendBaseDaily> map = backendBaseService.getBaseDaily();
        if (map.isEmpty()) {
            logger.error("***INSERT INTO TABLE:*" + tableName + "*FAILED， CAUSE BY EMPTY SET FROM CSV FILE ***");
            throw new RuntimeException();
        }

        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            TbAmpBackendBaseDaily tbAmpBackendBaseDaily = (TbAmpBackendBaseDaily) entry.getValue();
            if (tbAmpBackendBaseDaily.getMic().length() > 50) {
                continue;
            }
            String sql = "INSERT INTO " + tableName + " VALUES(" + tbAmpBackendBaseDaily.toString() + ")";
            jdbcTemplate.update(sql);
        }
        logger.info("---INSERT INTO TABLE:-" + tableName + "-SUCCEED---");
    }

}
