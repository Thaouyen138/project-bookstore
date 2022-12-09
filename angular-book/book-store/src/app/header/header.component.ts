import { Component, OnInit } from '@angular/core';
import {BookService} from '../service/book.service';
import {CategoryService} from '../service/category.service';
import {Category} from '../model/category';
import {Book} from '../model/book';
import {DataService} from '../service/data.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  username = 'Tài khoản';
  name = '';
  category = '';
  categoryList: Category[];
  bookList: Book[];
  constructor(private categoryService: CategoryService,
              private bookService: BookService,
              private data: DataService) {
  }


  getAllCategory() {
    this.categoryService.getAllCategory().subscribe(value => this.categoryList = value);
  }

  getAllBook() {
    this.bookService.getAllBook(this.name, this.category).subscribe(value => {
      this.bookList = value;
    });
  }
  ngOnInit(): void {
    this.username = sessionStorage.getItem('username');
  }

  search() {
    this.data.changeMessage(name);
  }
  chonLoaiSach($event: any) {
    this.category = String($event);
  }
}
