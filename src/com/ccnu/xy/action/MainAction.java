package com.ccnu.xy.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class MainAction extends ActionSupport {
	public String getIndex() throws Exception {
		String classtype = ServletActionContext.getRequest().getParameter("classtype");
		
		if (classtype != null && classtype == "bc") {
			
		}
		else {
			
		}
		return SUCCESS;
	}
}
