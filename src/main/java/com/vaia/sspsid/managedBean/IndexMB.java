/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.sspsid.managedBean;

import com.vaia.sspsid.dao.TableInfoDAO;
import com.vaia.sspsid.entity.TableInfo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Wirawan Adi <http://about.me/wirawan.adi>
 */
@Named("indexBean")
@ViewScoped
public class IndexMB extends AbstractManagedBean {

    @EJB
    private TableInfoDAO tableInfoDAO;
    private List<TableInfo> tableInfos;

    @PostConstruct
    private void init() {
        populate();
    }

    private void populate() {
        tableInfos = tableInfoDAO.getTableInfos();
    }

    public List<TableInfo> getTableInfos() {
        return tableInfos;
    }

    public void setTableInfos(List<TableInfo> tableInfos) {
        this.tableInfos = tableInfos;
    }

}
