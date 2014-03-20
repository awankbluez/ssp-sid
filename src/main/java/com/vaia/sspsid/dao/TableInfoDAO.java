/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.sspsid.dao;

import com.vaia.sspsid.entity.TableInfo;
import com.vaia.sspsid.util.DAOUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 *
 * @author Wirawan Adi <http://about.me/wirawan.adi>
 */
@Stateless
public class TableInfoDAO extends AbstractDAO {

    private static final String SQL_RETRIEVE_ALL = "select * from t_informasi order by create_dt desc";

    @PostConstruct
    private void init() {

    }

    public List<TableInfo> getTableInfos() {
        Connection connection = getConnection();
        List<TableInfo> tableInfos = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = DAOUtil.prepareStatement(connection, SQL_RETRIEVE_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                TableInfo e = new TableInfo();
                e.setIf1(resultSet.getString("id_info"));
                e.setIf2(resultSet.getString("desc_info"));
                e.setIf3(resultSet.getString("create_dt"));
                e.setIf4(resultSet.getString("update_dt"));
                tableInfos.add(e);
            }

        } catch (SQLException e) {

        } finally {
            DAOUtil.close(connection, preparedStatement, resultSet);
        }

        return tableInfos;

    }

}
