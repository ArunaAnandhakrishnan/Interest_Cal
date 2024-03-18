package com.vernite.cal.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionDetailsDto {

    //    private String transactionDate;
//    private String description;
//    private String recType;
//    private String transactionCurrency;
//    private BigDecimal transactionAmount;
//    private BigDecimal billingAmount;
//    private String billingCurrency;
    private BigDecimal outstandingamount;
    private Long minpaypercentage;
    private BigDecimal amount;
    private BigDecimal madAmount;

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
}
