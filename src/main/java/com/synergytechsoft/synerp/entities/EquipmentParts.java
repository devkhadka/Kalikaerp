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
@Table(name = "equipment_parts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipmentParts.findAll", query = "SELECT e FROM EquipmentParts e"),
    @NamedQuery(name = "EquipmentParts.findById", query = "SELECT e FROM EquipmentParts e WHERE e.id = :id"),
    @NamedQuery(name = "EquipmentParts.findByName", query = "SELECT e FROM EquipmentParts e WHERE e.name = :name"),
    @NamedQuery(name = "EquipmentParts.findByModelNumber", query = "SELECT e FROM EquipmentParts e WHERE e.modelNumber = :modelNumber"),
    @NamedQuery(name = "EquipmentParts.findByRemarks", query = "SELECT e FROM EquipmentParts e WHERE e.remarks = :remarks"),
    @NamedQuery(name = "EquipmentParts.findByUsage", query = "SELECT e FROM EquipmentParts e WHERE e.usage = :usage"),
    @NamedQuery(name = "EquipmentParts.findByDescription", query = "SELECT e FROM EquipmentParts e WHERE e.description = :description"),
    @NamedQuery(name = "EquipmentParts.findByQuantity", query = "SELECT e FROM EquipmentParts e WHERE e.quantity = :quantity")})
public class EquipmentParts implements Serializable {
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
    @Column(name = "model_number")
    private String modelNumber;
    @Size(max = 45)
    @Column(name = "remarks")
    private String remarks;
    @Size(max = 45)
    @Column(name = "usages")
    private String usage;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Column(name = "quantity")
    private Integer quantity;
    @ManyToMany(mappedBy = "equipmentPartsCollection")
    private Collection<EquipmentCategory> equipmentCategoryCollection;
    @ManyToMany(mappedBy = "equipmentPartsCollection")
    private Collection<Equipment> equipmentCollection;

    public EquipmentParts() {
    }

    public EquipmentParts(Integer id) {
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

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @XmlTransient
    public Collection<EquipmentCategory> getEquipmentCategoryCollection() {
        return equipmentCategoryCollection;
    }

    public void setEquipmentCategoryCollection(Collection<EquipmentCategory> equipmentCategoryCollection) {
        this.equipmentCategoryCollection = equipmentCategoryCollection;
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
        if (!(object instanceof EquipmentParts)) {
            return false;
        }
        EquipmentParts other = (EquipmentParts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + "";
    }
    
}
