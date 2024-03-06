package com.vernite.cal.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Ctransactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serno;

	@ManyToOne
	@JoinColumn(name = "caccserno", nullable = false)
	private Caccounts caccounts;

	@ManyToOne
	@JoinColumn(name = "typeserno_alloc", nullable = false)
	private Trxntypes trxntypes;

	@OneToOne(mappedBy = "ctransactions", cascade = CascadeType.ALL)
	private Cisotrxns cisotrxns;

	@Column
	private Long institutionId;

	@Column
	private Long partitionkey;

//	@Column
//	private Long caccserno;

	@Column
	private Long cardserno;

	@Column
	private Long defCaccserno;

	@Column
	private Long product;

	@Column
	private Long batchserno;

//	@Column
//	private Long typesernoAlloc;

	@Column
	private Long typesernoFees;

	@Column
	private Long typesernoReports;

	@Column
	private Long typesernoRewards;

	@Column
	private Long typesernoGledger;

	@Column
	private Long typesernoDivert;

	@Column
	private Long typesernoNopost;

	@Column
	private Long typesernoProbe;

	@Column
	private Long typesernoText;

	@Column
	private Long msgclass;

	@Column
	private Long msgtype;

	@Column
	private Long trxntype;

	@Column
	private String origMsgType;

	@Column
	private String i000MsgType;

	@Column( length = 25)
	private String i002Number;

	@Column( length = 6)
	private String i003ProcCode;

	@Column(precision = 16, scale = 3)
	private BigDecimal i004AmtTrxn;

	@Column(precision = 16, scale = 3)
	private BigDecimal i005AmtSettle;

	@Column(precision = 16, scale = 3)
	private BigDecimal i006AmtBill;

	@Column
	private Date i007LoadDate;

	@Column(precision = 16, scale = 3)
	private BigDecimal i008BillingFee;

	@Column
	private Date i013TrxnDate;

	@Column(length = 4)
	private String i044ReasonCode;

	@Column(length = 254)
	private String i048TextData;

	@Column(length = 3)
	private String i049CurTrxn;

	@Column(length = 3)
	private String i050CurSettle;

	@Column(length = 3)
	private String i051CurBill;

	@Column(length = 3)
	private String centercurrency;

	@Column(precision = 16, scale = 3)
	private BigDecimal centeramount;

	@Column(length = 3)
	private Long instalmenttype;

	@Column(length = 5)
	private Long instalmentindepflag;

	@Column(length = 3)
	private Long instalmentsnumber;

	@Column(length = 5)
	private Long instalmentseq;

	@Column(length = 5)
	private Long instalmentrepaymenttype;

	@Column(length = 5)
	private Long instalmentoffset;

	@Column(precision = 16, scale = 3)
	private BigDecimal instalmentorigamount;

	@Column(precision = 16, scale = 3)
	private BigDecimal instalmenttotalamount;

	@Column(length = 5)
	private Long instalmentplanserno;

	@Column
	private Date instalmentinterestanchordate;

	@Column
	private Long instalmentserno;

	@Column(length = 10)
	private Long instalmentpartitionkey;

	@Column(precision = 16, scale = 3)
	private BigDecimal instalmentamrtprincipalamount;

	@Column
	private Long instalmentpaymentallocation;

	@Column(length = 5)
	private String instalmentpostindicator;

	@Column(precision = 16, scale = 3)
	private Long mbhagreementserno;

	@Column(length = 25)
	private String consolidationkey;

	@Column(length = 10)
	private Long ofstmtorinvoiceserno;

	@Column(length = 10)
	private Long ofstmtorinvoicepartitionkey;

	@Column
	private Date ofstmtdate;

	@Column
	private Date ofprintduedate;

	@Column
	private Date ofduedate;

	@Column
	private Date ofoverduestmtdate;

	@Column(length = 1)
	private String ofrectype;

	@Column(length = 10)
	private Long oftrxntype;

	@Column(length = 10)
	private Long rewardsflag;

	@Column(length = 20)
	private String rewardbalancereasoncode;

	@Column(length = 5)
	private Long singleMsgFlag;

	@Column(length = 1)
	private String authimmediateposting;

	@Column(length = 2)
	private String authaccounttype;

	@Column(precision = 16, scale = 3)
	private BigDecimal authamount;

	@Column(length = 50)
	private String originator;

	@Column(length = 10)
	private String originatorreasoncode;

	@Column(length = 25)
	private String proxycardnumber;

	@Column(length = 25)
	private String invoicenumber;

	@Column(precision = 16, scale = 3)
	private BigDecimal amount;

	@Column(precision = 16, scale = 3)
	private BigDecimal embeddedfee;

	@Column(precision = 32, scale = 16)
	private BigDecimal totalpoints;

	@Column(precision = 32, scale = 16)
	private BigDecimal totalrebates;

	@Column(length = 5)
	private Long taxflag;

	@Column(precision = 16, scale = 3)
	private BigDecimal taxbaseamount;

	@Column
	private Date valuedate;

	@Column
	private Date startofinterest;

	@Column
	private Date minduevaluedate;

	@Column
	private Date postdate;

	@Column(length = 26)
	private String posttimestamp;

	@Column(length = 100)
	private String textdescription;

	@Column(length = 20)
	private String fgresolutionstatus;

	@Column(length = 36)
	private String externaltrxnid;

	@Column(length = 4, nullable = false)
	private String stgeneral;

	@Column(length = 11)
	private String logaction;

	@Column(length = 1)
	private Long recalculated;

	@Column(precision = 26, scale = 2)
	private BigDecimal converted;

	public Long getSerno() {
		return serno;
	}

	public Caccounts getCaccounts() {
		return caccounts;
	}

	public Trxntypes getTrxntypes() {
		return trxntypes;
	}

	public Cisotrxns getCisotrxns() {
		return cisotrxns;
	}

	public Long getInstitutionId() {
		return institutionId;
	}

	public Long getPartitionkey() {
		return partitionkey;
	}

//	public Long getCaccserno() {
//		return caccserno;
//	}

	public Long getCardserno() {
		return cardserno;
	}

	public Long getDefCaccserno() {
		return defCaccserno;
	}

	public Long getProduct() {
		return product;
	}

	public Long getBatchserno() {
		return batchserno;
	}

//	public Long getTypesernoAlloc() {
//		return typesernoAlloc;
//	}

	public Long getTypesernoFees() {
		return typesernoFees;
	}

	public Long getTypesernoReports() {
		return typesernoReports;
	}

	public Long getTypesernoRewards() {
		return typesernoRewards;
	}

	public Long getTypesernoGledger() {
		return typesernoGledger;
	}

	public Long getTypesernoDivert() {
		return typesernoDivert;
	}

	public Long getTypesernoNopost() {
		return typesernoNopost;
	}

	public Long getTypesernoProbe() {
		return typesernoProbe;
	}

	public Long getTypesernoText() {
		return typesernoText;
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

	public String getOrigMsgType() {
		return origMsgType;
	}

	public String getI000MsgType() {
		return i000MsgType;
	}

	public String getI002Number() {
		return i002Number;
	}

	public String getI003ProcCode() {
		return i003ProcCode;
	}

	public BigDecimal getI004AmtTrxn() {
		return i004AmtTrxn;
	}

	public BigDecimal getI005AmtSettle() {
		return i005AmtSettle;
	}

	public BigDecimal getI006AmtBill() {
		return i006AmtBill;
	}

	public Date getI007LoadDate() {
		return i007LoadDate;
	}

	public BigDecimal getI008BillingFee() {
		return i008BillingFee;
	}

	public Date getI013TrxnDate() {
		return i013TrxnDate;
	}

	public String getI044ReasonCode() {
		return i044ReasonCode;
	}

	public String getI048TextData() {
		return i048TextData;
	}

	public String getI049CurTrxn() {
		return i049CurTrxn;
	}

	public String getI050CurSettle() {
		return i050CurSettle;
	}

	public String getI051CurBill() {
		return i051CurBill;
	}

	public String getCentercurrency() {
		return centercurrency;
	}

	public BigDecimal get() {
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

	public Long getInstalmentoffset() {
		return instalmentoffset;
	}

	public BigDecimal getInstalmentorigamount() {
		return instalmentorigamount;
	}

	public BigDecimal getInstalmenttotalamount() {
		return instalmenttotalamount;
	}

	public Long getInstalmentplanserno() {
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

	public BigDecimal getInstalmentamrtprincipalamount() {
		return instalmentamrtprincipalamount;
	}

	public Long getInstalmentpaymentallocation() {
		return instalmentpaymentallocation;
	}

	public String getInstalmentpostindicator() {
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

	public Long getSingleMsgFlag() {
		return singleMsgFlag;
	}

	public String getAuthimmediateposting() {
		return authimmediateposting;
	}

	public String getAuthaccounttype() {
		return authaccounttype;
	}

	public BigDecimal getAuthamount() {
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

	public BigDecimal getAmount() {
		return amount;
	}

	public BigDecimal getEmbeddedfee() {
		return embeddedfee;
	}

	public BigDecimal getTotalpoints() {
		return totalpoints;
	}

	public BigDecimal getTotalrebates() {
		return totalrebates;
	}

	public Long getTaxflag() {
		return taxflag;
	}

	public BigDecimal getTaxbaseamount() {
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

	public BigDecimal getConverted() {
		return converted;
	}

	public void setSerno(Long serno) {
		this.serno = serno;
	}

	public void setCaccounts(Caccounts caccounts) {
		this.caccounts = caccounts;
	}

	public void setTrxntypes(Trxntypes trxntypes) {
		this.trxntypes = trxntypes;
	}

	public void setCisotrxns(Cisotrxns cisotrxns) {
		this.cisotrxns = cisotrxns;
	}

	public void setInstitutionId(Long institutionId) {
		this.institutionId = institutionId;
	}

	public void setPartitionkey(Long partitionkey) {
		this.partitionkey = partitionkey;
	}

//	public void setCaccserno(Long caccserno) {
//		this.caccserno = caccserno;
//	}

	public void setCardserno(Long cardserno) {
		this.cardserno = cardserno;
	}

	public void setDefCaccserno(Long defCaccserno) {
		this.defCaccserno = defCaccserno;
	}

	public void setProduct(Long product) {
		this.product = product;
	}

	public void setBatchserno(Long batchserno) {
		this.batchserno = batchserno;
	}

//	public void setTypesernoAlloc(Long typesernoAlloc) {
//		this.typesernoAlloc = typesernoAlloc;
//	}

	public void setTypesernoFees(Long typesernoFees) {
		this.typesernoFees = typesernoFees;
	}

	public void setTypesernoReports(Long typesernoReports) {
		this.typesernoReports = typesernoReports;
	}

	public void setTypesernoRewards(Long typesernoRewards) {
		this.typesernoRewards = typesernoRewards;
	}

	public void setTypesernoGledger(Long typesernoGledger) {
		this.typesernoGledger = typesernoGledger;
	}

	public void setTypesernoDivert(Long typesernoDivert) {
		this.typesernoDivert = typesernoDivert;
	}

	public void setTypesernoNopost(Long typesernoNopost) {
		this.typesernoNopost = typesernoNopost;
	}

	public void setTypesernoProbe(Long typesernoProbe) {
		this.typesernoProbe = typesernoProbe;
	}

	public void setTypesernoText(Long typesernoText) {
		this.typesernoText = typesernoText;
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

	public void setOrigMsgType(String origMsgType) {
		this.origMsgType = origMsgType;
	}

	public void setI000MsgType(String i000MsgType) {
		this.i000MsgType = i000MsgType;
	}

	public void setI002Number(String i002Number) {
		this.i002Number = i002Number;
	}

	public void setI003ProcCode(String i003ProcCode) {
		this.i003ProcCode = i003ProcCode;
	}

	public void setI004AmtTrxn(BigDecimal i004AmtTrxn) {
		this.i004AmtTrxn = i004AmtTrxn;
	}

	public void setI005AmtSettle(BigDecimal i005AmtSettle) {
		this.i005AmtSettle = i005AmtSettle;
	}

	public void setI006AmtBill(BigDecimal i006AmtBill) {
		this.i006AmtBill = i006AmtBill;
	}

	public void setI007LoadDate(Date i007LoadDate) {
		this.i007LoadDate = i007LoadDate;
	}

	public void setI008BillingFee(BigDecimal i008BillingFee) {
		this.i008BillingFee = i008BillingFee;
	}

	public void setI013TrxnDate(Date i013TrxnDate) {
		this.i013TrxnDate = i013TrxnDate;
	}

	public void setI044ReasonCode(String i044ReasonCode) {
		this.i044ReasonCode = i044ReasonCode;
	}

	public void setI048TextData(String i048TextData) {
		this.i048TextData = i048TextData;
	}

	public void setI049CurTrxn(String i049CurTrxn) {
		this.i049CurTrxn = i049CurTrxn;
	}

	public void setI050CurSettle(String i050CurSettle) {
		this.i050CurSettle = i050CurSettle;
	}

	public void setI051CurBill(String i051CurBill) {
		this.i051CurBill = i051CurBill;
	}

	public void setCentercurrency(String centercurrency) {
		this.centercurrency = centercurrency;
	}

	public void setCenteramount(BigDecimal centeramount) {
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

	public void setInstalmentoffset(Long instalmentoffset) {
		this.instalmentoffset = instalmentoffset;
	}

	public void setInstalmentorigamount(BigDecimal instalmentorigamount) {
		this.instalmentorigamount = instalmentorigamount;
	}

	public void setInstalmenttotalamount(BigDecimal instalmenttotalamount) {
		this.instalmenttotalamount = instalmenttotalamount;
	}

	public void setInstalmentplanserno(Long instalmentplanserno) {
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

	public void setInstalmentamrtprincipalamount(BigDecimal instalmentamrtprincipalamount) {
		this.instalmentamrtprincipalamount = instalmentamrtprincipalamount;
	}

	public void setInstalmentpaymentallocation(Long instalmentpaymentallocation) {
		this.instalmentpaymentallocation = instalmentpaymentallocation;
	}

	public void setInstalmentpostindicator(String instalmentpostindicator) {
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

	public void setSingleMsgFlag(Long singleMsgFlag) {
		this.singleMsgFlag = singleMsgFlag;
	}

	public void setAuthimmediateposting(String authimmediateposting) {
		this.authimmediateposting = authimmediateposting;
	}

	public void setAuthaccounttype(String authaccounttype) {
		this.authaccounttype = authaccounttype;
	}

	public void setAuthamount(BigDecimal authamount) {
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

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setEmbeddedfee(BigDecimal embeddedfee) {
		this.embeddedfee = embeddedfee;
	}

	public void setTotalpoints(BigDecimal totalpoints) {
		this.totalpoints = totalpoints;
	}

	public void setTotalrebates(BigDecimal totalrebates) {
		this.totalrebates = totalrebates;
	}

	public void setTaxflag(Long taxflag) {
		this.taxflag = taxflag;
	}

	public void setTaxbaseamount(BigDecimal taxbaseamount) {
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

	public void setConverted(BigDecimal converted) {
		this.converted = converted;
	}

}
