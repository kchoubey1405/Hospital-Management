/**
 * 
 */
package com.myproject.controller;

import java.util.List;

import com.myproject.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@PostMapping("/saveItemCategory")
	public ResponseDto saveItemCategory(@RequestBody ItemCategoryDto dto) {
		return pharmacyMedicineService.saveOrUpdateItemCategory(dto);
	}

	@PostMapping("/saveItemUnit")
	public ResponseDto saveItemCategory(@RequestBody ItemUnitDto dto) {
		return pharmacyMedicineService.saveOrUpdateItemUnit(dto);
	}

	@GetMapping("/getAllItemCategories")
	public List<ItemCategoryDto> getAllItemCategories() {
		return pharmacyMedicineService.getAllItemCategories();
	}

	@GetMapping("/getAllItemUnits")
	public List<ItemUnitDto> getAllItemUnits() {
		return pharmacyMedicineService.getAllItemUnits();
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

	@GetMapping("/searchPurchaseOrder")
	public List<PurchaseOrderDto> searchPurchaseOrder(@RequestParam(value="invoiceNum") String invoiceNum , @RequestParam(value="supplierName") String supplierName) {
		return pharmacyMedicineService.searchPurchaseOrder(invoiceNum , supplierName);
	}
}
