package com.example.demo.model.book;

import com.example.demo.model.Order.Order;
import com.example.demo.model.category.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "is_deleted", columnDefinition = "BIT(1)")
    private Integer isDelete = 0;

    private String name;

    @Column(name = "total_page")
    private String totalPage;

    private String publisher;

    @Column(name = "published_date")
    private String publishedDate;

    private String authors;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "bookOrder")
    @JsonBackReference("book")
    private List<Order> orderList;



}
