package com.example.demo.model.Order;

import com.example.demo.model.book.Book;
import com.example.demo.model.transaction.Transaction;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity(name = "order_book")
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

    public Order(Integer id, int isDelete, int quantity, Transaction transactionOrder, Book bookOrder) {
        this.id = id;
        this.isDelete = isDelete;
        this.quantity = quantity;
        this.transactionOrder = transactionOrder;
        this.bookOrder = bookOrder;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Transaction getTransactionOrder() {
        return transactionOrder;
    }

    public void setTransactionOrder(Transaction transactionOrder) {
        this.transactionOrder = transactionOrder;
    }

    public Book getBookOrder() {
        return bookOrder;
    }

    public void setBookOrder(Book bookOrder) {
        this.bookOrder = bookOrder;
    }
}
