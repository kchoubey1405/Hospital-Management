package com.myproject.serviceimpl;

import com.myproject.dao.BrandDao;
import com.myproject.dao.PatientDao;
import com.myproject.dto.BrandDto;
import com.myproject.dto.ResponseDto;
import com.myproject.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingsServiceImpl implements SettingsService {
    @Autowired
    BrandDao brandDao;

    @Override
    public List<BrandDto> getBrandDetails() {
        return brandDao.getBrandDetails();
    }

    @Override
    public ResponseDto saveBrandDetails(BrandDto brandDto) {
        return brandDao.saveBrandDetails(brandDto);
    }
}
