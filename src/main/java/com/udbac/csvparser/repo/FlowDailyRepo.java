package com.udbac.csvparser.repo;

/**
 * Created by 43890 on 2016/10/17.
 * 插入表 tb_amp_flow_marketing_daily
 *        tb_amp_flow_nature_daily
 *        tb_amp_flow_total_daily
 */
public interface FlowDailyRepo {
    void insertFlowMarket() throws Exception;

    void insertFlowNature() throws Exception;

    void insertFlowTotalDaily() throws Exception;
}
