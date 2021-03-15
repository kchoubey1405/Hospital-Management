package com.myproject.dao;

import com.myproject.dto.DoctorDto;
import com.myproject.dto.ItemCategoryDto;
import com.myproject.dto.ResponseDto;
import com.myproject.entity.DoctorDo;
import com.myproject.entity.ItemCategoryDo;
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
public class ItemCategoryDao extends BaseDao<ItemCategoryDo, ItemCategoryDto> {
    @Autowired
    EntityManager entityManager;

    @Override
    protected ItemCategoryDo importDto(ItemCategoryDto fromDto) {
        ItemCategoryDo entity = new ItemCategoryDo();
        entity.setCategoryId(fromDto.getCategoryId());
        entity.setCategoryName(fromDto.getCategoryName());
        return entity;
    }

    @Override
    protected ItemCategoryDto exportDto(ItemCategoryDo entity) {
        ItemCategoryDto dto = new ItemCategoryDto();
        dto.setCategoryId(entity.getCategoryId());
        dto.setCategoryName(entity.getCategoryName());
        return dto;
    }

    public ResponseDto saveOrUpdate(ItemCategoryDto itemCategoryDto) {
        ResponseDto responseDto = new ResponseDto();
        this.getSession().saveOrUpdate(importDto(itemCategoryDto));
        responseDto.setResponseMessage("Saved successfully");
        responseDto.setResponseCode(ApplicationConstant.SUCCESS_CODE);
        responseDto.setStatus(ApplicationConstant.SUCCESS);
        return responseDto;
    }
    public List<ItemCategoryDto> getAllItemCategories() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ItemCategoryDo> query = builder.createQuery(ItemCategoryDo.class);
        Root<ItemCategoryDo> variableRoot = query.from(ItemCategoryDo.class);
        query.select(variableRoot);
        TypedQuery<ItemCategoryDo> q = entityManager.createQuery(query);
        return exportDtoList(q.getResultList());
    }

}
