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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "purchase_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseOrder.findAll", query = "SELECT p FROM PurchaseOrder p"),
    @NamedQuery(name = "PurchaseOrder.findById", query = "SELECT p FROM PurchaseOrder p WHERE p.id = :id"),
    @NamedQuery(name = "PurchaseOrder.findByNumber", query = "SELECT p FROM PurchaseOrder p WHERE p.number = :number"),
    @NamedQuery(name = "PurchaseOrder.findByCompany", query = "SELECT p FROM PurchaseOrder p WHERE p.company = :company"),
    @NamedQuery(name = "PurchaseOrder.findByAmount", query = "SELECT p FROM PurchaseOrder p WHERE p.amount = :amount"),
    @NamedQuery(name = "PurchaseOrder.findByProject", query = "SELECT p FROM PurchaseOrder p WHERE p.project = :project"),
    @NamedQuery(name = "PurchaseOrder.findBySupplierVatPan", query = "SELECT p FROM PurchaseOrder p WHERE p.supplierVatPan = :supplierVatPan")})
public class PurchaseOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "number")
    private String number;
    @Lob
    @Size(max = 65535)
    @Column(name = "terms_conditions")
    private String termsConditions;
    @Size(max = 45)
    @Column(name = "company")
    private String company;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Size(max = 45)
    @Column(name = "project")
    private String project;
    @Column(name = "supplier_vat_pan")
    private Integer supplierVatPan;
    @Lob
    @Size(max = 65535)
    @Column(name = "external_doc_number")
    private String externalDocNumber;
    @Lob
    @Size(max = 65535)
    @Column(name = "currency")
    private String currency;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderId")
    private Collection<PurchaseOrderDetails> purchaseOrderDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderId")
    private Collection<PurchaseCosts> purchaseCostsCollection;
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Supplier supplierId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderId")
    private Collection<ForeignPurchase> foreignPurchaseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderId")
    private Collection<LocalPurchase> localPurchaseCollection;
    
    @Transient
    private ForeignPurchase foreignPurchase;

    public ForeignPurchase getForeignPurchase() {
        return foreignPurchase;
    }

    public void setForeignPurchase(ForeignPurchase foreignPurchase) {
        this.foreignPurchase = foreignPurchase;
    }

    public PurchaseOrder() {
    }

    public PurchaseOrder(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTermsConditions() {
        return termsConditions;
    }

    public void setTermsConditions(String termsConditions) {
        this.termsConditions = termsConditions;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Integer getSupplierVatPan() {
        return supplierVatPan;
    }

    public void setSupplierVatPan(Integer supplierVatPan) {
        this.supplierVatPan = supplierVatPan;
    }

    public String getExternalDocNumber() {
        return externalDocNumber;
    }

    public void setExternalDocNumber(String externalDocNumber) {
        this.externalDocNumber = externalDocNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @XmlTransient
    public Collection<PurchaseOrderDetails> getPurchaseOrderDetailsCollection() {
        return purchaseOrderDetailsCollection;
    }

    public void setPurchaseOrderDetailsCollection(Collection<PurchaseOrderDetails> purchaseOrderDetailsCollection) {
        this.purchaseOrderDetailsCollection = purchaseOrderDetailsCollection;
    }

    @XmlTransient
    public Collection<PurchaseCosts> getPurchaseCostsCollection() {
        return purchaseCostsCollection;
    }

    public void setPurchaseCostsCollection(Collection<PurchaseCosts> purchaseCostsCollection) {
        this.purchaseCostsCollection = purchaseCostsCollection;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }

    @XmlTransient
    public Collection<ForeignPurchase> getForeignPurchaseCollection() {
        return foreignPurchaseCollection;
    }

    public void setForeignPurchaseCollection(Collection<ForeignPurchase> foreignPurchaseCollection) {
        this.foreignPurchaseCollection = foreignPurchaseCollection;
    }

    @XmlTransient
    public Collection<LocalPurchase> getLocalPurchaseCollection() {
        return localPurchaseCollection;
    }

    public void setLocalPurchaseCollection(Collection<LocalPurchase> localPurchaseCollection) {
        this.localPurchaseCollection = localPurchaseCollection;
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
        if (!(object instanceof PurchaseOrder)) {
            return false;
        }
        PurchaseOrder other = (PurchaseOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PurchaseOrder[ id=" + id + " ]";
    }
    
}
