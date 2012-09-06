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
@Table(name = "equipment_finance_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipmentFinanceDetail.findAll", query = "SELECT e FROM EquipmentFinanceDetail e"),
    @NamedQuery(name = "EquipmentFinanceDetail.findById", query = "SELECT e FROM EquipmentFinanceDetail e WHERE e.id = :id"),
    @NamedQuery(name = "EquipmentFinanceDetail.findByNextDueDate", query = "SELECT e FROM EquipmentFinanceDetail e WHERE e.nextDueDate = :nextDueDate"),
    @NamedQuery(name = "EquipmentFinanceDetail.findByPaidDate", query = "SELECT e FROM EquipmentFinanceDetail e WHERE e.paidDate = :paidDate"),
    @NamedQuery(name = "EquipmentFinanceDetail.findByPaidAmount", query = "SELECT e FROM EquipmentFinanceDetail e WHERE e.paidAmount = :paidAmount"),
    @NamedQuery(name = "EquipmentFinanceDetail.findByOtherCharges", query = "SELECT e FROM EquipmentFinanceDetail e WHERE e.otherCharges = :otherCharges"),
    @NamedQuery(name = "EquipmentFinanceDetail.findByRemarks", query = "SELECT e FROM EquipmentFinanceDetail e WHERE e.remarks = :remarks")})
public class EquipmentFinanceDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "next_due_date")
    @Temporal(TemporalType.DATE)
    private Date nextDueDate;
    @Column(name = "paid_date")
    @Temporal(TemporalType.DATE)
    private Date paidDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "paid_amount")
    private Double paidAmount;
    @Column(name = "other_charges")
    private Double otherCharges;
    @Size(max = 255)
    @Column(name = "remarks")
    private String remarks;
    @JoinColumn(name = "equipment_financing_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EquipmentFinancing equipmentFinancingId;

    public EquipmentFinanceDetail() {
    }

    public EquipmentFinanceDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNextDueDate() {
        return nextDueDate;
    }

    public void setNextDueDate(Date nextDueDate) {
        this.nextDueDate = nextDueDate;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Double getOtherCharges() {
        return otherCharges;
    }

    public void setOtherCharges(Double otherCharges) {
        this.otherCharges = otherCharges;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public EquipmentFinancing getEquipmentFinancingId() {
        return equipmentFinancingId;
    }

    public void setEquipmentFinancingId(EquipmentFinancing equipmentFinancingId) {
        this.equipmentFinancingId = equipmentFinancingId;
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
        if (!(object instanceof EquipmentFinanceDetail)) {
            return false;
        }
        EquipmentFinanceDetail other = (EquipmentFinanceDetail) object;
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
