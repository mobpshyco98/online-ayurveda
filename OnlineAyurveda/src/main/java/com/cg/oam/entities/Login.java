package com.cg.oam.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * Created By Titas Sarkar
 */
@Entity
@Table(name = "cg_login")
public class Login {

	@Id
	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "login_password", length = 25)
	private String password;

	@Column(name = "login_role", length = 25)
	private String role;

	@Column(name = "user_name", length = 30)
	private String userName;

	public Login(Integer customerId, String password, String role, String userName) {
		super();
		this.customerId = customerId;
		this.password = password;
		this.role = role;
		this.userName = userName;
	}

	public Login() {
		super();
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
