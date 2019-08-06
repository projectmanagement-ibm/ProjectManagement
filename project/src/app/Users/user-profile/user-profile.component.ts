import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, FormControl, Validators, Form} from '@angular/forms';
import { Observable } from 'rxjs/Observable';
import {UsersService} from '../../services/users.service';
import {ActivatedRoute, Router, UrlSegment} from '@angular/router';
import {map} from 'rxjs/operators';
import {User} from '../../models/user.model';


@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  formGroup: FormGroup;
  post: any = '';
  id = 0;
  userId: number;
  user: User;
  firstName: String;
  lastName: String;
  contact: Number;
  email: String;
  address: String;
  isUpdate = false;
  roles: any[];

  constructor(
      private formBuilder: FormBuilder,
      private usersService: UsersService,
      private router: Router,
      private activatedRoute: ActivatedRoute,
              ) {
      this.usersService.getRoles()
          .subscribe(response => {
              this.roles  =  response.json();
              console.log('roles', this.roles);
          })

      this.activatedRoute.url.subscribe((s: UrlSegment[]) => {
          if (s[1]) {
              // tslint:disable-next-line:radix
              this.id = parseInt(s[1].path);

              console.log('id=====', this.id);

              if (this.id > 0) {
                  console.log('at line 422222');
                  this.isUpdate = true;
                  this.usersService.getUserById(this.id)
                      .subscribe(response => {
                          this.user = response.json();
                          if (this.user) {
                              this.userId = this.user.id,
                                  this.firstName = this.user.firstName;
                              this.lastName = this.user.lastName;
                              this.contact = this.user.contact;
                              this.email = this.user.email;
                              this.address = this.user.address;
                              console.log('user at 32', this.user);
                          }
                      })
              }
          }
      })
      }

  ngOnInit() {
    this.createForm();
  };


  createForm() {
      const name = /^[a-zA-Z]{3,30}$/;
      // tslint:disable-next-line:max-line-length
    const emailRegex: RegExp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    this.formGroup = this.formBuilder.group({
      'firstName': [null, [
          Validators.required,
          Validators.pattern(name),
          Validators.minLength(3),
      ]],
      'lastName': [null,
          [Validators.required,
          Validators.pattern(name),
          Validators.minLength(3),
      ]],
      'contact': [null, [Validators.required,
          Validators.minLength(10),
          Validators.maxLength(12)
      ]],
      'email': [null, [Validators.required,
        Validators.pattern(emailRegex)
      ]],
      'address': [null, [Validators.required,
      Validators.minLength(3),
      ]],
        'roleId': [
            null, [Validators.required]
        ]
    })
  }


  onSubmit(post) {
    this.post = post;
    console.log('post===', post);
    console.log('isupdate at 92', this.isUpdate);
    if (this.isUpdate) {
        this.updateUser(this.post);
    } else {
        this.createUser(this.post);
    }
  }

  createUser(user) {
    console.log('user at 111==', user);
    this.usersService.createUser(user)
        .subscribe(response => {
          console.log('response', response);
          this.router.navigate(['/user-list']);
        }, error => {
          console.log('error', error);
        })
  }

    updateUser(user) {
        user['roleId'] = 2;
        console.log('update user at 123==', user);

        user['id'] = this.userId;
        this.usersService.editUser(user)
            .subscribe(response => {
                console.log('response', response);
                this.isUpdate = false;
                this.router.navigate(['/user-list']);
            }, error => {
                console.log('error', error);
            })
    }

    onClose() {
        this.router.navigate(['/user-list']);
    }
}
