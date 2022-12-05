import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Book} from '../model/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  API_URL = `${environment.API_URL}`;
  constructor(private http: HttpClient) {}

  public getAllBook(): Observable<any> {
    return this.http.get<Book[]>(this.API_URL + 'public/bookList');
  }

  public findByID(id: number): Observable<Book> {
    return this.http.get<Book>(this.API_URL + 'public/findByIdBook/' + id);
  }

}
