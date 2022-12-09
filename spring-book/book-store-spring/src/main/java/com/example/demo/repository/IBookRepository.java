package com.example.demo.repository;

import com.example.demo.model.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book,Integer> {

    @Query(value = "select * from book where is_deleted = 0 and name like :name", nativeQuery = true)
    List<Book> findAllBook( @Param("name") String name);

    @Query(value = "select * from book where id = :id", nativeQuery = true)
    Book findByIdBook(@Param("id") Integer id);
}
