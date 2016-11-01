package com.udbac.csvparser.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by 43890 on 2016/10/11.
 * 读取配置文件
 */
@Component
public class ParserProperties {

    @Value("${com.udbac.csvparser.csvpath}")
    private String csvPath;
    public String getCsvPath() {
        return csvPath;
    }

    @Value("${com.udbac.csvparser.addressees}")
    private String addressees;
    public String getAddressees() {
        return addressees;
    }


}
