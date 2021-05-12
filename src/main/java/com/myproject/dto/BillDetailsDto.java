/**
 * 
 */
package com.myproject.dto;

import java.math.BigDecimal;

/**
 * @author Kamlesh.Choubey
 *
 */
public class BillDetailsDto {
	private Integer id;
	private String itemName;
	private String itemId;
	private String billMapId;
	private BigDecimal cost;
	private BigDecimal concessionPercentage;
	private BigDecimal gstPercentage;
	private BigDecimal mrp;
	private String concessionType;
	private BigDecimal quantity;
	private String purchaseType;
	private String unit;
	private String actualUnit;

	private BigDecimal actualQuantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getBillMapId() {
		return billMapId;
	}

	public void setBillMapId(String billMapId) {
		this.billMapId = billMapId;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getConcessionPercentage() {
		return concessionPercentage;
	}

	public void setConcessionPercentage(BigDecimal concessionPercentage) {
		this.concessionPercentage = concessionPercentage;
	}

	public BigDecimal getMrp() {
		return mrp;
	}

	public void setMrp(BigDecimal mrp) {
		this.mrp = mrp;
	}

	public String getConcessionType() {
		return concessionType;
	}

	public void setConcessionType(String concessionType) {
		this.concessionType = concessionType;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}

	public BigDecimal getGstPercentage() {
		return gstPercentage;
	}

	public void setGstPercentage(BigDecimal gstPercentage) {
		this.gstPercentage = gstPercentage;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getActualQuantity() {
		return actualQuantity;
	}

	public void setActualQuantity(BigDecimal actualQuantity) {
		this.actualQuantity = actualQuantity;
	}

	public String getActualUnit() {
		return actualUnit;
	}

	public void setActualUnit(String actualUnit) {
		this.actualUnit = actualUnit;
	}
}
