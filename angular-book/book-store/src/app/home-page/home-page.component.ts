import { Component, OnInit } from '@angular/core';
import {CategoryService} from '../service/category.service';
import {BookService} from '../service/book.service';
import {Category} from '../model/category';
import {Book} from '../model/book';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  categoryList: Category[];
  bookList: Book[];

  constructor(private categoryService: CategoryService,
              private bookService: BookService) {
  }


  getAllCategory() {
    this.categoryService.getAllCategory().subscribe(value => this.categoryList = value);
  }

  getAllBook() {
    this.bookService.getAllBook().subscribe(value => this.bookList = value);
  }
  ngOnInit(): void {
    this.getAllCategory();
    this.getAllBook();
  }
}
