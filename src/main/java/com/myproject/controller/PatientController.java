/**
 * 
 */
package com.myproject.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.dto.PatientDto;
import com.myproject.service.PatientService;

/**
 * @author Kamlesh.Choubey
 *
 */
@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	PatientService patientService;
	
	@PostMapping("/registration")
	public  HashMap<String , Object> registerNewPatient(@RequestBody PatientDto patientDto){
		return patientService.registerNewPatient(patientDto);
	}
	
	@GetMapping("/patientNameById")
	public String getPatientNameById(@RequestParam(value="patientId") String patientId){
		return patientService.getPatientNameById(patientId);
	}

	@GetMapping("/patientById")
	public PatientDto getPatientById(@RequestParam int patientId) {
		return patientService.getPatientById(patientId);
	}
	
	@GetMapping("/patientByName")
	public List<PatientDto> getPatientByName(@RequestParam String patientName) {
		return patientService.getPatientByName(patientName);
	}

	@GetMapping("/patientsList")
	public List<PatientDto> getAllPatientList() {
		return patientService.getAllPatientList();
	}
}
