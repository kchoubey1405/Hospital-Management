package com.myproject.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dto.PrescribedMedsDto;
import com.myproject.entity.PrescribedMedsDo;
import com.myproject.persistent.util.BaseDao;

@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class PrescribedMedsDao extends BaseDao<PrescribedMedsDo, PrescribedMedsDto>{
	public PrescribedMedsDo importDto(PrescribedMedsDto fromDto) {
		PrescribedMedsDo entity = new PrescribedMedsDo();
		entity.setPrescribedMedId(fromDto.getPrescribedMedId());
		entity.setMedName(fromDto.getMedName());
		entity.setDays(fromDto.getDays());
		entity.setCost(fromDto.getCost());
		entity.setBillId(fromDto.getBillId());
		return entity;
	}

	public PrescribedMedsDto exportDto(PrescribedMedsDo entity) {
		PrescribedMedsDto dto = new PrescribedMedsDto();
		dto.setPrescribedMedId(entity.getPrescribedMedId());
		dto.setMedName(entity.getMedName());
		dto.setDays(entity.getDays());
		dto.setCost(entity.getCost());
		dto.setBillId(entity.getBillId());
		return dto;
	}

}
