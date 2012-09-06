/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
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
@Table(name = "material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m"),
    @NamedQuery(name = "Material.findById", query = "SELECT m FROM Material m WHERE m.id = :id"),
    @NamedQuery(name = "Material.findByMaterialDerscription", query = "SELECT m FROM Material m WHERE m.materialDerscription = :materialDerscription")})
public class Material implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "material_derscription")
    private String materialDerscription;
    @ManyToMany(mappedBy = "materialCollection")
    private Collection<MaterialGroup> materialGroupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialId",fetch= FetchType.EAGER)
    private Set<PurchaseRequestMaterial> purchaseRequestMaterialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialId")
    private Collection<RequisitionMaterial> requisitionMaterialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialId")
    private Collection<IssueFuelNFluidSlip> issueFuelNFluidSlipCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialId")
    private Collection<StockLocation> stockLocationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialId")
    private Collection<SiteTransferRequisition> siteTransferRequisitionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialId")
    private Collection<StockAdjustment> stockAdjustmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialId")
    private Collection<StoreIn> storeInCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialId")
    private Collection<SiteTransferDetails> siteTransferDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialId")
    private Collection<StoreReceiveFineDetails> storeReceiveFineDetailsCollection;
    @JoinColumn(name = "unit_group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UnitGroup unitGroupId;
    @JoinColumn(name = "material_group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MaterialGroup materialGroupId;
    @JoinColumn(name = "material_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MaterialMaster materialMasterId;

    public Material() {
    }

    public Material(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaterialDerscription() {
        return materialDerscription;
    }

    public void setMaterialDerscription(String materialDerscription) {
        this.materialDerscription = materialDerscription;
    }

    @XmlTransient
    public Collection<MaterialGroup> getMaterialGroupCollection() {
        return materialGroupCollection;
    }

    public void setMaterialGroupCollection(Collection<MaterialGroup> materialGroupCollection) {
        this.materialGroupCollection = materialGroupCollection;
    }

    @XmlTransient
    public Set<PurchaseRequestMaterial> getPurchaseRequestMaterialCollection() {
        return purchaseRequestMaterialCollection;
    }

    public void setPurchaseRequestMaterialCollection(Set<PurchaseRequestMaterial> purchaseRequestMaterialCollection) {
        this.purchaseRequestMaterialCollection = purchaseRequestMaterialCollection;
    }

    @XmlTransient
    public Collection<RequisitionMaterial> getRequisitionMaterialCollection() {
        return requisitionMaterialCollection;
    }

    public void setRequisitionMaterialCollection(Collection<RequisitionMaterial> requisitionMaterialCollection) {
        this.requisitionMaterialCollection = requisitionMaterialCollection;
    }

    @XmlTransient
    public Collection<IssueFuelNFluidSlip> getIssueFuelNFluidSlipCollection() {
        return issueFuelNFluidSlipCollection;
    }

    public void setIssueFuelNFluidSlipCollection(Collection<IssueFuelNFluidSlip> issueFuelNFluidSlipCollection) {
        this.issueFuelNFluidSlipCollection = issueFuelNFluidSlipCollection;
    }

    @XmlTransient
    public Collection<StockLocation> getStockLocationCollection() {
        return stockLocationCollection;
    }

    public void setStockLocationCollection(Collection<StockLocation> stockLocationCollection) {
        this.stockLocationCollection = stockLocationCollection;
    }

    @XmlTransient
    public Collection<SiteTransferRequisition> getSiteTransferRequisitionCollection() {
        return siteTransferRequisitionCollection;
    }

    public void setSiteTransferRequisitionCollection(Collection<SiteTransferRequisition> siteTransferRequisitionCollection) {
        this.siteTransferRequisitionCollection = siteTransferRequisitionCollection;
    }

    @XmlTransient
    public Collection<StockAdjustment> getStockAdjustmentCollection() {
        return stockAdjustmentCollection;
    }

    public void setStockAdjustmentCollection(Collection<StockAdjustment> stockAdjustmentCollection) {
        this.stockAdjustmentCollection = stockAdjustmentCollection;
    }

    @XmlTransient
    public Collection<StoreIn> getStoreInCollection() {
        return storeInCollection;
    }

    public void setStoreInCollection(Collection<StoreIn> storeInCollection) {
        this.storeInCollection = storeInCollection;
    }

    @XmlTransient
    public Collection<SiteTransferDetails> getSiteTransferDetailsCollection() {
        return siteTransferDetailsCollection;
    }

    public void setSiteTransferDetailsCollection(Collection<SiteTransferDetails> siteTransferDetailsCollection) {
        this.siteTransferDetailsCollection = siteTransferDetailsCollection;
    }

    @XmlTransient
    public Collection<StoreReceiveFineDetails> getStoreReceiveFineDetailsCollection() {
        return storeReceiveFineDetailsCollection;
    }

    public void setStoreReceiveFineDetailsCollection(Collection<StoreReceiveFineDetails> storeReceiveFineDetailsCollection) {
        this.storeReceiveFineDetailsCollection = storeReceiveFineDetailsCollection;
    }

    public UnitGroup getUnitGroupId() {
        return unitGroupId;
    }

    public void setUnitGroupId(UnitGroup unitGroupId) {
        this.unitGroupId = unitGroupId;
    }

    public MaterialGroup getMaterialGroupId() {
        return materialGroupId;
    }

    public void setMaterialGroupId(MaterialGroup materialGroupId) {
        this.materialGroupId = materialGroupId;
    }

    public MaterialMaster getMaterialMasterId() {
        return materialMasterId;
    }

    public void setMaterialMasterId(MaterialMaster materialMasterId) {
        this.materialMasterId = materialMasterId;
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
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
 return "Material[ id=" + id + " ]";
    }
    
}
