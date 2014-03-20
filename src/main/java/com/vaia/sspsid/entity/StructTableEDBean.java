package com.vaia.sspsid.entity;

import com.vaia.sspsid.somepackage.TableEDBean;
import com.vaia.sspsid.somepackage.TableEDBean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "StructED")
@SessionScoped
public class StructTableEDBean {
	//Table Records Store
		    private String edf1,edf2,edf3,edf4;
		  
		    public String getEdf1() {
		        return edf1;
		    }

		    public void setEdf1(String edf1) {
		        this.edf1 = edf1;
		    }

		    public String getEdf2() {
		        return edf2;
		    }

		    public void setEdf2(String edf2) {
		        this.edf2 = edf2;
		    }
		    
		    public String getEdf3() {
		        return edf3;
		    }

		    public void setEdf3(String edf3) {
		        this.edf3 = edf3;
		    }
		    
		    public String getEdf4() {
		        return edf4;
		    }

		    public void setEdf4(String edf4) {
		        this.edf4 = edf4;
		    }
		    		    
		    public ArrayList<StructTableEDBean> getMessagesED() {
		        return TableEDBean.getED();
		    }
	
}
