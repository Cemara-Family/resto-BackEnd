package com.resto.resto.produk;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "produk")
public class Produk implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMenu;

    @Column(length = 20)
    @NotEmpty(message = "Menu is Required")
    private String Menu;

    @Column(length = 10)
    private String jenisMenu;

    @Column(length = 30)
    private int Stok;

    @Column(length = 50)
    private Long Harga;

    @Column(length = 20)
    private Blob Gambar;

    public Produk(int idMenu, String menu, String jenisMenu, int stok, Long harga, Blob gambar) {
        this.idMenu = idMenu;
        Menu = menu;
        this.jenisMenu = jenisMenu;
        Stok = stok;
        Harga = harga;
        Gambar = gambar;
    }

    public Produk(){}

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getMenu() {
        return Menu;
    }

    public void setMenu(String menu) {
        Menu = menu;
    }

    public String getJenisMenu() {
        return jenisMenu;
    }

    public void setJenisMenu(String jenisMenu) {
        this.jenisMenu = jenisMenu;
    }

    public int getStok() {
        return Stok;
    }

    public void setStok(int stok) {
        Stok = stok;
    }

    public Long getHarga() {
        return Harga;
    }

    public void setHarga(Long harga) {
        Harga = harga;
    }

    public Blob getGambar() {
        return Gambar;
    }

    public void setGambar(Blob gambar) {
        Gambar = gambar;
    }

    
    
}
