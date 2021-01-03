/**
 * 
 */
package com.myproject.dao;

import java.util.ArrayList;
import java.util.Date;
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

import com.myproject.dto.BillDetailsDto;
import com.myproject.dto.BillingDto;
import com.myproject.entity.BillDetailsDo;
import com.myproject.entity.BillMap;
import com.myproject.utill.ServicesUtil;

/**
 * @author Kamlesh.Choubey
 *
 */
@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class BillingDao {

	@Autowired
	EntityManager entityManager;

	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	public BillMap importDto(BillingDto fromDto) {
		BillMap entity = new BillMap();
		entity.setBillId(fromDto.getBillId());
		entity.setBillType(fromDto.getBillType());
		entity.setBillType(fromDto.getBillType());
		entity.setPaymentMode(fromDto.getPaymentMode());
		entity.setPaymentStatus(fromDto.getPaymentStatus());
		entity.setCreatedAt(new Date());
		entity.setPatientId(fromDto.getPatientId());
		List<BillDetailsDo> billDetailList = new ArrayList<>();
		fromDto.getBillDetailList().stream().forEach(billDetailsDto -> {
			BillDetailsDo billDetailsDo = new BillDetailsDo();
			billDetailsDo.setBillMapId(billDetailsDto.getBillMapId());
			billDetailsDo.setConcessionPercentage(billDetailsDto.getConcessionPercentage());
			billDetailsDo.setConcessionType(billDetailsDto.getConcessionType());
			billDetailsDo.setCost(billDetailsDto.getCost());
			billDetailsDo.setId(billDetailsDto.getId());
			billDetailsDo.setItemId(billDetailsDto.getItemId());
			billDetailsDo.setItemName(billDetailsDto.getItemName());
			billDetailsDo.setMrp(billDetailsDto.getMrp());
			billDetailList.add(billDetailsDo);
		}

		);
		entity.setBillDetailList(billDetailList);
		return entity;
	}

	public BillingDto exportDto(BillMap entity) {
		BillingDto dto = new BillingDto();
		dto.setBillId(entity.getBillId());
		dto.setBillType(entity.getBillType());
		dto.setBillType(entity.getBillType());
		dto.setPaymentMode(entity.getPaymentMode());
		dto.setPaymentStatus(entity.getPaymentStatus());
		dto.setCreatedAt(new Date());
		dto.setPatientId(entity.getPatientId());
		List<BillDetailsDto> billDetailList = new ArrayList<>();
		entity.getBillDetailList().stream().forEach(billDetailsDo -> {
			BillDetailsDto billDetailsDto = new BillDetailsDto();
			billDetailsDto.setBillMapId(billDetailsDo.getBillMapId());
			billDetailsDto.setConcessionPercentage(billDetailsDo.getConcessionPercentage());
			billDetailsDto.setConcessionType(billDetailsDo.getConcessionType());
			billDetailsDto.setCost(billDetailsDo.getCost());
			billDetailsDto.setId(billDetailsDo.getId());
			billDetailsDto.setItemId(billDetailsDo.getItemId());
			billDetailsDto.setItemName(billDetailsDo.getItemName());
			billDetailsDto.setMrp(billDetailsDo.getMrp());
			billDetailList.add(billDetailsDto);
		}

		);
		dto.setBillDetailList(billDetailList);
		return dto;
	}

	public String generateBill(BillingDto billingDto) {
		String response = "failed";
		try {
			BillMap billMap = importDto(billingDto);
			getSession().saveOrUpdate(billMap);
			response = "Bill " + billMap.getBillId() + " generated successfully";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	

	public BillingDto fetchBillDtails(String patientId, String billId) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<BillMap> criteria = builder.createQuery(BillMap.class);
		Root<BillMap> d = criteria.from(BillMap.class);
		if(!ServicesUtil.isEmpty(patientId)){
			criteria.where(builder.equal(d.get("patientId"), patientId));
		}else if(!ServicesUtil.isEmpty(billId)){
			criteria.where(builder.equal(d.get("billId"), billId));
		}
		TypedQuery<BillMap> q = entityManager.createQuery(criteria);
		return exportDto(q.getSingleResult());
	}


}
