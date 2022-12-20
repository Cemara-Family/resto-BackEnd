package com.resto.resto.pemesanan;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.resto.resto.user.User;

@Entity
@Table(name = "pemesanan")
public class Pemesanan implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pemesanan;

    @Column(columnDefinition = "DATE")
    private String tanggal_pemesanan;

    @OneToMany
    @JoinColumn(name = "idUser")
    private Set<User> idUser;
    
    public Pemesanan() {
    }

    public Pemesanan(int id_pemesanan, String tanggal_pemesanan, Set<User> idUser) {
        this.id_pemesanan = id_pemesanan;
        this.tanggal_pemesanan = tanggal_pemesanan;
        this.idUser = idUser;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getId_pemesanan() {
        return id_pemesanan;
    }

    public void setId_pemesanan(int id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
    }

    public String getTanggal_pemesanan() {
        return tanggal_pemesanan;
    }

    public void setTanggal_pemesanan(String tanggal_pemesanan) {
        this.tanggal_pemesanan = tanggal_pemesanan;
    }

    public Set<User> getIdUser() {
        return idUser;
    }

    public void setIdUser(Set<User> idUser) {
        this.idUser = idUser;
    }
    

   
    
    
    
}
