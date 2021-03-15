package com.myproject.controller;

import com.myproject.dto.BrandDto;
import com.myproject.dto.PharmacyMedicineDto;
import com.myproject.dto.ResponseDto;
import com.myproject.service.PharmacyMedicineService;
import com.myproject.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SettingsController")
public class SettingsController {
    @Autowired
    SettingsService settingsService;

    @PostMapping("/updateBrandDetails")
    public ResponseDto updateBrandDetails(@RequestBody BrandDto dto) {
        return settingsService.saveBrandDetails(dto);
    }

    @GetMapping("/getBrandDetails")
    public List<BrandDto> getBrandDetails(){
        return settingsService.getBrandDetails();
    }
}
