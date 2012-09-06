/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "reject_purchase_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RejectPurchaseRequest.findAll", query = "SELECT r FROM RejectPurchaseRequest r"),
    @NamedQuery(name = "RejectPurchaseRequest.findById", query = "SELECT r FROM RejectPurchaseRequest r WHERE r.id = :id"),
    @NamedQuery(name = "RejectPurchaseRequest.findByQuantity", query = "SELECT r FROM RejectPurchaseRequest r WHERE r.quantity = :quantity")})
public class RejectPurchaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantity")
    private Double quantity;
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unitId;
    @JoinColumn(name = "purchase_request_material_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PurchaseRequestMaterial purchaseRequestMaterialId;

    public RejectPurchaseRequest() {
    }

    public RejectPurchaseRequest(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }

    public PurchaseRequestMaterial getPurchaseRequestMaterialId() {
        return purchaseRequestMaterialId;
    }

    public void setPurchaseRequestMaterialId(PurchaseRequestMaterial purchaseRequestMaterialId) {
        this.purchaseRequestMaterialId = purchaseRequestMaterialId;
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
        if (!(object instanceof RejectPurchaseRequest)) {
            return false;
        }
        RejectPurchaseRequest other = (RejectPurchaseRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.devkhadka.kalikaerp.models.RejectPurchaseRequest[ id=" + id + " ]";
    }
    
}
