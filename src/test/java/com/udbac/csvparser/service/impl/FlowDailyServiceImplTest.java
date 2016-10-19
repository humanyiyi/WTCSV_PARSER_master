package com.udbac.csvparser.service.impl;

import com.udbac.csvparser.Application;
import com.udbac.csvparser.entity.TbAmpFlowMarketingDaily;
import com.udbac.csvparser.entity.TbAmpFlowNatureDaily;
import com.udbac.csvparser.entity.TbAmpFlowTotalDaily;
import com.udbac.csvparser.service.FlowDailyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by 43890 on 2016/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class FlowDailyServiceImplTest {
    @Autowired
    FlowDailyService flowDailyService;

    @Test
    public void getFlowMarketing() throws Exception {
        List<TbAmpFlowMarketingDaily> list = flowDailyService.getFlowMarketing();
        for (TbAmpFlowMarketingDaily market : list) {
            System.out.println(market.toString());
        }
        System.err.println(list.size());
    }

    @Test
    public void getFlowNature() throws Exception {
        List<TbAmpFlowNatureDaily> list = flowDailyService.getFlowNature();
        for (TbAmpFlowNatureDaily tb : list) {
            System.out.println(tb.toString());
        }
        System.err.println(list.size());
    }

    @Test
    public void getFlowTotal() throws Exception {
        List<TbAmpFlowTotalDaily> list = flowDailyService.getFlowTotal();
        for (TbAmpFlowTotalDaily tb : list) {
            System.out.println(tb.toString());
        }
        list.size();
    }

}