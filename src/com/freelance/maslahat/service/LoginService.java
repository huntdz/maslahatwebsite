package com.freelance.maslahat.service;

import com.freelance.maslahat.db.DBService;
import com.freelance.maslahat.iquery.IQueryLogin;
import com.freelance.maslahat.model.ModelLogin;
import com.freelance.maslahat.util.Md5;

import java.sql.SQLException;

import org.apache.log4j.Logger;

public class LoginService extends DBService implements IQueryLogin{
	
	private static final Logger LOG = Logger.getLogger(LoginService.class);
	
	public ModelLogin authenticate(String email, String password) {
		ModelLogin model = new ModelLogin(); 
		
		openConnection();
		try {			
			ps = connection.prepareStatement(QUERY_LOGIN);
			ps.setString(1, email);
			ps.setString(2, Md5.hash(password));
			rs = ps.executeQuery();
			System.out.println("ps Login= "+ps);
			while (rs.next()) {
				model.setUserId(rs.getInt(FIELD_USER_ID));
				model.setEmail(rs.getString(FIELD_EMAIL));
				model.setRoleId(rs.getInt(FIELD_ROLE_ID));
				model.setNamaRole(rs.getString(FIELD_NAMA_ROLE));
				model.setStatusUser(rs.getString(FIELD_STATUS_USER));
			}
		} catch (SQLException e) {
			LOG.error(e);
			e.printStackTrace();
		} finally {
			closeConnetion();
		}
		
		return model;
	}
	
}
