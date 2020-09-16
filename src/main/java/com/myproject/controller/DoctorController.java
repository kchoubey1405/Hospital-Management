package com.myproject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.dto.PrescriptionDto;
import com.myproject.dto.ResponseDto;

@RestController
@RequestMapping("/doctorService")
public class DoctorController {
	
	@PostMapping("/savePriscription")
	public ResponseDto savePriscription(@RequestBody PrescriptionDto prescriptionDto){
		return null;
	}
	

}
