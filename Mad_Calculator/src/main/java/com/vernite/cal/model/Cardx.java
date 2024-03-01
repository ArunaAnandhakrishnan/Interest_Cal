package com.vernite.cal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

	
	// cardx -> mprofileacct
//	@Id
//	@OneToMany(mappedBy = "cardx", cascade = CascadeType.ALL)
//	@JsonIgnore
//	private List<Mprofileacct> mprofileacctsList;

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

	public Caccounts getCaccounts() {
		return caccounts;
	}

	public Products getProducts() {
		return products;
	}

//	public List<Mprofileacct> getMprofileacctsList() {
//		return mprofileacctsList;
//	}

	public String getNumberx() {
		return numberx;
	}

	public void setSerno(Long serno) {
		this.serno = serno;
	}

	public void setCaccounts(Caccounts caccounts) {
		this.caccounts = caccounts;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

//	public void setMprofileacctsList(List<Mprofileacct> mprofileacctsList) {
//		this.mprofileacctsList = mprofileacctsList;
//	}

	public void setNumberx(String numberx) {
		this.numberx = numberx;
	}

}