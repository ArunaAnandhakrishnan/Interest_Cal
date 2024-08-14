package com.vernite.cal.dto;

import java.util.List;

import com.vernite.cal.model.Cardx;

public class ProductsDto {

	private Long serno;
	private String shortcode;
	private String groupcode;
	private String name;
	private String namestringid;
	private String description;
	private String descriptionstringid;
	private String appliestocustomer;
	private String appliestoaccount;
	private String appliestocard;
	private String appliestoriskdomain;
	private String appliestoproxycard;
	private String appliestomercustomer;
	private String appliestomeraccount;
	private String appliestomerchant;
	private String appliestoterminal;
	private String appliestoloan;
	private Long suppressdisplay;

	public Long getSerno() {
		return serno;
	}

	public String getName() {
		return name;
	}

	public void setSerno(Long serno) {
		this.serno = serno;
	}

	public void setName(String name) {
		this.name = name;
	}

}
