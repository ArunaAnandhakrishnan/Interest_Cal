package com.vernite.cal.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionDetailsDto {

	private Date transactionDate;
	private String description;
	private String recType;
	private BigDecimal transactionAmount;
	private BigDecimal billingAmount;
	private BigDecimal outstandingamount;
	private Long minpaypercentage;


	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRecType() {
		return recType;
	}

	public void setRecType(String recType) {
		this.recType = recType;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public BigDecimal getBillingAmount() {
		return billingAmount;
	}

	public void setBillingAmount(BigDecimal billingAmount) {
		this.billingAmount = billingAmount;
	}

	public BigDecimal getOutstandingamount() {
		return outstandingamount;
	}

	public void setOutstandingamount(BigDecimal outstandingamount) {
		this.outstandingamount = outstandingamount;
	}

	public Long getMinpaypercentage() {
		return minpaypercentage;
	}

	public void setMinpaypercentage(Long minpaypercentage) {
		this.minpaypercentage = minpaypercentage;
	}
}
