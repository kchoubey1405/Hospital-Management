/**
 * 
 */
package com.myproject.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.BillDao;
import com.myproject.dto.BillResponseDto;
import com.myproject.service.BillingService;

/**
 * @author Kamlesh.Choubey
 *
 */
@Service
public class BillingServiceImpl implements BillingService{

	@Autowired
	BillDao billDao;
	
	@Override
	public BillResponseDto fetchBillDtails(String patientId, String billId) {
		
		return billDao.fetchBillDtails(patientId, billId);
	}

}
