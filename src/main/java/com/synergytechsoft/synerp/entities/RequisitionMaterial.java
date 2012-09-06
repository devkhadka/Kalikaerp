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
@Table(name = "requisition_material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequisitionMaterial.findAll", query = "SELECT r FROM RequisitionMaterial r"),
    @NamedQuery(name = "RequisitionMaterial.findById", query = "SELECT r FROM RequisitionMaterial r WHERE r.id = :id")})
public class RequisitionMaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitionMaterialId")
    private Collection<RequistionMaterialProject> requistionMaterialProjectCollection;
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Material materialId;
    @JoinColumn(name = "material_requisition_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MaterialRequisition materialRequisitionId;

    public RequisitionMaterial() {
       this.materialId=new Material() ;
    }

    public RequisitionMaterial(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<RequistionMaterialProject> getRequistionMaterialProjectCollection() {
        if(requistionMaterialProjectCollection==null){
            requistionMaterialProjectCollection=new ArrayList<RequistionMaterialProject>();
        }
        return requistionMaterialProjectCollection;
    }

    public void setRequistionMaterialProjectCollection(Collection<RequistionMaterialProject> requistionMaterialProjectCollection) {
        this.requistionMaterialProjectCollection = requistionMaterialProjectCollection;
    }

    public Material getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Material materialId) {
        this.materialId = materialId;
    }

    public MaterialRequisition getMaterialRequisitionId() {
        return materialRequisitionId;
    }

    public void setMaterialRequisitionId(MaterialRequisition materialRequisitionId) {
        this.materialRequisitionId = materialRequisitionId;
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
        if (!(object instanceof RequisitionMaterial)) {
            return false;
        }
        RequisitionMaterial other = (RequisitionMaterial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.materialId.getMaterialDerscription();
    }
    public void addRequisitionProject(RequistionMaterialProject p){
        this.getRequistionMaterialProjectCollection().add(p);
        p.setRequisitionMaterialId(this);
    }
    
}
