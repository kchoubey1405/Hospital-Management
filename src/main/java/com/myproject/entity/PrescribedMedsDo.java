/**
 * 
 */
package com.myproject.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.myproject.persistent.util.BaseDo;

/**
 * @author Kamlesh.Choubey
 *
 */

@Entity
@Table(name="PRESC_MEDS")
public class PrescribedMedsDo implements BaseDo{

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "PRESC_MED_ID", length = 100)
	private String prescribedMedId;
	@Column(name = "MED_NAME", length = 100)
	private String medName;
	@Column(name = "DAYS")
	private BigDecimal days;
	@Column(name = "COST")
	private BigDecimal cost;
	@Column(name = "BILL_ID", length = 100)
	private String billId;
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
	@Override
	public String toString() {
		return "PrescribedMedsDto [prescribedMedId=" + prescribedMedId + ", medName=" + medName + ", days=" + days
				+ ", cost=" + cost + ", billId=" + billId + "]";
	}
	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
