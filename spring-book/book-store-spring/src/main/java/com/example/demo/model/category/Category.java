package com.example.demo.model.category;

import com.example.demo.model.book.Book;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_deleted")
    private int isDelete = 0;

    @OneToMany(mappedBy = "category")
    @JsonBackReference("category")
    private Set<Book> books;

    public Category() {
    }

}
