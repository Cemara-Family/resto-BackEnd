package com.resto.resto.pemesanan;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pemesanan")
public class Pemesanan implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pemesanan;

    @Column(columnDefinition = "DATE")
    private String tanggal_pemesanan;

    @Column(length = 50)
    private int total_belanja;

    public Pemesanan() {
    }

    public Pemesanan(int id_pemesanan, String tanggal_pemesanan, int total_belanja) {
        this.id_pemesanan = id_pemesanan;
        this.tanggal_pemesanan = tanggal_pemesanan;
        this.total_belanja = total_belanja;
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

    public int getTotal_belanja() {
        return total_belanja;
    }

    public void setTotal_belanja(int total_belanja) {
        this.total_belanja = total_belanja;
    }

    
}
