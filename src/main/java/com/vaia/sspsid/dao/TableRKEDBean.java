package com.vaia.sspsid.dao;

import com.vaia.sspsid.entity.StructTableRKEDBean;

import java.sql.*;
import java.util.ArrayList;
 
public class TableRKEDBean {
public static ArrayList<StructTableRKEDBean> getRKED() {
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=SIDPARAMETER", "sa", "sa");
            PreparedStatement ps = con.prepareStatement("select * from REFVAL_KODE_ERROR_DESK");
            ArrayList<StructTableRKEDBean> rked = new ArrayList<StructTableRKEDBean>();
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
            	StructTableRKEDBean e = new StructTableRKEDBean();
                e.setRkedf1(rs.getString("subkv"));
                e.setRkedf2(rs.getString("deskripsi_er"));
                rked.add(e);
                found = true;
            }
            rs.close();
            if (found) {
                return rked;
            } else {
                return null; // no entries found
            }
        } catch (Exception e) {
            System.out.println("Error In getRK() -->" + e.getMessage());
            return (null);
        }
    }
}

