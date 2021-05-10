package com.myproject.serviceimpl;

import com.myproject.dao.BrandDao;
import com.myproject.dao.PatientDao;
import com.myproject.dto.BrandDto;
import com.myproject.dto.ResponseDto;
import com.myproject.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class SettingsServiceImpl implements SettingsService {
    @Autowired
    BrandDao brandDao;
    private final Path root = Paths.get("uploads");

    @PostConstruct
    public void init(){
        try {
            if(!Files.exists(root)) {
                Files.createDirectory(root);
            }

        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public List<BrandDto> getBrandDetails() {
        return brandDao.getBrandDetails();
    }

    @Override
    public ResponseDto saveBrandDetails(BrandDto brandDto) {
        return brandDao.saveBrandDetails(brandDto, root);
    }
}
