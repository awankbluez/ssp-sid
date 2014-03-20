package com.vaia.sspsid.dao;

import com.vaia.sspsid.entity.TableInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class TableInfoDAO {

    public List<TableInfo> getInfo() {
        ArrayList<TableInfo> infos = new ArrayList<>();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=SIDWEB", "sa", "sa");
            PreparedStatement ps = con.prepareStatement("select * from t_informasi order by create_dt desc");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TableInfo e = new TableInfo();
                e.setIf1(rs.getString("id_info"));
                e.setIf2(rs.getString("desc_info"));
                e.setIf3(rs.getString("create_dt"));
                e.setIf4(rs.getString("update_dt"));
                infos.add(e);
            }
            rs.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error In getInfo() -->" + e.getMessage());
        }

        return infos;
    }
}
