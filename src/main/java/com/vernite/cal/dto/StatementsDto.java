package com.vernite.cal.dto;

import java.util.Date;

public class StatementsDto {

	private Long institution_id;
	// serno NUMBER(10) not null,
	private Long partitionkey;
//	private Long caccserno;
	private Long batchserno;
	private Date cycledate;
	private Date prevbillingdate;
	private Date billingdate;
	private String generatedatetime;
	private Date lastprintdate;
	private Long printcount;
	private Long closingbalance;
	private Long openingbalance;
	private Long averagedailybalance;
	private Long paidinfullbalance;
	private Long mindueamount;
	private Long overdueamount;
	private Long wishtopay;
	private Long mindueamountwaived;
	private Long cycleactivity;
	private Long totalcredits;
	private Long totaldebits;
	private Long totalpayments;
	private Long totalcreditsbyduedate;
	private Long totalinterest;
	private Long excessinterest;
	private Long pendinginterest;
	private Long returnedpayments;
	private Long backdatedcredits;
	private Long backdateddebits;
	private Long backdatedpayments;
	private Long backdatedreturnedpayments;
	private Long excesspaymentamount;
	private Long latepaymentfee;
	private Long instalmentclosingbalance;
	private Long instalmentclosingbalprincipal;
	private Long instalmentopeningbalance;
	private Long creditlimit;
	private Long overduecycles;
	private Long overdueage;
	private Long paymentindicator;
	private Long currency;
	private Date duedate;
	private Date printduedate;
	private Date overduedate;
	private Date currentoverduedate;
	private Date cureoverduedate;
	private String stgeneral;
	private Long collectorcase;
	private Long coltypeserno;
	private Long repaymentplanserno;
	private Long repaymentplanpartitionkey;
	private Long repaymentplancycle;
	private Long mbhagreementserno;
	private Date mbhagreementexpirydate;
	private Long aprbalance;
	private Long aprpastdue;
	private Long aprcash;
	private Long aprinstalments;
	private Long numofmonthstopayoffwithminamt;
	private Long pmntamttopayoffin12months;
	private String reason;
	private Long sequence;
	private Long cycledays;
	private Long pushcounter;
	private Date pushedbillingdate;
	private Date pushedprintduedate;
	private Long prevstmtserno;
	private Long prevstmtpartitionkey;
	private Long recalcallowed;
	private Long recalcmindueamount;
	private Long recalcoverdueamount;
	private Long recalccycleactivity;
	private Long recalcoverduecycles;
	private Long recalcoverdueage;
	private Date recalcoverduedate;
	private Date recalccurrentoverduedate;
	private Long recalcpaymentindicator;
	private Long recalcclosingbalance;
	private Long recalcaveragedailybalance;
	private Long recalcpaidinfullbalance;
	private Long recalctotalcredits;
	private Long recalctotalpayments;
	private Long recalctotalcreditsbyduedate;
	private Long recalctotalinterest;
	private Long recalcexcessinterest;
	private Long recalcexcesspaymentamount;
	private Date recalccureoverduedate;
	private Long converted;

	public Long getInstitution_id() {
		return institution_id;
	}

	public Long getPartitionkey() {
		return partitionkey;
	}

	public Long getBatchserno() {
		return batchserno;
	}

	public Date getCycledate() {
		return cycledate;
	}

	public Date getPrevbillingdate() {
		return prevbillingdate;
	}

	public Date getBillingdate() {
		return billingdate;
	}

	public String getGeneratedatetime() {
		return generatedatetime;
	}

	public Date getLastprintdate() {
		return lastprintdate;
	}

	public Long getPrintcount() {
		return printcount;
	}

	public Long getClosingbalance() {
		return closingbalance;
	}

	public Long getOpeningbalance() {
		return openingbalance;
	}

	public Long getAveragedailybalance() {
		return averagedailybalance;
	}

	public Long getPaidinfullbalance() {
		return paidinfullbalance;
	}

	public Long getMindueamount() {
		return mindueamount;
	}

	public Long getOverdueamount() {
		return overdueamount;
	}

	public Long getWishtopay() {
		return wishtopay;
	}

	public Long getMindueamountwaived() {
		return mindueamountwaived;
	}

	public Long getCycleactivity() {
		return cycleactivity;
	}

	public Long getTotalcredits() {
		return totalcredits;
	}

	public Long getTotaldebits() {
		return totaldebits;
	}

	public Long getTotalpayments() {
		return totalpayments;
	}

	public Long getTotalcreditsbyduedate() {
		return totalcreditsbyduedate;
	}

	public Long getTotalinterest() {
		return totalinterest;
	}

	public Long getExcessinterest() {
		return excessinterest;
	}

	public Long getPendinginterest() {
		return pendinginterest;
	}

	public Long getReturnedpayments() {
		return returnedpayments;
	}

	public Long getBackdatedcredits() {
		return backdatedcredits;
	}

	public Long getBackdateddebits() {
		return backdateddebits;
	}

	public Long getBackdatedpayments() {
		return backdatedpayments;
	}

	public Long getBackdatedreturnedpayments() {
		return backdatedreturnedpayments;
	}

	public Long getExcesspaymentamount() {
		return excesspaymentamount;
	}

	public Long getLatepaymentfee() {
		return latepaymentfee;
	}

	public Long getInstalmentclosingbalance() {
		return instalmentclosingbalance;
	}

	public Long getInstalmentclosingbalprincipal() {
		return instalmentclosingbalprincipal;
	}

	public Long getInstalmentopeningbalance() {
		return instalmentopeningbalance;
	}

	public Long getCreditlimit() {
		return creditlimit;
	}

	public Long getOverduecycles() {
		return overduecycles;
	}

	public Long getOverdueage() {
		return overdueage;
	}

	public Long getPaymentindicator() {
		return paymentindicator;
	}

	public Long getCurrency() {
		return currency;
	}

	public Date getDuedate() {
		return duedate;
	}

	public Date getPrintduedate() {
		return printduedate;
	}

	public Date getOverduedate() {
		return overduedate;
	}

	public Date getCurrentoverduedate() {
		return currentoverduedate;
	}

	public Date getCureoverduedate() {
		return cureoverduedate;
	}

	public String getStgeneral() {
		return stgeneral;
	}

	public Long getCollectorcase() {
		return collectorcase;
	}

	public Long getColtypeserno() {
		return coltypeserno;
	}

	public Long getRepaymentplanserno() {
		return repaymentplanserno;
	}

	public Long getRepaymentplanpartitionkey() {
		return repaymentplanpartitionkey;
	}

	public Long getRepaymentplancycle() {
		return repaymentplancycle;
	}

	public Long getMbhagreementserno() {
		return mbhagreementserno;
	}

	public Date getMbhagreementexpirydate() {
		return mbhagreementexpirydate;
	}

	public Long getAprbalance() {
		return aprbalance;
	}

	public Long getAprpastdue() {
		return aprpastdue;
	}

	public Long getAprcash() {
		return aprcash;
	}

	public Long getAprinstalments() {
		return aprinstalments;
	}

	public Long getNumofmonthstopayoffwithminamt() {
		return numofmonthstopayoffwithminamt;
	}

	public Long getPmntamttopayoffin12months() {
		return pmntamttopayoffin12months;
	}

	public String getReason() {
		return reason;
	}

	public Long getSequence() {
		return sequence;
	}

	public Long getCycledays() {
		return cycledays;
	}

	public Long getPushcounter() {
		return pushcounter;
	}

	public Date getPushedbillingdate() {
		return pushedbillingdate;
	}

	public Date getPushedprintduedate() {
		return pushedprintduedate;
	}

	public Long getPrevstmtserno() {
		return prevstmtserno;
	}

	public Long getPrevstmtpartitionkey() {
		return prevstmtpartitionkey;
	}

	public Long getRecalcallowed() {
		return recalcallowed;
	}

	public Long getRecalcmindueamount() {
		return recalcmindueamount;
	}

	public Long getRecalcoverdueamount() {
		return recalcoverdueamount;
	}

	public Long getRecalccycleactivity() {
		return recalccycleactivity;
	}

	public Long getRecalcoverduecycles() {
		return recalcoverduecycles;
	}

	public Long getRecalcoverdueage() {
		return recalcoverdueage;
	}

	public Date getRecalcoverduedate() {
		return recalcoverduedate;
	}

	public Date getRecalccurrentoverduedate() {
		return recalccurrentoverduedate;
	}

	public Long getRecalcpaymentindicator() {
		return recalcpaymentindicator;
	}

	public Long getRecalcclosingbalance() {
		return recalcclosingbalance;
	}

	public Long getRecalcaveragedailybalance() {
		return recalcaveragedailybalance;
	}

	public Long getRecalcpaidinfullbalance() {
		return recalcpaidinfullbalance;
	}

	public Long getRecalctotalcredits() {
		return recalctotalcredits;
	}

	public Long getRecalctotalpayments() {
		return recalctotalpayments;
	}

	public Long getRecalctotalcreditsbyduedate() {
		return recalctotalcreditsbyduedate;
	}

	public Long getRecalctotalinterest() {
		return recalctotalinterest;
	}

	public Long getRecalcexcessinterest() {
		return recalcexcessinterest;
	}

	public Long getRecalcexcesspaymentamount() {
		return recalcexcesspaymentamount;
	}

	public Date getRecalccureoverduedate() {
		return recalccureoverduedate;
	}

	public Long getConverted() {
		return converted;
	}

	public void setInstitution_id(Long institution_id) {
		this.institution_id = institution_id;
	}

	public void setPartitionkey(Long partitionkey) {
		this.partitionkey = partitionkey;
	}

	public void setBatchserno(Long batchserno) {
		this.batchserno = batchserno;
	}

	public void setCycledate(Date cycledate) {
		this.cycledate = cycledate;
	}

	public void setPrevbillingdate(Date prevbillingdate) {
		this.prevbillingdate = prevbillingdate;
	}

	public void setBillingdate(Date billingdate) {
		this.billingdate = billingdate;
	}

	public void setGeneratedatetime(String generatedatetime) {
		this.generatedatetime = generatedatetime;
	}

	public void setLastprintdate(Date lastprintdate) {
		this.lastprintdate = lastprintdate;
	}

	public void setPrintcount(Long printcount) {
		this.printcount = printcount;
	}

	public void setClosingbalance(Long closingbalance) {
		this.closingbalance = closingbalance;
	}

	public void setOpeningbalance(Long openingbalance) {
		this.openingbalance = openingbalance;
	}

	public void setAveragedailybalance(Long averagedailybalance) {
		this.averagedailybalance = averagedailybalance;
	}

	public void setPaidinfullbalance(Long paidinfullbalance) {
		this.paidinfullbalance = paidinfullbalance;
	}

	public void setMindueamount(Long mindueamount) {
		this.mindueamount = mindueamount;
	}

	public void setOverdueamount(Long overdueamount) {
		this.overdueamount = overdueamount;
	}

	public void setWishtopay(Long wishtopay) {
		this.wishtopay = wishtopay;
	}

	public void setMindueamountwaived(Long mindueamountwaived) {
		this.mindueamountwaived = mindueamountwaived;
	}

	public void setCycleactivity(Long cycleactivity) {
		this.cycleactivity = cycleactivity;
	}

	public void setTotalcredits(Long totalcredits) {
		this.totalcredits = totalcredits;
	}

	public void setTotaldebits(Long totaldebits) {
		this.totaldebits = totaldebits;
	}

	public void setTotalpayments(Long totalpayments) {
		this.totalpayments = totalpayments;
	}

	public void setTotalcreditsbyduedate(Long totalcreditsbyduedate) {
		this.totalcreditsbyduedate = totalcreditsbyduedate;
	}

	public void setTotalinterest(Long totalinterest) {
		this.totalinterest = totalinterest;
	}

	public void setExcessinterest(Long excessinterest) {
		this.excessinterest = excessinterest;
	}

	public void setPendinginterest(Long pendinginterest) {
		this.pendinginterest = pendinginterest;
	}

	public void setReturnedpayments(Long returnedpayments) {
		this.returnedpayments = returnedpayments;
	}

	public void setBackdatedcredits(Long backdatedcredits) {
		this.backdatedcredits = backdatedcredits;
	}

	public void setBackdateddebits(Long backdateddebits) {
		this.backdateddebits = backdateddebits;
	}

	public void setBackdatedpayments(Long backdatedpayments) {
		this.backdatedpayments = backdatedpayments;
	}

	public void setBackdatedreturnedpayments(Long backdatedreturnedpayments) {
		this.backdatedreturnedpayments = backdatedreturnedpayments;
	}

	public void setExcesspaymentamount(Long excesspaymentamount) {
		this.excesspaymentamount = excesspaymentamount;
	}

	public void setLatepaymentfee(Long latepaymentfee) {
		this.latepaymentfee = latepaymentfee;
	}

	public void setInstalmentclosingbalance(Long instalmentclosingbalance) {
		this.instalmentclosingbalance = instalmentclosingbalance;
	}

	public void setInstalmentclosingbalprincipal(Long instalmentclosingbalprincipal) {
		this.instalmentclosingbalprincipal = instalmentclosingbalprincipal;
	}

	public void setInstalmentopeningbalance(Long instalmentopeningbalance) {
		this.instalmentopeningbalance = instalmentopeningbalance;
	}

	public void setCreditlimit(Long creditlimit) {
		this.creditlimit = creditlimit;
	}

	public void setOverduecycles(Long overduecycles) {
		this.overduecycles = overduecycles;
	}

	public void setOverdueage(Long overdueage) {
		this.overdueage = overdueage;
	}

	public void setPaymentindicator(Long paymentindicator) {
		this.paymentindicator = paymentindicator;
	}

	public void setCurrency(Long currency) {
		this.currency = currency;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public void setPrintduedate(Date printduedate) {
		this.printduedate = printduedate;
	}

	public void setOverduedate(Date overduedate) {
		this.overduedate = overduedate;
	}

	public void setCurrentoverduedate(Date currentoverduedate) {
		this.currentoverduedate = currentoverduedate;
	}

	public void setCureoverduedate(Date cureoverduedate) {
		this.cureoverduedate = cureoverduedate;
	}

	public void setStgeneral(String stgeneral) {
		this.stgeneral = stgeneral;
	}

	public void setCollectorcase(Long collectorcase) {
		this.collectorcase = collectorcase;
	}

	public void setColtypeserno(Long coltypeserno) {
		this.coltypeserno = coltypeserno;
	}

	public void setRepaymentplanserno(Long repaymentplanserno) {
		this.repaymentplanserno = repaymentplanserno;
	}

	public void setRepaymentplanpartitionkey(Long repaymentplanpartitionkey) {
		this.repaymentplanpartitionkey = repaymentplanpartitionkey;
	}

	public void setRepaymentplancycle(Long repaymentplancycle) {
		this.repaymentplancycle = repaymentplancycle;
	}

	public void setMbhagreementserno(Long mbhagreementserno) {
		this.mbhagreementserno = mbhagreementserno;
	}

	public void setMbhagreementexpirydate(Date mbhagreementexpirydate) {
		this.mbhagreementexpirydate = mbhagreementexpirydate;
	}

	public void setAprbalance(Long aprbalance) {
		this.aprbalance = aprbalance;
	}

	public void setAprpastdue(Long aprpastdue) {
		this.aprpastdue = aprpastdue;
	}

	public void setAprcash(Long aprcash) {
		this.aprcash = aprcash;
	}

	public void setAprinstalments(Long aprinstalments) {
		this.aprinstalments = aprinstalments;
	}

	public void setNumofmonthstopayoffwithminamt(Long numofmonthstopayoffwithminamt) {
		this.numofmonthstopayoffwithminamt = numofmonthstopayoffwithminamt;
	}

	public void setPmntamttopayoffin12months(Long pmntamttopayoffin12months) {
		this.pmntamttopayoffin12months = pmntamttopayoffin12months;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	public void setCycledays(Long cycledays) {
		this.cycledays = cycledays;
	}

	public void setPushcounter(Long pushcounter) {
		this.pushcounter = pushcounter;
	}

	public void setPushedbillingdate(Date pushedbillingdate) {
		this.pushedbillingdate = pushedbillingdate;
	}

	public void setPushedprintduedate(Date pushedprintduedate) {
		this.pushedprintduedate = pushedprintduedate;
	}

	public void setPrevstmtserno(Long prevstmtserno) {
		this.prevstmtserno = prevstmtserno;
	}

	public void setPrevstmtpartitionkey(Long prevstmtpartitionkey) {
		this.prevstmtpartitionkey = prevstmtpartitionkey;
	}

	public void setRecalcallowed(Long recalcallowed) {
		this.recalcallowed = recalcallowed;
	}

	public void setRecalcmindueamount(Long recalcmindueamount) {
		this.recalcmindueamount = recalcmindueamount;
	}

	public void setRecalcoverdueamount(Long recalcoverdueamount) {
		this.recalcoverdueamount = recalcoverdueamount;
	}

	public void setRecalccycleactivity(Long recalccycleactivity) {
		this.recalccycleactivity = recalccycleactivity;
	}

	public void setRecalcoverduecycles(Long recalcoverduecycles) {
		this.recalcoverduecycles = recalcoverduecycles;
	}

	public void setRecalcoverdueage(Long recalcoverdueage) {
		this.recalcoverdueage = recalcoverdueage;
	}

	public void setRecalcoverduedate(Date recalcoverduedate) {
		this.recalcoverduedate = recalcoverduedate;
	}

	public void setRecalccurrentoverduedate(Date recalccurrentoverduedate) {
		this.recalccurrentoverduedate = recalccurrentoverduedate;
	}

	public void setRecalcpaymentindicator(Long recalcpaymentindicator) {
		this.recalcpaymentindicator = recalcpaymentindicator;
	}

	public void setRecalcclosingbalance(Long recalcclosingbalance) {
		this.recalcclosingbalance = recalcclosingbalance;
	}

	public void setRecalcaveragedailybalance(Long recalcaveragedailybalance) {
		this.recalcaveragedailybalance = recalcaveragedailybalance;
	}

	public void setRecalcpaidinfullbalance(Long recalcpaidinfullbalance) {
		this.recalcpaidinfullbalance = recalcpaidinfullbalance;
	}

	public void setRecalctotalcredits(Long recalctotalcredits) {
		this.recalctotalcredits = recalctotalcredits;
	}

	public void setRecalctotalpayments(Long recalctotalpayments) {
		this.recalctotalpayments = recalctotalpayments;
	}

	public void setRecalctotalcreditsbyduedate(Long recalctotalcreditsbyduedate) {
		this.recalctotalcreditsbyduedate = recalctotalcreditsbyduedate;
	}

	public void setRecalctotalinterest(Long recalctotalinterest) {
		this.recalctotalinterest = recalctotalinterest;
	}

	public void setRecalcexcessinterest(Long recalcexcessinterest) {
		this.recalcexcessinterest = recalcexcessinterest;
	}

	public void setRecalcexcesspaymentamount(Long recalcexcesspaymentamount) {
		this.recalcexcesspaymentamount = recalcexcesspaymentamount;
	}

	public void setRecalccureoverduedate(Date recalccureoverduedate) {
		this.recalccureoverduedate = recalccureoverduedate;
	}

	public void setConverted(Long converted) {
		this.converted = converted;
	}

}
