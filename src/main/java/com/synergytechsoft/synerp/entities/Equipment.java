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
@Table(name = "equipment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipment.findAll", query = "SELECT e FROM Equipment e"),
    @NamedQuery(name = "Equipment.findById", query = "SELECT e FROM Equipment e WHERE e.id = :id"),
    @NamedQuery(name = "Equipment.findByHiredOwned", query = "SELECT e FROM Equipment e WHERE e.hiredOwned = :hiredOwned"),
    @NamedQuery(name = "Equipment.findByHiredDate", query = "SELECT e FROM Equipment e WHERE e.hiredDate = :hiredDate"),
    @NamedQuery(name = "Equipment.findByAlias", query = "SELECT e FROM Equipment e WHERE e.alias = :alias"),
    @NamedQuery(name = "Equipment.findByName", query = "SELECT e FROM Equipment e WHERE e.name = :name"),
    @NamedQuery(name = "Equipment.findByStatus", query = "SELECT e FROM Equipment e WHERE e.status = :status"),
    @NamedQuery(name = "Equipment.findByUsedHours", query = "SELECT e FROM Equipment e WHERE e.usedHours = :usedHours"),
    @NamedQuery(name = "Equipment.findBySerialNumber", query = "SELECT e FROM Equipment e WHERE e.serialNumber = :serialNumber"),
    @NamedQuery(name = "Equipment.findByCode", query = "SELECT e FROM Equipment e WHERE e.code = :code")})
public class Equipment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "hired_owned")
    private Integer hiredOwned;
    @Column(name = "hired_date")
    @Temporal(TemporalType.DATE)
    private Date hiredDate;
    
    @Size(max = 45)
    @Column(name = "alias")
    private String alias;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private Integer status;
    @Column(name = "used_hours",columnDefinition="int default '0'")
    private Integer usedHours;
    @Size(max = 45)
    @Column(name = "serial_number")
    private String serialNumber;
    @Size(max = 45)
    @Column(name = "code")
    private String code;
    @JoinTable(name = "equipment_has_equipment_parts", joinColumns = {
        @JoinColumn(name = "equipment_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "equipment_parts_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<EquipmentParts> equipmentPartsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipmentId")
    private Collection<EquipmentMaintenance> equipmentMaintenanceCollection;
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Company companyId;
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Currency currencyId;
    @JoinColumn(name = "equipment_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EquipmentCategory equipmentCategoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipmentId")
    private Collection<EquipmentFinancing> equipmentFinancingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipmentId")
    private Collection<EquipmentInsurance> equipmentInsuranceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipmentId")
    private Collection<RoadRegistration> roadRegistrationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipmentId")
    private Collection<RepairOrder> repairOrderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipmentId")
    private Collection<MaintenanceSchedules> maintenanceSchedulesCollection;

    public Equipment() {
    }

    public Equipment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHiredOwned() {
        return hiredOwned;
    }

    public void setHiredOwned(Integer hiredOwned) {
        this.hiredOwned = hiredOwned;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public Integer getUsedHours() {
        return usedHours;
    }

    public void setUsedHours(Integer usedHours) {
        this.usedHours = usedHours;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlTransient
    public Collection<EquipmentParts> getEquipmentPartsCollection() {
        return equipmentPartsCollection;
    }

    public void setEquipmentPartsCollection(Collection<EquipmentParts> equipmentPartsCollection) {
        this.equipmentPartsCollection = equipmentPartsCollection;
    }

    @XmlTransient
    public Collection<EquipmentMaintenance> getEquipmentMaintenanceCollection() {
        return equipmentMaintenanceCollection;
    }

    public void setEquipmentMaintenanceCollection(Collection<EquipmentMaintenance> equipmentMaintenanceCollection) {
        this.equipmentMaintenanceCollection = equipmentMaintenanceCollection;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public Currency getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Currency currencyId) {
        this.currencyId = currencyId;
    }

    public EquipmentCategory getEquipmentCategoryId() {
        return equipmentCategoryId;
    }

    public void setEquipmentCategoryId(EquipmentCategory equipmentCategoryId) {
        this.equipmentCategoryId = equipmentCategoryId;
    }

    @XmlTransient
    public Collection<EquipmentFinancing> getEquipmentFinancingCollection() {
        return equipmentFinancingCollection;
    }

    public void setEquipmentFinancingCollection(Collection<EquipmentFinancing> equipmentFinancingCollection) {
        this.equipmentFinancingCollection = equipmentFinancingCollection;
    }

    @XmlTransient
    public Collection<EquipmentInsurance> getEquipmentInsuranceCollection() {
        return equipmentInsuranceCollection;
    }

    public void setEquipmentInsuranceCollection(Collection<EquipmentInsurance> equipmentInsuranceCollection) {
        this.equipmentInsuranceCollection = equipmentInsuranceCollection;
    }

    @XmlTransient
    public Collection<RoadRegistration> getRoadRegistrationCollection() {
        return roadRegistrationCollection;
    }

    public void setRoadRegistrationCollection(Collection<RoadRegistration> roadRegistrationCollection) {
        this.roadRegistrationCollection = roadRegistrationCollection;
    }

    @XmlTransient
    public Collection<RepairOrder> getRepairOrderCollection() {
        return repairOrderCollection;
    }

    public void setRepairOrderCollection(Collection<RepairOrder> repairOrderCollection) {
        this.repairOrderCollection = repairOrderCollection;
    }

    @XmlTransient
    public Collection<MaintenanceSchedules> getMaintenanceSchedulesCollection() {
        return maintenanceSchedulesCollection;
    }

    public void setMaintenanceSchedulesCollection(Collection<MaintenanceSchedules> maintenanceSchedulesCollection) {
        this.maintenanceSchedulesCollection = maintenanceSchedulesCollection;
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
        if (!(object instanceof Equipment)) {
            return false;
        }
        Equipment other = (Equipment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + "";
    }
    //added
    private String makeEngine;
    private String country;
    private String modelNo;
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMakeEngine() {
        return makeEngine;
    }

    public void setMakeEngine(String makeEngine) {
        this.makeEngine = makeEngine;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
}
