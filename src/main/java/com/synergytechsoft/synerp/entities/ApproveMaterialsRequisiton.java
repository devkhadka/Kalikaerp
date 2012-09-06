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
@Table(name = "approve_materials_requisiton")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApproveMaterialsRequisiton.findAll", query = "SELECT a FROM ApproveMaterialsRequisiton a"),
    @NamedQuery(name = "ApproveMaterialsRequisiton.findById", query = "SELECT a FROM ApproveMaterialsRequisiton a WHERE a.id = :id"),
    @NamedQuery(name = "ApproveMaterialsRequisiton.findByApproveQuantity", query = "SELECT a FROM ApproveMaterialsRequisiton a WHERE a.approveQuantity = :approveQuantity"),
    @NamedQuery(name = "ApproveMaterialsRequisiton.findByIssueCompleted", query = "SELECT a FROM ApproveMaterialsRequisiton a WHERE a.issueCompleted = :issueCompleted"),
    @NamedQuery(name = "ApproveMaterialsRequisiton.findByRejectQuantity", query = "SELECT a FROM ApproveMaterialsRequisiton a WHERE a.rejectQuantity = :rejectQuantity")})
public class ApproveMaterialsRequisiton implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "approve_quantity")
    private Double approveQuantity;
    @Column(name = "issue_completed")
    private Integer issueCompleted;
    @Column(name = "reject_quantity")
    private Double rejectQuantity;
    @Lob
    @Size(max = 65535)
    @Column(name = "reasons_of_rejection")
    private String reasonsOfRejection;
    @OneToMany(mappedBy = "approveMaterialsRequisitonId")
    private Collection<GoodsOutDetail> goodsOutDetailCollection;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "approvePurchaseRequestMaterialId")
    private Collection<ProcessApprovedRequisitions> processApprovedRequisitionsCollection;
    @OneToMany(cascade= CascadeType.ALL,mappedBy="approveMaterialsRequisitonId")
    private Collection<SiteTransferRequisition> siteTransferRequisitionsCollection;
    @LazyCollection(LazyCollectionOption.FALSE)    
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unitId;
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "requisition_delivery_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RequisitionDelivery requisitionDeliveryId;
    @Transient
    private ProcessApprovedRequisitions processApprovedRequisitions;
    public ApproveMaterialsRequisiton() {
    }

    public ApproveMaterialsRequisiton(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getApproveQuantity() {
        return approveQuantity;
    }

    public void setApproveQuantity(Double approveQuantity) {
        this.approveQuantity = approveQuantity;
    }

    public Integer getIssueCompleted() {
        return issueCompleted;
    }

    public void setIssueCompleted(Integer issueCompleted) {
        this.issueCompleted = issueCompleted;
    }

    public Double getRejectQuantity() {
        return rejectQuantity;
    }

    public void setRejectQuantity(Double rejectQuantity) {
        this.rejectQuantity = rejectQuantity;
    }

    public String getReasonsOfRejection() {
        return reasonsOfRejection;
    }

    public void setReasonsOfRejection(String reasonsOfRejection) {
        this.reasonsOfRejection = reasonsOfRejection;
    }

    @XmlTransient
    public Collection<GoodsOutDetail> getGoodsOutDetailCollection() {
        return goodsOutDetailCollection;
    }

    public void setGoodsOutDetailCollection(Collection<GoodsOutDetail> goodsOutDetailCollection) {
        this.goodsOutDetailCollection = goodsOutDetailCollection;
    }

    @XmlTransient
    public Collection<ProcessApprovedRequisitions> getProcessApprovedRequisitionsCollection() {
        return processApprovedRequisitionsCollection;
    }

    public void setProcessApprovedRequisitionsCollection(Collection<ProcessApprovedRequisitions> processApprovedRequisitionsCollection) {
        this.processApprovedRequisitionsCollection = processApprovedRequisitionsCollection;
    }

    public Collection<SiteTransferRequisition> getSiteTransferRequisitionsCollection() {
        return siteTransferRequisitionsCollection;
    }

    public void setSiteTransferRequisitionsCollection(Collection<SiteTransferRequisition> siteTransferRequisitionsCollection) {
        this.siteTransferRequisitionsCollection = siteTransferRequisitionsCollection;
    }

   

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }

    public RequisitionDelivery getRequisitionDeliveryId() {
        return requisitionDeliveryId;
    }

    public void setRequisitionDeliveryId(RequisitionDelivery requisitionDeliveryId) {
        this.requisitionDeliveryId = requisitionDeliveryId;
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
        if (!(object instanceof ApproveMaterialsRequisiton)) {
            return false;
        }
        ApproveMaterialsRequisiton other = (ApproveMaterialsRequisiton) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  id.toString();
    }
     public void createProcess() {
        if (processApprovedRequisitions == null) {
            processApprovedRequisitions = new ProcessApprovedRequisitions();
        }
        if (!getProcessApprovedRequisitionsCollection().contains(processApprovedRequisitions)) {
            this.getProcessApprovedRequisitionsCollection().add(processApprovedRequisitions);
            processApprovedRequisitions.setApprovePurchaseRequestMaterialId(this);
        }
       
    }
    public ProcessApprovedRequisitions getNewProcess(){
        this.createProcess();
        return processApprovedRequisitions;
    }
}
