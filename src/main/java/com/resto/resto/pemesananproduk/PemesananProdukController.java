package com.resto.resto.pemesananproduk;

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

import com.resto.resto.dto.ResponseData;

@RestController
@RequestMapping("/api/pemesanan_produk")
@CrossOrigin (origins = "http://localhost:3000")

public class PemesananProdukController {

    @Autowired
    private PemesananProdukServices pemesananprodukServices;

    @PostMapping
    public ResponseEntity<ResponseData<PemesananProduk>> postProgram(@Valid @RequestBody PemesananProduk pemesananProduk, Errors errors) {
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
        value.add(pemesananprodukServices.save(pemesananProduk));
        responseData.setData(value);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public ResponseEntity<ResponseData<PemesananProduk>> fetchPrograms() {
        ResponseData<PemesananProduk> responseData = new ResponseData<>();
        try {
            responseData.setResult(true);
            List<PemesananProduk> value = (List<PemesananProduk>) pemesananprodukServices.findAll();
            responseData.setData(value);

            return ResponseEntity.ok(responseData);
        } catch (Exception ex) {
            responseData.setResult(false);
            responseData.getMessage().add(ex.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @GetMapping("/{id_pemesanan}")
    public ResponseEntity<ResponseData<PemesananProduk>> fetchProgramsById(@PathVariable("id") int id) {
        ResponseData<PemesananProduk> responseData = new ResponseData<>();
        try {
            responseData.setResult(true);
            List<PemesananProduk> value = new ArrayList<>();
            value.add(pemesananprodukServices.findOne(id));
            responseData.setData(value);

            return ResponseEntity.ok(responseData);
        } catch (Exception ex) {
            responseData.setResult(false);
            responseData.getMessage().add(ex.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @PutMapping
    public ResponseEntity<ResponseData<PemesananProduk>> updateProgram(@Valid @RequestBody PemesananProduk pemesananProduk, Errors errors) {
        ResponseData<PemesananProduk> responseData = new ResponseData<>();
        if (pemesananProduk.getId_menu() != 0) {

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
            value.add(pemesananprodukServices.save(pemesananProduk));
            responseData.setData(value);

            return ResponseEntity.ok(responseData);
        } else {
            responseData.setResult(false);
            responseData.getMessage().add("ID is Required");
            responseData.setData(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @DeleteMapping("/{id_pemesanan}")
    public ResponseEntity<ResponseData<Void>> deleteProgramsById(@PathVariable("id") int id) {
        ResponseData<Void> responseData = new ResponseData<>();
        try {
            pemesananprodukServices.removeOne(id);
            responseData.setResult(true);
            responseData.getMessage().add("Successfully Remove");

            return ResponseEntity.ok(responseData);
        } catch (Exception ex) {
            responseData.setResult(false);
            responseData.getMessage().add(ex.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

}