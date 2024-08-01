package com.vernite.cal.dto;


import java.util.List;

public class ConfigurationDto {
    private List<Long> serno;
    private Boolean overLimitAmount;
    private Boolean overDueAmount;

    public List<Long> getSerno() {
        return serno;
    }

    public void setSerno(List<Long> serno) {
        this.serno = serno;
    }

    public Boolean getOverLimitAmount() {
        return overLimitAmount;
    }

    public void setOverLimitAmount(Boolean overLimitAmount) {
        this.overLimitAmount = overLimitAmount;
    }

    public Boolean getOverDueAmount() {
        return overDueAmount;
    }

    public void setOverDueAmount(Boolean overDueAmount) {
        this.overDueAmount = overDueAmount;
    }
}
