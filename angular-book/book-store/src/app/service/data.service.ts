import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Book} from '../model/book';


@Injectable({
  providedIn: 'root'
})
export class DataService {
  messageSource = new BehaviorSubject<string>('');
  currentMessage = this.messageSource.asObservable();
  API_URL = `${environment.API_URL}`;
  constructor(private http: HttpClient) {}

  public getAllBook(name: string, categoryId: string): Observable<any> {
    return this.http.get<Book[]>(this.API_URL + 'public/bookList?name=' + name + '&category=' + categoryId );
  }
  changeMessage(name : string) {
    this.messageSource.next(name);
  }
}
