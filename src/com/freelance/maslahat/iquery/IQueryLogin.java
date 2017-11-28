package com.freelance.maslahat.iquery;

public interface IQueryLogin {
	
	public final String QUERY_LOGIN = "SELECT * FROM vw_user where email = ? AND password = ?";

	public final String FIELD_USER_ID = "id";
	public final String FIELD_EMAIL = "email";
	public final String FIELD_ROLE_ID = "role_id";
	public final String FIELD_NAMA_ROLE = "nama_role";
	public final String FIELD_STATUS_USER = "active";
}
