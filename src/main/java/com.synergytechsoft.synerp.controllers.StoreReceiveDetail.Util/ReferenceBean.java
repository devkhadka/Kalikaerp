/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.controllers.StoreReceiveDetail;


import com.synergytechsoft.synerp.entities.StoreReceiveDetails;
import com.synergytechsoft.synerp.entities.StoreReceiveFineDetails;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Transient;
import org.primefaces.component.datatable.DataTable;

/**
 *
 * @author user
 */
public class ReferenceBean implements Serializable {

    private final StoreReceiveDetails srd;

    public ReferenceBean(StoreReceiveDetails srd) {
        this.srd = srd;
    }
    private RowSelectModel rsm;
    @Transient
    private DataTable dt;

    public DataTable getDt() {
        return dt;
    }

    public void setDt(DataTable dt) {
        this.dt = dt;
    }

    public RowSelectModel getRsm() {
        return rsm;
    }

    public void setRsm(RowSelectModel rsm) {
        this.rsm = rsm;
    }

    public void addTextBox1() {
        System.out.println("add called");
        srd.addStoreReceiveFineDetail();      
        recreate();
    }

    public void removeSelected1() {        

        StoreReceiveFineDetails selected = null;
        if (dt != null) {
            selected = (StoreReceiveFineDetails) dt.getSelection();
        }
        if (selected != null && srd.getStoreReceiveFineDetailsCollection().contains(selected)) {
            srd.getStoreReceiveFineDetailsCollection().remove(selected);
        }
        recreate();
    }

    private void recreate() {
        List<StoreReceiveFineDetails> list  = new ArrayList<StoreReceiveFineDetails>(srd.getStoreReceiveFineDetailsCollection());
        rsm = new RowSelectModel(list);
    }
}
