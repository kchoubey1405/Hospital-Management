/**
 *
 */
package com.myproject.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dto.PatientDto;
import com.myproject.entity.PatientDo;
import com.myproject.utill.ServicesUtil;

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
        entity.setPatientName(fromDto.getPatientName());
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
        if(!ServicesUtil.isEmpty(fromDto.getPatientId())){
        	 entity.setPatientid(fromDto.getPatientId());
        }
       
        return entity;
    }

    public PatientDto exportDto(PatientDo entity) {
        PatientDto dto = new PatientDto();
        dto.setPatientId(entity.getPatientid());
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
        return dto;
    }

    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @SuppressWarnings({"rawtypes", "deprecation"})
    public String getPatientNameById(String patientId) {
        Query query = this.getSession().createQuery("select p.patientName from PatientDo p where patientId = :patientId");
        query.setParameter("patientId", patientId);
        return query.uniqueResult().toString();
    }

    public String registerNewPatient(PatientDto patientDto) {
    	PatientDo patientDo = importDto(patientDto);
        this.getSession().saveOrUpdate(patientDo);
        return patientDo.getPatientid();
    }

    @SuppressWarnings("deprecation")
	public PatientDto getPatientById(String patientId) {
        return exportDto((PatientDo) this.getSession().createCriteria(PatientDo.class).add(Restrictions.eq("patientid", patientId)).uniqueResult());
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
	public List<PatientDto> getAllPatientList(String patientId) {
        return exportDtoList(this.getSession().createCriteria(PatientDo.class).list());
    }

    protected List<PatientDto> exportDtoList(Collection<PatientDo> listDo) {
        List<PatientDto> returnDtos = null;
//		if (!ServicesUtil.isEmpty(listDo)) {
        returnDtos = new ArrayList<PatientDto>(listDo.size());
        for (Iterator<PatientDo> iterator = listDo.iterator(); iterator.hasNext(); ) {
            returnDtos.add(exportDto(iterator.next()));
        }
//		}
        return returnDtos;
    }

	public List<PatientDto> getPatientByName(String patientName) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<PatientDo> criteriaQuery = cb.createQuery(PatientDo.class);
		Root<PatientDo> root = criteriaQuery.from(PatientDo.class);
		criteriaQuery.where(cb.equal(root.get("patientName"), patientName));
		TypedQuery<PatientDo> query = entityManager.createQuery(criteriaQuery);
		return exportDtoList(query.getResultList());
		
	}
}
