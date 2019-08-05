import { Injectable } from '@angular/core';
import {Http} from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url = 'http://localhost:8011/login-service/login';
  constructor(
      private http: Http
  ) { }

  checkUser(user) {
    return this.http.post(this.url, user);
  }
}
