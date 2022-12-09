package com.example.demo.controller;

import com.example.demo.service.IBookService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("public/categoryList")
    public ResponseEntity<?> getAllCategory() {
        return new ResponseEntity<>(iCategoryService.findAllCategory(), HttpStatus.OK);
    }

    @GetMapping("public/bookList")
    public ResponseEntity<?> getAllBook(@RequestParam(name = "name", defaultValue = "") String name) {
        return new ResponseEntity<>(iBookService.findAllBook(name), HttpStatus.OK);
    }

    @GetMapping("public/findByIdBook/{id}")
    public ResponseEntity<?> getByIdBook(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(iBookService.findByIdBook(id), HttpStatus.OK);
    }
}
