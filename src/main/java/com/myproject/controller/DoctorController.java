package com.myproject.controller;

import java.util.List;

import com.myproject.dto.DoctorDto;
import com.myproject.dto.PrescriptionDto;
import com.myproject.dto.ResponseDto;
import com.myproject.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctorService")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/savePrescription")
    public ResponseDto savePrescription(@RequestBody PrescriptionDto prescriptionDto) {
        return doctorService.savePriscription(prescriptionDto);
    }
    
    @GetMapping("/getPrescriptionDetails")
    public PrescriptionDto getPrescriptionDetails(@RequestParam(value="appointmentId") String appointmentId) {
        return doctorService.getPrescriptionDetails(appointmentId);
    }

    @PostMapping("/createNewDoctorsRecord")
    public ResponseDto createNewDoctorsRecord(@RequestBody DoctorDto doctorDto) {
        return doctorService.createNewDoctorRecord(doctorDto);
    }

    @GetMapping("/getDoctorDetailById")
    public DoctorDto getDoctorDetailById(@RequestParam(value = "doctorId") String doctorId) {
        return doctorService.getDoctorById(doctorId);
    }

    @GetMapping("/getDoctorsListByDepartment")
    public List<DoctorDto> getDoctorsList(@RequestParam(value = "departmentName") String departmentName) {
        return doctorService.getDoctorsList(departmentName);
    }

    @GetMapping("/getDoctorsList")
    public List<DoctorDto> getDoctorsList() {
        return doctorService.getAllDoctorsList();
    }
}
