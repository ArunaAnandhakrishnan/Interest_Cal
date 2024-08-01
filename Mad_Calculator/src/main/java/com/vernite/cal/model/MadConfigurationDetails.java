package com.vernite.cal.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class MadConfigurationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<Long> serno;
    private Boolean overLimit;

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

    public Boolean getOverLimit() {
        return overLimit;
    }

    public void setOverLimit(Boolean overLimit) {
        this.overLimit = overLimit;
    }
}

