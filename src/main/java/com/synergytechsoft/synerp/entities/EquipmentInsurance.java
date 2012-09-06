/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "equipment_insurance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipmentInsurance.findAll", query = "SELECT e FROM EquipmentInsurance e"),
    @NamedQuery(name = "EquipmentInsurance.findById", query = "SELECT e FROM EquipmentInsurance e WHERE e.id = :id"),
    @NamedQuery(name = "EquipmentInsurance.findByInsurer", query = "SELECT e FROM EquipmentInsurance e WHERE e.insurer = :insurer"),
    @NamedQuery(name = "EquipmentInsurance.findByPolicy", query = "SELECT e FROM EquipmentInsurance e WHERE e.policy = :policy"),
    @NamedQuery(name = "EquipmentInsurance.findByPremium", query = "SELECT e FROM EquipmentInsurance e WHERE e.premium = :premium"),
    @NamedQuery(name = "EquipmentInsurance.findByInsuredAmount", query = "SELECT e FROM EquipmentInsurance e WHERE e.insuredAmount = :insuredAmount"),
    @NamedQuery(name = "EquipmentInsurance.findByCoverStartDate", query = "SELECT e FROM EquipmentInsurance e WHERE e.coverStartDate = :coverStartDate"),
    @NamedQuery(name = "EquipmentInsurance.findByCoverEndDate", query = "SELECT e FROM EquipmentInsurance e WHERE e.coverEndDate = :coverEndDate"),
    @NamedQuery(name = "EquipmentInsurance.findByRemarks", query = "SELECT e FROM EquipmentInsurance e WHERE e.remarks = :remarks")})
public class EquipmentInsurance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "insurer")
    private String insurer;
    @Size(max = 45)
    @Column(name = "policy")
    private String policy;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "premium")
    private Double premium;
    @Size(max = 45)
    @Column(name = "insured_amount")
    private String insuredAmount;
    @Column(name = "cover_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date coverStartDate;
    @Column(name = "cover_end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date coverEndDate;
    @Size(max = 45)
    @Column(name = "remarks")
    private String remarks;
    @JoinColumn(name = "equipment_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Equipment equipmentId;

    public EquipmentInsurance() {
    }

    public EquipmentInsurance(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInsurer() {
        return insurer;
    }

    public void setInsurer(String insurer) {
        this.insurer = insurer;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public String getInsuredAmount() {
        return insuredAmount;
    }

    public void setInsuredAmount(String insuredAmount) {
        this.insuredAmount = insuredAmount;
    }

    public Date getCoverStartDate() {
        return coverStartDate;
    }

    public void setCoverStartDate(Date coverStartDate) {
        this.coverStartDate = coverStartDate;
    }

    public Date getCoverEndDate() {
        return coverEndDate;
    }

    public void setCoverEndDate(Date coverEndDate) {
        this.coverEndDate = coverEndDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Equipment getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Equipment equipmentId) {
        this.equipmentId = equipmentId;
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
        if (!(object instanceof EquipmentInsurance)) {
            return false;
        }
        EquipmentInsurance other = (EquipmentInsurance) object;
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
