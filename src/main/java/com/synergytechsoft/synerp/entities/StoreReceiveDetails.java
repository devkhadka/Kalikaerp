/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "store_receive_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreReceiveDetails.findAll", query = "SELECT s FROM StoreReceiveDetails s"),
    @NamedQuery(name = "StoreReceiveDetails.findById", query = "SELECT s FROM StoreReceiveDetails s WHERE s.id = :id"),
    @NamedQuery(name = "StoreReceiveDetails.findBySupplierName", query = "SELECT s FROM StoreReceiveDetails s WHERE s.supplierName = :supplierName"),
    @NamedQuery(name = "StoreReceiveDetails.findByDeliveryNoteNumber", query = "SELECT s FROM StoreReceiveDetails s WHERE s.deliveryNoteNumber = :deliveryNoteNumber"),
    @NamedQuery(name = "StoreReceiveDetails.findByCarrier", query = "SELECT s FROM StoreReceiveDetails s WHERE s.carrier = :carrier"),
    @NamedQuery(name = "StoreReceiveDetails.findByCarriageNumber", query = "SELECT s FROM StoreReceiveDetails s WHERE s.carriageNumber = :carriageNumber"),
    @NamedQuery(name = "StoreReceiveDetails.findByDriver", query = "SELECT s FROM StoreReceiveDetails s WHERE s.driver = :driver"),
    @NamedQuery(name = "StoreReceiveDetails.findByDate", query = "SELECT s FROM StoreReceiveDetails s WHERE s.date = :date"),
    @NamedQuery(name = "StoreReceiveDetails.findByUser", query = "SELECT s FROM StoreReceiveDetails s WHERE s.user = :user"),
    @NamedQuery(name = "StoreReceiveDetails.findByReceivedBy", query = "SELECT s FROM StoreReceiveDetails s WHERE s.receivedBy = :receivedBy"),
    @NamedQuery(name = "StoreReceiveDetails.findByVerifiedBy", query = "SELECT s FROM StoreReceiveDetails s WHERE s.verifiedBy = :verifiedBy"),
    @NamedQuery(name = "StoreReceiveDetails.findByGrnNumber", query = "SELECT s FROM StoreReceiveDetails s WHERE s.grnNumber = :grnNumber")})
public class StoreReceiveDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "supplier_name")
    private String supplierName;
    @Size(max = 45)
    @Column(name = "delivery_note_number")
    private String deliveryNoteNumber;
    @Size(max = 45)
    @Column(name = "carrier")
    private String carrier;
    @Size(max = 45)
    @Column(name = "carriage_number")
    private String carriageNumber;
    @Size(max = 45)
    @Column(name = "driver")
    private String driver;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 45)
    @Column(name = "user")
    private String user;
    @Size(max = 45)
    @Column(name = "received_by")
    private String receivedBy;
    @Size(max = 45)
    @Column(name = "verified_by")
    private String verifiedBy;
    @Size(max = 45)
    @Column(name = "grn_number")
    private String grnNumber;
    @JoinColumn(name = "store_receive_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StoreReceive storeReceiveId;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grnNumber")
    private Collection<StoreIn> storeInCollection;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeReceiveDetailsId")
    private Collection<StoreReceiveFineDetails> storeReceiveFineDetailsCollection;

    public StoreReceiveDetails() {
    }

    public StoreReceiveDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getDeliveryNoteNumber() {
        return deliveryNoteNumber;
    }

    public void setDeliveryNoteNumber(String deliveryNoteNumber) {
        this.deliveryNoteNumber = deliveryNoteNumber;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCarriageNumber() {
        return carriageNumber;
    }

    public void setCarriageNumber(String carriageNumber) {
        this.carriageNumber = carriageNumber;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(String receivedBy) {
        this.receivedBy = receivedBy;
    }

    public String getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public String getGrnNumber() {
        return grnNumber;
    }

    public void setGrnNumber(String grnNumber) {
        this.grnNumber = grnNumber;
    }

    public StoreReceive getStoreReceiveId() {
        return storeReceiveId;
    }

    public void setStoreReceiveId(StoreReceive storeReceiveId) {
        this.storeReceiveId = storeReceiveId;
    }

    @XmlTransient
    public Collection<StoreIn> getStoreInCollection() {
         if (storeInCollection == null) {
            storeInCollection = new ArrayList<StoreIn>();
        }
        return storeInCollection;
    }

    public void setStoreInCollection(Collection<StoreIn> storeInCollection) {
        this.storeInCollection = storeInCollection;
    }

    @XmlTransient
    public Collection<StoreReceiveFineDetails> getStoreReceiveFineDetailsCollection() {
       if (storeReceiveFineDetailsCollection == null) {
            storeReceiveFineDetailsCollection = new ArrayList<StoreReceiveFineDetails>();
        }
        
        return storeReceiveFineDetailsCollection;
    }

    public void setStoreReceiveFineDetailsCollection(Collection<StoreReceiveFineDetails> storeReceiveFineDetailsCollection) {
        this.storeReceiveFineDetailsCollection = storeReceiveFineDetailsCollection;
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
        if (!(object instanceof StoreReceiveDetails)) {
            return false;
        }
        StoreReceiveDetails other = (StoreReceiveDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

     @Override
    public String toString() {
        return id + "grn no" + grnNumber;        
    }
    
    
      public void addStoreIn() {
        System.out.println("isnside add");
        StoreIn storeIn = new StoreIn();
        storeIn.setQuantity(33.00);  
        this.addStoreIn(storeIn);
        System.out.println("isnside addd");
    }
      
       public void addStoreIn(StoreIn sin) {
        this.getStoreInCollection().add(sin);
        sin.setGrnNumber(this);
    }
        public void addStoreReceiveFineDetail() {
        StoreReceiveFineDetails s = new StoreReceiveFineDetails();
        this.getStoreReceiveFineDetailsCollection().add(s);
        s.setStoreReceiveDetailsId(this);
        
    }
}
