/**
 * 
 */
package com.myproject.serviceimpl;

import java.util.List;

import com.myproject.dao.SupplierDao;
import com.myproject.dto.SupplierDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.PharmacyMedicineDao;
import com.myproject.dao.PurchaseOrderDao;
import com.myproject.dto.PharmacyMedicineDto;
import com.myproject.dto.PurchaseOrderDto;
import com.myproject.service.PharmacyMedicineService;

/**
 * @author Kamlesh.Choubey
 *
 */
@Service
public class PharmacyMedicineServiceImpl implements PharmacyMedicineService{

	@Autowired
	PharmacyMedicineDao pharmacyMedicineDao;

	@Autowired
	SupplierDao supplierDao;

	@Autowired
	PurchaseOrderDao purchaseOrderDao;

	@Override
	public String saveOrUpdatePharmacyMedicine(PharmacyMedicineDto dto) {
		return pharmacyMedicineDao.saveOrUpdateMedicine(dto);
	}

	@Override
	public String saveOrUpdateSupplier(SupplierDto dto) {
		return supplierDao.saveorUpdateSupplier(dto);
	}

	@Override
	public List<SupplierDto> getSupplierList() {
		return supplierDao.getSupplierList();
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

	@Override
	public String saveOrUpdatePurchaseOrder(PurchaseOrderDto dto) {
		return purchaseOrderDao.saveOrUpdatePurchaseOrder(dto);
	}

	@Override
	public String deletePurchaseOrder(PurchaseOrderDto dto) {
		return purchaseOrderDao.deletePurchaseOrder(dto);
	}

	@Override
	public PurchaseOrderDto getPurchaseOrderDetails(Integer purchaseOrderId) {
		return purchaseOrderDao.getPurchaseOrderDetails(purchaseOrderId);
	}

	@Override
	public List<PurchaseOrderDto> getPurchaseOrderList() {
		return purchaseOrderDao.getPurchaseOrderList();
	}

	@Override
	public List<PharmacyMedicineDto> getMedicineListByName(String medicineName) {
		return pharmacyMedicineDao.getMedicineListByName(medicineName);
	}

}
