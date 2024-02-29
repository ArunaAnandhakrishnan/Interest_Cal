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

}
