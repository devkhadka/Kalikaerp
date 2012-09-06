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
@Table(name = "repair_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RepairOrder.findAll", query = "SELECT r FROM RepairOrder r"),
    @NamedQuery(name = "RepairOrder.findById", query = "SELECT r FROM RepairOrder r WHERE r.id = :id"),
    @NamedQuery(name = "RepairOrder.findByProblem", query = "SELECT r FROM RepairOrder r WHERE r.problem = :problem"),
    @NamedQuery(name = "RepairOrder.findByEstimatedTime", query = "SELECT r FROM RepairOrder r WHERE r.estimatedTime = :estimatedTime"),
    @NamedQuery(name = "RepairOrder.findByMaterialsRequired", query = "SELECT r FROM RepairOrder r WHERE r.materialsRequired = :materialsRequired"),
    @NamedQuery(name = "RepairOrder.findByEstimatedCost", query = "SELECT r FROM RepairOrder r WHERE r.estimatedCost = :estimatedCost"),
    @NamedQuery(name = "RepairOrder.findByTimeUnit", query = "SELECT r FROM RepairOrder r WHERE r.timeUnit = :timeUnit"),
    @NamedQuery(name = "RepairOrder.findByMechanicName", query = "SELECT r FROM RepairOrder r WHERE r.mechanicName = :mechanicName")})
public class RepairOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "problem")
    private String problem;
    @Column(name = "estimated_time")
    private Integer estimatedTime;
    @Size(max = 255)
    @Column(name = "materials_required")
    private String materialsRequired;
    @Size(max = 45)
    @Column(name = "estimated_cost")
    private String estimatedCost;
    @Column(name = "time_unit")
    private Integer timeUnit;
    @Size(max = 45)
    @Column(name = "mechanic_name")
    private String mechanicName;
    @JoinColumn(name = "equipment_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Equipment equipmentId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "repairOrderId")
    private Collection<MaintenanceDetail> maintenanceDetailCollection;

    public RepairOrder() {
    }

    public RepairOrder(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public Integer getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Integer estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getMaterialsRequired() {
        return materialsRequired;
    }

    public void setMaterialsRequired(String materialsRequired) {
        this.materialsRequired = materialsRequired;
    }

    public String getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(String estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public Integer getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(Integer timeUnit) {
        this.timeUnit = timeUnit;
    }

    public String getMechanicName() {
        return mechanicName;
    }

    public void setMechanicName(String mechanicName) {
        this.mechanicName = mechanicName;
    }

    public Equipment getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Equipment equipmentId) {
        this.equipmentId = equipmentId;
    }

    @XmlTransient
    public Collection<MaintenanceDetail> getMaintenanceDetailCollection() {
        return maintenanceDetailCollection;
    }

    public void setMaintenanceDetailCollection(Collection<MaintenanceDetail> maintenanceDetailCollection) {
        this.maintenanceDetailCollection = maintenanceDetailCollection;
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
        if (!(object instanceof RepairOrder)) {
            return false;
        }
        RepairOrder other = (RepairOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.RepairOrder[ id=" + id + " ]";
    }
    
}
