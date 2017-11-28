package com.freelance.maslahat.action;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;



public class AuthenticationInterceptor implements Interceptor {


	private static final long serialVersionUID = 3209471287702024601L;

	@Override
	public void destroy() {}

	@Override
	public void init() {}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		
/*		System.out.println("session in interceptor = " + session.size());
		System.out.println("session user in interceptor = " + session.get("user"));*/
		if (session != null && session.get("user") != null && !session.get("user").equals("null")) {
			
			HttpServletResponse response = (HttpServletResponse)actionInvocation.getInvocationContext().get(StrutsStatics.HTTP_RESPONSE);
	        if(response!=null){
	            response.setHeader("Cache-control", "no-cache");
	            response.setHeader("Cache-Control","no-store");
	            response.setHeader("Pragme", "no-cache");
	            response.setHeader("Expires", "0");
	        }
			
			System.out.println("session not expired");
			return actionInvocation.invoke();
		}
		
		System.out.println("session expired");
		
		return ActionSupport.LOGIN;
	}

	

}
