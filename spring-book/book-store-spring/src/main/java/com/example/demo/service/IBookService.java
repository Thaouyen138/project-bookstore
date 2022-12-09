package com.example.demo.service;

import com.example.demo.model.book.Book;

import java.util.List;

public interface IBookService {

    List<Book> findAllBook(String name);

    Book findByIdBook(Integer id);
}
