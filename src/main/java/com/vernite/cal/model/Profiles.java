package com.vernite.cal.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Profiles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serno;

	@OneToMany(mappedBy = "profiles")
	private List<Mprofileacct> mprofileacctsLists;

	@OneToMany(mappedBy = "profiles")
	private List<Cstmtsettings> cstmtsettingsList;

	private Long institution_id;
	// serno NUMBER(10) not null,
	private String usedfor;
	private String shortcode;
	private Long corpindicator;
	private String description;
	private Long logversion;
	private Long rowserno;
	private Long tabindicator;
	private Long usedforcampaigns;
	private long appliestorp;

	public Long getSerno() {
		return serno;
	}

	public String getDescription() {
		return description;
	}

	public Long getLogversion() {
		return logversion;
	}

	public void setSerno(Long serno) {
		this.serno = serno;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLogversion(Long logversion) {
		this.logversion = logversion;
	}

	public List<Mprofileacct> getMprofileacctsLists() {
		return mprofileacctsLists;
	}

	public List<Cstmtsettings> getCstmtsettingsList() {
		return cstmtsettingsList;
	}

	public Long getInstitution_id() {
		return institution_id;
	}

	public String getUsedfor() {
		return usedfor;
	}

	public String getShortcode() {
		return shortcode;
	}

	public Long getCorpindicator() {
		return corpindicator;
	}

	public Long getRowserno() {
		return rowserno;
	}

	public Long getTabindicator() {
		return tabindicator;
	}

	public Long getUsedforcampaigns() {
		return usedforcampaigns;
	}

	public long getAppliestorp() {
		return appliestorp;
	}

	public void setMprofileacctsLists(List<Mprofileacct> mprofileacctsLists) {
		this.mprofileacctsLists = mprofileacctsLists;
	}

	public void setCstmtsettingsList(List<Cstmtsettings> cstmtsettingsList) {
		this.cstmtsettingsList = cstmtsettingsList;
	}

	public void setInstitution_id(Long institution_id) {
		this.institution_id = institution_id;
	}

	public void setUsedfor(String usedfor) {
		this.usedfor = usedfor;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public void setCorpindicator(Long corpindicator) {
		this.corpindicator = corpindicator;
	}

	public void setRowserno(Long rowserno) {
		this.rowserno = rowserno;
	}

	public void setTabindicator(Long tabindicator) {
		this.tabindicator = tabindicator;
	}

	public void setUsedforcampaigns(Long usedforcampaigns) {
		this.usedforcampaigns = usedforcampaigns;
	}

	public void setAppliestorp(long appliestorp) {
		this.appliestorp = appliestorp;
	}

}
