/**
 * 
 */
package com.myproject.dto;

import java.util.Date;
import java.util.List;

import com.myproject.persistent.util.BaseDto;

/**
 * @author Kamlesh.Choubey
 *
 */
public class PurchaseOrderDto extends BaseDto{
	
	private Integer purchaseOrderId;
	private Date orderDate;
	private String supplierName;
	private String storeName;
	private Date deliveryDate;
	private Boolean rol;
	
	private List<PurchaseOrderDetailsDto> productDetails;
	public Integer getPurchaseOrderId() {
		return purchaseOrderId;
	}
	public void setPurchaseOrderId(Integer purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Boolean getRol() {
		return rol;
	}
	public void setRol(Boolean rol) {
		this.rol = rol;
	}
	public List<PurchaseOrderDetailsDto> getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(List<PurchaseOrderDetailsDto> productDetails) {
		this.productDetails = productDetails;
	}
	@Override
	public Boolean getValidForUsage() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
