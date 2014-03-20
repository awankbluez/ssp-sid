package com.vaia.sspsid.somepackage;

import com.vaia.sspsid.entity.StructTableRKBean;

import java.sql.*;
import java.util.ArrayList;
 
public class TableRKBean {
public static ArrayList<StructTableRKBean> getRK() {
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=SIDPARAMETER", "sa", "sa");
            PreparedStatement ps = con.prepareStatement("select * from dbo.REFVAL_KARAKTER");
            ArrayList<StructTableRKBean> rk = new ArrayList<StructTableRKBean>();
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
            	StructTableRKBean e = new StructTableRKBean();
                e.setRkf1(rs.getString("karakter"));
                e.setRkf2(rs.getString("kv"));
                e.setRkf3(rs.getString("keterangan"));
                e.setRkf4(rs.getString("keterangan2"));
                e.setRkf5(rs.getString("nilai1"));
                rk.add(e);
                found = true;
            }
            rs.close();
            if (found) {
                return rk;
            } else {
                return null; // no entries found
            }
        } catch (Exception e) {
            System.out.println("Error In getRK() -->" + e.getMessage());
            return (null);
        }
    }
}

