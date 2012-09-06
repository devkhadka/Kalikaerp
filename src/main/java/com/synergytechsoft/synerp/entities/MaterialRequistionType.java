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

/**
 *
 * @author dev
 */
@Entity
@Table(name = "material_requistion_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialRequistionType.findAll", query = "SELECT m FROM MaterialRequistionType m"),
    @NamedQuery(name = "MaterialRequistionType.findById", query = "SELECT m FROM MaterialRequistionType m WHERE m.id = :id"),
    @NamedQuery(name = "MaterialRequistionType.findByName", query = "SELECT m FROM MaterialRequistionType m WHERE m.name = :name"),
    @NamedQuery(name = "MaterialRequistionType.findByDescription", query = "SELECT m FROM MaterialRequistionType m WHERE m.description = :description")})
public class MaterialRequistionType implements Serializable {
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
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialRequistionTypeId")
    private Collection<MaterialRequisition> materialRequisitionCollection;

    public MaterialRequistionType() {
    }

    public MaterialRequistionType(Integer id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<MaterialRequisition> getMaterialRequisitionCollection() {
        return materialRequisitionCollection;
    }

    public void setMaterialRequisitionCollection(Collection<MaterialRequisition> materialRequisitionCollection) {
        this.materialRequisitionCollection = materialRequisitionCollection;
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
        if (!(object instanceof MaterialRequistionType)) {
            return false;
        }
        MaterialRequistionType other = (MaterialRequistionType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.MaterialRequistionType[ id=" + id + " ]";
    }
    
}
