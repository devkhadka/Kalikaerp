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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "process_approved_requisitions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcessApprovedRequisitions.findAll", query = "SELECT p FROM ProcessApprovedRequisitions p"),
    @NamedQuery(name = "ProcessApprovedRequisitions.findById", query = "SELECT p FROM ProcessApprovedRequisitions p WHERE p.id = :id"),
    @NamedQuery(name = "ProcessApprovedRequisitions.findByQuantityPO", query = "SELECT p FROM ProcessApprovedRequisitions p WHERE p.quantityPO = :quantityPO"),
    @NamedQuery(name = "ProcessApprovedRequisitions.findByStores", query = "SELECT p FROM ProcessApprovedRequisitions p WHERE p.stores = :stores"),
    @NamedQuery(name = "ProcessApprovedRequisitions.findByQuantityStores", query = "SELECT p FROM ProcessApprovedRequisitions p WHERE p.quantityStores = :quantityStores"),
    @NamedQuery(name = "ProcessApprovedRequisitions.findByQuantityPOunitid", query = "SELECT p FROM ProcessApprovedRequisitions p WHERE p.quantityPOunitid = :quantityPOunitid"),
    @NamedQuery(name = "ProcessApprovedRequisitions.findByQuantityStoresUnitId", query = "SELECT p FROM ProcessApprovedRequisitions p WHERE p.quantityStoresUnitId = :quantityStoresUnitId"),
    @NamedQuery(name = "ProcessApprovedRequisitions.findByProcessedBy", query = "SELECT p FROM ProcessApprovedRequisitions p WHERE p.processedBy = :processedBy"),
    @NamedQuery(name = "ProcessApprovedRequisitions.findByProcessedDate", query = "SELECT p FROM ProcessApprovedRequisitions p WHERE p.processedDate = :processedDate")})
public class ProcessApprovedRequisitions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "quantity_PO")
    private String quantityPO;
    @Size(max = 45)
    @Column(name = "stores")
    private String stores;
    @Size(max = 45)
    @Column(name = "quantity_stores")
    private String quantityStores;
    @Column(name = "quantity_PO_unit_id")
    private String quantityPOunitid;
    @Column(name = "quantity_stores_unit_id")
    private String quantityStoresUnitId;
    @Size(max = 45)
    @Column(name = "processed_by")
    private String processedBy;
    @Column(name = "processed_date")
    @Temporal(TemporalType.DATE)
    private Date processedDate;
    @JoinColumn(name = "approve_purchase_request_material_id", referencedColumnName = "id")
   
    @ManyToOne(optional = false,fetch= FetchType.EAGER, cascade= CascadeType.ALL)
    private ApproveMaterialsRequisiton approvePurchaseRequestMaterialId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processApprovedRequisitionsId")
    private Collection<SiteTransferDetails> siteTransferDetailsCollection;

    public ProcessApprovedRequisitions() {
    }

    public ProcessApprovedRequisitions(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuantityPO() {
        return quantityPO;
    }

    public void setQuantityPO(String quantityPO) {
        this.quantityPO = quantityPO;
    }

    public String getStores() {
        return stores;
    }

    public void setStores(String stores) {
        this.stores = stores;
    }

    public String getQuantityStores() {
        return quantityStores;
    }

    public void setQuantityStores(String quantityStores) {
        this.quantityStores = quantityStores;
    }

    public String getQuantityPOunitid() {
        return quantityPOunitid;
    }

    public void setQuantityPOunitid(String quantityPOunitid) {
        this.quantityPOunitid = quantityPOunitid;
    }

    public String getQuantityStoresUnitId() {
        return quantityStoresUnitId;
    }

    public void setQuantityStoresUnitId(String quantityStoresUnitId) {
        this.quantityStoresUnitId = quantityStoresUnitId;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }

    public Date getProcessedDate() {
        return processedDate;
    }

    public void setProcessedDate(Date processedDate) {
        this.processedDate = processedDate;
    }

    public ApproveMaterialsRequisiton getApprovePurchaseRequestMaterialId() {
        return approvePurchaseRequestMaterialId;
    }

    public void setApprovePurchaseRequestMaterialId(ApproveMaterialsRequisiton approvePurchaseRequestMaterialId) {
        this.approvePurchaseRequestMaterialId = approvePurchaseRequestMaterialId;
    }

    @XmlTransient
    public Collection<SiteTransferDetails> getSiteTransferDetailsCollection() {
        return siteTransferDetailsCollection;
    }

    public void setSiteTransferDetailsCollection(Collection<SiteTransferDetails> siteTransferDetailsCollection) {
        this.siteTransferDetailsCollection = siteTransferDetailsCollection;
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
        if (!(object instanceof ProcessApprovedRequisitions)) {
            return false;
        }
        ProcessApprovedRequisitions other = (ProcessApprovedRequisitions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.ProcessApprovedRequisitions[ id=" + id + " ]";
    }
    
}
