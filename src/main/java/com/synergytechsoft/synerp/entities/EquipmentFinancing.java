/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "equipment_financing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipmentFinancing.findAll", query = "SELECT e FROM EquipmentFinancing e"),
    @NamedQuery(name = "EquipmentFinancing.findById", query = "SELECT e FROM EquipmentFinancing e WHERE e.id = :id"),
    @NamedQuery(name = "EquipmentFinancing.findByContractNumber", query = "SELECT e FROM EquipmentFinancing e WHERE e.contractNumber = :contractNumber"),
    @NamedQuery(name = "EquipmentFinancing.findByFinancer", query = "SELECT e FROM EquipmentFinancing e WHERE e.financer = :financer"),
    @NamedQuery(name = "EquipmentFinancing.findByFullAmount", query = "SELECT e FROM EquipmentFinancing e WHERE e.fullAmount = :fullAmount"),
    @NamedQuery(name = "EquipmentFinancing.findByDownPayment", query = "SELECT e FROM EquipmentFinancing e WHERE e.downPayment = :downPayment"),
    @NamedQuery(name = "EquipmentFinancing.findByFinanceAmount", query = "SELECT e FROM EquipmentFinancing e WHERE e.financeAmount = :financeAmount"),
    @NamedQuery(name = "EquipmentFinancing.findByFirstInstallmentDue", query = "SELECT e FROM EquipmentFinancing e WHERE e.firstInstallmentDue = :firstInstallmentDue"),
    @NamedQuery(name = "EquipmentFinancing.findByInstallmentAmount", query = "SELECT e FROM EquipmentFinancing e WHERE e.installmentAmount = :installmentAmount"),
    @NamedQuery(name = "EquipmentFinancing.findByRoi", query = "SELECT e FROM EquipmentFinancing e WHERE e.roi = :roi"),
    @NamedQuery(name = "EquipmentFinancing.findByInstallmentNumber", query = "SELECT e FROM EquipmentFinancing e WHERE e.installmentNumber = :installmentNumber"),
    @NamedQuery(name = "EquipmentFinancing.findByRemarks", query = "SELECT e FROM EquipmentFinancing e WHERE e.remarks = :remarks")})
public class EquipmentFinancing implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "contract_number")
    private String contractNumber;
    @Size(max = 45)
    @Column(name = "financer")
    private String financer;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "full_amount")
    private Double fullAmount;
    @Column(name = "down_payment")
    private Double downPayment;
    @Column(name = "finance_amount")
    private Double financeAmount;
    @Column(name = "first_installment_due")
    @Temporal(TemporalType.DATE)
    private Date firstInstallmentDue;
    @Size(max = 45)
    @Column(name = "installment_amount")
    private String installmentAmount;
    @Column(name = "roi")
    private Double roi;
    @Column(name = "installment_number")
    private Integer installmentNumber;
    @Size(max = 45)
    @Column(name = "remarks")
    private String remarks;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipmentFinancingId")
    private Collection<EquipmentFinanceDetail> equipmentFinanceDetailCollection;
    @JoinColumn(name = "equipment_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Equipment equipmentId;

    public EquipmentFinancing() {
    }

    public EquipmentFinancing(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getFinancer() {
        return financer;
    }

    public void setFinancer(String financer) {
        this.financer = financer;
    }

    public Double getFullAmount() {
        return fullAmount;
    }

    public void setFullAmount(Double fullAmount) {
        this.fullAmount = fullAmount;
    }

    public Double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(Double downPayment) {
        this.downPayment = downPayment;
    }

    public Double getFinanceAmount() {
        return financeAmount;
    }

    public void setFinanceAmount(Double financeAmount) {
        this.financeAmount = financeAmount;
    }

    public Date getFirstInstallmentDue() {
        return firstInstallmentDue;
    }

    public void setFirstInstallmentDue(Date firstInstallmentDue) {
        this.firstInstallmentDue = firstInstallmentDue;
    }

    public String getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(String installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    public Double getRoi() {
        return roi;
    }

    public void setRoi(Double roi) {
        this.roi = roi;
    }

    public Integer getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(Integer installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @XmlTransient
    public Collection<EquipmentFinanceDetail> getEquipmentFinanceDetailCollection() {
        return equipmentFinanceDetailCollection;
    }

    public void setEquipmentFinanceDetailCollection(Collection<EquipmentFinanceDetail> equipmentFinanceDetailCollection) {
        this.equipmentFinanceDetailCollection = equipmentFinanceDetailCollection;
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
        if (!(object instanceof EquipmentFinancing)) {
            return false;
        }
        EquipmentFinancing other = (EquipmentFinancing) object;
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
