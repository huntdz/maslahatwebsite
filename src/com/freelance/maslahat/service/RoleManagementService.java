package com.freelance.maslahat.service;

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
	 * get all data role menu from database
	 * @param idUserLevel
	 * @return map MenuModel
	 */
	public Map<String, MenuModel> roleMenuAccess(String idNamaRole){
		Map<String, MenuModel> roleAccess = new  LinkedHashMap<String, MenuModel>();
		
		openConnection();
		try {
			ps = connection.prepareStatement(QUERY_GET_ROLE_ACCESS);
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
	 * get list role access menu from database
	 * @param idUserLevel
	 * @return list role menu
	 */
	public List<MenuModel> listRoleMenu(String idNamaRole){
		Map<String, MenuModel> map = roleMenuAccess(idNamaRole);
		List<MenuModel> list = new ArrayList<MenuModel>(map.values());
		return list;
	}
	
}
