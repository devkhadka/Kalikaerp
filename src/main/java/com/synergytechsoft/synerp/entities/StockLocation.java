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
@Table(name = "stock_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StockLocation.findAll", query = "SELECT s FROM StockLocation s"),
    @NamedQuery(name = "StockLocation.findById", query = "SELECT s FROM StockLocation s WHERE s.id = :id"),
    @NamedQuery(name = "StockLocation.findByQuantity", query = "SELECT s FROM StockLocation s WHERE s.quantity = :quantity")})
public class StockLocation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantity")
    private Double quantity;
    @JoinColumn(name = "status_material_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StatusMaterial statusMaterialId;
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Material materialId;
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unitId;
    @JoinColumn(name = "store_location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StoreLocation storeLocationId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stockLocationId")
    private Collection<StockAdjustment> stockAdjustmentCollection;

    public StockLocation() {
    }

    public StockLocation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public StatusMaterial getStatusMaterialId() {
        return statusMaterialId;
    }

    public void setStatusMaterialId(StatusMaterial statusMaterialId) {
        this.statusMaterialId = statusMaterialId;
    }

    public Material getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Material materialId) {
        this.materialId = materialId;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }

    public StoreLocation getStoreLocationId() {
        return storeLocationId;
    }

    public void setStoreLocationId(StoreLocation storeLocationId) {
        this.storeLocationId = storeLocationId;
    }

    @XmlTransient
    public Collection<StockAdjustment> getStockAdjustmentCollection() {
        return stockAdjustmentCollection;
    }

    public void setStockAdjustmentCollection(Collection<StockAdjustment> stockAdjustmentCollection) {
        this.stockAdjustmentCollection = stockAdjustmentCollection;
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
        if (!(object instanceof StockLocation)) {
            return false;
        }
        StockLocation other = (StockLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.StockLocation[ id=" + id + " ]";
    }
    
}
