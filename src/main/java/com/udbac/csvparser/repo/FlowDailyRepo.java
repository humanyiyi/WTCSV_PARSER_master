package com.udbac.csvparser.repo;

/**
 * Created by 43890 on 2016/10/17.
 */
public interface FlowDailyRepo {
    void insertFlowMarket() throws Exception;

    void insertFlowNature() throws Exception;

    void insertFlowTotalDaily() throws Exception;
}
