package com.vaia.sspsid.somepackage;

import com.vaia.sspsid.entity.TableInfo;

import java.sql.*;
import java.util.ArrayList;
 
public class TableInfoBean {
public static ArrayList<TableInfo> getInfo() {
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=SIDWEB", "sa", "sa");
            PreparedStatement ps = con.prepareStatement("select * from t_informasi order by create_dt desc");
            ArrayList<TableInfo> info = new ArrayList<TableInfo>();
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
            	TableInfo e = new TableInfo();
                e.setIf1(rs.getString("id_info"));
                e.setIf2(rs.getString("desc_info"));
                e.setIf3(rs.getString("create_dt"));
                e.setIf4(rs.getString("update_dt"));
                info.add(e);
                found = true;
            }
            rs.close();
            if (found) {
                return info;
            } else {
                return null; // no entries found
            }
        } catch (Exception e) {
            System.out.println("Error In getInfo() -->" + e.getMessage());
            return (null);
        }
    }
}

