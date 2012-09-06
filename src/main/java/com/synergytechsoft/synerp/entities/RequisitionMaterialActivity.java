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
@Table(name = "requisition_material_activity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequisitionMaterialActivity.findAll", query = "SELECT r FROM RequisitionMaterialActivity r"),
    @NamedQuery(name = "RequisitionMaterialActivity.findById", query = "SELECT r FROM RequisitionMaterialActivity r WHERE r.id = :id")})
public class RequisitionMaterialActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitionMaterialActivityId")
    private Collection<RequisitionMaterialActivitySubcontractor> requisitionMaterialActivitySubcontractorCollection;
    @JoinColumn(name = "requistion_material_project_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RequistionMaterialProject requistionMaterialProjectId;
    @JoinColumn(name = "activity_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Activity activityId;

    public RequisitionMaterialActivity() {
    }

    public RequisitionMaterialActivity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<RequisitionMaterialActivitySubcontractor> getRequisitionMaterialActivitySubcontractorCollection() {
        if (requisitionMaterialActivitySubcontractorCollection == null) {
            requisitionMaterialActivitySubcontractorCollection = new ArrayList<RequisitionMaterialActivitySubcontractor>();
        }
        return requisitionMaterialActivitySubcontractorCollection;
    }

    public void setRequisitionMaterialActivitySubcontractorCollection(Collection<RequisitionMaterialActivitySubcontractor> requisitionMaterialActivitySubcontractorCollection) {
        this.requisitionMaterialActivitySubcontractorCollection = requisitionMaterialActivitySubcontractorCollection;
    }

    public RequistionMaterialProject getRequistionMaterialProjectId() {
        return requistionMaterialProjectId;
    }

    public void setRequistionMaterialProjectId(RequistionMaterialProject requistionMaterialProjectId) {
        this.requistionMaterialProjectId = requistionMaterialProjectId;
    }

    public Activity getActivityId() {
        return activityId;
    }

    public void setActivityId(Activity activityId) {
        this.activityId = activityId;
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
        if (!(object instanceof RequisitionMaterialActivity)) {
            return false;
        }
        RequisitionMaterialActivity other = (RequisitionMaterialActivity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if(activityId!=null)
        return this.getActivityId().getName();
        else
            return this.id + "";
    }

    public void addRequisitionMaterialSubcontractor(RequisitionMaterialActivitySubcontractor rmas) {
        this.getRequisitionMaterialActivitySubcontractorCollection().add(rmas);
        rmas.setRequisitionMaterialActivityId(this);
    }
}
