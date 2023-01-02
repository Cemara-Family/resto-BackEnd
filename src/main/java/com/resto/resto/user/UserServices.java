package com.resto.resto.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServices {

    @Autowired
    private UserRepo userRepo;

    public User save(User user) {
        return userRepo.save(user);
    }

    public User update(User user) {
        User result = findOne(user.getId_user());
        result.setAlamat(user.getAlamat());
        result.setBirthdate(user.getBirthdate());
        result.setFullname(user.getFullname());
        result.setJenis_kelamin(user.getJenis_kelamin());
        result.setNoTelp(user.getNoTelp());
        result.setPassword(user.getPassword());
        result.setUsername(user.getUsername());
        result.setId_user(user.getId_user());

        return result;
    }

    public User findOne(int id) {
        return userRepo.findById(id).get();
    }

    public Iterable<User> findAll() {
        return userRepo.findAll();
    }

    public void removeOne(int id) {
        userRepo.deleteById(id);
    }

    // public Iterable<User> findAuth (String username, String password){
    // return userRepo.findUserAuth(username, password);
    // }
    public User findAuth(String username, String password) {
        return userRepo.findAuth(username, password);
    }
}
