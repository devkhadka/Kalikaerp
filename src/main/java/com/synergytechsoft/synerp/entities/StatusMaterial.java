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
@Table(name = "status_material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusMaterial.findAll", query = "SELECT s FROM StatusMaterial s"),
    @NamedQuery(name = "StatusMaterial.findById", query = "SELECT s FROM StatusMaterial s WHERE s.id = :id"),
    @NamedQuery(name = "StatusMaterial.findByTypeNumber", query = "SELECT s FROM StatusMaterial s WHERE s.typeNumber = :typeNumber"),
    @NamedQuery(name = "StatusMaterial.findByDescription", query = "SELECT s FROM StatusMaterial s WHERE s.description = :description")})
public class StatusMaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "type_number")
    private Integer typeNumber;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusMaterialId")
    private Collection<GoodsOutLocation> goodsOutLocationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusMaterialId")
    private Collection<StockLocation> stockLocationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusMaterialId")
    private Collection<StoreIn> storeInCollection;

    public StatusMaterial() {
    }

    public StatusMaterial(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeNumber() {
        return typeNumber;
    }

    public void setTypeNumber(Integer typeNumber) {
        this.typeNumber = typeNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<GoodsOutLocation> getGoodsOutLocationCollection() {
        return goodsOutLocationCollection;
    }

    public void setGoodsOutLocationCollection(Collection<GoodsOutLocation> goodsOutLocationCollection) {
        this.goodsOutLocationCollection = goodsOutLocationCollection;
    }

    @XmlTransient
    public Collection<StockLocation> getStockLocationCollection() {
        return stockLocationCollection;
    }

    public void setStockLocationCollection(Collection<StockLocation> stockLocationCollection) {
        this.stockLocationCollection = stockLocationCollection;
    }

    @XmlTransient
    public Collection<StoreIn> getStoreInCollection() {
        return storeInCollection;
    }

    public void setStoreInCollection(Collection<StoreIn> storeInCollection) {
        this.storeInCollection = storeInCollection;
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
        if (!(object instanceof StatusMaterial)) {
            return false;
        }
        StatusMaterial other = (StatusMaterial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StatusMaterial[ id=" + id + " ]";
    }
    
}
