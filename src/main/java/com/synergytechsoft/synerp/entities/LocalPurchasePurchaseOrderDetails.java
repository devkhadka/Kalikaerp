/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "local_purchase_purchase_order_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocalPurchasePurchaseOrderDetails.findAll", query = "SELECT l FROM LocalPurchasePurchaseOrderDetails l"),
    @NamedQuery(name = "LocalPurchasePurchaseOrderDetails.findByLocalPurchaseId", query = "SELECT l FROM LocalPurchasePurchaseOrderDetails l WHERE l.localPurchasePurchaseOrderDetailsPK.localPurchaseId = :localPurchaseId"),
    @NamedQuery(name = "LocalPurchasePurchaseOrderDetails.findByPurchaseOrderDetailsId", query = "SELECT l FROM LocalPurchasePurchaseOrderDetails l WHERE l.localPurchasePurchaseOrderDetailsPK.purchaseOrderDetailsId = :purchaseOrderDetailsId"),
    @NamedQuery(name = "LocalPurchasePurchaseOrderDetails.findByExpense", query = "SELECT l FROM LocalPurchasePurchaseOrderDetails l WHERE l.expense = :expense")})
public class LocalPurchasePurchaseOrderDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LocalPurchasePurchaseOrderDetailsPK localPurchasePurchaseOrderDetailsPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "expense")
    private Double expense;
    @Lob
    @Size(max = 65535)
    @Column(name = "remarks")
    private String remarks;
    @JoinColumn(name = "purchase_order_details_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PurchaseOrderDetails purchaseOrderDetails;
    @JoinColumn(name = "local_purchase_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private LocalPurchase localPurchase;

    public LocalPurchasePurchaseOrderDetails() {
    }

    public LocalPurchasePurchaseOrderDetails(LocalPurchasePurchaseOrderDetailsPK localPurchasePurchaseOrderDetailsPK) {
        this.localPurchasePurchaseOrderDetailsPK = localPurchasePurchaseOrderDetailsPK;
    }

    public LocalPurchasePurchaseOrderDetails(int localPurchaseId, int purchaseOrderDetailsId) {
        this.localPurchasePurchaseOrderDetailsPK = new LocalPurchasePurchaseOrderDetailsPK(localPurchaseId, purchaseOrderDetailsId);
    }

    public LocalPurchasePurchaseOrderDetailsPK getLocalPurchasePurchaseOrderDetailsPK() {
        return localPurchasePurchaseOrderDetailsPK;
    }

    public void setLocalPurchasePurchaseOrderDetailsPK(LocalPurchasePurchaseOrderDetailsPK localPurchasePurchaseOrderDetailsPK) {
        this.localPurchasePurchaseOrderDetailsPK = localPurchasePurchaseOrderDetailsPK;
    }

    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public PurchaseOrderDetails getPurchaseOrderDetails() {
        return purchaseOrderDetails;
    }

    public void setPurchaseOrderDetails(PurchaseOrderDetails purchaseOrderDetails) {
        this.purchaseOrderDetails = purchaseOrderDetails;
    }

    public LocalPurchase getLocalPurchase() {
        return localPurchase;
    }

    public void setLocalPurchase(LocalPurchase localPurchase) {
        this.localPurchase = localPurchase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (localPurchasePurchaseOrderDetailsPK != null ? localPurchasePurchaseOrderDetailsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalPurchasePurchaseOrderDetails)) {
            return false;
        }
        LocalPurchasePurchaseOrderDetails other = (LocalPurchasePurchaseOrderDetails) object;
        if ((this.localPurchasePurchaseOrderDetailsPK == null && other.localPurchasePurchaseOrderDetailsPK != null) || (this.localPurchasePurchaseOrderDetailsPK != null && !this.localPurchasePurchaseOrderDetailsPK.equals(other.localPurchasePurchaseOrderDetailsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.LocalPurchasePurchaseOrderDetails[ localPurchasePurchaseOrderDetailsPK=" + localPurchasePurchaseOrderDetailsPK + " ]";
    }
    
}
