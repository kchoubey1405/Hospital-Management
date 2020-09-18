package com.myproject.service;

import java.util.List;

import com.myproject.dto.MedicineDto;
import com.myproject.dto.ResponseDto;
import com.myproject.dto.TestDto;

public interface TestService {

    ResponseDto addTest(TestDto testDto);

    List<TestDto> getAllTests();
}
