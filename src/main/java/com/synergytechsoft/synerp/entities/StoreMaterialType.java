/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "store_material_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreMaterialType.findAll", query = "SELECT s FROM StoreMaterialType s"),
    @NamedQuery(name = "StoreMaterialType.findById", query = "SELECT s FROM StoreMaterialType s WHERE s.id = :id")})
public class StoreMaterialType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "store_in_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StoreIn storeInId;

    public StoreMaterialType() {
    }

    public StoreMaterialType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StoreIn getStoreInId() {
        return storeInId;
    }

    public void setStoreInId(StoreIn storeInId) {
        this.storeInId = storeInId;
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
        if (!(object instanceof StoreMaterialType)) {
            return false;
        }
        StoreMaterialType other = (StoreMaterialType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.StoreMaterialType[ id=" + id + " ]";
    }
    
}
