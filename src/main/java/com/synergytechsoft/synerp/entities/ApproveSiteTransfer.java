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
@Table(name = "approve_site_transfer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApproveSiteTransfer.findAll", query = "SELECT a FROM ApproveSiteTransfer a"),
    @NamedQuery(name = "ApproveSiteTransfer.findById", query = "SELECT a FROM ApproveSiteTransfer a WHERE a.id = :id"),
    @NamedQuery(name = "ApproveSiteTransfer.findByApprovedQuantity", query = "SELECT a FROM ApproveSiteTransfer a WHERE a.approvedQuantity = :approvedQuantity"),
    @NamedQuery(name = "ApproveSiteTransfer.findByRejectedQuantity", query = "SELECT a FROM ApproveSiteTransfer a WHERE a.rejectedQuantity = :rejectedQuantity")})
public class ApproveSiteTransfer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "approved_quantity")
    private Double approvedQuantity;
    @Column(name = "rejected_quantity")
    private Double rejectedQuantity;
    @Lob
    @Size(max = 65535)
    @Column(name = "remarks")
    private String remarks;
    @OneToMany(mappedBy = "approveSiteTransferId")
    private Collection<GoodsOutDetail> goodsOutDetailCollection;
    @JoinColumn(name = "site_transfer_details_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SiteTransferDetails siteTransferDetailsId;
    @JoinColumn(name = "unit_id_rejected", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unitIdRejected;
    @JoinColumn(name = "unit_id_approved", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unitIdApproved;

    public ApproveSiteTransfer() {
    }

    public ApproveSiteTransfer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getApprovedQuantity() {
        return approvedQuantity;
    }

    public void setApprovedQuantity(Double approvedQuantity) {
        this.approvedQuantity = approvedQuantity;
    }

    public Double getRejectedQuantity() {
        return rejectedQuantity;
    }

    public void setRejectedQuantity(Double rejectedQuantity) {
        this.rejectedQuantity = rejectedQuantity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @XmlTransient
    public Collection<GoodsOutDetail> getGoodsOutDetailCollection() {
        return goodsOutDetailCollection;
    }

    public void setGoodsOutDetailCollection(Collection<GoodsOutDetail> goodsOutDetailCollection) {
        this.goodsOutDetailCollection = goodsOutDetailCollection;
    }

    public SiteTransferDetails getSiteTransferDetailsId() {
        return siteTransferDetailsId;
    }

    public void setSiteTransferDetailsId(SiteTransferDetails siteTransferDetailsId) {
        this.siteTransferDetailsId = siteTransferDetailsId;
    }

    public Unit getUnitIdRejected() {
        return unitIdRejected;
    }

    public void setUnitIdRejected(Unit unitIdRejected) {
        this.unitIdRejected = unitIdRejected;
    }

    public Unit getUnitIdApproved() {
        return unitIdApproved;
    }

    public void setUnitIdApproved(Unit unitIdApproved) {
        this.unitIdApproved = unitIdApproved;
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
        if (!(object instanceof ApproveSiteTransfer)) {
            return false;
        }
        ApproveSiteTransfer other = (ApproveSiteTransfer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.ApproveSiteTransfer[ id=" + id + " ]";
    }
    
}
