/**
 * 
 */
package com.myproject.dto;

import java.math.BigDecimal;

import com.myproject.entity.PurchaseOrderDo;

/**
 * @author Kamlesh.Choubey
 *
 */
public class PurchaseOrderDetailsDto {
	private Integer productId;
//	private Integer purchaseOrderId;
	private Integer medicineId;
	private String productName;
	private String batchNumber;
	private Integer quantity;
	private String unit;
	private BigDecimal purchaseCost;
	private BigDecimal discount;
	private BigDecimal tax;
	private PurchaseOrderDo purchaseOrderDo;
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
//	public Integer getPurchaseOrderId() {
//		return purchaseOrderId;
//	}
//	public void setPurchaseOrderId(Integer purchaseOrderId) {
//		this.purchaseOrderId = purchaseOrderId;
//	}
	public Integer getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}
	public PurchaseOrderDo getPurchaseOrderDo() {
		return purchaseOrderDo;
	}
	public void setPurchaseOrderDo(PurchaseOrderDo purchaseOrderDo) {
		this.purchaseOrderDo = purchaseOrderDo;
	}
	
	
}
