/**
 * 
 */
package com.myproject.service;

import java.util.List;

import com.myproject.dto.DoctorDto;
import com.myproject.dto.PrescriptionDto;
import com.myproject.dto.ResponseDto;

/**
 * @author Kamlesh.Choubey
 *
 */
public interface DoctorService {
	public ResponseDto savePriscription(PrescriptionDto prescriptionDto);
	public DoctorDto getDoctorById(String doctorId);
	public List<DoctorDto> getDoctorsList(String department);
	public List<DoctorDto> getAllDoctorsList();
	public ResponseDto createNewDoctorRecord(DoctorDto doctorDto);

}
