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
@Table(name = "equipment_maintenance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipmentMaintenance.findAll", query = "SELECT e FROM EquipmentMaintenance e"),
    @NamedQuery(name = "EquipmentMaintenance.findById", query = "SELECT e FROM EquipmentMaintenance e WHERE e.id = :id"),
    @NamedQuery(name = "EquipmentMaintenance.findByDescription", query = "SELECT e FROM EquipmentMaintenance e WHERE e.description = :description")})
public class EquipmentMaintenance implements Serializable {
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
    @JoinColumn(name = "equipment_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Equipment equipmentId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipmentMaintenanceId")
    private Collection<MaintenanceDetail> maintenanceDetailCollection;

    public EquipmentMaintenance() {
    }

    public EquipmentMaintenance(Integer id) {
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
        if (!(object instanceof EquipmentMaintenance)) {
            return false;
        }
        EquipmentMaintenance other = (EquipmentMaintenance) object;
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
