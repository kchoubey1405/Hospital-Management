package com.myproject.service;

import com.myproject.dto.BrandDto;
import com.myproject.dto.PharmacyMedicineDto;
import com.myproject.dto.ResponseDto;

import java.util.List;

public interface SettingsService {
    public void init();
    public List<BrandDto> getBrandDetails();
    public ResponseDto saveBrandDetails(BrandDto brandDto);

}
