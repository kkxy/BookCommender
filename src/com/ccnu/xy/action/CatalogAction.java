package com.ccnu.xy.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.xy.dao.DictDao;
import com.ccnu.xy.model.Dict;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CatalogAction extends ActionSupport {
	public String getCatalog() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		
		String classtype = (String)act.getSession().get("classtype");
		String typeid = (String)act.getSession().get("typeid");

		List<Dict> aClass = new ArrayList<>();
		List<Dict> bClass = new ArrayList<>();
		ArrayList<Integer> count = new ArrayList<>();
		
		DictDao dd = new DictDao();
		
		if (classtype != null && typeid != null && !classtype.equals("a")) {
			String nexttype = "", lasttype = "";
			if (classtype.equals("b")) {
				lasttype = "a";
				nexttype = "c";
			}
			else if (classtype.equals("c")) {
				lasttype = "b";
				nexttype = "d";
			}
			
			int last = 0;
			count.add(last);
			aClass.add(dd.getByItemId(session, new Integer(typeid)));
			for (int i = 0; i < aClass.size(); i++) {
				Dict d = aClass.get(i);
				List<Dict> res = dd.getByTypeId(session, d.getItemid());
				bClass.addAll(res);
				last += res.size();
				count.add(last);
			}
			
			act.put("nowtype", classtype);
			act.put("lasttype", lasttype);
			act.put("nexttype", nexttype);
			act.put("bigclass", aClass);
			act.put("smallclass", bClass);
			act.put("count", count);
			
		}
		else {
//			首页导航 1
			aClass = dd.getByTypeId(session, 1);
			int last = 0;
			count.add(last);
			for (int i = 0; i < aClass.size(); i++) {
				Dict d = aClass.get(i);
				List<Dict> res = dd.getByTypeId(session, d.getItemid());
				bClass.addAll(res);
				last += res.size();
				count.add(last);
			}
			
			act.put("nowtype", "a");
			act.put("nexttype", "b");
			act.put("bigclass", aClass);
			act.put("smallclass", bClass);
			act.put("count", count);
		}
		
		session.close();
		sf.close();
		return SUCCESS;
	}
}
