/**
 * 
 */
package com.myproject.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.myproject.persistent.util.BaseDo;

/**
 * @author Kamlesh.Choubey
 *
 */

@Entity
@Table(name="PRESC_TESTINGS_DESC")
public class PrescribedTestingDo implements BaseDo {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "PRESC_TEST_ID", length = 100)
	private String testId;	
	@Column(name = "TEST_NAME")
	private String testName;
	@Column(name = "APPOINTMENT_ID", length = 100)
	private String appointmentId;
	@Column(name = "DATE_OF_BOOKING")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfBooking;
	@Column(name = "DATE_OF_RESULT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfResult;
	@Column(name = "REPORT_DESC", length = 250)
	private String reportDesc;
	@Column(name = "COST")
	private BigDecimal cost;
	@Column(name = "TEST_DESC", length = 250)
	private String testDesc;
	@Column(name = "COMMENT", length = 250)
	private String comment;
	@Column(name = "BILL_ID", length = 100)
	private String billId;
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
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}
		


}
