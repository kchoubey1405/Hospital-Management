/**
 * 
 */
package com.myproject.service;

import com.myproject.dto.BillResponseDto;

/**
 * @author Kamlesh.Choubey
 *
 */
public interface BillingService {

	BillResponseDto fetchBillDtails(String patientId, String billId);
}
