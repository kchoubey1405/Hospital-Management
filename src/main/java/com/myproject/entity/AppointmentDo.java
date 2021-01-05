/**
 * 
 */
package com.myproject.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.myproject.persistent.util.BaseDo;

/**
 * @author Kamlesh.Choubey
 *
 */

@Entity
@Table(name="APPOINTMENTS")
public class AppointmentDo implements BaseDo{

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "APPOINTMENT_ID", length = 100)
	private String appointmentId;
	@Column(name = "DISEASE_DESC", length = 250)
	private String diseaseDesc;
	@Column(name = "ADVISE", length = 250)
	private String advise;
	@Column(name = "PATIENT_ID", length = 100)
	private String patientId;
	@Column(name = "PATIENT_NAME", length = 100)
	private String patientName;
	@Column(name = "DOCTOR_ID", length = 100)
	private String doctorId;
	@Column(name = "HEIGHT")
	private BigDecimal height;
	@Column(name = "WEIGHT")
	private BigDecimal weight;
	@Column(name = "TEMPERATURE")
	private BigDecimal temprature;
	@Column(name = "BP", length = 100)
	private String Bp;
	@Column(name = "CREATED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	@Column(name = "APPOINTMENT_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date appointmentDate;
	@Column(name = "STATUS", length = 10)
	private String status;
	
	@Column(name="TIME_SLOT", length=20)
	private String timeSlot;
	
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
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
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public BigDecimal getTemprature() {
		return temprature;
	}
	public void setTemprature(BigDecimal temprature) {
		this.temprature = temprature;
	}
	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}

}
