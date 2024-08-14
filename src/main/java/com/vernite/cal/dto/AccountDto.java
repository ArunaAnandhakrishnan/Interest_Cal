package com.vernite.cal.dto;

import java.util.Date;

import oracle.sql.TIMESTAMP;

public class AccountDto {

	private Long institution_id;

	private Long custserno;
	private String numberx;
	private Long primarycardserno;
	private Long riskdomainserno;
	private String accounttype;
	private String billingmethod;
	private Long dailyaccrualflag;
	private Long product;
	private Long currency;
	private Long creditlimit;
	private Long balance;
	private Long openingminamount;
	private Long minamount;
	private Long minamountwaived;
	private Date minamtduedate;
	private Date minamtprintduedate;
	private Long overdueamount;
	private Date overduedate;
	private Long overduecycles;
	private Date currentoverduedate;
	private Long currentoverdueage;
	private Date cureoverduedate;
	private Date cureoverduelastupddate;
	private Date lastminamountwaiveddate;
	private Date stopdailyaccrualrepdate;
	private Long paymentindicator;
	private Long allocprofserno;
	private Long feeprofserno;
	private Long trxnfeeprofserno;
	private Long instprofserno;
	private Long rewardprofserno;
	private Long caprofserno;
	private Long servicefeeoverridesexist;
	private Long trxnfeeoverridesexist;
	private String stgeneral;
	private String stfinancial;
	private String stauthorization;
	private String prechangerequeststgeneral;
	private Long inactive;
	private Long nextstmtserno;
	private Long nextstmtpartitionkey;
	private Long totalpoints;
	private Long totalpointtrxns;
	private Long totalcredits;
	private Long totaldebits;
	private Long thisperioddue;
	private Long returnedpayments;
	private Long backdatedcredits;
	private Long backdateddebits;
	private Long backdatedpayments;
	private Long backdatedreturnedpayments;
	private Date lastbillingdate;
	private String lastbillingreason;
	private Date lasttrxnpostdate;
	private Date lastactivitytrxnpostdate;
	private Date lastallocationdate;
	private Long lastpaymentserno;
	private Long lastpaymentpartitionkey;
	private Long lastbalupdeodserno;
	private Long prevbalupdeodserno;
	private Long lastmtpupdeodserno;
	private Long prevmtpupdeodserno;
	private Long instalmentcount;
	private Long instalmentbalance;
	private Long instalmentbalanceprincipal;
	private Long issinstbalance;
	private Long acqinstbalance;
	private Long cashbalance;
	private Long paidinfullbalance;
	private Date createdate;
	private Long chargeoffamount;
	private Date chargeoffdate;
	private Date closedate;
	private Long excesspaymentamount;
	private Long latepaymentfee;
	private Long latepaymentfeetrxnserno;
	private Long latepaymentfeetrxnpartitionkey;
	private Long activitysincelaststatement;
	private String transactorhistory;
	private Long statementinstalmentsallowed;
	private Long statementinstalmentsmaxnum;
	private Long statementinstalmentsactivenum;
	private Long autoredeemcyclestoskip;
	private Long collectorcase;
	private Long dormantacctypeserno;
	private Long repaymentplanserno;
	private Long repaymentplanpartitionkey;
	private Long mbhagreementserno;
	private TIMESTAMP mbhagreementexpirydate;
	private Long realflag;
	private String excludefromprobe;
	private String languagecode;
	private String logaction;
	private Long entityversionno;
	private Long converted;

	public String getNumberx() {
		return numberx;
	}

	public Long getCreditlimit() {
		return creditlimit;
	}

	public Long getBalance() {
		return balance;
	}

	public String getStgeneral() {
		return stgeneral;
	}

	public String getTransactorhistory() {
		return transactorhistory;
	}

	public void setNumberx(String numberx) {
		this.numberx = numberx;
	}

	public void setCreditlimit(Long creditlimit) {
		this.creditlimit = creditlimit;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public void setStgeneral(String stgeneral) {
		this.stgeneral = stgeneral;
	}

	public void setTransactorhistory(String transactorhistory) {
		this.transactorhistory = transactorhistory;
	}

}