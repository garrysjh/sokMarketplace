package com.stringofkisses.api;

import com.stringofkisses.models.Product;
import com.stringofkisses.models.UserCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface userCartRepository extends JpaRepository<UserCart, Integer> {

    @Query(value = "SELECT id FROM user_cart WHERE user_id= :givenId", nativeQuery = true)
    int getCartIdFromUserId(int givenId);
}
