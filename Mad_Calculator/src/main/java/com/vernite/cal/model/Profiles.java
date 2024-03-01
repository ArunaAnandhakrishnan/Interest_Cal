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

}
