package com.vernite.cal.dto;


import java.util.List;

public class ConfigurationDto {
    private List<Long> serno;
    private Boolean overLimit;

    public List<Long> getSerno() {
        return serno;
    }

    public void setSerno(List<Long> serno) {
        this.serno = serno;
    }

    public Boolean getOverLimit() {
        return overLimit;
    }

    public void setOverLimit(Boolean overLimit) {
        this.overLimit = overLimit;
    }
}
