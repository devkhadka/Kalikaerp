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
@Table(name = "maintenance_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaintenanceDetail.findAll", query = "SELECT m FROM MaintenanceDetail m"),
    @NamedQuery(name = "MaintenanceDetail.findById", query = "SELECT m FROM MaintenanceDetail m WHERE m.id = :id")})
public class MaintenanceDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maintenanceDetailId")
    private Collection<MaintenanceFineDetails> maintenanceFineDetailsCollection;
    @JoinColumn(name = "equipment_maintenance_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EquipmentMaintenance equipmentMaintenanceId;
    @JoinColumn(name = "repair_order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RepairOrder repairOrderId;

    public MaintenanceDetail() {
    }

    public MaintenanceDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<MaintenanceFineDetails> getMaintenanceFineDetailsCollection() {
        return maintenanceFineDetailsCollection;
    }

    public void setMaintenanceFineDetailsCollection(Collection<MaintenanceFineDetails> maintenanceFineDetailsCollection) {
        this.maintenanceFineDetailsCollection = maintenanceFineDetailsCollection;
    }

    public EquipmentMaintenance getEquipmentMaintenanceId() {
        return equipmentMaintenanceId;
    }

    public void setEquipmentMaintenanceId(EquipmentMaintenance equipmentMaintenanceId) {
        this.equipmentMaintenanceId = equipmentMaintenanceId;
    }

    public RepairOrder getRepairOrderId() {
        return repairOrderId;
    }

    public void setRepairOrderId(RepairOrder repairOrderId) {
        this.repairOrderId = repairOrderId;
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
        if (!(object instanceof MaintenanceDetail)) {
            return false;
        }
        MaintenanceDetail other = (MaintenanceDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.MaintenanceDetail[ id=" + id + " ]";
    }
    
}
