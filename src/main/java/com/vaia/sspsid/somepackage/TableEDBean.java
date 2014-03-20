package com.vaia.sspsid.somepackage;

import com.vaia.sspsid.entity.StructTableEDBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.sql.DataSource;

public class TableEDBean {

    public static ArrayList<StructTableEDBean> getED() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=SIDBRI", "sa", "sa");
            PreparedStatement ps = con.prepareStatement("select * from MAPFLAG_ERROR_DESK");
            ArrayList<StructTableEDBean> erd = new ArrayList<StructTableEDBean>();
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
                StructTableEDBean e = new StructTableEDBean();
                e.setEdf1(rs.getString("kode_error"));
                e.setEdf2(rs.getString("deskripsi"));
                e.setEdf3(rs.getString("form"));
                e.setEdf4(rs.getString("fielddb"));
                erd.add(e);
                found = true;
            }
            rs.close();
            if (found) {
                return erd;
            } else {
                return null; // no entries found
            }
        } catch (Exception e) {
            System.out.println("Error In getED() -->" + e.getMessage());
            return (null);
        }
    }

    @Resource(name = "jdbc/sidbri")
    private DataSource sidBRIDatasource;
}
