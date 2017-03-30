package com.udbac.csvparser.entity;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class TbAmpFlowMarketingDaily {

    private String createDate;
    private String mic;
    private String url;
    private Integer visits;
    private Integer pv;

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getMic() {
        return mic;
    }
//    public void setMic(String mic) {
//        this.mic = mic;
//    }
    public void setMic(String mic) {
        if (!StringUtils.isEmpty(mic)) {
            if (mic.contains("'")) {
                this.mic = mic.replace("'", "''");
                return;
            }
        }
        this.mic = mic;
    }

    public String getUrl() {
        return url;
    }

    /**
     * 转义sql中的 '
     *
     * @param url
     */
    public void setUrl(String url) {
        if (!StringUtils.isEmpty(url)) {
            if (url.contains("'")) {
                this.url = url.replace("'", "''");
                return;
            }
        }
        this.url = url;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    @Override
    public String toString() {
        return "'" + createDate + "'" +
                ", '" + mic + '\'' +
                ", '" + url + '\'' +
                ", " + visits +
                "," + pv;
    }

}
