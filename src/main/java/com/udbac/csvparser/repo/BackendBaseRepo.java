package com.udbac.csvparser.repo;

import com.udbac.csvparser.entity.TbAmpBackendBaseDaily;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 43890 on 2016/10/16.
 * 插入表tb_amp_backend_base_daily
 */
public interface BackendBaseRepo {
    void insertBackendBase() throws Exception;
}
