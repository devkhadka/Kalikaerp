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
@Table(name = "material_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialGroup.findAll", query = "SELECT m FROM MaterialGroup m"),
    @NamedQuery(name = "MaterialGroup.findById", query = "SELECT m FROM MaterialGroup m WHERE m.id = :id"),
    @NamedQuery(name = "MaterialGroup.findByName", query = "SELECT m FROM MaterialGroup m WHERE m.name = :name")})
public class MaterialGroup implements Serializable {
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
    @JoinTable(name = "material_group_has_material", joinColumns = {
        @JoinColumn(name = "material_group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "material_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Material> materialCollection;
    @OneToMany(mappedBy = "parentId")
    private Collection<MaterialGroup> materialGroupCollection;
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    @ManyToOne
    private MaterialGroup parentId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialGroupId")
    private Collection<Material> materialCollection1;

    public MaterialGroup() {
    }

    public MaterialGroup(Integer id) {
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

    @XmlTransient
    public Collection<Material> getMaterialCollection() {
        return materialCollection;
    }

    public void setMaterialCollection(Collection<Material> materialCollection) {
        this.materialCollection = materialCollection;
    }

    @XmlTransient
    public Collection<MaterialGroup> getMaterialGroupCollection() {
        return materialGroupCollection;
    }

    public void setMaterialGroupCollection(Collection<MaterialGroup> materialGroupCollection) {
        this.materialGroupCollection = materialGroupCollection;
    }

    public MaterialGroup getParentId() {
        return parentId;
    }

    public void setParentId(MaterialGroup parentId) {
        this.parentId = parentId;
    }

    @XmlTransient
    public Collection<Material> getMaterialCollection1() {
        return materialCollection1;
    }

    public void setMaterialCollection1(Collection<Material> materialCollection1) {
        this.materialCollection1 = materialCollection1;
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
        if (!(object instanceof MaterialGroup)) {
            return false;
        }
        MaterialGroup other = (MaterialGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id.toString();
    }
    
}
