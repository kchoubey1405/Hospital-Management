/**
 * 
 */
package com.myproject.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dto.AppointmentDto;
import com.myproject.entity.AppointmentDo;
import com.myproject.persistent.util.BaseDao;

/**
 * @author Kamlesh.Choubey
 *
 */
@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AppointmentDao extends BaseDao<AppointmentDo, AppointmentDto> {
	public AppointmentDo importDto(AppointmentDto fromDto) {
		AppointmentDo entity = new AppointmentDo();
		entity.setAppointmentId(fromDto.getAppointmentId());
		entity.setAdvise(fromDto.getAdvise());
		entity.setBp(fromDto.getBp());
		entity.setDiseaseDesc(fromDto.getDiseaseDesc());
		entity.setDoctorId(fromDto.getDoctorId());
		entity.setHeight(fromDto.getHeight());
		entity.setPatientId(fromDto.getPatientId());
		entity.setWeight(fromDto.getWeight());
		entity.setCreatedAt(new Date());
		entity.setAppointmentDate(fromDto.getAppointmentDate());
		entity.setPatientName(fromDto.getPatientName());
		entity.setTimeSlot(fromDto.getTimeSlot());
		return entity;
	}

	public AppointmentDto exportDto(AppointmentDo entity) {
		AppointmentDto dto = new AppointmentDto();
		dto.setAppointmentId(entity.getAppointmentId());
		dto.setAdvise(entity.getAdvise());
		dto.setBp(entity.getBp());
		dto.setDiseaseDesc(entity.getDiseaseDesc());
		dto.setDoctorId(entity.getDoctorId());
		dto.setHeight(entity.getHeight());
		dto.setPatientId(entity.getPatientId());
		dto.setWeight(entity.getWeight());
		dto.setCreatedAt(entity.getCreatedAt());
		dto.setAppointmentDate(entity.getAppointmentDate());
		dto.setPatientName(entity.getPatientName());
		dto.setTimeSlot(entity.getTimeSlot());
		return dto;
	}

	public void saveOrUpdate(AppointmentDto appointmentDto) {
		System.err.println(appointmentDto.toString());
		this.getSession().saveOrUpdate(importDto(appointmentDto));
	}
	
	public AppointmentDto getAppointmentDetailsById(String appointmentId) {
		return exportDto(this.getSession().get(AppointmentDo.class, appointmentId));
	}
	
	public List<AppointmentDto> getAppointmentList(String doctorId, int numberOfDays, int startIndex, int pageSize){
		System.err.println("inside dao");
		List<AppointmentDto> dtoList = null;
		try{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -numberOfDays);
		Date d = cal.getTime();
		CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<AppointmentDo> criteria = builder.createQuery(AppointmentDo.class);
		Root<AppointmentDo> r = criteria.from(AppointmentDo.class);
		Predicate predicateForDoctorId
		  = builder.equal(r.get("doctorId"), doctorId);
		Predicate predicateForNumberOfDays = builder.greaterThanOrEqualTo(r.get("createdAt"), d);
		Predicate predicateForDocIdAndNumOfDayd=builder.and(predicateForDoctorId , predicateForNumberOfDays);
		criteria.where(predicateForDocIdAndNumOfDayd);
		TypedQuery<AppointmentDo> q = this.getSession().createQuery(criteria);
		q.setFirstResult(startIndex);
		q.setMaxResults(pageSize);
		dtoList =  exportDtoList(q.getResultList());
		}catch(Exception e){
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return dtoList;
	}
}
