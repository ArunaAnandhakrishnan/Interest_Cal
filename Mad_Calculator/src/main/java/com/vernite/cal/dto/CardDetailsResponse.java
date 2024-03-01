package com.vernite.cal.dto;

import java.util.List;

import com.vernite.cal.model.Caccounts;
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

}
