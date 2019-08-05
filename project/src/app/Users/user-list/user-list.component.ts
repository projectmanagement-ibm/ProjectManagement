import { Component, OnInit } from '@angular/core';
import { UsersService } from '../../services/users.service';
import {Router} from '@angular/router';

import {User} from '../../models/user.model';
@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  users: User[];
  searchedUsers: User[];
  searchedString: String;
    p: number;
    filter: string;
  constructor(
      private usersService: UsersService,
      private router: Router,
  ) { }

  ngOnInit() {
    this.getUsers();
  }

  getUsers() {
    this.usersService.getUsers()
        .subscribe(response => {
          this.users = response.json();
          console.log('users', response);
        }, error => {
          console.log('error', error);
        })
  }

  onAddUser() {
      this.router.navigate(['/user-profile']);
  }

  onEdit(user) {
    console.log('user onedit', user);
    this.router.navigate(['/update-user', user.id ] );
  }

  onRemove(user) {
      console.log('user onremove', user);

      this.usersService.deleteUser(user.id)
          .subscribe(response => {
              console.log('response on delete', response);
              this.getUsers();
          })
  }

  onSearch(fName) {
      console.log('search=====', fName);
      this.usersService.getByName(fName)
          .subscribe(response => {
              this.searchedUsers = response.json();
          })
  }
}
