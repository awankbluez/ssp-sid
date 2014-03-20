/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.sspsid.managedBean;

import com.vaia.sspsid.dao.TableEDBean;
import com.vaia.sspsid.dao.TableInfoDAO;
import com.vaia.sspsid.dao.TableInfoDAO1;
import com.vaia.sspsid.dao.TableRDTBean;
import com.vaia.sspsid.entity.RDT;
import com.vaia.sspsid.entity.StructTableEDBean;
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
    private TableInfoDAO1 tableInfoDAO; // kurang benar
    @EJB
    private TableInfoDAO tableInfoBean;
    @EJB
    private TableRDTBean tableRDTBean;
    @EJB
    private TableEDBean tableEDBean;

    private List<TableInfo> tableInfos;
    private List<RDT> rdts;
    private List<StructTableEDBean> eds;

    private Integer tesValueButton;

    @PostConstruct
    private void init() {
        populate();
    }

    private void populate() {
        tableInfos = tableInfoBean.getInfo();
        rdts = tableRDTBean.getRDT();
        eds = tableEDBean.getED();
    }

    public List<TableInfo> getTableInfos() {
        return tableInfos;
    }

    public void setTableInfos(List<TableInfo> tableInfos) {
        this.tableInfos = tableInfos;
    }

    public List<RDT> getRdts() {
        return rdts;
    }

    public void setRdts(List<RDT> rdts) {
        this.rdts = rdts;
    }

    public List<StructTableEDBean> getEds() {
        return eds;
    }

    public void setEds(List<StructTableEDBean> eds) {
        this.eds = eds;
    }

    public Integer getTesValueButton() {
        return tesValueButton;
    }

    public void setTesValueButton(Integer tesValueButton) {
        this.tesValueButton = tesValueButton;
    }

}
