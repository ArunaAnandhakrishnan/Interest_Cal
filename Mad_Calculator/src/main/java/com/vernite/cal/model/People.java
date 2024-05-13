package com.vernite.cal.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
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

	public int getInstitution_id() {
		return institution_id;
	}

	public void setInstitution_id(int institution_id) {
		this.institution_id = institution_id;
	}

	public long getSerno() {
		return serno;
	}

	public void setSerno(long serno) {
		this.serno = serno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setSerno(Long serno) {
		this.serno = serno;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMidname() {
		return midname;
	}

	public void setMidname(String midname) {
		this.midname = midname;
	}

	public String getMothername() {
		return mothername;
	}

	public void setMothername(String mothername) {
		this.mothername = mothername;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getPersontype() {
		return persontype;
	}

	public void setPersontype(int persontype) {
		this.persontype = persontype;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public char getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(char maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public String getSsnumber() {
		return ssnumber;
	}

	public void setSsnumber(String ssnumber) {
		this.ssnumber = ssnumber;
	}

	public char getCustidnumber() {
		return custidnumber;
	}

	public void setCustidnumber(char custidnumber) {
		this.custidnumber = custidnumber;
	}

	public char getResident() {
		return resident;
	}

	public void setResident(char resident) {
		this.resident = resident;
	}

	public int getLegalentity() {
		return legalentity;
	}

	public void setLegalentity(int legalentity) {
		this.legalentity = legalentity;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getNationalid() {
		return nationalid;
	}

	public void setNationalid(String nationalid) {
		this.nationalid = nationalid;
	}

	public char getStgeneral() {
		return stgeneral;
	}

	public void setStgeneral(char stgeneral) {
		this.stgeneral = stgeneral;
	}

	public String getLanguagecode() {
		return languagecode;
	}

	public void setLanguagecode(String languagecode) {
		this.languagecode = languagecode;
	}

	public char getLogaction() {
		return logaction;
	}

	public void setLogaction(char logaction) {
		this.logaction = logaction;
	}

	public char getLl_title() {
		return ll_title;
	}

	public void setLl_title(char ll_title) {
		this.ll_title = ll_title;
	}

	public char getLl_firstname() {
		return ll_firstname;
	}

	public void setLl_firstname(char ll_firstname) {
		this.ll_firstname = ll_firstname;
	}

	public char getLl_midname() {
		return ll_midname;
	}

	public void setLl_midname(char ll_midname) {
		this.ll_midname = ll_midname;
	}

	public String getLl_lastname() {
		return ll_lastname;
	}

	public void setLl_lastname(String ll_lastname) {
		this.ll_lastname = ll_lastname;
	}

	public String getLl_mothername() {
		return ll_mothername;
	}

	public void setLl_mothername(String ll_mothername) {
		this.ll_mothername = ll_mothername;
	}

	public String getLl_organization() {
		return ll_organization;
	}

	public void setLl_organization(String ll_organization) {
		this.ll_organization = ll_organization;
	}

	public String getLl_department() {
		return ll_department;
	}

	public void setLl_department(String ll_department) {
		this.ll_department = ll_department;
	}

	public String getLl_position() {
		return ll_position;
	}

	public void setLl_position(String ll_position) {
		this.ll_position = ll_position;
	}

	public String getExternalreference() {
		return externalreference;
	}

	public void setExternalreference(String externalreference) {
		this.externalreference = externalreference;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public int getEntityversionno() {
		return entityversionno;
	}

	public void setEntityversionno(int entityversionno) {
		this.entityversionno = entityversionno;
	}

	public int getConverted() {
		return converted;
	}

	public void setConverted(int converted) {
		this.converted = converted;
	}

}
