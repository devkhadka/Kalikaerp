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
@Table(name = "store_in")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreIn.findAll", query = "SELECT s FROM StoreIn s"),
    @NamedQuery(name = "StoreIn.findById", query = "SELECT s FROM StoreIn s WHERE s.id = :id"),
    @NamedQuery(name = "StoreIn.findByQuantity", query = "SELECT s FROM StoreIn s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "StoreIn.findByMethodOfValuation", query = "SELECT s FROM StoreIn s WHERE s.methodOfValuation = :methodOfValuation"),
    @NamedQuery(name = "StoreIn.findByReOrderLevel", query = "SELECT s FROM StoreIn s WHERE s.reOrderLevel = :reOrderLevel"),
    @NamedQuery(name = "StoreIn.findByMinimumLevel", query = "SELECT s FROM StoreIn s WHERE s.minimumLevel = :minimumLevel"),
    @NamedQuery(name = "StoreIn.findByMaximumLevel", query = "SELECT s FROM StoreIn s WHERE s.maximumLevel = :maximumLevel"),
    @NamedQuery(name = "StoreIn.findByRejectedQuantity", query = "SELECT s FROM StoreIn s WHERE s.rejectedQuantity = :rejectedQuantity")})
public class StoreIn implements Serializable {
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
    @Size(max = 45)
    @Column(name = "method_of_valuation")
    private String methodOfValuation;
    @Column(name = "re_order_level")
    private Double reOrderLevel;
    @Column(name = "minimum_level")
    private Double minimumLevel;
    @Column(name = "maximum_level")
    private Double maximumLevel;
    @Column(name = "rejected_quantity")
    private Double rejectedQuantity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeInId")
    private Collection<StoreMaterialType> storeMaterialTypeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeInId")
    private Collection<StoreInDetail> storeInDetailCollection;
    @JoinColumn(name = "grn_number", referencedColumnName = "grn_number")
    @ManyToOne(optional = false)
    private StoreReceiveDetails grnNumber;
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unitId;
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Material materialId;
    @JoinColumn(name = "store_location_id", referencedColumnName = "id")
    @ManyToOne
    private StoreLocation storeLocationId;
    @JoinColumn(name = "status_material_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StatusMaterial statusMaterialId;

    public StoreIn() {
    }

    public StoreIn(Integer id) {
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

    public String getMethodOfValuation() {
        return methodOfValuation;
    }

    public void setMethodOfValuation(String methodOfValuation) {
        this.methodOfValuation = methodOfValuation;
    }

    public Double getReOrderLevel() {
        return reOrderLevel;
    }

    public void setReOrderLevel(Double reOrderLevel) {
        this.reOrderLevel = reOrderLevel;
    }

    public Double getMinimumLevel() {
        return minimumLevel;
    }

    public void setMinimumLevel(Double minimumLevel) {
        this.minimumLevel = minimumLevel;
    }

    public Double getMaximumLevel() {
        return maximumLevel;
    }

    public void setMaximumLevel(Double maximumLevel) {
        this.maximumLevel = maximumLevel;
    }

    public Double getRejectedQuantity() {
        return rejectedQuantity;
    }

    public void setRejectedQuantity(Double rejectedQuantity) {
        this.rejectedQuantity = rejectedQuantity;
    }

    @XmlTransient
    public Collection<StoreMaterialType> getStoreMaterialTypeCollection() {
        return storeMaterialTypeCollection;
    }

    public void setStoreMaterialTypeCollection(Collection<StoreMaterialType> storeMaterialTypeCollection) {
        this.storeMaterialTypeCollection = storeMaterialTypeCollection;
    }

    @XmlTransient
    public Collection<StoreInDetail> getStoreInDetailCollection() {
        return storeInDetailCollection;
    }

    public void setStoreInDetailCollection(Collection<StoreInDetail> storeInDetailCollection) {
        this.storeInDetailCollection = storeInDetailCollection;
    }

    public StoreReceiveDetails getGrnNumber() {
        return grnNumber;
    }

    public void setGrnNumber(StoreReceiveDetails grnNumber) {
        this.grnNumber = grnNumber;
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

    public StoreLocation getStoreLocationId() {
        return storeLocationId;
    }

    public void setStoreLocationId(StoreLocation storeLocationId) {
        this.storeLocationId = storeLocationId;
    }

    public StatusMaterial getStatusMaterialId() {
        return statusMaterialId;
    }

    public void setStatusMaterialId(StatusMaterial statusMaterialId) {
        this.statusMaterialId = statusMaterialId;
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
        if (!(object instanceof StoreIn)) {
            return false;
        }
        StoreIn other = (StoreIn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.StoreIn[ id=" + id + " ]";
    }
    
}
