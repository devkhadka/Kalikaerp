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
@Table(name = "requistion_material_project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequistionMaterialProject.findAll", query = "SELECT r FROM RequistionMaterialProject r"),
    @NamedQuery(name = "RequistionMaterialProject.findById", query = "SELECT r FROM RequistionMaterialProject r WHERE r.id = :id")})
public class RequistionMaterialProject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Project projectId;
    @JoinColumn(name = "requisition_material_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RequisitionMaterial requisitionMaterialId;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requistionMaterialProjectId")
    private Collection<RequisitionMaterialActivity> requisitionMaterialActivityCollection;

    public RequistionMaterialProject() {
        projectId=new Project();
    }

    public RequistionMaterialProject(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public RequisitionMaterial getRequisitionMaterialId() {
        return requisitionMaterialId;
    }

    public void setRequisitionMaterialId(RequisitionMaterial requisitionMaterialId) {
        this.requisitionMaterialId = requisitionMaterialId;
    }

    @XmlTransient
    public Collection<RequisitionMaterialActivity> getRequisitionMaterialActivityCollection() {
        if(requisitionMaterialActivityCollection==null){
            requisitionMaterialActivityCollection=new ArrayList<RequisitionMaterialActivity>();
        }
        return requisitionMaterialActivityCollection;
    }

    public void setRequisitionMaterialActivityCollection(Collection<RequisitionMaterialActivity> requisitionMaterialActivityCollection) {
        this.requisitionMaterialActivityCollection = requisitionMaterialActivityCollection;
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
        if (!(object instanceof RequistionMaterialProject)) {
            return false;
        }
        RequistionMaterialProject other = (RequistionMaterialProject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getProjectId().getName();
    }
    public void addRequistionMaterialActivity(RequisitionMaterialActivity ra){
        this.getRequisitionMaterialActivityCollection().add(ra);
        ra.setRequistionMaterialProjectId(this);
}
}
