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
@Table(name = "issue_fuel_n_fluid_slip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IssueFuelNFluidSlip.findAll", query = "SELECT i FROM IssueFuelNFluidSlip i"),
    @NamedQuery(name = "IssueFuelNFluidSlip.findById", query = "SELECT i FROM IssueFuelNFluidSlip i WHERE i.id = :id"),
    @NamedQuery(name = "IssueFuelNFluidSlip.findByIssuedTo", query = "SELECT i FROM IssueFuelNFluidSlip i WHERE i.issuedTo = :issuedTo"),
    @NamedQuery(name = "IssueFuelNFluidSlip.findBySlipNumber", query = "SELECT i FROM IssueFuelNFluidSlip i WHERE i.slipNumber = :slipNumber"),
    @NamedQuery(name = "IssueFuelNFluidSlip.findByQuantity", query = "SELECT i FROM IssueFuelNFluidSlip i WHERE i.quantity = :quantity")})
public class IssueFuelNFluidSlip implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "issued_to")
    private String issuedTo;
    @Size(max = 45)
    @Column(name = "slip_number")
    private String slipNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantity")
    private Double quantity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "slipNumber")
    private Collection<CloseSlips> closeSlipsCollection;
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unitId;
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Material materialId;

    public IssueFuelNFluidSlip() {
    }

    public IssueFuelNFluidSlip(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIssuedTo() {
        return issuedTo;
    }

    public void setIssuedTo(String issuedTo) {
        this.issuedTo = issuedTo;
    }

    public String getSlipNumber() {
        return slipNumber;
    }

    public void setSlipNumber(String slipNumber) {
        this.slipNumber = slipNumber;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @XmlTransient
    public Collection<CloseSlips> getCloseSlipsCollection() {
        return closeSlipsCollection;
    }

    public void setCloseSlipsCollection(Collection<CloseSlips> closeSlipsCollection) {
        this.closeSlipsCollection = closeSlipsCollection;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }

    public Material getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Material materialId) {
        this.materialId = materialId;
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
        if (!(object instanceof IssueFuelNFluidSlip)) {
            return false;
        }
        IssueFuelNFluidSlip other = (IssueFuelNFluidSlip) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.IssueFuelNFluidSlip[ id=" + id + " ]";
    }
    
}
