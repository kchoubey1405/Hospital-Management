/**
 * 
 */
package com.myproject.service;

import java.util.List;

import com.myproject.dto.AppointmentDto;
import com.myproject.dto.ResponseDto;

/**
 * @author Kamlesh.Choubey
 *
 */
public interface HospitalServices {
	
	public ResponseDto createAppointment(AppointmentDto appointmentDto);
	public AppointmentDto getAppointmentDetailById(String appointmentId);
	public List<AppointmentDto> getAppointmentList(String doctorId , int numberOfDays , int startIndex, int lastIndext);

}
