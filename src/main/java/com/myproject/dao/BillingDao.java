/**
 *
 */
package com.myproject.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dto.BillDetailsDto;
import com.myproject.dto.BillingDto;
import com.myproject.dto.PharmacyMedicineDto;
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

    @Autowired
    PharmacyMedicineDao pharmacyMedicineDao;

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
        entity.setCreatedAt(fromDto.getCreatedAt());
        entity.setPatientId(fromDto.getPatientId());
        entity.setTotalCost(fromDto.getTotalCost());
        entity.setTotalDiscount(fromDto.getTotalDiscount());
        entity.setTotalGST(fromDto.getTotalGST());
        entity.setName(fromDto.getName());
        entity.setAge(fromDto.getAge());
        entity.setGender(fromDto.getGender());
        List<BillDetailsDo> billDetailList = new ArrayList<>();
        fromDto.getBillDetailList().stream().forEach(billDetailsDto -> {
                                                         BillDetailsDo billDetailsDo = new BillDetailsDo();
                                                         billDetailsDo.setBillMapId(billDetailsDto.getBillMapId());
                                                         billDetailsDo.setConcessionPercentage(billDetailsDto.getConcessionPercentage());
                                                         billDetailsDo.setGstPercentage(billDetailsDto.getGstPercentage());
                                                         billDetailsDo.setConcessionType(billDetailsDto.getConcessionType());
                                                         billDetailsDo.setCost(billDetailsDto.getCost());
                                                         billDetailsDo.setId(billDetailsDto.getId());
                                                         billDetailsDo.setItemId(billDetailsDto.getItemId());
                                                         billDetailsDo.setItemName(billDetailsDto.getItemName());
                                                         billDetailsDo.setMrp(billDetailsDto.getMrp());
                                                         billDetailsDo.setUnit(billDetailsDto.getUnit());
            billDetailsDo.setActualUnit(billDetailsDto.getActualUnit());
                                                         billDetailsDo.setQuantity(billDetailsDto.getQuantity());
                                                         billDetailsDo.setPurchaseType(billDetailsDto.getPurchaseType());

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
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setPatientId(entity.getPatientId());
        dto.setTotalCost(entity.getTotalCost());
        dto.setTotalDiscount(entity.getTotalDiscount());
        dto.setTotalGST(entity.getTotalGST());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setGender(entity.getGender());
        List<BillDetailsDto> billDetailList = new ArrayList<>();
        entity.getBillDetailList().stream().forEach(billDetailsDo -> {
                                                        BillDetailsDto billDetailsDto = new BillDetailsDto();
                                                        billDetailsDto.setBillMapId(billDetailsDo.getBillMapId());
                                                        billDetailsDto.setConcessionPercentage(billDetailsDo.getConcessionPercentage());
                                                        billDetailsDto.setGstPercentage(billDetailsDo.getGstPercentage());
                                                        billDetailsDto.setConcessionType(billDetailsDo.getConcessionType());
                                                        billDetailsDto.setCost(billDetailsDo.getCost());
                                                        billDetailsDto.setId(billDetailsDo.getId());
                                                        billDetailsDto.setItemId(billDetailsDo.getItemId());
                                                        billDetailsDto.setItemName(billDetailsDo.getItemName());
                                                        billDetailsDto.setMrp(billDetailsDo.getMrp());
                                                        billDetailsDto.setUnit(billDetailsDo.getUnit());
            billDetailsDto.setActualUnit(billDetailsDo.getActualUnit());
                                                        billDetailsDto.setQuantity(billDetailsDo.getQuantity());
                                                        billDetailsDto.setPurchaseType(billDetailsDo.getPurchaseType());
                                                        billDetailList.add(billDetailsDto);
                                                    }

        );
        dto.setBillDetailList(billDetailList);
        return dto;
    }

    public HashMap<String, Object> generateBill(BillingDto billingDto) {
        String response = "failed";
        Integer billId = 0;
        HashMap<String, Object> hm = new HashMap<>();
        try {
            BillMap billMap = importDto(billingDto);
            getSession().saveOrUpdate(billMap);
            response = "success";
            billId = billMap.getBillId();
            List<BillDetailsDto> itemList = billingDto.getBillDetailList();
            for (BillDetailsDto billDetailsDto : itemList) {
                if (billDetailsDto.getPurchaseType().equalsIgnoreCase("pharmacy-purchase")) {
                    PharmacyMedicineDto pharmacyMedicineDto = pharmacyMedicineDao.getMedicineDetails(Integer.parseInt(billDetailsDto.getItemId()));
                    pharmacyMedicineDto.setStockQuantity(BigDecimal.valueOf(pharmacyMedicineDto.getStockQuantity().floatValue() - billDetailsDto.getActualQuantity().floatValue()));
                    pharmacyMedicineDao.saveOrUpdateMedicine(pharmacyMedicineDto);
                } else if (billDetailsDto.getPurchaseType().equalsIgnoreCase("pharmacy-return")) {
                    PharmacyMedicineDto pharmacyMedicineDto = pharmacyMedicineDao.getMedicineDetails(Integer.parseInt(billDetailsDto.getItemId()));
                    pharmacyMedicineDto.setStockQuantity(BigDecimal.valueOf(pharmacyMedicineDto.getStockQuantity().floatValue() + billDetailsDto.getActualQuantity().floatValue()));
                    pharmacyMedicineDao.saveOrUpdateMedicine(pharmacyMedicineDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        hm.put("response", response);
        hm.put("billId", billId);
        return hm;
    }

    public List<BillingDto> fetchBillDtails(Integer patientId, String billId, String name) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BillMap> criteria = builder.createQuery(BillMap.class);
        Root<BillMap> d = criteria.from(BillMap.class);
        if (!ServicesUtil.isEmpty(patientId)) {
            criteria.where(builder.equal(d.get("patientId"), patientId));
        } else if (!ServicesUtil.isEmpty(billId)) {
            criteria.where(builder.equal(d.get("billId"), billId));
        } else if (!ServicesUtil.isEmpty(name)) {
            criteria.where(builder.like(d.<String>get("name"),"%"+name+"%"));
        }
        TypedQuery<BillMap> q = entityManager.createQuery(criteria);
        return exportDtoList(q.getResultList());
    }

    public List<BillingDto> exportDtoList(Collection<BillMap> listDo) {
        List<BillingDto> returnDtos = null;
        if (!ServicesUtil.isEmpty(listDo)) {
            returnDtos = new ArrayList<BillingDto>(listDo.size());
            for (Iterator<BillMap> iterator = listDo.iterator(); iterator.hasNext(); ) {
                returnDtos.add(exportDto(iterator.next()));
            }
        }
        return returnDtos;
    }
    
    public List<BillingDto> fetchBillList(Long todate, Long fromDate, String billType) {
    	List<BillingDto> dtoList = null;
		try{
		CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<BillMap> criteria = builder.createQuery(BillMap.class);
		Root<BillMap> r = criteria.from(BillMap.class);
		Predicate predicateForBillType
		  = builder.equal(r.get("billType"), billType);
		Predicate predicateForFromDate = builder.greaterThanOrEqualTo(r.get("createdAt"), new Date(fromDate));
		Predicate predicateForTodate = builder.lessThanOrEqualTo(r.get("createdAt"), new Date(todate));
		Predicate predicateForTimeRange =builder.and(predicateForFromDate , predicateForTodate);
		Predicate predicate =builder.and(predicateForTimeRange , predicateForBillType);
		criteria.where(predicate);
		TypedQuery<BillMap> q = this.getSession().createQuery(criteria);
//		q.setFirstResult(startIndex);
//		q.setMaxResults(pageSize);
		dtoList =  exportDtoList(q.getResultList());
		}catch(Exception e){
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return dtoList;
	}
}
