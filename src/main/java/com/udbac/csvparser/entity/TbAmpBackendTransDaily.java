package com.udbac.csvparser.entity;

import org.springframework.jca.cci.core.InteractionCallback;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import sun.rmi.server.InactiveGroupException;

@Component
public class TbAmpBackendTransDaily {
    private String createDate;
    private String mic;
    private Integer behaviorVV;
    private Integer transactionVV;
    private Integer phonBuyVV;
    private Integer setMealVV;
    private Integer partsVV;

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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getBehaviorVV() {
        return behaviorVV;
    }

    public void setBehaviorVV(Integer behaviorVV) {
        this.behaviorVV = behaviorVV;
    }

    public Integer getTransactionVV() {
        return transactionVV;
    }

    public void setTransactionVV(Integer transactionVV) {
        this.transactionVV = transactionVV;
    }

    public Integer getPhonBuyVV() {
        return phonBuyVV;
    }

    public void setPhonBuyVV(Integer phonBuyVV) {
        this.phonBuyVV = phonBuyVV;
    }

    public Integer getSetMealVV() {
        return setMealVV;
    }

    public void setSetMealVV(Integer setMealVV) {
        this.setMealVV = setMealVV;
    }

    public Integer getPartsVV() {
        return partsVV;
    }

    public void setPartsVV(Integer partsVV) {
        this.partsVV = partsVV;
    }

    @Override
    public String toString() {
        return "'" + createDate + "'" +
                ", '" + mic + '\'' +
                ", " + behaviorVV +
                ", " + transactionVV +
                "," + phonBuyVV +
                ", " + setMealVV +
                ", " + partsVV;
    }

}
