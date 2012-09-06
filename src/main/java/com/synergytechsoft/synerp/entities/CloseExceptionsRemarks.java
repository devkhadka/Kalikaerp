/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "close_exceptions_remarks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CloseExceptionsRemarks.findAll", query = "SELECT c FROM CloseExceptionsRemarks c"),
    @NamedQuery(name = "CloseExceptionsRemarks.findById", query = "SELECT c FROM CloseExceptionsRemarks c WHERE c.id = :id"),
    @NamedQuery(name = "CloseExceptionsRemarks.findByPoNumber", query = "SELECT c FROM CloseExceptionsRemarks c WHERE c.poNumber = :poNumber"),
    @NamedQuery(name = "CloseExceptionsRemarks.findByStoNumber", query = "SELECT c FROM CloseExceptionsRemarks c WHERE c.stoNumber = :stoNumber"),
    @NamedQuery(name = "CloseExceptionsRemarks.findByRemarks", query = "SELECT c FROM CloseExceptionsRemarks c WHERE c.remarks = :remarks")})
public class CloseExceptionsRemarks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "po_number")
    private String poNumber;
    @Size(max = 45)
    @Column(name = "sto_number")
    private String stoNumber;
    @Size(max = 45)
    @Column(name = "remarks")
    private String remarks;
    @JoinColumn(name = "store_receive_fine_details_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StoreReceiveFineDetails storeReceiveFineDetailsId;

    public CloseExceptionsRemarks() {
    }

    public CloseExceptionsRemarks(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getStoNumber() {
        return stoNumber;
    }

    public void setStoNumber(String stoNumber) {
        this.stoNumber = stoNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public StoreReceiveFineDetails getStoreReceiveFineDetailsId() {
        return storeReceiveFineDetailsId;
    }

    public void setStoreReceiveFineDetailsId(StoreReceiveFineDetails storeReceiveFineDetailsId) {
        this.storeReceiveFineDetailsId = storeReceiveFineDetailsId;
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
        if (!(object instanceof CloseExceptionsRemarks)) {
            return false;
        }
        CloseExceptionsRemarks other = (CloseExceptionsRemarks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.CloseExceptionsRemarks[ id=" + id + " ]";
    }
    
}
