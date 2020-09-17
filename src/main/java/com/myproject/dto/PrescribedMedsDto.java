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
	public Boolean getValidForUsage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	}
