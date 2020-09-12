package com.myproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.PatientDao;
import com.myproject.dto.PatientDto;
import com.myproject.dto.ResponseDto;
import com.myproject.service.PatientService;
import com.myproject.utill.ApplicationConstant;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientDao patientDao;
	
	@Override
	public ResponseDto registerNewPatient(PatientDto patientDto) {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setResponseMessage("Creation failed");
		responseDto.setResponseCode(ApplicationConstant.FAILURE_CODE);
		responseDto.setStatus(ApplicationConstant.FAILURE);
		try{
			patientDao.registerNewPatient(patientDto);
			responseDto.setResponseMessage("Saved or updated successfully");
			responseDto.setResponseCode(ApplicationConstant.SUCCESS_CODE);
			responseDto.setStatus(ApplicationConstant.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
		}
		return responseDto;
	}

	@Override
	public String getPatientNameById(String patientId) {
		return patientDao.getPatientNameById(patientId);
	}

	@Override
	public PatientDto getPatientById(String patientId) {
		return patientDao.getPatientById(patientId);
	}

	@Override
	public List<PatientDto> getAllPatientList(String patientId) {
		return patientDao.getAllPatientList(patientId);
	}

}
