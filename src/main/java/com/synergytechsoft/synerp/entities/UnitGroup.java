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
@Table(name = "unit_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnitGroup.findAll", query = "SELECT u FROM UnitGroup u"),
    @NamedQuery(name = "UnitGroup.findById", query = "SELECT u FROM UnitGroup u WHERE u.id = :id"),
    @NamedQuery(name = "UnitGroup.findByName", query = "SELECT u FROM UnitGroup u WHERE u.name = :name")})
public class UnitGroup implements Serializable {
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
    @JoinColumn(name = "default_unit_id", referencedColumnName = "id")
    @ManyToOne(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
    private Unit defaultUnitId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitGroupId")
    private Collection<Material> materialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitGroupId")
    private Collection<Unit> unitCollection;

    public UnitGroup() {
    }

    public UnitGroup(Integer id) {
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

    public Unit getDefaultUnitId() {
        return defaultUnitId;
    }

    public void setDefaultUnitId(Unit defaultUnitId) {
        this.defaultUnitId = defaultUnitId;
    }

    @XmlTransient
    public Collection<Material> getMaterialCollection() {
        return materialCollection;
    }

    public void setMaterialCollection(Collection<Material> materialCollection) {
        this.materialCollection = materialCollection;
    }

    @XmlTransient
    public Collection<Unit> getUnitCollection() {
        return unitCollection;
    }

    public void setUnitCollection(Collection<Unit> unitCollection) {
        this.unitCollection = unitCollection;
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
        if (!(object instanceof UnitGroup)) {
            return false;
        }
        UnitGroup other = (UnitGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + "";
    }
    
}
