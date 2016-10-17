package com.udbac.csvparser.repo.impl;

import com.udbac.csvparser.Application;
import com.udbac.csvparser.repo.BackendBaseRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 43890 on 2016/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class BackendBaseRepoImplTest {
    @Autowired
    BackendBaseRepo backendBaseRepo;
    @Test
    public void insertBackendBase() throws Exception {
        backendBaseRepo.insertBackendBase();
    }

}