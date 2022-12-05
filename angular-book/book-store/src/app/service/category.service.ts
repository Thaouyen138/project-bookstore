import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Category} from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  API_URL = `${environment.API_URL}`;
  constructor(private http: HttpClient) { }
  public getAllCategory(): Observable<any> {
    return this.http.get<Category[]>(this.API_URL + 'public/categoryList');
  }
}
