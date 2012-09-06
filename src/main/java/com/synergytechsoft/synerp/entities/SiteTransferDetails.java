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
@Table(name = "site_transfer_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteTransferDetails.findAll", query = "SELECT s FROM SiteTransferDetails s"),
    @NamedQuery(name = "SiteTransferDetails.findById", query = "SELECT s FROM SiteTransferDetails s WHERE s.id = :id"),
    @NamedQuery(name = "SiteTransferDetails.findByQuantityReq", query = "SELECT s FROM SiteTransferDetails s WHERE s.quantityReq = :quantityReq"),
    @NamedQuery(name = "SiteTransferDetails.findByLocation", query = "SELECT s FROM SiteTransferDetails s WHERE s.location = :location")})
public class SiteTransferDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantity_req")
    private Double quantityReq;
    @Size(max = 45)
    @Column(name = "location")
    private String location;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "siteTransferDetailsId")
    private Collection<ApproveSiteTransfer> approveSiteTransferCollection;
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unitId;
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Material materialId;
    @JoinColumn(name = "process_approved_requisitions_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProcessApprovedRequisitions processApprovedRequisitionsId;
    @JoinColumn(name = "site_transfer_orders_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SiteTransferOrders siteTransferOrdersId;

    public SiteTransferDetails() {
    }

    public SiteTransferDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantityReq() {
        return quantityReq;
    }

    public void setQuantityReq(Double quantityReq) {
        this.quantityReq = quantityReq;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @XmlTransient
    public Collection<ApproveSiteTransfer> getApproveSiteTransferCollection() {
        return approveSiteTransferCollection;
    }

    public void setApproveSiteTransferCollection(Collection<ApproveSiteTransfer> approveSiteTransferCollection) {
        this.approveSiteTransferCollection = approveSiteTransferCollection;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }

    public Material getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Material materialId) {
        this.materialId = materialId;
    }

    public ProcessApprovedRequisitions getProcessApprovedRequisitionsId() {
        return processApprovedRequisitionsId;
    }

    public void setProcessApprovedRequisitionsId(ProcessApprovedRequisitions processApprovedRequisitionsId) {
        this.processApprovedRequisitionsId = processApprovedRequisitionsId;
    }

    public SiteTransferOrders getSiteTransferOrdersId() {
        return siteTransferOrdersId;
    }

    public void setSiteTransferOrdersId(SiteTransferOrders siteTransferOrdersId) {
        this.siteTransferOrdersId = siteTransferOrdersId;
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
        if (!(object instanceof SiteTransferDetails)) {
            return false;
        }
        SiteTransferDetails other = (SiteTransferDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.SiteTransferDetails[ id=" + id + " ]";
    }
    
}
