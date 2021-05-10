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
@Table(name="BILL_DETAILS")
public class BillDetailsDo {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer id;
	
	@Column(name="ITEM_NAME" , length=200)
	private String itemName;
	
	@Column(name="ITEM_ID" , length=100)
	private String itemId;
	
	@Column(name="BILL_MAP_ID" , length=100)
	private String billMapId;
	
	@Column(name="COST")
	private BigDecimal cost;
	
	@Column(name="CONCESSION_PERCENTAGE")
	private BigDecimal concessionPercentage;

	@Column(name="GST_PERCENTAGE")
	private BigDecimal gstPercentage;

	@Column(name="MRP")
	private BigDecimal mrp;
	
	@Column(name="CONCESSION_TYPE" , length=100)
	private String concessionType;
	
	@Column(name="QUANTITY")
	private BigDecimal quantity;

	@Column(name="PURCHASE_TYPE" , length=100)
	private String purchaseType;

	@Column(name="UNIT" , length=100)
	private String unit;

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
}
