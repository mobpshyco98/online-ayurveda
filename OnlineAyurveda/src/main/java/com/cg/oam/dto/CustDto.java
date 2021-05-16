package com.cg.oam.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustDto {

	public Integer custId;
	
	@NotBlank(message = "Customer name must not be blank")
	@Pattern(regexp = "([a-zA-Z]+)|([a-zA-Z]+[\\s][a-zA-Z]+)", message = "Name must contain alphabets")
	public String custName;
	private String contactNo;
	private String address;
	private String location;
	
	public CustDto(Integer custId, String custName, String contactNo, String address, String location) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.contactNo = contactNo;
		this.address = address;
		this.location = location;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
