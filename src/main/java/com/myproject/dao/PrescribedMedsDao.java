package com.myproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dto.PrescribedMedsDto;
import com.myproject.entity.PrescribedMedsDo;
import com.myproject.persistent.util.BaseDao;

@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class PrescribedMedsDao extends BaseDao<PrescribedMedsDo, PrescribedMedsDto>{
	
	@Autowired
	EntityManager entityManager;
	
	public PrescribedMedsDo importDto(PrescribedMedsDto fromDto) {
		PrescribedMedsDo entity = new PrescribedMedsDo();
		entity.setPrescribedMedId(fromDto.getPrescribedMedId());
		entity.setMedName(fromDto.getMedName());
		entity.setDays(fromDto.getDays());
		entity.setCost(fromDto.getCost());
		entity.setBillId(fromDto.getBillId());
		entity.setAppointmentId(fromDto.getAppointmentId());
		entity.setComment(fromDto.getComment());
		entity.setDosage(fromDto.getDosage());
		return entity;
	}

	public PrescribedMedsDto exportDto(PrescribedMedsDo entity) {
		PrescribedMedsDto dto = new PrescribedMedsDto();
		dto.setPrescribedMedId(entity.getPrescribedMedId());
		dto.setMedName(entity.getMedName());
		dto.setDays(entity.getDays());
		dto.setCost(entity.getCost());
		dto.setBillId(entity.getBillId());
		dto.setAppointmentId(entity.getAppointmentId());
		dto.setComment(entity.getComment());
		dto.setDosage(entity.getDosage());
		return dto;
	}
	
	public List<PrescribedMedsDto> getPrescribedMedsListByAppointmentId(String appointmentId){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PrescribedMedsDo> criteria = builder.createQuery(PrescribedMedsDo.class);
		Root<PrescribedMedsDo> d = criteria.from(PrescribedMedsDo.class);
		criteria.where(builder.equal(d.get("appointmentId"), appointmentId));
		TypedQuery<PrescribedMedsDo> q = entityManager.createQuery(criteria);
		return exportDtoList(q.getResultList());
	}

}
