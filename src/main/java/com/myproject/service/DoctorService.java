/**
 * 
 */
package com.myproject.service;

import com.myproject.dto.PrescriptionDto;
import com.myproject.dto.ResponseDto;

/**
 * @author Kamlesh.Choubey
 *
 */
public interface DoctorService {
	public ResponseDto savePriscription(PrescriptionDto prescriptionDto);

}
