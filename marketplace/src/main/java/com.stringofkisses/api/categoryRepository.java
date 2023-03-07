package com.stringofkisses.api;

import com.stringofkisses.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface categoryRepository extends JpaRepository<Category, String> {
    @Query(value = "SELECT * FROM product_category WHERE id= :id", nativeQuery = true)
    Category getCategory(int id);
}
