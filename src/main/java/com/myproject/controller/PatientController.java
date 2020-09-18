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

import com.myproject.dao.PatientDao;
import com.myproject.dto.PatientDto;
import com.myproject.dto.ResponseDto;
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
	public  HashMap<String , String> registerNewPatient(@RequestBody PatientDto patientDto){
		return patientService.registerNewPatient(patientDto);
	}
	
	@GetMapping("/patientNameById")
	public String getPatientNameById(@RequestParam(value="patientId") String patientId){
		return patientService.getPatientNameById(patientId);
	}

	@GetMapping("/patientById")
	public PatientDto getPatientById(@RequestParam String patientId) {
		return patientService.getPatientById(patientId);
	}

	@GetMapping("/patientsList")
	public List<PatientDto> getAllPatientList(String patientId) {
		return patientService.getAllPatientList(patientId);
	}
}
