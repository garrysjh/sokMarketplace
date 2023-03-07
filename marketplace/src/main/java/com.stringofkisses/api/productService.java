package com.stringofkisses.api;

import com.stringofkisses.models.Category;
import com.stringofkisses.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService {
    @Autowired
    private productRepository ProductRepo;

    public List<Product> listAllProducts() {return ProductRepo.findAll();}

    public void addProduct(Product product) {
        ProductRepo.save(product);
    }

    public Product getFromId(int Id) {return ProductRepo.getProduct(Id);}

    public float getPrice(int Id) {
        return ProductRepo.getPrice(Id);
    }

    public String getImg(int Id) {
        return ProductRepo.getImg(Id);
    }

    public void delete(Product product) {ProductRepo.delete(product);


}}
