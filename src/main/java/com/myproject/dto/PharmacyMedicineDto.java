/**
 * 
 */
package com.myproject.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.myproject.persistent.util.BaseDto;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Kamlesh.Choubey
 *
 */
public class PharmacyMedicineDto extends BaseDto{
	
	private Integer medicineId;
	private String medicineName;
	private String genericName;
	private Integer boxSize;
	private Date expDate;
	private String medicineShelf;
	private String details;
	private String category;
	private String unit;
	private String triggerValue;
	private String image;
	private BigDecimal salePrice;
	private BigDecimal supplierPrice;
	private String barcode;
	private BigDecimal tax;
	private String supplierName;
	private String availability;
	private BigDecimal stockQuantity;
	private String barcodeNum;
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

	@Override
	public Boolean getValidForUsage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Integer getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}
	
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getBarcodeNum() {
		return barcodeNum;
	}
	public void setBarcodeNum(String barcodeNum) {
		this.barcodeNum = barcodeNum;
	}
	@Override
	public String toString() {
		return "PharmacyMedicineDto [medicineId=" + medicineId + ", medicineName=" + medicineName + ", genericName="
				+ genericName + ", boxSize=" + boxSize + ", expDate=" + expDate + ", medicineShelf=" + medicineShelf
				+ ", details=" + details + ", category=" + category + ", unit=" + unit + ", triggerValue="
				+ triggerValue + ", image=" + image + ", salePrice=" + salePrice + ", supplierPrice=" + supplierPrice
				+ ", barcode=" + barcode + ", tax=" + tax + ", supplierName=" + supplierName + ", availability="
				+ availability + ", stockQuantity=" + stockQuantity + ", barcodeNum=" + barcodeNum + "]";
	}
	
}
