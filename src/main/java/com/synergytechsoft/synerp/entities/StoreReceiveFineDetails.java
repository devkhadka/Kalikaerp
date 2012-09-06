/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "store_receive_fine_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreReceiveFineDetails.findAll", query = "SELECT s FROM StoreReceiveFineDetails s"),
    @NamedQuery(name = "StoreReceiveFineDetails.findById", query = "SELECT s FROM StoreReceiveFineDetails s WHERE s.id = :id"),
    @NamedQuery(name = "StoreReceiveFineDetails.findByQuantityChallan", query = "SELECT s FROM StoreReceiveFineDetails s WHERE s.quantityChallan = :quantityChallan"),
    @NamedQuery(name = "StoreReceiveFineDetails.findByQuantityReceived", query = "SELECT s FROM StoreReceiveFineDetails s WHERE s.quantityReceived = :quantityReceived"),
    @NamedQuery(name = "StoreReceiveFineDetails.findByQuantityDamaged", query = "SELECT s FROM StoreReceiveFineDetails s WHERE s.quantityDamaged = :quantityDamaged")})
public class StoreReceiveFineDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantity_challan")
    private Double quantityChallan;
    @Column(name = "quantity_received")
    private Double quantityReceived;
    @Column(name = "quantity_damaged")
    private Double quantityDamaged;
    @Lob
    @Size(max = 65535)
    @Column(name = "remarks")
    private String remarks;
    @JoinColumn(name = "unit_id_damaged", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unitIdDamaged;
    @JoinColumn(name = "unit_id_received", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unitIdReceived;
    @JoinColumn(name = "store_receive_details_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StoreReceiveDetails storeReceiveDetailsId;
    @JoinColumn(name = "unit_id_challan", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unitIdChallan;
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Material materialId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeReceiveFineDetailsId")
    private Collection<CloseExceptionsRemarks> closeExceptionsRemarksCollection;

    public StoreReceiveFineDetails() {
    }

    public StoreReceiveFineDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantityChallan() {
        return quantityChallan;
    }

    public void setQuantityChallan(Double quantityChallan) {
        this.quantityChallan = quantityChallan;
    }

    public Double getQuantityReceived() {
        return quantityReceived;
    }

    public void setQuantityReceived(Double quantityReceived) {
        this.quantityReceived = quantityReceived;
    }

    public Double getQuantityDamaged() {
        return quantityDamaged;
    }

    public void setQuantityDamaged(Double quantityDamaged) {
        this.quantityDamaged = quantityDamaged;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Unit getUnitIdDamaged() {
        return unitIdDamaged;
    }

    public void setUnitIdDamaged(Unit unitIdDamaged) {
        this.unitIdDamaged = unitIdDamaged;
    }

    public Unit getUnitIdReceived() {
        return unitIdReceived;
    }

    public void setUnitIdReceived(Unit unitIdReceived) {
        this.unitIdReceived = unitIdReceived;
    }

    public StoreReceiveDetails getStoreReceiveDetailsId() {
        return storeReceiveDetailsId;
    }

    public void setStoreReceiveDetailsId(StoreReceiveDetails storeReceiveDetailsId) {
        this.storeReceiveDetailsId = storeReceiveDetailsId;
    }

    public Unit getUnitIdChallan() {
        return unitIdChallan;
    }

    public void setUnitIdChallan(Unit unitIdChallan) {
        this.unitIdChallan = unitIdChallan;
    }

    public Material getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Material materialId) {
        this.materialId = materialId;
    }

    @XmlTransient
    public Collection<CloseExceptionsRemarks> getCloseExceptionsRemarksCollection() {
        return closeExceptionsRemarksCollection;
    }

    public void setCloseExceptionsRemarksCollection(Collection<CloseExceptionsRemarks> closeExceptionsRemarksCollection) {
        this.closeExceptionsRemarksCollection = closeExceptionsRemarksCollection;
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
        if (!(object instanceof StoreReceiveFineDetails)) {
            return false;
        }
        StoreReceiveFineDetails other = (StoreReceiveFineDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

     @Override
    public String toString() {
        return id + "";
    }
    
    
    
     @Transient
    private Collection<StoreIn> storeInCollection;

    public Collection<StoreIn> getStoreInCollection() {

        if (storeInCollection == null) {
            storeInCollection = new ArrayList<StoreIn>();
        }
        return storeInCollection;
    }

    public void addStoreIn() {
        System.out.println("isnside add");
        StoreIn storeIn = new StoreIn();
      
        this.getStoreInCollection().add(storeIn);
        this.getStoreReceiveDetailsId().addStoreIn(storeIn);
        System.out.println("isnside addd");
    }
}
