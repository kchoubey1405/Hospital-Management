/**
 * 
 */
package com.myproject.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.myproject.persistent.util.BaseDto;

/**
 * @author Kamlesh.Choubey
 *
 */
public class PrescribedTestingDto extends BaseDto {
	private String testId;
	private String appointmentId;
	private Date dateOfBooking;
	private Date dateOfResult;
	private String reportDesc;
	private BigDecimal cost;
	private String testDesc;
	private String billId;
	private String comment;
	private String testName;
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Date getDateOfBooking() {
		return dateOfBooking;
	}
	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}
	public Date getDateOfResult() {
		return dateOfResult;
	}
	public void setDateOfResult(Date dateOfResult) {
		this.dateOfResult = dateOfResult;
	}
	public String getReportDesc() {
		return reportDesc;
	}
	public void setReportDesc(String reportDesc) {
		this.reportDesc = reportDesc;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public String getTestDesc() {
		return testDesc;
	}
	public void setTestDesc(String testDesc) {
		this.testDesc = testDesc;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	@Override
	public Boolean getValidForUsage() {
		// TODO Auto-generated method stub
		return null;
	}
		
}
