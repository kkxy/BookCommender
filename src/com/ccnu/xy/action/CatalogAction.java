package com.ccnu.xy.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CatalogAction extends ActionSupport {
	public String getCatalog() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		
		
		session.close();
		sf.close();
		return SUCCESS;
	}
}
