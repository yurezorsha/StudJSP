/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "gruppyi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gruppyi.findAll", query = "SELECT g FROM Gruppyi g")
    , @NamedQuery(name = "Gruppyi.findByNazvanie", query = "SELECT g FROM Gruppyi g WHERE g.nazvanie = :nazvanie")
    , @NamedQuery(name = "Gruppyi.findByShifr", query = "SELECT g FROM Gruppyi g WHERE g.shifr = :shifr")
    , @NamedQuery(name = "Gruppyi.findByDataFormir", query = "SELECT g FROM Gruppyi g WHERE g.dataFormir = :dataFormir")
    , @NamedQuery(name = "Gruppyi.findByKodPlana", query = "SELECT g FROM Gruppyi g WHERE g.kodPlana = :kodPlana")
    , @NamedQuery(name = "Gruppyi.findByStatus", query = "SELECT g FROM Gruppyi g WHERE g.status = :status")
    , @NamedQuery(name = "Gruppyi.findByStatusDate", query = "SELECT g FROM Gruppyi g WHERE g.statusDate = :statusDate")})
public class Gruppyi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nazvanie")
    private String nazvanie;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Shifr")
    private Integer shifr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DataFormir")
    @Temporal(TemporalType.DATE)
    private Date dataFormir;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KodPlana")
    private int kodPlana;
    @Size(max = 50)
    @Column(name = "Status")
    private String status;
    @Column(name = "StatusDate")
    @Temporal(TemporalType.DATE)
    private Date statusDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shifrGruppyi")
    private Collection<Studentyi> studentyiCollection;

    public Gruppyi() {
    }

    public Gruppyi(Integer shifr) {
        this.shifr = shifr;
    }

    public Gruppyi(Integer shifr, String nazvanie, Date dataFormir, int kodPlana) {
        this.shifr = shifr;
        this.nazvanie = nazvanie;
        this.dataFormir = dataFormir;
        this.kodPlana = kodPlana;
    }

    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    public Integer getShifr() {
        return shifr;
    }

    public void setShifr(Integer shifr) {
        this.shifr = shifr;
    }

    public Date getDataFormir() {
        return dataFormir;
    }

    public void setDataFormir(Date dataFormir) {
        this.dataFormir = dataFormir;
    }

    public int getKodPlana() {
        return kodPlana;
    }

    public void setKodPlana(int kodPlana) {
        this.kodPlana = kodPlana;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    @XmlTransient
    public Collection<Studentyi> getStudentyiCollection() {
        return studentyiCollection;
    }

    public void setStudentyiCollection(Collection<Studentyi> studentyiCollection) {
        this.studentyiCollection = studentyiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shifr != null ? shifr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gruppyi)) {
            return false;
        }
        Gruppyi other = (Gruppyi) object;
        if ((this.shifr == null && other.shifr != null) || (this.shifr != null && !this.shifr.equals(other.shifr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getNazvanie();
    }
    
}
