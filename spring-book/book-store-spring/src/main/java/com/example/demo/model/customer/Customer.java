package com.example.demo.model.customer;

import com.example.demo.model.transaction.Transaction;
import com.example.demo.model.user.AppUser;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "is_deleted")
    private int isDelete = 0;

    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "gender", columnDefinition = "BIT(1)")
    private Integer gender;
    @Column(name = "status")
    private int status = 0;
    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "user_name", referencedColumnName = "user_name")
    private AppUser appUser;

    @OneToMany(mappedBy = "customer")
    private List<Transaction> transactionList;

    public Customer() {
    }

    public Customer(Integer id, int isDelete, String name, String phoneNumber, String address, Integer gender, int status, String email, List<Transaction> transactionList) {
        this.id = id;
        this.isDelete = isDelete;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.status = status;
        this.email = email;
        this.transactionList = transactionList;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
