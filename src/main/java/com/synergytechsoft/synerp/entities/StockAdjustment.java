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
@Table(name = "stock_adjustment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StockAdjustment.findAll", query = "SELECT s FROM StockAdjustment s"),
    @NamedQuery(name = "StockAdjustment.findById", query = "SELECT s FROM StockAdjustment s WHERE s.id = :id"),
    @NamedQuery(name = "StockAdjustment.findByAddLessQuantity", query = "SELECT s FROM StockAdjustment s WHERE s.addLessQuantity = :addLessQuantity"),
    @NamedQuery(name = "StockAdjustment.findByAddLess", query = "SELECT s FROM StockAdjustment s WHERE s.addLess = :addLess")})
public class StockAdjustment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "remarks")
    private String remarks;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "add_less_quantity")
    private Double addLessQuantity;
    @Column(name = "add_less")
    private Boolean addLess;
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unitId;
    @JoinColumn(name = "stock_location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StockLocation stockLocationId;
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Material materialId;

    public StockAdjustment() {
    }

    public StockAdjustment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Double getAddLessQuantity() {
        return addLessQuantity;
    }

    public void setAddLessQuantity(Double addLessQuantity) {
        this.addLessQuantity = addLessQuantity;
    }

    public Boolean getAddLess() {
        return addLess;
    }

    public void setAddLess(Boolean addLess) {
        this.addLess = addLess;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }

    public StockLocation getStockLocationId() {
        return stockLocationId;
    }

    public void setStockLocationId(StockLocation stockLocationId) {
        this.stockLocationId = stockLocationId;
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
        if (!(object instanceof StockAdjustment)) {
            return false;
        }
        StockAdjustment other = (StockAdjustment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.StockAdjustment[ id=" + id + " ]";
    }
    
}
