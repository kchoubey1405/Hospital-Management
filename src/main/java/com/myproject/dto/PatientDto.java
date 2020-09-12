/**
 * 
 */
package com.myproject.dto;

import java.util.Date;

/**
 * @author Kamlesh.Choubey
 *
 */

public class PatientDto {

	private String patientId;
	private String patientName;
	private String guardiansName;
	private Integer age;
	private Long contactNum;
	private Long altContactNum;
	private String street;
	private String state;
	private String country;
	private Long postalCode;
	private String referedFrom;
	private String referedTo;
	private String diseaseDesc;
	private String visitType;
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
	public String getReferedTo() {
		return referedTo;
	}
	public void setReferedTo(String referedTo) {
		this.referedTo = referedTo;
	}
	@Override
	public String toString() {
		return "PatientDto [patientId=" + patientId + ", patientName=" + patientName + ", guardiansName="
				+ guardiansName + ", age=" + age + ", contactNum=" + contactNum + ", altContactNum=" + altContactNum
				+ ", street=" + street + ", state=" + state + ", country=" + country + ", postalCode=" + postalCode
				+ ", referedFrom=" + referedFrom + ", referedTo=" + referedTo + ", diseaseDesc=" + diseaseDesc
				+ ", visitType=" + visitType + ", createdAt=" + createdAt + "]";
	}
	
}
