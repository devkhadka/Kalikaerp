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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "store_receive")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreReceive.findAll", query = "SELECT s FROM StoreReceive s"),
    @NamedQuery(name = "StoreReceive.findById", query = "SELECT s FROM StoreReceive s WHERE s.id = :id"),
    @NamedQuery(name = "StoreReceive.findByPoNumber", query = "SELECT s FROM StoreReceive s WHERE s.poNumber = :poNumber"),
    @NamedQuery(name = "StoreReceive.findByIsComplete", query = "SELECT s FROM StoreReceive s WHERE s.isComplete = :isComplete")})
public class StoreReceive implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "po_number")
    private String poNumber;
    @Column(name = "is_complete")
    private Boolean isComplete;
    @JoinColumn(name = "store_location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StoreLocation storeLocationId;
    @JoinColumn(name = "receving_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RecevingType recevingTypeId;
    @JoinColumn(name = "stores_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Stores storesId;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeReceiveId")
    private Collection<StoreReceiveDetails> storeReceiveDetailsCollection;
    
     @Transient
    private StoreReceiveDetails storeReceiveDetails;

    public StoreReceive() {
    }

    public StoreReceive(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public Boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Boolean isComplete) {
        this.isComplete = isComplete;
    }

    public StoreLocation getStoreLocationId() {
        return storeLocationId;
    }

    public void setStoreLocationId(StoreLocation storeLocationId) {
        this.storeLocationId = storeLocationId;
    }

    public RecevingType getRecevingTypeId() {
        return recevingTypeId;
    }

    public void setRecevingTypeId(RecevingType recevingTypeId) {
        this.recevingTypeId = recevingTypeId;
    }

    public Stores getStoresId() {
        return storesId;
    }

    public void setStoresId(Stores storesId) {
        this.storesId = storesId;
    }

    @XmlTransient
    public Collection<StoreReceiveDetails> getStoreReceiveDetailsCollection() {
         
        if (storeReceiveDetailsCollection==null){
            storeReceiveDetailsCollection=new ArrayList<StoreReceiveDetails>();
        }
        return storeReceiveDetailsCollection;
    }

    public void setStoreReceiveDetailsCollection(Collection<StoreReceiveDetails> storeReceiveDetailsCollection) {
        this.storeReceiveDetailsCollection = storeReceiveDetailsCollection;
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
        if (!(object instanceof StoreReceive)) {
            return false;
        }
        StoreReceive other = (StoreReceive) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StoreReceive[ id=" + id + " ]";
    }
    
      public StoreReceiveDetails getStoreReceiveDet(){
    
        if(storeReceiveDetails==null)
            storeReceiveDetails =new StoreReceiveDetails();
   
        if (!this.getStoreReceiveDetailsCollection().contains(storeReceiveDetails)){
          this.getStoreReceiveDetailsCollection().add(storeReceiveDetails);
          storeReceiveDetails.setStoreReceiveId(this);
        }
           
        
        return storeReceiveDetails;
    }
    
}
