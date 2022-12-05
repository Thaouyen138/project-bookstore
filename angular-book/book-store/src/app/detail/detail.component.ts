import { Component, OnInit } from '@angular/core';
import {Book} from '../model/book';
import {ActivatedRoute} from '@angular/router';
import {BookService} from '../service/book.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  book: Book = null;

  constructor(private bookService: BookService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    const id = Number(this.activatedRoute.snapshot.params.id);
    this.bookService.findByID(id).subscribe(
      value => {
        this.book = value;
        console.log(this.book);
      }
    );
  }

  // findByIdBook() {
  // }
}
