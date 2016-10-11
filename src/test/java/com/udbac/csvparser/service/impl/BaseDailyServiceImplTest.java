package com.udbac.csvparser.service.impl;

import com.udbac.csvparser.Application;
import com.udbac.csvparser.entity.TbAmpBackendBaseDaily;
import com.udbac.csvparser.service.BaseDailyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by 43890 on 2016/10/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class BaseDailyServiceImplTest {
    @Autowired
    BaseDailyService baseDailyService;
    @Test
    public void getDailyCsv() throws Exception {
       List<TbAmpBackendBaseDaily> list= baseDailyService.getDailyCsv();
        for (TbAmpBackendBaseDaily tbAmpBackendBaseDaily : list) {
            System.out.println(tbAmpBackendBaseDaily.toString());
        }
    }

}