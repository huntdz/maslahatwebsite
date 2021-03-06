package com.freelance.maslahat.action;


import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.freelance.maslahat.model.MenuModel;
import com.freelance.maslahat.model.ModelLogin;
import com.freelance.maslahat.service.LoginService;
import com.freelance.maslahat.service.RoleManagementService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	

	private static final long serialVersionUID = 3368256167399703150L;
	private String email;
	private String password;
	private Map<String, Object> session;

	@Override
	public String execute() throws ParseException{
		clearFieldErrors();	
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    
		int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH);
	    int day = cal.get(Calendar.DAY_OF_MONTH);
	    
		LoginService service = new LoginService();
		ModelLogin model = service.authenticate(email, password);		
	    System.out.println("status user= "+model.getStatusUser());
	    if(StringUtils.isEmpty(model.getStatusUser())){
	    	System.out.println("Invalid username or password");
	    	return SUCCESS;
	    }else{
	    	if(model.getStatusUser().equals("1")){
				session.clear();
				session.put("user", model.getNamaRole());
				session.put("id_role", String.valueOf(model.getRoleId()));
				session.put("user_id", model.getUserId());
				
				setRoleAccess(String.valueOf(model.getRoleId()));
				return SUCCESS;
			}else {
				System.out.println("user is inactive");
				addActionError("Invalid username or password");
				return SUCCESS;
			}
	    }
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	protected void setRoleAccess(String idRole){
		Map<String, MenuModel> mapRoles = new RoleManagementService().roleMenuAccess(idRole);
		for (Map.Entry<String, MenuModel> entry : mapRoles.entrySet()) {
			if (entry.getValue().haveRead()) {
				String key = entry.getKey();
				MenuModel role = entry.getValue();
				session.put(key, role);
			}
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
