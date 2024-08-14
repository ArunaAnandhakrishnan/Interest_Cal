package com.vernite.cal.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import oracle.sql.TIMESTAMP;

@Entity
@Table(name = "CACCOUNTS")
public class Caccounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serno;

    @OneToMany(mappedBy = "caccounts", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cardx> cardsList;

    @OneToMany(mappedBy = "caccounts", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cstatements> cstatementsList;

    @OneToMany(mappedBy = "caccounts", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Ctransactions> ctransactionsList;
    private Long institution_id;
    private Long custserno;
    private String numberx;
    private Long primarycardserno;
    private Long riskdomainserno;
    private String accounttype;
    private String billingmethod;
    private Long dailyaccrualflag;
    private Long product;
    private Long currency;
    private Long creditlimit;
    private Long balance;
    private Long openingminamount;
    private Long minamount;
    private Long minamountwaived;
    private Date minamtduedate;
    private Date minamtprintduedate;
    private Long overdueamount;
    private Date overduedate;
    private Long overduecycles;
    private Date currentoverduedate;
    private Long currentoverdueage;
    private Date cureoverduedate;
    private Date cureoverduelastupddate;
    private Date lastminamountwaiveddate;
    private Date stopdailyaccrualrepdate;
    private Long paymentindicator;
    private Long allocprofserno;
    private Long feeprofserno;
    private Long trxnfeeprofserno;
    private Long instprofserno;
    private Long rewardprofserno;
    private Long caprofserno;
    private Long servicefeeoverridesexist;
    private Long trxnfeeoverridesexist;
    private String stgeneral;
    private String stfinancial;
    private String stauthorization;
    private String prechangerequeststgeneral;
    private Long inactive;
    private Long nextstmtserno;
    private Long nextstmtpartitionkey;
    private Long totalpoints;
    private Long totalpointtrxns;
    private Long totalcredits;
    private Long totaldebits;
    private Long thisperioddue;
    private Long returnedpayments;
    private Long backdatedcredits;
    private Long backdateddebits;
    private Long backdatedpayments;
    private Long backdatedreturnedpayments;
    private Date lastbillingdate;
    private String lastbillingreason;
    private Date lasttrxnpostdate;
    private Date lastactivitytrxnpostdate;
    private Date lastallocationdate;
    private Long lastpaymentserno;
    private Long lastpaymentpartitionkey;
    private Long lastbalupdeodserno;
    private Long prevbalupdeodserno;
    private Long lastmtpupdeodserno;
    private Long prevmtpupdeodserno;
    private Long instalmentcount;
    private Long instalmentbalance;
    private Long instalmentbalanceprincipal;
    private Long issinstbalance;
    private Long acqinstbalance;
    private Long cashbalance;
    private Long paidinfullbalance;
    private Date createdate;
    private Long chargeoffamount;
    private Date chargeoffdate;
    private Date closedate;
    private Long excesspaymentamount;
    private Long latepaymentfee;
    private Long latepaymentfeetrxnserno;
    private Long latepaymentfeetrxnpartitionkey;
    private Long activitysincelaststatement;
    private String transactorhistory;
    private Long statementinstalmentsallowed;
    private Long statementinstalmentsmaxnum;
    private Long statementinstalmentsactivenum;
    private Long autoredeemcyclestoskip;
    private Long collectorcase;
    private Long dormantacctypeserno;
    private Long repaymentplanserno;
    private Long repaymentplanpartitionkey;
    private Long mbhagreementserno;
    private TIMESTAMP mbhagreementexpirydate;
    private Long realflag;
    private String excludefromprobe;
    private String languagecode;
    private String logaction;
    private Long entityversionno;
    private Long converted;

    public Long getSerno() {
        return serno;
    }

    public void setSerno(Long serno) {
        this.serno = serno;
    }

    public List<Cardx> getCardsList() {
        return cardsList;
    }

    public void setCardsList(List<Cardx> cardsList) {
        this.cardsList = cardsList;
    }

    public List<Cstatements> getCstatementsList() {
        return cstatementsList;
    }

    public void setCstatementsList(List<Cstatements> cstatementsList) {
        this.cstatementsList = cstatementsList;
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

    public Long getCustserno() {
        return custserno;
    }

    public void setCustserno(Long custserno) {
        this.custserno = custserno;
    }

    public String getNumberx() {
        return numberx;
    }

    public void setNumberx(String numberx) {
        this.numberx = numberx;
    }

    public Long getPrimarycardserno() {
        return primarycardserno;
    }

    public void setPrimarycardserno(Long primarycardserno) {
        this.primarycardserno = primarycardserno;
    }

    public Long getRiskdomainserno() {
        return riskdomainserno;
    }

    public void setRiskdomainserno(Long riskdomainserno) {
        this.riskdomainserno = riskdomainserno;
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

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
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

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getOpeningminamount() {
        return openingminamount;
    }

    public void setOpeningminamount(Long openingminamount) {
        this.openingminamount = openingminamount;
    }

    public Long getMinamount() {
        return minamount;
    }

    public void setMinamount(Long minamount) {
        this.minamount = minamount;
    }

    public Long getMinamountwaived() {
        return minamountwaived;
    }

    public void setMinamountwaived(Long minamountwaived) {
        this.minamountwaived = minamountwaived;
    }

    public Date getMinamtduedate() {
        return minamtduedate;
    }

    public void setMinamtduedate(Date minamtduedate) {
        this.minamtduedate = minamtduedate;
    }

    public Date getMinamtprintduedate() {
        return minamtprintduedate;
    }

    public void setMinamtprintduedate(Date minamtprintduedate) {
        this.minamtprintduedate = minamtprintduedate;
    }

    public Long getOverdueamount() {
        return overdueamount;
    }

    public void setOverdueamount(Long overdueamount) {
        this.overdueamount = overdueamount;
    }

    public Date getOverduedate() {
        return overduedate;
    }

    public void setOverduedate(Date overduedate) {
        this.overduedate = overduedate;
    }

    public Long getOverduecycles() {
        return overduecycles;
    }

    public void setOverduecycles(Long overduecycles) {
        this.overduecycles = overduecycles;
    }

    public Date getCurrentoverduedate() {
        return currentoverduedate;
    }

    public void setCurrentoverduedate(Date currentoverduedate) {
        this.currentoverduedate = currentoverduedate;
    }

    public Long getCurrentoverdueage() {
        return currentoverdueage;
    }

    public void setCurrentoverdueage(Long currentoverdueage) {
        this.currentoverdueage = currentoverdueage;
    }

    public Date getCureoverduedate() {
        return cureoverduedate;
    }

    public void setCureoverduedate(Date cureoverduedate) {
        this.cureoverduedate = cureoverduedate;
    }

    public Date getCureoverduelastupddate() {
        return cureoverduelastupddate;
    }

    public void setCureoverduelastupddate(Date cureoverduelastupddate) {
        this.cureoverduelastupddate = cureoverduelastupddate;
    }

    public Date getLastminamountwaiveddate() {
        return lastminamountwaiveddate;
    }

    public void setLastminamountwaiveddate(Date lastminamountwaiveddate) {
        this.lastminamountwaiveddate = lastminamountwaiveddate;
    }

    public Date getStopdailyaccrualrepdate() {
        return stopdailyaccrualrepdate;
    }

    public void setStopdailyaccrualrepdate(Date stopdailyaccrualrepdate) {
        this.stopdailyaccrualrepdate = stopdailyaccrualrepdate;
    }

    public Long getPaymentindicator() {
        return paymentindicator;
    }

    public void setPaymentindicator(Long paymentindicator) {
        this.paymentindicator = paymentindicator;
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

    public String getPrechangerequeststgeneral() {
        return prechangerequeststgeneral;
    }

    public void setPrechangerequeststgeneral(String prechangerequeststgeneral) {
        this.prechangerequeststgeneral = prechangerequeststgeneral;
    }

    public Long getInactive() {
        return inactive;
    }

    public void setInactive(Long inactive) {
        this.inactive = inactive;
    }

    public Long getNextstmtserno() {
        return nextstmtserno;
    }

    public void setNextstmtserno(Long nextstmtserno) {
        this.nextstmtserno = nextstmtserno;
    }

    public Long getNextstmtpartitionkey() {
        return nextstmtpartitionkey;
    }

    public void setNextstmtpartitionkey(Long nextstmtpartitionkey) {
        this.nextstmtpartitionkey = nextstmtpartitionkey;
    }

    public Long getTotalpoints() {
        return totalpoints;
    }

    public void setTotalpoints(Long totalpoints) {
        this.totalpoints = totalpoints;
    }

    public Long getTotalpointtrxns() {
        return totalpointtrxns;
    }

    public void setTotalpointtrxns(Long totalpointtrxns) {
        this.totalpointtrxns = totalpointtrxns;
    }

    public Long getTotalcredits() {
        return totalcredits;
    }

    public void setTotalcredits(Long totalcredits) {
        this.totalcredits = totalcredits;
    }

    public Long getTotaldebits() {
        return totaldebits;
    }

    public void setTotaldebits(Long totaldebits) {
        this.totaldebits = totaldebits;
    }

    public Long getThisperioddue() {
        return thisperioddue;
    }

    public void setThisperioddue(Long thisperioddue) {
        this.thisperioddue = thisperioddue;
    }

    public Long getReturnedpayments() {
        return returnedpayments;
    }

    public void setReturnedpayments(Long returnedpayments) {
        this.returnedpayments = returnedpayments;
    }

    public Long getBackdatedcredits() {
        return backdatedcredits;
    }

    public void setBackdatedcredits(Long backdatedcredits) {
        this.backdatedcredits = backdatedcredits;
    }

    public Long getBackdateddebits() {
        return backdateddebits;
    }

    public void setBackdateddebits(Long backdateddebits) {
        this.backdateddebits = backdateddebits;
    }

    public Long getBackdatedpayments() {
        return backdatedpayments;
    }

    public void setBackdatedpayments(Long backdatedpayments) {
        this.backdatedpayments = backdatedpayments;
    }

    public Long getBackdatedreturnedpayments() {
        return backdatedreturnedpayments;
    }

    public void setBackdatedreturnedpayments(Long backdatedreturnedpayments) {
        this.backdatedreturnedpayments = backdatedreturnedpayments;
    }

    public Date getLastbillingdate() {
        return lastbillingdate;
    }

    public void setLastbillingdate(Date lastbillingdate) {
        this.lastbillingdate = lastbillingdate;
    }

    public String getLastbillingreason() {
        return lastbillingreason;
    }

    public void setLastbillingreason(String lastbillingreason) {
        this.lastbillingreason = lastbillingreason;
    }

    public Date getLasttrxnpostdate() {
        return lasttrxnpostdate;
    }

    public void setLasttrxnpostdate(Date lasttrxnpostdate) {
        this.lasttrxnpostdate = lasttrxnpostdate;
    }

    public Date getLastactivitytrxnpostdate() {
        return lastactivitytrxnpostdate;
    }

    public void setLastactivitytrxnpostdate(Date lastactivitytrxnpostdate) {
        this.lastactivitytrxnpostdate = lastactivitytrxnpostdate;
    }

    public Date getLastallocationdate() {
        return lastallocationdate;
    }

    public void setLastallocationdate(Date lastallocationdate) {
        this.lastallocationdate = lastallocationdate;
    }

    public Long getLastpaymentserno() {
        return lastpaymentserno;
    }

    public void setLastpaymentserno(Long lastpaymentserno) {
        this.lastpaymentserno = lastpaymentserno;
    }

    public Long getLastpaymentpartitionkey() {
        return lastpaymentpartitionkey;
    }

    public void setLastpaymentpartitionkey(Long lastpaymentpartitionkey) {
        this.lastpaymentpartitionkey = lastpaymentpartitionkey;
    }

    public Long getLastbalupdeodserno() {
        return lastbalupdeodserno;
    }

    public void setLastbalupdeodserno(Long lastbalupdeodserno) {
        this.lastbalupdeodserno = lastbalupdeodserno;
    }

    public Long getPrevbalupdeodserno() {
        return prevbalupdeodserno;
    }

    public void setPrevbalupdeodserno(Long prevbalupdeodserno) {
        this.prevbalupdeodserno = prevbalupdeodserno;
    }

    public Long getLastmtpupdeodserno() {
        return lastmtpupdeodserno;
    }

    public void setLastmtpupdeodserno(Long lastmtpupdeodserno) {
        this.lastmtpupdeodserno = lastmtpupdeodserno;
    }

    public Long getPrevmtpupdeodserno() {
        return prevmtpupdeodserno;
    }

    public void setPrevmtpupdeodserno(Long prevmtpupdeodserno) {
        this.prevmtpupdeodserno = prevmtpupdeodserno;
    }

    public Long getInstalmentcount() {
        return instalmentcount;
    }

    public void setInstalmentcount(Long instalmentcount) {
        this.instalmentcount = instalmentcount;
    }

    public Long getInstalmentbalance() {
        return instalmentbalance;
    }

    public void setInstalmentbalance(Long instalmentbalance) {
        this.instalmentbalance = instalmentbalance;
    }

    public Long getInstalmentbalanceprincipal() {
        return instalmentbalanceprincipal;
    }

    public void setInstalmentbalanceprincipal(Long instalmentbalanceprincipal) {
        this.instalmentbalanceprincipal = instalmentbalanceprincipal;
    }

    public Long getIssinstbalance() {
        return issinstbalance;
    }

    public void setIssinstbalance(Long issinstbalance) {
        this.issinstbalance = issinstbalance;
    }

    public Long getAcqinstbalance() {
        return acqinstbalance;
    }

    public void setAcqinstbalance(Long acqinstbalance) {
        this.acqinstbalance = acqinstbalance;
    }

    public Long getCashbalance() {
        return cashbalance;
    }

    public void setCashbalance(Long cashbalance) {
        this.cashbalance = cashbalance;
    }

    public Long getPaidinfullbalance() {
        return paidinfullbalance;
    }

    public void setPaidinfullbalance(Long paidinfullbalance) {
        this.paidinfullbalance = paidinfullbalance;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Long getChargeoffamount() {
        return chargeoffamount;
    }

    public void setChargeoffamount(Long chargeoffamount) {
        this.chargeoffamount = chargeoffamount;
    }

    public Date getChargeoffdate() {
        return chargeoffdate;
    }

    public void setChargeoffdate(Date chargeoffdate) {
        this.chargeoffdate = chargeoffdate;
    }

    public Date getClosedate() {
        return closedate;
    }

    public void setClosedate(Date closedate) {
        this.closedate = closedate;
    }

    public Long getExcesspaymentamount() {
        return excesspaymentamount;
    }

    public void setExcesspaymentamount(Long excesspaymentamount) {
        this.excesspaymentamount = excesspaymentamount;
    }

    public Long getLatepaymentfee() {
        return latepaymentfee;
    }

    public void setLatepaymentfee(Long latepaymentfee) {
        this.latepaymentfee = latepaymentfee;
    }

    public Long getLatepaymentfeetrxnserno() {
        return latepaymentfeetrxnserno;
    }

    public void setLatepaymentfeetrxnserno(Long latepaymentfeetrxnserno) {
        this.latepaymentfeetrxnserno = latepaymentfeetrxnserno;
    }

    public Long getLatepaymentfeetrxnpartitionkey() {
        return latepaymentfeetrxnpartitionkey;
    }

    public void setLatepaymentfeetrxnpartitionkey(Long latepaymentfeetrxnpartitionkey) {
        this.latepaymentfeetrxnpartitionkey = latepaymentfeetrxnpartitionkey;
    }

    public Long getActivitysincelaststatement() {
        return activitysincelaststatement;
    }

    public void setActivitysincelaststatement(Long activitysincelaststatement) {
        this.activitysincelaststatement = activitysincelaststatement;
    }

    public String getTransactorhistory() {
        return transactorhistory;
    }

    public void setTransactorhistory(String transactorhistory) {
        this.transactorhistory = transactorhistory;
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

    public Long getStatementinstalmentsactivenum() {
        return statementinstalmentsactivenum;
    }

    public void setStatementinstalmentsactivenum(Long statementinstalmentsactivenum) {
        this.statementinstalmentsactivenum = statementinstalmentsactivenum;
    }

    public Long getAutoredeemcyclestoskip() {
        return autoredeemcyclestoskip;
    }

    public void setAutoredeemcyclestoskip(Long autoredeemcyclestoskip) {
        this.autoredeemcyclestoskip = autoredeemcyclestoskip;
    }

    public Long getCollectorcase() {
        return collectorcase;
    }

    public void setCollectorcase(Long collectorcase) {
        this.collectorcase = collectorcase;
    }

    public Long getDormantacctypeserno() {
        return dormantacctypeserno;
    }

    public void setDormantacctypeserno(Long dormantacctypeserno) {
        this.dormantacctypeserno = dormantacctypeserno;
    }

    public Long getRepaymentplanserno() {
        return repaymentplanserno;
    }

    public void setRepaymentplanserno(Long repaymentplanserno) {
        this.repaymentplanserno = repaymentplanserno;
    }

    public Long getRepaymentplanpartitionkey() {
        return repaymentplanpartitionkey;
    }

    public void setRepaymentplanpartitionkey(Long repaymentplanpartitionkey) {
        this.repaymentplanpartitionkey = repaymentplanpartitionkey;
    }

    public Long getMbhagreementserno() {
        return mbhagreementserno;
    }

    public void setMbhagreementserno(Long mbhagreementserno) {
        this.mbhagreementserno = mbhagreementserno;
    }

    public TIMESTAMP getMbhagreementexpirydate() {
        return mbhagreementexpirydate;
    }

    public void setMbhagreementexpirydate(TIMESTAMP mbhagreementexpirydate) {
        this.mbhagreementexpirydate = mbhagreementexpirydate;
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

    public String getLanguagecode() {
        return languagecode;
    }

    public void setLanguagecode(String languagecode) {
        this.languagecode = languagecode;
    }

    public String getLogaction() {
        return logaction;
    }

    public void setLogaction(String logaction) {
        this.logaction = logaction;
    }

    public Long getEntityversionno() {
        return entityversionno;
    }

    public void setEntityversionno(Long entityversionno) {
        this.entityversionno = entityversionno;
    }

    public Long getConverted() {
        return converted;
    }

    public void setConverted(Long converted) {
        this.converted = converted;
    }
}
