package com.vaia.sspsid.dao;

import com.vaia.sspsid.entity.StructTableRKVBean;

import java.sql.*;
import java.util.ArrayList;
 
public class TableRKVBean {
public static ArrayList<StructTableRKVBean> getRKV() {
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=SIDPARAMETER", "sa", "sa");
            PreparedStatement ps = con.prepareStatement("select * from REFVAL_KV where ispusatval=1 order by kode_error");
            ArrayList<StructTableRKVBean> rkv = new ArrayList<StructTableRKVBean>();
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
            	StructTableRKVBean e = new StructTableRKVBean();
                e.setRkvf1(rs.getString("kv"));
                e.setRkvf2(rs.getString("subkv"));
                e.setRkvf3(rs.getString("kode_error"));
                e.setRkvf4(rs.getString("kelompok_error"));
                e.setRkvf5(rs.getString("isdateornumtype"));
                e.setRkvf6(rs.getString("tabel_ref"));
                e.setRkvf7(rs.getString("field_ref"));
                e.setRkvf8(rs.getString("selfcon"));
                e.setRkvf9(rs.getString("operator"));
                e.setRkvf10(rs.getString("procon"));
                e.setRkvf11(rs.getString("komentar_er"));
                rkv.add(e);
                found = true;
            }
            rs.close();
            if (found) {
                return rkv;
            } else {
                return null; // no entries found
            }
        } catch (Exception e) {
            System.out.println("Error In getRKV() -->" + e.getMessage());
            return (null);
        }
    }
}

