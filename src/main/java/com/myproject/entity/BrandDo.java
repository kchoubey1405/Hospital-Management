package com.myproject.entity;

import com.myproject.persistent.util.BaseDo;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "BRAND_DETAILS")
public class BrandDo implements BaseDo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", length = 100)
    private int id;

    @Column(name = "COMPANY_NAME", length = 500)
    private String companyName;
    @Column(name = "ADDRESS", length = 500)
    private String companyAddress;
    @Column(name = "EMAIL", length = 500)
    private String email;
    @Column(name = "GSTIN", length = 500)
    private String gstin;
    @Column(name = "REGNO", length = 500)
    private String regNo;
    @Column(name = "CONTACT", length = 50)
    private String contact;
    @Column(name = "WEBSITE", length = 100)
    private String website;
    @Lob
    @Column(name = "LOGO")
    private String logo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public Object getPrimaryKey() {
        // TODO Auto-generated method stub
        return null;
    }
}
