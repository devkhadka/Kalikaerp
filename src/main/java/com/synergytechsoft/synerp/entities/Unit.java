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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "unit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unit.findAll", query = "SELECT u FROM Unit u"),
    @NamedQuery(name = "Unit.findById", query = "SELECT u FROM Unit u WHERE u.id = :id"),
    @NamedQuery(name = "Unit.findByName", query = "SELECT u FROM Unit u WHERE u.name = :name"),
    @NamedQuery(name = "Unit.findByIsDefault", query = "SELECT u FROM Unit u WHERE u.isDefault = :isDefault"),
    @NamedQuery(name = "Unit.findByConversionFactor", query = "SELECT u FROM Unit u WHERE u.conversionFactor = :conversionFactor")})
public class Unit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "is_default")
    private Boolean isDefault;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "conversion_factor")
    private Double conversionFactor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitId")
    private Collection<PurchaseRequestMaterial> purchaseRequestMaterialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitIdRejected")
    private Collection<ApproveSiteTransfer> approveSiteTransferCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitIdApproved")
    private Collection<ApproveSiteTransfer> approveSiteTransferCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitId")
    private Collection<PurchaseOrderDetails> purchaseOrderDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitId")
    private Collection<GoodsOutLocation> goodsOutLocationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitId")
    private Collection<IssueFuelNFluidSlip> issueFuelNFluidSlipCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitId")
    private Collection<StoreInDetail> storeInDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitId")
    private Collection<ApproveMaterialsRequisiton> approveMaterialsRequisitonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitId")
    private Collection<StockLocation> stockLocationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitId")
    private Collection<SiteTransferRequisition> siteTransferRequisitionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitId")
    private Collection<StockAdjustment> stockAdjustmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitId")
    private Collection<StoreIn> storeInCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitId")
    private Collection<SiteTransferDetails> siteTransferDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitIdDamaged")
    private Collection<StoreReceiveFineDetails> storeReceiveFineDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitIdReceived")
    private Collection<StoreReceiveFineDetails> storeReceiveFineDetailsCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitIdChallan")
    private Collection<StoreReceiveFineDetails> storeReceiveFineDetailsCollection2;
    @OneToMany(mappedBy = "defaultUnitId")
    private Collection<UnitGroup> unitGroupCollection;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitId")
    private Collection<ApprovePurchaseRequestMaterial> approvePurchaseRequestMaterialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitId")
    private Collection<RequisitionRejection> requisitionRejectionCollection;
    @JoinColumn(name = "unit_group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UnitGroup unitGroupId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitId")
    private Collection<RejectPurchaseRequest> rejectPurchaseRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitId")
    private Collection<LocalPurchase> localPurchaseCollection;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitId")
    private Collection<RequisitionDelivery> requisitionDeliveryCollection;

 
    public Unit() {
    }

    public Unit(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Double getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(Double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @XmlTransient
    public Collection<PurchaseRequestMaterial> getPurchaseRequestMaterialCollection() {
        return purchaseRequestMaterialCollection;
    }

    public void setPurchaseRequestMaterialCollection(Collection<PurchaseRequestMaterial> purchaseRequestMaterialCollection) {
        this.purchaseRequestMaterialCollection = purchaseRequestMaterialCollection;
    }

    @XmlTransient
    public Collection<ApproveSiteTransfer> getApproveSiteTransferCollection() {
        return approveSiteTransferCollection;
    }

    public void setApproveSiteTransferCollection(Collection<ApproveSiteTransfer> approveSiteTransferCollection) {
        this.approveSiteTransferCollection = approveSiteTransferCollection;
    }

    @XmlTransient
    public Collection<ApproveSiteTransfer> getApproveSiteTransferCollection1() {
        return approveSiteTransferCollection1;
    }

    public void setApproveSiteTransferCollection1(Collection<ApproveSiteTransfer> approveSiteTransferCollection1) {
        this.approveSiteTransferCollection1 = approveSiteTransferCollection1;
    }

    @XmlTransient
    public Collection<PurchaseOrderDetails> getPurchaseOrderDetailsCollection() {
        return purchaseOrderDetailsCollection;
    }

    public void setPurchaseOrderDetailsCollection(Collection<PurchaseOrderDetails> purchaseOrderDetailsCollection) {
        this.purchaseOrderDetailsCollection = purchaseOrderDetailsCollection;
    }

    @XmlTransient
    public Collection<GoodsOutLocation> getGoodsOutLocationCollection() {
        return goodsOutLocationCollection;
    }

    public void setGoodsOutLocationCollection(Collection<GoodsOutLocation> goodsOutLocationCollection) {
        this.goodsOutLocationCollection = goodsOutLocationCollection;
    }

    @XmlTransient
    public Collection<IssueFuelNFluidSlip> getIssueFuelNFluidSlipCollection() {
        return issueFuelNFluidSlipCollection;
    }

    public void setIssueFuelNFluidSlipCollection(Collection<IssueFuelNFluidSlip> issueFuelNFluidSlipCollection) {
        this.issueFuelNFluidSlipCollection = issueFuelNFluidSlipCollection;
    }

    @XmlTransient
    public Collection<StoreInDetail> getStoreInDetailCollection() {
        return storeInDetailCollection;
    }

    public void setStoreInDetailCollection(Collection<StoreInDetail> storeInDetailCollection) {
        this.storeInDetailCollection = storeInDetailCollection;
    }

    @XmlTransient
    public Collection<ApproveMaterialsRequisiton> getApproveMaterialsRequisitonCollection() {
        return approveMaterialsRequisitonCollection;
    }

    public void setApproveMaterialsRequisitonCollection(Collection<ApproveMaterialsRequisiton> approveMaterialsRequisitonCollection) {
        this.approveMaterialsRequisitonCollection = approveMaterialsRequisitonCollection;
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

    @XmlTransient
    public Collection<StoreReceiveFineDetails> getStoreReceiveFineDetailsCollection1() {
        return storeReceiveFineDetailsCollection1;
    }

    public void setStoreReceiveFineDetailsCollection1(Collection<StoreReceiveFineDetails> storeReceiveFineDetailsCollection1) {
        this.storeReceiveFineDetailsCollection1 = storeReceiveFineDetailsCollection1;
    }

    @XmlTransient
    public Collection<StoreReceiveFineDetails> getStoreReceiveFineDetailsCollection2() {
        return storeReceiveFineDetailsCollection2;
    }

    public void setStoreReceiveFineDetailsCollection2(Collection<StoreReceiveFineDetails> storeReceiveFineDetailsCollection2) {
        this.storeReceiveFineDetailsCollection2 = storeReceiveFineDetailsCollection2;
    }

    @XmlTransient
    public Collection<UnitGroup> getUnitGroupCollection() {
        return unitGroupCollection;
    }

    public void setUnitGroupCollection(Collection<UnitGroup> unitGroupCollection) {
        this.unitGroupCollection = unitGroupCollection;
    }

    @XmlTransient
    public Collection<ApprovePurchaseRequestMaterial> getApprovePurchaseRequestMaterialCollection() {
        return approvePurchaseRequestMaterialCollection;
    }

    public void setApprovePurchaseRequestMaterialCollection(Collection<ApprovePurchaseRequestMaterial> approvePurchaseRequestMaterialCollection) {
        this.approvePurchaseRequestMaterialCollection = approvePurchaseRequestMaterialCollection;
    }

    @XmlTransient
    public Collection<RequisitionRejection> getRequisitionRejectionCollection() {
        return requisitionRejectionCollection;
    }

    public void setRequisitionRejectionCollection(Collection<RequisitionRejection> requisitionRejectionCollection) {
        this.requisitionRejectionCollection = requisitionRejectionCollection;
    }

    public UnitGroup getUnitGroupId() {
        return unitGroupId;
    }

    public void setUnitGroupId(UnitGroup unitGroupId) {
        this.unitGroupId = unitGroupId;
    }

    @XmlTransient
    public Collection<RejectPurchaseRequest> getRejectPurchaseRequestCollection() {
        return rejectPurchaseRequestCollection;
    }

    public void setRejectPurchaseRequestCollection(Collection<RejectPurchaseRequest> rejectPurchaseRequestCollection) {
        this.rejectPurchaseRequestCollection = rejectPurchaseRequestCollection;
    }

    @XmlTransient
    public Collection<LocalPurchase> getLocalPurchaseCollection() {
        return localPurchaseCollection;
    }

    public void setLocalPurchaseCollection(Collection<LocalPurchase> localPurchaseCollection) {
        this.localPurchaseCollection = localPurchaseCollection;
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
        if (!(object instanceof Unit)) {
            return false;
        }
        Unit other = (Unit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
@XmlTransient
    public Collection<RequisitionDelivery> getRequisitionDeliveryCollection() {
        return requisitionDeliveryCollection;
    }

    public void setRequisitionDeliveryCollection(Collection<RequisitionDelivery> requisitionDeliveryCollection) {
        this.requisitionDeliveryCollection = requisitionDeliveryCollection;
    }
    

    @Override
    public String toString() {
        return "Unit[ id=" + id + " ]";

    }
    
}
