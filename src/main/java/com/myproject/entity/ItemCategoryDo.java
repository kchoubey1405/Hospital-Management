package com.myproject.entity;

import com.myproject.persistent.util.BaseDo;

import javax.persistence.*;

@Entity
@Table(name = "ITEM_CATEGORY")
public class ItemCategoryDo implements BaseDo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="CATEGORY_ID")
    private Integer categoryId;

    @Column(name="CATEGORY_NAME" , length=100)
    private String categoryName;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public Object getPrimaryKey() {
        // TODO Auto-generated method stub
        return null;
    }
}
