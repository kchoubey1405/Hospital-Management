package com.myproject.entity;

import com.myproject.persistent.util.BaseDo;

import javax.persistence.*;

@Entity
@Table(name = "ITEM_UNIT")
public class ItemUnitDo implements BaseDo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="UNIT_NAME" , length=100)
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
    public Object getPrimaryKey() {
        // TODO Auto-generated method stub
        return null;
    }
}
