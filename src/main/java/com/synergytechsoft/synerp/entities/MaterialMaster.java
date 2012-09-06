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
@Table(name = "material_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialMaster.findAll", query = "SELECT m FROM MaterialMaster m"),
    @NamedQuery(name = "MaterialMaster.findById", query = "SELECT m FROM MaterialMaster m WHERE m.id = :id")})
public class MaterialMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "industries_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Industries industriesId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialMasterId")
    private Collection<Material> materialCollection;

    public MaterialMaster() {
    }

    public MaterialMaster(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Industries getIndustriesId() {
        return industriesId;
    }

    public void setIndustriesId(Industries industriesId) {
        this.industriesId = industriesId;
    }

    @XmlTransient
    public Collection<Material> getMaterialCollection() {
        return materialCollection;
    }

    public void setMaterialCollection(Collection<Material> materialCollection) {
        this.materialCollection = materialCollection;
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
        if (!(object instanceof MaterialMaster)) {
            return false;
        }
        MaterialMaster other = (MaterialMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.MaterialMaster[ id=" + id + " ]";
    }
    
}
