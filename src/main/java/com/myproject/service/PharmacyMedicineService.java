/**
 * 
 */
package com.myproject.service;

import java.util.List;

import com.myproject.dto.*;

/**
 * @author Kamlesh.Choubey
 *
 */
public interface PharmacyMedicineService {
	//Pharmacy medicines CRUD
	public PharmacyMedicineDto getMedicineDetails(Integer medicineId);
	public List<PharmacyMedicineDto> getMedicineList();
	public String saveOrUpdatePharmacyMedicine(PharmacyMedicineDto dto);
	public List<SupplierDto> getSupplierList();
	public String saveOrUpdateSupplier(SupplierDto dto);
	public String deleteMedicineRecord(String medicineId);
	
	public List<PharmacyMedicineDto> getMedicineListByName(String medicineName);
	
	//Purchase order CRUD
	public String saveOrUpdatePurchaseOrder(PurchaseOrderDto dto);
	public ResponseDto saveOrUpdateItemCategory(ItemCategoryDto dto);
	public ResponseDto saveOrUpdateItemUnit(ItemUnitDto dto);
	public List<ItemCategoryDto> getAllItemCategories();
	public List<ItemUnitDto> getAllItemUnits();
	public String deletePurchaseOrder(PurchaseOrderDto dto);
	public PurchaseOrderDto getPurchaseOrderDetails(Integer purchaseOrderId);
	public List<PurchaseOrderDto> getPurchaseOrderList();
	public List<PurchaseOrderDto> searchPurchaseOrder(String invoiceNum, String supplierName);
}
