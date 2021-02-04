/**
 * 
 */
package com.myproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.myproject.entity.MedicineDo;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dto.PharmacyMedicineDto;
import com.myproject.entity.PharmacyMedicineDo;
import com.myproject.persistent.util.BaseDao;

/**
 * @author Kamlesh.Choubey
 *
 */

@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class PharmacyMedicineDao extends BaseDao<PharmacyMedicineDo, PharmacyMedicineDto>{

	@Autowired
	EntityManager entityManager;

	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	@Override
	protected PharmacyMedicineDo importDto(PharmacyMedicineDto fromDto) {
		PharmacyMedicineDo entity = new PharmacyMedicineDo();
		entity.setMedicineId(fromDto.getMedicineId());
		entity.setMedicineName(fromDto.getMedicineName());
		entity.setAvailability(fromDto.getAvailability());
		entity.setBoxSize(fromDto.getBoxSize());
		entity.setCategory(fromDto.getCategory());
		entity.setDetails(fromDto.getDetails());
		entity.setExpDate(fromDto.getExpDate());
		entity.setGenericName(fromDto.getGenericName());
		entity.setImage(fromDto.getImage());
		entity.setMedicineShelf(fromDto.getMedicineShelf());
		entity.setSalePrice(fromDto.getSalePrice());
		entity.setSupplierName(fromDto.getSupplierName());
		entity.setSupplierPrice(fromDto.getSupplierPrice());
		entity.setTax(fromDto.getTax());
		entity.setTriggerValue(fromDto.getTriggerValue());
		entity.setUnit(fromDto.getUnit());
		entity.setStockQuantity(fromDto.getStockQuantity());
		return entity;
	}

	@Override
	protected PharmacyMedicineDto exportDto(PharmacyMedicineDo entity) {
		PharmacyMedicineDto dto = new PharmacyMedicineDto();
		dto.setMedicineId(entity.getMedicineId());
		dto.setMedicineName(entity.getMedicineName());
		dto.setAvailability(entity.getAvailability());
		dto.setBoxSize(entity.getBoxSize());
		dto.setCategory(entity.getCategory());
		dto.setDetails(entity.getDetails());
		dto.setExpDate(entity.getExpDate());
		dto.setGenericName(entity.getGenericName());
		dto.setImage(entity.getImage());
		dto.setMedicineShelf(entity.getMedicineShelf());
		dto.setSalePrice(entity.getSalePrice());
		dto.setSupplierName(entity.getSupplierName());
		dto.setSupplierPrice(entity.getSupplierPrice());
		dto.setTax(entity.getTax());
		dto.setTriggerValue(entity.getTriggerValue());
		dto.setUnit(entity.getUnit());
		dto.setStockQuantity(entity.getStockQuantity());
		return dto;
	}
	
	public String saveOrUpdateMedicine(PharmacyMedicineDto dto){
		String resonse="failure";
		try{
			this.getSession().saveOrUpdate(importDto(dto));
			resonse="success";
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return resonse;
	}

	public String deleteMedicineRecord(String medicineId) {
		String resonse="failure";
		try{
//			this.getSession().delete(importDto(dto));
			CriteriaDelete<PharmacyMedicineDo> criteriaDelete = entityManager.getCriteriaBuilder().createCriteriaDelete(PharmacyMedicineDo.class);
			Root<PharmacyMedicineDo> root = criteriaDelete.from(PharmacyMedicineDo.class);
			criteriaDelete.where(entityManager.getCriteriaBuilder().equal(root.get("medicineId"), medicineId));
			entityManager.createQuery(criteriaDelete).executeUpdate();
			//			entityManager.remove(entityManager.contains(importDto(dto)) ? importDto(dto) : entityManager.merge(importDto(dto)));
			resonse="success";
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return resonse;
	}
	
	public PharmacyMedicineDto getMedicineDetails(Integer medicineId){
		PharmacyMedicineDto dto = new PharmacyMedicineDto();
		try{
			dto = exportDto(this.getSession().get(PharmacyMedicineDo.class, medicineId));
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return dto;
		
	}
	public List<PharmacyMedicineDto> getMedicineList(){
		try{
			Session session=this.getSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<PharmacyMedicineDo> criteria = builder.createQuery(PharmacyMedicineDo.class);
			Root<PharmacyMedicineDo> d = criteria.from(PharmacyMedicineDo.class);
			TypedQuery<PharmacyMedicineDo> q = session.createQuery(criteria);
			return exportDtoList(q.getResultList());
		
	}catch (Exception e) {
		System.out.println(e.getMessage());
	}
		return null;
	}
	
	public List<PharmacyMedicineDto> getMedicineListByName(String medicineName) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<PharmacyMedicineDo> criteriaQuery = cb.createQuery(PharmacyMedicineDo.class);
		Root<PharmacyMedicineDo> root = criteriaQuery.from(PharmacyMedicineDo.class);
		criteriaQuery.where(cb.like(root.<String>get("medicineName"),"%"+medicineName+"%"));
		TypedQuery<PharmacyMedicineDo> query = entityManager.createQuery(criteriaQuery);
		return exportDtoList(query.getResultList());
		
	}

}
