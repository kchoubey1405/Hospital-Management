/**
 * 
 */
package com.myproject.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import com.myproject.dao.*;
import com.myproject.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.service.PharmacyMedicineService;

/**
 * @author Kamlesh.Choubey
 *
 */
@Service
public class PharmacyMedicineServiceImpl implements PharmacyMedicineService {

	@Autowired
	PharmacyMedicineDao pharmacyMedicineDao;

	@Autowired
	SupplierDao supplierDao;

	@Autowired
	ItemCategoryDao itemCategoryDao;

	@Autowired
	ItemUnitDao itemUnitDao;

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
	public String deleteMedicineRecord(String medicineId) {
		return pharmacyMedicineDao.deleteMedicineRecord(medicineId);
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
		if (dto.getStatus()!= null && dto.getStatus().equalsIgnoreCase("delivered")) {
			List<PurchaseOrderDetailsDto> purchaseOrderDetailsDtoList = dto.getProductDetails();
			for (PurchaseOrderDetailsDto purchaseOrderDetailsDto : purchaseOrderDetailsDtoList) {
				PharmacyMedicineDto pharmacyMedicineDto = pharmacyMedicineDao.getMedicineDetails(purchaseOrderDetailsDto.getMedicineId());
				pharmacyMedicineDto.setStockQuantity(BigDecimal.valueOf(pharmacyMedicineDto.getStockQuantity().intValue() + purchaseOrderDetailsDto.getQuantity()));
				pharmacyMedicineDto.setAvailability("IN STOCK");
				pharmacyMedicineDao.saveOrUpdateMedicine(pharmacyMedicineDto);
			}
		}

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

	@Override
	public ResponseDto saveOrUpdateItemCategory(ItemCategoryDto dto) {
		 return itemCategoryDao.saveOrUpdate(dto);
	}
	@Override
	public List<ItemCategoryDto> getAllItemCategories() {
		return itemCategoryDao.getAllItemCategories();
	}

	@Override
	public ResponseDto saveOrUpdateItemUnit(ItemUnitDto dto) {
		return itemUnitDao.saveOrUpdate(dto);
	}

	@Override
	public List<ItemUnitDto> getAllItemUnits() {
		return itemUnitDao.getAllItemUnits();
	}

	@Override
	public List<PurchaseOrderDto> searchPurchaseOrder(String invoiceNum, String supplierName) {
		return purchaseOrderDao.searchPurchaseOrder(invoiceNum, supplierName);
	}

}
