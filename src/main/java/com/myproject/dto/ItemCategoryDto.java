package com.myproject.dto;

import com.myproject.persistent.util.BaseDto;

public class ItemCategoryDto extends BaseDto {
    private Integer categoryId;
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
    public Boolean getValidForUsage() {
        // TODO Auto-generated method stub
        return null;
    }
}
