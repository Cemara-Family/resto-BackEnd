package com.resto.resto.user;

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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.resto.resto.pemesanan.Pemesanan;

@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;

    @Column(length = 20)
    @NotEmpty(message = "Username is required")
    private String username;

    @Column(length = 10)
    @NotEmpty(message = "Password is required")
    private String password;

    @Column(length = 30)
    private String fullname;

    @Column(length = 10)
    private String jenis_kelamin;

    @Column(length = 20)
    private String birthdate;

    @Column(length = 50)
    private String alamat;

    @Column(length = 30)
    private String noTelp;

    @OneToMany
    @JoinColumn(name = "id_user")
    private Set<Pemesanan> pemesanans;

    public User() {
    }

    public User(int id_user, @NotEmpty(message = "Username is required") String username,
            @NotEmpty(message = "Password is required") String password, String fullname, String jenis_kelamin,
            String birthdate, String alamat, String noTelp, Set<Pemesanan> pemesanans) {
        this.id_user = id_user;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.jenis_kelamin = jenis_kelamin;
        this.birthdate = birthdate;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.pemesanans = pemesanans;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public Set<Pemesanan> getPemesanans() {
        return pemesanans;
    }

    public void setPemesanans(Set<Pemesanan> pemesanans) {
        this.pemesanans = pemesanans;
    }

}
