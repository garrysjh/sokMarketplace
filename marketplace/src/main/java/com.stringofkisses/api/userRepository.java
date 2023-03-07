package com.stringofkisses.api;

import com.stringofkisses.models.Product;
import com.stringofkisses.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT password FROM User WHERE username= :username", nativeQuery = true)
    String findByUsername(String username);

    @Query(value = "SELECT id FROM User WHERE username= :username", nativeQuery = true)
    int findIdByUsername(String username);

    @Query(value = "SELECT First_name FROM USER WHERE id= :id", nativeQuery = true)
    String findFirstNameById(int id);

    @Query(value = "SELECT COUNT(Username) FROM USER WHERE username= :entered", nativeQuery = true)
    int findUserIfExists(String entered);


}
