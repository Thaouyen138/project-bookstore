package com.example.demo.service.impl;

import com.example.demo.model.book.Book;
import com.example.demo.repository.IBookRepository;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> findAllBook(String name) {
        return iBookRepository.findAllBook("%" + name + "%");
    }

    public Book findByIdBook(Integer id) {
        return iBookRepository.findByIdBook(id);
    }
}
