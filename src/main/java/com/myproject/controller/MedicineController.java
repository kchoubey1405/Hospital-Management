package com.myproject.controller;

import java.util.List;

import com.myproject.dto.MedicineDto;
import com.myproject.dto.PatientDto;
import com.myproject.dto.ResponseDto;
import com.myproject.service.MedicineService;
import com.myproject.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicine")
public class MedicineController {
    @Autowired
    MedicineService medicineService;

    @GetMapping("/medicineList")
    public List<MedicineDto> getAllMedicineList() {
        return medicineService.getAllMedicineList();
    }

    @PostMapping("/medicine")
    public ResponseDto addNewMedicine(@RequestBody MedicineDto medicineDto){
        return medicineService.addMedicine(medicineDto);
    }
}
