package com.example.empolyeemanegement.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // names
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    // address
    private String address;
    @Column(unique = true)

    // phone and email
    private String phone;
    @Column(unique = true, nullable = false)
    private String email;

    // password
    @Column(nullable = false)
    private String password;

//    // payment
//    @OneToOne(cascade = CascadeType.MERGE)
//    private Payment payment;
//
//    @OneToOne
//    private Cart cart;
//
//    // verify password
//    public boolean verifyPassword(String password) {
//        return PasswordManager.getInstance().matches(password, this.password);
//    }
}
