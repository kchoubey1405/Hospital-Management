/**
 * 
 */
package com.myproject.controller;

import java.util.List;

import com.myproject.dto.SupplierDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.myproject.dto.PharmacyMedicineDto;
import com.myproject.dto.PurchaseOrderDto;
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
	
	@DeleteMapping("/deleteMedicineRecord/{medicineId}")
	public String deleteMedicineRecord(@PathVariable(value = "medicineId") String medicineId){
		return pharmacyMedicineService.deleteMedicineRecord(medicineId);
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
	
	@PostMapping("/saveOrUpdatePurchaseOrder")
	public String saveOrUpdatePurchaseOrder(@RequestBody PurchaseOrderDto dto) {
		return pharmacyMedicineService.saveOrUpdatePurchaseOrder(dto);
	}

	@DeleteMapping("/deletePurchaseOrder")
	public String deletePurchaseOrder(@RequestBody PurchaseOrderDto dto) {
		return pharmacyMedicineService.deletePurchaseOrder(dto);
	}

	@GetMapping("/getPurchaseOrderDetails")
	public PurchaseOrderDto getPurchaseOrderDetails(@RequestParam(value="purchaseOrderId") Integer purchaseOrderId) {
		return pharmacyMedicineService.getPurchaseOrderDetails(purchaseOrderId);
	}

	@GetMapping("/getPurchaseOrderList")
	public List<PurchaseOrderDto> getPurchaseOrderList() {
		return pharmacyMedicineService.getPurchaseOrderList();
	}
	
	@GetMapping("/getMedicineListByName")
	public List<PharmacyMedicineDto> getMedicineListByName(@RequestParam(value="medicineName") String medicineName) {
		return pharmacyMedicineService.getMedicineListByName(medicineName);
	}

}
