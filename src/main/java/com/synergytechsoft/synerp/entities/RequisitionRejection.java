/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "requisition_rejection")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequisitionRejection.findAll", query = "SELECT r FROM RequisitionRejection r"),
    @NamedQuery(name = "RequisitionRejection.findById", query = "SELECT r FROM RequisitionRejection r WHERE r.id = :id"),
    @NamedQuery(name = "RequisitionRejection.findByRejectedQuantity", query = "SELECT r FROM RequisitionRejection r WHERE r.rejectedQuantity = :rejectedQuantity")})
public class RequisitionRejection implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rejected_quantity")
    private Double rejectedQuantity;
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unitId;
    @JoinColumn(name = "requisition_delivery_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RequisitionDelivery requisitionDeliveryId;

    public RequisitionRejection() {
    }

    public RequisitionRejection(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getRejectedQuantity() {
        return rejectedQuantity;
    }

    public void setRejectedQuantity(Double rejectedQuantity) {
        this.rejectedQuantity = rejectedQuantity;
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
        if (!(object instanceof RequisitionRejection)) {
            return false;
        }
        RequisitionRejection other = (RequisitionRejection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.RequisitionRejection[ id=" + id + " ]";
    }
    
}
