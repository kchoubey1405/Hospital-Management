/**
 * 
 */
package com.myproject.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Kamlesh.Choubey
 *
 */
@Entity
@Table(name="BILL_MAP")
public class BillMap {
	
	@Id
	@Column(name="BILL_ID" , length=50)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer billId;
	
	@Column(name="BILL_TYPE" , length=30)
	private String billType;
	
	@Column(name="CREATED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name="PAYMENT_STATUS" , length = 30)
	private String paymentStatus;
	
	@Column(name="PAYMENT_MODE" , length = 30)
	private String paymentMode;
	
	@Column(name="PATIENT_ID" , length = 100)
	private String patientId;
	
	@Column(name="TOTAL_COST")
	private BigDecimal totalCost;

	@Column(name="TOTAL_GST")
	private BigDecimal totalGST;

	@Column(name="TOTAL_DISCOUNT")
	private BigDecimal totalDiscount;

	@OneToMany(cascade=CascadeType.ALL) 
	@JoinColumn(name="BILL_MAP_ID")
	private List<BillDetailsDo> billDetailList;

	
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

	public List<BillDetailsDo> getBillDetailList() {
		return billDetailList;
	}

	public void setBillDetailList(List<BillDetailsDo> billDetailList) {
		this.billDetailList = billDetailList;
	}

	public BigDecimal getTotalGST() {
		return totalGST;
	}

	public void setTotalGST(BigDecimal totalGST) {
		this.totalGST = totalGST;
	}

	public BigDecimal getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(BigDecimal totalDiscount) {
		this.totalDiscount = totalDiscount;
	}
}
