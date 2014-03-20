package com.vaia.sspsid.util;

import com.vaia.sspsid.dao.TableUserBean;
import com.vaia.sspsid.dao.TableUserBean;

import java.sql.*;
import java.util.ArrayList;
 
public class SqlConBean {
public static ArrayList<TableUserBean> getCustomer() {
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=SIDPARAMETER", "sa", "sa");
            PreparedStatement ps = con.prepareStatement("select * from daftar_proses_sid where isactive=1");
            ArrayList<TableUserBean> al = new ArrayList<TableUserBean>();
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
            	TableUserBean e = new TableUserBean();
                e.setF1(rs.getString("prosesno"));
                e.setF2(rs.getString("subprosesno"));
                e.setF3(rs.getString("deskripsi"));
                e.setF4(rs.getString("status"));
                e.setF5(rs.getString("last_run"));
                e.setF6(rs.getString("last_run_daily_min"));
                e.setF7(rs.getString("last_run_monthly_min"));
                al.add(e);
                found = true;
            }
            rs.close();
            if (found) {
                return al;
            } else {
                return null; // no entries found
            }
        } catch (Exception e) {
            System.out.println("Error In getCustomer() -->" + e.getMessage());
            return (null);
        }
    }
}

