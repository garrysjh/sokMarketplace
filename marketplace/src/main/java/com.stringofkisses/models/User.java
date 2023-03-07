package com.stringofkisses.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(unique = true, name="username")
    private String username;
    @Column(unique = true, name="password")
    private String password;
    @Column(unique = true, name="first_name")
    private String first_name;
    @Column(unique = true, name="last_name")
    private String last_name;
    @Column(unique = true, name="email")
    private String email;
    @Column(unique = true, name="phone")
    private String phone;
    @Column(name="admin")
    private Boolean admin;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="id", referencedColumnName = "user_id")
//    private UserCart userCart;

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
