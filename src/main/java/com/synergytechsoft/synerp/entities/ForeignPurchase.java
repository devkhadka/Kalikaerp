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
@Table(name = "foreign_purchase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ForeignPurchase.findAll", query = "SELECT f FROM ForeignPurchase f"),
    @NamedQuery(name = "ForeignPurchase.findById", query = "SELECT f FROM ForeignPurchase f WHERE f.id = :id"),
    @NamedQuery(name = "ForeignPurchase.findByInsurance", query = "SELECT f FROM ForeignPurchase f WHERE f.insurance = :insurance"),
    @NamedQuery(name = "ForeignPurchase.findByFreight", query = "SELECT f FROM ForeignPurchase f WHERE f.freight = :freight"),
    @NamedQuery(name = "ForeignPurchase.findByLcChargeBankCommission", query = "SELECT f FROM ForeignPurchase f WHERE f.lcChargeBankCommission = :lcChargeBankCommission"),
    @NamedQuery(name = "ForeignPurchase.findByDockCharges", query = "SELECT f FROM ForeignPurchase f WHERE f.dockCharges = :dockCharges"),
    @NamedQuery(name = "ForeignPurchase.findByLoadUnloadCharges", query = "SELECT f FROM ForeignPurchase f WHERE f.loadUnloadCharges = :loadUnloadCharges"),
    @NamedQuery(name = "ForeignPurchase.findByClearingForwardingCharges", query = "SELECT f FROM ForeignPurchase f WHERE f.clearingForwardingCharges = :clearingForwardingCharges"),
    @NamedQuery(name = "ForeignPurchase.findByOtherIncidientalExpenses", query = "SELECT f FROM ForeignPurchase f WHERE f.otherIncidientalExpenses = :otherIncidientalExpenses"),
    @NamedQuery(name = "ForeignPurchase.findByImn", query = "SELECT f FROM ForeignPurchase f WHERE f.imn = :imn"),
    @NamedQuery(name = "ForeignPurchase.findByExchangeRate", query = "SELECT f FROM ForeignPurchase f WHERE f.exchangeRate = :exchangeRate"),
    @NamedQuery(name = "ForeignPurchase.findByDomesticFrieght", query = "SELECT f FROM ForeignPurchase f WHERE f.domesticFrieght = :domesticFrieght")})
public class ForeignPurchase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "insurance")
    private Double insurance;
    @Column(name = "freight")
    private Double freight;
    @Column(name = "lc_charge_bank_commission")
    private Double lcChargeBankCommission;
    @Column(name = "dock_charges")
    private Double dockCharges;
    @Column(name = "load_unload_charges")
    private Double loadUnloadCharges;
    @Column(name = "clearing_forwarding_charges")
    private Double clearingForwardingCharges;
    @Column(name = "other_incidiental_expenses")
    private Double otherIncidientalExpenses;
    @Size(max = 45)
    @Column(name = "imn")
    private String imn;
    @Column(name = "exchange_rate")
    private Double exchangeRate;
    @Column(name = "domestic_frieght")
    private Double domesticFrieght;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foreignPurchase")
    private Collection<ForeignPurchasePurchaseOrderDetails> foreignPurchasePurchaseOrderDetailsCollection;
    @JoinColumn(name = "purchase_order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PurchaseOrder purchaseOrderId;
    @JoinColumn(name = "import_basis_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ImportBasis importBasisId;

    public ForeignPurchase() {
    }

    public ForeignPurchase(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getInsurance() {
        return insurance;
    }

    public void setInsurance(Double insurance) {
        this.insurance = insurance;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public Double getLcChargeBankCommission() {
        return lcChargeBankCommission;
    }

    public void setLcChargeBankCommission(Double lcChargeBankCommission) {
        this.lcChargeBankCommission = lcChargeBankCommission;
    }

    public Double getDockCharges() {
        return dockCharges;
    }

    public void setDockCharges(Double dockCharges) {
        this.dockCharges = dockCharges;
    }

    public Double getLoadUnloadCharges() {
        return loadUnloadCharges;
    }

    public void setLoadUnloadCharges(Double loadUnloadCharges) {
        this.loadUnloadCharges = loadUnloadCharges;
    }

    public Double getClearingForwardingCharges() {
        return clearingForwardingCharges;
    }

    public void setClearingForwardingCharges(Double clearingForwardingCharges) {
        this.clearingForwardingCharges = clearingForwardingCharges;
    }

    public Double getOtherIncidientalExpenses() {
        return otherIncidientalExpenses;
    }

    public void setOtherIncidientalExpenses(Double otherIncidientalExpenses) {
        this.otherIncidientalExpenses = otherIncidientalExpenses;
    }

    public String getImn() {
        return imn;
    }

    public void setImn(String imn) {
        this.imn = imn;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Double getDomesticFrieght() {
        return domesticFrieght;
    }

    public void setDomesticFrieght(Double domesticFrieght) {
        this.domesticFrieght = domesticFrieght;
    }

    @XmlTransient
    public Collection<ForeignPurchasePurchaseOrderDetails> getForeignPurchasePurchaseOrderDetailsCollection() {
        return foreignPurchasePurchaseOrderDetailsCollection;
    }

    public void setForeignPurchasePurchaseOrderDetailsCollection(Collection<ForeignPurchasePurchaseOrderDetails> foreignPurchasePurchaseOrderDetailsCollection) {
        this.foreignPurchasePurchaseOrderDetailsCollection = foreignPurchasePurchaseOrderDetailsCollection;
    }

    public PurchaseOrder getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(PurchaseOrder purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public ImportBasis getImportBasisId() {
        return importBasisId;
    }

    public void setImportBasisId(ImportBasis importBasisId) {
        this.importBasisId = importBasisId;
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
        if (!(object instanceof ForeignPurchase)) {
            return false;
        }
        ForeignPurchase other = (ForeignPurchase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.ForeignPurchase[ id=" + id + " ]";
    }
    
}
