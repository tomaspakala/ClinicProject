/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Tomas
 */
@Entity
@Table(name = "ILLNESS")
@NamedQueries({
    @NamedQuery(name = "Illness.findAll", query = "SELECT i FROM Illness i"),
    @NamedQuery(name = "Illness.findById", query = "SELECT i FROM Illness i WHERE i.id = :id"),
    @NamedQuery(name = "Illness.findByCategory", query = "SELECT i FROM Illness i WHERE i.category = :category"),
    @NamedQuery(name = "Illness.findByIllnessCode", query = "SELECT i FROM Illness i WHERE i.illnessCode = :illnessCode")})
public class Illness implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "CATEGORY")
    private String category;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ILLNESS_CODE")
    private Double illnessCode;
    @ManyToMany(mappedBy = "illnessSet")
    private Set<Patient> patientSet;

    public Illness() {
    }

    public Illness(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getIllnessCode() {
        return illnessCode;
    }

    public void setIllnessCode(Double illnessCode) {
        this.illnessCode = illnessCode;
    }

    public Set<Patient> getPatientSet() {
        return patientSet;
    }

    public void setPatientSet(Set<Patient> patientSet) {
        this.patientSet = patientSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (illnessCode != null ? illnessCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Illness)) {
            return false;
        }
        Illness other = (Illness) object;
        if (this.patientSet.size() == other.patientSet.size()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "entities.Illness[ id=" + id + " ]";
    }
    
}
