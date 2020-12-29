package com.myproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.myproject.persistent.util.BaseDo;

@Entity
@Table(name="PHARMACY_SUPPLIER")
public class SupplierDo implements BaseDo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="SUPPLIER_ID")
    private Integer supplierId;

    @Column(name="SUPPLIER_NAME" , length=100)
    private String supplierName;

    @Column(name="EMAIL" , length=100)
    private String email;

    @Column(name="PHONE_NUMBER" , length=100)
    private String phoneNumber;

    @Column(name="ADDRESS" , length=100)
    private String address;

    @Override
    public String toString() {
        return "PharmacyMedicineDo [medicineId=" + supplierId + ", medicineName=" + supplierName + "]";
    }

    @Override
    public Object getPrimaryKey() {
        return null;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
