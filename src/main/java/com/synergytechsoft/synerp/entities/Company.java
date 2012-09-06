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
@Table(name = "company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
    @NamedQuery(name = "Company.findById", query = "SELECT c FROM Company c WHERE c.id = :id"),
    @NamedQuery(name = "Company.findByName", query = "SELECT c FROM Company c WHERE c.name = :name"),
    @NamedQuery(name = "Company.findByAlias", query = "SELECT c FROM Company c WHERE c.alias = :alias"),
    @NamedQuery(name = "Company.findByAddress", query = "SELECT c FROM Company c WHERE c.address = :address"),
    @NamedQuery(name = "Company.findByVatPan", query = "SELECT c FROM Company c WHERE c.vatPan = :vatPan"),
    @NamedQuery(name = "Company.findByRegistrationNumber", query = "SELECT c FROM Company c WHERE c.registrationNumber = :registrationNumber"),
    @NamedQuery(name = "Company.findByTaxOffice", query = "SELECT c FROM Company c WHERE c.taxOffice = :taxOffice"),
    @NamedQuery(name = "Company.findByPicture", query = "SELECT c FROM Company c WHERE c.picture = :picture"),
    @NamedQuery(name = "Company.findByFile", query = "SELECT c FROM Company c WHERE c.file = :file"),
    @NamedQuery(name = "Company.findByTelephoneNo", query = "SELECT c FROM Company c WHERE c.telephoneNo = :telephoneNo"),
    @NamedQuery(name = "Company.findByEmailId", query = "SELECT c FROM Company c WHERE c.emailId = :emailId"),
    @NamedQuery(name = "Company.findByPoBoxNumber", query = "SELECT c FROM Company c WHERE c.poBoxNumber = :poBoxNumber"),
    @NamedQuery(name = "Company.findByPostalAddress", query = "SELECT c FROM Company c WHERE c.postalAddress = :postalAddress")})
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "alias")
    private String alias;
    @Size(max = 45)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vat_pan")
    private int vatPan;
    @Size(max = 45)
    @Column(name = "registration_number")
    private String registrationNumber;
    @Size(max = 45)
    @Column(name = "tax_office")
    private String taxOffice;
    @Size(max = 255)
    @Column(name = "picture")
    private String picture;
    @Size(max = 255)
    @Column(name = "file")
    private String file;
    @Size(max = 45)
    @Column(name = "telephone_no")
    private String telephoneNo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Collection<Equipment> equipmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Collection<Project> projectCollection;
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Currency currencyId;
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country countryId;
    @JoinColumn(name = "industries_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Industries industriesId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Collection<Repairs> repairsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Collection<Stores> storesCollection;

    public Company() {
    }

    public Company(Integer id) {
        this.id = id;
    }

    public Company(Integer id, String name, int vatPan) {
        this.id = id;
        this.name = name;
        this.vatPan = vatPan;
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

    public int getVatPan() {
        return vatPan;
    }

    public void setVatPan(int vatPan) {
        this.vatPan = vatPan;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
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

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
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
    public Collection<Equipment> getEquipmentCollection() {
        return equipmentCollection;
    }

    public void setEquipmentCollection(Collection<Equipment> equipmentCollection) {
        this.equipmentCollection = equipmentCollection;
    }

    @XmlTransient
    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
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

    public Industries getIndustriesId() {
        return industriesId;
    }

    public void setIndustriesId(Industries industriesId) {
        this.industriesId = industriesId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
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
