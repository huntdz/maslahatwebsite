package com.freelance.maslahat.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 9121430372072509102L;
	private Map<String, Object> session;
	
	/**
	 * logout process
	 */
	public String execute(){
		session.remove("user");
		session.clear();
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
