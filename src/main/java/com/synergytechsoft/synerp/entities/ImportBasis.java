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
@Table(name = "import_basis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImportBasis.findAll", query = "SELECT i FROM ImportBasis i"),
    @NamedQuery(name = "ImportBasis.findById", query = "SELECT i FROM ImportBasis i WHERE i.id = :id"),
    @NamedQuery(name = "ImportBasis.findByName", query = "SELECT i FROM ImportBasis i WHERE i.name = :name")})
public class ImportBasis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "importBasisId")
    private Collection<ForeignPurchase> foreignPurchaseCollection;

    public ImportBasis() {
    }

    public ImportBasis(Integer id) {
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
    public Collection<ForeignPurchase> getForeignPurchaseCollection() {
        return foreignPurchaseCollection;
    }

    public void setForeignPurchaseCollection(Collection<ForeignPurchase> foreignPurchaseCollection) {
        this.foreignPurchaseCollection = foreignPurchaseCollection;
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
        if (!(object instanceof ImportBasis)) {
            return false;
        }
        ImportBasis other = (ImportBasis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ImportBasis[ id=" + id + " ]";
    }
    
}
