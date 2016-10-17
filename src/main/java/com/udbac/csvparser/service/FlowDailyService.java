package com.udbac.csvparser.service;

import com.udbac.csvparser.entity.TbAmpFlowMarketingDaily;
import com.udbac.csvparser.entity.TbAmpFlowNatureDaily;
import com.udbac.csvparser.entity.TbAmpFlowTotalDaily;

import java.util.List;

/**
 * Created by 43890 on 2016/10/16.
 */
public interface FlowDailyService {

    List<TbAmpFlowMarketingDaily> getFlowMarketing();

    List<TbAmpFlowNatureDaily> getFlowNature();

    List<TbAmpFlowTotalDaily> getFlowTotal();
}
