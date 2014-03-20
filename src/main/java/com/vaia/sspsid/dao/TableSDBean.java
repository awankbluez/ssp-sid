package com.vaia.sspsid.dao;

import com.vaia.sspsid.entity.StructTableSDBean;

import java.sql.*;
import java.util.ArrayList;
 
public class TableSDBean {
public static ArrayList<StructTableSDBean> getSD() {
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=SIDPARAMETER", "sa", "sa");
            PreparedStatement ps = con.prepareStatement("select * from daftar_sumber_data where isactive=1 ");
            ArrayList<StructTableSDBean> sd = new ArrayList<StructTableSDBean>();
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
            	StructTableSDBean e = new StructTableSDBean();
                e.setF1(rs.getString("sumber_data"));
                e.setF2(rs.getString("posisi_data"));
                e.setF3(rs.getString("isready_desc"));
                sd.add(e);
                found = true;
            }
            rs.close();
            if (found) {
                return sd;
            } else {
                return null; // no entries found
            }
        } catch (Exception e) {
            System.out.println("Error In getCustomer() -->" + e.getMessage());
            return (null);
        }
    }
}

