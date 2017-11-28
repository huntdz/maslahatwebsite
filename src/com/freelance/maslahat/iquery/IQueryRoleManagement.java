package com.freelance.maslahat.iquery;

public interface IQueryRoleManagement {

	public String QUERY_INSERT_ROLE = "SELECT wmg.fn_insert_role(?,?,?,?)";
	//public String QUERY_GET_ROLE_ACCESS = "SELECT * FROM wmg.fn_role_akses_get(?,?)";
//	public String QUERY_GET_LIST_USER_ROLE = "select distinct(id_user_level), description_user_level from wmg.vw_role_menu";
	public String QUERY_GET_LIST_USER_ROLE = "SELECT * FROM wmg.fn_get_role_name(?,?)";
	public String QUERY_UPDATE_ROLE_ACCESS = "select wmg.fn_update_role(?,?,?,?)";
	public String QUERY_UPDATE_ROLE_NAME = "select wmg.fn_update_role_name(?,?)";
//	public String QUERY_CHECK_DUPLICATE_ROLE = "SELECT * from wmg.fn_check_role_menu(?)";
	public String QUERY_CHECK_DUPLICATE_ROLE = "SELECT * from wmg.fn_check_duplicate_role(?)";
	public String QUERY_CHECK_USER_ROLE = "SELECT * from wmg.fn_check_user_role(?)";
	public String QUERY_DELETE_ROLE = "SELECT wmg.fn_delete_role(?)";
	
	public String QUERY_INSERT_ROLE_TAB = "SELECT wmg.fn_insert_role_tab(?,?,?,?,?)";
	public String QUERY_GET_ROLE_TAB_ACCESS = "SELECT * FROM wmg.fn_role_tab_akses_get(?,?)";
	public String QUERY_UPDATE_ROLE_TAB_ACCESS = "select wmg.fn_update_role_tab(?,?,?,?)";
	public String QUERY_INSERT_NAMA_ROLE = "INSERT INTO wmg.t_nama_role_ref(nama_role)VALUES (?)returning id;";
	public String QUERY_GET_LEVEL_USER_EDIT = "SELECT distinct(id_user_level) FROM wmg.vw_role_menu where id_nama_role = ?";
	
	public String FIELD_ID_ROLE = "id_role";
	//public String FIELD_ID_MENU = "id_menu";
	//public String FIELD_NAMA_MENU = "nama_menu";
	public String FIELD_NAMA_MENU_UTAMA = "nama_menu_utama";
	/*public String FIELD_ROLE_ACTION = "role_action";*/
	public String FIELD_ID_USER_LEVEL = "id_user_level";
	public String FIELD_NAMA_LEVEL = "description_user_level";
	public String DUPLICATE_DATA = "01";
	public String USER_FOUND = "01";
	public String FIELD_MESSAGE = "message";
	
	public String FIELD_ID_TAB_ROLE = "id_tab_role";
	public String FIELD_ID_TAB_MENU = "id_tab_menu";
	public String FIELD_ID_SUB_MENU = "id_sub_menu";
	public String FIELD_NAMA_TAB_MENU = "nama_tab";
	public String FIELD_NAMA_SUB_MENU = "nama_sub_menu";
	public String FIELD_TAB_ACTION = "role_action";

	public String FIELD_ID_NAMA_ROLE = "id_nama_role";
	//public String FIELD_NAMA_ROLE = "nama_role";
	
	public String QUERY_CEK_MYSQL = "SELECT * FROM menu_tm";
	public String QUERY_GET_ROLE_ACCESS = "SELECT * FROM vw_role_menu";
	
	public String FIELD_ID_ROLE_REF = "id_role_ref";
	public String FIELD_ROLE_ACTION = "role_action";
	public String FIELD_ID_MENU = "id_menu";
	public String FIELD_NAMA_MENU = "nama_menu";
	public String FIELD_NAMA_ROLE = "nama_role";
	public String FIELD_ROLE_DESC = "role_desc";
	
}

