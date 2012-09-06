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
@Table(name = "project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
    @NamedQuery(name = "Project.findById", query = "SELECT p FROM Project p WHERE p.id = :id"),
    @NamedQuery(name = "Project.findByName", query = "SELECT p FROM Project p WHERE p.name = :name"),
    @NamedQuery(name = "Project.findByAlias", query = "SELECT p FROM Project p WHERE p.alias = :alias"),
    @NamedQuery(name = "Project.findByVatPan", query = "SELECT p FROM Project p WHERE p.vatPan = :vatPan"),
    @NamedQuery(name = "Project.findByRegistrationName", query = "SELECT p FROM Project p WHERE p.registrationName = :registrationName"),
    @NamedQuery(name = "Project.findByTaxOffice", query = "SELECT p FROM Project p WHERE p.taxOffice = :taxOffice"),
    @NamedQuery(name = "Project.findByPicture", query = "SELECT p FROM Project p WHERE p.picture = :picture"),
    @NamedQuery(name = "Project.findByFile", query = "SELECT p FROM Project p WHERE p.file = :file"),
    @NamedQuery(name = "Project.findByFile1", query = "SELECT p FROM Project p WHERE p.file1 = :file1"),
    @NamedQuery(name = "Project.findByTelephoneNo", query = "SELECT p FROM Project p WHERE p.telephoneNo = :telephoneNo"),
    @NamedQuery(name = "Project.findByEmailId", query = "SELECT p FROM Project p WHERE p.emailId = :emailId"),
    @NamedQuery(name = "Project.findByPoBoxNumber", query = "SELECT p FROM Project p WHERE p.poBoxNumber = :poBoxNumber"),
    @NamedQuery(name = "Project.findByPostalAddress", query = "SELECT p FROM Project p WHERE p.postalAddress = :postalAddress")})
public class Project implements Serializable {
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
    @Size(max = 45)
    @Column(name = "alias")
    private String alias;
    @Lob
    @Size(max = 65535)
    @Column(name = "address")
    private String address;
    @Column(name = "vat_pan")
    private Integer vatPan;
    @Size(max = 45)
    @Column(name = "registration_name")
    private String registrationName;
    @Size(max = 45)
    @Column(name = "tax_office")
    private String taxOffice;
    @Size(max = 45)
    @Column(name = "picture")
    private String picture;
    @Size(max = 45)
    @Column(name = "file")
    private String file;
    @Size(max = 45)
    @Column(name = "file1")
    private String file1;
    @Column(name = "telephone_no")
    private Integer telephoneNo;
    @Size(max = 45)
    @Column(name = "email_id")
    private String emailId;
    @Lob
    @Size(max = 65535)
    @Column(name = "website")
    private String website;
    @Size(max = 45)
    @Column(name = "po_box_number")
    private String poBoxNumber;
    @Size(max = 45)
    @Column(name = "postal_address")
    private String postalAddress;
    @ManyToMany(mappedBy = "projectCollection")
    private Collection<Repairs> repairsCollection;
    @ManyToMany(mappedBy = "projectCollection")
    private Collection<Stores> storesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId")
    private Collection<Subcontractor> subcontractorCollection;
    @OneToMany(mappedBy = "projectId")
    private Collection<PurchaseRequestMaterial> purchaseRequestMaterialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId")
    private Collection<RequistionMaterialProject> requistionMaterialProjectCollection;
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Currency currencyId;
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country countryId;
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Company companyId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId")
    private Collection<Activity> activityCollection;

    public Project() {
    }

    public Project(Integer id) {
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getVatPan() {
        return vatPan;
    }

    public void setVatPan(Integer vatPan) {
        this.vatPan = vatPan;
    }

    public String getRegistrationName() {
        return registrationName;
    }

    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName;
    }

    public String getTaxOffice() {
        return taxOffice;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFile1() {
        return file1;
    }

    public void setFile1(String file1) {
        this.file1 = file1;
    }

    public Integer getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(Integer telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPoBoxNumber() {
        return poBoxNumber;
    }

    public void setPoBoxNumber(String poBoxNumber) {
        this.poBoxNumber = poBoxNumber;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    @XmlTransient
    public Collection<Repairs> getRepairsCollection() {
        return repairsCollection;
    }

    public void setRepairsCollection(Collection<Repairs> repairsCollection) {
        this.repairsCollection = repairsCollection;
    }

    @XmlTransient
    public Collection<Stores> getStoresCollection() {
        return storesCollection;
    }

    public void setStoresCollection(Collection<Stores> storesCollection) {
        this.storesCollection = storesCollection;
    }

    @XmlTransient
    public Collection<Subcontractor> getSubcontractorCollection() {
        return subcontractorCollection;
    }

    public void setSubcontractorCollection(Collection<Subcontractor> subcontractorCollection) {
        this.subcontractorCollection = subcontractorCollection;
    }

    @XmlTransient
    public Collection<PurchaseRequestMaterial> getPurchaseRequestMaterialCollection() {
        return purchaseRequestMaterialCollection;
    }

    public void setPurchaseRequestMaterialCollection(Collection<PurchaseRequestMaterial> purchaseRequestMaterialCollection) {
        this.purchaseRequestMaterialCollection = purchaseRequestMaterialCollection;
    }

    @XmlTransient
    public Collection<RequistionMaterialProject> getRequistionMaterialProjectCollection() {
        return requistionMaterialProjectCollection;
    }

    public void setRequistionMaterialProjectCollection(Collection<RequistionMaterialProject> requistionMaterialProjectCollection) {
        this.requistionMaterialProjectCollection = requistionMaterialProjectCollection;
    }

    public Currency getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Currency currencyId) {
        this.currencyId = currencyId;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    @XmlTransient
    public Collection<Activity> getActivityCollection() {
        return activityCollection;
    }

    public void setActivityCollection(Collection<Activity> activityCollection) {
        this.activityCollection = activityCollection;
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
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  id + "";
    }
    
}
