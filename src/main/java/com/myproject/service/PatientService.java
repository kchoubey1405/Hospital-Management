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
	public ResponseDto registerNewPatient(PatientDto patientDto);
	public String getPatientNameById(String patientId);
	public PatientDto getPatientById(String patientId);
	public List<PatientDto> getAllPatientList(String patientId);
}
