/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dev
 */
@Embeddable
public class LocalPurchasePurchaseOrderDetailsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "local_purchase_id")
    private int localPurchaseId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "purchase_order_details_id")
    private int purchaseOrderDetailsId;

    public LocalPurchasePurchaseOrderDetailsPK() {
    }

    public LocalPurchasePurchaseOrderDetailsPK(int localPurchaseId, int purchaseOrderDetailsId) {
        this.localPurchaseId = localPurchaseId;
        this.purchaseOrderDetailsId = purchaseOrderDetailsId;
    }

    public int getLocalPurchaseId() {
        return localPurchaseId;
    }

    public void setLocalPurchaseId(int localPurchaseId) {
        this.localPurchaseId = localPurchaseId;
    }

    public int getPurchaseOrderDetailsId() {
        return purchaseOrderDetailsId;
    }

    public void setPurchaseOrderDetailsId(int purchaseOrderDetailsId) {
        this.purchaseOrderDetailsId = purchaseOrderDetailsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) localPurchaseId;
        hash += (int) purchaseOrderDetailsId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalPurchasePurchaseOrderDetailsPK)) {
            return false;
        }
        LocalPurchasePurchaseOrderDetailsPK other = (LocalPurchasePurchaseOrderDetailsPK) object;
        if (this.localPurchaseId != other.localPurchaseId) {
            return false;
        }
        if (this.purchaseOrderDetailsId != other.purchaseOrderDetailsId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.LocalPurchasePurchaseOrderDetailsPK[ localPurchaseId=" + localPurchaseId + ", purchaseOrderDetailsId=" + purchaseOrderDetailsId + " ]";
    }
    
}
