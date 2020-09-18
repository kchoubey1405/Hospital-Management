/**
 * 
 */
package com.myproject.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.myproject.persistent.util.BaseDto;

/**
 * @author Kamlesh.Choubey
 *
 */
public class AppointmentDto extends BaseDto{
	private String appointmentId;
	private String diseaseDesc;
	private String advise;
	private String patientId;
	private String doctorId;
	private BigDecimal height;
	private BigDecimal weight;
	private String Bp;
	private Date createdAt;
	

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getDiseaseDesc() {
		return diseaseDesc;
	}

	public void setDiseaseDesc(String diseaseDesc) {
		this.diseaseDesc = diseaseDesc;
	}

	public String getAdvise() {
		return advise;
	}

	public void setAdvise(String advise) {
		this.advise = advise;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getBp() {
		return Bp;
	}

	public void setBp(String bp) {
		Bp = bp;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	

	@Override
	public String toString() {
		return "AppointmentDto [appointmentId=" + appointmentId + ", diseaseDesc=" + diseaseDesc + ", advise=" + advise
				+ ", patientId=" + patientId + ", doctorId=" + doctorId + ", height=" + height + ", weight=" + weight
				+ ", Bp=" + Bp + ", createdAt=" + createdAt + "]";
	}

	@Override
	public Boolean getValidForUsage() {
		// TODO Auto-generated method stub
		return null;
	}

}
