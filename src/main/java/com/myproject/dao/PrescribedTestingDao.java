/**
 * 
 */
package com.myproject.dao;

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
		return dto;
	}

}
