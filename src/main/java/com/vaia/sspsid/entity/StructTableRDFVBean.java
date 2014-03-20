package com.vaia.sspsid.entity;

import com.vaia.sspsid.dao.TableRDFVBean;
import com.vaia.sspsid.dao.TableRDFVBean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "StructRDFV")
@SessionScoped
public class StructTableRDFVBean {
	//Table Records Store
		    private String rdfvf1,rdfvf2,rdfvf3,rdfvf4,rdfvf5;
		  
		    public String getRdfvf1() {
		        return rdfvf1;
		    }

		    public void setRdfvf1(String rdfvf1) {
		        this.rdfvf1 = rdfvf1;
		    }

		    public String getRdfvf2() {
		        return rdfvf2;
		    }

		    public void setRdfvf2(String rdfvf2) {
		        this.rdfvf2 = rdfvf2;
		    }
		    
		    public String getRdfvf3() {
		        return rdfvf3;
		    }

		    public void setRdfvf3(String rdfvf3) {
		        this.rdfvf3 = rdfvf3;
		    }
		    
		    public String getRdfvf4() {
		        return rdfvf4;
		    }

		    public void setRdfvf4(String rdfvf4) {
		        this.rdfvf4 = rdfvf4;
		    }
		    
		    public String getRdfvf5() {
		        return rdfvf5;
		    }

		    public void setRdfvf5(String rdfvf5) {
		        this.rdfvf5 = rdfvf5;
		    }
		    
		    public ArrayList<StructTableRDFVBean> getMessagesRDFV() {
		        return TableRDFVBean.getRDFV();
		    }
}
