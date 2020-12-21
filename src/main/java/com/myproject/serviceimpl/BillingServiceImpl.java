/**
 * 
 */
package com.myproject.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.BillDao;
import com.myproject.dao.BillingDao;
import com.myproject.dto.BillResponseDto;
import com.myproject.dto.BillingDto;
import com.myproject.service.BillingService;

/**
 * @author Kamlesh.Choubey
 *
 */
@Service
public class BillingServiceImpl implements BillingService{

	@Autowired
	BillDao billDao;
	
	@Autowired
	BillingDao billingDao;
	
	@Override
	public BillResponseDto fetchBillDtails(String patientId, String billId) {
		
		return billDao.fetchBillDtails(patientId, billId);
	}
	
	@Override
	public String generateBill(BillingDto billingDto) {
		return billingDao.generateBill(billingDto);
	}

}
