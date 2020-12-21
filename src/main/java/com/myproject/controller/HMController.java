/**
 * 
 */
package com.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.dto.AppointmentDto;
import com.myproject.dto.BillResponseDto;
import com.myproject.dto.BillingDto;
import com.myproject.dto.ResponseDto;
import com.myproject.service.BillingService;
import com.myproject.service.HospitalServices;

/**
 * @author Kamlesh.Choubey
 *
 */
@RestController
@RequestMapping("/HMServiceController")
public class HMController {

	@Autowired
	HospitalServices hospitalServices;
	@Autowired
	BillingService billingService;

	@PostMapping("/createNewAppointment")
	public ResponseDto createAppointment(@RequestBody AppointmentDto appointmentDto) {
		return hospitalServices.createAppointment(appointmentDto);
	}

	@GetMapping("/getAppointmentDetailById")
	public AppointmentDto getAppointmentDetailById(@RequestParam(value = "appointmentId") String appointmentId) {
		return hospitalServices.getAppointmentDetailById(appointmentId);
	}

	@GetMapping("/getAppointmentList")
	public List<AppointmentDto> getAppointmentList(@RequestParam(value = "doctorId") String doctorId,
			@RequestParam(value = "numberOfDays") int numberOfDays, @RequestParam(value = "startIndex") int startIndex,
			@RequestParam(value = "pazeSize") int pazeSize) {
		return hospitalServices.getAppointmentList(doctorId, numberOfDays, startIndex, pazeSize);
	}

	@GetMapping("/fetchBillDtails")
	public BillResponseDto fetchBillDtails(@RequestParam(value="patientId") String patientId, @RequestParam(value="billId") String billId) {

		return billingService.fetchBillDtails(patientId, billId);
	}
	
	@PostMapping("/generateBill")
	public String generateBill(@RequestBody BillingDto billingDto) {
		return hospitalServices.generateBill(billingDto);
	}

}
