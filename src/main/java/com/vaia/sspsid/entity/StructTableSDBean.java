package com.vaia.sspsid.entity;

import com.vaia.sspsid.somepackage.TableSDBean;
import com.vaia.sspsid.somepackage.TableSDBean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "StructSD")
@SessionScoped
public class StructTableSDBean {
	//Table Records Store
		    private String f1,f2,f3;
		  
		    public String getF1() {
		        return f1;
		    }

		    public void setF1(String f1) {
		        this.f1 = f1;
		    }

		    public String getF2() {
		        return f2;
		    }

		    public void setF2(String f2) {
		        this.f2 = f2;
		    }
		    
		    public String getF3() {
		        return f3;
		    }

		    public void setF3(String f3) {
		        this.f3 = f3;
		    }
		    
		    public ArrayList<StructTableSDBean> getMessages() {
		        return TableSDBean.getSD();
		    }
	
}
