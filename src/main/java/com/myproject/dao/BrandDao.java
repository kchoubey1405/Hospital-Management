package com.myproject.dao;

import com.myproject.dto.BillDto;
import com.myproject.dto.BrandDto;
import com.myproject.dto.ResponseDto;
import com.myproject.entity.BillDo;
import com.myproject.entity.BrandDo;
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
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class BrandDao extends BaseDao<BrandDo, BrandDto> {
    @Autowired
    EntityManager entityManager;

    @Override
    protected BrandDo importDto(BrandDto fromDto) {
        BrandDo entity = new BrandDo();
        entity.setCompanyName(fromDto.getCompanyName());
        entity.setId(fromDto.getId());
        entity.setContact(fromDto.getContact());
        entity.setEmail(fromDto.getEmail());
        entity.setGstin(fromDto.getGstin());
        entity.setCompanyAddress(fromDto.getCompanyAddress());
        entity.setRegNo(fromDto.getRegNo());
        entity.setWebsite(fromDto.getWebsite());
        entity.setLogo(fromDto.getLogo());
        return entity;
    }

    @Override
    protected BrandDto exportDto(BrandDo entity) {
        BrandDto dto = new BrandDto();
        dto.setCompanyAddress(entity.getCompanyAddress());
        dto.setCompanyName(entity.getCompanyName());
        dto.setContact(entity.getContact());
        dto.setEmail(entity.getEmail());
        dto.setGstin(entity.getGstin());
        dto.setId(entity.getId());
        dto.setRegNo(entity.getRegNo());
        dto.setWebsite(entity.getWebsite());
        dto.setLogo(entity.getLogo());
        return dto;
    }

    public List<BrandDto> getBrandDetails() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BrandDo> query = builder.createQuery(BrandDo.class);
        Root<BrandDo> variableRoot = query.from(BrandDo.class);
        query.select(variableRoot);
        TypedQuery<BrandDo> q = entityManager.createQuery(query);
        return exportDtoList(q.getResultList());
    }
    public ResponseDto saveBrandDetails(BrandDto brandDto, Path root) {
        ResponseDto responseDto = new ResponseDto();
        this.getSession().saveOrUpdate(importDto(brandDto));
        responseDto.setResponseMessage("Saved successfully");
        responseDto.setResponseCode(ApplicationConstant.SUCCESS_CODE);
        responseDto.setStatus(ApplicationConstant.SUCCESS);
        return responseDto;
    }

}
