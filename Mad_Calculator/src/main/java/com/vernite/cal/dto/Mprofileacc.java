package com.vernite.cal.dto;

import java.math.BigDecimal;
import java.util.Date;

public class Mprofileacc {

	private Long institution_id;
	// serno NUMBER(10) not null,
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
	private String currency;
	private BigDecimal creditlimit;
	private Long allocprofserno;
	private Long feeprofserno;
	private Long trxnfeeprofserno;
	private Long instprofserno;
	private Long rewardprofserno;
	private Long caprofserno;
	// private Long stmtprofserno;
	private Long enablediversion;
	private Long enablerewarddiversion;
	private BigDecimal lmaxaggcl;
	private String stgeneral;
	private Long holidaytableserno;
	private String bankname;
	private String bankaccount;
	private String banksortcode;
	private String bankbranch;
	private String bankaccname;
	private String bankacccountry;
	private Long bankddenabled;
	private BigDecimal bankddamount;
	private BigDecimal bankddpercentage;
	private Long bankddcombination;
	private String paymentmethod;
	private Long statementinstalmentsallowed;
	private Long statementinstalmentsmaxnum;
	private Long mbhindicator;
	private String mbhnocontractindstatus;
	private String mbhexpiredstatus;
	private Long mbhagreementexpiryperiod;
	private Long mbhagreementrenbefexpperiod;
	private BigDecimal mbhagreementprofitrate;
	private Long mbhagreementprofitrateperiod;
	private String embcompanyname;
	private Long sendtovcf;
	private Long defineriskdomain;
	private Long makeauthgroups;
	private String authcurrency;
	private BigDecimal authlimit;
	private BigDecimal authshadowextralimit;
	private Long authlimitperiod;
	private BigDecimal extraauthlimit;
	private Long authalltrxn;
	private Long authalltrxnperiod;
	private BigDecimal authcashlimit;
	private BigDecimal authshadowextracashlimit;
	private Long authcashtrxn;
	private Long authcashperiod;
	private BigDecimal authtebonus;
	private BigDecimal authtmpbonus;
	private Long authtmpperiod;
	private Long authtmpbonustrxns;
	private BigDecimal authtmpcashbonusamount;
	private Long authtmpcashbonustrxns;
	private Long authtmpcashbonusperiod;
	private Long authusagecode;
	private Long authdeclinetrxn;
	private BigDecimal authdeclinelimit;
	private Long authdeclineperiod;
	private BigDecimal auth1trxnlimit;
	private BigDecimal authblockedlimit;
	private String authaccounttype;
	private Long authmodeusage;
	private Long authdhprofserno;
	private Long scorecardserno;

	public Long getInstitution_id() {
		return institution_id;
	}

	public Long getLeveldepth() {
		return leveldepth;
	}

	public String getLevellabel() {
		return levellabel;
	}

	public String getLevelparentlabel() {
		return levelparentlabel;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public Long getRealflag() {
		return realflag;
	}

	public String getExcludefromprobe() {
		return excludefromprobe;
	}

	public Long getCorpmodel() {
		return corpmodel;
	}

	public Long getMemomodel() {
		return memomodel;
	}

	public Date getValidfrom() {
		return validfrom;
	}

	public Date getValiduntil() {
		return validuntil;
	}

	public Long getChildaccmasterprofileserno() {
		return childaccmasterprofileserno;
	}

	public Long getChildcardmasterprofileserno() {
		return childcardmasterprofileserno;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public String getBillingmethod() {
		return billingmethod;
	}

	public Long getDailyaccrualflag() {
		return dailyaccrualflag;
	}

	public Long getServiceperiod() {
		return serviceperiod;
	}

	public Long getNextmasterprofile() {
		return nextmasterprofile;
	}

	public Long getPrevmasterprofile() {
		return prevmasterprofile;
	}

	public Long getPropagatechanges() {
		return propagatechanges;
	}

	public String getNumbergeneration() {
		return numbergeneration;
	}

	public String getNumbergenformat() {
		return numbergenformat;
	}

	public String getCurrency() {
		return currency;
	}

	public BigDecimal getCreditlimit() {
		return creditlimit;
	}

	public Long getAllocprofserno() {
		return allocprofserno;
	}

	public Long getFeeprofserno() {
		return feeprofserno;
	}

	public Long getTrxnfeeprofserno() {
		return trxnfeeprofserno;
	}

	public Long getInstprofserno() {
		return instprofserno;
	}

	public Long getRewardprofserno() {
		return rewardprofserno;
	}

	public Long getCaprofserno() {
		return caprofserno;
	}

	public Long getEnablediversion() {
		return enablediversion;
	}

	public Long getEnablerewarddiversion() {
		return enablerewarddiversion;
	}

	public BigDecimal getLmaxaggcl() {
		return lmaxaggcl;
	}

	public String getStgeneral() {
		return stgeneral;
	}

	public Long getHolidaytableserno() {
		return holidaytableserno;
	}

	public String getBankname() {
		return bankname;
	}

	public String getBankaccount() {
		return bankaccount;
	}

	public String getBanksortcode() {
		return banksortcode;
	}

	public String getBankbranch() {
		return bankbranch;
	}

	public String getBankaccname() {
		return bankaccname;
	}

	public String getBankacccountry() {
		return bankacccountry;
	}

	public Long getBankddenabled() {
		return bankddenabled;
	}

	public BigDecimal getBankddamount() {
		return bankddamount;
	}

	public BigDecimal getBankddpercentage() {
		return bankddpercentage;
	}

	public Long getBankddcombination() {
		return bankddcombination;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public Long getStatementinstalmentsallowed() {
		return statementinstalmentsallowed;
	}

	public Long getStatementinstalmentsmaxnum() {
		return statementinstalmentsmaxnum;
	}

	public Long getMbhindicator() {
		return mbhindicator;
	}

	public String getMbhnocontractindstatus() {
		return mbhnocontractindstatus;
	}

	public String getMbhexpiredstatus() {
		return mbhexpiredstatus;
	}

	public Long getMbhagreementexpiryperiod() {
		return mbhagreementexpiryperiod;
	}

	public Long getMbhagreementrenbefexpperiod() {
		return mbhagreementrenbefexpperiod;
	}

	public BigDecimal getMbhagreementprofitrate() {
		return mbhagreementprofitrate;
	}

	public Long getMbhagreementprofitrateperiod() {
		return mbhagreementprofitrateperiod;
	}

	public String getEmbcompanyname() {
		return embcompanyname;
	}

	public Long getSendtovcf() {
		return sendtovcf;
	}

	public Long getDefineriskdomain() {
		return defineriskdomain;
	}

	public Long getMakeauthgroups() {
		return makeauthgroups;
	}

	public String getAuthcurrency() {
		return authcurrency;
	}

	public BigDecimal getAuthlimit() {
		return authlimit;
	}

	public BigDecimal getAuthshadowextralimit() {
		return authshadowextralimit;
	}

	public Long getAuthlimitperiod() {
		return authlimitperiod;
	}

	public BigDecimal getExtraauthlimit() {
		return extraauthlimit;
	}

	public Long getAuthalltrxn() {
		return authalltrxn;
	}

	public Long getAuthalltrxnperiod() {
		return authalltrxnperiod;
	}

	public BigDecimal getAuthcashlimit() {
		return authcashlimit;
	}

	public BigDecimal getAuthshadowextracashlimit() {
		return authshadowextracashlimit;
	}

	public Long getAuthcashtrxn() {
		return authcashtrxn;
	}

	public Long getAuthcashperiod() {
		return authcashperiod;
	}

	public BigDecimal getAuthtebonus() {
		return authtebonus;
	}

	public BigDecimal getAuthtmpbonus() {
		return authtmpbonus;
	}

	public Long getAuthtmpperiod() {
		return authtmpperiod;
	}

	public Long getAuthtmpbonustrxns() {
		return authtmpbonustrxns;
	}

	public BigDecimal getAuthtmpcashbonusamount() {
		return authtmpcashbonusamount;
	}

	public Long getAuthtmpcashbonustrxns() {
		return authtmpcashbonustrxns;
	}

	public Long getAuthtmpcashbonusperiod() {
		return authtmpcashbonusperiod;
	}

	public Long getAuthusagecode() {
		return authusagecode;
	}

	public Long getAuthdeclinetrxn() {
		return authdeclinetrxn;
	}

	public BigDecimal getAuthdeclinelimit() {
		return authdeclinelimit;
	}

	public Long getAuthdeclineperiod() {
		return authdeclineperiod;
	}

	public BigDecimal getAuth1trxnlimit() {
		return auth1trxnlimit;
	}

	public BigDecimal getAuthblockedlimit() {
		return authblockedlimit;
	}

	public String getAuthaccounttype() {
		return authaccounttype;
	}

	public Long getAuthmodeusage() {
		return authmodeusage;
	}

	public Long getAuthdhprofserno() {
		return authdhprofserno;
	}

	public Long getScorecardserno() {
		return scorecardserno;
	}

	public void setInstitution_id(Long institution_id) {
		this.institution_id = institution_id;
	}

	public void setLeveldepth(Long leveldepth) {
		this.leveldepth = leveldepth;
	}

	public void setLevellabel(String levellabel) {
		this.levellabel = levellabel;
	}

	public void setLevelparentlabel(String levelparentlabel) {
		this.levelparentlabel = levelparentlabel;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setRealflag(Long realflag) {
		this.realflag = realflag;
	}

	public void setExcludefromprobe(String excludefromprobe) {
		this.excludefromprobe = excludefromprobe;
	}

	public void setCorpmodel(Long corpmodel) {
		this.corpmodel = corpmodel;
	}

	public void setMemomodel(Long memomodel) {
		this.memomodel = memomodel;
	}

	public void setValidfrom(Date validfrom) {
		this.validfrom = validfrom;
	}

	public void setValiduntil(Date validuntil) {
		this.validuntil = validuntil;
	}

	public void setChildaccmasterprofileserno(Long childaccmasterprofileserno) {
		this.childaccmasterprofileserno = childaccmasterprofileserno;
	}

	public void setChildcardmasterprofileserno(Long childcardmasterprofileserno) {
		this.childcardmasterprofileserno = childcardmasterprofileserno;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public void setBillingmethod(String billingmethod) {
		this.billingmethod = billingmethod;
	}

	public void setDailyaccrualflag(Long dailyaccrualflag) {
		this.dailyaccrualflag = dailyaccrualflag;
	}

	public void setServiceperiod(Long serviceperiod) {
		this.serviceperiod = serviceperiod;
	}

	public void setNextmasterprofile(Long nextmasterprofile) {
		this.nextmasterprofile = nextmasterprofile;
	}

	public void setPrevmasterprofile(Long prevmasterprofile) {
		this.prevmasterprofile = prevmasterprofile;
	}

	public void setPropagatechanges(Long propagatechanges) {
		this.propagatechanges = propagatechanges;
	}

	public void setNumbergeneration(String numbergeneration) {
		this.numbergeneration = numbergeneration;
	}

	public void setNumbergenformat(String numbergenformat) {
		this.numbergenformat = numbergenformat;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setCreditlimit(BigDecimal creditlimit) {
		this.creditlimit = creditlimit;
	}

	public void setAllocprofserno(Long allocprofserno) {
		this.allocprofserno = allocprofserno;
	}

	public void setFeeprofserno(Long feeprofserno) {
		this.feeprofserno = feeprofserno;
	}

	public void setTrxnfeeprofserno(Long trxnfeeprofserno) {
		this.trxnfeeprofserno = trxnfeeprofserno;
	}

	public void setInstprofserno(Long instprofserno) {
		this.instprofserno = instprofserno;
	}

	public void setRewardprofserno(Long rewardprofserno) {
		this.rewardprofserno = rewardprofserno;
	}

	public void setCaprofserno(Long caprofserno) {
		this.caprofserno = caprofserno;
	}

	public void setEnablediversion(Long enablediversion) {
		this.enablediversion = enablediversion;
	}

	public void setEnablerewarddiversion(Long enablerewarddiversion) {
		this.enablerewarddiversion = enablerewarddiversion;
	}

	public void setLmaxaggcl(BigDecimal lmaxaggcl) {
		this.lmaxaggcl = lmaxaggcl;
	}

	public void setStgeneral(String stgeneral) {
		this.stgeneral = stgeneral;
	}

	public void setHolidaytableserno(Long holidaytableserno) {
		this.holidaytableserno = holidaytableserno;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}

	public void setBanksortcode(String banksortcode) {
		this.banksortcode = banksortcode;
	}

	public void setBankbranch(String bankbranch) {
		this.bankbranch = bankbranch;
	}

	public void setBankaccname(String bankaccname) {
		this.bankaccname = bankaccname;
	}

	public void setBankacccountry(String bankacccountry) {
		this.bankacccountry = bankacccountry;
	}

	public void setBankddenabled(Long bankddenabled) {
		this.bankddenabled = bankddenabled;
	}

	public void setBankddamount(BigDecimal bankddamount) {
		this.bankddamount = bankddamount;
	}

	public void setBankddpercentage(BigDecimal bankddpercentage) {
		this.bankddpercentage = bankddpercentage;
	}

	public void setBankddcombination(Long bankddcombination) {
		this.bankddcombination = bankddcombination;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public void setStatementinstalmentsallowed(Long statementinstalmentsallowed) {
		this.statementinstalmentsallowed = statementinstalmentsallowed;
	}

	public void setStatementinstalmentsmaxnum(Long statementinstalmentsmaxnum) {
		this.statementinstalmentsmaxnum = statementinstalmentsmaxnum;
	}

	public void setMbhindicator(Long mbhindicator) {
		this.mbhindicator = mbhindicator;
	}

	public void setMbhnocontractindstatus(String mbhnocontractindstatus) {
		this.mbhnocontractindstatus = mbhnocontractindstatus;
	}

	public void setMbhexpiredstatus(String mbhexpiredstatus) {
		this.mbhexpiredstatus = mbhexpiredstatus;
	}

	public void setMbhagreementexpiryperiod(Long mbhagreementexpiryperiod) {
		this.mbhagreementexpiryperiod = mbhagreementexpiryperiod;
	}

	public void setMbhagreementrenbefexpperiod(Long mbhagreementrenbefexpperiod) {
		this.mbhagreementrenbefexpperiod = mbhagreementrenbefexpperiod;
	}

	public void setMbhagreementprofitrate(BigDecimal mbhagreementprofitrate) {
		this.mbhagreementprofitrate = mbhagreementprofitrate;
	}

	public void setMbhagreementprofitrateperiod(Long mbhagreementprofitrateperiod) {
		this.mbhagreementprofitrateperiod = mbhagreementprofitrateperiod;
	}

	public void setEmbcompanyname(String embcompanyname) {
		this.embcompanyname = embcompanyname;
	}

	public void setSendtovcf(Long sendtovcf) {
		this.sendtovcf = sendtovcf;
	}

	public void setDefineriskdomain(Long defineriskdomain) {
		this.defineriskdomain = defineriskdomain;
	}

	public void setMakeauthgroups(Long makeauthgroups) {
		this.makeauthgroups = makeauthgroups;
	}

	public void setAuthcurrency(String authcurrency) {
		this.authcurrency = authcurrency;
	}

	public void setAuthlimit(BigDecimal authlimit) {
		this.authlimit = authlimit;
	}

	public void setAuthshadowextralimit(BigDecimal authshadowextralimit) {
		this.authshadowextralimit = authshadowextralimit;
	}

	public void setAuthlimitperiod(Long authlimitperiod) {
		this.authlimitperiod = authlimitperiod;
	}

	public void setExtraauthlimit(BigDecimal extraauthlimit) {
		this.extraauthlimit = extraauthlimit;
	}

	public void setAuthalltrxn(Long authalltrxn) {
		this.authalltrxn = authalltrxn;
	}

	public void setAuthalltrxnperiod(Long authalltrxnperiod) {
		this.authalltrxnperiod = authalltrxnperiod;
	}

	public void setAuthcashlimit(BigDecimal authcashlimit) {
		this.authcashlimit = authcashlimit;
	}

	public void setAuthshadowextracashlimit(BigDecimal authshadowextracashlimit) {
		this.authshadowextracashlimit = authshadowextracashlimit;
	}

	public void setAuthcashtrxn(Long authcashtrxn) {
		this.authcashtrxn = authcashtrxn;
	}

	public void setAuthcashperiod(Long authcashperiod) {
		this.authcashperiod = authcashperiod;
	}

	public void setAuthtebonus(BigDecimal authtebonus) {
		this.authtebonus = authtebonus;
	}

	public void setAuthtmpbonus(BigDecimal authtmpbonus) {
		this.authtmpbonus = authtmpbonus;
	}

	public void setAuthtmpperiod(Long authtmpperiod) {
		this.authtmpperiod = authtmpperiod;
	}

	public void setAuthtmpbonustrxns(Long authtmpbonustrxns) {
		this.authtmpbonustrxns = authtmpbonustrxns;
	}

	public void setAuthtmpcashbonusamount(BigDecimal authtmpcashbonusamount) {
		this.authtmpcashbonusamount = authtmpcashbonusamount;
	}

	public void setAuthtmpcashbonustrxns(Long authtmpcashbonustrxns) {
		this.authtmpcashbonustrxns = authtmpcashbonustrxns;
	}

	public void setAuthtmpcashbonusperiod(Long authtmpcashbonusperiod) {
		this.authtmpcashbonusperiod = authtmpcashbonusperiod;
	}

	public void setAuthusagecode(Long authusagecode) {
		this.authusagecode = authusagecode;
	}

	public void setAuthdeclinetrxn(Long authdeclinetrxn) {
		this.authdeclinetrxn = authdeclinetrxn;
	}

	public void setAuthdeclinelimit(BigDecimal authdeclinelimit) {
		this.authdeclinelimit = authdeclinelimit;
	}

	public void setAuthdeclineperiod(Long authdeclineperiod) {
		this.authdeclineperiod = authdeclineperiod;
	}

	public void setAuth1trxnlimit(BigDecimal auth1trxnlimit) {
		this.auth1trxnlimit = auth1trxnlimit;
	}

	public void setAuthblockedlimit(BigDecimal authblockedlimit) {
		this.authblockedlimit = authblockedlimit;
	}

	public void setAuthaccounttype(String authaccounttype) {
		this.authaccounttype = authaccounttype;
	}

	public void setAuthmodeusage(Long authmodeusage) {
		this.authmodeusage = authmodeusage;
	}

	public void setAuthdhprofserno(Long authdhprofserno) {
		this.authdhprofserno = authdhprofserno;
	}

	public void setScorecardserno(Long scorecardserno) {
		this.scorecardserno = scorecardserno;
	}

}
