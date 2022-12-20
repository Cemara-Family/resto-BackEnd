package com.resto.resto.pemesananproduk;

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

import com.resto.resto.pemesanan.Pemesanan;
import com.resto.resto.user.User;

@Entity
@Table(name = "pemesanan_produk")
public class PemesananProduk implements Serializable{
    
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_menu;

    @Column(length = 50)
    private int qty;

    @OneToMany
    @JoinColumn(name = "id_pemesanan")
    private Set<Pemesanan> id_pemesanan;

    public PemesananProduk() {
    }

    public PemesananProduk(int id_menu, int qty, Set<Pemesanan> id_pemesanan) {
        this.id_menu = id_menu;
        this.qty = qty;
        this.id_pemesanan = id_pemesanan;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Set<Pemesanan> getId_pemesanan() {
        return id_pemesanan;
    }

    public void setId_pemesanan(Set<Pemesanan> id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
    }
    
    
    
   

    
    
    
}
