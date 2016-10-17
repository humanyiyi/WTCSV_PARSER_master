package com.udbac.csvparser.service.impl;

import com.udbac.csvparser.Application;
import com.udbac.csvparser.entity.TbAmpBackendTransDaily;
import com.udbac.csvparser.service.BackendTransService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by 43890 on 2016/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class BackendTransRepoImplTest {
    private static final Logger logger = LoggerFactory.getLogger(BackendTransRepoImplTest.class);
    @Autowired
    BackendTransService backendTransService;
    @Test
    public void getBackendTrans() throws Exception {
        List<TbAmpBackendTransDaily> list = backendTransService.getBackendTrans();
        for (TbAmpBackendTransDaily tb : list) {
            System.out.println(tb.toString());
        }
        System.err.println(list.size());
    }

}