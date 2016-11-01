package com.udbac.csvparser.service;

import com.udbac.csvparser.entity.TbAmpBackendTransDaily;

import java.util.List;

/**
 * Created by 43890 on 2016/10/16.
 * 解析CSV文件数据 tb_amp_backend_trans_daily
 */
public interface BackendTransService {
    List<TbAmpBackendTransDaily> getBackendTrans() throws Exception;
}
