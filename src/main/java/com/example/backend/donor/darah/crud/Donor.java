/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.donor.darah.crud;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pascal
 */
@Entity
@Table(name = "donor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donor.findAll", query = "SELECT d FROM Donor d"),
    @NamedQuery(name = "Donor.findByNik", query = "SELECT d FROM Donor d WHERE d.nik = :nik"),
    @NamedQuery(name = "Donor.findByNama", query = "SELECT d FROM Donor d WHERE d.nama = :nama"),
    @NamedQuery(name = "Donor.findByTgllahir", query = "SELECT d FROM Donor d WHERE d.tgllahir = :tgllahir"),
    @NamedQuery(name = "Donor.findBySex", query = "SELECT d FROM Donor d WHERE d.sex = :sex"),
    @NamedQuery(name = "Donor.findByAlamat", query = "SELECT d FROM Donor d WHERE d.alamat = :alamat"),
    @NamedQuery(name = "Donor.findByTelpon", query = "SELECT d FROM Donor d WHERE d.telpon = :telpon"),
    @NamedQuery(name = "Donor.findByGoldar", query = "SELECT d FROM Donor d WHERE d.goldar = :goldar"),
    @NamedQuery(name = "Donor.findByTerakhir", query = "SELECT d FROM Donor d WHERE d.terakhir = :terakhir")})
public class Donor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nik")
    private String nik;
    @Column(name = "nama")
    private String nama;
    @Column(name = "tgllahir")
    @Temporal(TemporalType.DATE)
    private Date tgllahir;
    @Column(name = "sex")
    private String sex;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "telpon")
    private String telpon;
    @Column(name = "goldar")
    private String goldar;
    @Column(name = "terakhir")
    @Temporal(TemporalType.DATE)
    private Date terakhir;

    public Donor() {
    }

    public Donor(String nik) {
        this.nik = nik;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTgllahir() {
        return tgllahir;
    }

    public void setTgllahir(Date tgllahir) {
        this.tgllahir = tgllahir;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    public String getGoldar() {
        return goldar;
    }

    public void setGoldar(String goldar) {
        this.goldar = goldar;
    }

    public Date getTerakhir() {
        return terakhir;
    }

    public void setTerakhir(Date terakhir) {
        this.terakhir = terakhir;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nik != null ? nik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donor)) {
            return false;
        }
        Donor other = (Donor) object;
        if ((this.nik == null && other.nik != null) || (this.nik != null && !this.nik.equals(other.nik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.backend.donor.darah.crud.Donor[ nik=" + nik + " ]";
    }
    
}
