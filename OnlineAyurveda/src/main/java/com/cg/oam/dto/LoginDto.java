package com.cg.oam.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cg.oam.util.LoginConstants;

public class LoginDto {

	@NotNull(message= LoginConstants.USERID_NOTNULL_MESSAGE)
	private Integer customerId;
	
	@NotBlank(message = LoginConstants.PASSWORD_REQUIRED_MESSAGE )
	private String password;
	
	private String role;

	public LoginDto() {
		super();
	}
	

	public LoginDto(@NotNull(message = "User Id Cannot be null") Integer customerId,
			@NotBlank(message = "password required") String password, String role) {
		super();
		this.customerId = customerId;
		this.password = password;
		this.role = role;
	}


	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
}
