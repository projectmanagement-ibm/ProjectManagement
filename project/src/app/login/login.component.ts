import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {LoginService} from '../services/login.service';
import {getResponseURL} from '@angular/http/src/http_utils';
import { AuthService } from '../services/auth.service';
import {UsersService} from '../services/users.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  isValid: boolean;
  roles: any[];
  loggedInUser: any;

  constructor(
      private formBuilder: FormBuilder,
      private router: Router,
      private loginService: LoginService,
      private auth: AuthService,
      private usersService: UsersService
  ) {


      this.isValid = true;
      const emailRegex: RegExp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
      this.loginForm = this.formBuilder.group({
      'username': [null, [
          Validators.required,
          Validators.pattern(emailRegex)
      ]],
      'password': [null, [
          Validators.required
      ]]
    })

  }

  ngOnInit() {
      this.getRoles();
  }

  getRoles() {
      this.usersService.getRoles()
          .subscribe(response => {
              this.roles = response.json();
          })
  }
  onSubmit(user) {
      console.log('user in ligin', user);
      this.loginUser(user);
  }

  loginUser(user) {
      this.loginService.checkUser(user)
          .subscribe(response => {
              console.log('login response', response['_body']);
              if  (response['_body']) {
                  this.loggedInUser = JSON.parse(response['_body']);
                  console.log('this.loggedInUser', this.loggedInUser);

                  console.log('this.loggedInUser', this.loggedInUser['roleId']);
                  const temp = this.roles.filter(value => {
                      return value.roleId === this.loggedInUser['roleId'];
                  })

                  console.log('temp', temp[0].roleName);

                  this.isValid = true;
                  this.auth.sendToken(user.username);
                  this.auth.sendRole(temp[0].roleName);
                  this.auth.sendUserId(this.loggedInUser['userId']);
                  this.router.navigate(['/dashboard']);
              } else {
                  this.isValid = false;
              }
          })
  }
}
