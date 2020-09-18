/**
 * 
 */
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

import com.myproject.dto.DoctorDto;
import com.myproject.entity.DoctorDo;
import com.myproject.persistent.util.BaseDao;

/**
 * @author Kamlesh.Choubey
 *
 */
@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class DoctorDao extends BaseDao<DoctorDo, DoctorDto> {

	@Autowired
	EntityManager entityManager;

	@Override
	protected DoctorDo importDto(DoctorDto fromDto) {
		DoctorDo entity = new DoctorDo();
		entity.setEmpId(fromDto.getEmpId());
		entity.setDoctorId(fromDto.getDoctorId());
		entity.setDoctorName(fromDto.getDoctorName());
		entity.setConsulationCharge(fromDto.getConsulationCharge());
		entity.setDepartment(fromDto.getDepartment());
		entity.setDesignation(fromDto.getDesignation());
		entity.setExperience(fromDto.getExperience());
		entity.setHighestQualification(fromDto.getHighestQualification());
		entity.setSpeciality(fromDto.getSpeciality());
		return entity;
	}

	@Override
	protected DoctorDto exportDto(DoctorDo entity) {
		DoctorDto dto = new DoctorDto();
		dto.setEmpId(entity.getEmpId());
		dto.setDoctorId(entity.getDoctorId());
		dto.setDoctorName(entity.getDoctorName());
		dto.setConsulationCharge(entity.getConsulationCharge());
		dto.setDepartment(entity.getDepartment());
		dto.setDesignation(entity.getDesignation());
		dto.setExperience(entity.getExperience());
		dto.setHighestQualification(entity.getHighestQualification());
		dto.setSpeciality(entity.getSpeciality());
		return dto;
	}

	public DoctorDto getDoctorById(String doctorId) {
		return exportDto(entityManager.find(DoctorDo.class, doctorId));
	}

	public List<DoctorDto> getDoctorsList(String department) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<DoctorDo> criteria = builder.createQuery(DoctorDo.class);
		Root<DoctorDo> d = criteria.from(DoctorDo.class);
		criteria.where(builder.equal(d.get("department"), department));
		TypedQuery<DoctorDo> q = entityManager.createQuery(criteria);
		return exportDtoList(q.getResultList());
	}

	public void saveOrUpdate(DoctorDto doctorDto) {
		this.getSession().saveOrUpdate(importDto(doctorDto));
	}

}
