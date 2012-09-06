/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "site_transfer_requisition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteTransferRequisition.findAll", query = "SELECT s FROM SiteTransferRequisition s"),
    @NamedQuery(name = "SiteTransferRequisition.findById", query = "SELECT s FROM SiteTransferRequisition s WHERE s.id = :id"),
    @NamedQuery(name = "SiteTransferRequisition.findByQuantity", query = "SELECT s FROM SiteTransferRequisition s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "SiteTransferRequisition.findByExpectedDate", query = "SELECT s FROM SiteTransferRequisition s WHERE s.expectedDate = :expectedDate"),
    @NamedQuery(name = "SiteTransferRequisition.findByRequisitionedBy", query = "SELECT s FROM SiteTransferRequisition s WHERE s.requisitionedBy = :requisitionedBy")})
public class SiteTransferRequisition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "expected_date")
    @Temporal(TemporalType.DATE)
    private Date expectedDate;
    @Size(max = 45)
    @Column(name = "requisitioned_by")
    private String requisitionedBy;
    @Lob
    @Size(max = 65535)
    @Column(name = "remarks")
    private String remarks;
   
    @JoinColumn(name = "ApproveMaterialRequisitionId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ApproveMaterialsRequisiton approveMaterialsRequisitonId;
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unitId;
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Material materialId;

    public SiteTransferRequisition() {
    }

    public SiteTransferRequisition(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public String getRequisitionedBy() {
        return requisitionedBy;
    }

    public void setRequisitionedBy(String requisitionedBy) {
        this.requisitionedBy = requisitionedBy;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public ApproveMaterialsRequisiton getApproveMaterialsRequisitonId() {
        return approveMaterialsRequisitonId;
    }

    public void setApproveMaterialsRequisitonId(ApproveMaterialsRequisiton approveMaterialsRequisitonId) {
        this.approveMaterialsRequisitonId = approveMaterialsRequisitonId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SiteTransferRequisition)) {
            return false;
        }
        SiteTransferRequisition other = (SiteTransferRequisition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.SiteTransferRequisition[ id=" + id + " ]";
    }
    
}
