package com.resto.resto.pemesananproduk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pemesanan_produk")
public class PemesananProduk implements Serializable{
    
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_menu;

    @Column(length = 50)
    private int jumlah;

    public PemesananProduk() {
    }

    public PemesananProduk( int id_menu, int jumlah) {
        this.id_menu = id_menu;
        this.jumlah = jumlah;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }


    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    
}
