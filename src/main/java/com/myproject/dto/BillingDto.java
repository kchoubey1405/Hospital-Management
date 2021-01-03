/**
 * 
 */
package com.myproject.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Kamlesh.Choubey
 *
 */
public class BillingDto {
	private Integer billId;
	private String billType;
	private Date createdAt;
	private String paymentStatus;
	private String paymentMode;
	private String patientId;
	private BigDecimal totalCost;
	private List<BillDetailsDto> billDetailList;

	

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public List<BillDetailsDto> getBillDetailList() {
		return billDetailList;
	}

	public void setBillDetailList(List<BillDetailsDto> billDetailList) {
		this.billDetailList = billDetailList;
	}

	
}
