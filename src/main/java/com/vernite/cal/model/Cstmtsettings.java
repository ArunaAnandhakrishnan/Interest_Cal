package com.vernite.cal.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cstmtsettings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer serno;

	@ManyToOne
	@JoinColumn(name = "profserno", nullable = false)
	private Profiles profiles;

	// private Integer profserno;

	private Long institution_id;
	// serno NUMBER(10) not null,
	// private Long profserno;
	private Long minpayamount;
	private Long minpaypercentage;
	private Long minpaycombination;
	private Long dateinc;
	private Long triggerbal;
	private Long mindbbal;
	private Long mincrbal;
	private Long minactivity;
	private String basedateind;
	private Long graceperiod;
	private Long graceperiodrevolver;
	private Long graceperiodtransactor;
	private Long cutoffgraceperiod;
	private Long logversion;

	public Integer getSerno() {
		return serno;
	}

	public Profiles getProfiles() {
		return profiles;
	}

	public Long getMinpaypercentage() {
		return minpaypercentage;
	}

	public void setSerno(Integer serno) {
		this.serno = serno;
	}

	public void setProfiles(Profiles profiles) {
		this.profiles = profiles;
	}

	public void setMinpaypercentage(Long minpaypercentage) {
		this.minpaypercentage = minpaypercentage;
	}

}
