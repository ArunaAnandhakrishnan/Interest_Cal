package com.vernite.cal.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Mprofileacct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serno;

	@ManyToOne
	@JoinColumn(name = "stmtprofserno", nullable = false)
	private Profiles profiles;
	@ManyToOne
	@JoinColumn(name = "product", nullable = false)
	private Products products;
	private Long institution_id;
	private Long leveldepth;
	private String levellabel;
	private String levelparentlabel;
	private String code;
	private String description;
	private Long realflag;
	private String excludefromprobe;
	private Long corpmodel;
	private Long memomodel;
	private Date validfrom;
	private Date validuntil;
	private Long childaccmasterprofileserno;
	private Long childcardmasterprofileserno;
	private String accounttype;
	private String billingmethod;
	private Long dailyaccrualflag;
	private Long serviceperiod;
	private Long nextmasterprofile;
	private Long prevmasterprofile;
	private Long propagatechanges;

	private String numbergeneration;
	private String numbergenformat;
	private Long currency;
	private Long creditlimit;
	private Long allocprofserno;
	private Long feeprofserno;
	private Long trxnfeeprofserno;
	private Long instprofserno;
	private Long rewardprofserno;
	private Long caprofserno;
	private Long enablediversion;
	private Long enablerewarddiversion;
	private Long lmaxaggcl;
	private String stgeneral;
	private Long holidaytableserno;
	private String bankname;
	private String bankaccount;
	private String banksortcode;
	private String bankbranch;
	private String bankaccname;
	private String bankacccountry;
	private Long bankddenabled;
	private Long bankddamount;
	private Long bankddpercentage;
	private Long bankddcombination;
	private String paymentmethod;
	private Long statementinstalmentsallowed;
	private Long statementinstalmentsmaxnum;
	private Long mbhindicator;
	private String mbhnocontractindstatus;
	private String mbhexpiredstatus;
	private Long mbhagreementexpiryperiod;
	private Long mbhagreementrenbefexpperiod;
	private Long mbhagreementprofitrate;
	private Long mbhagreementprofitrateperiod;
	private String embcompanyname;
	private Long sendtovcf;
	private Long defineriskdomain;
	private Long makeauthgroups;
	private Long authcurrency;
	private Long authlimit;
	private Long authshadowextralimit;
	private Long authlimitperiod;
	private Long extraauthlimit;
	private Long authalltrxn;
	private Long authalltrxnperiod;
	private Long authcashlimit;
	private Long authshadowextracashlimit;
	private Long authcashtrxn;
	private Long authcashperiod;
	private Long authtebonus;
	private Long authtmpbonus;
	private Long authtmpperiod;
	private Long authtmpbonustrxns;
	private Long authtmpcashbonusamount;
	private Long authtmpcashbonustrxns;
	private Long authtmpcashbonusperiod;
	private Long authusagecode;
	private Long authdeclinetrxn;
	private Long authdeclinelimit;
	private Long authdeclineperiod;
	private Long auth1trxnlimit;
	private Long authblockedlimit;
	private Long authaccounttype;
	private Long authmodeusage;
	private Long authdhprofserno;
	private Long scorecardserno;


	public Long getSerno() {
		return serno;
	}

	public void setSerno(Long serno) {
		this.serno = serno;
	}

	public Profiles getProfiles() {
		return profiles;
	}

	public void setProfiles(Profiles profiles) {
		this.profiles = profiles;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Long getInstitution_id() {
		return institution_id;
	}

	public void setInstitution_id(Long institution_id) {
		this.institution_id = institution_id;
	}

	public Long getLeveldepth() {
		return leveldepth;
	}

	public void setLeveldepth(Long leveldepth) {
		this.leveldepth = leveldepth;
	}

	public String getLevellabel() {
		return levellabel;
	}

	public void setLevellabel(String levellabel) {
		this.levellabel = levellabel;
	}

	public String getLevelparentlabel() {
		return levelparentlabel;
	}

	public void setLevelparentlabel(String levelparentlabel) {
		this.levelparentlabel = levelparentlabel;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getRealflag() {
		return realflag;
	}

	public void setRealflag(Long realflag) {
		this.realflag = realflag;
	}

	public String getExcludefromprobe() {
		return excludefromprobe;
	}

	public void setExcludefromprobe(String excludefromprobe) {
		this.excludefromprobe = excludefromprobe;
	}

	public Long getCorpmodel() {
		return corpmodel;
	}

	public void setCorpmodel(Long corpmodel) {
		this.corpmodel = corpmodel;
	}

	public Long getMemomodel() {
		return memomodel;
	}

	public void setMemomodel(Long memomodel) {
		this.memomodel = memomodel;
	}

	public Date getValidfrom() {
		return validfrom;
	}

	public void setValidfrom(Date validfrom) {
		this.validfrom = validfrom;
	}

	public Date getValiduntil() {
		return validuntil;
	}

	public void setValiduntil(Date validuntil) {
		this.validuntil = validuntil;
	}

	public Long getChildaccmasterprofileserno() {
		return childaccmasterprofileserno;
	}

	public void setChildaccmasterprofileserno(Long childaccmasterprofileserno) {
		this.childaccmasterprofileserno = childaccmasterprofileserno;
	}

	public Long getChildcardmasterprofileserno() {
		return childcardmasterprofileserno;
	}

	public void setChildcardmasterprofileserno(Long childcardmasterprofileserno) {
		this.childcardmasterprofileserno = childcardmasterprofileserno;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getBillingmethod() {
		return billingmethod;
	}

	public void setBillingmethod(String billingmethod) {
		this.billingmethod = billingmethod;
	}

	public Long getDailyaccrualflag() {
		return dailyaccrualflag;
	}

	public void setDailyaccrualflag(Long dailyaccrualflag) {
		this.dailyaccrualflag = dailyaccrualflag;
	}

	public Long getServiceperiod() {
		return serviceperiod;
	}

	public void setServiceperiod(Long serviceperiod) {
		this.serviceperiod = serviceperiod;
	}

	public Long getNextmasterprofile() {
		return nextmasterprofile;
	}

	public void setNextmasterprofile(Long nextmasterprofile) {
		this.nextmasterprofile = nextmasterprofile;
	}

	public Long getPrevmasterprofile() {
		return prevmasterprofile;
	}

	public void setPrevmasterprofile(Long prevmasterprofile) {
		this.prevmasterprofile = prevmasterprofile;
	}

	public Long getPropagatechanges() {
		return propagatechanges;
	}

	public void setPropagatechanges(Long propagatechanges) {
		this.propagatechanges = propagatechanges;
	}

	public String getNumbergeneration() {
		return numbergeneration;
	}

	public void setNumbergeneration(String numbergeneration) {
		this.numbergeneration = numbergeneration;
	}

	public String getNumbergenformat() {
		return numbergenformat;
	}

	public void setNumbergenformat(String numbergenformat) {
		this.numbergenformat = numbergenformat;
	}

	public Long getCurrency() {
		return currency;
	}

	public void setCurrency(Long currency) {
		this.currency = currency;
	}

	public Long getCreditlimit() {
		return creditlimit;
	}

	public void setCreditlimit(Long creditlimit) {
		this.creditlimit = creditlimit;
	}

	public Long getAllocprofserno() {
		return allocprofserno;
	}

	public void setAllocprofserno(Long allocprofserno) {
		this.allocprofserno = allocprofserno;
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

	public Long getEnablediversion() {
		return enablediversion;
	}

	public void setEnablediversion(Long enablediversion) {
		this.enablediversion = enablediversion;
	}

	public Long getEnablerewarddiversion() {
		return enablerewarddiversion;
	}

	public void setEnablerewarddiversion(Long enablerewarddiversion) {
		this.enablerewarddiversion = enablerewarddiversion;
	}

	public Long getLmaxaggcl() {
		return lmaxaggcl;
	}

	public void setLmaxaggcl(Long lmaxaggcl) {
		this.lmaxaggcl = lmaxaggcl;
	}

	public String getStgeneral() {
		return stgeneral;
	}

	public void setStgeneral(String stgeneral) {
		this.stgeneral = stgeneral;
	}

	public Long getHolidaytableserno() {
		return holidaytableserno;
	}

	public void setHolidaytableserno(Long holidaytableserno) {
		this.holidaytableserno = holidaytableserno;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBankaccount() {
		return bankaccount;
	}

	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}

	public String getBanksortcode() {
		return banksortcode;
	}

	public void setBanksortcode(String banksortcode) {
		this.banksortcode = banksortcode;
	}

	public String getBankbranch() {
		return bankbranch;
	}

	public void setBankbranch(String bankbranch) {
		this.bankbranch = bankbranch;
	}

	public String getBankaccname() {
		return bankaccname;
	}

	public void setBankaccname(String bankaccname) {
		this.bankaccname = bankaccname;
	}

	public String getBankacccountry() {
		return bankacccountry;
	}

	public void setBankacccountry(String bankacccountry) {
		this.bankacccountry = bankacccountry;
	}

	public Long getBankddenabled() {
		return bankddenabled;
	}

	public void setBankddenabled(Long bankddenabled) {
		this.bankddenabled = bankddenabled;
	}

	public Long getBankddamount() {
		return bankddamount;
	}

	public void setBankddamount(Long bankddamount) {
		this.bankddamount = bankddamount;
	}

	public Long getBankddpercentage() {
		return bankddpercentage;
	}

	public void setBankddpercentage(Long bankddpercentage) {
		this.bankddpercentage = bankddpercentage;
	}

	public Long getBankddcombination() {
		return bankddcombination;
	}

	public void setBankddcombination(Long bankddcombination) {
		this.bankddcombination = bankddcombination;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public Long getStatementinstalmentsallowed() {
		return statementinstalmentsallowed;
	}

	public void setStatementinstalmentsallowed(Long statementinstalmentsallowed) {
		this.statementinstalmentsallowed = statementinstalmentsallowed;
	}

	public Long getStatementinstalmentsmaxnum() {
		return statementinstalmentsmaxnum;
	}

	public void setStatementinstalmentsmaxnum(Long statementinstalmentsmaxnum) {
		this.statementinstalmentsmaxnum = statementinstalmentsmaxnum;
	}

	public Long getMbhindicator() {
		return mbhindicator;
	}

	public void setMbhindicator(Long mbhindicator) {
		this.mbhindicator = mbhindicator;
	}

	public String getMbhnocontractindstatus() {
		return mbhnocontractindstatus;
	}

	public void setMbhnocontractindstatus(String mbhnocontractindstatus) {
		this.mbhnocontractindstatus = mbhnocontractindstatus;
	}

	public String getMbhexpiredstatus() {
		return mbhexpiredstatus;
	}

	public void setMbhexpiredstatus(String mbhexpiredstatus) {
		this.mbhexpiredstatus = mbhexpiredstatus;
	}

	public Long getMbhagreementexpiryperiod() {
		return mbhagreementexpiryperiod;
	}

	public void setMbhagreementexpiryperiod(Long mbhagreementexpiryperiod) {
		this.mbhagreementexpiryperiod = mbhagreementexpiryperiod;
	}

	public Long getMbhagreementrenbefexpperiod() {
		return mbhagreementrenbefexpperiod;
	}

	public void setMbhagreementrenbefexpperiod(Long mbhagreementrenbefexpperiod) {
		this.mbhagreementrenbefexpperiod = mbhagreementrenbefexpperiod;
	}

	public Long getMbhagreementprofitrate() {
		return mbhagreementprofitrate;
	}

	public void setMbhagreementprofitrate(Long mbhagreementprofitrate) {
		this.mbhagreementprofitrate = mbhagreementprofitrate;
	}

	public Long getMbhagreementprofitrateperiod() {
		return mbhagreementprofitrateperiod;
	}

	public void setMbhagreementprofitrateperiod(Long mbhagreementprofitrateperiod) {
		this.mbhagreementprofitrateperiod = mbhagreementprofitrateperiod;
	}

	public String getEmbcompanyname() {
		return embcompanyname;
	}

	public void setEmbcompanyname(String embcompanyname) {
		this.embcompanyname = embcompanyname;
	}

	public Long getSendtovcf() {
		return sendtovcf;
	}

	public void setSendtovcf(Long sendtovcf) {
		this.sendtovcf = sendtovcf;
	}

	public Long getDefineriskdomain() {
		return defineriskdomain;
	}

	public void setDefineriskdomain(Long defineriskdomain) {
		this.defineriskdomain = defineriskdomain;
	}

	public Long getMakeauthgroups() {
		return makeauthgroups;
	}

	public void setMakeauthgroups(Long makeauthgroups) {
		this.makeauthgroups = makeauthgroups;
	}

	public Long getAuthcurrency() {
		return authcurrency;
	}

	public void setAuthcurrency(Long authcurrency) {
		this.authcurrency = authcurrency;
	}

	public Long getAuthlimit() {
		return authlimit;
	}

	public void setAuthlimit(Long authlimit) {
		this.authlimit = authlimit;
	}

	public Long getAuthshadowextralimit() {
		return authshadowextralimit;
	}

	public void setAuthshadowextralimit(Long authshadowextralimit) {
		this.authshadowextralimit = authshadowextralimit;
	}

	public Long getAuthlimitperiod() {
		return authlimitperiod;
	}

	public void setAuthlimitperiod(Long authlimitperiod) {
		this.authlimitperiod = authlimitperiod;
	}

	public Long getExtraauthlimit() {
		return extraauthlimit;
	}

	public void setExtraauthlimit(Long extraauthlimit) {
		this.extraauthlimit = extraauthlimit;
	}

	public Long getAuthalltrxn() {
		return authalltrxn;
	}

	public void setAuthalltrxn(Long authalltrxn) {
		this.authalltrxn = authalltrxn;
	}

	public Long getAuthalltrxnperiod() {
		return authalltrxnperiod;
	}

	public void setAuthalltrxnperiod(Long authalltrxnperiod) {
		this.authalltrxnperiod = authalltrxnperiod;
	}

	public Long getAuthcashlimit() {
		return authcashlimit;
	}

	public void setAuthcashlimit(Long authcashlimit) {
		this.authcashlimit = authcashlimit;
	}

	public Long getAuthshadowextracashlimit() {
		return authshadowextracashlimit;
	}

	public void setAuthshadowextracashlimit(Long authshadowextracashlimit) {
		this.authshadowextracashlimit = authshadowextracashlimit;
	}

	public Long getAuthcashtrxn() {
		return authcashtrxn;
	}

	public void setAuthcashtrxn(Long authcashtrxn) {
		this.authcashtrxn = authcashtrxn;
	}

	public Long getAuthcashperiod() {
		return authcashperiod;
	}

	public void setAuthcashperiod(Long authcashperiod) {
		this.authcashperiod = authcashperiod;
	}

	public Long getAuthtebonus() {
		return authtebonus;
	}

	public void setAuthtebonus(Long authtebonus) {
		this.authtebonus = authtebonus;
	}

	public Long getAuthtmpbonus() {
		return authtmpbonus;
	}

	public void setAuthtmpbonus(Long authtmpbonus) {
		this.authtmpbonus = authtmpbonus;
	}

	public Long getAuthtmpperiod() {
		return authtmpperiod;
	}

	public void setAuthtmpperiod(Long authtmpperiod) {
		this.authtmpperiod = authtmpperiod;
	}

	public Long getAuthtmpbonustrxns() {
		return authtmpbonustrxns;
	}

	public void setAuthtmpbonustrxns(Long authtmpbonustrxns) {
		this.authtmpbonustrxns = authtmpbonustrxns;
	}

	public Long getAuthtmpcashbonusamount() {
		return authtmpcashbonusamount;
	}

	public void setAuthtmpcashbonusamount(Long authtmpcashbonusamount) {
		this.authtmpcashbonusamount = authtmpcashbonusamount;
	}

	public Long getAuthtmpcashbonustrxns() {
		return authtmpcashbonustrxns;
	}

	public void setAuthtmpcashbonustrxns(Long authtmpcashbonustrxns) {
		this.authtmpcashbonustrxns = authtmpcashbonustrxns;
	}

	public Long getAuthtmpcashbonusperiod() {
		return authtmpcashbonusperiod;
	}

	public void setAuthtmpcashbonusperiod(Long authtmpcashbonusperiod) {
		this.authtmpcashbonusperiod = authtmpcashbonusperiod;
	}

	public Long getAuthusagecode() {
		return authusagecode;
	}

	public void setAuthusagecode(Long authusagecode) {
		this.authusagecode = authusagecode;
	}

	public Long getAuthdeclinetrxn() {
		return authdeclinetrxn;
	}

	public void setAuthdeclinetrxn(Long authdeclinetrxn) {
		this.authdeclinetrxn = authdeclinetrxn;
	}

	public Long getAuthdeclinelimit() {
		return authdeclinelimit;
	}

	public void setAuthdeclinelimit(Long authdeclinelimit) {
		this.authdeclinelimit = authdeclinelimit;
	}

	public Long getAuthdeclineperiod() {
		return authdeclineperiod;
	}

	public void setAuthdeclineperiod(Long authdeclineperiod) {
		this.authdeclineperiod = authdeclineperiod;
	}

	public Long getAuth1trxnlimit() {
		return auth1trxnlimit;
	}

	public void setAuth1trxnlimit(Long auth1trxnlimit) {
		this.auth1trxnlimit = auth1trxnlimit;
	}

	public Long getAuthblockedlimit() {
		return authblockedlimit;
	}

	public void setAuthblockedlimit(Long authblockedlimit) {
		this.authblockedlimit = authblockedlimit;
	}

	public Long getAuthaccounttype() {
		return authaccounttype;
	}

	public void setAuthaccounttype(Long authaccounttype) {
		this.authaccounttype = authaccounttype;
	}

	public Long getAuthmodeusage() {
		return authmodeusage;
	}

	public void setAuthmodeusage(Long authmodeusage) {
		this.authmodeusage = authmodeusage;
	}

	public Long getAuthdhprofserno() {
		return authdhprofserno;
	}

	public void setAuthdhprofserno(Long authdhprofserno) {
		this.authdhprofserno = authdhprofserno;
	}

	public Long getScorecardserno() {
		return scorecardserno;
	}

	public void setScorecardserno(Long scorecardserno) {
		this.scorecardserno = scorecardserno;
	}
}