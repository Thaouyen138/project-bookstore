import {Component, DoCheck, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {CategoryService} from '../service/category.service';
import {BookService} from '../service/book.service';
import {Category} from '../model/category';
import {Book} from '../model/book';
import {DataService} from '../service/data.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  categoryList: Category[];
  bookList: Book[];
  name = '';
  category = '';

  constructor(private categoryService: CategoryService,
              private bookService: BookService,
              private data: DataService) {
    data.currentMessage.subscribe(name => {
      this.name = name;
    })
  }

  getAllCategory() {
    this.categoryService.getAllCategory().subscribe(value => this.categoryList = value);
  }

  getAllBook() {
    this.bookService.getAllBook(this.name).subscribe(value => this.bookList = value);
  }

  ngOnInit(): void {
    this.getAllCategory();
    this.getAllBook();
  }
}
