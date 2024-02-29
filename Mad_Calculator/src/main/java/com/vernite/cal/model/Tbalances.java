package com.vernite.cal.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import oracle.sql.TIMESTAMP;

@Entity
public class Tbalances {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serno;

	@ManyToOne
	@JoinColumn(name = "stmtserno", nullable = false)
	private Cstatements cstatements;

//	private Integer stmtserno;

	private Long institution_id;
	// serno NUMBER(10) not null,
	private Long normaltbalanceserno;
	// private Long stmtserno;
	private Long partitionkey;
	private Long invoiceserno;
	private Long invoicepartitionkey;
	private Long trxnserno;
	private Long trxnpartitionkey;
	private Long instalmentserno;
	private Long instalmentpartitionkey;
	private Long reversaltrxnserno;
	private Long reversaltrxnpartitionkey;
	private Long caccserno;
	private String rectype;
	private Long cycleage;
	private Long overdueage;
	private BigDecimal amount;
	private BigDecimal outstandingamount;
	private Long cashbackamount;
	private Long outstandingcashbackamount;
	private BigDecimal dueamount;
	private BigDecimal postduedateoutstdueamount;
	private BigDecimal postduedateoutstamount;
	private BigDecimal totalbalance;
	private Long pendinginterestcycles;
	private Long pendinginterest;
	private Long totalpendinginterest;
	private Long excessinterest;
	private Long chargedinterest;
	private Long chargedexcessinterest;
	private Long chargedinterestforceflag;
	private BigDecimal suspendedinterest;
	private Date balcreatedate;
	private Date baleffectdate;
	private Date lastbalupddate;
	private Date startofinterestoriginal;
	private Date startofinterest;
	private TIMESTAMP rollingdate;
	private TIMESTAMP instalmentexpirydate;
	private Date valuedate;
	private Date printduedate;
	private Date duedate;
	private TIMESTAMP minduevaluedate;
	private Long minpaypercentage;
	private Long interestbaseserno;
	private Long interestrateserno;
	private TIMESTAMP interestrate;
	private Long interestratedaily;
	private String rewardbalancereasoncode;
	private Long mbhagreementserno;
	private TIMESTAMP mbhagreementexpirydate;
	private Long campaignserno;
	private TIMESTAMP campaignexpirydate;
	private Long campaignallocprofserno;
	private Long transactiontype;
	private Long defaultinteresttrxntype;
	private String sign;
	private Long cashflag;
	private Long trxntypeoptions;
	private Long instalmentallocpriority;
	private Long chargeflag;
	private Long partialgrace;
	private Long inclusiveness;
	private Long interestextendedtoduedate;
	private Long interestperiod;
	private Long keepinterestbaseserno;
	private Long taxflag;
	private Long chargefeeflag;
	private String consolidationsubkey;
	private String status;
	private Long origtrxnserno;
	private Long origtrxnpartitionkey;
	private String origrectype;
	private Long origcycleage;
	private Long origoverdueage;
	private Long origstmtserno;
	private Long origstmtpartitionkey;
	private Date origstmtdate;
	private Date origprintduedate;
	private Date origduedate;
	private Long overduestmtserno;
	private Long overduestmtpartitionkey;
	private Date overduestmtdate;
	private String overduestatus;
	private Long ofstmtorinvoiceserno;
	private Long ofstmtorinvoicepartitionkey;
	private TIMESTAMP ofstmtdate;
	private TIMESTAMP ofprintduedate;
	private TIMESTAMP ofduedate;
	private TIMESTAMP ofoverduestmtdate;
	private String ofrectype;
	private Long oftrxntype;
	private Long minamountswaivedserno;
	private Long nextbalanceserno;
	private Long nextbalancepartitionkey;
	private Long rateindex;
	private Long balintindex;
	private Timestamp logtimestamp;
	private Long converted;

	public Long getSerno() {
		return serno;
	}

	public Cstatements getCstatements() {
		return cstatements;
	}

	public Long getInstitution_id() {
		return institution_id;
	}

	public Long getNormaltbalanceserno() {
		return normaltbalanceserno;
	}

	public Long getPartitionkey() {
		return partitionkey;
	}

	public Long getInvoiceserno() {
		return invoiceserno;
	}

	public Long getInvoicepartitionkey() {
		return invoicepartitionkey;
	}

	public Long getTrxnserno() {
		return trxnserno;
	}

	public Long getTrxnpartitionkey() {
		return trxnpartitionkey;
	}

	public Long getInstalmentserno() {
		return instalmentserno;
	}

	public Long getInstalmentpartitionkey() {
		return instalmentpartitionkey;
	}

	public Long getReversaltrxnserno() {
		return reversaltrxnserno;
	}

	public Long getReversaltrxnpartitionkey() {
		return reversaltrxnpartitionkey;
	}

	public Long getCaccserno() {
		return caccserno;
	}

	public String getRectype() {
		return rectype;
	}

	public Long getCycleage() {
		return cycleage;
	}

	public Long getOverdueage() {
		return overdueage;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public BigDecimal getOutstandingamount() {
		return outstandingamount;
	}

	public BigDecimal getDueamount() {
		return dueamount;
	}

	public BigDecimal getPostduedateoutstdueamount() {
		return postduedateoutstdueamount;
	}

	public BigDecimal getPostduedateoutstamount() {
		return postduedateoutstamount;
	}

	public BigDecimal getTotalbalance() {
		return totalbalance;
	}

	public BigDecimal getSuspendedinterest() {
		return suspendedinterest;
	}

	public Date getBalcreatedate() {
		return balcreatedate;
	}

	public Date getBaleffectdate() {
		return baleffectdate;
	}

	public Date getLastbalupddate() {
		return lastbalupddate;
	}

	public Date getStartofinterestoriginal() {
		return startofinterestoriginal;
	}

	public Date getStartofinterest() {
		return startofinterest;
	}

	public Date getValuedate() {
		return valuedate;
	}

	public Date getPrintduedate() {
		return printduedate;
	}

	public Date getDuedate() {
		return duedate;
	}

	public String getRewardbalancereasoncode() {
		return rewardbalancereasoncode;
	}

	public Long getMbhagreementserno() {
		return mbhagreementserno;
	}

	public Long getCampaignserno() {
		return campaignserno;
	}

	public Long getCampaignallocprofserno() {
		return campaignallocprofserno;
	}

	public Long getTransactiontype() {
		return transactiontype;
	}

	public Long getDefaultinteresttrxntype() {
		return defaultinteresttrxntype;
	}

	public String getSign() {
		return sign;
	}

	public Long getInstalmentallocpriority() {
		return instalmentallocpriority;
	}

	public Long getChargeflag() {
		return chargeflag;
	}

	public Long getPartialgrace() {
		return partialgrace;
	}

	public Long getInclusiveness() {
		return inclusiveness;
	}

	public Long getInterestextendedtoduedate() {
		return interestextendedtoduedate;
	}

	public Long getInterestperiod() {
		return interestperiod;
	}

	public Long getTaxflag() {
		return taxflag;
	}

	public Long getChargefeeflag() {
		return chargefeeflag;
	}

	public String getConsolidationsubkey() {
		return consolidationsubkey;
	}

	public String getStatus() {
		return status;
	}

	public Long getOrigtrxnserno() {
		return origtrxnserno;
	}

	public Long getOrigtrxnpartitionkey() {
		return origtrxnpartitionkey;
	}

	public String getOrigrectype() {
		return origrectype;
	}

	public Long getOrigcycleage() {
		return origcycleage;
	}

	public Long getOrigoverdueage() {
		return origoverdueage;
	}

	public Long getOrigstmtpartitionkey() {
		return origstmtpartitionkey;
	}

	public Date getOrigstmtdate() {
		return origstmtdate;
	}

	public Date getOrigprintduedate() {
		return origprintduedate;
	}

	public Date getOrigduedate() {
		return origduedate;
	}

	public Date getOverduestmtdate() {
		return overduestmtdate;
	}

	public String getOverduestatus() {
		return overduestatus;
	}

	public Long getOfstmtorinvoiceserno() {
		return ofstmtorinvoiceserno;
	}

	public Long getOfstmtorinvoicepartitionkey() {
		return ofstmtorinvoicepartitionkey;
	}

	public String getOfrectype() {
		return ofrectype;
	}

	public Long getOftrxntype() {
		return oftrxntype;
	}

	public Long getMinamountswaivedserno() {
		return minamountswaivedserno;
	}

	public Long getNextbalanceserno() {
		return nextbalanceserno;
	}

	public Long getNextbalancepartitionkey() {
		return nextbalancepartitionkey;
	}

	public Long getBalintindex() {
		return balintindex;
	}

	public Timestamp getLogtimestamp() {
		return logtimestamp;
	}

	public Long getConverted() {
		return converted;
	}

	public void setSerno(Long serno) {
		this.serno = serno;
	}

	public void setCstatements(Cstatements cstatements) {
		this.cstatements = cstatements;
	}

	public void setInstitution_id(Long institution_id) {
		this.institution_id = institution_id;
	}

	public void setNormaltbalanceserno(Long normaltbalanceserno) {
		this.normaltbalanceserno = normaltbalanceserno;
	}

	public void setPartitionkey(Long partitionkey) {
		this.partitionkey = partitionkey;
	}

	public void setInvoiceserno(Long invoiceserno) {
		this.invoiceserno = invoiceserno;
	}

	public void setInvoicepartitionkey(Long invoicepartitionkey) {
		this.invoicepartitionkey = invoicepartitionkey;
	}

	public void setTrxnserno(Long trxnserno) {
		this.trxnserno = trxnserno;
	}

	public void setTrxnpartitionkey(Long trxnpartitionkey) {
		this.trxnpartitionkey = trxnpartitionkey;
	}

	public void setInstalmentserno(Long instalmentserno) {
		this.instalmentserno = instalmentserno;
	}

	public void setInstalmentpartitionkey(Long instalmentpartitionkey) {
		this.instalmentpartitionkey = instalmentpartitionkey;
	}

	public void setReversaltrxnserno(Long reversaltrxnserno) {
		this.reversaltrxnserno = reversaltrxnserno;
	}

	public void setReversaltrxnpartitionkey(Long reversaltrxnpartitionkey) {
		this.reversaltrxnpartitionkey = reversaltrxnpartitionkey;
	}

	public void setCaccserno(Long caccserno) {
		this.caccserno = caccserno;
	}

	public void setRectype(String rectype) {
		this.rectype = rectype;
	}

	public void setCycleage(Long cycleage) {
		this.cycleage = cycleage;
	}

	public void setOverdueage(Long overdueage) {
		this.overdueage = overdueage;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setOutstandingamount(BigDecimal outstandingamount) {
		this.outstandingamount = outstandingamount;
	}

	public void setDueamount(BigDecimal dueamount) {
		this.dueamount = dueamount;
	}

	public void setPostduedateoutstdueamount(BigDecimal postduedateoutstdueamount) {
		this.postduedateoutstdueamount = postduedateoutstdueamount;
	}

	public void setPostduedateoutstamount(BigDecimal postduedateoutstamount) {
		this.postduedateoutstamount = postduedateoutstamount;
	}

	public void setTotalbalance(BigDecimal totalbalance) {
		this.totalbalance = totalbalance;
	}

	public Long getPendinginterestcycles() {
		return pendinginterestcycles;
	}

	public void setPendinginterestcycles(Long pendinginterestcycles) {
		this.pendinginterestcycles = pendinginterestcycles;
	}

	public Long getPendinginterest() {
		return pendinginterest;
	}

	public void setPendinginterest(Long pendinginterest) {
		this.pendinginterest = pendinginterest;
	}

	public Long getTotalpendinginterest() {
		return totalpendinginterest;
	}

	public void setTotalpendinginterest(Long totalpendinginterest) {
		this.totalpendinginterest = totalpendinginterest;
	}

	public Long getChargedinterest() {
		return chargedinterest;
	}

	public void setChargedinterest(Long chargedinterest) {
		this.chargedinterest = chargedinterest;
	}

	public Long getExcessinterest() {
		return excessinterest;
	}

	public void setExcessinterest(Long excessinterest) {
		this.excessinterest = excessinterest;
	}

	public void setSuspendedinterest(BigDecimal suspendedinterest) {
		this.suspendedinterest = suspendedinterest;
	}

	public void setBalcreatedate(Date balcreatedate) {
		this.balcreatedate = balcreatedate;
	}

	public void setBaleffectdate(Date baleffectdate) {
		this.baleffectdate = baleffectdate;
	}

	public void setLastbalupddate(Date lastbalupddate) {
		this.lastbalupddate = lastbalupddate;
	}

	public void setStartofinterestoriginal(Date startofinterestoriginal) {
		this.startofinterestoriginal = startofinterestoriginal;
	}

	public void setStartofinterest(Date startofinterest) {
		this.startofinterest = startofinterest;
	}

	public void setValuedate(Date valuedate) {
		this.valuedate = valuedate;
	}

	public void setPrintduedate(Date printduedate) {
		this.printduedate = printduedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public Long getMinpaypercentage() {
		return minpaypercentage;
	}

	public void setMinpaypercentage(Long minpaypercentage) {
		this.minpaypercentage = minpaypercentage;
	}

	public void setRewardbalancereasoncode(String rewardbalancereasoncode) {
		this.rewardbalancereasoncode = rewardbalancereasoncode;
	}

	public void setMbhagreementserno(Long mbhagreementserno) {
		this.mbhagreementserno = mbhagreementserno;
	}

	public void setCampaignserno(Long campaignserno) {
		this.campaignserno = campaignserno;
	}

	public void setCampaignallocprofserno(Long campaignallocprofserno) {
		this.campaignallocprofserno = campaignallocprofserno;
	}

	public void setTransactiontype(Long transactiontype) {
		this.transactiontype = transactiontype;
	}

	public void setDefaultinteresttrxntype(Long defaultinteresttrxntype) {
		this.defaultinteresttrxntype = defaultinteresttrxntype;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Long getCashbackamount() {
		return cashbackamount;
	}

	public void setCashbackamount(Long cashbackamount) {
		this.cashbackamount = cashbackamount;
	}

	public void setInstalmentallocpriority(Long instalmentallocpriority) {
		this.instalmentallocpriority = instalmentallocpriority;
	}

	public void setChargeflag(Long chargeflag) {
		this.chargeflag = chargeflag;
	}

	public void setPartialgrace(Long partialgrace) {
		this.partialgrace = partialgrace;
	}

	public void setInclusiveness(Long inclusiveness) {
		this.inclusiveness = inclusiveness;
	}

	public void setInterestextendedtoduedate(Long interestextendedtoduedate) {
		this.interestextendedtoduedate = interestextendedtoduedate;
	}

	public void setInterestperiod(Long interestperiod) {
		this.interestperiod = interestperiod;
	}

	public void setTaxflag(Long taxflag) {
		this.taxflag = taxflag;
	}

	public void setChargefeeflag(Long chargefeeflag) {
		this.chargefeeflag = chargefeeflag;
	}

	public void setConsolidationsubkey(String consolidationsubkey) {
		this.consolidationsubkey = consolidationsubkey;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setOrigtrxnserno(Long origtrxnserno) {
		this.origtrxnserno = origtrxnserno;
	}

	public void setOrigtrxnpartitionkey(Long origtrxnpartitionkey) {
		this.origtrxnpartitionkey = origtrxnpartitionkey;
	}

	public void setOrigrectype(String origrectype) {
		this.origrectype = origrectype;
	}

	public void setOrigcycleage(Long origcycleage) {
		this.origcycleage = origcycleage;
	}

	public void setOrigoverdueage(Long origoverdueage) {
		this.origoverdueage = origoverdueage;
	}

	public void setOrigstmtpartitionkey(Long origstmtpartitionkey) {
		this.origstmtpartitionkey = origstmtpartitionkey;
	}

	public Long getOutstandingcashbackamount() {
		return outstandingcashbackamount;
	}

	public Long getChargedexcessinterest() {
		return chargedexcessinterest;
	}

	public Long getChargedinterestforceflag() {
		return chargedinterestforceflag;
	}

	public Long getInterestratedaily() {
		return interestratedaily;
	}

	public void setOutstandingcashbackamount(Long outstandingcashbackamount) {
		this.outstandingcashbackamount = outstandingcashbackamount;
	}

	public void setChargedexcessinterest(Long chargedexcessinterest) {
		this.chargedexcessinterest = chargedexcessinterest;
	}

	public void setChargedinterestforceflag(Long chargedinterestforceflag) {
		this.chargedinterestforceflag = chargedinterestforceflag;
	}

	public void setInterestratedaily(Long interestratedaily) {
		this.interestratedaily = interestratedaily;
	}

	public Long getOrigstmtserno() {
		return origstmtserno;
	}

	public Long getOverduestmtpartitionkey() {
		return overduestmtpartitionkey;
	}

	public void setOrigstmtserno(Long origstmtserno) {
		this.origstmtserno = origstmtserno;
	}

	public void setOverduestmtpartitionkey(Long overduestmtpartitionkey) {
		this.overduestmtpartitionkey = overduestmtpartitionkey;
	}

	public void setOrigstmtdate(Date origstmtdate) {
		this.origstmtdate = origstmtdate;
	}

	public void setOrigprintduedate(Date origprintduedate) {
		this.origprintduedate = origprintduedate;
	}

	public void setOrigduedate(Date origduedate) {
		this.origduedate = origduedate;
	}

	public Long getOverduestmtserno() {
		return overduestmtserno;
	}

	public void setOverduestmtserno(Long overduestmtserno) {
		this.overduestmtserno = overduestmtserno;
	}

	public void setOverduestmtdate(Date overduestmtdate) {
		this.overduestmtdate = overduestmtdate;
	}

	public void setOverduestatus(String overduestatus) {
		this.overduestatus = overduestatus;
	}

	public void setOfstmtorinvoiceserno(Long ofstmtorinvoiceserno) {
		this.ofstmtorinvoiceserno = ofstmtorinvoiceserno;
	}

	public void setOfstmtorinvoicepartitionkey(Long ofstmtorinvoicepartitionkey) {
		this.ofstmtorinvoicepartitionkey = ofstmtorinvoicepartitionkey;
	}

	public TIMESTAMP getRollingdate() {
		return rollingdate;
	}

	public TIMESTAMP getInstalmentexpirydate() {
		return instalmentexpirydate;
	}

	public TIMESTAMP getMinduevaluedate() {
		return minduevaluedate;
	}

	public Long getInterestbaseserno() {
		return interestbaseserno;
	}

	public Long getInterestrateserno() {
		return interestrateserno;
	}

	public TIMESTAMP getInterestrate() {
		return interestrate;
	}

	public TIMESTAMP getMbhagreementexpirydate() {
		return mbhagreementexpirydate;
	}

	public TIMESTAMP getCampaignexpirydate() {
		return campaignexpirydate;
	}

	public Long getCashflag() {
		return cashflag;
	}

	public Long getTrxntypeoptions() {
		return trxntypeoptions;
	}

	public Long getKeepinterestbaseserno() {
		return keepinterestbaseserno;
	}

	public TIMESTAMP getOfstmtdate() {
		return ofstmtdate;
	}

	public TIMESTAMP getOfprintduedate() {
		return ofprintduedate;
	}

	public TIMESTAMP getOfduedate() {
		return ofduedate;
	}

	public TIMESTAMP getOfoverduestmtdate() {
		return ofoverduestmtdate;
	}

	public void setRollingdate(TIMESTAMP rollingdate) {
		this.rollingdate = rollingdate;
	}

	public void setInstalmentexpirydate(TIMESTAMP instalmentexpirydate) {
		this.instalmentexpirydate = instalmentexpirydate;
	}

	public void setMinduevaluedate(TIMESTAMP minduevaluedate) {
		this.minduevaluedate = minduevaluedate;
	}

	public void setInterestbaseserno(Long interestbaseserno) {
		this.interestbaseserno = interestbaseserno;
	}

	public void setInterestrateserno(Long interestrateserno) {
		this.interestrateserno = interestrateserno;
	}

	public void setInterestrate(TIMESTAMP interestrate) {
		this.interestrate = interestrate;
	}

	public void setMbhagreementexpirydate(TIMESTAMP mbhagreementexpirydate) {
		this.mbhagreementexpirydate = mbhagreementexpirydate;
	}

	public void setCampaignexpirydate(TIMESTAMP campaignexpirydate) {
		this.campaignexpirydate = campaignexpirydate;
	}

	public void setCashflag(Long cashflag) {
		this.cashflag = cashflag;
	}

	public void setTrxntypeoptions(Long trxntypeoptions) {
		this.trxntypeoptions = trxntypeoptions;
	}

	public void setKeepinterestbaseserno(Long keepinterestbaseserno) {
		this.keepinterestbaseserno = keepinterestbaseserno;
	}

	public void setOfstmtdate(TIMESTAMP ofstmtdate) {
		this.ofstmtdate = ofstmtdate;
	}

	public void setOfprintduedate(TIMESTAMP ofprintduedate) {
		this.ofprintduedate = ofprintduedate;
	}

	public void setOfduedate(TIMESTAMP ofduedate) {
		this.ofduedate = ofduedate;
	}

	public void setOfoverduestmtdate(TIMESTAMP ofoverduestmtdate) {
		this.ofoverduestmtdate = ofoverduestmtdate;
	}

	public void setOfrectype(String ofrectype) {
		this.ofrectype = ofrectype;
	}

	public void setOftrxntype(Long oftrxntype) {
		this.oftrxntype = oftrxntype;
	}

	public void setMinamountswaivedserno(Long minamountswaivedserno) {
		this.minamountswaivedserno = minamountswaivedserno;
	}

	public void setNextbalanceserno(Long nextbalanceserno) {
		this.nextbalanceserno = nextbalanceserno;
	}

	public void setNextbalancepartitionkey(Long nextbalancepartitionkey) {
		this.nextbalancepartitionkey = nextbalancepartitionkey;
	}

	public void setBalintindex(Long balintindex) {
		this.balintindex = balintindex;
	}

	public void setLogtimestamp(Timestamp logtimestamp) {
		this.logtimestamp = logtimestamp;
	}

	public void setConverted(Long converted) {
		this.converted = converted;
	}

	public Long getRateindex() {
		return rateindex;
	}

	public void setRateindex(Long rateindex) {
		this.rateindex = rateindex;
	}

}
