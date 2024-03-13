package com.vernite.cal.model;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "CTRANSACTIONS")
public class Ctransactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serno;

	@ManyToOne
	@JoinColumn(name = "caccserno", nullable = false)
	private Caccounts caccounts;

	@ManyToOne
	@JoinColumn(name = "typeserno_alloc")
	private Trxntypes trxntypes;

	@OneToOne(mappedBy = "ctransactions", cascade = CascadeType.ALL)
	private Cisotrxns cisotrxns;

	@Column(name = "INSTITUTION_ID")
	private Long institutionId;

	@Column(name = "PARTITIONKEY")
	private Long partitionkey;

	@Column
	private Long cardserno;

	@Column
	private Long defCaccserno;

	@Column
	private Integer product;

//	@Column
//	private Long batchserno;
//
//	@Column
//	private Long typesernoFees;
//
//	@Column
//	private Long typesernoReports;
//
//	@Column
//	private Long typesernoRewards;
//
//	@Column
//	private Long typesernoGledger;
//
//	@Column
//	private Long typesernoDivert;
//
//	@Column
//	private Long typesernoNopost;
//
//	@Column
//	private Long typesernoProbe;
//
//	@Column
//	private Long typesernoText;
//
//	@Column
//	private Long msgclass;
//
//	@Column
//	private Long msgtype;
//
//	@Column
//	private Long trxntype;
//
//	@Column( precision = 5)
//	private String origMsgType;
//
//	@Column(name = "I000_MSG_TYPE", precision = 4)
//	private String i000MsgType;
//
//	@Column(name = "I002_NUMBER", precision = 25)
//	private String i002Number;
//
//	@Column(name = "I003_PROC_CODE", precision = 6)
//	private String i003ProcCode;
//
//	@Column(name = "I004_AMT_TRXN", precision = 16, scale = 3)
//	private BigDecimal i004AmtTrxn;
//
//	@Column(name = "I005_AMT_SETTLE",precision = 16, scale = 3)
//	private BigDecimal i005AmtSettle;
//
//	@Column(name = "I006_AMT_BILL",precision = 16, scale = 3)
//	private BigDecimal i006AmtBill;
//
//	@Column(name = "I007_LOAD_DATE")
//	private Date i007LoadDate;
//
//	@Column(name = "I008_BILLING_FEE",precision = 16, scale = 3)
//	private BigDecimal i008BillingFee;
//
//	@Column(name = "i013_TRXN_DATE")
//	private Date i013TrxnDate;
//
//	@Column(name = "I044_REASON_CODE",precision = 4)
//	private String i044ReasonCode;
//
//	@Column(name = "I048_TEXT_DATA",precision = 254)
//	private String i048TextData;
//
//	@Column(name = "I049_CUR_TRXN",precision = 3)
//	private String i049CurTrxn;
//
//	@Column(name = "I050_CUR_SETTLE",precision = 3)
//	private String i050CurSettle;
//
//	@Column(name = "I051_CUR_BILL",precision = 3)
//	private String i051CurBill;
//
//	@Column(precision = 3)
//	private String centercurrency;
//
//	@Column(precision = 16, scale = 3)
//	private BigDecimal centeramount;
//
//	@Column
//	private Integer instalmenttype;
//
//	@Column
//	private Integer instalmentindepflag;
//
//	@Column
//	private Integer instalmentsnumber;
//
//	@Column
//	private Integer instalmentseq;
//
//	@Column
//	private Integer instalmentrepaymenttype;
//
//	@Column
//	private Integer instalmentoffset;
//
//	@Column(precision = 16, scale = 3)
//	private BigDecimal instalmentorigamount;
//
//	@Column(precision = 16, scale = 3)
//	private BigDecimal instalmenttotalamount;
//
//	@Column
//	private Long instalmentplanserno;
//
//	@Column
//	private Date instalmentinterestanchordate;
//
//	@Column
//	private Long instalmentserno;
//
//	@Column
//	private Long instalmentpartitionkey;
//
//	@Column(precision = 16, scale = 3)
//	private BigDecimal instalmentamrtprincipalamount;
//
//	@Column
//	private Integer instalmentpaymentallocation;
//
//	@Column
//	private String instalmentpostindicator;
//
//	@Column
//	private Long mbhagreementserno;
//
//	@Column
//	private String consolidationkey;
//
//	@Column
//	private Long ofstmtorinvoiceserno;
//
//	@Column
//	private Long ofstmtorinvoicepartitionkey;
//
//	@Column
//	private Date ofstmtdate;
//
//	@Column
//	private Date ofprintduedate;
//
//	@Column
//	private Date ofduedate;
//
//	@Column
//	private Date ofoverduestmtdate;
//
//	@Column
//	private String ofrectype;
//
//	@Column
//	private Long oftrxntype;
//
//	@Column
//	private Long rewardsflag;
//
//	@Column
//	private String rewardbalancereasoncode;
//
//	@Column
//	private Integer singleMsgFlag;
//
//	@Column
//	private String authimmediateposting;
//
//	@Column
//	private String authaccounttype;
//
//	@Column(precision = 16, scale = 3)
//	private BigDecimal authamount;
//
//	@Column
//	private String originator;
//
//	@Column
//	private String originatorreasoncode;
//
//	@Column
//	private String proxycardnumber;
//
//	@Column
//	private String invoicenumber;
//
//	@Column(precision = 16, scale = 3)
//	private BigDecimal amount;
//
//	@Column
//	private BigDecimal embeddedfee;
//
//	@Column(precision = 32, scale = 16)
//	private BigDecimal totalpoints;
//
//	@Column(precision = 32, scale = 16)
//	private BigDecimal totalrebates;
//
//	@Column
//	private Integer taxflag;
//
//	@Column(precision = 16, scale = 3)
//	private BigDecimal taxbaseamount;
//
//	@Column
//	private Date valuedate;
//
//	@Column
//	private Date startofinterest;
//
//	@Column
//	private Date minduevaluedate;
//
//	@Column
//	private Date postdate;
//
//	@Column
//	private String posttimestamp;
//
//	@Column
//	private String textdescription;
//
//	@Column
//	private String fgresolutionstatus;
//
//	@Column
//	private String externaltrxnid;
//
//	@Column
//	private String stgeneral;
//
//	@Column
//	private String logaction;
//
//	@Column
//	private Integer recalculated;
//
//	@Column(precision = 2)
//	private BigDecimal converted;

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

	public Trxntypes getTrxntypes() {
		return trxntypes;
	}

	public void setTrxntypes(Trxntypes trxntypes) {
		this.trxntypes = trxntypes;
	}

	public Cisotrxns getCisotrxns() {
		return cisotrxns;
	}

	public void setCisotrxns(Cisotrxns cisotrxns) {
		this.cisotrxns = cisotrxns;
	}

	public Long getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(Long institutionId) {
		this.institutionId = institutionId;
	}

	public Long getPartitionkey() {
		return partitionkey;
	}

	public void setPartitionkey(Long partitionkey) {
		this.partitionkey = partitionkey;
	}

	public Long getCardserno() {
		return cardserno;
	}

	public void setCardserno(Long cardserno) {
		this.cardserno = cardserno;
	}

	public Long getDefCaccserno() {
		return defCaccserno;
	}

	public void setDefCaccserno(Long defCaccserno) {
		this.defCaccserno = defCaccserno;
	}

	public Integer getProduct() {
		return product;
	}

	public void setProduct(Integer product) {
		this.product = product;
	}

//	public Long getBatchserno() {
//		return batchserno;
//	}
//
//	public void setBatchserno(Long batchserno) {
//		this.batchserno = batchserno;
//	}
//
//	public Long getTypesernoFees() {
//		return typesernoFees;
//	}
//
//	public void setTypesernoFees(Long typesernoFees) {
//		this.typesernoFees = typesernoFees;
//	}
//
//	public Long getTypesernoReports() {
//		return typesernoReports;
//	}
//
//	public void setTypesernoReports(Long typesernoReports) {
//		this.typesernoReports = typesernoReports;
//	}
//
//	public Long getTypesernoRewards() {
//		return typesernoRewards;
//	}
//
//	public void setTypesernoRewards(Long typesernoRewards) {
//		this.typesernoRewards = typesernoRewards;
//	}
//
//	public Long getTypesernoGledger() {
//		return typesernoGledger;
//	}
//
//	public void setTypesernoGledger(Long typesernoGledger) {
//		this.typesernoGledger = typesernoGledger;
//	}
//
//	public Long getTypesernoDivert() {
//		return typesernoDivert;
//	}
//
//	public void setTypesernoDivert(Long typesernoDivert) {
//		this.typesernoDivert = typesernoDivert;
//	}
//
//	public Long getTypesernoNopost() {
//		return typesernoNopost;
//	}
//
//	public void setTypesernoNopost(Long typesernoNopost) {
//		this.typesernoNopost = typesernoNopost;
//	}
//
//	public Long getTypesernoProbe() {
//		return typesernoProbe;
//	}
//
//	public void setTypesernoProbe(Long typesernoProbe) {
//		this.typesernoProbe = typesernoProbe;
//	}
//
//	public Long getTypesernoText() {
//		return typesernoText;
//	}
//
//	public void setTypesernoText(Long typesernoText) {
//		this.typesernoText = typesernoText;
//	}
//
//	public Long getMsgclass() {
//		return msgclass;
//	}
//
//	public void setMsgclass(Long msgclass) {
//		this.msgclass = msgclass;
//	}
//
//	public Long getMsgtype() {
//		return msgtype;
//	}
//
//	public void setMsgtype(Long msgtype) {
//		this.msgtype = msgtype;
//	}
//
//	public Long getTrxntype() {
//		return trxntype;
//	}
//
//	public void setTrxntype(Long trxntype) {
//		this.trxntype = trxntype;
//	}
//
//	public String getOrigMsgType() {
//		return origMsgType;
//	}
//
//	public void setOrigMsgType(String origMsgType) {
//		this.origMsgType = origMsgType;
//	}
//
//	public String getI000MsgType() {
//		return i000MsgType;
//	}
//
//	public void setI000MsgType(String i000MsgType) {
//		this.i000MsgType = i000MsgType;
//	}
//
//	public String getI002Number() {
//		return i002Number;
//	}
//
//	public void setI002Number(String i002Number) {
//		this.i002Number = i002Number;
//	}
//
//	public String getI003ProcCode() {
//		return i003ProcCode;
//	}
//
//	public void setI003ProcCode(String i003ProcCode) {
//		this.i003ProcCode = i003ProcCode;
//	}
//
//	public Date getI007LoadDate() {
//		return i007LoadDate;
//	}
//
//	public void setI007LoadDate(Date i007LoadDate) {
//		this.i007LoadDate = i007LoadDate;
//	}
//
//	public Date getI013TrxnDate() {
//		return i013TrxnDate;
//	}
//
//	public void setI013TrxnDate(Date i013TrxnDate) {
//		this.i013TrxnDate = i013TrxnDate;
//	}
//
//	public String getI044ReasonCode() {
//		return i044ReasonCode;
//	}
//
//	public void setI044ReasonCode(String i044ReasonCode) {
//		this.i044ReasonCode = i044ReasonCode;
//	}
//
//	public String getI048TextData() {
//		return i048TextData;
//	}
//
//	public void setI048TextData(String i048TextData) {
//		this.i048TextData = i048TextData;
//	}
//
//	public String getI049CurTrxn() {
//		return i049CurTrxn;
//	}
//
//	public void setI049CurTrxn(String i049CurTrxn) {
//		this.i049CurTrxn = i049CurTrxn;
//	}
//
//	public String getI050CurSettle() {
//		return i050CurSettle;
//	}
//
//	public void setI050CurSettle(String i050CurSettle) {
//		this.i050CurSettle = i050CurSettle;
//	}
//
//	public String getI051CurBill() {
//		return i051CurBill;
//	}
//
//	public void setI051CurBill(String i051CurBill) {
//		this.i051CurBill = i051CurBill;
//	}
//
//	public String getCentercurrency() {
//		return centercurrency;
//	}
//
//	public void setCentercurrency(String centercurrency) {
//		this.centercurrency = centercurrency;
//	}
//
//	public BigDecimal getCenteramount() {
//		return centeramount;
//	}
//
//	public void setCenteramount(BigDecimal centeramount) {
//		this.centeramount = centeramount;
//	}
//
//	public Integer getInstalmenttype() {
//		return instalmenttype;
//	}
//
//	public void setInstalmenttype(Integer instalmenttype) {
//		this.instalmenttype = instalmenttype;
//	}
//
//	public Integer getInstalmentindepflag() {
//		return instalmentindepflag;
//	}
//
//	public void setInstalmentindepflag(Integer instalmentindepflag) {
//		this.instalmentindepflag = instalmentindepflag;
//	}
//
//	public Integer getInstalmentsnumber() {
//		return instalmentsnumber;
//	}
//
//	public void setInstalmentsnumber(Integer instalmentsnumber) {
//		this.instalmentsnumber = instalmentsnumber;
//	}
//
//	public Integer getInstalmentseq() {
//		return instalmentseq;
//	}
//
//	public void setInstalmentseq(Integer instalmentseq) {
//		this.instalmentseq = instalmentseq;
//	}
//
//	public Integer getInstalmentrepaymenttype() {
//		return instalmentrepaymenttype;
//	}
//
//	public void setInstalmentrepaymenttype(Integer instalmentrepaymenttype) {
//		this.instalmentrepaymenttype = instalmentrepaymenttype;
//	}
//
//	public Integer getInstalmentoffset() {
//		return instalmentoffset;
//	}
//
//	public void setInstalmentoffset(Integer instalmentoffset) {
//		this.instalmentoffset = instalmentoffset;
//	}
//
//	public BigDecimal getInstalmentorigamount() {
//		return instalmentorigamount;
//	}
//
//	public void setInstalmentorigamount(BigDecimal instalmentorigamount) {
//		this.instalmentorigamount = instalmentorigamount;
//	}
//
//	public BigDecimal getInstalmenttotalamount() {
//		return instalmenttotalamount;
//	}
//
//	public void setInstalmenttotalamount(BigDecimal instalmenttotalamount) {
//		this.instalmenttotalamount = instalmenttotalamount;
//	}
//
//	public Long getInstalmentplanserno() {
//		return instalmentplanserno;
//	}
//
//	public void setInstalmentplanserno(Long instalmentplanserno) {
//		this.instalmentplanserno = instalmentplanserno;
//	}
//
//	public Date getInstalmentinterestanchordate() {
//		return instalmentinterestanchordate;
//	}
//
//	public void setInstalmentinterestanchordate(Date instalmentinterestanchordate) {
//		this.instalmentinterestanchordate = instalmentinterestanchordate;
//	}
//
//	public Long getInstalmentserno() {
//		return instalmentserno;
//	}
//
//	public void setInstalmentserno(Long instalmentserno) {
//		this.instalmentserno = instalmentserno;
//	}
//
//	public Long getInstalmentpartitionkey() {
//		return instalmentpartitionkey;
//	}
//
//	public void setInstalmentpartitionkey(Long instalmentpartitionkey) {
//		this.instalmentpartitionkey = instalmentpartitionkey;
//	}
//
//	public BigDecimal getInstalmentamrtprincipalamount() {
//		return instalmentamrtprincipalamount;
//	}
//
//	public void setInstalmentamrtprincipalamount(BigDecimal instalmentamrtprincipalamount) {
//		this.instalmentamrtprincipalamount = instalmentamrtprincipalamount;
//	}
//
//	public Integer getInstalmentpaymentallocation() {
//		return instalmentpaymentallocation;
//	}
//
//	public void setInstalmentpaymentallocation(Integer instalmentpaymentallocation) {
//		this.instalmentpaymentallocation = instalmentpaymentallocation;
//	}
//
//	public String getInstalmentpostindicator() {
//		return instalmentpostindicator;
//	}
//
//	public void setInstalmentpostindicator(String instalmentpostindicator) {
//		this.instalmentpostindicator = instalmentpostindicator;
//	}
//
//	public Long getMbhagreementserno() {
//		return mbhagreementserno;
//	}
//
//	public void setMbhagreementserno(Long mbhagreementserno) {
//		this.mbhagreementserno = mbhagreementserno;
//	}
//
//	public String getConsolidationkey() {
//		return consolidationkey;
//	}
//
//	public void setConsolidationkey(String consolidationkey) {
//		this.consolidationkey = consolidationkey;
//	}
//
//	public Long getOfstmtorinvoiceserno() {
//		return ofstmtorinvoiceserno;
//	}
//
//	public void setOfstmtorinvoiceserno(Long ofstmtorinvoiceserno) {
//		this.ofstmtorinvoiceserno = ofstmtorinvoiceserno;
//	}
//
//	public Long getOfstmtorinvoicepartitionkey() {
//		return ofstmtorinvoicepartitionkey;
//	}
//
//	public void setOfstmtorinvoicepartitionkey(Long ofstmtorinvoicepartitionkey) {
//		this.ofstmtorinvoicepartitionkey = ofstmtorinvoicepartitionkey;
//	}
//
//	public Date getOfstmtdate() {
//		return ofstmtdate;
//	}
//
//	public void setOfstmtdate(Date ofstmtdate) {
//		this.ofstmtdate = ofstmtdate;
//	}
//
//	public Date getOfprintduedate() {
//		return ofprintduedate;
//	}
//
//	public void setOfprintduedate(Date ofprintduedate) {
//		this.ofprintduedate = ofprintduedate;
//	}
//
//	public Date getOfduedate() {
//		return ofduedate;
//	}
//
//	public void setOfduedate(Date ofduedate) {
//		this.ofduedate = ofduedate;
//	}
//
//	public Date getOfoverduestmtdate() {
//		return ofoverduestmtdate;
//	}
//
//	public void setOfoverduestmtdate(Date ofoverduestmtdate) {
//		this.ofoverduestmtdate = ofoverduestmtdate;
//	}
//
//	public String getOfrectype() {
//		return ofrectype;
//	}
//
//	public void setOfrectype(String ofrectype) {
//		this.ofrectype = ofrectype;
//	}
//
//	public Long getOftrxntype() {
//		return oftrxntype;
//	}
//
//	public void setOftrxntype(Long oftrxntype) {
//		this.oftrxntype = oftrxntype;
//	}
//
//	public Long getRewardsflag() {
//		return rewardsflag;
//	}
//
//	public void setRewardsflag(Long rewardsflag) {
//		this.rewardsflag = rewardsflag;
//	}
//
//	public String getRewardbalancereasoncode() {
//		return rewardbalancereasoncode;
//	}
//
//	public void setRewardbalancereasoncode(String rewardbalancereasoncode) {
//		this.rewardbalancereasoncode = rewardbalancereasoncode;
//	}
//
//	public Integer getSingleMsgFlag() {
//		return singleMsgFlag;
//	}
//
//	public void setSingleMsgFlag(Integer singleMsgFlag) {
//		this.singleMsgFlag = singleMsgFlag;
//	}
//
//	public String getAuthimmediateposting() {
//		return authimmediateposting;
//	}
//
//	public void setAuthimmediateposting(String authimmediateposting) {
//		this.authimmediateposting = authimmediateposting;
//	}
//
//	public String getAuthaccounttype() {
//		return authaccounttype;
//	}
//
//	public void setAuthaccounttype(String authaccounttype) {
//		this.authaccounttype = authaccounttype;
//	}
//
//	public BigDecimal getAuthamount() {
//		return authamount;
//	}
//
//	public void setAuthamount(BigDecimal authamount) {
//		this.authamount = authamount;
//	}
//
//	public String getOriginator() {
//		return originator;
//	}
//
//	public void setOriginator(String originator) {
//		this.originator = originator;
//	}
//
//	public String getOriginatorreasoncode() {
//		return originatorreasoncode;
//	}
//
//	public void setOriginatorreasoncode(String originatorreasoncode) {
//		this.originatorreasoncode = originatorreasoncode;
//	}
//
//	public String getProxycardnumber() {
//		return proxycardnumber;
//	}
//
//	public void setProxycardnumber(String proxycardnumber) {
//		this.proxycardnumber = proxycardnumber;
//	}
//
//	public String getInvoicenumber() {
//		return invoicenumber;
//	}
//
//	public void setInvoicenumber(String invoicenumber) {
//		this.invoicenumber = invoicenumber;
//	}
//
//	public BigDecimal getAmount() {
//		return amount;
//	}
//
//	public void setAmount(BigDecimal amount) {
//		this.amount = amount;
//	}
//
//	public BigDecimal getEmbeddedfee() {
//		return embeddedfee;
//	}
//
//	public void setEmbeddedfee(BigDecimal embeddedfee) {
//		this.embeddedfee = embeddedfee;
//	}
//
//	public BigDecimal getTotalpoints() {
//		return totalpoints;
//	}
//
//	public void setTotalpoints(BigDecimal totalpoints) {
//		this.totalpoints = totalpoints;
//	}
//
//	public BigDecimal getTotalrebates() {
//		return totalrebates;
//	}
//
//	public void setTotalrebates(BigDecimal totalrebates) {
//		this.totalrebates = totalrebates;
//	}
//
//	public Integer getTaxflag() {
//		return taxflag;
//	}
//
//	public void setTaxflag(Integer taxflag) {
//		this.taxflag = taxflag;
//	}
//
//	public BigDecimal getTaxbaseamount() {
//		return taxbaseamount;
//	}
//
//	public void setTaxbaseamount(BigDecimal taxbaseamount) {
//		this.taxbaseamount = taxbaseamount;
//	}
//
//	public Date getValuedate() {
//		return valuedate;
//	}
//
//	public void setValuedate(Date valuedate) {
//		this.valuedate = valuedate;
//	}
//
//	public Date getStartofinterest() {
//		return startofinterest;
//	}
//
//	public void setStartofinterest(Date startofinterest) {
//		this.startofinterest = startofinterest;
//	}
//
//	public Date getMinduevaluedate() {
//		return minduevaluedate;
//	}
//
//	public void setMinduevaluedate(Date minduevaluedate) {
//		this.minduevaluedate = minduevaluedate;
//	}
//
//	public Date getPostdate() {
//		return postdate;
//	}
//
//	public void setPostdate(Date postdate) {
//		this.postdate = postdate;
//	}
//
//	public String getPosttimestamp() {
//		return posttimestamp;
//	}
//
//	public void setPosttimestamp(String posttimestamp) {
//		this.posttimestamp = posttimestamp;
//	}
//
//	public String getTextdescription() {
//		return textdescription;
//	}
//
//	public void setTextdescription(String textdescription) {
//		this.textdescription = textdescription;
//	}
//
//	public String getFgresolutionstatus() {
//		return fgresolutionstatus;
//	}
//
//	public void setFgresolutionstatus(String fgresolutionstatus) {
//		this.fgresolutionstatus = fgresolutionstatus;
//	}
//
//	public String getExternaltrxnid() {
//		return externaltrxnid;
//	}
//
//	public void setExternaltrxnid(String externaltrxnid) {
//		this.externaltrxnid = externaltrxnid;
//	}
//
//	public String getStgeneral() {
//		return stgeneral;
//	}
//
//	public void setStgeneral(String stgeneral) {
//		this.stgeneral = stgeneral;
//	}
//
//	public String getLogaction() {
//		return logaction;
//	}
//
//	public void setLogaction(String logaction) {
//		this.logaction = logaction;
//	}
//
//	public Integer getRecalculated() {
//		return recalculated;
//	}
//
//	public void setRecalculated(Integer recalculated) {
//		this.recalculated = recalculated;
//	}
//
//	public BigDecimal getConverted() {
//		return converted;
//	}
//
//	public void setConverted(BigDecimal converted) {
//		this.converted = converted;
//	}
//
//	public BigDecimal getI004AmtTrxn() {
//		return i004AmtTrxn;
//	}
//
//	public void setI004AmtTrxn(BigDecimal i004AmtTrxn) {
//		this.i004AmtTrxn = i004AmtTrxn;
//	}
//
//	public BigDecimal getI005AmtSettle() {
//		return i005AmtSettle;
//	}
//
//	public void setI005AmtSettle(BigDecimal i005AmtSettle) {
//		this.i005AmtSettle = i005AmtSettle;
//	}
//
//	public BigDecimal getI006AmtBill() {
//		return i006AmtBill;
//	}
//
//	public void setI006AmtBill(BigDecimal i006AmtBill) {
//		this.i006AmtBill = i006AmtBill;
//	}
//
//	public BigDecimal getI008BillingFee() {
//		return i008BillingFee;
//	}
//
//	public void setI008BillingFee(BigDecimal i008BillingFee) {
//		this.i008BillingFee = i008BillingFee;
//	}

}
