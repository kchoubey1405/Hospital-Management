/**
 * 
 */
package com.myproject.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.myproject.dto.PrescriptionDto;
import com.myproject.dto.ResponseDto;

/**
 * @author Kamlesh.Choubey
 *
 */
public interface DoctorService {
	public ResponseDto savePriscription(PrescriptionDto prescriptionDto);

}
