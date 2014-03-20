package com.vaia.sspsid.somepackage;

import com.vaia.sspsid.entity.StructTableERBean;

import java.sql.*;
import java.util.ArrayList;
 
public class TableERBean {
public static ArrayList<StructTableERBean> getER() {
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=SIDWEB", "sa", "sa");
            PreparedStatement ps = con.prepareStatement("select * from FACT_ER order by er_f01+er_f02+er_f03c+er_f03f+er_f03g+er_f03h+er_f04a+er_f04b+er_f06 desc");
            ArrayList<StructTableERBean> er1 = new ArrayList<StructTableERBean>();
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
            	StructTableERBean e = new StructTableERBean();
                e.setErf1(rs.getString("rgdesc"));
                e.setErf2(rs.getString("mbdesc"));
                e.setErf3(rs.getString("brdesc"));
                e.setErf4(rs.getString("mainbr"));
                e.setErf5(rs.getString("branch"));
                e.setErf6(rs.getString("bibr"));
                e.setErf7(rs.getString("er_f01"));
                e.setErf8(rs.getString("er_f02"));
                e.setErf9(rs.getString("er_f03c"));
                e.setErf10(rs.getString("er_f03f"));
                e.setErf11(rs.getString("er_f03g"));
                e.setErf12(rs.getString("er_f03h"));
                e.setErf13(rs.getString("er_f04a"));
                e.setErf14(rs.getString("er_f04b"));
                e.setErf15(rs.getString("er_f06"));
                er1.add(e);
                found = true;
            }
            rs.close();
            if (found) {
                return er1;
            } else {
                return null; // no entries found
            }
        } catch (Exception e) {
            System.out.println("Error In getER() -->" + e.getMessage());
            return (null);
        }
    }
}

