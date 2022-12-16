package com.resto.resto.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends CrudRepository<User, Integer> {
    @Query(value = "SELECT a.* FROM user a WHERE a.username = :username AND password = :password", nativeQuery = true)
    public Iterable<User> findAuth(@Param("username") String username, @Param("password") String password);
}
