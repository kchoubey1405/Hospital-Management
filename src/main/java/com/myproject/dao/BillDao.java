/**
 * 
 */
package com.myproject.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dto.BillDto;
import com.myproject.entity.BillDo;
import com.myproject.persistent.util.BaseDao;
import com.myproject.utill.ApplicationConstant;

/**
 * @author Kamlesh.Choubey
 *
 */
@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class BillDao extends BaseDao<BillDo, BillDto>{
	public BillDo importDto(BillDto fromDto) {
		BillDo entity = new BillDo();
		entity.setBillId(fromDto.getBillId());
		entity.setStatus(fromDto.getStatus());
		entity.setType(fromDto.getType());
		entity.setCreatedAt(fromDto.getCreatedAt());
		return entity;
	}

	public BillDto exportDto(BillDo entity) {
		BillDto dto = new BillDto();
		dto.setBillId(entity.getBillId());
		dto.setStatus(entity.getStatus());
		dto.setType(entity.getType());
		dto.setCreatedAt(entity.getCreatedAt());
		return dto;
	}
	
	public String generateBill(String type , String status){
		BillDto billDto = new BillDto();
		Date createdAt = new Date();
		billDto.setBillId(String.valueOf(createdAt.getTime()));
		billDto.setCreatedAt(createdAt);
		billDto.setType(type);
		billDto.setStatus(status);
		this.getSession().save(importDto(billDto));
		return String.valueOf(createdAt.getTime());
	}
}
