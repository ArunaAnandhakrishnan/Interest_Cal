package com.vernite.cal.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Products {

	private Long institutionId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serno;

	@OneToMany(mappedBy = "products")
	private List<Cardx> cardxsLists;

	// private Long institution_id;
	// private Long serno;
	private String shortcode;
	private String groupcode;
	private String name;
	private Long namestringid;
	private String description;
	private Long descriptionstringid;
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

	public List<Cardx> getCardxsLists() {
		return cardxsLists;
	}

	public String getName() {
		return name;
	}

	public void setSerno(Long serno) {
		this.serno = serno;
	}

	public void setCardxsLists(List<Cardx> cardxsLists) {
		this.cardxsLists = cardxsLists;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getInstitutionId() {
		return institutionId;
	}

	public String getShortcode() {
		return shortcode;
	}

	public String getGroupcode() {
		return groupcode;
	}

	public Long getNamestringid() {
		return namestringid;
	}

	public String getDescription() {
		return description;
	}

	public Long getDescriptionstringid() {
		return descriptionstringid;
	}

	public String getAppliestocustomer() {
		return appliestocustomer;
	}

	public String getAppliestoaccount() {
		return appliestoaccount;
	}

	public String getAppliestocard() {
		return appliestocard;
	}

	public String getAppliestoriskdomain() {
		return appliestoriskdomain;
	}

	public String getAppliestoproxycard() {
		return appliestoproxycard;
	}

	public String getAppliestomercustomer() {
		return appliestomercustomer;
	}

	public String getAppliestomeraccount() {
		return appliestomeraccount;
	}

	public String getAppliestomerchant() {
		return appliestomerchant;
	}

	public String getAppliestoterminal() {
		return appliestoterminal;
	}

	public String getAppliestoloan() {
		return appliestoloan;
	}

	public Long getSuppressdisplay() {
		return suppressdisplay;
	}

	public void setInstitutionId(Long institutionId) {
		this.institutionId = institutionId;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public void setGroupcode(String groupcode) {
		this.groupcode = groupcode;
	}

	public void setNamestringid(Long namestringid) {
		this.namestringid = namestringid;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDescriptionstringid(Long descriptionstringid) {
		this.descriptionstringid = descriptionstringid;
	}

	public void setAppliestocustomer(String appliestocustomer) {
		this.appliestocustomer = appliestocustomer;
	}

	public void setAppliestoaccount(String appliestoaccount) {
		this.appliestoaccount = appliestoaccount;
	}

	public void setAppliestocard(String appliestocard) {
		this.appliestocard = appliestocard;
	}

	public void setAppliestoriskdomain(String appliestoriskdomain) {
		this.appliestoriskdomain = appliestoriskdomain;
	}

	public void setAppliestoproxycard(String appliestoproxycard) {
		this.appliestoproxycard = appliestoproxycard;
	}

	public void setAppliestomercustomer(String appliestomercustomer) {
		this.appliestomercustomer = appliestomercustomer;
	}

	public void setAppliestomeraccount(String appliestomeraccount) {
		this.appliestomeraccount = appliestomeraccount;
	}

	public void setAppliestomerchant(String appliestomerchant) {
		this.appliestomerchant = appliestomerchant;
	}

	public void setAppliestoterminal(String appliestoterminal) {
		this.appliestoterminal = appliestoterminal;
	}

	public void setAppliestoloan(String appliestoloan) {
		this.appliestoloan = appliestoloan;
	}

	public void setSuppressdisplay(Long suppressdisplay) {
		this.suppressdisplay = suppressdisplay;
	}

}
