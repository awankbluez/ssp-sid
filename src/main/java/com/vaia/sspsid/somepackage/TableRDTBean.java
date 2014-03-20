package com.vaia.sspsid.somepackage;

import com.vaia.sspsid.entity.StructTableRDTBean;

import java.sql.*;
import java.util.ArrayList;
 
public class TableRDTBean {
public static ArrayList<StructTableRDTBean> getRDT() {
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=SIDPARAMETER", "sa", "sa");
            PreparedStatement ps = con.prepareStatement("select desc1,desc2,desc3+'xxx' as desccus from ref_dati2");
            ArrayList<StructTableRDTBean> rdt = new ArrayList<StructTableRDTBean>();
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
            	StructTableRDTBean e = new StructTableRDTBean();
                e.setRdtf1(rs.getString("desc1"));
                e.setRdtf2(rs.getString("desc2"));
                e.setRdtf3(rs.getString("desccus"));
                rdt.add(e);
                found = true;
            }
            rs.close();
            if (found) {
                return rdt;
            } else {
                return null; // no entries found
            }
        } catch (Exception e) {
            System.out.println("Error In getRK() -->" + e.getMessage());
            return (null);
        }
    }
}

