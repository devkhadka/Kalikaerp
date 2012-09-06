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
@Table(name = "store_in_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreInDetail.findAll", query = "SELECT s FROM StoreInDetail s"),
    @NamedQuery(name = "StoreInDetail.findById", query = "SELECT s FROM StoreInDetail s WHERE s.id = :id"),
    @NamedQuery(name = "StoreInDetail.findByName", query = "SELECT s FROM StoreInDetail s WHERE s.name = :name"),
    @NamedQuery(name = "StoreInDetail.findByQuantity", query = "SELECT s FROM StoreInDetail s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "StoreInDetail.findBySerialno", query = "SELECT s FROM StoreInDetail s WHERE s.serialno = :serialno"),
    @NamedQuery(name = "StoreInDetail.findByStatus", query = "SELECT s FROM StoreInDetail s WHERE s.status = :status")})
public class StoreInDetail implements Serializable {
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantity")
    private Double quantity;
    @Size(max = 45)
    @Column(name = "serialno")
    private String serialno;
    @Column(name = "status")
    private Integer status;
    @Lob
    @Size(max = 65535)
    @Column(name = "remarks")
    private String remarks;
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unitId;
    @JoinColumn(name = "store_in_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StoreIn storeInId;

    public StoreInDetail() {
    }

    public StoreInDetail(Integer id) {
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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }

    public StoreIn getStoreInId() {
        return storeInId;
    }

    public void setStoreInId(StoreIn storeInId) {
        this.storeInId = storeInId;
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
        if (!(object instanceof StoreInDetail)) {
            return false;
        }
        StoreInDetail other = (StoreInDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.StoreInDetail[ id=" + id + " ]";
    }
    
}
