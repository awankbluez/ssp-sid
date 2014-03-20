package com.vaia.sspsid.entity;

import com.vaia.sspsid.somepackage.TableSPSBean;
import com.vaia.sspsid.somepackage.TableSPSBean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "StructSPS")
@SessionScoped
public class StructTableSPSBean {
	//Table Records Store
		    private String spsf1,spsf2,spsf3,spsf4,spsf5,spsf6,spsf7,spsf8;
		  
		    public String getSpsf1() {
		        return spsf1;
		    }

		    public void setSpsf1(String spsf1) {
		        this.spsf1 = spsf1;
		    }

		    public String getSpsf2() {
		        return spsf2;
		    }

		    public void setSpsf2(String spsf2) {
		        this.spsf2 = spsf2;
		    }
		    
		    public String getSpsf3() {
		        return spsf3;
		    }

		    public void setSpsf3(String spsf3) {
		        this.spsf3 = spsf3;
		    }
		    
		    public String getSpsf4() {
		        return spsf4;
		    }

		    public void setSpsf4(String spsf4) {
		        this.spsf4 = spsf4;
		    }
		    
		    public String getSpsf5() {
		        return spsf5;
		    }

		    public void setSpsf5(String spsf5) {
		        this.spsf5 = spsf5;
		    }
		    
		    public String getSpsf6() {
		        return spsf6;
		    }

		    public void setSpsf6(String spsf6) {
		        this.spsf6 = spsf6;
		    }
		    
		    public String getSpsf7() {
		        return spsf7;
		    }

		    public void setSpsf7(String spsf7) {
		        this.spsf7 = spsf7;
		    }
		    
		    public String getSpsf8() {
		        return spsf8;
		    }

		    public void setSpsf8(String spsf8) {
		        this.spsf8 = spsf8;
		    }
		    
		    public ArrayList<StructTableSPSBean> getMessages() {
		        return TableSPSBean.getSPS();
		    }
	
}
