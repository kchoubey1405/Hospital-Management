package com.myproject.service;

import java.util.List;

import com.myproject.dto.MedicineDto;
import com.myproject.dto.PatientDto;
import com.myproject.dto.ResponseDto;

public interface MedicineService {
    ResponseDto addMedicine(MedicineDto medicineDto);
//    String getPatientNameById(String patientId);
//    PatientDto getPatientById(String patientId);
    List<MedicineDto> getAllMedicineList();
}
