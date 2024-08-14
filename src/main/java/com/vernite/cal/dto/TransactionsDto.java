package com.vernite.cal.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionsDto {

	private Long institution_id;
	// private Integer serno NUMBER(10) not null,
	private Long partitionkey;
//	private Long caccserno;
	private Long cardserno;
	private Long def_caccserno;
	private String product;
	private String batchserno;
	// private String typeserno_alloc;
	private String typeserno_fees;
	private Long typeserno_reports;
	private Long typeserno_rewards;
	private Long typeserno_gledger;
	private Long typeserno_divert;
	private Long typeserno_nopost;
	private Long typeserno_probe;
	private Long typeserno_text;
	private Long msgclass;
	private Long msgtype;
	private Long trxntype;
	private String orig_msg_type;
	private String i000_msg_type;
	private String i002_number;
	private String i003_proc_code;
	private Long i004_amt_trxn;
	private Long i005_amt_settle;
	private BigDecimal i006_amt_bill;
	private Date i007_load_date;
	private Long i008_billing_fee;
	private String i013_trxn_date;
	private String i044_reason_code;
	private String i048_text_data;
	private Long i049_cur_trxn;
	private Long i050_cur_settle;
	private Long i051_cur_bill;
	private Long centercurrency;
	private Long centeramount;
	private Long instalmenttype;
	private Long instalmentindepflag;
	private Long instalmentsnumber;
	private Long instalmentseq;
	private Long instalmentrepaymenttype;
	private String instalmentoffset;
	private Long instalmentorigamount;
	private Long instalmenttotalamount;
	private String instalmentplanserno;
	private Date instalmentinterestanchordate;
	private Long instalmentserno;
	private Long instalmentpartitionkey;
	private Long instalmentamrtprincipalamount;
	private Long instalmentpaymentallocation;
	private Long instalmentpostindicator;
	private Long mbhagreementserno;
	private String consolidationkey;
	private Long ofstmtorinvoiceserno;
	private Long ofstmtorinvoicepartitionkey;
	private Date ofstmtdate;
	private Date ofprintduedate;
	private Date ofduedate;
	private Date ofoverduestmtdate;
	private String ofrectype;
	private Long oftrxntype;
	private Long rewardsflag;
	private String rewardbalancereasoncode;
	private Long single_msg_flag;
	private String authimmediateposting;
	private Long authaccounttype;
	private Long authamount;
	private String originator;
	private String originatorreasoncode;
	private String proxycardnumber;
	private String invoicenumber;
	private Long amount;
	private Long embeddedfee;
	private Long totalpoints;
	private Long totalrebates;
	private String taxflag;
	private Long taxbaseamount;
	private Date valuedate;
	private Date startofinterest;
	private Date minduevaluedate;
	private Date postdate;
	private String posttimestamp;
	private String textdescription;
	private String fgresolutionstatus;
	private String externaltrxnid;
	private String stgeneral;
	private String logaction;
	private Long recalculated;
	private Long converted;

	public Long getInstitution_id() {
		return institution_id;
	}

	public Long getPartitionkey() {
		return partitionkey;
	}

	public Long getCardserno() {
		return cardserno;
	}

	public Long getDef_caccserno() {
		return def_caccserno;
	}

	public String getProduct() {
		return product;
	}

	public String getBatchserno() {
		return batchserno;
	}

	public String getTypeserno_fees() {
		return typeserno_fees;
	}

	public Long getTypeserno_reports() {
		return typeserno_reports;
	}

	public Long getTypeserno_rewards() {
		return typeserno_rewards;
	}

	public Long getTypeserno_gledger() {
		return typeserno_gledger;
	}

	public Long getTypeserno_divert() {
		return typeserno_divert;
	}

	public Long getTypeserno_nopost() {
		return typeserno_nopost;
	}

	public Long getTypeserno_probe() {
		return typeserno_probe;
	}

	public Long getTypeserno_text() {
		return typeserno_text;
	}

	public Long getMsgclass() {
		return msgclass;
	}

	public Long getMsgtype() {
		return msgtype;
	}

	public Long getTrxntype() {
		return trxntype;
	}

	public String getOrig_msg_type() {
		return orig_msg_type;
	}

	public String getI000_msg_type() {
		return i000_msg_type;
	}

	public String getI002_number() {
		return i002_number;
	}

	public String getI003_proc_code() {
		return i003_proc_code;
	}

	public Long getI004_amt_trxn() {
		return i004_amt_trxn;
	}

	public Long getI005_amt_settle() {
		return i005_amt_settle;
	}

	public Date getI007_load_date() {
		return i007_load_date;
	}

	public Long getI008_billing_fee() {
		return i008_billing_fee;
	}

	public String getI013_trxn_date() {
		return i013_trxn_date;
	}

	public String getI044_reason_code() {
		return i044_reason_code;
	}

	public String getI048_text_data() {
		return i048_text_data;
	}

	public Long getI049_cur_trxn() {
		return i049_cur_trxn;
	}

	public Long getI050_cur_settle() {
		return i050_cur_settle;
	}

	public Long getI051_cur_bill() {
		return i051_cur_bill;
	}

	public Long getCentercurrency() {
		return centercurrency;
	}

	public Long getCenteramount() {
		return centeramount;
	}

	public Long getInstalmenttype() {
		return instalmenttype;
	}

	public Long getInstalmentindepflag() {
		return instalmentindepflag;
	}

	public Long getInstalmentsnumber() {
		return instalmentsnumber;
	}

	public Long getInstalmentseq() {
		return instalmentseq;
	}

	public Long getInstalmentrepaymenttype() {
		return instalmentrepaymenttype;
	}

	public String getInstalmentoffset() {
		return instalmentoffset;
	}

	public Long getInstalmentorigamount() {
		return instalmentorigamount;
	}

	public Long getInstalmenttotalamount() {
		return instalmenttotalamount;
	}

	public String getInstalmentplanserno() {
		return instalmentplanserno;
	}

	public Date getInstalmentinterestanchordate() {
		return instalmentinterestanchordate;
	}

	public Long getInstalmentserno() {
		return instalmentserno;
	}

	public Long getInstalmentpartitionkey() {
		return instalmentpartitionkey;
	}

	public Long getInstalmentamrtprincipalamount() {
		return instalmentamrtprincipalamount;
	}

	public Long getInstalmentpaymentallocation() {
		return instalmentpaymentallocation;
	}

	public Long getInstalmentpostindicator() {
		return instalmentpostindicator;
	}

	public Long getMbhagreementserno() {
		return mbhagreementserno;
	}

	public String getConsolidationkey() {
		return consolidationkey;
	}

	public Long getOfstmtorinvoiceserno() {
		return ofstmtorinvoiceserno;
	}

	public Long getOfstmtorinvoicepartitionkey() {
		return ofstmtorinvoicepartitionkey;
	}

	public Date getOfstmtdate() {
		return ofstmtdate;
	}

	public Date getOfprintduedate() {
		return ofprintduedate;
	}

	public Date getOfduedate() {
		return ofduedate;
	}

	public Date getOfoverduestmtdate() {
		return ofoverduestmtdate;
	}

	public String getOfrectype() {
		return ofrectype;
	}

	public Long getOftrxntype() {
		return oftrxntype;
	}

	public Long getRewardsflag() {
		return rewardsflag;
	}

	public String getRewardbalancereasoncode() {
		return rewardbalancereasoncode;
	}

	public Long getSingle_msg_flag() {
		return single_msg_flag;
	}

	public String getAuthimmediateposting() {
		return authimmediateposting;
	}

	public Long getAuthaccounttype() {
		return authaccounttype;
	}

	public Long getAuthamount() {
		return authamount;
	}

	public String getOriginator() {
		return originator;
	}

	public String getOriginatorreasoncode() {
		return originatorreasoncode;
	}

	public String getProxycardnumber() {
		return proxycardnumber;
	}

	public String getInvoicenumber() {
		return invoicenumber;
	}

	public Long getAmount() {
		return amount;
	}

	public Long getEmbeddedfee() {
		return embeddedfee;
	}

	public Long getTotalpoints() {
		return totalpoints;
	}

	public Long getTotalrebates() {
		return totalrebates;
	}

	public String getTaxflag() {
		return taxflag;
	}

	public Long getTaxbaseamount() {
		return taxbaseamount;
	}

	public Date getValuedate() {
		return valuedate;
	}

	public Date getStartofinterest() {
		return startofinterest;
	}

	public Date getMinduevaluedate() {
		return minduevaluedate;
	}

	public Date getPostdate() {
		return postdate;
	}

	public String getPosttimestamp() {
		return posttimestamp;
	}

	public String getTextdescription() {
		return textdescription;
	}

	public String getFgresolutionstatus() {
		return fgresolutionstatus;
	}

	public String getExternaltrxnid() {
		return externaltrxnid;
	}

	public String getStgeneral() {
		return stgeneral;
	}

	public String getLogaction() {
		return logaction;
	}

	public Long getRecalculated() {
		return recalculated;
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

	public void setCardserno(Long cardserno) {
		this.cardserno = cardserno;
	}

	public void setDef_caccserno(Long def_caccserno) {
		this.def_caccserno = def_caccserno;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public void setBatchserno(String batchserno) {
		this.batchserno = batchserno;
	}

	public void setTypeserno_fees(String typeserno_fees) {
		this.typeserno_fees = typeserno_fees;
	}

	public void setTypeserno_reports(Long typeserno_reports) {
		this.typeserno_reports = typeserno_reports;
	}

	public void setTypeserno_rewards(Long typeserno_rewards) {
		this.typeserno_rewards = typeserno_rewards;
	}

	public void setTypeserno_gledger(Long typeserno_gledger) {
		this.typeserno_gledger = typeserno_gledger;
	}

	public void setTypeserno_divert(Long typeserno_divert) {
		this.typeserno_divert = typeserno_divert;
	}

	public void setTypeserno_nopost(Long typeserno_nopost) {
		this.typeserno_nopost = typeserno_nopost;
	}

	public void setTypeserno_probe(Long typeserno_probe) {
		this.typeserno_probe = typeserno_probe;
	}

	public void setTypeserno_text(Long typeserno_text) {
		this.typeserno_text = typeserno_text;
	}

	public void setMsgclass(Long msgclass) {
		this.msgclass = msgclass;
	}

	public void setMsgtype(Long msgtype) {
		this.msgtype = msgtype;
	}

	public void setTrxntype(Long trxntype) {
		this.trxntype = trxntype;
	}

	public void setOrig_msg_type(String orig_msg_type) {
		this.orig_msg_type = orig_msg_type;
	}

	public void setI000_msg_type(String i000_msg_type) {
		this.i000_msg_type = i000_msg_type;
	}

	public void setI002_number(String i002_number) {
		this.i002_number = i002_number;
	}

	public void setI003_proc_code(String i003_proc_code) {
		this.i003_proc_code = i003_proc_code;
	}

	public void setI004_amt_trxn(Long i004_amt_trxn) {
		this.i004_amt_trxn = i004_amt_trxn;
	}

	public void setI005_amt_settle(Long i005_amt_settle) {
		this.i005_amt_settle = i005_amt_settle;
	}

	public BigDecimal getI006_amt_bill() {
		return i006_amt_bill;
	}

	public void setI006_amt_bill(BigDecimal i006_amt_bill) {
		this.i006_amt_bill = i006_amt_bill;
	}

	public void setI007_load_date(Date i007_load_date) {
		this.i007_load_date = i007_load_date;
	}

	public void setI008_billing_fee(Long i008_billing_fee) {
		this.i008_billing_fee = i008_billing_fee;
	}

	public void setI013_trxn_date(String i013_trxn_date) {
		this.i013_trxn_date = i013_trxn_date;
	}

	public void setI044_reason_code(String i044_reason_code) {
		this.i044_reason_code = i044_reason_code;
	}

	public void setI048_text_data(String i048_text_data) {
		this.i048_text_data = i048_text_data;
	}

	public void setI049_cur_trxn(Long i049_cur_trxn) {
		this.i049_cur_trxn = i049_cur_trxn;
	}

	public void setI050_cur_settle(Long i050_cur_settle) {
		this.i050_cur_settle = i050_cur_settle;
	}

	public void setI051_cur_bill(Long i051_cur_bill) {
		this.i051_cur_bill = i051_cur_bill;
	}

	public void setCentercurrency(Long centercurrency) {
		this.centercurrency = centercurrency;
	}

	public void setCenteramount(Long centeramount) {
		this.centeramount = centeramount;
	}

	public void setInstalmenttype(Long instalmenttype) {
		this.instalmenttype = instalmenttype;
	}

	public void setInstalmentindepflag(Long instalmentindepflag) {
		this.instalmentindepflag = instalmentindepflag;
	}

	public void setInstalmentsnumber(Long instalmentsnumber) {
		this.instalmentsnumber = instalmentsnumber;
	}

	public void setInstalmentseq(Long instalmentseq) {
		this.instalmentseq = instalmentseq;
	}

	public void setInstalmentrepaymenttype(Long instalmentrepaymenttype) {
		this.instalmentrepaymenttype = instalmentrepaymenttype;
	}

	public void setInstalmentoffset(String instalmentoffset) {
		this.instalmentoffset = instalmentoffset;
	}

	public void setInstalmentorigamount(Long instalmentorigamount) {
		this.instalmentorigamount = instalmentorigamount;
	}

	public void setInstalmenttotalamount(Long instalmenttotalamount) {
		this.instalmenttotalamount = instalmenttotalamount;
	}

	public void setInstalmentplanserno(String instalmentplanserno) {
		this.instalmentplanserno = instalmentplanserno;
	}

	public void setInstalmentinterestanchordate(Date instalmentinterestanchordate) {
		this.instalmentinterestanchordate = instalmentinterestanchordate;
	}

	public void setInstalmentserno(Long instalmentserno) {
		this.instalmentserno = instalmentserno;
	}

	public void setInstalmentpartitionkey(Long instalmentpartitionkey) {
		this.instalmentpartitionkey = instalmentpartitionkey;
	}

	public void setInstalmentamrtprincipalamount(Long instalmentamrtprincipalamount) {
		this.instalmentamrtprincipalamount = instalmentamrtprincipalamount;
	}

	public void setInstalmentpaymentallocation(Long instalmentpaymentallocation) {
		this.instalmentpaymentallocation = instalmentpaymentallocation;
	}

	public void setInstalmentpostindicator(Long instalmentpostindicator) {
		this.instalmentpostindicator = instalmentpostindicator;
	}

	public void setMbhagreementserno(Long mbhagreementserno) {
		this.mbhagreementserno = mbhagreementserno;
	}

	public void setConsolidationkey(String consolidationkey) {
		this.consolidationkey = consolidationkey;
	}

	public void setOfstmtorinvoiceserno(Long ofstmtorinvoiceserno) {
		this.ofstmtorinvoiceserno = ofstmtorinvoiceserno;
	}

	public void setOfstmtorinvoicepartitionkey(Long ofstmtorinvoicepartitionkey) {
		this.ofstmtorinvoicepartitionkey = ofstmtorinvoicepartitionkey;
	}

	public void setOfstmtdate(Date ofstmtdate) {
		this.ofstmtdate = ofstmtdate;
	}

	public void setOfprintduedate(Date ofprintduedate) {
		this.ofprintduedate = ofprintduedate;
	}

	public void setOfduedate(Date ofduedate) {
		this.ofduedate = ofduedate;
	}

	public void setOfoverduestmtdate(Date ofoverduestmtdate) {
		this.ofoverduestmtdate = ofoverduestmtdate;
	}

	public void setOfrectype(String ofrectype) {
		this.ofrectype = ofrectype;
	}

	public void setOftrxntype(Long oftrxntype) {
		this.oftrxntype = oftrxntype;
	}

	public void setRewardsflag(Long rewardsflag) {
		this.rewardsflag = rewardsflag;
	}

	public void setRewardbalancereasoncode(String rewardbalancereasoncode) {
		this.rewardbalancereasoncode = rewardbalancereasoncode;
	}

	public void setSingle_msg_flag(Long single_msg_flag) {
		this.single_msg_flag = single_msg_flag;
	}

	public void setAuthimmediateposting(String authimmediateposting) {
		this.authimmediateposting = authimmediateposting;
	}

	public void setAuthaccounttype(Long authaccounttype) {
		this.authaccounttype = authaccounttype;
	}

	public void setAuthamount(Long authamount) {
		this.authamount = authamount;
	}

	public void setOriginator(String originator) {
		this.originator = originator;
	}

	public void setOriginatorreasoncode(String originatorreasoncode) {
		this.originatorreasoncode = originatorreasoncode;
	}

	public void setProxycardnumber(String proxycardnumber) {
		this.proxycardnumber = proxycardnumber;
	}

	public void setInvoicenumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public void setEmbeddedfee(Long embeddedfee) {
		this.embeddedfee = embeddedfee;
	}

	public void setTotalpoints(Long totalpoints) {
		this.totalpoints = totalpoints;
	}

	public void setTotalrebates(Long totalrebates) {
		this.totalrebates = totalrebates;
	}

	public void setTaxflag(String taxflag) {
		this.taxflag = taxflag;
	}

	public void setTaxbaseamount(Long taxbaseamount) {
		this.taxbaseamount = taxbaseamount;
	}

	public void setValuedate(Date valuedate) {
		this.valuedate = valuedate;
	}

	public void setStartofinterest(Date startofinterest) {
		this.startofinterest = startofinterest;
	}

	public void setMinduevaluedate(Date minduevaluedate) {
		this.minduevaluedate = minduevaluedate;
	}

	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}

	public void setPosttimestamp(String posttimestamp) {
		this.posttimestamp = posttimestamp;
	}

	public void setTextdescription(String textdescription) {
		this.textdescription = textdescription;
	}

	public void setFgresolutionstatus(String fgresolutionstatus) {
		this.fgresolutionstatus = fgresolutionstatus;
	}

	public void setExternaltrxnid(String externaltrxnid) {
		this.externaltrxnid = externaltrxnid;
	}

	public void setStgeneral(String stgeneral) {
		this.stgeneral = stgeneral;
	}

	public void setLogaction(String logaction) {
		this.logaction = logaction;
	}

	public void setRecalculated(Long recalculated) {
		this.recalculated = recalculated;
	}

	public void setConverted(Long converted) {
		this.converted = converted;
	}

}
