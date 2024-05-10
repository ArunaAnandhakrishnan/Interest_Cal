package com.vernite.cal.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class Cisotrxns {

	private Long institution_id;
	private Long partitionkey;
	private String source;
	private String i011_trace_num;
	private Timestamp i012_trxn_time;
	private Date i015_settle_date;
	private Date i016_convers_date;
	private Long i018_merch_type;
	private Long i019_acq_country;
	private String i022_pos_entry;
	private Long i023_sequence;
	private Long i024_funct_code;
	private Long i025_pos_cond;
	private Long i028_trxn_fee;
	private Long i031_arn;
	private String i032_acquirer_id;
	private Long i037_ret_ref_num;
	private String i038_auth_id;
	private String i039_resp_cd;
	private String i041_pos_id;
	private String i042_merch_id;
	private String i043a_merch_name;
	private String i043b_merch_city;
	private String i043c_merch_cnt;
	private String i059_pos_geo_data;
	private String i060_pos_cap;
	private String i062v2_trans_id;
	private String i062m_inf_data;
	private Long cashbackamount;
	private BigDecimal psvatamount;
	private Long trxnentry;
	private Long trxnqualifier;
	private String trxnmsgidentifier;
	private String summcomcode;
	private String paymentmode;
	private String offlineauthflag;
	private Date authtrxntype;
	private Date authserno;
	private Long authpartitionkey;
	private Date authreasoncode;
	private String authresponsedescription;
	private String authreasondescription;
	private String acqcountrycode;
	private String acqregion;
	private String productcode;
	private String fuelacceptancemode;
	private Long units;
	private String unitofmeasure;
	private Long unitprice;
	private String fleetnumber;
	private String fleetbrand;
	private Long lineitemind;
	private Long finallineitemind;
	private Long liorigtrxnamount;
	private String feeprogramind;
	private String interchangefeeind;
	private Long interchangefeeamount;
	private Float sourcetobaseexrate;
	private Float basetodestexrate;
	private String interchangefeecurrency;
	private String multipleclearingind;
	private String token;
	private String tokenassurancelevel;
	private String tokenrequestorid;
	private String walletidentifier;
	private Long converted;

	public Long getInstitution_id() {
		return institution_id;
	}

	public Long getPartitionkey() {
		return partitionkey;
	}

	public String getSource() {
		return source;
	}

	public String getI011_trace_num() {
		return i011_trace_num;
	}

	public Timestamp getI012_trxn_time() {
		return i012_trxn_time;
	}

	public Date getI015_settle_date() {
		return i015_settle_date;
	}

	public Date getI016_convers_date() {
		return i016_convers_date;
	}

	public Long getI018_merch_type() {
		return i018_merch_type;
	}

	public Long getI019_acq_country() {
		return i019_acq_country;
	}

	public String getI022_pos_entry() {
		return i022_pos_entry;
	}

	public Long getI023_sequence() {
		return i023_sequence;
	}

	public Long getI024_funct_code() {
		return i024_funct_code;
	}

	public Long getI025_pos_cond() {
		return i025_pos_cond;
	}

	public Long getI028_trxn_fee() {
		return i028_trxn_fee;
	}

	public Long getI031_arn() {
		return i031_arn;
	}

	public String getI032_acquirer_id() {
		return i032_acquirer_id;
	}

	public Long getI037_ret_ref_num() {
		return i037_ret_ref_num;
	}

	public String getI038_auth_id() {
		return i038_auth_id;
	}

	public String getI039_resp_cd() {
		return i039_resp_cd;
	}

	public String getI041_pos_id() {
		return i041_pos_id;
	}

	public String getI042_merch_id() {
		return i042_merch_id;
	}

	public String getI043a_merch_name() {
		return i043a_merch_name;
	}

	public String getI043b_merch_city() {
		return i043b_merch_city;
	}

	public String getI043c_merch_cnt() {
		return i043c_merch_cnt;
	}

	public String getI059_pos_geo_data() {
		return i059_pos_geo_data;
	}

	public String getI060_pos_cap() {
		return i060_pos_cap;
	}

	public String getI062v2_trans_id() {
		return i062v2_trans_id;
	}

	public String getI062m_inf_data() {
		return i062m_inf_data;
	}

	public Long getCashbackamount() {
		return cashbackamount;
	}

	public BigDecimal getPsvatamount() {
		return psvatamount;
	}

	public Long getTrxnentry() {
		return trxnentry;
	}

	public Long getTrxnqualifier() {
		return trxnqualifier;
	}

	public String getTrxnmsgidentifier() {
		return trxnmsgidentifier;
	}

	public String getSummcomcode() {
		return summcomcode;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public String getOfflineauthflag() {
		return offlineauthflag;
	}

	public Date getAuthtrxntype() {
		return authtrxntype;
	}

	public Date getAuthserno() {
		return authserno;
	}

	public Long getAuthpartitionkey() {
		return authpartitionkey;
	}

	public Date getAuthreasoncode() {
		return authreasoncode;
	}

	public String getAuthresponsedescription() {
		return authresponsedescription;
	}

	public String getAuthreasondescription() {
		return authreasondescription;
	}

	public String getAcqcountrycode() {
		return acqcountrycode;
	}

	public String getAcqregion() {
		return acqregion;
	}

	public String getProductcode() {
		return productcode;
	}

	public String getFuelacceptancemode() {
		return fuelacceptancemode;
	}

	public Long getUnits() {
		return units;
	}

	public String getUnitofmeasure() {
		return unitofmeasure;
	}

	public Long getUnitprice() {
		return unitprice;
	}

	public String getFleetnumber() {
		return fleetnumber;
	}

	public String getFleetbrand() {
		return fleetbrand;
	}

	public Long getLineitemind() {
		return lineitemind;
	}

	public Long getFinallineitemind() {
		return finallineitemind;
	}

	public Long getLiorigtrxnamount() {
		return liorigtrxnamount;
	}

	public String getFeeprogramind() {
		return feeprogramind;
	}

	public String getInterchangefeeind() {
		return interchangefeeind;
	}

	public Long getInterchangefeeamount() {
		return interchangefeeamount;
	}

	public Float getSourcetobaseexrate() {
		return sourcetobaseexrate;
	}

	public Float getBasetodestexrate() {
		return basetodestexrate;
	}

	public String getInterchangefeecurrency() {
		return interchangefeecurrency;
	}

	public String getMultipleclearingind() {
		return multipleclearingind;
	}

	public String getToken() {
		return token;
	}

	public String getTokenassurancelevel() {
		return tokenassurancelevel;
	}

	public String getTokenrequestorid() {
		return tokenrequestorid;
	}

	public String getWalletidentifier() {
		return walletidentifier;
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

	public void setSource(String source) {
		this.source = source;
	}

	public void setI011_trace_num(String i011_trace_num) {
		this.i011_trace_num = i011_trace_num;
	}

	public void setI012_trxn_time(Timestamp i012_trxn_time) {
		this.i012_trxn_time = i012_trxn_time;
	}

	public void setI015_settle_date(Date i015_settle_date) {
		this.i015_settle_date = i015_settle_date;
	}

	public void setI016_convers_date(Date i016_convers_date) {
		this.i016_convers_date = i016_convers_date;
	}

	public void setI018_merch_type(Long i018_merch_type) {
		this.i018_merch_type = i018_merch_type;
	}

	public void setI019_acq_country(Long i019_acq_country) {
		this.i019_acq_country = i019_acq_country;
	}

	public void setI022_pos_entry(String i022_pos_entry) {
		this.i022_pos_entry = i022_pos_entry;
	}

	public void setI023_sequence(Long i023_sequence) {
		this.i023_sequence = i023_sequence;
	}

	public void setI024_funct_code(Long i024_funct_code) {
		this.i024_funct_code = i024_funct_code;
	}

	public void setI025_pos_cond(Long i025_pos_cond) {
		this.i025_pos_cond = i025_pos_cond;
	}

	public void setI028_trxn_fee(Long i028_trxn_fee) {
		this.i028_trxn_fee = i028_trxn_fee;
	}

	public void setI031_arn(Long i031_arn) {
		this.i031_arn = i031_arn;
	}

	public void setI032_acquirer_id(String i032_acquirer_id) {
		this.i032_acquirer_id = i032_acquirer_id;
	}

	public void setI037_ret_ref_num(Long i037_ret_ref_num) {
		this.i037_ret_ref_num = i037_ret_ref_num;
	}

	public void setI038_auth_id(String i038_auth_id) {
		this.i038_auth_id = i038_auth_id;
	}

	public void setI039_resp_cd(String i039_resp_cd) {
		this.i039_resp_cd = i039_resp_cd;
	}

	public void setI041_pos_id(String i041_pos_id) {
		this.i041_pos_id = i041_pos_id;
	}

	public void setI042_merch_id(String i042_merch_id) {
		this.i042_merch_id = i042_merch_id;
	}

	public void setI043a_merch_name(String i043a_merch_name) {
		this.i043a_merch_name = i043a_merch_name;
	}

	public void setI043b_merch_city(String i043b_merch_city) {
		this.i043b_merch_city = i043b_merch_city;
	}

	public void setI043c_merch_cnt(String i043c_merch_cnt) {
		this.i043c_merch_cnt = i043c_merch_cnt;
	}

	public void setI059_pos_geo_data(String i059_pos_geo_data) {
		this.i059_pos_geo_data = i059_pos_geo_data;
	}

	public void setI060_pos_cap(String i060_pos_cap) {
		this.i060_pos_cap = i060_pos_cap;
	}

	public void setI062v2_trans_id(String i062v2_trans_id) {
		this.i062v2_trans_id = i062v2_trans_id;
	}

	public void setI062m_inf_data(String i062m_inf_data) {
		this.i062m_inf_data = i062m_inf_data;
	}

	public void setCashbackamount(Long cashbackamount) {
		this.cashbackamount = cashbackamount;
	}

	public void setPsvatamount(BigDecimal psvatamount) {
		this.psvatamount = psvatamount;
	}

	public void setTrxnentry(Long trxnentry) {
		this.trxnentry = trxnentry;
	}

	public void setTrxnqualifier(Long trxnqualifier) {
		this.trxnqualifier = trxnqualifier;
	}

	public void setTrxnmsgidentifier(String trxnmsgidentifier) {
		this.trxnmsgidentifier = trxnmsgidentifier;
	}

	public void setSummcomcode(String summcomcode) {
		this.summcomcode = summcomcode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	public void setOfflineauthflag(String offlineauthflag) {
		this.offlineauthflag = offlineauthflag;
	}

	public void setAuthtrxntype(Date authtrxntype) {
		this.authtrxntype = authtrxntype;
	}

	public void setAuthserno(Date authserno) {
		this.authserno = authserno;
	}

	public void setAuthpartitionkey(Long authpartitionkey) {
		this.authpartitionkey = authpartitionkey;
	}

	public void setAuthreasoncode(Date authreasoncode) {
		this.authreasoncode = authreasoncode;
	}

	public void setAuthresponsedescription(String authresponsedescription) {
		this.authresponsedescription = authresponsedescription;
	}

	public void setAuthreasondescription(String authreasondescription) {
		this.authreasondescription = authreasondescription;
	}

	public void setAcqcountrycode(String acqcountrycode) {
		this.acqcountrycode = acqcountrycode;
	}

	public void setAcqregion(String acqregion) {
		this.acqregion = acqregion;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public void setFuelacceptancemode(String fuelacceptancemode) {
		this.fuelacceptancemode = fuelacceptancemode;
	}

	public void setUnits(Long units) {
		this.units = units;
	}

	public void setUnitofmeasure(String unitofmeasure) {
		this.unitofmeasure = unitofmeasure;
	}

	public void setUnitprice(Long unitprice) {
		this.unitprice = unitprice;
	}

	public void setFleetnumber(String fleetnumber) {
		this.fleetnumber = fleetnumber;
	}

	public void setFleetbrand(String fleetbrand) {
		this.fleetbrand = fleetbrand;
	}

	public void setLineitemind(Long lineitemind) {
		this.lineitemind = lineitemind;
	}

	public void setFinallineitemind(Long finallineitemind) {
		this.finallineitemind = finallineitemind;
	}

	public void setLiorigtrxnamount(Long liorigtrxnamount) {
		this.liorigtrxnamount = liorigtrxnamount;
	}

	public void setFeeprogramind(String feeprogramind) {
		this.feeprogramind = feeprogramind;
	}

	public void setInterchangefeeind(String interchangefeeind) {
		this.interchangefeeind = interchangefeeind;
	}

	public void setInterchangefeeamount(Long interchangefeeamount) {
		this.interchangefeeamount = interchangefeeamount;
	}

	public void setSourcetobaseexrate(Float sourcetobaseexrate) {
		this.sourcetobaseexrate = sourcetobaseexrate;
	}

	public void setBasetodestexrate(Float basetodestexrate) {
		this.basetodestexrate = basetodestexrate;
	}

	public void setInterchangefeecurrency(String interchangefeecurrency) {
		this.interchangefeecurrency = interchangefeecurrency;
	}

	public void setMultipleclearingind(String multipleclearingind) {
		this.multipleclearingind = multipleclearingind;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setTokenassurancelevel(String tokenassurancelevel) {
		this.tokenassurancelevel = tokenassurancelevel;
	}

	public void setTokenrequestorid(String tokenrequestorid) {
		this.tokenrequestorid = tokenrequestorid;
	}

	public void setWalletidentifier(String walletidentifier) {
		this.walletidentifier = walletidentifier;
	}

	public void setConverted(Long converted) {
		this.converted = converted;
	}

}
