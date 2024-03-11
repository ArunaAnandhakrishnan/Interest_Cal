package com.vernite.cal.dto;

import java.util.Date;

public class StatementResponse {

	private Long totaldebits;
	private Long totalcredits;
	private Long overdueamount;
	private Date printduedate;
	private Date duedate;
	private Long mindueamount;
	private Long closingbalance;
	private Long openingbalance;
	private Long overduecycles;

	public Long getOverduecycles() {
		return overduecycles;
	}

	public void setOverduecycles(Long overduecycles) {
		this.overduecycles = overduecycles;
	}

	public Long getTotaldebits() {
		return totaldebits;
	}

	public Long getTotalcredits() {
		return totalcredits;
	}

	public Long getOverdueamount() {
		return overdueamount;
	}

	public Date getPrintduedate() {
		return printduedate;
	}

	public Date getDuedate() {
		return duedate;
	}

	public Long getMindueamount() {
		return mindueamount;
	}

	public Long getClosingbalance() {
		return closingbalance;
	}

	public void setTotaldebits(Long totaldebits) {
		this.totaldebits = totaldebits;
	}

	public void setTotalcredits(Long totalcredits) {
		this.totalcredits = totalcredits;
	}

	public void setOverdueamount(Long overdueamount) {
		this.overdueamount = overdueamount;
	}

	public void setPrintduedate(Date printduedate) {
		this.printduedate = printduedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public void setMindueamount(Long mindueamount) {
		this.mindueamount = mindueamount;
	}

	public void setClosingbalance(Long closingbalance) {
		this.closingbalance = closingbalance;
	}

	public Long getOpeningbalance() {
		return openingbalance;
	}

	public void setOpeningbalance(Long openingbalance) {
		this.openingbalance = openingbalance;
	}

}
