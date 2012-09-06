/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "local_purchase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocalPurchase.findAll", query = "SELECT l FROM LocalPurchase l"),
    @NamedQuery(name = "LocalPurchase.findById", query = "SELECT l FROM LocalPurchase l WHERE l.id = :id")})
public class LocalPurchase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localPurchase")
    private Collection<LocalPurchasePurchaseOrderDetails> localPurchasePurchaseOrderDetailsCollection;
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unitId;
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Currency currencyId;
    @JoinColumn(name = "purchase_order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PurchaseOrder purchaseOrderId;

    public LocalPurchase() {
    }

    public LocalPurchase(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<LocalPurchasePurchaseOrderDetails> getLocalPurchasePurchaseOrderDetailsCollection() {
        return localPurchasePurchaseOrderDetailsCollection;
    }

    public void setLocalPurchasePurchaseOrderDetailsCollection(Collection<LocalPurchasePurchaseOrderDetails> localPurchasePurchaseOrderDetailsCollection) {
        this.localPurchasePurchaseOrderDetailsCollection = localPurchasePurchaseOrderDetailsCollection;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }

    public Currency getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Currency currencyId) {
        this.currencyId = currencyId;
    }

    public PurchaseOrder getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(PurchaseOrder purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalPurchase)) {
            return false;
        }
        LocalPurchase other = (LocalPurchase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.LocalPurchase[ id=" + id + " ]";
    }
    
}
