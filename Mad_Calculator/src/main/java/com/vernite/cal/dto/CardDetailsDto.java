package com.vernite.cal.dto;

public class CardDetailsDto {

    private String cardNumber;
    private Long mobileNo;
    private Long cardSerno;
    private String custIdNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Long getCardSerno() {
        return cardSerno;
    }

    public void setCardSerno(Long cardSerno) {
        this.cardSerno = cardSerno;
    }

    public String getCustIdNumber() {
        return custIdNumber;
    }

    public void setCustIdNumber(String custIdNumber) {
        this.custIdNumber = custIdNumber;
    }
}
