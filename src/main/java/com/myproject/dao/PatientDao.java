/**
 * 
 */
package com.myproject.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dto.PatientDto;
import com.myproject.dto.ResponseDto;
import com.myproject.entity.PatientDo;

/**
 * @author Kamlesh.Choubey
 *
 */
@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class PatientDao {
	
	@Autowired
	EntityManager entityManager;
	
	public PatientDo importDto(PatientDto fromDto) {
		PatientDo entity = new PatientDo();
		entity.setPatientId(fromDto.getPatientId());
		entity.setPatientName(fromDto.getPatientName());
		entity.setGuardiansName(fromDto.getGuardiansName());
		entity.setAge(fromDto.getAge());
		entity.setContactNum(fromDto.getContactNum());
		entity.setAltContactNum(fromDto.getAltContactNum());
		entity.setStreet(fromDto.getStreet());
		entity.setState(fromDto.getState());
		entity.setCountry(fromDto.getCountry());
		entity.setPostalCode(fromDto.getPostalCode());
		entity.setReferedFrom(fromDto.getReferedFrom());
		entity.setReferedTo(fromDto.getReferedTo());
		entity.setDiseaseDesc(fromDto.getDiseaseDesc());
		entity.setVisitType(fromDto.getVisitType());
		entity.setCreatedAt(fromDto.getCreatedAt());
		return entity;
	}

	public PatientDto exportDto(PatientDo entity) {
		PatientDto dto = new PatientDto();
		dto.setPatientId(entity.getPatientId());
		dto.setPatientName(entity.getPatientName());
		dto.setGuardiansName(entity.getGuardiansName());
		dto.setAge(entity.getAge());
		dto.setContactNum(entity.getContactNum());
		dto.setAltContactNum(entity.getAltContactNum());
		dto.setStreet(entity.getStreet());
		dto.setState(entity.getState());
		dto.setCountry(entity.getCountry());
		dto.setPostalCode(entity.getPostalCode());
		dto.setReferedFrom(entity.getReferedFrom());
		dto.setReferedTo(entity.getReferedTo());
		dto.setDiseaseDesc(entity.getDiseaseDesc());
		dto.setVisitType(entity.getVisitType());
		dto.setCreatedAt(entity.getCreatedAt());
		return dto;
	}

	
	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public String getPatientNameById(String patientId){
		Query query = this.getSession().createQuery("select p.patientName from PatientDo p where patientId = :patientId");
		query.setParameter("patientId", patientId);
		return query.uniqueResult().toString();
		
	}
		
	public void registerNewPatient(PatientDto patientDto) {
		this.getSession().saveOrUpdate(importDto(patientDto));
	}
	
	public PatientDto getPatientById(String patientId) {
		return exportDto((PatientDo) this.getSession().createCriteria(PatientDo.class).add(Restrictions.eq("patientId", patientId)).uniqueResult());
	}

	public List<PatientDto> getAllPatientList(String patientId) {
		return exportDtoList(this.getSession().createCriteria(PatientDo.class).list());
	}
	
	protected List<PatientDto> exportDtoList(Collection<PatientDo> listDo) {
		List<PatientDto> returnDtos = null;
//		if (!ServicesUtil.isEmpty(listDo)) {
			returnDtos = new ArrayList<PatientDto>(listDo.size());
			for (Iterator<PatientDo> iterator = listDo.iterator(); iterator.hasNext();) {
				returnDtos.add(exportDto(iterator.next()));
			}
//		}
		return returnDtos;
	}
	
}
