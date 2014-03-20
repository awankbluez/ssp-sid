package com.vaia.sspsid.entity;

import com.vaia.sspsid.dao.TableRKEDBean;
import com.vaia.sspsid.dao.TableRKEDBean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "StructRKED")
@SessionScoped
public class StructTableRKEDBean {
	//Table Records Store
		    private String rkedf1,rkedf2;
		  
		    public String getRkedf1() {
		        return rkedf1;
		    }

		    public void setRkedf1(String rkedf1) {
		        this.rkedf1 = rkedf1;
		    }

		    public String getRkedf2() {
		        return rkedf2;
		    }

		    public void setRkedf2(String rkedf2) {
		        this.rkedf2 = rkedf2;
		    }
		    
		    public ArrayList<StructTableRKEDBean> getMessagesRKED() {
		        return TableRKEDBean.getRKED();
		    }
	
}
