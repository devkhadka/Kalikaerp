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
@Table(name = "maintenance_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaintenanceDetails.findAll", query = "SELECT m FROM MaintenanceDetails m"),
    @NamedQuery(name = "MaintenanceDetails.findById", query = "SELECT m FROM MaintenanceDetails m WHERE m.id = :id"),
    @NamedQuery(name = "MaintenanceDetails.findByMaterialId", query = "SELECT m FROM MaintenanceDetails m WHERE m.materialId = :materialId"),
    @NamedQuery(name = "MaintenanceDetails.findByQuantity", query = "SELECT m FROM MaintenanceDetails m WHERE m.quantity = :quantity"),
    @NamedQuery(name = "MaintenanceDetails.findByRemarks", query = "SELECT m FROM MaintenanceDetails m WHERE m.remarks = :remarks"),
    @NamedQuery(name = "MaintenanceDetails.findByMaterialName", query = "SELECT m FROM MaintenanceDetails m WHERE m.materialName = :materialName")})
public class MaintenanceDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "material_id")
    private Integer materialId;
    @Size(max = 45)
    @Column(name = "quantity")
    private String quantity;
    @Size(max = 45)
    @Column(name = "remarks")
    private String remarks;
    @Size(max = 45)
    @Column(name = "material_name")
    private String materialName;
    @JoinColumn(name = "scheduled_maintenances_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MaintenanceSchedules scheduledMaintenancesId;

    public MaintenanceDetails() {
    }

    public MaintenanceDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public MaintenanceSchedules getScheduledMaintenancesId() {
        return scheduledMaintenancesId;
    }

    public void setScheduledMaintenancesId(MaintenanceSchedules scheduledMaintenancesId) {
        this.scheduledMaintenancesId = scheduledMaintenancesId;
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
        if (!(object instanceof MaintenanceDetails)) {
            return false;
        }
        MaintenanceDetails other = (MaintenanceDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.MaintenanceDetails[ id=" + id + " ]";
    }
    
}
