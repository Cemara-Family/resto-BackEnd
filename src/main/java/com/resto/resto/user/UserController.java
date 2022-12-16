package com.resto.resto.user;

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

import com.resto.resto.dto.Auth;
import com.resto.resto.dto.ResponseData;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserServices userServices;

    @PostMapping
    // public User posUser(@RequestBody User user){
    //     return userServices.save(user);
    // }

    public ResponseEntity<ResponseData<User>> postUser (@Valid @RequestBody 
    User user, Errors errors){
        ResponseData<User> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setResult(false);
            responseData.setData(null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setResult(true);
        List<User> value = new ArrayList<>();
        value.add(userServices.save(user));
        responseData.setData(value);
        return ResponseEntity.ok(responseData);
        
    }
    @GetMapping
    // public Iterable<User> fetchUser(){
    //     return userServices.findAll();
    // }
    public ResponseEntity<ResponseData<User>> fetchUser(){
        ResponseData<User> responseData = new ResponseData<>();
        try {
            responseData.setResult(true);
            Iterable<User> value = userServices.findAll();
            responseData.setData(value);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            responseData.setResult(false);
            responseData.getMessage().add(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @GetMapping("/{id}")
    // public User fetchUserById(@PathVariable("id") int id){
    //     return userServices.findOne(id);
    // }
    public ResponseEntity<ResponseData<User>>fetchUserById(@PathVariable("id") int id){
        ResponseData<User> responseData = new ResponseData<>();

        try {
            responseData.setResult(true);
            List<User> value = new ArrayList<>();
            value.add(userServices.findOne(id));
            responseData.setData(value);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            responseData.setResult(false);
            responseData.getMessage().add(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @PutMapping
    // public User updatUser(@RequestBody User user){
    //     return userServices.save(user);
    // }
    public ResponseEntity<ResponseData<User>> updateUser(
        @Valid @RequestBody User user, Errors errors){
            ResponseData<User> responseData = new ResponseData<>();
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
                List<User> value = new ArrayList<>();
                value.add(userServices.update(user));
                responseData.setData(value);
                return ResponseEntity.ok(responseData);
            } catch (Exception e) {
                // TODO: handle exception
                responseData.getMessage().add("Id is required");
                responseData.setResult(false);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

            }
        }

   

    @DeleteMapping("/{id}")
    // public void deleteUserById(@PathVariable("id") int id){
    //     userServices.removeOne(id);
    // }
    public ResponseEntity<ResponseData<Void>> deleteUserById(@PathVariable("id") int id) {
        ResponseData<Void> responseData = new ResponseData<>();

        try {
            userServices.removeOne(id);
            responseData.setResult(true);
            responseData.getMessage().add("Successfully Removed");

            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            responseData.setResult(false);
            responseData.getMessage().add(e.getMessage());
            

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }
    @PostMapping("/auth")
    public ResponseEntity<ResponseData<User>> getUserAuth(@RequestBody Auth auth){
        ResponseData<User> responseData = new ResponseData<>();

        System.out.println(auth.getUsername());
        System.out.println(auth.getPassword());

        try {
            Iterable<User> value = userServices.findAuth(auth.getUsername(), auth.getPassword());
            responseData.setResult(true);
            responseData.getMessage();
            responseData.setData(value);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            // TODO: handle exception
        }
    }

    // @PostMapping("/register")
    // public User getUserLoginAuth(@Valid @RequestBody User user, Errors errors){
    //     ResponseData<User> responseData = new ResponseData<>();
    //         if(errors.hasErrors()) {
    //             for(ObjectError error : errors.getAllErrors()){
    //                 System.out.println(error.getDefaultMessage());
    //             }

    //             throw new RuntimeException("Akun Gagal Terdaftar")
    //         }
    //         return userServices.save(user);
    // }
}
