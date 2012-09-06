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
@Table(name = "site_transfer_orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteTransferOrders.findAll", query = "SELECT s FROM SiteTransferOrders s"),
    @NamedQuery(name = "SiteTransferOrders.findById", query = "SELECT s FROM SiteTransferOrders s WHERE s.id = :id")})
public class SiteTransferOrders implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "stores_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Stores storesId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "siteTransferOrdersId")
    private Collection<SiteTransferDetails> siteTransferDetailsCollection;

    public SiteTransferOrders() {
    }

    public SiteTransferOrders(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Stores getStoresId() {
        return storesId;
    }

    public void setStoresId(Stores storesId) {
        this.storesId = storesId;
    }

    @XmlTransient
    public Collection<SiteTransferDetails> getSiteTransferDetailsCollection() {
        return siteTransferDetailsCollection;
    }

    public void setSiteTransferDetailsCollection(Collection<SiteTransferDetails> siteTransferDetailsCollection) {
        this.siteTransferDetailsCollection = siteTransferDetailsCollection;
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
        if (!(object instanceof SiteTransferOrders)) {
            return false;
        }
        SiteTransferOrders other = (SiteTransferOrders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.SiteTransferOrders[ id=" + id + " ]";
    }
    
}
