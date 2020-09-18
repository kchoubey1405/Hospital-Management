package com.myproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "medicine_details")
public class MedicineDo extends BaseModel {

    @Column(name = "medicine_name", length = 50)
    private String medicineName;

    @Column(name = "medicine_type", length = 50)
    private String medicineType;

    @Column(name = "strength", length = 50)
    private String strength;

    @Column(name = "price")
    private Integer price;

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(String medicineType) {
        this.medicineType = medicineType;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
