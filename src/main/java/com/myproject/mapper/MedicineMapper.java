package com.myproject.mapper;

import com.myproject.dto.MedicineDto;
import com.myproject.dto.PatientDto;
import com.myproject.entity.MedicineDo;
import com.myproject.entity.PatientDo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface MedicineMapper {

    MedicineDo getMedicineDo(MedicineDto medicineDto);
}
