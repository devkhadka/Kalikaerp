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
@Table(name = "requisition_delivery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequisitionDelivery.findAll", query = "SELECT r FROM RequisitionDelivery r"),
    @NamedQuery(name = "RequisitionDelivery.findById", query = "SELECT r FROM RequisitionDelivery r WHERE r.id = :id"),
    @NamedQuery(name = "RequisitionDelivery.findByDeliveryDate", query = "SELECT r FROM RequisitionDelivery r WHERE r.deliveryDate = :deliveryDate"),
    @NamedQuery(name = "RequisitionDelivery.findByRequestProcessDate", query = "SELECT r FROM RequisitionDelivery r WHERE r.requestProcessDate = :requestProcessDate"),
    @NamedQuery(name = "RequisitionDelivery.findByQuantity", query = "SELECT r FROM RequisitionDelivery r WHERE r.quantity = :quantity"),
    @NamedQuery(name = "RequisitionDelivery.findByPending", query = "SELECT r FROM RequisitionDelivery r WHERE r.pending = :pending")})
public class RequisitionDelivery implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "delivery_date")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;
    @Column(name = "request_process_date")
    @Temporal(TemporalType.DATE)
    private Date requestProcessDate;
    @Size(max = 45)
    @Column(name = "quantity")
    private String quantity;
      
    @Column(name = "pending")
    private Integer pending;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitionDeliveryId")
    private Collection<ApproveMaterialsRequisiton> approveMaterialsRequisitonCollection;
    @JoinColumn(name = "requisition_material_activity_Subcontractor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RequisitionMaterialActivitySubcontractor requisitionmaterialactivitySubcontractorid;
     @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitionDeliveryId")
    private Collection<RequisitionRejection> requisitionRejectionCollection;
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "unit_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Unit unitId;
    @Transient
    private ApproveMaterialsRequisiton approveMaterialsRequisiton;
  

    public RequisitionDelivery() {
    }

    public RequisitionDelivery(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getRequestProcessDate() {
        return requestProcessDate;
    }

    public void setRequestProcessDate(Date requestProcessDate) {
        this.requestProcessDate = requestProcessDate;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Integer getPending() {
        return pending;
    }

    public void setPending(Integer pending) {
        this.pending = pending;
    }

    @XmlTransient
    public Collection<ApproveMaterialsRequisiton> getApproveMaterialsRequisitonCollection() {
        return approveMaterialsRequisitonCollection;
    }

    public void setApproveMaterialsRequisitonCollection(Collection<ApproveMaterialsRequisiton> approveMaterialsRequisitonCollection) {
        this.approveMaterialsRequisitonCollection = approveMaterialsRequisitonCollection;
    }

    public RequisitionMaterialActivitySubcontractor getRequisitionmaterialactivitySubcontractorid() {
        return requisitionmaterialactivitySubcontractorid;
    }

    public void setRequisitionmaterialactivitySubcontractorid(RequisitionMaterialActivitySubcontractor requisitionmaterialactivitySubcontractorid) {
        this.requisitionmaterialactivitySubcontractorid = requisitionmaterialactivitySubcontractorid;
    }

    @XmlTransient
    public Collection<RequisitionRejection> getRequisitionRejectionCollection() {
        return requisitionRejectionCollection;
    }

    public void setRequisitionRejectionCollection(Collection<RequisitionRejection> requisitionRejectionCollection) {
        this.requisitionRejectionCollection = requisitionRejectionCollection;
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
        if (!(object instanceof RequisitionDelivery)) {
            return false;
        }
        RequisitionDelivery other = (RequisitionDelivery) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.id+"";
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }
    
    
    public void createNew() {
        if (approveMaterialsRequisiton == null || hasAnyIdNull()) {
            approveMaterialsRequisiton = new ApproveMaterialsRequisiton();
}
        if (!getApproveMaterialsRequisitonCollection().contains(approveMaterialsRequisiton) && hasAnyIdNull()) {
            this.getApproveMaterialsRequisitonCollection().add(approveMaterialsRequisiton);
            approveMaterialsRequisiton.setRequisitionDeliveryId(this);
        }
       
    }

    public ApproveMaterialsRequisiton getNewArmc() {
        
        this.createNew();
        
        return approveMaterialsRequisiton;
        
        
    }
    private boolean hasNewApprovals(){
        for(ApproveMaterialsRequisiton a: getApproveMaterialsRequisitonCollection()){
            if(a.getId()==null)
                return true;
        }
        return false;
    }
    private boolean hasAnyIdNull(){
        boolean b=true;
        for(ApproveMaterialsRequisiton a: getApproveMaterialsRequisitonCollection()){
            
            if(a.getId()==null){
                b=false;
            }
        }
        return b;
    }
    
     
    
}
