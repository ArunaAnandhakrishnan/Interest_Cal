package com.vernite.cal.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionDetailsDto {


    private BigDecimal outstandingamount;
    private Long minpaypercentage;
    private BigDecimal amount;
    private BigDecimal madAmount;
    private Double overDueAmount;
    private Double overLimitAmount;
    private BigDecimal mad;
    private Long trxnSerno;
    private String cycleDate;
    private String accountNo;
    private String cardNo;

    public BigDecimal getOutstandingamount() {
        return outstandingamount;
    }

    public void setOutstandingamount(BigDecimal outstandingamount) {
        this.outstandingamount = outstandingamount;
    }

    public Long getMinpaypercentage() {
        return minpaypercentage;
    }

    public void setMinpaypercentage(Long minpaypercentage) {
        this.minpaypercentage = minpaypercentage;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getMadAmount() {
        return madAmount;
    }

    public void setMadAmount(BigDecimal madAmount) {
        this.madAmount = madAmount;
    }

    public Double getOverDueAmount() {
        return overDueAmount;
    }

    public void setOverDueAmount(Double overDueAmount) {
        this.overDueAmount = overDueAmount;
    }

    public Double getOverLimitAmount() {
        return overLimitAmount;
    }

    public void setOverLimitAmount(Double overLimitAmount) {
        this.overLimitAmount = overLimitAmount;
    }

    public BigDecimal getMad() {
        return mad;
    }

    public void setMad(BigDecimal mad) {
        this.mad = mad;
    }

    public Long getTrxnSerno() {
        return trxnSerno;
    }

    public void setTrxnSerno(Long trxnSerno) {
        this.trxnSerno = trxnSerno;
    }

    public String getCycleDate() {
        return cycleDate;
    }

    public void setCycleDate(String cycleDate) {
        this.cycleDate = cycleDate;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
