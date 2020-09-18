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
	HashMap<String , String> registerNewPatient(PatientDto patientDto);
	String getPatientNameById(String patientId);
	PatientDto getPatientById(String patientId);
	List<PatientDto> getAllPatientList(String patientId);
}
