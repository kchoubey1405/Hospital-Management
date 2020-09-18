package com.myproject.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.myproject.dao.MedicineDao;
import com.myproject.dao.TestDao;
import com.myproject.dto.MedicineDto;
import com.myproject.dto.ResponseDto;
import com.myproject.dto.TestDto;
import com.myproject.entity.MedicineDo;
import com.myproject.entity.TestDo;
import com.myproject.mapper.MedicineMapper;
import com.myproject.service.TestService;
import com.myproject.utill.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    TestDao testDao;

    @Autowired
    private MedicineMapper mapper;

    @Override
    public ResponseDto addTest(TestDto testDto) {
        TestDo testDo = mapper.getTestDo(testDto);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setResponseMessage("Creation failed");
        responseDto.setResponseCode(ApplicationConstant.FAILURE_CODE);
        responseDto.setStatus(ApplicationConstant.FAILURE);
        try {
            testDao.save(testDo);
            responseDto.setResponseMessage("Saved or updated successfully");
            responseDto.setResponseCode(ApplicationConstant.SUCCESS_CODE);
            responseDto.setStatus(ApplicationConstant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseDto;
    }

    @Override
    public List<TestDto> getAllTests() {
        List<TestDto> testDtos = new ArrayList<>();
        List<TestDo> testDos = testDao.findAll();
        for (TestDo testDo : testDos) {
            TestDto testDto = new TestDto();
            testDto.setPrice(testDo.getPrice());
            testDto.setTestName(testDo.getTestName());
            testDtos.add(testDto);
        }
        return testDtos;
    }
}
