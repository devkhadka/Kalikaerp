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
@Table(name = "receving_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecevingType.findAll", query = "SELECT r FROM RecevingType r"),
    @NamedQuery(name = "RecevingType.findById", query = "SELECT r FROM RecevingType r WHERE r.id = :id"),
    @NamedQuery(name = "RecevingType.findByName", query = "SELECT r FROM RecevingType r WHERE r.name = :name")})
public class RecevingType implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recevingTypeId")
    private Collection<StoreReceive> storeReceiveCollection;

    public RecevingType() {
    }

    public RecevingType(Integer id) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecevingType)) {
            return false;
        }
        RecevingType other = (RecevingType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RecevingType[ id=" + id + " ]";
    }
    
}
