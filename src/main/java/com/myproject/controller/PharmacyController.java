/**
 * 
 */
package com.myproject.controller;

import java.util.List;

import com.myproject.dto.SupplierDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.dto.PharmacyMedicineDto;
import com.myproject.service.PharmacyMedicineService;

/**
 * @author Kamlesh.Choubey
 *
 */

@RestController
@RequestMapping("/pharmacyController")
public class PharmacyController {
	
	@Autowired
	PharmacyMedicineService pharmacyMedicineService;
	
	@PostMapping("/saveOrUpdatePharmacyMedicine")
	public String saveOrUpdatePharmacyMedicine(@RequestBody PharmacyMedicineDto dto) {
		return pharmacyMedicineService.saveOrUpdatePharmacyMedicine(dto);
	}

	@GetMapping("/getMedicineDetails")
	public PharmacyMedicineDto getMedicineDetails(@RequestParam(value = "medicineId") Integer medicineId){
		return pharmacyMedicineService.getMedicineDetails(medicineId);
	}
	
	@DeleteMapping("/deleteMedicineRecord")
	public String deleteMedicineRecord(@RequestBody PharmacyMedicineDto dto){
		return pharmacyMedicineService.deleteMedicineRecord(dto);
	}
	
	@GetMapping("/getMedicineList")
	public List<PharmacyMedicineDto> getMedicineList(){
		return pharmacyMedicineService.getMedicineList();
	}


	@PostMapping("/saveSupplier")
	public String saveOrUpdateSupplier(@RequestBody SupplierDto dto) {
		return pharmacyMedicineService.saveOrUpdateSupplier(dto);
	}

	@GetMapping("/getSupplierList")
	public List<SupplierDto> getSuppliersList(){
		return pharmacyMedicineService.getSupplierList();
	}

}
