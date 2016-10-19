package com.udbac.csvparser.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 43890 on 2016/10/18.
 */
public class TbAmpFlowNatureDailyTest {
    @Test
    public void setUrl() throws Exception {
        TbAmpFlowNatureDaily tbAmpFlowNatureDaily = new TbAmpFlowNatureDaily();
        String temp = "aaaaaaaaaaaa'aaaaaaaaaaa";
        tbAmpFlowNatureDaily.setUrl(temp);

        System.out.println(tbAmpFlowNatureDaily.getUrl());
    }

}