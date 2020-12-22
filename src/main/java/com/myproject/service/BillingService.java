/**
 * 
 */
package com.myproject.service;

import com.myproject.dto.BillResponseDto;
import com.myproject.dto.BillingDto;

/**
 * @author Kamlesh.Choubey
 *
 */
public interface BillingService {

	BillResponseDto fetchBillDtails(String patientId, String billId);
	public String generateBill(BillingDto billingDto) ;
}
