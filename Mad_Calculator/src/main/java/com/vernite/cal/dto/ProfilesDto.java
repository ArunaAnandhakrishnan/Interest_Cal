package com.vernite.cal.dto;

import java.util.List;

import com.vernite.cal.model.Cstmtsettings;
import com.vernite.cal.model.Mprofileacct;

public class ProfilesDto {
	private Long institution_id;
	private Long serno;
	private String usedfor;
	private String shortcode;
	private Long corpindicator;
	private String description;
	private String logversion;
	private Long rowserno;
	private String tabindicator;
	private String usedforcampaigns;
	private long appliestorp;

	public Long getSerno() {
		return serno;
	}

	public String getDescription() {
		return description;
	}

	public void setSerno(Long serno) {
		this.serno = serno;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
