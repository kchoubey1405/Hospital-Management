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

/**
 * @author Kamlesh.Choubey
 *
 */

@Entity
@Table(name="PURCHASE_ORDER_DETAILS")
public class PurchaseOrderDetailsDo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUCT_ID")
	private Integer productId;
	@Column(name="PURCHASE_ORDER_ID")
	private Integer purchaseOrderId;
	@Column(name="MEDICINE_ID")
	private Integer medicineId;
	@Column(name="PRODUCT_NAME")
	private String productName;
	@Column(name="BATCH_NUMBER")
	private String batchNumber;
	@Column(name="QUANTITY")
	private Integer quantity;
	@Column(name="UNIT")
	private String unit;
	@Column(name="PURCHASE_COST")
	private BigDecimal purchaseCost;
	@Column(name="DISCOUNT")
	private BigDecimal discount;
	@Column(name="TAX")
	private BigDecimal tax;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public BigDecimal getPurchaseCost() {
		return purchaseCost;
	}
	public void setPurchaseCost(BigDecimal purchaseCost) {
		this.purchaseCost = purchaseCost;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public BigDecimal getTax() {
		return tax;
	}
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getPurchaseOrderId() {
		return purchaseOrderId;
	}
	public void setPurchaseOrderId(Integer purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}
	public Integer getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}
	

}
