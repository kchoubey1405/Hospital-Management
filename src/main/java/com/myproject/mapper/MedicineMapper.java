package com.myproject.mapper;

import com.myproject.dto.MedicineDto;
import com.myproject.dto.TestDto;
import com.myproject.entity.MedicineDo;
import com.myproject.entity.TestDo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface MedicineMapper {

    MedicineDo getMedicineDo(MedicineDto medicineDto);

    TestDo getTestDo(TestDto medicineDto);
}
