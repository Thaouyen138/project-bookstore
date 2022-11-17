package com.example.demo.model.Order;

import com.example.demo.model.book.Book;
import com.example.demo.model.transaction.Transaction;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "is_deleted")
    private int isDelete = 0;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "transaction_id", referencedColumnName = "id")
    @JsonBackReference("transaction")
   private Transaction transactionOrder;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book bookOrder;

    public Order() {
    }

}
