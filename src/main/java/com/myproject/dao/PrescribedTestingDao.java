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

import com.myproject.dto.PrescribedTestingDto;
import com.myproject.entity.PrescribedTestingDo;
import com.myproject.persistent.util.BaseDao;

/**
 * @author Kamlesh.Choubey
 *
 */
@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class PrescribedTestingDao extends BaseDao<PrescribedTestingDo, PrescribedTestingDto>{
	
	@Autowired
	EntityManager entityManager; 
	
	public PrescribedTestingDo importDto(PrescribedTestingDto fromDto) {
		PrescribedTestingDo entity = new PrescribedTestingDo();
		entity.setTestId(fromDto.getTestId());
		entity.setAppointmentId(fromDto.getAppointmentId());
		entity.setBillId(fromDto.getBillId());
		entity.setDateOfBooking(fromDto.getDateOfBooking());
		entity.setTestDesc(fromDto.getTestDesc());
		entity.setDateOfResult(fromDto.getDateOfResult());
		entity.setCost(fromDto.getCost());
		entity.setTestDesc(fromDto.getTestDesc());
		entity.setComment(fromDto.getComment());
		entity.setTestName(fromDto.getTestName());
		return entity;
	}

	public PrescribedTestingDto exportDto(PrescribedTestingDo entity) {
		PrescribedTestingDto dto = new PrescribedTestingDto();
		dto.setTestId(entity.getTestId());
		dto.setAppointmentId(entity.getAppointmentId());
		dto.setBillId(entity.getBillId());
		dto.setDateOfBooking(entity.getDateOfBooking());
		dto.setTestDesc(entity.getTestDesc());
		dto.setDateOfResult(entity.getDateOfResult());
		dto.setCost(entity.getCost());
		dto.setTestDesc(entity.getTestDesc());
		dto.setComment(entity.getComment());
		dto.setTestName(entity.getTestName());
		return dto;
	}
	
	public List<PrescribedTestingDto> getPrescribedTestingListByAppointmentId(String appointmentId){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PrescribedTestingDo> criteria = builder.createQuery(PrescribedTestingDo.class);
		Root<PrescribedTestingDo> d = criteria.from(PrescribedTestingDo.class);
		criteria.where(builder.equal(d.get("appointmentId"), appointmentId));
		TypedQuery<PrescribedTestingDo> q = entityManager.createQuery(criteria);
		return exportDtoList(q.getResultList());
	}

}
