package com.example.demo.model.transaction;

import com.example.demo.model.Order.Order;
import com.example.demo.model.customer.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @JsonBackReference("customer")
    private Customer customer;

    @Column(name = "start_date", columnDefinition = "DATETIME")
    private String startDate;

    private Integer payment;

    @Column(name = "payment_method")
    private String paymentMethod;

    @OneToMany(mappedBy = "transactionOrder")
    private List<Order> orderList;

    public Transaction() {
    }

    public Transaction(Integer id, Customer customer, String startDate, Integer payment, String paymentMethod, List<Order> orderList) {
        this.id = id;
        this.customer = customer;
        this.startDate = startDate;
        this.payment = payment;
        this.paymentMethod = paymentMethod;
        this.orderList = orderList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
