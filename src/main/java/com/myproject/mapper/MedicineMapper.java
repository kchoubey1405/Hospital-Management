package com.myproject.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.myproject.dto.MedicineDto;
import com.myproject.dto.TestDto;
import com.myproject.entity.MedicineDo;
import com.myproject.entity.TestDo;

@Mapper(componentModel = "spring", uses = {})
@Component
public interface MedicineMapper {

    MedicineDo getMedicineDo(MedicineDto medicineDto);

    TestDo getTestDo(TestDto medicineDto);
}
