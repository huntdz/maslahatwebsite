package com.freelance.maslahat.action;

import java.sql.SQLException;

import com.freelance.maslahat.db.DBService;
import com.freelance.maslahat.iquery.IQueryRoleManagement;
import com.freelance.maslahat.service.RoleManagementService;
import com.freelance.maslahat.util.Md5;

public class VoidMain extends DBService implements IQueryRoleManagement {
	
	public static void main(String[] args){
		VoidMain main = new VoidMain();
		main.coba();
	}
	
	/*public static void main(String[] args){
		String hasil = Md5.hash("Maslahat1");
		System.out.println("Hash = " + hasil);
	}*/
	
	public void coba(){
		openConnection();
		try {
			
			ps = connection.prepareStatement(QUERY_CEK_MYSQL);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("id_menu : "+rs.getInt("id_menu"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnetion();
		}
	}

}
