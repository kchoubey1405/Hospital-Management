/**
 * 
 */
package com.myproject.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.myproject.persistent.util.BaseDo;

/**
 * @author Kamlesh.Choubey
 *
 */

@Entity
@Table(name="BILLINGS")
public class BillDo implements BaseDo{

	@Id
	@Column(name="BILL_ID" , length = 100)
	private String billId;
	@Column(name="TYPE" , length = 30)
	private String type;
	@Column(name="STATUS" , length = 30)
	private String status;
	@Column(name="CREATED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	@Column(name="PATIENT_ID" , length = 100)
	private String patientId;
	
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
