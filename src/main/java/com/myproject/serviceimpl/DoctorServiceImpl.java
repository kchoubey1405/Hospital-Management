/**
 * 
 */
package com.myproject.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.AppointmentDao;
import com.myproject.dao.BillDao;
import com.myproject.dao.PrescribedMedsDao;
import com.myproject.dao.PrescribedTestingDao;
import com.myproject.dto.AppointmentDto;
import com.myproject.dto.BillDto;
import com.myproject.dto.PrescribedMedsDto;
import com.myproject.dto.PrescribedTestingDto;
import com.myproject.dto.PrescriptionDto;
import com.myproject.dto.ResponseDto;
import com.myproject.service.DoctorService;
import com.myproject.utill.ApplicationConstant;

/**
 * @author Kamlesh.Choubey
 *
 */
@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	AppointmentDao appointmentDao;
	
	@Autowired
	PrescribedMedsDao prescribedMedsDao;
	
	@Autowired
	PrescribedTestingDao prescribedTestingDao;
	
	@Autowired
	BillDao billDao;
	
	@Override
	public ResponseDto savePriscription(PrescriptionDto prescriptionDto) {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setResponseMessage("Creation failed");
		responseDto.setResponseCode(ApplicationConstant.FAILURE_CODE);
		responseDto.setStatus(ApplicationConstant.FAILURE);
		AppointmentDto appointmentDto = prescriptionDto.getAppointmentDto();
		appointmentDao.createOrUpdate(appointmentDto);
		List<PrescribedMedsDto> prescribedMedsDtoList = prescriptionDto.getPrescribedMedsDtoList();
		prescribedMedsDtoList.stream().forEach(p -> {
		p.setBillId(billDao.generateBill(ApplicationConstant.MEDICINEBILL, ApplicationConstant.PAID));
		prescribedMedsDao.create(p);
		});
		List<PrescribedTestingDto> prescribedTestingDtoList = prescriptionDto.getPrescribedTestingDtoList();
		prescribedTestingDtoList.stream().forEach(d -> {
			d.setBillId(billDao.generateBill(ApplicationConstant.MEDICINEBILL, ApplicationConstant.PAID));
			prescribedTestingDao.create(d);
			});
		responseDto.setResponseMessage("Saved successfully");
		responseDto.setResponseCode(ApplicationConstant.SUCCESS_CODE);
		responseDto.setStatus(ApplicationConstant.SUCCESS);
		return responseDto;
	}

}
