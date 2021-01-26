/**
 * 
 */
package com.myproject.service;

import java.util.HashMap;
import java.util.List;

import com.myproject.dto.PatientDto;

/**
 * @author Kamlesh.Choubey
 *
 */

public interface PatientService {
	HashMap<String , Object> registerNewPatient(PatientDto patientDto);
	String getPatientNameById(String patientId);
	PatientDto getPatientById(int patientId);
	List<PatientDto> getAllPatientList();
	List<PatientDto> getPatientByName(String patientName);
}
