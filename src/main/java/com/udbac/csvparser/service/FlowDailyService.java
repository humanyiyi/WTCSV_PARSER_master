package com.udbac.csvparser.service;

import com.udbac.csvparser.entity.CustomerKey;
import com.udbac.csvparser.entity.TbAmpFlowMarketingDaily;
import com.udbac.csvparser.entity.TbAmpFlowNatureDaily;
import com.udbac.csvparser.entity.TbAmpFlowTotalDaily;

import java.util.Map;

/**
 * Created by 43890 on 2016/10/16.
 * 解析CSV文件数据  tb_amp_flow_marketing_daily
                    tb_amp_flow_nature_daily
                    tb_amp_flow_total_daily
 */
public interface FlowDailyService {

    Map<CustomerKey,TbAmpFlowMarketingDaily> getFlowMarketing() throws Exception;

    Map<CustomerKey,TbAmpFlowNatureDaily> getFlowNature() throws Exception;

    Map<CustomerKey,TbAmpFlowTotalDaily> getFlowTotal() throws Exception;
}
