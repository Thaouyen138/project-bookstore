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

    private String price;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    private String url;

    @OneToMany(mappedBy = "bookOrder")
    @JsonBackReference("book")
    private List<Order> orderList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Book() {
    }

    public Book(Integer id, Integer isDelete, String name, String totalPage, String publisher, String publishedDate, String authors, String price, Category category, String url, List<Order> orderList) {
        this.id = id;
        this.isDelete = isDelete;
        this.name = name;
        this.totalPage = totalPage;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.authors = authors;
        this.price = price;
        this.category = category;
        this.url = url;
        this.orderList = orderList;
    }
}
