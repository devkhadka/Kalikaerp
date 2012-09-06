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
@Table(name = "goods_out_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GoodsOutDetail.findAll", query = "SELECT g FROM GoodsOutDetail g"),
    @NamedQuery(name = "GoodsOutDetail.findById", query = "SELECT g FROM GoodsOutDetail g WHERE g.id = :id"),
    @NamedQuery(name = "GoodsOutDetail.findByRate", query = "SELECT g FROM GoodsOutDetail g WHERE g.rate = :rate")})
public class GoodsOutDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rate")
    private Double rate;
    @JoinColumn(name = "goods_out_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GoodsOut goodsOutId;
    @JoinColumn(name = "approve_site_transfer_id", referencedColumnName = "id")
    @ManyToOne
    private ApproveSiteTransfer approveSiteTransferId;
    @JoinColumn(name = "approve_materials_requisiton_id", referencedColumnName = "id")
    @ManyToOne
    private ApproveMaterialsRequisiton approveMaterialsRequisitonId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goodsOutId")
    private Collection<GoodsOutLocation> goodsOutLocationCollection;

    public GoodsOutDetail() {
    }

    public GoodsOutDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public GoodsOut getGoodsOutId() {
        return goodsOutId;
    }

    public void setGoodsOutId(GoodsOut goodsOutId) {
        this.goodsOutId = goodsOutId;
    }

    public ApproveSiteTransfer getApproveSiteTransferId() {
        return approveSiteTransferId;
    }

    public void setApproveSiteTransferId(ApproveSiteTransfer approveSiteTransferId) {
        this.approveSiteTransferId = approveSiteTransferId;
    }

    public ApproveMaterialsRequisiton getApproveMaterialsRequisitonId() {
        return approveMaterialsRequisitonId;
    }

    public void setApproveMaterialsRequisitonId(ApproveMaterialsRequisiton approveMaterialsRequisitonId) {
        this.approveMaterialsRequisitonId = approveMaterialsRequisitonId;
    }

    @XmlTransient
    public Collection<GoodsOutLocation> getGoodsOutLocationCollection() {
        return goodsOutLocationCollection;
    }

    public void setGoodsOutLocationCollection(Collection<GoodsOutLocation> goodsOutLocationCollection) {
        this.goodsOutLocationCollection = goodsOutLocationCollection;
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
        if (!(object instanceof GoodsOutDetail)) {
            return false;
        }
        GoodsOutDetail other = (GoodsOutDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.GoodsOutDetail[ id=" + id + " ]";
    }
    
}
