/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "subcontractor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subcontractor.findAll", query = "SELECT s FROM Subcontractor s"),
    @NamedQuery(name = "Subcontractor.findById", query = "SELECT s FROM Subcontractor s WHERE s.id = :id")})
public class Subcontractor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinTable(name = "subcontractor_has_sub_activity", joinColumns = {
        @JoinColumn(name = "subcontractor_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "sub_activity_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<SubActivity> subActivityCollection;
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Project projectId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subcontractorId")
    private Collection<RequisitionMaterialActivitySubcontractor> requisitionMaterialActivitySubcontractorCollection;

    public Subcontractor() {
    }

    public Subcontractor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<SubActivity> getSubActivityCollection() {
        return subActivityCollection;
    }

    public void setSubActivityCollection(Collection<SubActivity> subActivityCollection) {
        this.subActivityCollection = subActivityCollection;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    @XmlTransient
    public Collection<RequisitionMaterialActivitySubcontractor> getRequisitionMaterialActivitySubcontractorCollection() {
        return requisitionMaterialActivitySubcontractorCollection;
    }

    public void setRequisitionMaterialActivitySubcontractorCollection(Collection<RequisitionMaterialActivitySubcontractor> requisitionMaterialActivitySubcontractorCollection) {
        this.requisitionMaterialActivitySubcontractorCollection = requisitionMaterialActivitySubcontractorCollection;
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
        if (!(object instanceof Subcontractor)) {
            return false;
        }
        Subcontractor other = (Subcontractor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id+ "";
    }
    
}
