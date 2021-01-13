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
	@Column(name="INVOICE_NUMBER" , length=100)
	private String invoiceNumber;
	@Column(name="STATUS" , length=100)
	private String status;
	@Column(name="STORE_NAME" , length=100)
	private String storeName;
	@Column(name="DELIVERY_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deliveryDate;
	@Column(name="ROL")
	private Boolean rol;
	@Column(name="TOTAL_AMOUNT")
	private BigDecimal totalAmount;
	@Column(name="TOTAL_GST")
	private BigDecimal totalGST;
	@Column(name="TOTAL_DISCOUNT")
	private BigDecimal totalDiscount;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
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

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
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

	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
