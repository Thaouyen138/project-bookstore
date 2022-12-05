import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Category} from '../model/category';
import {AppUser} from '../model/app-user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  API_URL = `${environment.API_URL}`;
  constructor(private http: HttpClient) { }
  public login(appuser: AppUser): Observable<any> {
    return this.http.post<any>(this.API_URL + 'public/login', appuser);
  }
}
