package com.resto.resto.pemesanan;

import javax.swing.plaf.TreeUI;
import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.resto.resto.dto.PemesananProduk;

public interface PemesananRepo extends CrudRepository<Pemesanan, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO pemesanan_produk  (id_pemesanan, id_menu, quantity) VALUES (:id_pemesanan, :id_menu, :quantity)", nativeQuery = true)
    public void order(@PathParam("id_pemesanan") int id_pemesanan, @PathParam("id_menu") int id_menu,
            @PathParam("quantity") int quantity);
}
