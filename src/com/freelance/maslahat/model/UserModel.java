package com.freelance.maslahat.model;

public class UserModel {
	private String idUser;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String password;
	private String phoneNumber;
	private BankModel bank;
	private String branch;
	private String accountNumber;
	private String accountName;
	private String noKtp;
	private String imgKtp;
	private String noNpwp;
	private String imgNpwp;
	private RoleModel role;
	private String active;
	
	private String dateCreated;
	private String dateUpdated;
	
	public UserModel(){
		
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public BankModel getBank() {
		return bank;
	}

	public void setBank(BankModel bank) {
		this.bank = bank;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getNoKtp() {
		return noKtp;
	}

	public void setNoKtp(String noKtp) {
		this.noKtp = noKtp;
	}

	public String getImgKtp() {
		return imgKtp;
	}

	public void setImgKtp(String imgKtp) {
		this.imgKtp = imgKtp;
	}

	public String getNoNpwp() {
		return noNpwp;
	}

	public void setNoNpwp(String noNpwp) {
		this.noNpwp = noNpwp;
	}

	public String getImgNpwp() {
		return imgNpwp;
	}

	public void setImgNpwp(String imgNpwp) {
		this.imgNpwp = imgNpwp;
	}

	public RoleModel getRole() {
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
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
