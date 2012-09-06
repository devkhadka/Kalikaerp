/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "close_slips")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CloseSlips.findAll", query = "SELECT c FROM CloseSlips c"),
    @NamedQuery(name = "CloseSlips.findById", query = "SELECT c FROM CloseSlips c WHERE c.id = :id")})
public class CloseSlips implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "slip_number", referencedColumnName = "slip_number")
    @ManyToOne(optional = false)
    private IssueFuelNFluidSlip slipNumber;

    public CloseSlips() {
    }

    public CloseSlips(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IssueFuelNFluidSlip getSlipNumber() {
        return slipNumber;
    }

    public void setSlipNumber(IssueFuelNFluidSlip slipNumber) {
        this.slipNumber = slipNumber;
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
        if (!(object instanceof CloseSlips)) {
            return false;
        }
        CloseSlips other = (CloseSlips) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.CloseSlips[ id=" + id + " ]";
    }
    
}
