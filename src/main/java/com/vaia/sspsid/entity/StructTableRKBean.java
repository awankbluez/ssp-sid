package com.vaia.sspsid.entity;

import com.vaia.sspsid.dao.TableRKBean;
import com.vaia.sspsid.dao.TableRKBean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "StructRK")
@SessionScoped
public class StructTableRKBean {
	//Table Records Store
		    private String rkf1,rkf2,rkf3,rkf4,rkf5;
		  
		    public String getRkf1() {
		        return rkf1;
		    }

		    public void setRkf1(String rkf1) {
		        this.rkf1 = rkf1;
		    }

		    public String getRkf2() {
		        return rkf2;
		    }

		    public void setRkf2(String rkf2) {
		        this.rkf2 = rkf2;
		    }
		    
		    public String getRkf3() {
		        return rkf3;
		    }

		    public void setRkf3(String rkf3) {
		        this.rkf3 = rkf3;
		    }
		    
		    public String getRkf4() {
		        return rkf4;
		    }

		    public void setRkf4(String rkf4) {
		        this.rkf4 = rkf4;
		    }
		    
		    public String getRkf5() {
		        return rkf5;
		    }

		    public void setRkf5(String rkf5) {
		        this.rkf5 = rkf5;
		    }
		    
		    public ArrayList<StructTableRKBean> getMessagesRK() {
		        return TableRKBean.getRK();
		    }
	
}
