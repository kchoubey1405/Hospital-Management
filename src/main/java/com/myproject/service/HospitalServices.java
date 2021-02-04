/**
 * 
 */
package com.myproject.service;

import java.util.HashMap;
import java.util.List;

import com.myproject.dto.AppointmentDto;
import com.myproject.dto.BillingDto;
import com.myproject.dto.ResponseDto;

/**
 * @author Kamlesh.Choubey
 *
 */
public interface HospitalServices {
	
	public ResponseDto createAppointment(AppointmentDto appointmentDto);
	public AppointmentDto getAppointmentDetailById(String appointmentId);
	public List<AppointmentDto> getAppointmentList(String doctorId , int numberOfDays , int startIndex, int lastIndext);
	public HashMap<String , Object> generateBill(BillingDto billingDto) ;
	public List<BillingDto> fetchBillDtails(Integer patientId, String billId);
	public List<AppointmentDto> getAppointmentListByPatientId(String patientId);
	public List<BillingDto> fetchBillList(Long todate, Long fromDate, String billType);

}
