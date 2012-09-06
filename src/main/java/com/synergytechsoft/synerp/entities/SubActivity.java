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
@Table(name = "sub_activity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubActivity.findAll", query = "SELECT s FROM SubActivity s"),
    @NamedQuery(name = "SubActivity.findById", query = "SELECT s FROM SubActivity s WHERE s.id = :id"),
    @NamedQuery(name = "SubActivity.findByName", query = "SELECT s FROM SubActivity s WHERE s.name = :name"),
    @NamedQuery(name = "SubActivity.findByParentId", query = "SELECT s FROM SubActivity s WHERE s.parentId = :parentId")})
public class SubActivity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "parent_id")
    private Integer parentId;
    @ManyToMany(mappedBy = "subActivityCollection")
    private Collection<Subcontractor> subcontractorCollection;
    @OneToMany(mappedBy = "subActivityId")
    private Collection<SubActivity> subActivityCollection;
    @JoinColumn(name = "sub_activity_id", referencedColumnName = "id")
    @ManyToOne
    private SubActivity subActivityId;
    @JoinColumn(name = "activity_id", referencedColumnName = "id")
    @ManyToOne
    private Activity activityId;

    public SubActivity() {
    }

    public SubActivity(Integer id) {
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @XmlTransient
    public Collection<Subcontractor> getSubcontractorCollection() {
        return subcontractorCollection;
    }

    public void setSubcontractorCollection(Collection<Subcontractor> subcontractorCollection) {
        this.subcontractorCollection = subcontractorCollection;
    }

    @XmlTransient
    public Collection<SubActivity> getSubActivityCollection() {
        return subActivityCollection;
    }

    public void setSubActivityCollection(Collection<SubActivity> subActivityCollection) {
        this.subActivityCollection = subActivityCollection;
    }

    public SubActivity getSubActivityId() {
        return subActivityId;
    }

    public void setSubActivityId(SubActivity subActivityId) {
        this.subActivityId = subActivityId;
    }

    public Activity getActivityId() {
        return activityId;
    }

    public void setActivityId(Activity activityId) {
        this.activityId = activityId;
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
        if (!(object instanceof SubActivity)) {
            return false;
        }
        SubActivity other = (SubActivity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.synergytechsoft.devkhadka.mavenproject2.entities.SubActivity[ id=" + id + " ]";
    }
    
}
