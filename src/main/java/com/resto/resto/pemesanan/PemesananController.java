package com.resto.resto.pemesanan;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resto.resto.dto.PemesananProduk;
import com.resto.resto.dto.ResponseData;

@RestController
@RequestMapping("/api/pemesanan")
@CrossOrigin(origins = "http://localhost:3000")

public class PemesananController {

    @Autowired
    private PemesananServices pemesananServices;

    @PostMapping
    public ResponseEntity<ResponseData<Pemesanan>> postProgram(@Valid @RequestBody Pemesanan pemesanan, Errors errors) {
        ResponseData<Pemesanan> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }

            responseData.setResult(false);
            responseData.setData(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setResult(true);
        List<Pemesanan> value = new ArrayList<>();
        value.add(pemesananServices.save(pemesanan));
        responseData.setData(value);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public ResponseEntity<ResponseData<Pemesanan>> fetchPrograms() {
        ResponseData<Pemesanan> responseData = new ResponseData<>();
        try {
            responseData.setResult(true);
            List<Pemesanan> value = (List<Pemesanan>) pemesananServices.findAll();
            responseData.setData(value);

            return ResponseEntity.ok(responseData);
        } catch (Exception ex) {
            responseData.setResult(false);
            responseData.getMessage().add(ex.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @GetMapping("/{id_pemesanan}")
    public ResponseEntity<ResponseData<Pemesanan>> fetchProgramsById(@PathVariable("id") int id) {
        ResponseData<Pemesanan> responseData = new ResponseData<>();
        try {
            responseData.setResult(true);
            List<Pemesanan> value = new ArrayList<>();
            value.add(pemesananServices.findOne(id));
            responseData.setData(value);

            return ResponseEntity.ok(responseData);
        } catch (Exception ex) {
            responseData.setResult(false);
            responseData.getMessage().add(ex.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @PutMapping
    public ResponseEntity<ResponseData<Pemesanan>> updateProgram(@Valid @RequestBody Pemesanan pemesanan,
            Errors errors) {
        ResponseData<Pemesanan> responseData = new ResponseData<>();
        if (pemesanan.getId_pemesanan() != 0) {

            if (errors.hasErrors()) {
                for (ObjectError error : errors.getAllErrors()) {
                    responseData.getMessage().add(error.getDefaultMessage());
                }

                responseData.setResult(false);
                responseData.setData(null);

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }
            responseData.setResult(true);
            List<Pemesanan> value = new ArrayList<>();
            value.add(pemesananServices.save(pemesanan));
            responseData.setData(value);

            return ResponseEntity.ok(responseData);
        } else {
            responseData.setResult(false);
            responseData.getMessage().add("ID is Required");
            responseData.setData(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseData<Void>> deleteProgramsById(@PathVariable("id") int id) {
        ResponseData<Void> responseData = new ResponseData<>();
        try {
            pemesananServices.removeOne(id);
            responseData.setResult(true);
            responseData.getMessage().add("Successfully Remove");

            return ResponseEntity.ok(responseData);
        } catch (Exception ex) {
            responseData.setResult(false);
            responseData.getMessage().add(ex.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @PostMapping("/order")
    public ResponseEntity<ResponseData<PemesananProduk>> postPemesanan(
            @Valid @RequestBody PemesananProduk pemesananProduk,
            Errors errors) {
        ResponseData<PemesananProduk> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }

            responseData.setResult(false);
            responseData.setData(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setResult(true);
        List<PemesananProduk> value = new ArrayList<>();
        pemesananServices.order(pemesananProduk.getId_pemesanan(), pemesananProduk.getId_menu(),
                pemesananProduk.getQuantity());
        // value.add();
        // responseData.setData(value);

        return ResponseEntity.ok(responseData);
    }

}