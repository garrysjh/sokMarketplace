package com.stringofkisses.api;

import com.stringofkisses.models.CartItems;
import com.stringofkisses.models.Category;
import com.stringofkisses.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface cartItemsRepository extends JpaRepository<CartItems, Integer> {

    @Query(value = "SELECT COUNT(QUANTITY) FROM CART_ITEMS WHERE cart_id = :cart_id AND product_id = :product_id", nativeQuery = true)
    int CheckIfExisting(int cart_id, int product_id);
@Modifying
@Transactional
    @Query(value = "update cart_items SET QUANTITY = QUANTITY+1 WHERE cart_id = :cart_id AND product_id = :product_id", countQuery = "select 1", nativeQuery = true)
    void incrementQuantity(int cart_id, int product_id);
    @Query(value = "select * from cart_items where cart_id = :cart_id", nativeQuery = true)
    List<CartItems> findAllFromCart(int cart_id);

    @Query(value = "SELECT * FROM cart_items WHERE id= :id", nativeQuery = true)
    CartItems getCartItem(int id);

    @Query(value = "SELECT QUANTITY FROM CART_ITEMS WHERE PRODUCT_ID = :product_id AND CART_ID = :cart_id", nativeQuery = true)
        int getQuantity(int product_id, int cart_id);

}


