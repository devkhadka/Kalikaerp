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
@Table(name = "equipment_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipmentCategory.findAll", query = "SELECT e FROM EquipmentCategory e"),
    @NamedQuery(name = "EquipmentCategory.findById", query = "SELECT e FROM EquipmentCategory e WHERE e.id = :id"),
    @NamedQuery(name = "EquipmentCategory.findByName", query = "SELECT e FROM EquipmentCategory e WHERE e.name = :name"),
    @NamedQuery(name = "EquipmentCategory.findByDescription", query = "SELECT e FROM EquipmentCategory e WHERE e.description = :description"),
    @NamedQuery(name = "EquipmentCategory.findByParentId", query = "SELECT e FROM EquipmentCategory e WHERE e.parentId = :parentId")})
public class EquipmentCategory implements Serializable {
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
    @Column(name = "parent_id")
    private Integer parentId;
    @JoinTable(name = "equipment_category_has_equipment_parts", joinColumns = {
        @JoinColumn(name = "equipment_category_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "equipment_parts_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<EquipmentParts> equipmentPartsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipmentCategoryId")
    private Collection<Equipment> equipmentCollection;

    public EquipmentCategory() {
    }

    public EquipmentCategory(Integer id) {
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @XmlTransient
    public Collection<EquipmentParts> getEquipmentPartsCollection() {
        return equipmentPartsCollection;
    }

    public void setEquipmentPartsCollection(Collection<EquipmentParts> equipmentPartsCollection) {
        this.equipmentPartsCollection = equipmentPartsCollection;
    }

    @XmlTransient
    public Collection<Equipment> getEquipmentCollection() {
        return equipmentCollection;
    }

    public void setEquipmentCollection(Collection<Equipment> equipmentCollection) {
        this.equipmentCollection = equipmentCollection;
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
        if (!(object instanceof EquipmentCategory)) {
            return false;
        }
        EquipmentCategory other = (EquipmentCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  id + "";
    }
    
}
