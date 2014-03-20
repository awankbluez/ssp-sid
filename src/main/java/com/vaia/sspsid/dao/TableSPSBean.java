package com.vaia.sspsid.dao;

import com.vaia.sspsid.entity.StructTableSPSBean;

import java.sql.*;
import java.util.ArrayList;
 
public class TableSPSBean {
public static ArrayList<StructTableSPSBean> getSPS() {
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=SIDPARAMETER", "sa", "sa");
            PreparedStatement ps = con.prepareStatement("select * from status_proses_sid");
            ArrayList<StructTableSPSBean> sd = new ArrayList<StructTableSPSBean>();
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
            	StructTableSPSBean e = new StructTableSPSBean();
                e.setSpsf1(rs.getString("opsiproses"));
                e.setSpsf2(rs.getString("last_processed_time"));
                e.setSpsf3(rs.getString("startdate"));
                e.setSpsf4(rs.getString("estimateenddate"));
                e.setSpsf5(rs.getString("status_proses"));
                e.setSpsf6(rs.getString("proses_curr_run"));
                e.setSpsf7(rs.getString("actualenddate"));
                e.setSpsf8(rs.getString("actual_processed_time"));
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

