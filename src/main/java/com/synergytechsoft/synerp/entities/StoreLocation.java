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
@Table(name = "store_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreLocation.findAll", query = "SELECT s FROM StoreLocation s"),
    @NamedQuery(name = "StoreLocation.findById", query = "SELECT s FROM StoreLocation s WHERE s.id = :id"),
    @NamedQuery(name = "StoreLocation.findByName", query = "SELECT s FROM StoreLocation s WHERE s.name = :name")})
public class StoreLocation implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeLocationId")
    private Collection<StoreReceive> storeReceiveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeLocationId")
    private Collection<GoodsOutLocation> goodsOutLocationCollection;
    @OneToMany(mappedBy = "parentId")
    private Collection<StoreLocation> storeLocationCollection;
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    @ManyToOne
    private StoreLocation parentId;
    @JoinColumn(name = "stores_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Stores storesId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeLocationId")
    private Collection<StockLocation> stockLocationCollection;
    @OneToMany(mappedBy = "storeLocationId")
    private Collection<StoreIn> storeInCollection;

    public StoreLocation() {
    }

    public StoreLocation(Integer id) {
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

    @XmlTransient
    public Collection<StoreReceive> getStoreReceiveCollection() {
        return storeReceiveCollection;
    }

    public void setStoreReceiveCollection(Collection<StoreReceive> storeReceiveCollection) {
        this.storeReceiveCollection = storeReceiveCollection;
    }

    @XmlTransient
    public Collection<GoodsOutLocation> getGoodsOutLocationCollection() {
        return goodsOutLocationCollection;
    }

    public void setGoodsOutLocationCollection(Collection<GoodsOutLocation> goodsOutLocationCollection) {
        this.goodsOutLocationCollection = goodsOutLocationCollection;
    }

    @XmlTransient
    public Collection<StoreLocation> getStoreLocationCollection() {
        return storeLocationCollection;
    }

    public void setStoreLocationCollection(Collection<StoreLocation> storeLocationCollection) {
        this.storeLocationCollection = storeLocationCollection;
    }

    public StoreLocation getParentId() {
        return parentId;
    }

    public void setParentId(StoreLocation parentId) {
        this.parentId = parentId;
    }

    public Stores getStoresId() {
        return storesId;
    }

    public void setStoresId(Stores storesId) {
        this.storesId = storesId;
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
        if (!(object instanceof StoreLocation)) {
            return false;
        }
        StoreLocation other = (StoreLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StoreLocation[ id=" + id + " ]";
    }
    
}
