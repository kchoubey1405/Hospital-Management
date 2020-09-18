/**
 * 
 */
package com.myproject.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.myproject.persistent.util.BaseDo;

/**
 * @author Kamlesh.Choubey
 *
 */

@Entity
@Table(name = "DOCTOR_DETAILS")
public class DoctorDo implements BaseDo {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "DOCTOR_ID", length = 100)
	private String doctorId;
	@Column(name = "EMP_ID", nullable = false)
	private String empId;

	@Column(name = "DOCTOR_NAME", length = 100)
	private String doctorName;
	@Column(name = "DEPARTMENT", length = 50)
	private String department;
	@Column(name = "TOTAL_EXPERIENCE")
	private BigDecimal experience;
	@Column(name = "SPECIALITY", length = 50)
	private String speciality;
	@Column(name = "HIGHEST_QUALIFICATION", length = 100)
	private String highestQualification;
	@Column(name = "CONSULTATION_CHARGE")
	private BigDecimal consulationCharge;
	@Column(name = "DESIGNATION", length = 50)
	private String designation;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public BigDecimal getExperience() {
		return experience;
	}

	public void setExperience(BigDecimal experience) {
		this.experience = experience;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getHighestQualification() {
		return highestQualification;
	}

	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}

	public BigDecimal getConsulationCharge() {
		return consulationCharge;
	}

	public void setConsulationCharge(BigDecimal consulationCharge) {
		this.consulationCharge = consulationCharge;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "DoctorDo [empId=" + empId + ", doctorId=" + doctorId + ", doctorName=" + doctorName + ", department="
				+ department + ", experience=" + experience + ", speciality=" + speciality + ", highestQualification="
				+ highestQualification + ", consulationCharge=" + consulationCharge + ", designation=" + designation
				+ "]";
	}

}
