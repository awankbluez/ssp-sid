package com.vaia.sspsid.entity;

import com.vaia.sspsid.somepackage.TableRKVBean;
import com.vaia.sspsid.somepackage.TableRKVBean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "StructRKV")
@SessionScoped
public class StructTableRKVBean {
	//Table Records Store
		    private String rkvf1,rkvf2,rkvf3,rkvf4,rkvf5,rkvf6,rkvf7,rkvf8,rkvf9,rkvf10,rkvf11;
		  
		    public String getRkvf1() {
		        return rkvf1;
		    }

		    public void setRkvf1(String rkvf1) {
		        this.rkvf1 = rkvf1;
		    }

		    public String getRkvf2() {
		        return rkvf2;
		    }

		    public void setRkvf2(String rkvf2) {
		        this.rkvf2 = rkvf2;
		    }
		    
		    public String getRkvf3() {
		        return rkvf3;
		    }

		    public void setRkvf3(String rkvf3) {
		        this.rkvf3 = rkvf3;
		    }
		    
		    public String getRkvf4() {
		        return rkvf4;
		    }

		    public void setRkvf4(String rkvf4) {
		        this.rkvf4 = rkvf4;
		    }
		    
		    public String getRkvf5() {
		        return rkvf5;
		    }

		    public void setRkvf5(String rkvf5) {
		        this.rkvf5 = rkvf5;
		    }
		    
		    public String getRkvf6() {
		        return rkvf6;
		    }

		    public void setRkvf6(String rkvf6) {
		        this.rkvf6 = rkvf6;
		    }
		    
		    public String getRkvf7() {
		        return rkvf7;
		    }

		    public void setRkvf7(String rkvf7) {
		        this.rkvf7 = rkvf7;
		    }
		    
		    public String getRkvf8() {
		        return rkvf8;
		    }

		    public void setRkvf8(String rkvf8) {
		        this.rkvf8 = rkvf8;
		    }
		    
		    public String getRkvf9() {
		        return rkvf9;
		    }

		    public void setRkvf9(String rkvf9) {
		        this.rkvf9 = rkvf9;
		    }
		    
		    public String getRkvf10() {
		        return rkvf10;
		    }

		    public void setRkvf10(String rkvf10) {
		        this.rkvf10 = rkvf10;
		    }
		    
		    public String getRkvf11() {
		        return rkvf11;
		    }

		    public void setRkvf11(String rkvf11) {
		        this.rkvf11 = rkvf11;
		    }
		    
		    public ArrayList<StructTableRKVBean> getMessagesRKV() {
		        return TableRKVBean.getRKV();
		    }
	
}
