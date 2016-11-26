package com.udbac.csvparser.service;

import com.udbac.csvparser.entity.CustomerKey;
import com.udbac.csvparser.entity.TbAmpBackendBaseDaily;

import java.util.Map;

/**
 * Created by 43890 on 2016/10/11.
 * 解析CSV文件数据 tb_amp_backend_base_daily
 */

public interface BackendBaseService {
    Map<CustomerKey,TbAmpBackendBaseDaily> getBaseDaily() throws Exception;
}
