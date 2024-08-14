package com.vernite.cal.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import oracle.sql.TIMESTAMP;

@Entity
public class Cstatements {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serno;

	@ManyToOne
	@JoinColumn(name = "caccserno", nullable = false)
	private Caccounts caccounts;
	@OneToMany(mappedBy = "cstatements", cascade = CascadeType.ALL)
	private List<Tbalances> tbalanceList;
	private Long institution_id;
	private Long partitionkey;
	private Long batchserno;
	private Date cycledate;
	private Date prevbillingdate;
	private Date billingdate;
	private String generatedatetime;
	private Timestamp lastprintdate;
	private Long printcount;
	private Double closingbalance;
	private Double openingbalance;
	private Long averagedailybalance;
	private Long paidinfullbalance;
	private Double mindueamount;
	private Double overdueamount;
	private Long wishtopay;
	private Long mindueamountwaived;
	private Long cycleactivity;
	private Double totalcredits;
	private Double totaldebits;
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
	private Double creditlimit;
	private Long overduecycles;
	private Long overdueage;
	private Long paymentindicator;
	private String currency;
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
	private Integer mbhagreementserno;
	private Timestamp mbhagreementexpirydate;
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
	private TIMESTAMP pushedbillingdate;
	private TIMESTAMP pushedprintduedate;
	private Long prevstmtserno;
	private Long prevstmtpartitionkey;
	private Long recalcallowed;
	private Long recalcmindueamount;
	private Long recalcoverdueamount;
	private Long recalccycleactivity;
	private Long recalcoverduecycles;
	private Long recalcoverdueage;
	private TIMESTAMP recalcoverduedate;
	private TIMESTAMP recalccurrentoverduedate;
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
	private TIMESTAMP recalccureoverduedate;
	private Long converted;

	public Long getSerno() {
		return serno;
	}

	public void setSerno(Long serno) {
		this.serno = serno;
	}

	public Caccounts getCaccounts() {
		return caccounts;
	}

	public void setCaccounts(Caccounts caccounts) {
		this.caccounts = caccounts;
	}

	public List<Tbalances> getTbalanceList() {
		return tbalanceList;
	}

	public void setTbalanceList(List<Tbalances> tbalanceList) {
		this.tbalanceList = tbalanceList;
	}

	public Long getInstitution_id() {
		return institution_id;
	}

	public void setInstitution_id(Long institution_id) {
		this.institution_id = institution_id;
	}

	public Long getPartitionkey() {
		return partitionkey;
	}

	public void setPartitionkey(Long partitionkey) {
		this.partitionkey = partitionkey;
	}

	public Long getBatchserno() {
		return batchserno;
	}

	public void setBatchserno(Long batchserno) {
		this.batchserno = batchserno;
	}

	public Date getCycledate() {
		return cycledate;
	}

	public void setCycledate(Date cycledate) {
		this.cycledate = cycledate;
	}

	public Date getPrevbillingdate() {
		return prevbillingdate;
	}

	public void setPrevbillingdate(Date prevbillingdate) {
		this.prevbillingdate = prevbillingdate;
	}

	public Date getBillingdate() {
		return billingdate;
	}

	public void setBillingdate(Date billingdate) {
		this.billingdate = billingdate;
	}

	public String getGeneratedatetime() {
		return generatedatetime;
	}

	public void setGeneratedatetime(String generatedatetime) {
		this.generatedatetime = generatedatetime;
	}

	public Timestamp getLastprintdate() {
		return lastprintdate;
	}

	public void setLastprintdate(Timestamp lastprintdate) {
		this.lastprintdate = lastprintdate;
	}

	public Long getPrintcount() {
		return printcount;
	}

	public void setPrintcount(Long printcount) {
		this.printcount = printcount;
	}

	public Double getClosingbalance() {
		return closingbalance;
	}

	public void setClosingbalance(Double closingbalance) {
		this.closingbalance = closingbalance;
	}

	public Double getOpeningbalance() {
		return openingbalance;
	}

	public void setOpeningbalance(Double openingbalance) {
		this.openingbalance = openingbalance;
	}

	public Long getAveragedailybalance() {
		return averagedailybalance;
	}

	public void setAveragedailybalance(Long averagedailybalance) {
		this.averagedailybalance = averagedailybalance;
	}

	public Long getPaidinfullbalance() {
		return paidinfullbalance;
	}

	public void setPaidinfullbalance(Long paidinfullbalance) {
		this.paidinfullbalance = paidinfullbalance;
	}

	public Double getMindueamount() {
		return mindueamount;
	}

	public void setMindueamount(Double mindueamount) {
		this.mindueamount = mindueamount;
	}

	public Double getOverdueamount() {
		return overdueamount;
	}

	public void setOverdueamount(Double overdueamount) {
		this.overdueamount = overdueamount;
	}

	public Long getWishtopay() {
		return wishtopay;
	}

	public void setWishtopay(Long wishtopay) {
		this.wishtopay = wishtopay;
	}

	public Long getMindueamountwaived() {
		return mindueamountwaived;
	}

	public void setMindueamountwaived(Long mindueamountwaived) {
		this.mindueamountwaived = mindueamountwaived;
	}

	public Long getCycleactivity() {
		return cycleactivity;
	}

	public void setCycleactivity(Long cycleactivity) {
		this.cycleactivity = cycleactivity;
	}

	public Double getTotalcredits() {
		return totalcredits;
	}

	public void setTotalcredits(Double totalcredits) {
		this.totalcredits = totalcredits;
	}

	public Double getTotaldebits() {
		return totaldebits;
	}

	public void setTotaldebits(Double totaldebits) {
		this.totaldebits = totaldebits;
	}

	public Long getTotalpayments() {
		return totalpayments;
	}

	public void setTotalpayments(Long totalpayments) {
		this.totalpayments = totalpayments;
	}

	public Long getTotalcreditsbyduedate() {
		return totalcreditsbyduedate;
	}

	public void setTotalcreditsbyduedate(Long totalcreditsbyduedate) {
		this.totalcreditsbyduedate = totalcreditsbyduedate;
	}

	public Long getTotalinterest() {
		return totalinterest;
	}

	public void setTotalinterest(Long totalinterest) {
		this.totalinterest = totalinterest;
	}

	public Long getExcessinterest() {
		return excessinterest;
	}

	public void setExcessinterest(Long excessinterest) {
		this.excessinterest = excessinterest;
	}

	public Long getPendinginterest() {
		return pendinginterest;
	}

	public void setPendinginterest(Long pendinginterest) {
		this.pendinginterest = pendinginterest;
	}

	public Long getReturnedpayments() {
		return returnedpayments;
	}

	public void setReturnedpayments(Long returnedpayments) {
		this.returnedpayments = returnedpayments;
	}

	public Long getBackdatedcredits() {
		return backdatedcredits;
	}

	public void setBackdatedcredits(Long backdatedcredits) {
		this.backdatedcredits = backdatedcredits;
	}

	public Long getBackdateddebits() {
		return backdateddebits;
	}

	public void setBackdateddebits(Long backdateddebits) {
		this.backdateddebits = backdateddebits;
	}

	public Long getBackdatedpayments() {
		return backdatedpayments;
	}

	public void setBackdatedpayments(Long backdatedpayments) {
		this.backdatedpayments = backdatedpayments;
	}

	public Long getBackdatedreturnedpayments() {
		return backdatedreturnedpayments;
	}

	public void setBackdatedreturnedpayments(Long backdatedreturnedpayments) {
		this.backdatedreturnedpayments = backdatedreturnedpayments;
	}

	public Long getExcesspaymentamount() {
		return excesspaymentamount;
	}

	public void setExcesspaymentamount(Long excesspaymentamount) {
		this.excesspaymentamount = excesspaymentamount;
	}

	public Long getLatepaymentfee() {
		return latepaymentfee;
	}

	public void setLatepaymentfee(Long latepaymentfee) {
		this.latepaymentfee = latepaymentfee;
	}

	public Long getInstalmentclosingbalance() {
		return instalmentclosingbalance;
	}

	public void setInstalmentclosingbalance(Long instalmentclosingbalance) {
		this.instalmentclosingbalance = instalmentclosingbalance;
	}

	public Long getInstalmentclosingbalprincipal() {
		return instalmentclosingbalprincipal;
	}

	public void setInstalmentclosingbalprincipal(Long instalmentclosingbalprincipal) {
		this.instalmentclosingbalprincipal = instalmentclosingbalprincipal;
	}

	public Long getInstalmentopeningbalance() {
		return instalmentopeningbalance;
	}

	public void setInstalmentopeningbalance(Long instalmentopeningbalance) {
		this.instalmentopeningbalance = instalmentopeningbalance;
	}

	public Double getCreditlimit() {
		return creditlimit;
	}

	public void setCreditlimit(Double creditlimit) {
		this.creditlimit = creditlimit;
	}

	public Long getOverduecycles() {
		return overduecycles;
	}

	public void setOverduecycles(Long overduecycles) {
		this.overduecycles = overduecycles;
	}

	public Long getOverdueage() {
		return overdueage;
	}

	public void setOverdueage(Long overdueage) {
		this.overdueage = overdueage;
	}

	public Long getPaymentindicator() {
		return paymentindicator;
	}

	public void setPaymentindicator(Long paymentindicator) {
		this.paymentindicator = paymentindicator;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public Date getPrintduedate() {
		return printduedate;
	}

	public void setPrintduedate(Date printduedate) {
		this.printduedate = printduedate;
	}

	public Date getOverduedate() {
		return overduedate;
	}

	public void setOverduedate(Date overduedate) {
		this.overduedate = overduedate;
	}

	public Date getCurrentoverduedate() {
		return currentoverduedate;
	}

	public void setCurrentoverduedate(Date currentoverduedate) {
		this.currentoverduedate = currentoverduedate;
	}

	public Date getCureoverduedate() {
		return cureoverduedate;
	}

	public void setCureoverduedate(Date cureoverduedate) {
		this.cureoverduedate = cureoverduedate;
	}

	public String getStgeneral() {
		return stgeneral;
	}

	public void setStgeneral(String stgeneral) {
		this.stgeneral = stgeneral;
	}

	public Long getCollectorcase() {
		return collectorcase;
	}

	public void setCollectorcase(Long collectorcase) {
		this.collectorcase = collectorcase;
	}

	public Long getColtypeserno() {
		return coltypeserno;
	}

	public void setColtypeserno(Long coltypeserno) {
		this.coltypeserno = coltypeserno;
	}

	public Long getRepaymentplanserno() {
		return repaymentplanserno;
	}

	public void setRepaymentplanserno(Long repaymentplanserno) {
		this.repaymentplanserno = repaymentplanserno;
	}

	public Long getRepaymentplanpartitionkey() {
		return repaymentplanpartitionkey;
	}

	public void setRepaymentplanpartitionkey(Long repaymentplanpartitionkey) {
		this.repaymentplanpartitionkey = repaymentplanpartitionkey;
	}

	public Long getRepaymentplancycle() {
		return repaymentplancycle;
	}

	public void setRepaymentplancycle(Long repaymentplancycle) {
		this.repaymentplancycle = repaymentplancycle;
	}

	public Integer getMbhagreementserno() {
		return mbhagreementserno;
	}

	public void setMbhagreementserno(Integer mbhagreementserno) {
		this.mbhagreementserno = mbhagreementserno;
	}

	public Timestamp getMbhagreementexpirydate() {
		return mbhagreementexpirydate;
	}

	public void setMbhagreementexpirydate(Timestamp mbhagreementexpirydate) {
		this.mbhagreementexpirydate = mbhagreementexpirydate;
	}

	public Long getAprbalance() {
		return aprbalance;
	}

	public void setAprbalance(Long aprbalance) {
		this.aprbalance = aprbalance;
	}

	public Long getAprpastdue() {
		return aprpastdue;
	}

	public void setAprpastdue(Long aprpastdue) {
		this.aprpastdue = aprpastdue;
	}

	public Long getAprcash() {
		return aprcash;
	}

	public void setAprcash(Long aprcash) {
		this.aprcash = aprcash;
	}

	public Long getAprinstalments() {
		return aprinstalments;
	}

	public void setAprinstalments(Long aprinstalments) {
		this.aprinstalments = aprinstalments;
	}

	public Long getNumofmonthstopayoffwithminamt() {
		return numofmonthstopayoffwithminamt;
	}

	public void setNumofmonthstopayoffwithminamt(Long numofmonthstopayoffwithminamt) {
		this.numofmonthstopayoffwithminamt = numofmonthstopayoffwithminamt;
	}

	public Long getPmntamttopayoffin12months() {
		return pmntamttopayoffin12months;
	}

	public void setPmntamttopayoffin12months(Long pmntamttopayoffin12months) {
		this.pmntamttopayoffin12months = pmntamttopayoffin12months;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	public Long getCycledays() {
		return cycledays;
	}

	public void setCycledays(Long cycledays) {
		this.cycledays = cycledays;
	}

	public Long getPushcounter() {
		return pushcounter;
	}

	public void setPushcounter(Long pushcounter) {
		this.pushcounter = pushcounter;
	}

	public TIMESTAMP getPushedbillingdate() {
		return pushedbillingdate;
	}

	public void setPushedbillingdate(TIMESTAMP pushedbillingdate) {
		this.pushedbillingdate = pushedbillingdate;
	}

	public TIMESTAMP getPushedprintduedate() {
		return pushedprintduedate;
	}

	public void setPushedprintduedate(TIMESTAMP pushedprintduedate) {
		this.pushedprintduedate = pushedprintduedate;
	}

	public Long getPrevstmtserno() {
		return prevstmtserno;
	}

	public void setPrevstmtserno(Long prevstmtserno) {
		this.prevstmtserno = prevstmtserno;
	}

	public Long getPrevstmtpartitionkey() {
		return prevstmtpartitionkey;
	}

	public void setPrevstmtpartitionkey(Long prevstmtpartitionkey) {
		this.prevstmtpartitionkey = prevstmtpartitionkey;
	}

	public Long getRecalcallowed() {
		return recalcallowed;
	}

	public void setRecalcallowed(Long recalcallowed) {
		this.recalcallowed = recalcallowed;
	}

	public Long getRecalcmindueamount() {
		return recalcmindueamount;
	}

	public void setRecalcmindueamount(Long recalcmindueamount) {
		this.recalcmindueamount = recalcmindueamount;
	}

	public Long getRecalcoverdueamount() {
		return recalcoverdueamount;
	}

	public void setRecalcoverdueamount(Long recalcoverdueamount) {
		this.recalcoverdueamount = recalcoverdueamount;
	}

	public Long getRecalccycleactivity() {
		return recalccycleactivity;
	}

	public void setRecalccycleactivity(Long recalccycleactivity) {
		this.recalccycleactivity = recalccycleactivity;
	}

	public Long getRecalcoverduecycles() {
		return recalcoverduecycles;
	}

	public void setRecalcoverduecycles(Long recalcoverduecycles) {
		this.recalcoverduecycles = recalcoverduecycles;
	}

	public Long getRecalcoverdueage() {
		return recalcoverdueage;
	}

	public void setRecalcoverdueage(Long recalcoverdueage) {
		this.recalcoverdueage = recalcoverdueage;
	}

	public TIMESTAMP getRecalcoverduedate() {
		return recalcoverduedate;
	}

	public void setRecalcoverduedate(TIMESTAMP recalcoverduedate) {
		this.recalcoverduedate = recalcoverduedate;
	}

	public TIMESTAMP getRecalccurrentoverduedate() {
		return recalccurrentoverduedate;
	}

	public void setRecalccurrentoverduedate(TIMESTAMP recalccurrentoverduedate) {
		this.recalccurrentoverduedate = recalccurrentoverduedate;
	}

	public Long getRecalcpaymentindicator() {
		return recalcpaymentindicator;
	}

	public void setRecalcpaymentindicator(Long recalcpaymentindicator) {
		this.recalcpaymentindicator = recalcpaymentindicator;
	}

	public Long getRecalcclosingbalance() {
		return recalcclosingbalance;
	}

	public void setRecalcclosingbalance(Long recalcclosingbalance) {
		this.recalcclosingbalance = recalcclosingbalance;
	}

	public Long getRecalcaveragedailybalance() {
		return recalcaveragedailybalance;
	}

	public void setRecalcaveragedailybalance(Long recalcaveragedailybalance) {
		this.recalcaveragedailybalance = recalcaveragedailybalance;
	}

	public Long getRecalcpaidinfullbalance() {
		return recalcpaidinfullbalance;
	}

	public void setRecalcpaidinfullbalance(Long recalcpaidinfullbalance) {
		this.recalcpaidinfullbalance = recalcpaidinfullbalance;
	}

	public Long getRecalctotalcredits() {
		return recalctotalcredits;
	}

	public void setRecalctotalcredits(Long recalctotalcredits) {
		this.recalctotalcredits = recalctotalcredits;
	}

	public Long getRecalctotalpayments() {
		return recalctotalpayments;
	}

	public void setRecalctotalpayments(Long recalctotalpayments) {
		this.recalctotalpayments = recalctotalpayments;
	}

	public Long getRecalctotalcreditsbyduedate() {
		return recalctotalcreditsbyduedate;
	}

	public void setRecalctotalcreditsbyduedate(Long recalctotalcreditsbyduedate) {
		this.recalctotalcreditsbyduedate = recalctotalcreditsbyduedate;
	}

	public Long getRecalctotalinterest() {
		return recalctotalinterest;
	}

	public void setRecalctotalinterest(Long recalctotalinterest) {
		this.recalctotalinterest = recalctotalinterest;
	}

	public Long getRecalcexcessinterest() {
		return recalcexcessinterest;
	}

	public void setRecalcexcessinterest(Long recalcexcessinterest) {
		this.recalcexcessinterest = recalcexcessinterest;
	}

	public Long getRecalcexcesspaymentamount() {
		return recalcexcesspaymentamount;
	}

	public void setRecalcexcesspaymentamount(Long recalcexcesspaymentamount) {
		this.recalcexcesspaymentamount = recalcexcesspaymentamount;
	}

	public TIMESTAMP getRecalccureoverduedate() {
		return recalccureoverduedate;
	}

	public void setRecalccureoverduedate(TIMESTAMP recalccureoverduedate) {
		this.recalccureoverduedate = recalccureoverduedate;
	}

	public Long getConverted() {
		return converted;
	}

	public void setConverted(Long converted) {
		this.converted = converted;
	}
}
