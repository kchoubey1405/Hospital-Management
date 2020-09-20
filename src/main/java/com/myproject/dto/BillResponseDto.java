/**
 * 
 */
package com.myproject.dto;

import java.util.List;

/**
 * @author Kamlesh.Choubey
 *
 */
public class BillResponseDto {
	private BillDto billDto;
	private List<PrescribedMedsDto> medicineList;
	private List<PrescribedTestingDto> testList;
	public BillDto getBillDto() {
		return billDto;
	}
	public void setBillDto(BillDto billDto) {
		this.billDto = billDto;
	}
	public List<PrescribedMedsDto> getMedicineList() {
		return medicineList;
	}
	public void setMedicineList(List<PrescribedMedsDto> medicineList) {
		this.medicineList = medicineList;
	}
	public List<PrescribedTestingDto> getTestList() {
		return testList;
	}
	public void setTestList(List<PrescribedTestingDto> testList) {
		this.testList = testList;
	}
	

}
