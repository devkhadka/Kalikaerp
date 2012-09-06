/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "foreign_purchase_purchase_order_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ForeignPurchasePurchaseOrderDetails.findAll", query = "SELECT f FROM ForeignPurchasePurchaseOrderDetails f"),
    @NamedQuery(name = "ForeignPurchasePurchaseOrderDetails.findByForeignPurchaseId", query = "SELECT f FROM ForeignPurchasePurchaseOrderDetails f WHERE f.foreignPurchasePurchaseOrderDetailsPK.foreignPurchaseId = :foreignPurchaseId"),
    @NamedQuery(name = "ForeignPurchasePurchaseOrderDetails.findByPurchaseOrderDetailsId", query = "SELECT f FROM ForeignPurchasePurchaseOrderDetails f WHERE f.foreignPurchasePurchaseOrderDetailsPK.purchaseOrderDetailsId = :purchaseOrderDetailsId"),
    @NamedQuery(name = "ForeignPurchasePurchaseOrderDetails.findByQuantity", query = "SELECT f FROM ForeignPurchasePurchaseOrderDetails f WHERE f.quantity = :quantity"),
    @NamedQuery(name = "ForeignPurchasePurchaseOrderDetails.findByCustomAccessedValue", query = "SELECT f FROM ForeignPurchasePurchaseOrderDetails f WHERE f.customAccessedValue = :customAccessedValue"),
    @NamedQuery(name = "ForeignPurchasePurchaseOrderDetails.findByCustomDuty", query = "SELECT f FROM ForeignPurchasePurchaseOrderDetails f WHERE f.customDuty = :customDuty"),
    @NamedQuery(name = "ForeignPurchasePurchaseOrderDetails.findByVat", query = "SELECT f FROM ForeignPurchasePurchaseOrderDetails f WHERE f.vat = :vat")})
public class ForeignPurchasePurchaseOrderDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ForeignPurchasePurchaseOrderDetailsPK foreignPurchasePurchaseOrderDetailsPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "custom_accessed_value")
    private Double customAccessedValue;
    @Column(name = "custom_duty")
    private Double customDuty;
    @Column(name = "VAT")
    private Double vat;
    @JoinColumn(name = "purchase_order_details_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PurchaseOrderDetails purchaseOrderDetails;
    @JoinColumn(name = "foreign_purchase_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ForeignPurchase foreignPurchase;

    public ForeignPurchasePurchaseOrderDetails() {
    }

    public ForeignPurchasePurchaseOrderDetails(ForeignPurchasePurchaseOrderDetailsPK foreignPurchasePurchaseOrderDetailsPK) {
        this.foreignPurchasePurchaseOrderDetailsPK = foreignPurchasePurchaseOrderDetailsPK;
    }

    public ForeignPurchasePurchaseOrderDetails(int foreignPurchaseId, int purchaseOrderDetailsId) {
        this.foreignPurchasePurchaseOrderDetailsPK = new ForeignPurchasePurchaseOrderDetailsPK(foreignPurchaseId, purchaseOrderDetailsId);
    }

    public ForeignPurchasePurchaseOrderDetailsPK getForeignPurchasePurchaseOrderDetailsPK() {
        return foreignPurchasePurchaseOrderDetailsPK;
    }

    public void setForeignPurchasePurchaseOrderDetailsPK(ForeignPurchasePurchaseOrderDetailsPK foreignPurchasePurchaseOrderDetailsPK) {
        this.foreignPurchasePurchaseOrderDetailsPK = foreignPurchasePurchaseOrderDetailsPK;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getCustomAccessedValue() {
        return customAccessedValue;
    }

    public void setCustomAccessedValue(Double customAccessedValue) {
        this.customAccessedValue = customAccessedValue;
    }

    public Double getCustomDuty() {
        return customDuty;
    }

    public void setCustomDuty(Double customDuty) {
        this.customDuty = customDuty;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public PurchaseOrderDetails getPurchaseOrderDetails() {
        return purchaseOrderDetails;
    }

    public void setPurchaseOrderDetails(PurchaseOrderDetails purchaseOrderDetails) {
        this.purchaseOrderDetails = purchaseOrderDetails;
    }

    public ForeignPurchase getForeignPurchase() {
        return foreignPurchase;
    }

    public void setForeignPurchase(ForeignPurchase foreignPurchase) {
        this.foreignPurchase = foreignPurchase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foreignPurchasePurchaseOrderDetailsPK != null ? foreignPurchasePurchaseOrderDetailsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ForeignPurchasePurchaseOrderDetails)) {
            return false;
        }
        ForeignPurchasePurchaseOrderDetails other = (ForeignPurchasePurchaseOrderDetails) object;
        if ((this.foreignPurchasePurchaseOrderDetailsPK == null && other.foreignPurchasePurchaseOrderDetailsPK != null) || (this.foreignPurchasePurchaseOrderDetailsPK != null && !this.foreignPurchasePurchaseOrderDetailsPK.equals(other.foreignPurchasePurchaseOrderDetailsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.ForeignPurchasePurchaseOrderDetails[ foreignPurchasePurchaseOrderDetailsPK=" + foreignPurchasePurchaseOrderDetailsPK + " ]";
    }
    
}
