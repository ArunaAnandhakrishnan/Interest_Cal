package com.vernite.cal.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.vernite.cal.model.Caccounts;
import com.vernite.cal.model.Cstatements;
import com.vernite.cal.model.Cstmtsettings;
import com.vernite.cal.model.Products;
import com.vernite.cal.model.Profiles;

public class CardDetailsResponse {

	private String numberx;
	private String stgeneral;
	private String transactorhistory;
	private String name;
	private String description;
	private Long minpaypercentage;
	private String stgeneralCard;
	private Long primarycard;
	private String expirydatestatus;
	private String cardNumber;
	private List<String> cycleDate;

	private List<String> accountNo;

    public String getNumberx() {
		return numberx;
	}

	public String getStgeneral() {
		return stgeneral;
	}

	public String getTransactorhistory() {
		return transactorhistory;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Long getMinpaypercentage() {
		return minpaypercentage;
	}

	public void setNumberx(String numberx) {
		this.numberx = numberx;
	}

	public void setStgeneral(String stgeneral) {
		this.stgeneral = stgeneral;
	}

	public void setTransactorhistory(String transactorhistory) {
		this.transactorhistory = transactorhistory;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMinpaypercentage(Long minpaypercentage) {
		this.minpaypercentage = minpaypercentage;
	}

	public String getStgeneralCard() {
		return stgeneralCard;
	}

	public Long getPrimarycard() {
		return primarycard;
	}

	public void setStgeneralCard(String stgeneralCard) {
		this.stgeneralCard = stgeneralCard;
	}

	public void setPrimarycard(Long primarycard) {
		this.primarycard = primarycard;
	}

	public String getExpirydatestatus() {
		return expirydatestatus;
	}

	public void setExpirydatestatus(String expirydatestatus) {
		this.expirydatestatus = expirydatestatus;
	}

	public List<String> getCycleDate() {
		return cycleDate;
	}

	public void setCycleDate(List<String> cycleDate) {
		this.cycleDate = cycleDate;
	}


	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public List<String> getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(List<String> accountNo) {
		this.accountNo = accountNo;
	}
}
