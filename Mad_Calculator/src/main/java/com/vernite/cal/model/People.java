package com.vernite.cal.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "PEOPLE")
public class People {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serno;

	private int institution_id;

	private String title;
	private String lastname;
	private String firstname;
	private String midname;
	private String mothername;
	private String organization;
	private String department;
	private String position;
	private Date dob;
	private int persontype;
	private char sex;
	private char maritalstatus;
	private String ssnumber;
	private char custidnumber;
	private char resident;
	private int legalentity;
	private String employeeid;
	private String nationalid;
	private char stgeneral;
	private String languagecode;
	private char logaction;
	private char ll_title;
	private char ll_firstname;
	private char ll_midname;
	private String ll_lastname;
	private String ll_mothername;
	private String ll_organization;
	private String ll_department;
	private String ll_position;
	private String externalreference;
	private Date createdate;
	private int entityversionno;
	private int converted;


}
