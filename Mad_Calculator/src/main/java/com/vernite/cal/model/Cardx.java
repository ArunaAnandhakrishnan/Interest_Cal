package com.vernite.cal.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import oracle.sql.TIMESTAMP;

@Entity
public class Cardx {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serno;

	@ManyToOne
	@JoinColumn(name = "caccserno", nullable = false)
	@JsonIgnore
	private Caccounts caccounts;

	@ManyToOne
	@JoinColumn(name = "product", unique = true, nullable = false)
	@JsonIgnore
	private Products products;


	private String numberx;
	private long institution_id;
	// private Long caccserno;
	private Long primarycard;
	private Long peopleserno;
	private Long riskdomainserno;
	// private Long product;
	// private Integer caccserno;
	private Long feeprofserno;
	private Long trxnfeeprofserno;
	private Long authfeeprofserno;
	private Long instprofserno;
	private Long rewardprofserno;
	private Long caprofserno;
	private Long servicefeeoverridesexist;
	private Long trxnfeeoverridesexist;
	private Long servicecode;
	private Date expirydate;
	private String expirydatestatus;
	private Long expiryperiodrenew;
	private TIMESTAMP previousexpirydate;
	private String prevexpirydatestatus;
	private Date createdate;
	private TIMESTAMP blockeddate;
	private TIMESTAMP closedate;
	private Long oldcardserno;
	private Long newcardserno;
	private String stgeneral;
	private String stfinancial;
	private String stauthorization;
	private String stembossing;
	private String prechangerequeststgeneral;
	private Long masterprofileserno;
	private Long realflag;
	private String cardcountry;
	private Long virtual;
	private Long applicationserno;
	private Long accstmtsummaryind;
	private Long sendmemostatement;
	private String logaction;
	private Long defaultaccounttype;
	private Long instantissuance;
	private String languagecode;
	private Long pvvversionno;
	private Long cardactiveversionno;
	private Long entityversionno;
	private String externalreference;
	private String acsenrolmentstatus;
	private Long acspasswordmodel;
	private Long prioritypasscardserno;
	private Long prioritypasscard;
	private Long riskassessmentvalue;
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

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Long getPeopleserno() {
		return peopleserno;
	}

	public void setPeopleserno(Long peopleserno) {
		this.peopleserno = peopleserno;
	}

	public String getNumberx() {
		return numberx;
	}

	public void setNumberx(String numberx) {
		this.numberx = numberx;
	}

	public long getInstitution_id() {
		return institution_id;
	}

	public void setInstitution_id(long institution_id) {
		this.institution_id = institution_id;
	}

	public Long getPrimarycard() {
		return primarycard;
	}

	public void setPrimarycard(Long primarycard) {
		this.primarycard = primarycard;
	}

	public Long getRiskdomainserno() {
		return riskdomainserno;
	}

	public void setRiskdomainserno(Long riskdomainserno) {
		this.riskdomainserno = riskdomainserno;
	}

	public Long getFeeprofserno() {
		return feeprofserno;
	}

	public void setFeeprofserno(Long feeprofserno) {
		this.feeprofserno = feeprofserno;
	}

	public Long getTrxnfeeprofserno() {
		return trxnfeeprofserno;
	}

	public void setTrxnfeeprofserno(Long trxnfeeprofserno) {
		this.trxnfeeprofserno = trxnfeeprofserno;
	}

	public Long getAuthfeeprofserno() {
		return authfeeprofserno;
	}

	public void setAuthfeeprofserno(Long authfeeprofserno) {
		this.authfeeprofserno = authfeeprofserno;
	}

	public Long getInstprofserno() {
		return instprofserno;
	}

	public void setInstprofserno(Long instprofserno) {
		this.instprofserno = instprofserno;
	}

	public Long getRewardprofserno() {
		return rewardprofserno;
	}

	public void setRewardprofserno(Long rewardprofserno) {
		this.rewardprofserno = rewardprofserno;
	}

	public Long getCaprofserno() {
		return caprofserno;
	}

	public void setCaprofserno(Long caprofserno) {
		this.caprofserno = caprofserno;
	}

	public Long getServicefeeoverridesexist() {
		return servicefeeoverridesexist;
	}

	public void setServicefeeoverridesexist(Long servicefeeoverridesexist) {
		this.servicefeeoverridesexist = servicefeeoverridesexist;
	}

	public Long getTrxnfeeoverridesexist() {
		return trxnfeeoverridesexist;
	}

	public void setTrxnfeeoverridesexist(Long trxnfeeoverridesexist) {
		this.trxnfeeoverridesexist = trxnfeeoverridesexist;
	}

	public Long getServicecode() {
		return servicecode;
	}

	public void setServicecode(Long servicecode) {
		this.servicecode = servicecode;
	}

	public Date getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

	public String getExpirydatestatus() {
		return expirydatestatus;
	}

	public void setExpirydatestatus(String expirydatestatus) {
		this.expirydatestatus = expirydatestatus;
	}

	public Long getExpiryperiodrenew() {
		return expiryperiodrenew;
	}

	public void setExpiryperiodrenew(Long expiryperiodrenew) {
		this.expiryperiodrenew = expiryperiodrenew;
	}

	public TIMESTAMP getPreviousexpirydate() {
		return previousexpirydate;
	}

	public void setPreviousexpirydate(TIMESTAMP previousexpirydate) {
		this.previousexpirydate = previousexpirydate;
	}

	public String getPrevexpirydatestatus() {
		return prevexpirydatestatus;
	}

	public void setPrevexpirydatestatus(String prevexpirydatestatus) {
		this.prevexpirydatestatus = prevexpirydatestatus;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public TIMESTAMP getBlockeddate() {
		return blockeddate;
	}

	public void setBlockeddate(TIMESTAMP blockeddate) {
		this.blockeddate = blockeddate;
	}

	public TIMESTAMP getClosedate() {
		return closedate;
	}

	public void setClosedate(TIMESTAMP closedate) {
		this.closedate = closedate;
	}

	public Long getOldcardserno() {
		return oldcardserno;
	}

	public void setOldcardserno(Long oldcardserno) {
		this.oldcardserno = oldcardserno;
	}

	public Long getNewcardserno() {
		return newcardserno;
	}

	public void setNewcardserno(Long newcardserno) {
		this.newcardserno = newcardserno;
	}

	public String getStgeneral() {
		return stgeneral;
	}

	public void setStgeneral(String stgeneral) {
		this.stgeneral = stgeneral;
	}

	public String getStfinancial() {
		return stfinancial;
	}

	public void setStfinancial(String stfinancial) {
		this.stfinancial = stfinancial;
	}

	public String getStauthorization() {
		return stauthorization;
	}

	public void setStauthorization(String stauthorization) {
		this.stauthorization = stauthorization;
	}

	public String getStembossing() {
		return stembossing;
	}

	public void setStembossing(String stembossing) {
		this.stembossing = stembossing;
	}

	public String getPrechangerequeststgeneral() {
		return prechangerequeststgeneral;
	}

	public void setPrechangerequeststgeneral(String prechangerequeststgeneral) {
		this.prechangerequeststgeneral = prechangerequeststgeneral;
	}

	public Long getMasterprofileserno() {
		return masterprofileserno;
	}

	public void setMasterprofileserno(Long masterprofileserno) {
		this.masterprofileserno = masterprofileserno;
	}

	public Long getRealflag() {
		return realflag;
	}

	public void setRealflag(Long realflag) {
		this.realflag = realflag;
	}

	public String getCardcountry() {
		return cardcountry;
	}

	public void setCardcountry(String cardcountry) {
		this.cardcountry = cardcountry;
	}

	public Long getVirtual() {
		return virtual;
	}

	public void setVirtual(Long virtual) {
		this.virtual = virtual;
	}

	public Long getApplicationserno() {
		return applicationserno;
	}

	public void setApplicationserno(Long applicationserno) {
		this.applicationserno = applicationserno;
	}

	public Long getAccstmtsummaryind() {
		return accstmtsummaryind;
	}

	public void setAccstmtsummaryind(Long accstmtsummaryind) {
		this.accstmtsummaryind = accstmtsummaryind;
	}

	public Long getSendmemostatement() {
		return sendmemostatement;
	}

	public void setSendmemostatement(Long sendmemostatement) {
		this.sendmemostatement = sendmemostatement;
	}

	public String getLogaction() {
		return logaction;
	}

	public void setLogaction(String logaction) {
		this.logaction = logaction;
	}

	public Long getDefaultaccounttype() {
		return defaultaccounttype;
	}

	public void setDefaultaccounttype(Long defaultaccounttype) {
		this.defaultaccounttype = defaultaccounttype;
	}

	public Long getInstantissuance() {
		return instantissuance;
	}

	public void setInstantissuance(Long instantissuance) {
		this.instantissuance = instantissuance;
	}

	public String getLanguagecode() {
		return languagecode;
	}

	public void setLanguagecode(String languagecode) {
		this.languagecode = languagecode;
	}

	public Long getPvvversionno() {
		return pvvversionno;
	}

	public void setPvvversionno(Long pvvversionno) {
		this.pvvversionno = pvvversionno;
	}

	public Long getCardactiveversionno() {
		return cardactiveversionno;
	}

	public void setCardactiveversionno(Long cardactiveversionno) {
		this.cardactiveversionno = cardactiveversionno;
	}

	public Long getEntityversionno() {
		return entityversionno;
	}

	public void setEntityversionno(Long entityversionno) {
		this.entityversionno = entityversionno;
	}

	public String getExternalreference() {
		return externalreference;
	}

	public void setExternalreference(String externalreference) {
		this.externalreference = externalreference;
	}

	public String getAcsenrolmentstatus() {
		return acsenrolmentstatus;
	}

	public void setAcsenrolmentstatus(String acsenrolmentstatus) {
		this.acsenrolmentstatus = acsenrolmentstatus;
	}

	public Long getAcspasswordmodel() {
		return acspasswordmodel;
	}

	public void setAcspasswordmodel(Long acspasswordmodel) {
		this.acspasswordmodel = acspasswordmodel;
	}

	public Long getPrioritypasscardserno() {
		return prioritypasscardserno;
	}

	public void setPrioritypasscardserno(Long prioritypasscardserno) {
		this.prioritypasscardserno = prioritypasscardserno;
	}

	public Long getPrioritypasscard() {
		return prioritypasscard;
	}

	public void setPrioritypasscard(Long prioritypasscard) {
		this.prioritypasscard = prioritypasscard;
	}

	public Long getRiskassessmentvalue() {
		return riskassessmentvalue;
	}

	public void setRiskassessmentvalue(Long riskassessmentvalue) {
		this.riskassessmentvalue = riskassessmentvalue;
	}

	public Long getConverted() {
		return converted;
	}

	public void setConverted(Long converted) {
		this.converted = converted;
	}
}