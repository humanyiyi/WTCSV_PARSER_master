package com.udbac.csvparser.service;

import com.udbac.csvparser.entity.TbAmpBackendTransDaily;

import java.util.List;

/**
 * Created by 43890 on 2016/10/16.
 */
public interface BackendTransService {
    List<TbAmpBackendTransDaily> getBackendTrans();
}
