package com.myproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dto.SupplierDto;
import com.myproject.entity.SupplierDo;
import com.myproject.persistent.util.BaseDao;

@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class SupplierDao extends BaseDao<SupplierDo, SupplierDto> {
    @Autowired
    EntityManager entityManager;

    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    protected SupplierDo importDto(SupplierDto fromDto) {
        SupplierDo supplierDo = new SupplierDo();
        supplierDo.setAddress(fromDto.getAddress());
        supplierDo.setEmail(fromDto.getEmail());
        supplierDo.setPhoneNumber(fromDto.getPhoneNumber());
        supplierDo.setSupplierName(fromDto.getSupplierName());
        supplierDo.setSupplierId(fromDto.getSupplierId());
        return supplierDo;
    }

    @Override
    protected SupplierDto exportDto(SupplierDo entity) {
        SupplierDto dto = new SupplierDto();
        dto.setAddress(entity.getAddress());
        dto.setSupplierId(entity.getSupplierId());
        dto.setSupplierName(entity.getSupplierName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setEmail(entity.getEmail());
        return dto;
    }
    public String saveorUpdateSupplier(SupplierDto dto){
        String response="failure";
        try{
            this.getSession().saveOrUpdate(importDto(dto));
            response="success";
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }
    public List<SupplierDto> getSupplierList(){
        try{
            Session session=this.getSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<SupplierDo> criteria = builder.createQuery(SupplierDo.class);
            Root<SupplierDo> d = criteria.from(SupplierDo.class);
            TypedQuery<SupplierDo> q = session.createQuery(criteria);
            return exportDtoList(q.getResultList());

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
