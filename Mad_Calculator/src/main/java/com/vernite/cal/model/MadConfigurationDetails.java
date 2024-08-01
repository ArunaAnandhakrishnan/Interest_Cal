package com.vernite.cal.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "MAD_CONFIGURATION_DETAILS")
public class MadConfigurationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<Long> serno;
    private Boolean overLimitAmount;
    private Boolean overDueAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

