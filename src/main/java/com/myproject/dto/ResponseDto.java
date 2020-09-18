/**
 * 
 */
package com.myproject.dto;

/**
 * @author Kamlesh.Choubey
 *
 */
public class ResponseDto {
	
	private String responseMessage;
	private String responseCode;
	private String status;
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	@Override
	public String toString() {
		return "ResponseDto [responseMessage=" + responseMessage + ", responseCode=" + responseCode + ", status="
				+ status + "]";
	}
	
	
}
