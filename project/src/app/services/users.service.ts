import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import {HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  url = 'http://localhost:8011/users-service/api/users';

  headers = new HttpHeaders().set('Access-Control-Allow-Origin', '*'); // create header object

  constructor(private http: Http) { }

  createUser(user: any) {
    return this.http.post(this.url, user);
  }

  getUsers() {
    return this.http.get(this.url);
  }

  getUserById(id) {
    return this.http.get(this.url + '/' + id);
  }

  editUser(user: any) {
    return this.http.put(this.url, user);
  }

  deleteUser(id) {
    return this.http.delete(this.url + '/' + id);
  }

  getRoles() {
    return this.http.get(this.url + '/roles');
  }

  getByName(fName) {
    return this.http.get(this.url + '/search/' + fName);
  }
}
