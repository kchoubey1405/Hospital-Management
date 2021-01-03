/**
 * 
 */
package com.myproject.dao;

import java.util.ArrayList;
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

import com.myproject.dto.PurchaseOrderDetailsDto;
import com.myproject.dto.PurchaseOrderDto;
import com.myproject.entity.PurchaseOrderDetailsDo;
import com.myproject.entity.PurchaseOrderDo;
import com.myproject.persistent.util.BaseDao;

/**
 * @author Kamlesh.Choubey
 *
 */
@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class PurchaseOrderDao extends BaseDao<PurchaseOrderDo, PurchaseOrderDto>{

	@Autowired
	EntityManager entityManager;

	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}

//	@Override
	protected PurchaseOrderDo importDto(PurchaseOrderDto fromDto) {
		PurchaseOrderDo entity = new PurchaseOrderDo();
		entity.setPurchaseOrderId(fromDto.getPurchaseOrderId());
		entity.setDeliveryDate(fromDto.getDeliveryDate());
		entity.setOrderDate(fromDto.getOrderDate());
		List<PurchaseOrderDetailsDo> productList = new ArrayList<>();
		fromDto.getProductDetails().stream().forEach(p1-> {
			PurchaseOrderDetailsDo product = new PurchaseOrderDetailsDo();
			product.setBatchNumber(p1.getBatchNumber());
			product.setDiscount(p1.getDiscount());
			product.setMedicineId(p1.getMedicineId());
			product.setProductId(p1.getProductId());
			product.setProductName(p1.getProductName());
			product.setPurchaseCost(p1.getPurchaseCost());
//			product.setPurchaseOrderId(p1.getPurchaseOrderId());
//			product.setPurchaseOrderDo(p1.getPurchaseOrderDo());
			product.setQuantity(p1.getQuantity());
			product.setTax(p1.getTax());
			product.setUnit(p1.getUnit());
			productList.add(product);
		});
		entity.setProductDetails(productList);
		entity.setRol(fromDto.getRol());
		entity.setStoreName(fromDto.getStoreName());
		entity.setSupplierName(fromDto.getSupplierName());
		return entity;
	}

//	@Override
	protected PurchaseOrderDto exportDto(PurchaseOrderDo entity) {
		PurchaseOrderDto dto = new PurchaseOrderDto();
		dto.setPurchaseOrderId(entity.getPurchaseOrderId());
		dto.setDeliveryDate(entity.getDeliveryDate());
		dto.setOrderDate(entity.getOrderDate());
		List<PurchaseOrderDetailsDto> productList = new ArrayList<>();
		entity.getProductDetails().stream().forEach(p1-> {
			PurchaseOrderDetailsDto product = new PurchaseOrderDetailsDto();
			product.setBatchNumber(p1.getBatchNumber());
			product.setDiscount(p1.getDiscount());
			product.setMedicineId(p1.getMedicineId());
			product.setProductId(p1.getProductId());
			product.setProductName(p1.getProductName());
			product.setPurchaseCost(p1.getPurchaseCost());
//			product.setPurchaseOrderId(p1.getPurchaseOrderId());
//			product.setPurchaseOrderDo(p1.getPurchaseOrderDo());
			product.setQuantity(p1.getQuantity());
			product.setTax(p1.getTax());
			product.setUnit(p1.getUnit());
			productList.add(product);
		});
		dto.setProductDetails(productList);
		dto.setRol(entity.getRol());
		dto.setStoreName(entity.getStoreName());
		dto.setSupplierName(entity.getStoreName());
		return dto;
	}
	
	public String saveOrUpdatePurchaseOrder(PurchaseOrderDto dto){
		String resonse="failure";
		try{
//			this.getSession().saveOrUpdate(importDto(dto));
			PurchaseOrderDo purchaseOrderDo= entityManager.contains(importDto(dto)) ? importDto(dto) : entityManager.merge(importDto(dto));
			this.getSession().saveOrUpdate(purchaseOrderDo);
			resonse="success";
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return resonse;
	}

	public String deletePurchaseOrder(PurchaseOrderDto dto) {
		String resonse="failure";
		try{
			entityManager.remove(entityManager.contains(importDto(dto)) ? importDto(dto) : entityManager.merge(importDto(dto)));
			resonse="success";
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return resonse;
	}
	
	public PurchaseOrderDto getPurchaseOrderDetails(Integer purchaseOrderId){
		PurchaseOrderDto dto = new PurchaseOrderDto();
		try{
			dto = exportDto(this.getSession().get(PurchaseOrderDo.class, purchaseOrderId));
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return dto;
		
	}
	@SuppressWarnings("unused")
	public List<PurchaseOrderDto> getPurchaseOrderList(){
		try{
			Session session=this.getSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<PurchaseOrderDo> criteria = builder.createQuery(PurchaseOrderDo.class);
			Root<PurchaseOrderDo> d = criteria.from(PurchaseOrderDo.class);
			TypedQuery<PurchaseOrderDo> q = session.createQuery(criteria);
			return exportDtoList(q.getResultList());
		
	}catch (Exception e) {
		System.out.println(e.getMessage());
	}
		return null;
	}

}
