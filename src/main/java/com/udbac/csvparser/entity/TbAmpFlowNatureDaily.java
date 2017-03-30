package com.udbac.csvparser.entity;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class TbAmpFlowNatureDaily {

    private String createDate;
    private String classfy;
    private String url;
    private String entryPage;
    private Integer visits;
    private Integer pv;

    public String getClassfy() {
        return classfy;
    }

    public void setClassfy(String classfy) {
        this.classfy = classfy;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getEntryPage() {
        return entryPage;
    }
    /**
     * 转义sql中的 '
     * @param entryPage
     */
    public void setEntryPage(String entryPage) {
        if (!StringUtils.isEmpty(entryPage)) {
            if (entryPage.contains("'")) {
                this.entryPage = entryPage.replace("'", "''");
                return;
            }
        }
        this.entryPage = entryPage;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        if (!StringUtils.isEmpty(url)) {
            if (url.contains("'")) {
                this.url = url.replace("'", "''");
                return;
            }
        }
        this.url = url;
    }

    @Override
    public String toString() {
        return "'" + createDate + "'" +
                ", '" + classfy + '\'' +
                ", '" + url + '\'' +
                ", '" + entryPage + '\'' +
                ", " + visits +
                "," + pv;


    }

}
