package com.udbac.csvparser.service;

import com.udbac.csvparser.entity.TbAmpBackendBaseDaily;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 43890 on 2016/10/11.
 */

public interface BackendBaseService {
    List<TbAmpBackendBaseDaily> getBaseDaily() throws Exception;
}
