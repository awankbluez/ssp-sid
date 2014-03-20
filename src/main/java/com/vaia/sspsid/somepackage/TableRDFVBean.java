package com.vaia.sspsid.somepackage;

import com.vaia.sspsid.entity.StructTableRDFVBean;

import java.sql.*;
import java.util.ArrayList;
 
public class TableRDFVBean {
public static ArrayList<StructTableRDFVBean> getRDFV() {
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=SIDPARAMETER", "sa", "sa");
            PreparedStatement ps = con.prepareStatement("select * from REFVAL_DAFTAR_FIELD_VALIDASI where ispusatval=1 ");
            ArrayList<StructTableRDFVBean> sd = new ArrayList<StructTableRDFVBean>();
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
            	StructTableRDFVBean e = new StructTableRDFVBean();
                e.setRdfvf1(rs.getString("form"));
                e.setRdfvf2(rs.getString("tabeldb"));
                e.setRdfvf3(rs.getString("fielddb"));
                e.setRdfvf4(rs.getString("kv"));
                e.setRdfvf5(rs.getString("tabeler"));
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
            System.out.println("Error In getRDFV() -->" + e.getMessage());
            return (null);
        }
    }
}

