/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "approve_purchase_request_material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApprovePurchaseRequestMaterial.findAll", query = "SELECT a FROM ApprovePurchaseRequestMaterial a"),
    @NamedQuery(name = "ApprovePurchaseRequestMaterial.findById", query = "SELECT a FROM ApprovePurchaseRequestMaterial a WHERE a.id = :id"),
    @NamedQuery(name = "ApprovePurchaseRequestMaterial.findByProject", query = "SELECT a FROM ApprovePurchaseRequestMaterial a WHERE a.project = :project"),
    @NamedQuery(name = "ApprovePurchaseRequestMaterial.findByQuantity", query = "SELECT a FROM ApprovePurchaseRequestMaterial a WHERE a.quantity = :quantity"),
    @NamedQuery(name = "ApprovePurchaseRequestMaterial.findByComplete", query = "SELECT a FROM ApprovePurchaseRequestMaterial a WHERE a.complete = :complete"),
    @NamedQuery(name = "ApprovePurchaseRequestMaterial.findByApprovedBy", query = "SELECT a FROM ApprovePurchaseRequestMaterial a WHERE a.approvedBy = :approvedBy"),
    @NamedQuery(name = "ApprovePurchaseRequestMaterial.findByDate", query = "SELECT a FROM ApprovePurchaseRequestMaterial a WHERE a.date = :date"),
    @NamedQuery(name = "ApprovePurchaseRequestMaterial.findByLocationDelivery", query = "SELECT a FROM ApprovePurchaseRequestMaterial a WHERE a.locationDelivery = :locationDelivery")})
public class ApprovePurchaseRequestMaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "project")
    private String project;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "complete")
    private Boolean complete;
    @Size(max = 45)
    @Column(name = "approved_by")
    private String approvedBy;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 45)
    @Column(name = "location_delivery")
    private String locationDelivery;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "approvePurchaseRequestMaterialId")
    private Collection<PurchaseOrderDetails> purchaseOrderDetailsCollection;
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unitId;
    @JoinColumn(name = "purchase_request_material_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PurchaseRequestMaterial purchaseRequestMaterialId;

    public ApprovePurchaseRequestMaterial() {
    }

    public ApprovePurchaseRequestMaterial(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocationDelivery() {
        return locationDelivery;
    }

    public void setLocationDelivery(String locationDelivery) {
        this.locationDelivery = locationDelivery;
    }

    @XmlTransient
    public Collection<PurchaseOrderDetails> getPurchaseOrderDetailsCollection() {
        return purchaseOrderDetailsCollection;
    }

    public void setPurchaseOrderDetailsCollection(Collection<PurchaseOrderDetails> purchaseOrderDetailsCollection) {
        this.purchaseOrderDetailsCollection = purchaseOrderDetailsCollection;
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
        if (!(object instanceof ApprovePurchaseRequestMaterial)) {
            return false;
        }
        ApprovePurchaseRequestMaterial other = (ApprovePurchaseRequestMaterial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.devkhadka.kalikaerp.models.ApprovePurchaseRequestMaterial[ id=" + id + " ]";
    }
    
}
