package com.resto.resto.pemesanan;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.resto.resto.produk.Produk;
import com.resto.resto.user.User;

@Entity
@Table(name = "pemesanan")
public class Pemesanan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pemesanan;

    @Column(columnDefinition = "DATE")
    private String tanggal_pemesanan;

    @Column(length = 11)
    // @OneToMany
    // @JoinColumn(name = "id_user")
    private int id_user;

    @ManyToMany
    @JoinTable(name = "pemesanan_produk", joinColumns = @JoinColumn(name = "id_pemesanan"), inverseJoinColumns = @JoinColumn(name = "id_menu")

    )

    private Set<Produk> produks;

    public Pemesanan() {
    }

    public Pemesanan(int id_pemesanan, String tanggal_pemesanan, int id_user, Set<Produk> produks) {
        this.id_pemesanan = id_pemesanan;
        this.tanggal_pemesanan = tanggal_pemesanan;
        this.id_user = id_user;
        this.produks = produks;
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

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Set<Produk> getProduks() {
        return produks;
    }

    public void setProduks(Set<Produk> produks) {
        this.produks = produks;
    }

}
