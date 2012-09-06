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
@Table(name = "goods_out")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GoodsOut.findAll", query = "SELECT g FROM GoodsOut g"),
    @NamedQuery(name = "GoodsOut.findById", query = "SELECT g FROM GoodsOut g WHERE g.id = :id")})
public class GoodsOut implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goodsOutId")
    private Collection<GoodsOutDetail> goodsOutDetailCollection;

    public GoodsOut() {
    }

    public GoodsOut(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<GoodsOutDetail> getGoodsOutDetailCollection() {
        return goodsOutDetailCollection;
    }

    public void setGoodsOutDetailCollection(Collection<GoodsOutDetail> goodsOutDetailCollection) {
        this.goodsOutDetailCollection = goodsOutDetailCollection;
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
        if (!(object instanceof GoodsOut)) {
            return false;
        }
        GoodsOut other = (GoodsOut) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.GoodsOut[ id=" + id + " ]";
    }
    
}
