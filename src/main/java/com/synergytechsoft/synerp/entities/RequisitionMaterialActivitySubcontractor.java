/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "requisition_material_activity_subcontractor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequisitionMaterialActivitySubcontractor.findAll", query = "SELECT r FROM RequisitionMaterialActivitySubcontractor r"),
    @NamedQuery(name = "RequisitionMaterialActivitySubcontractor.findById", query = "SELECT r FROM RequisitionMaterialActivitySubcontractor r WHERE r.id = :id")})
public class RequisitionMaterialActivitySubcontractor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "requisition_material_activity_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RequisitionMaterialActivity requisitionMaterialActivityId;
    @JoinColumn(name = "subcontractor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Subcontractor subcontractorId;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitionmaterialactivitySubcontractorid")
    private Collection<RequisitionDelivery> requisitionDeliveryCollection;

    public RequisitionMaterialActivitySubcontractor() {
        subcontractorId=new Subcontractor();
    }

    public RequisitionMaterialActivitySubcontractor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RequisitionMaterialActivity getRequisitionMaterialActivityId() {
        return requisitionMaterialActivityId;
    }

    public void setRequisitionMaterialActivityId(RequisitionMaterialActivity requisitionMaterialActivityId) {
        this.requisitionMaterialActivityId = requisitionMaterialActivityId;
    }

    public Subcontractor getSubcontractorId() {
        return subcontractorId;
    }

    public void setSubcontractorId(Subcontractor subcontractorId) {
        this.subcontractorId = subcontractorId;
    }

    @XmlTransient
    public Collection<RequisitionDelivery> getRequisitionDeliveryCollection() {
        if(requisitionDeliveryCollection==null){
            requisitionDeliveryCollection=new ArrayList<RequisitionDelivery>();
        }
        return requisitionDeliveryCollection;
    }

    public void setRequisitionDeliveryCollection(Collection<RequisitionDelivery> requisitionDeliveryCollection) {
        this.requisitionDeliveryCollection = requisitionDeliveryCollection;
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
        if (!(object instanceof RequisitionMaterialActivitySubcontractor)) {
            return false;
        }
        RequisitionMaterialActivitySubcontractor other = (RequisitionMaterialActivitySubcontractor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.subcontractorId+"";
    }
    public void addRequisitionDeliveryDate(RequisitionDelivery rd){
        this.getRequisitionDeliveryCollection().add(rd);
        rd.setRequisitionmaterialactivitySubcontractorid(this);
    }
    
}
