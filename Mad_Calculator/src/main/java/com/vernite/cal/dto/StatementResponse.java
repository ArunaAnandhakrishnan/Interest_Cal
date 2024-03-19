package com.vernite.cal.dto;

import java.math.BigDecimal;
import java.util.Date;

public class StatementResponse {

	private Double totaldebits;
	private Double totalcredits;
	private Double overdueamount;

	private String printduedate;
	private String duedate;
	private Double mindueamount;
	private Double tad;
	private Double openingbalance;
	private Long overduecycles;
	private BigDecimal mad;

	public Double getTotaldebits() {
		return totaldebits;
	}

	public void setTotaldebits(Double totaldebits) {
		this.totaldebits = totaldebits;
	}

	public Double getTotalcredits() {
		return totalcredits;
	}

	public void setTotalcredits(Double totalcredits) {
		this.totalcredits = totalcredits;
	}

	public Double getOverdueamount() {
		return overdueamount;
	}

	public void setOverdueamount(Double overdueamount) {
		this.overdueamount = overdueamount;
	}

	public String getPrintduedate() {
		return printduedate;
	}

	public void setPrintduedate(String printduedate) {
		this.printduedate = printduedate;
	}

	public String getDuedate() {
		return duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	public Double getMindueamount() {
		return mindueamount;
	}

	public void setMindueamount(Double mindueamount) {
		this.mindueamount = mindueamount;
	}

	public Double getTad() {
		return tad;
	}

	public void setTad(Double tad) {
		this.tad = tad;
	}

	public Double getOpeningbalance() {
		return openingbalance;
	}

	public void setOpeningbalance(Double openingbalance) {
		this.openingbalance = openingbalance;
	}

	public Long getOverduecycles() {
		return overduecycles;
	}

	public void setOverduecycles(Long overduecycles) {
		this.overduecycles = overduecycles;
	}

	public BigDecimal getMad() {
		return mad;
	}

	public void setMad(BigDecimal mad) {
		this.mad = mad;
	}
}
