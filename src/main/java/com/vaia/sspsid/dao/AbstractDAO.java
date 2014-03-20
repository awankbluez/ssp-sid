/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.sspsid.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 *
 * @author Wirawan Adi <http://about.me/wirawan.adi>
 */
public class AbstractDAO {

    private static final Logger LOG = Logger.getLogger(AbstractDAO.class.getName());

    @Resource(lookup = "java:app/jdbc/sidbri")
    private DataSource sidBriDataSource;

    protected Connection getConnection() {
        Connection conn = null;

        try {
            conn = sidBriDataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }
}
