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
@Table(name = "purchase_request_material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseRequestMaterial.findAll", query = "SELECT p FROM PurchaseRequestMaterial p"),
    @NamedQuery(name = "PurchaseRequestMaterial.findByExpectedDate", query = "SELECT p FROM PurchaseRequestMaterial p WHERE p.expectedDate = :expectedDate"),
    @NamedQuery(name = "PurchaseRequestMaterial.findByExpextedQuantity", query = "SELECT p FROM PurchaseRequestMaterial p WHERE p.expextedQuantity = :expextedQuantity"),
    @NamedQuery(name = "PurchaseRequestMaterial.findByComplete", query = "SELECT p FROM PurchaseRequestMaterial p WHERE p.complete = :complete"),
    @NamedQuery(name = "PurchaseRequestMaterial.findByRaisedBy", query = "SELECT p FROM PurchaseRequestMaterial p WHERE p.raisedBy = :raisedBy"),
    @NamedQuery(name = "PurchaseRequestMaterial.findById", query = "SELECT p FROM PurchaseRequestMaterial p WHERE p.id = :id")})
public class PurchaseRequestMaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "expected_date")
    @Temporal(TemporalType.DATE)
    private Date expectedDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "expexted_quantity")
    private Double expextedQuantity;
    @Column(name = "complete")
    private Boolean complete;
    @Lob
    @Size(max = 65535)
    @Column(name = "location_delivery")
    private String locationDelivery;
    @Size(max = 45)
    @Column(name = "raised_by")
    private String raisedBy;
   
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unitId;
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    @ManyToOne
    private Project projectId;
    @JoinColumn(name = "purchase_request_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PurchaseRequest purchaseRequestId;
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Material materialId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseRequestMaterialId")
    private Collection<ApprovePurchaseRequestMaterial> approvePurchaseRequestMaterialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseRequestMaterialId")
    private Collection<RejectPurchaseRequest> rejectPurchaseRequestCollection;

    public PurchaseRequestMaterial() {
    }

    public PurchaseRequestMaterial(Integer id) {
        this.id = id;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public Double getExpextedQuantity() {
        return expextedQuantity;
    }

    public void setExpextedQuantity(Double expextedQuantity) {
        this.expextedQuantity = expextedQuantity;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public String getLocationDelivery() {
        return locationDelivery;
    }

    public void setLocationDelivery(String locationDelivery) {
        this.locationDelivery = locationDelivery;
    }

    public String getRaisedBy() {
        return raisedBy;
    }

    public void setRaisedBy(String raisedBy) {
        this.raisedBy = raisedBy;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public PurchaseRequest getPurchaseRequestId() {
        return purchaseRequestId;
    }

    public void setPurchaseRequestId(PurchaseRequest purchaseRequestId) {
        this.purchaseRequestId = purchaseRequestId;
    }

    public Material getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Material materialId) {
        this.materialId = materialId;
    }

    @XmlTransient
    public Collection<ApprovePurchaseRequestMaterial> getApprovePurchaseRequestMaterialCollection() {
        return approvePurchaseRequestMaterialCollection;
    }

    public void setApprovePurchaseRequestMaterialCollection(Collection<ApprovePurchaseRequestMaterial> approvePurchaseRequestMaterialCollection) {
        this.approvePurchaseRequestMaterialCollection = approvePurchaseRequestMaterialCollection;
    }

    @XmlTransient
    public Collection<RejectPurchaseRequest> getRejectPurchaseRequestCollection() {
        return rejectPurchaseRequestCollection;
    }

    public void setRejectPurchaseRequestCollection(Collection<RejectPurchaseRequest> rejectPurchaseRequestCollection) {
        this.rejectPurchaseRequestCollection = rejectPurchaseRequestCollection;
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
        if (!(object instanceof PurchaseRequestMaterial)) {
            return false;
        }
        PurchaseRequestMaterial other = (PurchaseRequestMaterial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.devkhadka.kalikaerp.models.PurchaseRequestMaterial[ id=" + id + " ]";
    }
    
}
