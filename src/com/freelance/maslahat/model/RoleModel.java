package com.freelance.maslahat.model;

public class RoleModel {
	private String idRole;
	private String namaRole;
	private String roleDesc;
	private String dateCreated;
	private String dateUpdated;
	
	public RoleModel(){
		
	}

	public String getIdRole() {
		return idRole;
	}

	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}

	public String getNamaRole() {
		return namaRole;
	}

	public void setNamaRole(String namaRole) {
		this.namaRole = namaRole;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
}
