package com.udbac.csvparser.service;

import com.udbac.csvparser.entity.CustomerKey;
import com.udbac.csvparser.entity.TbAmpBackendTransDaily;

import java.util.Map;

/**
 * Created by 43890 on 2016/10/16.
 * 解析CSV文件数据 tb_amp_backend_trans_daily
 */
public interface BackendTransService {
    Map<CustomerKey,TbAmpBackendTransDaily> getBackendTrans() throws Exception;
}
