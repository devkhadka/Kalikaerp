/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "road_registration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoadRegistration.findAll", query = "SELECT r FROM RoadRegistration r"),
    @NamedQuery(name = "RoadRegistration.findById", query = "SELECT r FROM RoadRegistration r WHERE r.id = :id"),
    @NamedQuery(name = "RoadRegistration.findByRcNumber", query = "SELECT r FROM RoadRegistration r WHERE r.rcNumber = :rcNumber"),
    @NamedQuery(name = "RoadRegistration.findByRcDate", query = "SELECT r FROM RoadRegistration r WHERE r.rcDate = :rcDate"),
    @NamedQuery(name = "RoadRegistration.findByRegion", query = "SELECT r FROM RoadRegistration r WHERE r.region = :region"),
    @NamedQuery(name = "RoadRegistration.findByRemarks", query = "SELECT r FROM RoadRegistration r WHERE r.remarks = :remarks")})
public class RoadRegistration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "rc_number")
    private String rcNumber;
    @Column(name = "rc_date")
    @Temporal(TemporalType.DATE)
    private Date rcDate;
    @Size(max = 45)
    @Column(name = "region")
    private String region;
    @Size(max = 45)
    @Column(name = "remarks")
    private String remarks;
    @JoinColumn(name = "equipment_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Equipment equipmentId;

    public RoadRegistration() {
    }

    public RoadRegistration(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRcNumber() {
        return rcNumber;
    }

    public void setRcNumber(String rcNumber) {
        this.rcNumber = rcNumber;
    }

    public Date getRcDate() {
        return rcDate;
    }

    public void setRcDate(Date rcDate) {
        this.rcDate = rcDate;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Equipment getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Equipment equipmentId) {
        this.equipmentId = equipmentId;
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
        if (!(object instanceof RoadRegistration)) {
            return false;
        }
        RoadRegistration other = (RoadRegistration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.RoadRegistration[ id=" + id + " ]";
    }
    
}
