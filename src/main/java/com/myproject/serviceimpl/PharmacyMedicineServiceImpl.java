/**
 * 
 */
package com.myproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.PharmacyMedicineDao;
import com.myproject.dto.PharmacyMedicineDto;
import com.myproject.service.PharmacyMedicineService;

/**
 * @author Kamlesh.Choubey
 *
 */
@Service
public class PharmacyMedicineServiceImpl implements PharmacyMedicineService{

	@Autowired
	PharmacyMedicineDao pharmacyMedicineDao;
	@Override
	public String saveOrUpdatePharmacyMedicine(PharmacyMedicineDto dto) {
		return pharmacyMedicineDao.saveOrUpdateMedicine(dto);
	}
	@Override
	public String deleteMedicineRecord(PharmacyMedicineDto dto) {
		return pharmacyMedicineDao.deleteMedicineRecord(dto);
	}
	@Override
	public PharmacyMedicineDto getMedicineDetails(Integer medicineId) {
		return pharmacyMedicineDao.getMedicineDetails(medicineId);
	}
	@Override
	public List<PharmacyMedicineDto> getMedicineList() {
		return pharmacyMedicineDao.getMedicineList();
	}

}
