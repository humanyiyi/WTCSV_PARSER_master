package com.udbac.csvparser.service.impl;

import com.udbac.csvparser.Application;
import com.udbac.csvparser.entity.TbAmpBackendBaseDaily;
import com.udbac.csvparser.service.BackendBaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by 43890 on 2016/10/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class BackendBaseServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(BackendBaseServiceImplTest.class);
    @Autowired
    BackendBaseService backendBaseService;
    @Test
    public void getDailyCsv() throws Exception {
       List<TbAmpBackendBaseDaily> list= backendBaseService.getBaseDaily();
        for (TbAmpBackendBaseDaily tbAmpBackendBaseDaily : list) {
            System.out.println(tbAmpBackendBaseDaily.toString());
        }
        System.err.println(list.size());
    }

}