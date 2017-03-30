package com.udbac.csvparser.entity;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by 43890 on 2016/9/19.
 */
@Component
public class TbAmpBackendBaseDaily {
    private String createDate;
    private String mic;
    private Integer visits;
    private Integer visitor;
    private Integer pv;
    private Integer click;
    private Integer bounceVisit;
    private String viewTime;

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

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public Integer getVisitor() {
        return visitor;
    }

    public void setVisitor(Integer visitor) {
        this.visitor = visitor;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public Integer getBounceVisit() {
        return bounceVisit;
    }

    public void setBounceVisit(Integer bounceVisit) {
        this.bounceVisit = bounceVisit;
    }

    public String getViewTime() {
        return viewTime;
    }

    public void setViewTime(String viewTime) {
        this.viewTime = viewTime;
    }

    @Override
    public String toString() {
        return
                "'" + createDate + "'" +
                        ", '" + mic + '\'' +
                        "," + visits +
                        "," + visitor +
                        ", " + pv +
                        "," + click +
                        ", " + bounceVisit +
                        ", " + viewTime;
    }
}

