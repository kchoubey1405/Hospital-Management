/**
 * 
 */
package com.myproject.service;

import java.util.List;

import com.myproject.dto.PatientDto;
import com.myproject.dto.ResponseDto;

/**
 * @author Kamlesh.Choubey
 *
 */

public interface PatientService {
	ResponseDto registerNewPatient(PatientDto patientDto);
	String getPatientNameById(String patientId);
	PatientDto getPatientById(String patientId);
	List<PatientDto> getAllPatientList(String patientId);
}
