package com.freelance.maslahat.action;

import com.freelance.maslahat.model.MenuModel;
import com.freelance.maslahat.service.RoleManagementService;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LandingPageAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	String roleId;
	
	private int sizeList;
	/**
	 * load data aplication first time
	 * @return
	 */
	public String landingPage(){
		roleId = String.valueOf(ActionContext.getContext().getSession().get("id_role"));
		System.out.println("roleId : "+roleId);
		int sessSize = ActionContext.getContext().getSession().size();
		System.out.println("session size = " + sessSize);
		if(sessSize <= 2 ){
			System.out.println("no login");
			ActionContext.getContext().getSession().clear();
			ActionContext.getContext().getSession().put("user", "guest");
			ActionContext.getContext().getSession().put("id_role", "2");
			//ActionContext.getContext().getSession().put("is_guest", "Y");
			roleId = "2";
			setRoleAccess(roleId);
		}
		return SUCCESS;
	}

	/**
	 * set role action for guest user
	 * @param idUserLevel
	 */
	protected void setRoleAccess(String idRole){
		Map<String, MenuModel> mapRoles = new RoleManagementService().roleMenuAccess(idRole);
		for (Map.Entry<String, MenuModel> entry : mapRoles.entrySet()) {
			if (entry.getValue().haveRead()) {
				String key = entry.getKey();
				MenuModel role = entry.getValue();
				ActionContext.getContext().getSession().put(key, role);
			}
			//System.out.println("session size di setRoleAccess : "+ActionContext.getContext().getSession().size());
		}
	}

	public int getSizeList() {
		return sizeList;
	}

	public void setSizeList(int sizeList) {
		this.sizeList = sizeList;
	}

}
