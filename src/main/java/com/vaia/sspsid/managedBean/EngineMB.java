package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ManagedBean(name="buttonBean")
@ViewScoped
public class EngineMB implements Serializable {
	
	private Integer number;
	
	public Integer getNumber(){
		return this.number;
	}
	
	public void setNumber(Integer number){
		this.number = number;
	}

}
