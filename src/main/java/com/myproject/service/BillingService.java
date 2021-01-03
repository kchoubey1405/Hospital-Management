/**
 * 
 */
package com.myproject.service;

import java.util.HashMap;

import com.myproject.dto.BillResponseDto;
import com.myproject.dto.BillingDto;

/**
 * @author Kamlesh.Choubey
 *
 */
public interface BillingService {

	BillResponseDto fetchBillDtails(String patientId, String billId);
	public HashMap<String , Object> generateBill(BillingDto billingDto) ;
}
