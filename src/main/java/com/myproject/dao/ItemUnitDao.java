package com.myproject.dao;

import com.myproject.dto.ItemCategoryDto;
import com.myproject.dto.ItemUnitDto;
import com.myproject.dto.ResponseDto;
import com.myproject.entity.ItemCategoryDo;
import com.myproject.entity.ItemUnitDo;
import com.myproject.persistent.util.BaseDao;
import com.myproject.utill.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ItemUnitDao  extends BaseDao<ItemUnitDo, ItemUnitDto> {

    @Autowired
    EntityManager entityManager;

    @Override
    protected ItemUnitDo importDto(ItemUnitDto fromDto) {
        ItemUnitDo entity = new ItemUnitDo();
        entity.setId(fromDto.getId());
        entity.setUnitName(fromDto.getUnitName());
        return entity;
    }

    @Override
    protected ItemUnitDto exportDto(ItemUnitDo entity) {

        ItemUnitDto dto = new ItemUnitDto();
        dto.setUnitName(entity.getUnitName());
        dto.setId(entity.getId());
        return dto;
    }

    public ResponseDto saveOrUpdate(ItemUnitDto itemUnitDto) {
        ResponseDto responseDto = new ResponseDto();
        this.getSession().saveOrUpdate(importDto(itemUnitDto));
        responseDto.setResponseMessage("Saved successfully");
        responseDto.setResponseCode(ApplicationConstant.SUCCESS_CODE);
        responseDto.setStatus(ApplicationConstant.SUCCESS);
        return responseDto;
    }
    public List<ItemUnitDto> getAllItemUnits() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ItemUnitDo> query = builder.createQuery(ItemUnitDo.class);
        Root<ItemUnitDo> variableRoot = query.from(ItemUnitDo.class);
        query.select(variableRoot);
        TypedQuery<ItemUnitDo> q = entityManager.createQuery(query);
        return exportDtoList(q.getResultList());
    }
}
