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
@Table(name = "stores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stores.findAll", query = "SELECT s FROM Stores s"),
    @NamedQuery(name = "Stores.findById", query = "SELECT s FROM Stores s WHERE s.id = :id"),
    @NamedQuery(name = "Stores.findByName", query = "SELECT s FROM Stores s WHERE s.name = :name"),
    @NamedQuery(name = "Stores.findByLocation", query = "SELECT s FROM Stores s WHERE s.location = :location")})
public class Stores implements Serializable {
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
    @Size(max = 45)
    @Column(name = "location")
    private String location;
    @JoinTable(name = "stores_has_project", joinColumns = {
        @JoinColumn(name = "stores_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "project_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Project> projectCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storesId")
    private Collection<StoreReceive> storeReceiveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storesId")
    private Collection<SiteTransferOrders> siteTransferOrdersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storesId")
    private Collection<PurchaseOrderDetails> purchaseOrderDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storesId")
    private Collection<StoreLocation> storeLocationCollection;
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Company companyId;

    public Stores() {
    }

    public Stores(Integer id) {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @XmlTransient
    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }

    @XmlTransient
    public Collection<StoreReceive> getStoreReceiveCollection() {
        return storeReceiveCollection;
    }

    public void setStoreReceiveCollection(Collection<StoreReceive> storeReceiveCollection) {
        this.storeReceiveCollection = storeReceiveCollection;
    }

    @XmlTransient
    public Collection<SiteTransferOrders> getSiteTransferOrdersCollection() {
        return siteTransferOrdersCollection;
    }

    public void setSiteTransferOrdersCollection(Collection<SiteTransferOrders> siteTransferOrdersCollection) {
        this.siteTransferOrdersCollection = siteTransferOrdersCollection;
    }

    @XmlTransient
    public Collection<PurchaseOrderDetails> getPurchaseOrderDetailsCollection() {
        return purchaseOrderDetailsCollection;
    }

    public void setPurchaseOrderDetailsCollection(Collection<PurchaseOrderDetails> purchaseOrderDetailsCollection) {
        this.purchaseOrderDetailsCollection = purchaseOrderDetailsCollection;
    }

    @XmlTransient
    public Collection<StoreLocation> getStoreLocationCollection() {
        return storeLocationCollection;
    }

    public void setStoreLocationCollection(Collection<StoreLocation> storeLocationCollection) {
        this.storeLocationCollection = storeLocationCollection;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
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
        if (!(object instanceof Stores)) {
            return false;
        }
        Stores other = (Stores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Stores[ id=" + id + " ]";
    }
    
}
