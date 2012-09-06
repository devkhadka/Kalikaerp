/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "equipment_repairs_materials")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipmentRepairsMaterials.findAll", query = "SELECT e FROM EquipmentRepairsMaterials e"),
    @NamedQuery(name = "EquipmentRepairsMaterials.findById", query = "SELECT e FROM EquipmentRepairsMaterials e WHERE e.id = :id"),
    @NamedQuery(name = "EquipmentRepairsMaterials.findByMaterialName", query = "SELECT e FROM EquipmentRepairsMaterials e WHERE e.materialName = :materialName"),
    @NamedQuery(name = "EquipmentRepairsMaterials.findByQuanity", query = "SELECT e FROM EquipmentRepairsMaterials e WHERE e.quanity = :quanity"),
    @NamedQuery(name = "EquipmentRepairsMaterials.findByRate", query = "SELECT e FROM EquipmentRepairsMaterials e WHERE e.rate = :rate")})
public class EquipmentRepairsMaterials implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "material_name")
    private String materialName;
    @Size(max = 45)
    @Column(name = "quanity")
    private String quanity;
    @Size(max = 45)
    @Column(name = "rate")
    private String rate;
    @JoinColumn(name = "maintenance_fine_details_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MaintenanceFineDetails maintenanceFineDetailsId;

    public EquipmentRepairsMaterials() {
    }

    public EquipmentRepairsMaterials(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getQuanity() {
        return quanity;
    }

    public void setQuanity(String quanity) {
        this.quanity = quanity;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public MaintenanceFineDetails getMaintenanceFineDetailsId() {
        return maintenanceFineDetailsId;
    }

    public void setMaintenanceFineDetailsId(MaintenanceFineDetails maintenanceFineDetailsId) {
        this.maintenanceFineDetailsId = maintenanceFineDetailsId;
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
        if (!(object instanceof EquipmentRepairsMaterials)) {
            return false;
        }
        EquipmentRepairsMaterials other = (EquipmentRepairsMaterials) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.EquipmentRepairsMaterials[ id=" + id + " ]";
    }
    
}
