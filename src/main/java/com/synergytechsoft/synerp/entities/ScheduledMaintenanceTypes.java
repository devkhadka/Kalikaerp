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
@Table(name = "scheduled_maintenance_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScheduledMaintenanceTypes.findAll", query = "SELECT s FROM ScheduledMaintenanceTypes s"),
    @NamedQuery(name = "ScheduledMaintenanceTypes.findById", query = "SELECT s FROM ScheduledMaintenanceTypes s WHERE s.id = :id"),
    @NamedQuery(name = "ScheduledMaintenanceTypes.findByName", query = "SELECT s FROM ScheduledMaintenanceTypes s WHERE s.name = :name"),
    @NamedQuery(name = "ScheduledMaintenanceTypes.findByCategory", query = "SELECT s FROM ScheduledMaintenanceTypes s WHERE s.category = :category")})
public class ScheduledMaintenanceTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private Integer category;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scheduledMaintenanceTypesId")
    private Collection<MaintenanceSchedules> maintenanceSchedulesCollection;

    public ScheduledMaintenanceTypes() {
    }

    public ScheduledMaintenanceTypes(Integer id) {
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

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    @XmlTransient
    public Collection<MaintenanceSchedules> getMaintenanceSchedulesCollection() {
        return maintenanceSchedulesCollection;
    }

    public void setMaintenanceSchedulesCollection(Collection<MaintenanceSchedules> maintenanceSchedulesCollection) {
        this.maintenanceSchedulesCollection = maintenanceSchedulesCollection;
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
        if (!(object instanceof ScheduledMaintenanceTypes)) {
            return false;
        }
        ScheduledMaintenanceTypes other = (ScheduledMaintenanceTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.ScheduledMaintenanceTypes[ id=" + id + " ]";
    }
    
}
