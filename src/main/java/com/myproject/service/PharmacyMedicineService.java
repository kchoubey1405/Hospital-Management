/**
 * 
 */
package com.myproject.service;

import java.util.List;

import com.myproject.dto.PharmacyMedicineDto;
import com.myproject.dto.PurchaseOrderDto;
import com.myproject.dto.SupplierDto;

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
	public String deleteMedicineRecord(PharmacyMedicineDto dto);
	
	public List<PharmacyMedicineDto> getMedicineListByName(String medicineName);
	
	//Purchase order CRUD
	public String saveOrUpdatePurchaseOrder(PurchaseOrderDto dto);
	public String deletePurchaseOrder(PurchaseOrderDto dto);
	public PurchaseOrderDto getPurchaseOrderDetails(Integer purchaseOrderId);
	public List<PurchaseOrderDto> getPurchaseOrderList();
}
