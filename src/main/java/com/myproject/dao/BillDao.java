/**
 * 
 */
package com.myproject.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dto.BillDto;
import com.myproject.dto.BillResponseDto;
import com.myproject.dto.PrescribedMedsDto;
import com.myproject.dto.PrescribedTestingDto;
import com.myproject.entity.BillDo;
import com.myproject.entity.PrescribedMedsDo;
import com.myproject.entity.PrescribedTestingDo;
import com.myproject.persistent.util.BaseDao;
import com.myproject.utill.ServicesUtil;

/**
 * @author Kamlesh.Choubey
 *
 */
@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class BillDao extends BaseDao<BillDo, BillDto> {
	
	@Autowired
	PrescribedMedsDao prescribedMedsDao;
	@Autowired
	PrescribedTestingDao prescribedTestingDao;
	
	public BillDo importDto(BillDto fromDto) {
		BillDo entity = new BillDo();
		entity.setBillId(fromDto.getBillId());
		entity.setStatus(fromDto.getStatus());
		entity.setType(fromDto.getType());
		entity.setCreatedAt(fromDto.getCreatedAt());
		entity.setPatientId(fromDto.getPatientId());
		return entity;
	}

	public BillDto exportDto(BillDo entity) {
		BillDto dto = new BillDto();
		dto.setBillId(entity.getBillId());
		dto.setStatus(entity.getStatus());
		dto.setType(entity.getType());
		dto.setCreatedAt(entity.getCreatedAt());
		dto.setPatientId(entity.getPatientId());
		return dto;
	}

	public String generateBill(String type, String status, String patientId) {
		BillDto billDto = new BillDto();
		Date createdAt = new Date();
		String id = String.valueOf(createdAt.getTime());
		billDto.setBillId(id);
		billDto.setCreatedAt(createdAt);
		billDto.setStatus(status);
		billDto.setPatientId(patientId);
		billDto.setType(type);
		this.getSession().save(importDto(billDto));
		return String.valueOf(createdAt.getTime());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BillResponseDto fetchBillDtails(String patientId, String billId) {
		BillResponseDto billingResponse = new BillResponseDto();
		List<PrescribedMedsDto> medicineList = new ArrayList<>();
		List<PrescribedTestingDto> testList = new ArrayList<>();
		try {
			String queryString = "";
			org.hibernate.query.Query query=null;
			if(!ServicesUtil.isEmpty(patientId)){
				queryString = "select b , pm , pt from BillDo b join PrescribedMedsDo pm on b.billId = pm.billId join PrescribedTestingDo pt on  b.billId = pt.billId where b.patientId = :patientId";
				 query = this.getSession().createQuery(queryString);
				query.setParameter("patientId", patientId);
			}else{
				 queryString = "select b , pm , pt from BillDo b join PrescribedMedsDo pm on b.billId = pm.billId join PrescribedTestingDo pt on  b.billId = pt.billId where b.billId = :billId";
					 query = this.getSession().createQuery(queryString);
					query.setParameter("billId", billId);
			}
			
			List<Object[]> entities = query.list();
			BillDto billDto = exportDto((BillDo) entities.get(0)[0]);
			billingResponse.setBillDto(billDto);
			for (Object objs[] : entities) {
				medicineList.add(prescribedMedsDao.exportDto((PrescribedMedsDo)objs[1]));
				testList.add(prescribedTestingDao.exportDto((PrescribedTestingDo)objs[2]));
			}
			billingResponse.setMedicineList(medicineList);
			billingResponse.setTestList(testList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return billingResponse;

	}
}
