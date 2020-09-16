/**
 * 
 */
package com.myproject.entity;

import com.myproject.dto.AppointmentDto;
import com.myproject.entity.AppointmentDo;

/**
 * @author Kamlesh.Choubey
 *
 */
public class AppointmentDao {
	public AppointmentDo importDto(AppointmentDto fromDto) {
		AppointmentDo entity = new AppointmentDo();
		entity.setAppointmentId(fromDto.getAppointmentId());
		entity.setAdvise(fromDto.getAdvise());
		entity.setBp(fromDto.getBp());
		entity.setDiseaseDesc(fromDto.getDiseaseDesc());
		entity.setDoctorId(fromDto.getDoctorId());
		entity.setHeight(fromDto.getHeight());
		entity.setPatientId(fromDto.getPatientId());
		entity.setWeight(fromDto.getWeight());
		return entity;
	}

	public AppointmentDto exportDto(AppointmentDo entity) {
		AppointmentDto dto = new AppointmentDto();
		dto.setAppointmentId(entity.getAppointmentId());
		dto.setAdvise(entity.getAdvise());
		dto.setBp(entity.getBp());
		dto.setDiseaseDesc(entity.getDiseaseDesc());
		dto.setDoctorId(entity.getDoctorId());
		dto.setHeight(entity.getHeight());
		dto.setPatientId(entity.getPatientId());
		dto.setWeight(entity.getWeight());
		return dto;
	}

}
