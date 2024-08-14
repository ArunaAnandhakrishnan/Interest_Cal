package com.vernite.cal.dto;

import java.util.Date;

public class StmtSettings {

	private Long institution_id;
	private Long serno;
	// private Long profserno;
	private Long minpayamount;
	private Long minpaypercentage;
	private Date minpaycombination;
	private Date dateinc;
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

	public Long getSerno() {
		return serno;
	}

	public Long getMinpaypercentage() {
		return minpaypercentage;
	}

	public void setSerno(Long serno) {
		this.serno = serno;
	}

	public void setMinpaypercentage(Long minpaypercentage) {
		this.minpaypercentage = minpaypercentage;
	}

}
