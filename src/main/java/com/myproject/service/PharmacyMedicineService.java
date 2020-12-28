/**
 * 
 */
package com.myproject.service;

import java.util.List;

import com.myproject.dto.PharmacyMedicineDto;
import com.myproject.dto.SupplierDto;

/**
 * @author Kamlesh.Choubey
 *
 */
public interface PharmacyMedicineService {
	public PharmacyMedicineDto getMedicineDetails(Integer medicineId);
	public List<PharmacyMedicineDto> getMedicineList();
	public String saveOrUpdatePharmacyMedicine(PharmacyMedicineDto dto);
	public List<SupplierDto> getSupplierList();
	public String saveOrUpdateSupplier(SupplierDto dto);
	public String deleteMedicineRecord(PharmacyMedicineDto dto);
}
