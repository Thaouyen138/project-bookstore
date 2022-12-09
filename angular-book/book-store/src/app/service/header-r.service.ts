import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Book} from '../model/book';

@Injectable({
  providedIn: 'root'
})
export class HeaderRService {
  API_URL = `${environment.API_URL}`;
  constructor(private http: HttpClient) {}

  public getAllBook(name: string, categoryId: string): Observable<any> {
    return this.http.get<Book[]>(this.API_URL + 'public/bookList?name=' + name + '&category=' + categoryId );
  }
}
