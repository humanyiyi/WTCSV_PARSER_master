package com.udbac.csvparser.repo.impl;

import com.udbac.csvparser.repo.BackendTransRepo;
import com.udbac.csvparser.service.BackendTransService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by 43890 on 2016/10/17.
 */
public class BackendTransRepoImpl implements BackendTransRepo {

    private static final Logger logger = LoggerFactory.getLogger(BackendBaseRepoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BackendTransService backendTransService;

    @Override
    public void insertBackendTrans() {

    }
}
