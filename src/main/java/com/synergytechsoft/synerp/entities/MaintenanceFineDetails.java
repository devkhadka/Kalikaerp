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
@Table(name = "maintenance_fine_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaintenanceFineDetails.findAll", query = "SELECT m FROM MaintenanceFineDetails m"),
    @NamedQuery(name = "MaintenanceFineDetails.findById", query = "SELECT m FROM MaintenanceFineDetails m WHERE m.id = :id"),
    @NamedQuery(name = "MaintenanceFineDetails.findByDescription", query = "SELECT m FROM MaintenanceFineDetails m WHERE m.description = :description"),
    @NamedQuery(name = "MaintenanceFineDetails.findByHour", query = "SELECT m FROM MaintenanceFineDetails m WHERE m.hour = :hour"),
    @NamedQuery(name = "MaintenanceFineDetails.findByLabourRate", query = "SELECT m FROM MaintenanceFineDetails m WHERE m.labourRate = :labourRate"),
    @NamedQuery(name = "MaintenanceFineDetails.findByOverhead", query = "SELECT m FROM MaintenanceFineDetails m WHERE m.overhead = :overhead")})
public class MaintenanceFineDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Column(name = "hour")
    private Integer hour;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "labour_rate")
    private Double labourRate;
    @Column(name = "overhead")
    private Double overhead;
    @JoinColumn(name = "maintenance_detail_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MaintenanceDetail maintenanceDetailId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maintenanceFineDetailsId")
    private Collection<EquipmentRepairsMaterials> equipmentRepairsMaterialsCollection;

    public MaintenanceFineDetails() {
    }

    public MaintenanceFineDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Double getLabourRate() {
        return labourRate;
    }

    public void setLabourRate(Double labourRate) {
        this.labourRate = labourRate;
    }

    public Double getOverhead() {
        return overhead;
    }

    public void setOverhead(Double overhead) {
        this.overhead = overhead;
    }

    public MaintenanceDetail getMaintenanceDetailId() {
        return maintenanceDetailId;
    }

    public void setMaintenanceDetailId(MaintenanceDetail maintenanceDetailId) {
        this.maintenanceDetailId = maintenanceDetailId;
    }

    @XmlTransient
    public Collection<EquipmentRepairsMaterials> getEquipmentRepairsMaterialsCollection() {
        return equipmentRepairsMaterialsCollection;
    }

    public void setEquipmentRepairsMaterialsCollection(Collection<EquipmentRepairsMaterials> equipmentRepairsMaterialsCollection) {
        this.equipmentRepairsMaterialsCollection = equipmentRepairsMaterialsCollection;
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
        if (!(object instanceof MaintenanceFineDetails)) {
            return false;
        }
        MaintenanceFineDetails other = (MaintenanceFineDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.MaintenanceFineDetails[ id=" + id + " ]";
    }
    
}
