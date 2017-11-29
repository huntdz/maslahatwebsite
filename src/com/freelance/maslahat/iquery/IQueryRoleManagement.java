package com.freelance.maslahat.iquery;

public interface IQueryRoleManagement {

	public String QUERY_CEK_MYSQL = "SELECT * FROM menu_tm";
	public String QUERY_GET_ROLE_ACCESS = "SELECT * FROM vw_role_menu";
	
	public String FIELD_ID_ROLE_REF = "id_role_ref";
	public String FIELD_ROLE_ACTION = "role_action";
	public String FIELD_ID_MENU = "id_menu";
	public String FIELD_NAMA_MENU = "nama_menu";
	public String FIELD_NAMA_ROLE = "nama_role";
	public String FIELD_ROLE_DESC = "role_desc";
	
}

