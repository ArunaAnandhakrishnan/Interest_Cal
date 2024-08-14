package com.vernite.cal.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Trxntypes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serno;

	@OneToMany(mappedBy = "trxntypes", cascade = CascadeType.ALL)
	private List<Ctransactions> ctransactionsList;

	private Long institution_id;
	private String usedfor;
	private String rectype;
	private Long priority;
	private String condition;
	private Long channelserno;
	private String trxnstatus;
	private String trxngroup;
	private String sign;
	private Long cashflag;
	private Long options;
	private Long ignorevaluedate;
	private Long logversion;
	private Long instintprofserno;
	private Long instfeeprofserno;
	private Long destination_institution_id;
	private Long minpaypercentage;
	private Long gltrxntypeserno;
	private String textdatarule;
	private String descriptionrule;
	private Long descriptionstringid;
	private Long authmode;
	private Long sendtoonline;
	private Long defaultinteresttrxntype;
	private Long donotconsolidate;
	private Long suppressdisplay;

	public Long getSerno() {
		return serno;
	}

	public void setSerno(Long serno) {
		this.serno = serno;
	}

	public List<Ctransactions> getCtransactionsList() {
		return ctransactionsList;
	}

	public void setCtransactionsList(List<Ctransactions> ctransactionsList) {
		this.ctransactionsList = ctransactionsList;
	}

	public Long getInstitution_id() {
		return institution_id;
	}

	public void setInstitution_id(Long institution_id) {
		this.institution_id = institution_id;
	}

	public String getUsedfor() {
		return usedfor;
	}

	public void setUsedfor(String usedfor) {
		this.usedfor = usedfor;
	}

	public String getRectype() {
		return rectype;
	}

	public void setRectype(String rectype) {
		this.rectype = rectype;
	}

	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Long getChannelserno() {
		return channelserno;
	}

	public void setChannelserno(Long channelserno) {
		this.channelserno = channelserno;
	}

	public String getTrxnstatus() {
		return trxnstatus;
	}

	public void setTrxnstatus(String trxnstatus) {
		this.trxnstatus = trxnstatus;
	}

	public String getTrxngroup() {
		return trxngroup;
	}

	public void setTrxngroup(String trxngroup) {
		this.trxngroup = trxngroup;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Long getCashflag() {
		return cashflag;
	}

	public void setCashflag(Long cashflag) {
		this.cashflag = cashflag;
	}

	public Long getOptions() {
		return options;
	}

	public void setOptions(Long options) {
		this.options = options;
	}

	public Long getIgnorevaluedate() {
		return ignorevaluedate;
	}

	public void setIgnorevaluedate(Long ignorevaluedate) {
		this.ignorevaluedate = ignorevaluedate;
	}

	public Long getLogversion() {
		return logversion;
	}

	public void setLogversion(Long logversion) {
		this.logversion = logversion;
	}

	public Long getInstintprofserno() {
		return instintprofserno;
	}

	public void setInstintprofserno(Long instintprofserno) {
		this.instintprofserno = instintprofserno;
	}

	public Long getInstfeeprofserno() {
		return instfeeprofserno;
	}

	public void setInstfeeprofserno(Long instfeeprofserno) {
		this.instfeeprofserno = instfeeprofserno;
	}

	public Long getDestination_institution_id() {
		return destination_institution_id;
	}

	public void setDestination_institution_id(Long destination_institution_id) {
		this.destination_institution_id = destination_institution_id;
	}

	public Long getMinpaypercentage() {
		return minpaypercentage;
	}

	public void setMinpaypercentage(Long minpaypercentage) {
		this.minpaypercentage = minpaypercentage;
	}

	public Long getGltrxntypeserno() {
		return gltrxntypeserno;
	}

	public void setGltrxntypeserno(Long gltrxntypeserno) {
		this.gltrxntypeserno = gltrxntypeserno;
	}

	public String getTextdatarule() {
		return textdatarule;
	}

	public void setTextdatarule(String textdatarule) {
		this.textdatarule = textdatarule;
	}

	public String getDescriptionrule() {
		return descriptionrule;
	}

	public void setDescriptionrule(String descriptionrule) {
		this.descriptionrule = descriptionrule;
	}

	public Long getDescriptionstringid() {
		return descriptionstringid;
	}

	public void setDescriptionstringid(Long descriptionstringid) {
		this.descriptionstringid = descriptionstringid;
	}

	public Long getAuthmode() {
		return authmode;
	}

	public void setAuthmode(Long authmode) {
		this.authmode = authmode;
	}

	public Long getSendtoonline() {
		return sendtoonline;
	}

	public void setSendtoonline(Long sendtoonline) {
		this.sendtoonline = sendtoonline;
	}

	public Long getDefaultinteresttrxntype() {
		return defaultinteresttrxntype;
	}

	public void setDefaultinteresttrxntype(Long defaultinteresttrxntype) {
		this.defaultinteresttrxntype = defaultinteresttrxntype;
	}

	public Long getDonotconsolidate() {
		return donotconsolidate;
	}

	public void setDonotconsolidate(Long donotconsolidate) {
		this.donotconsolidate = donotconsolidate;
	}

	public Long getSuppressdisplay() {
		return suppressdisplay;
	}

	public void setSuppressdisplay(Long suppressdisplay) {
		this.suppressdisplay = suppressdisplay;
	}
}
