package com.freelance.maslahat.service;

/*
import id.co.git.mandiri.model.MenuTabModel;
import id.co.git.mandiri.model.RoleModel;*/

import com.freelance.maslahat.db.DBService;
import com.freelance.maslahat.model.MenuModel;
import com.freelance.maslahat.iquery.IQueryRoleManagement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RoleManagementService extends DBService implements IQueryRoleManagement {

	/**
	 * insert data role menu into database
	 * @param listMenu
	 * @param idUserLevel
	 * @return
	 */
	/*public String doInsertRole(List<MenuModel> listMenu, String idUserLevel, String idNamaRole){
		System.out.println("RUNNING INSERT ROLE");
		String message = SUCCESS;
		openConnection();
		try {
			ps = connection.prepareStatement(QUERY_INSERT_ROLE);
			for (MenuModel menuModel : listMenu) {
				ps.setInt(1, Integer.parseInt(menuModel.getIdMenu()));
				ps.setInt(2, Integer.parseInt(idUserLevel));
				ps.setString(3, menuModel.toString());
				ps.setInt(4, Integer.parseInt(idNamaRole));
				ps.executeQuery();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			message = ERROR;
		} finally {
			closeConnetion();
		}
		return message;
	}*/
	
	/*public String doInsertTabRole(List<MenuTabModel> listTab, String idUserLevel, String idNamaRole){
		System.out.println("RUNNING INSERT TAB ROLE");
		String message = SUCCESS;
		openConnection();
		try {
			ps = connection.prepareStatement(QUERY_INSERT_ROLE_TAB);
			for (MenuTabModel model: listTab) {
				ps.setInt(1, Integer.parseInt(model.getIdMenu()));
				ps.setInt(2, Integer.parseInt(idUserLevel));
				ps.setInt(3, Integer.parseInt(model.getIdTabMenu()));
				ps.setString(4, model.toString());
				ps.setInt(5, Integer.parseInt(idNamaRole));
				ps.executeQuery();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			message = ERROR;
		} finally {
			closeConnetion();
		}
		
		return message;	
	}*/
	
	/**
	 * get all data role menu from database
	 * @param idUserLevel
	 * @return map MenuModel
	 */
	public Map<String, MenuModel> roleMenuAccess(String idNamaRole){
		Map<String, MenuModel> roleAccess = new  LinkedHashMap<String, MenuModel>();
		
		openConnection();
		try {
			
			/*ps = connection.prepareStatement(QUERY_CEK_MYSQL);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("id_menu : "+rs.getInt("id_menu"));
			}*/
			
			ps = connection.prepareStatement(QUERY_GET_ROLE_ACCESS);
			/*ps.setString(1, "BY_ID_NAMA_ROLE");
			ps.setInt(2, Integer.parseInt(idNamaRole));*/
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				//System.out.println("id = "+rs.getString(FIELD_ID_MENU)+", nama menu = "+rs.getString(FIELD_NAMA_MENU)+", role action = "+rs.getString(FIELD_ROLE_ACTION));
				String menuKey 	= rs.getString(FIELD_ID_MENU);
				String menuName = rs.getString(FIELD_NAMA_MENU);
				String actionName = rs.getString(FIELD_ROLE_ACTION);
				MenuModel role = new MenuModel(menuKey,menuName,actionName);
				if(!roleAccess.containsKey(menuKey))
					roleAccess.put(menuKey, role);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnetion();
		}
		return roleAccess;
	}
	
	/**
	 * get all data role user level from database
	 * @return list user level
	 */
	/*public List<RoleModel> listRoleUser(String type, String filter){
		List<RoleModel> list = new ArrayList<RoleModel>();
		openConnection();
		
		try {
			ps = connection.prepareStatement(QUERY_GET_LIST_USER_ROLE);
			ps.setString(1, type);
			ps.setString(2, filter);
			rs = ps.executeQuery();
			while (rs.next()) {
				RoleModel model = new RoleModel();
				model.setIdNamaRole(rs.getString(FIELD_ID_NAMA_ROLE));
				model.setNamaRole(rs.getString(FIELD_NAMA_ROLE));
				list.add(model);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnetion();
		}
		
		return list;
	}*/
	
	/**
	 * get list role access menu from database
	 * @param idUserLevel
	 * @return list role menu
	 */
	public List<MenuModel> listRoleMenu(String idNamaRole){
		Map<String, MenuModel> map = roleMenuAccess(idNamaRole);
		List<MenuModel> list = new ArrayList<MenuModel>(map.values());
		return list;
	}
	
	public String doCheckDuplicateRole(String namaRole){
		String message = "";
		openConnection();
		try {
			ps = connection.prepareStatement(QUERY_CHECK_DUPLICATE_ROLE);
			ps.setString(1, namaRole);
			rs = ps.executeQuery();
			while (rs.next()) {
				message = rs.getString(FIELD_MESSAGE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnetion();
		}
		return message;
	}
	
	/**
	 * update data role access menu into database
	 * @param listRole
	 * @param idUserLevel
	 * @return
	 */
	public String doUpdateRoleAccess(List<MenuModel> listRole, String idUserLevel, String idNamaRole) {
		System.out.println("RUNNING UPDATE ROLE");
		String message = "";
		openConnection();
		try {
			ps = connection.prepareStatement(QUERY_UPDATE_ROLE_ACCESS);
			for (MenuModel menuModel : listRole) {
				ps.setInt(1, Integer.parseInt(menuModel.getIdMenu()));
				ps.setInt(2, Integer.parseInt(idUserLevel));
				ps.setString(3, menuModel.toString());
				ps.setInt(4, Integer.parseInt(idNamaRole));
				ps.executeQuery();
			}
			message = SUCCESS;
		} catch (SQLException e) {
			message = ERROR;
			e.printStackTrace();
		} finally {
			closeConnetion();
		}
		
		return message;
	}
	
	
	public String doUpdateRoleName(String idNamaRole, String namaRole) {
		System.out.println("RUNNING UPDATE ROLE NAME");
		String message = "";
		
		System.out.println("nama role untuk update = " + namaRole);
		System.out.println("id nama role untuk update = " + idNamaRole);
		openConnection();
		try {
			ps = connection.prepareStatement(QUERY_UPDATE_ROLE_NAME);
			ps.setInt(1, Integer.parseInt(idNamaRole));
			ps.setString(2, namaRole);
			ps.execute();
			message = SUCCESS;
		} catch (SQLException e) {
			message = ERROR;
			e.printStackTrace();
		} finally {
			closeConnetion();
		}
		
		return message;
	}
	
	
	/**
	 * update data role access menu into database
	 * @param listRole
	 * @param idUserLevel
	 * @return
	 */
	/*public String doUpdateRoleTabccess(List<MenuTabModel> listRole, String idUserLevel, String idNamaRole) {
		System.out.println("RUNNING UPDATE ROLE");
		String message = "";
		openConnection();
		try {
			ps = connection.prepareStatement(QUERY_UPDATE_ROLE_TAB_ACCESS);
			for (MenuTabModel model : listRole) {
				ps.setInt(1, Integer.parseInt(model.getIdTabMenu()));
				ps.setInt(2, Integer.parseInt(idUserLevel));
				ps.setString(3, model.toString());
				ps.setInt(4, Integer.parseInt(idNamaRole));
				ps.executeQuery();
			}
			message = SUCCESS;
		} catch (SQLException e) {
			message = ERROR;
			e.printStackTrace();
		} finally {
			closeConnetion();
		}
		
		return message;
	}*/
	
	public String doCheckUserRole(String idUserLevel){
		String message = "";
		openConnection();
		try {
			ps = connection.prepareStatement(QUERY_CHECK_USER_ROLE);
			ps.setInt(1, Integer.parseInt(idUserLevel));
			rs = ps.executeQuery();
			System.out.println("ps"+ps);
			while (rs.next()) {
				message = rs.getString(FIELD_MESSAGE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnetion();
		}
		return message;
	}

	public String doDeleteRole(String idUserLevel){
		System.out.println("RUNNING DELETE ROLE");
		String message = "";
		boolean isSuccess = false;
		openConnection();
		try {
			ps = connection.prepareStatement(QUERY_DELETE_ROLE);
			ps.setInt(1, Integer.parseInt(idUserLevel));
			rs = ps.executeQuery();
			System.out.println(ps);
			while (rs.next()) {
				isSuccess = rs.getBoolean(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnetion();
		}
		
		if(isSuccess != true){
			message = ERROR;
		}else {
			message = SUCCESS;
		}
		
		return message;
	}

	/**
	 * get all data role menu from database
	 * @param idUserLevel
	 * @return map MenuModel
	 */
	/*public Map<String, MenuTabModel> roleTabMenuAccess(String idNamaRole){
		Map<String, MenuTabModel> roleAccess = new  LinkedHashMap<String, MenuTabModel>();
		
		openConnection();
		try {
			
			ps = connection.prepareStatement(QUERY_GET_ROLE_TAB_ACCESS);
			ps.setString(1, "BY_ID_NAMA_ROLE");
			ps.setInt(2, Integer.parseInt(idNamaRole));
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String tabKey 	= rs.getString(FIELD_ID_TAB_MENU);
				String tabName = rs.getString(FIELD_NAMA_TAB_MENU);
				String actionName = rs.getString(FIELD_ROLE_ACTION);
				String keyMenu = rs.getString(FIELD_ID_SUB_MENU);
				String namaMenu = rs.getString(FIELD_NAMA_SUB_MENU);
				String val = "00";
				MenuTabModel role = new MenuTabModel(tabKey,tabName,actionName,keyMenu,namaMenu);
				if(!roleAccess.containsKey(val+tabKey))
					roleAccess.put(val+tabKey, role);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnetion();
		}
		return roleAccess;
	}*/
	
	/**
	 * get list role access menu from database
	 * @param idUserLevel
	 * @return list role menu
	 */
	/*public List<MenuTabModel> listRoleTabMenu(String idNamaRole){
		Map<String, MenuTabModel> map = roleTabMenuAccess(idNamaRole);
//		System.out.println("isi list tab menu model = " + map.values());
		List<MenuTabModel> list = new ArrayList<MenuTabModel>(map.values());
		return list;
	}*/
	
	public String insertNamaRole(String namaRole){
		String message = "";
		openConnection();
		try {
			
			ps = connection.prepareStatement(QUERY_INSERT_NAMA_ROLE);
			ps.setString(1, namaRole);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				message = rs.getString("id");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnetion();
		}
		
		System.out.println("id nama role = " + message);
		return message;
	}
	
	public String getUserLevelEditState (String idNama){
		String result = "";
		openConnection();
		
		try {
			ps = connection.prepareStatement(QUERY_GET_LEVEL_USER_EDIT);
			ps.setInt(1, Integer.parseInt(idNama));
			rs = ps.executeQuery();
			
			while (rs.next()) {
				result = rs.getString(FIELD_ID_USER_LEVEL);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnetion();
		}
		
		return result;
	}
	
}
