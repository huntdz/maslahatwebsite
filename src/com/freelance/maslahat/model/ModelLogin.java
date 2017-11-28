package com.freelance.maslahat.model;

public class ModelLogin {
	
	private int userId;
	private String email;
	private int roleId;
	private String namaRole;
	
	private String statusUser;
	private String expired_date;
	private int suspendStatus;
	
	public String getExpired_date() {
		return expired_date;
	}
	public void setExpired_date(String expired_date) {
		this.expired_date = expired_date;
	}
	public int getSuspendStatus() {
		return suspendStatus;
	}
	public void setSuspendStatus(int suspendStatus) {
		this.suspendStatus = suspendStatus;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getNamaRole() {
		return namaRole;
	}
	public void setNamaRole(String namaRole) {
		this.namaRole = namaRole;
	}
	public String getStatusUser() {
		return statusUser;
	}
	public void setStatusUser(String statusUser) {
		this.statusUser = statusUser;
	}
}
