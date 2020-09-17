package com.myproject.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.myproject.dao.MedicineDao;
import com.myproject.dto.MedicineDto;
import com.myproject.dto.ResponseDto;
import com.myproject.entity.MedicineDo;
import com.myproject.mapper.MedicineMapper;
import com.myproject.service.MedicineService;
import com.myproject.utill.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    MedicineDao medicineDao;

    @Autowired
    private MedicineMapper medicineMapper;

    @Override
    public List<MedicineDto> getAllMedicineList() {
        List<MedicineDto> medicineDtos = new ArrayList<>();
        List<MedicineDo> medicineDos = medicineDao.findAll();
        for (MedicineDo medicineDo : medicineDos) {
            MedicineDto medicineDto = new MedicineDto();
            medicineDto.setMedicineName(medicineDo.getMedicineName());
            medicineDto.setMedicineType(medicineDo.getMedicineType());
            medicineDto.setPrice(medicineDo.getPrice());
            medicineDto.setStrength(medicineDo.getStrength());
            medicineDtos.add(medicineDto);
        }
        return medicineDtos;
    }

    @Override
    public ResponseDto addMedicine(MedicineDto medicineDto) {
        MedicineDo medicineDo = medicineMapper.getMedicineDo(medicineDto);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setResponseMessage("Creation failed");
        responseDto.setResponseCode(ApplicationConstant.FAILURE_CODE);
        responseDto.setStatus(ApplicationConstant.FAILURE);
        try {
            medicineDao.save(medicineDo);
            responseDto.setResponseMessage("Saved or updated successfully");
            responseDto.setResponseCode(ApplicationConstant.SUCCESS_CODE);
            responseDto.setStatus(ApplicationConstant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseDto;
    }
}
