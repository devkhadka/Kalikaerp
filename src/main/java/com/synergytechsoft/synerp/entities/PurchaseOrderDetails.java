/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "purchase_order_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseOrderDetails.findAll", query = "SELECT p FROM PurchaseOrderDetails p"),
    @NamedQuery(name = "PurchaseOrderDetails.findById", query = "SELECT p FROM PurchaseOrderDetails p WHERE p.id = :id"),
    @NamedQuery(name = "PurchaseOrderDetails.findByRate", query = "SELECT p FROM PurchaseOrderDetails p WHERE p.rate = :rate"),
    @NamedQuery(name = "PurchaseOrderDetails.findByQuantity", query = "SELECT p FROM PurchaseOrderDetails p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "PurchaseOrderDetails.findByAmount", query = "SELECT p FROM PurchaseOrderDetails p WHERE p.amount = :amount"),
    @NamedQuery(name = "PurchaseOrderDetails.findByLocationDelivery", query = "SELECT p FROM PurchaseOrderDetails p WHERE p.locationDelivery = :locationDelivery")})
public class PurchaseOrderDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rate")
    private Double rate;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "amount")
    private Double amount;
    @Size(max = 45)
    @Column(name = "location_delivery")
    private String locationDelivery;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderDetails")
    private Collection<LocalPurchasePurchaseOrderDetails> localPurchasePurchaseOrderDetailsCollection;
    @JoinColumn(name = "approve_purchase_request_material_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ApprovePurchaseRequestMaterial approvePurchaseRequestMaterialId;
    @JoinColumn(name = "stores_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Stores storesId;
    @JoinColumn(name = "purchase_order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PurchaseOrder purchaseOrderId;
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unitId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderDetails")
    private Collection<ForeignPurchasePurchaseOrderDetails> foreignPurchasePurchaseOrderDetailsCollection;

    public PurchaseOrderDetails() {
    }

    public PurchaseOrderDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getLocationDelivery() {
        return locationDelivery;
    }

    public void setLocationDelivery(String locationDelivery) {
        this.locationDelivery = locationDelivery;
    }

    @XmlTransient
    public Collection<LocalPurchasePurchaseOrderDetails> getLocalPurchasePurchaseOrderDetailsCollection() {
        return localPurchasePurchaseOrderDetailsCollection;
    }

    public void setLocalPurchasePurchaseOrderDetailsCollection(Collection<LocalPurchasePurchaseOrderDetails> localPurchasePurchaseOrderDetailsCollection) {
        this.localPurchasePurchaseOrderDetailsCollection = localPurchasePurchaseOrderDetailsCollection;
    }

    public ApprovePurchaseRequestMaterial getApprovePurchaseRequestMaterialId() {
        return approvePurchaseRequestMaterialId;
    }

    public void setApprovePurchaseRequestMaterialId(ApprovePurchaseRequestMaterial approvePurchaseRequestMaterialId) {
        this.approvePurchaseRequestMaterialId = approvePurchaseRequestMaterialId;
    }

    public Stores getStoresId() {
        return storesId;
    }

    public void setStoresId(Stores storesId) {
        this.storesId = storesId;
    }

    public PurchaseOrder getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(PurchaseOrder purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }

    @XmlTransient
    public Collection<ForeignPurchasePurchaseOrderDetails> getForeignPurchasePurchaseOrderDetailsCollection() {
        return foreignPurchasePurchaseOrderDetailsCollection;
    }

    public void setForeignPurchasePurchaseOrderDetailsCollection(Collection<ForeignPurchasePurchaseOrderDetails> foreignPurchasePurchaseOrderDetailsCollection) {
        this.foreignPurchasePurchaseOrderDetailsCollection = foreignPurchasePurchaseOrderDetailsCollection;
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
        if (!(object instanceof PurchaseOrderDetails)) {
            return false;
        }
        PurchaseOrderDetails other = (PurchaseOrderDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.PurchaseOrderDetails[ id=" + id + " ]";
    }
    
}
