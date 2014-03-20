package com.vaia.sspsid.entity;

import com.vaia.sspsid.somepackage.TableRDTBean;
import com.vaia.sspsid.somepackage.TableRDTBean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "StructRDT")
@SessionScoped
public class StructTableRDTBean {
	//Table Records Store
		    private String rdtf1,rdtf2,rdtf3;
		  
		    public String getRdtf1() {
		        return rdtf1;
		    }

		    public void setRdtf1(String rdtf1) {
		        this.rdtf1 = rdtf1;
		    }

		    public String getRdtf2() {
		        return rdtf2;
		    }

		    public void setRdtf2(String rdtf2) {
		        this.rdtf2 = rdtf2;
		    }
		    
		    public String getRdtf3() {
		        return rdtf3;
		    }

		    public void setRdtf3(String rdtf3) {
		        this.rdtf3 = rdtf3;
		    }
		    
		    public ArrayList<StructTableRDTBean> getMessagesRDT() {
		        return TableRDTBean.getRDT();
		    }
	
}
