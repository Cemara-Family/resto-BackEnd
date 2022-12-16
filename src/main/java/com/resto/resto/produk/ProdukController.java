package com.resto.resto.produk;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
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
@RequestMapping("/api/produk")
public class ProdukController {
    
    @Autowired
    private ProdukServices produkServices;

    @PostMapping
    // public Produk posProduk(@RequestBody Produk produk){
    //     return produkServices.save(produk);
    // }
    public ResponseEntity<ResponseData<Produk>> postProduk(@Valid @RequestBody Produk produk, Errors errors){
        ResponseData<Produk> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setResult(false);
            responseData.setData(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setResult(true);
        List<Produk> value = new ArrayList<>();
        value.add(produkServices.save(produk));
        responseData.setData(value);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
  

    public ResponseEntity<ResponseData<Produk>> fetchProduk(){
        ResponseData<Produk> responseData = new ResponseData<>();
        try {
            responseData.setResult(true);
            Iterable<Produk> value = produkServices.findAll();
            responseData.setData(value);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            responseData.setResult(false);
            responseData.getMessage().add(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }
    @GetMapping("/{idMenu}")
    // public Produk fetchProdukById(@PathVariable("idMenu") int idMenu){
    //     return produkServices.findOne(idMenu);
    // }
    public ResponseEntity<ResponseData<Produk>> fetchProdukByIdMenu(){
        ResponseData<Produk> responseData = new ResponseData<>();
        try {
            responseData.setResult(true);
            Iterable<Produk> value = produkServices.findAll();
            responseData.setData(value);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            responseData.setResult(false);
            responseData.getMessage().add(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }
    

    @PutMapping
    // public Produk updateProduk(@RequestBody Produk produk){
    //     return produkServices.save(produk);
    // }
    public ResponseEntity<ResponseData<Produk>> updateProduk(
        @Valid @RequestBody Produk produk, Errors errors){
            ResponseData<Produk> responseData = new ResponseData<>();
            if(errors.hasErrors()){
                for(ObjectError error : errors.getAllErrors()){
                    responseData.getMessage().add(error.getDefaultMessage());
                }
                responseData.setResult(false);
                responseData.setData(null);
              return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(responseData);
            }
            try {
                responseData.setResult(true);
                List<Produk> value = new ArrayList<>();
                value.add(produkServices.update(produk));
                responseData.setData(value);
                return ResponseEntity.ok(responseData);
            } catch (Exception e) {
                // TODO: handle exception
                responseData.getMessage().add("Id is required");
                responseData.setResult(false);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

            }
        }


    @DeleteMapping("/{idMenu}")
    // public void deleteProdukById(@PathVariable("idMenu") int idMenu){
    //     produkServices.removeOne(idMenu);
    // }
    public ResponseEntity<ResponseData<Void>> deleteProdukById(@PathVariable("idMenu") int idMenu){
        ResponseData<Void> responseData = new ResponseData<>();

        try {
            produkServices.removeOne(idMenu);
            responseData.setResult(true);
            responseData.getMessage().add("Successfully Removed");

            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
           responseData.setResult(false);
           responseData.getMessage().add(e.getMessage());

           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

}

