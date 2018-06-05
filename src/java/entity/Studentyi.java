/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "studentyi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studentyi.findAll", query = "SELECT s FROM Studentyi s")
    , @NamedQuery(name = "Studentyi.findByNomerZachetki", query = "SELECT s FROM Studentyi s WHERE s.nomerZachetki = :nomerZachetki")
    , @NamedQuery(name = "Studentyi.findByFamiliya", query = "SELECT s FROM Studentyi s WHERE s.familiya = :familiya")
    , @NamedQuery(name = "Studentyi.findByImya", query = "SELECT s FROM Studentyi s WHERE s.imya = :imya")
    , @NamedQuery(name = "Studentyi.findByOtchestvo", query = "SELECT s FROM Studentyi s WHERE s.otchestvo = :otchestvo")
    , @NamedQuery(name = "Studentyi.findByGorod", query = "SELECT s FROM Studentyi s WHERE s.gorod = :gorod")
    , @NamedQuery(name = "Studentyi.findByAdres", query = "SELECT s FROM Studentyi s WHERE s.adres = :adres")
    , @NamedQuery(name = "Studentyi.findByTel", query = "SELECT s FROM Studentyi s WHERE s.tel = :tel")
    , @NamedQuery(name = "Studentyi.findByStatus", query = "SELECT s FROM Studentyi s WHERE s.status = :status")
    , @NamedQuery(name = "Studentyi.findByStatusDate", query = "SELECT s FROM Studentyi s WHERE s.statusDate = :statusDate")})
public class Studentyi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NomerZachetki")
    private Long nomerZachetki;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Familiya")
    private String familiya;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Imya")
    private String imya;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Otchestvo")
    private String otchestvo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Gorod")
    private String gorod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "Adres")
    private String adres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Tel")
    private String tel;
    @Size(max = 50)
    @Column(name = "Status")
    private String status;
    @Column(name = "StatusDate")
    @Temporal(TemporalType.DATE)
    private Date statusDate;
    @JoinColumn(name = "ShifrGruppyi", referencedColumnName = "Shifr")
    @ManyToOne(optional = false)
    private Gruppyi shifrGruppyi;

    public Studentyi() {
    }

    public Studentyi(Long nomerZachetki) {
        this.nomerZachetki = nomerZachetki;
    }

    public Studentyi(Long nomerZachetki, String familiya, String imya, String otchestvo, String gorod, String adres, String tel) {
        this.nomerZachetki = nomerZachetki;
        this.familiya = familiya;
        this.imya = imya;
        this.otchestvo = otchestvo;
        this.gorod = gorod;
        this.adres = adres;
        this.tel = tel;
    }

    public Long getNomerZachetki() {
        return nomerZachetki;
    }

    public void setNomerZachetki(Long nomerZachetki) {
        this.nomerZachetki = nomerZachetki;
    }

    public String getFamiliya() {
        return familiya;
    }

    public void setFamiliya(String familiya) {
        this.familiya = familiya;
    }

    public String getImya() {
        return imya;
    }

    public void setImya(String imya) {
        this.imya = imya;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public String getGorod() {
        return gorod;
    }

    public void setGorod(String gorod) {
        this.gorod = gorod;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public Gruppyi getShifrGruppyi() {
        return shifrGruppyi;
    }

    public void setShifrGruppyi(Gruppyi shifrGruppyi) {
        this.shifrGruppyi = shifrGruppyi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomerZachetki != null ? nomerZachetki.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studentyi)) {
            return false;
        }
        Studentyi other = (Studentyi) object;
        if ((this.nomerZachetki == null && other.nomerZachetki != null) || (this.nomerZachetki != null && !this.nomerZachetki.equals(other.nomerZachetki))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Studentyi[ nomerZachetki=" + nomerZachetki + " ]";
    }
    
}
