package com.myproject.entity;

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

import com.myproject.persistent.util.BaseDo;

/**
 * @author Kamlesh.Choubey
 *
 */
@Entity
@Table(name="PURCHASE_ORDER")
public class PurchaseOrderDo implements BaseDo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PURCHASE_ORDER_ID")
	private Integer purchaseOrderId;
	@Column(name="ORDER_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	@Column(name="SUPPLIER_NAME" , length=100)
	private String supplierName;
	@Column(name="STORE_NAME" , length=100)
	private String storeName;
	@Column(name="DELIVERY_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deliveryDate;
	@Column(name="ROL")
	private Boolean rol;
	
//	@OneToMany(targetEntity=PurchaseOrderDetailsDo.class , mappedBy="purchaseOrderId" ,cascade=CascadeType.ALL) 
	@OneToMany(cascade = CascadeType.ALL)  
	@JoinColumn(name="PURCHASE_ORDER_ID") 
	private List<PurchaseOrderDetailsDo> productDetails;
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
	
	public List<PurchaseOrderDetailsDo> getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(List<PurchaseOrderDetailsDo> productDetails) {
		this.productDetails = productDetails;
	}
	public Integer getPurchaseOrderId() {
		return purchaseOrderId;
	}
	public void setPurchaseOrderId(Integer purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}
	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
