package com.stringofkisses.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="cart_items")
@Data
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

//    @OneToOne(mappedBy = "cartitems")
//    Product product;
    @Column(name="product_id")
    private int product_id;

    @Column(name="quantity")
    private int quantity = 0;

//    @ManyToOne
//            @JoinColumn(name = "cart_id", referencedColumnName = "id", nullable = false)
//    UserCart usercart;

    @Column(name="cart_id")
    private int cart_id;

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    public UserCart getUsercart() {
//        return usercart;
//    }
//
//    public void setUsercart(UserCart usercart) {
//        this.usercart = usercart;
//    }
}
