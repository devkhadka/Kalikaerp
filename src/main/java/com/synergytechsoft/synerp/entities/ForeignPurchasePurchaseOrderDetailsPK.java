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
public class ForeignPurchasePurchaseOrderDetailsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "foreign_purchase_id")
    private int foreignPurchaseId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "purchase_order_details_id")
    private int purchaseOrderDetailsId;

    public ForeignPurchasePurchaseOrderDetailsPK() {
    }

    public ForeignPurchasePurchaseOrderDetailsPK(int foreignPurchaseId, int purchaseOrderDetailsId) {
        this.foreignPurchaseId = foreignPurchaseId;
        this.purchaseOrderDetailsId = purchaseOrderDetailsId;
    }

    public int getForeignPurchaseId() {
        return foreignPurchaseId;
    }

    public void setForeignPurchaseId(int foreignPurchaseId) {
        this.foreignPurchaseId = foreignPurchaseId;
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
        hash += (int) foreignPurchaseId;
        hash += (int) purchaseOrderDetailsId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ForeignPurchasePurchaseOrderDetailsPK)) {
            return false;
        }
        ForeignPurchasePurchaseOrderDetailsPK other = (ForeignPurchasePurchaseOrderDetailsPK) object;
        if (this.foreignPurchaseId != other.foreignPurchaseId) {
            return false;
        }
        if (this.purchaseOrderDetailsId != other.purchaseOrderDetailsId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.ForeignPurchasePurchaseOrderDetailsPK[ foreignPurchaseId=" + foreignPurchaseId + ", purchaseOrderDetailsId=" + purchaseOrderDetailsId + " ]";
    }
    
}
