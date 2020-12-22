/**
 * 
 */
package com.myproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.AppointmentDao;
import com.myproject.dao.BillingDao;
import com.myproject.dto.AppointmentDto;
import com.myproject.dto.BillingDto;
import com.myproject.dto.ResponseDto;
import com.myproject.service.HospitalServices;
import com.myproject.utill.ApplicationConstant;

/**
 * @author Kamlesh.Choubey
 *
 */
@Service
public class HospitalServicesImpl implements HospitalServices{

	@Autowired
	AppointmentDao appointmentDao;
	
	@Autowired
	BillingDao billingDao;
	
	@Override
	public ResponseDto createAppointment(AppointmentDto appointmentDto) {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setResponseMessage("Creation failed");
		responseDto.setResponseCode(ApplicationConstant.FAILURE_CODE);
		responseDto.setStatus(ApplicationConstant.FAILURE);
//		System.err.println("inside service"+appointmentDto.toString());
//		billDao.generateBill(ApplicationConstant.REGISTRATION, ApplicationConstant.PAID, appointmentDto.getPatientId());
		appointmentDao.saveOrUpdate(appointmentDto);
		responseDto.setResponseMessage("Saved successfully");
		responseDto.setResponseCode(ApplicationConstant.SUCCESS_CODE);
		responseDto.setStatus(ApplicationConstant.SUCCESS);
		return responseDto;
	}

	@Override
	public AppointmentDto getAppointmentDetailById(String appointmentId) {
		return appointmentDao.getAppointmentDetailsById(appointmentId);
	}

	@Override
	public List<AppointmentDto> getAppointmentList(String doctorId, int numberOfDays, int startIndex, int pageSize) {
		return appointmentDao.getAppointmentList(doctorId, numberOfDays, startIndex, pageSize);
	}

	@Override
	public String generateBill(BillingDto billingDto) {
		return billingDao.generateBill(billingDto);
	}

}
