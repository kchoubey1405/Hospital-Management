/**
 * 
 */
package com.myproject.serviceimpl;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.ItemCategoryDao;
import com.myproject.dao.ItemUnitDao;
import com.myproject.dao.PharmacyMedicineDao;
import com.myproject.dao.PurchaseOrderDao;
import com.myproject.dao.SupplierDao;
import com.myproject.dto.ItemCategoryDto;
import com.myproject.dto.ItemUnitDto;
import com.myproject.dto.PharmacyMedicineDto;
import com.myproject.dto.PurchaseOrderDetailsDto;
import com.myproject.dto.PurchaseOrderDto;
import com.myproject.dto.ResponseDto;
import com.myproject.dto.SupplierDto;
import com.myproject.service.PharmacyMedicineService;
import com.myproject.utill.ServicesUtil;

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
	public HashMap<String , Object> saveOrUpdatePharmacyMedicine(PharmacyMedicineDto dto) {
		HashMap<String , Object> response = new HashMap<>();
		String barcodeNumber = String.valueOf(ServicesUtil.generateRandom(13));
		HashMap<String , String> barcodeDetails = ServicesUtil.generateBarcodeInPng(barcodeNumber);
		response.put("BarcodeImage" , barcodeDetails.get("Barcode"));
		dto.setBarcode(barcodeDetails.get("FilePath"));
		dto.setBarcodeNum(barcodeNumber);
		int itemId =  pharmacyMedicineDao.saveOrUpdateMedicine(dto);
		response.put("ItemId" , itemId);
		response.put("ResponseMessage" , "success");
		response.put("BarcodeNumber", barcodeNumber);
		return response;
		
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
		try {
			PharmacyMedicineDto dto = pharmacyMedicineDao.getMedicineDetails(medicineId);
			String url = dto.getBarcode();
			String img = Base64.getEncoder().encodeToString(Files.readAllBytes(new File(url).toPath()));
			dto.setBarcode(img);
			return dto;
		}catch(Exception e){

		}
		return null;
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

	@Override
	public PharmacyMedicineDto getMedicineDetailsByBarcodeNumber(String barcodeNum) {
		try {
			PharmacyMedicineDto dto = pharmacyMedicineDao.getMedicineDetailsByBarcodeNumber(barcodeNum);
			String url = dto.getBarcode();
			String img = Base64.getEncoder().encodeToString(Files.readAllBytes(new File(url).toPath()));
			dto.setBarcode(img);
		}catch(Exception e){

		}
		return null;
	}

}
