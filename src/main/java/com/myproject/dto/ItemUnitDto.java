package com.myproject.dto;

import com.myproject.persistent.util.BaseDto;

public class ItemUnitDto extends BaseDto  {
    private Integer id;
    private String unitName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    @Override
    public Boolean getValidForUsage() {
        // TODO Auto-generated method stub
        return null;
    }
}
