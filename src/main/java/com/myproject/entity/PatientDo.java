/**
 * 
 */
package com.myproject.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Kamlesh.Choubey
 *
 */

@Entity
@Table(name = "PATIENT_DETAILS")
public class PatientDo {

	@Id
	@Column(name = "PATIENT_ID")
	private String patientId;

	@Column(name = "PATIENT_NAME", length = 50)
	private String patientName;

	@Column(name = "GUARD_NAME", length = 50)
	private String guardiansName;

	@Column(name = "AGE")
	private Integer age;

	@Column(name = "CONTACT_NUM")
	private Long contactNum;

	@Column(name = "ALT_CONTACT_NUM")
	private Long altContactNum;

	@Column(name = "STREET", length = 250)
	private String street;

	@Column(name = "STATE", length = 50)
	private String state;

	@Column(name = "COUNTRY", length = 50)
	private String country;

	@Column(name = "POSTAL_CODE")
	private Long postalCode;

	@Column(name = "REFERED_FROM", length = 250)
	private String referedFrom;

	@Column(name = "REFERED_TO", length = 250)
	private String referedTo;

	@Column(name = "DISEASE_DESC", length = 250)
	private String diseaseDesc;

	@Column(name = "VISIT_TYPE", length = 30)
	private String visitType;

	@Column(name = "CREATED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getGuardiansName() {
		return guardiansName;
	}

	public void setGuardiansName(String guardiansName) {
		this.guardiansName = guardiansName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getContactNum() {
		return contactNum;
	}

	public void setContactNum(Long contactNum) {
		this.contactNum = contactNum;
	}

	public Long getAltContactNum() {
		return altContactNum;
	}

	public void setAltContactNum(Long altContactNum) {
		this.altContactNum = altContactNum;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Long postalCode) {
		this.postalCode = postalCode;
	}

	public String getReferedFrom() {
		return referedFrom;
	}

	public void setReferedFrom(String referedFrom) {
		this.referedFrom = referedFrom;
	}

	public String getReferedTo() {
		return referedTo;
	}

	public void setReferedTo(String referedTo) {
		this.referedTo = referedTo;
	}

	public String getDiseaseDesc() {
		return diseaseDesc;
	}

	public void setDiseaseDesc(String diseaseDesc) {
		this.diseaseDesc = diseaseDesc;
	}

	public String getVisitType() {
		return visitType;
	}

	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
