package com.vernite.cal.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Caddresslinks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serno;
	private int institution_id;
	private char tabindicator;
	private int rowserno;
	private int addressserno;
	private char addresstype;
	private Date fromdate;
	private Date untildate;
	private int addresslinktype1sourceserno;
	private int addresslinktype2sourceserno;
	private int addresslinktype3sourceserno;
	private int addresslinktype4sourceserno;
	private int addresslinktype5sourceserno;
	private char logaction;
	private int converted;

	public int getInstitution_id() {
		return institution_id;
	}

	public void setInstitution_id(int institution_id) {
		this.institution_id = institution_id;
	}

	public Long getSerno() {
		return serno;
	}

	public void setSerno(Long serno) {
		this.serno = serno;
	}

	public char getTabindicator() {
		return tabindicator;
	}

	public void setTabindicator(char tabindicator) {
		this.tabindicator = tabindicator;
	}

	public int getRowserno() {
		return rowserno;
	}

	public void setRowserno(int rowserno) {
		this.rowserno = rowserno;
	}

	public int getAddressserno() {
		return addressserno;
	}

	public void setAddressserno(int addressserno) {
		this.addressserno = addressserno;
	}

	public char getAddresstype() {
		return addresstype;
	}

	public void setAddresstype(char addresstype) {
		this.addresstype = addresstype;
	}

	public Date getFromdate() {
		return fromdate;
	}

	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}

	public Date getUntildate() {
		return untildate;
	}

	public void setUntildate(Date untildate) {
		this.untildate = untildate;
	}

	public int getAddresslinktype1sourceserno() {
		return addresslinktype1sourceserno;
	}

	public void setAddresslinktype1sourceserno(int addresslinktype1sourceserno) {
		this.addresslinktype1sourceserno = addresslinktype1sourceserno;
	}

	public int getAddresslinktype2sourceserno() {
		return addresslinktype2sourceserno;
	}

	public void setAddresslinktype2sourceserno(int addresslinktype2sourceserno) {
		this.addresslinktype2sourceserno = addresslinktype2sourceserno;
	}

	public int getAddresslinktype3sourceserno() {
		return addresslinktype3sourceserno;
	}

	public void setAddresslinktype3sourceserno(int addresslinktype3sourceserno) {
		this.addresslinktype3sourceserno = addresslinktype3sourceserno;
	}

	public int getAddresslinktype4sourceserno() {
		return addresslinktype4sourceserno;
	}

	public void setAddresslinktype4sourceserno(int addresslinktype4sourceserno) {
		this.addresslinktype4sourceserno = addresslinktype4sourceserno;
	}

	public int getAddresslinktype5sourceserno() {
		return addresslinktype5sourceserno;
	}

	public void setAddresslinktype5sourceserno(int addresslinktype5sourceserno) {
		this.addresslinktype5sourceserno = addresslinktype5sourceserno;
	}

	public char getLogaction() {
		return logaction;
	}

	public void setLogaction(char logaction) {
		this.logaction = logaction;
	}

	public int getConverted() {
		return converted;
	}

	public void setConverted(int converted) {
		this.converted = converted;
	}

}
