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
@Table(name = "maintenance_schedules")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaintenanceSchedules.findAll", query = "SELECT m FROM MaintenanceSchedules m"),
    @NamedQuery(name = "MaintenanceSchedules.findById", query = "SELECT m FROM MaintenanceSchedules m WHERE m.id = :id"),
    @NamedQuery(name = "MaintenanceSchedules.findByName", query = "SELECT m FROM MaintenanceSchedules m WHERE m.name = :name"),
    @NamedQuery(name = "MaintenanceSchedules.findByScheduledHours", query = "SELECT m FROM MaintenanceSchedules m WHERE m.scheduledHours = :scheduledHours")})
public class MaintenanceSchedules implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "scheduled_hours")
    private Double scheduledHours;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scheduledMaintenancesId")
    private Collection<MaintenanceDetails> maintenanceDetailsCollection;
    @JoinColumn(name = "equipment_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Equipment equipmentId;
    @JoinColumn(name = "scheduled_maintenance_types_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ScheduledMaintenanceTypes scheduledMaintenanceTypesId;

    public MaintenanceSchedules() {
    }

    public MaintenanceSchedules(Integer id) {
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

    public Double getScheduledHours() {
        return scheduledHours;
    }

    public void setScheduledHours(Double scheduledHours) {
        this.scheduledHours = scheduledHours;
    }

    @XmlTransient
    public Collection<MaintenanceDetails> getMaintenanceDetailsCollection() {
        return maintenanceDetailsCollection;
    }

    public void setMaintenanceDetailsCollection(Collection<MaintenanceDetails> maintenanceDetailsCollection) {
        this.maintenanceDetailsCollection = maintenanceDetailsCollection;
    }

    public Equipment getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Equipment equipmentId) {
        this.equipmentId = equipmentId;
    }

    public ScheduledMaintenanceTypes getScheduledMaintenanceTypesId() {
        return scheduledMaintenanceTypesId;
    }

    public void setScheduledMaintenanceTypesId(ScheduledMaintenanceTypes scheduledMaintenanceTypesId) {
        this.scheduledMaintenanceTypesId = scheduledMaintenanceTypesId;
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
        if (!(object instanceof MaintenanceSchedules)) {
            return false;
        }
        MaintenanceSchedules other = (MaintenanceSchedules) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.MaintenanceSchedules[ id=" + id + " ]";
    }
    
}
