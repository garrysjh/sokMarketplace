package com.stringofkisses.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="user_cart")
public class UserCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


//    @OneToOne(mappedBy = "userCart")
//    private User user;

    @Column(name="purchased")
    private Boolean purchased;

    @Column(name="user_id")
    private int user_id;
//    @OneToMany(mappedBy="CartItems")
//    private Set<CartItems> cartItemsSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Boolean getPurchased() {
        return purchased;
    }

    public void setPurchased(Boolean purchased) {
        this.purchased = purchased;
    }
}
