/**
 * 
 */
package com.myproject.dto;

import java.math.BigDecimal;

import com.myproject.persistent.util.BaseDto;

/**
 * @author Kamlesh.Choubey
 *
 */
public class PrescribedMedsDto extends BaseDto{
	private String prescribedMedId;
	private String medName;
	private BigDecimal days;
	private BigDecimal cost;
	private String billId;
	private BigDecimal comment;
	private String dosage;
	private String appointmentId;
	public String getPrescribedMedId() {
		return prescribedMedId;
	}
	public void setPrescribedMedId(String prescribedMedId) {
		this.prescribedMedId = prescribedMedId;
	}
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	public BigDecimal getDays() {
		return days;
	}
	public void setDays(BigDecimal days) {
		this.days = days;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	
	public BigDecimal getComment() {
		return comment;
	}
	public void setComment(BigDecimal comment) {
		this.comment = comment;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}
	@Override
	public Boolean getValidForUsage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	}
