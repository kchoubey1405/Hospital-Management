/**
 * 
 */
package com.myproject.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.myproject.persistent.util.BaseDo;

/**
 * @author Kamlesh.Choubey
 *
 */
@Entity
@Table(name="PHARMACY_MEDICINE")
public class PharmacyMedicineDo implements BaseDo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MEDICINE_ID")
	private Integer medicineId;
	
	@Column(name="MEDICINE_NAME" , length=100)
	private String medicineName;
	@Column(name="GENERIC_NAME" , length=100)
	private String genericName;
	@Column(name="BOX_SIZE")
	private Integer boxSize;
	@Column(name="EXPIRY_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expDate;
	@Column(name="" , length=100)
	private String medicineShelf;
	@Column(name="DETAILS" , length=255)
	private String details;
	@Column(name="CATEGORY" , length=50)
	private String category;
	@Column(name="UNIT" , length=50)
	private String unit;
	@Column(name="TRIGGER_VALUE" , length=50)
	private String triggerValue;
	@Lob
	@Column(name="IMAGE")
	private String image;
	@Column(name="SALE_PRICE")
	private BigDecimal salePrice;
	@Column(name="SUPPLIER_PRICE")
	private BigDecimal supplierPrice;
	@Column(name="TAX")
	private BigDecimal tax;
	@Column(name="SUPPLIER_NAME" , length=100)
	private String supplierName;
	@Column(name="AVAILABILITY" , length=20)
	private String availability;
	@Column(name="STOCK_QUANTITY")
	private BigDecimal stockQuantity;

	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getGenericName() {
		return genericName;
	}
	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}
	public Integer getBoxSize() {
		return boxSize;
	}
	public void setBoxSize(Integer boxSize) {
		this.boxSize = boxSize;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public String getMedicineShelf() {
		return medicineShelf;
	}
	public void setMedicineShelf(String medicineShelf) {
		this.medicineShelf = medicineShelf;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getTriggerValue() {
		return triggerValue;
	}
	public void setTriggerValue(String triggerValue) {
		this.triggerValue = triggerValue;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	public BigDecimal getSupplierPrice() {
		return supplierPrice;
	}
	public void setSupplierPrice(BigDecimal supplierPrice) {
		this.supplierPrice = supplierPrice;
	}
	public BigDecimal getTax() {
		return tax;
	}
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public BigDecimal getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(BigDecimal stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Integer getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}
	@Override
	public String toString() {
		return "PharmacyMedicineDo [medicineId=" + medicineId + ", medicineName=" + medicineName + ", genericName="
				+ genericName + ", boxSize=" + boxSize + ", expDate=" + expDate + ", medicineShelf=" + medicineShelf
				+ ", details=" + details + ", category=" + category + ", unit=" + unit + ", triggerValue="
				+ triggerValue + ", image=" + image + ", salePrice=" + salePrice + ", supplierPrice=" + supplierPrice
				+ ", tax=" + tax + ", supplierName=" + supplierName + ", availability=" + availability + "]";
	}
	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}

}
