package com.vernite.cal.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionDetailsDto {

	private Date i013_trxn_date;
	private String i048_text_data;
	private BigDecimal i004_amt_trxn;
	private BigDecimal i006_amt_bill;

	private BigDecimal outstandingamount;
	private Long minpaypercentage;

	private String rectype;

	public Date getI013_trxn_date() {
		return i013_trxn_date;
	}

	public String getI048_text_data() {
		return i048_text_data;
	}

	

	public BigDecimal getI004_amt_trxn() {
		return i004_amt_trxn;
	}

	public void setI004_amt_trxn(BigDecimal i004_amt_trxn) {
		this.i004_amt_trxn = i004_amt_trxn;
	}

	public BigDecimal getI006_amt_bill() {
		return i006_amt_bill;
	}

	public BigDecimal getOutstandingamount() {
		return outstandingamount;
	}

	public Long getMinpaypercentage() {
		return minpaypercentage;
	}

	public String getRectype() {
		return rectype;
	}

	public void setI013_trxn_date(Date i013_trxn_date) {
		this.i013_trxn_date = i013_trxn_date;
	}

	public void setI048_text_data(String i048_text_data) {
		this.i048_text_data = i048_text_data;
	}

	
	public void setI006_amt_bill(BigDecimal i006_amt_bill) {
		this.i006_amt_bill = i006_amt_bill;
	}

	public void setOutstandingamount(BigDecimal outstandingamount) {
		this.outstandingamount = outstandingamount;
	}

	public void setMinpaypercentage(Long minpaypercentage) {
		this.minpaypercentage = minpaypercentage;
	}

	public void setRectype(String rectype) {
		this.rectype = rectype;
	}

}
