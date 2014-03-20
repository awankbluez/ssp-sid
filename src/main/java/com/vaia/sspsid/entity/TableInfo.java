package com.vaia.sspsid.entity;

import com.vaia.sspsid.somepackage.TableInfoBean;
import java.io.Serializable;
import java.util.ArrayList;

public class TableInfo implements Serializable {

    //Table Records Store
    private String if1;
    private String if2;
    private String if3;
    private String if4;

    public String getIf1() {
        return if1;
    }

    public void setIf1(String if1) {
        this.if1 = if1;
    }

    public String getIf2() {
        return if2;
    }

    public void setIf2(String if2) {
        this.if2 = if2;
    }

    public String getIf3() {
        return if3;
    }

    public void setIf3(String if3) {
        this.if3 = if3;
    }

    public String getIf4() {
        return if4;
    }

    public void setIf4(String if4) {
        this.if4 = if4;
    }

    public ArrayList<TableInfo> getMessagesInfo() {
        return TableInfoBean.getInfo();
    }

}
