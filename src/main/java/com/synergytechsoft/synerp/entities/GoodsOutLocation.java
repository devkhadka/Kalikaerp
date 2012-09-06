/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "goods_out_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GoodsOutLocation.findAll", query = "SELECT g FROM GoodsOutLocation g"),
    @NamedQuery(name = "GoodsOutLocation.findById", query = "SELECT g FROM GoodsOutLocation g WHERE g.id = :id"),
    @NamedQuery(name = "GoodsOutLocation.findByQuantity", query = "SELECT g FROM GoodsOutLocation g WHERE g.quantity = :quantity")})
public class GoodsOutLocation implements Serializable {
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
    @JoinColumn(name = "store_location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StoreLocation storeLocationId;
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unitId;
    @JoinColumn(name = "goods_out_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GoodsOutDetail goodsOutId;

    public GoodsOutLocation() {
    }

    public GoodsOutLocation(Integer id) {
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

    public StoreLocation getStoreLocationId() {
        return storeLocationId;
    }

    public void setStoreLocationId(StoreLocation storeLocationId) {
        this.storeLocationId = storeLocationId;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }

    public GoodsOutDetail getGoodsOutId() {
        return goodsOutId;
    }

    public void setGoodsOutId(GoodsOutDetail goodsOutId) {
        this.goodsOutId = goodsOutId;
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
        if (!(object instanceof GoodsOutLocation)) {
            return false;
        }
        GoodsOutLocation other = (GoodsOutLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.GoodsOutLocation[ id=" + id + " ]";
    }
    
}
