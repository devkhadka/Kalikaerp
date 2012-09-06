/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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
@Table(name = "purchase_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseRequest.findAll", query = "SELECT p FROM PurchaseRequest p"),
    @NamedQuery(name = "PurchaseRequest.findById", query = "SELECT p FROM PurchaseRequest p WHERE p.id = :id"),
    @NamedQuery(name = "PurchaseRequest.findByDescription", query = "SELECT p FROM PurchaseRequest p WHERE p.description = :description")})
public class PurchaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Column(name = "request_process_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseRequestId", fetch= FetchType.EAGER)
    private Collection<PurchaseRequestMaterial> purchaseRequestMaterialCollection;

    public PurchaseRequest() {
    }

    public PurchaseRequest(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<PurchaseRequestMaterial> getPurchaseRequestMaterialCollection() {
        if(purchaseRequestMaterialCollection==null)
            purchaseRequestMaterialCollection = new ArrayList<PurchaseRequestMaterial>();
        return purchaseRequestMaterialCollection;
    }

    public void setPurchaseRequestMaterialCollection(Collection<PurchaseRequestMaterial> purchaseRequestMaterialCollection) {
        this.purchaseRequestMaterialCollection = purchaseRequestMaterialCollection;
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
        if (!(object instanceof PurchaseRequest)) {
            return false;
        }
        PurchaseRequest other = (PurchaseRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.PurchaseRequest[ id=" + id + " ]";
    }
    
    /**
     * 
     * @return 
     */

    public Date getCreatedDate() {
        return createdDate;
    }
/**
 *  Sets Created Date
 * @param createdDate
 */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    public void addPurchaseRequestMaterial(){
        PurchaseRequestMaterial purchaseRequestMaterial= new PurchaseRequestMaterial();
        this.getPurchaseRequestMaterialCollection().add(purchaseRequestMaterial);
        purchaseRequestMaterial.setPurchaseRequestId(this);
    }
    
    public void removePurchaseRequestMaterial(PurchaseRequestMaterial purchaseRequestMaterial){
        if(this.getPurchaseRequestMaterialCollection().contains(purchaseRequestMaterial)){
            this.getPurchaseRequestMaterialCollection().remove(purchaseRequestMaterial);
        }
    }
    
}
