/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "material_requisition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialRequisition.findAll", query = "SELECT m FROM MaterialRequisition m"),
    @NamedQuery(name = "MaterialRequisition.findById", query = "SELECT m FROM MaterialRequisition m WHERE m.id = :id"),
    @NamedQuery(name = "MaterialRequisition.findByRequisitonToBeRaisedDate", query = "SELECT m FROM MaterialRequisition m WHERE m.requisitonToBeRaisedDate = :requisitonToBeRaisedDate"),
    @NamedQuery(name = "MaterialRequisition.findByLocationDelivery", query = "SELECT m FROM MaterialRequisition m WHERE m.locationDelivery = :locationDelivery"),
    @NamedQuery(name = "MaterialRequisition.findByCreatedBy", query = "SELECT m FROM MaterialRequisition m WHERE m.createdBy = :createdBy"),
    @NamedQuery(name = "MaterialRequisition.findByCreatedDate", query = "SELECT m FROM MaterialRequisition m WHERE m.createdDate = :createdDate")})
public class MaterialRequisition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "requisiton_to_be_raised_date")
    @Temporal(TemporalType.DATE)
    private Date requisitonToBeRaisedDate;
    @Size(max = 45)
    @Column(name = "location_delivery")
    private String locationDelivery;
    @Size(max = 45)
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialRequisitionId")
    private Collection<RequisitionMaterial> requisitionMaterialCollection;
    @JoinColumn(name = "material_requistion_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MaterialRequistionType materialRequistionTypeId;

    public MaterialRequisition() {
    }

    public MaterialRequisition(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRequisitonToBeRaisedDate() {
        return requisitonToBeRaisedDate;
    }

    public void setRequisitonToBeRaisedDate(Date requisitonToBeRaisedDate) {
        this.requisitonToBeRaisedDate = requisitonToBeRaisedDate;
    }

    public String getLocationDelivery() {
        return locationDelivery;
    }

    public void setLocationDelivery(String locationDelivery) {
        this.locationDelivery = locationDelivery;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @XmlTransient
    public Collection<RequisitionMaterial> getRequisitionMaterialCollection() {
        if (requisitionMaterialCollection == null) {
            requisitionMaterialCollection = new ArrayList<RequisitionMaterial>();
        }

        return requisitionMaterialCollection;
    }

    public void setRequisitionMaterialCollection(Collection<RequisitionMaterial> requisitionMaterialCollection) {
        this.requisitionMaterialCollection = requisitionMaterialCollection;
    }

    public MaterialRequistionType getMaterialRequistionTypeId() {
        return materialRequistionTypeId;
    }

    public void setMaterialRequistionTypeId(MaterialRequistionType materialRequistionTypeId) {
        this.materialRequistionTypeId = materialRequistionTypeId;
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
        if (!(object instanceof MaterialRequisition)) {
            return false;
        }
        MaterialRequisition other = (MaterialRequisition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  id.toString();
    }

    public void addRequistionMaterial(RequisitionMaterial m) {
        if (!this.getRequisitionMaterialCollection().contains(m)) {
            this.getRequisitionMaterialCollection().add(m);
            m.setMaterialRequisitionId(this);
        }
    }

    public void deleteRequisitionMaterials(RequisitionMaterial rm) {
        if (getRequisitionMaterialCollection().contains(rm)) {
            this.requisitionMaterialCollection.remove(rm);
          //  rm.setMaterialRequisitionId(null);

        }
    }
}
