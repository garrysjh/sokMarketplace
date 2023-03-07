package com.stringofkisses.api;

import com.stringofkisses.models.Category;
import com.stringofkisses.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT * FROM product WHERE id= :id", nativeQuery = true)
    Product getProduct(int id);

    @Query(value = "SELECT price from product where id= :id", nativeQuery = true)
    float getPrice(int id);

    @Query(value = "SELECT image from product where id= :id", nativeQuery = true)
    String getImg(int id);
}
