package com.myproject.serviceimpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.BillDao;
import com.myproject.dao.PatientDao;
import com.myproject.dto.PatientDto;
import com.myproject.dto.ResponseDto;
import com.myproject.service.PatientService;
import com.myproject.utill.ApplicationConstant;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientDao patientDao;
	
	@Autowired
	BillDao billDao;
	
	@Override
	public HashMap<String , Object> registerNewPatient(PatientDto patientDto) {
		HashMap<String , Object> response = new HashMap<>();
		ResponseDto responseDto = new ResponseDto();
		responseDto.setResponseMessage("Creation failed");
		responseDto.setResponseCode(ApplicationConstant.FAILURE_CODE);
		responseDto.setStatus(ApplicationConstant.FAILURE);
		try{
			int patientId = patientDao.registerNewPatient(patientDto);
			response.put("patientId", patientId);
			String billId = billDao.generateBill(ApplicationConstant.REGISTRATION, ApplicationConstant.PAID,patientId);
			response.put("recieptId", billId);
			responseDto.setResponseMessage("Saved or updated successfully");
			responseDto.setResponseCode(ApplicationConstant.SUCCESS_CODE);
			responseDto.setStatus(ApplicationConstant.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
		}
		response.put("responseMessage", responseDto.toString());
		return response;
	}

	@Override
	public String getPatientNameById(String patientId) {
		return patientDao.getPatientNameById(patientId);
	}

	@Override
	public PatientDto getPatientById(int patientId) {
		return patientDao.getPatientById(patientId);
	}

	@Override
	public List<PatientDto> getAllPatientList() {
		return patientDao.getAllPatientList();
	}

	@Override
	public List<PatientDto> getPatientByName(String patientName) {
		return patientDao.getPatientByName(patientName);
	}

}
