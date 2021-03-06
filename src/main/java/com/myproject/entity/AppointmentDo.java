/**
 * 
 */
package com.myproject.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.myproject.persistent.util.BaseDo;

/**
 * @author Kamlesh.Choubey
 *
 */

@Entity
@Table(name="APPOINTMENTS")
public class AppointmentDo implements BaseDo{

	@Id
	@Column(name = "APPOINTMENT_ID", length = 100)
	private String appointmentId;
	@Column(name = "DISEASE_DESC", length = 250)
	private String diseaseDesc;
	@Column(name = "ADVISE", length = 250)
	private String advise;
	@Column(name = "PATIENT_ID", length = 100)
	private String patientId;
	@Column(name = "DOCTOR_ID", length = 100)
	private String doctorId;
	@Column(name = "HEIGHT")
	private BigDecimal height;
	@Column(name = "WEIGHT")
	private BigDecimal weight;
	@Column(name = "BP", length = 100)
	private String Bp;
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
	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}

}
