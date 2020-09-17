/**
 * 
 */
package com.myproject.dto;

import java.util.List;

/**
 * @author Kamlesh.Choubey
 *
 */
public class PrescriptionDto {
	private AppointmentDto appointmentDto;
	private List<PrescribedMedsDto> prescribedMedsDtoList;
	private List<PrescribedTestingDto> prescribedTestingDtoList;
	private ResponseDto responseDto;
	public AppointmentDto getAppointmentDto() {
		return appointmentDto;
	}
	public void setAppointmentDto(AppointmentDto appointmentDto) {
		this.appointmentDto = appointmentDto;
	}
	public List<PrescribedMedsDto> getPrescribedMedsDtoList() {
		return prescribedMedsDtoList;
	}
	public void setPrescribedMedsDtoList(List<PrescribedMedsDto> prescribedMedsDtoList) {
		this.prescribedMedsDtoList = prescribedMedsDtoList;
	}
	public List<PrescribedTestingDto> getPrescribedTestingDtoList() {
		return prescribedTestingDtoList;
	}
	public void setPrescribedTestingDtoList(List<PrescribedTestingDto> prescribedTestingDtoList) {
		this.prescribedTestingDtoList = prescribedTestingDtoList;
	}
	public ResponseDto getResponseDto() {
		return responseDto;
	}
	public void setResponseDto(ResponseDto responseDto) {
		this.responseDto = responseDto;
	}
	
}
