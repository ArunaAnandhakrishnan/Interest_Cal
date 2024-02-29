package com.vernite.cal.dto;

import java.util.List;

import com.vernite.cal.model.Caccounts;
import com.vernite.cal.model.Cstmtsettings;
import com.vernite.cal.model.Products;
import com.vernite.cal.model.Profiles;

public class CardDetailsResponse {

	private Long serno;
	private String numberx;
	private String stgeneral;
	private String transactorhistory;
	private String name;
	private String description;
	private Long minpaypercentage;

	public Long getSerno() {
		return serno;
	}

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

	public void setSerno(Long serno) {
		this.serno = serno;
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

	List<Caccounts> caccountsList;
	List<Products> productsList;
	List<Cstmtsettings> cstmtsettingsList;
	List<Profiles> profilesList;

	public List<Caccounts> getCaccountsList() {
		return caccountsList;
	}

	public List<Products> getProductsList() {
		return productsList;
	}

	public List<Cstmtsettings> getCstmtsettingsList() {
		return cstmtsettingsList;
	}

	public List<Profiles> getProfilesList() {
		return profilesList;
	}

	public void setCaccountsList(List<Caccounts> caccountsList) {
		this.caccountsList = caccountsList;
	}

	public void setProductsList(List<Products> productsList) {
		this.productsList = productsList;
	}

	public void setCstmtsettingsList(List<Cstmtsettings> cstmtsettingsList) {
		this.cstmtsettingsList = cstmtsettingsList;
	}

	public void setProfilesList(List<Profiles> profilesList) {
		this.profilesList = profilesList;
	}

}
