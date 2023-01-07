package com.resto.resto.produk;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProdukServices {
    
    @Autowired
    private ProdukRepo produkRepo;

    public Produk save(Produk produk){
        return produkRepo.save(produk);
    }

    public Produk update(Produk produk){
        Produk result =findOne(produk.getIdMenu());
       result.setGambar(produk.getGambar());
       result.setHarga(produk.getHarga());
       result.setJenisMenu(produk.getJenisMenu());
       result.setMenu(produk.getMenu());
       result.setStok(produk.getStok());
    return result;
       
    }

    public Produk findOne(int idMenu){
        return produkRepo.findById(idMenu).get();
    }

    public Iterable<Produk> findAll(){
        return produkRepo.findAll();
    }

    public void removeOne(int idMenu){
        produkRepo.deleteById(idMenu);
    }

    
}
