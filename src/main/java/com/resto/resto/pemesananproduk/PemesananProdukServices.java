package com.resto.resto.pemesananproduk;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class PemesananProdukServices {

    @Autowired
    private PemesananProdukRepo pemesananprodukRepo;

    public PemesananProduk save(PemesananProduk pemesananProduk) {
        return pemesananprodukRepo.save(pemesananProduk);
    }

    public PemesananProduk findOne(int id) {
        return pemesananprodukRepo.findById(id).get();
    }

    public Iterable<PemesananProduk> findAll() {
        return pemesananprodukRepo.findAll();
    }

    public void removeOne(int id) {
        pemesananprodukRepo.deleteById(id);
        ;
    }

}
