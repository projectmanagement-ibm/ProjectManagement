import { SubtaskService } from './../../services/subtask.service';
import { SubtaskListComponent } from './../subtask-list/subtask-list.component';
import { Subtask } from './../../models/subtask.model';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators, Form } from '@angular/forms';
import { UsersService } from '../../services/users.service';
import { ActivatedRoute, Router, UrlSegment } from '@angular/router';
import { MatDatepickerModule } from '@angular/material';
import {MatDatepickerToggle} from '@angular/material';
@Component({
  selector: 'app-subtask-detail',
  templateUrl: './subtask-detail.component.html',
  styleUrls: ['./subtask-detail.component.scss']
})
export class SubtaskDetailComponent implements OnInit {

  formGroup: FormGroup;
  post: any = '';
  id = 0;
  subtaskId: number;
  subtask: Subtask;
  name: String;
  description: String;
  status: String;
  startDate: Date;
  endDate: Date;
  userId: number;
  taskId: number;
  priority: number;
  isUpdate: boolean;
  developers: any[];
  endPoint: String;
  minDate = new Date(2000, 12, 1);
  maxDate = new Date(2020, 12, 1);
  minDate1 = new Date();
  maxDate1 = new Date(2025, 1, 1);

  today = new Date();

  constructor(
      private formBuilder: FormBuilder,
      private subtaskService: SubtaskService,
      private router: Router,
      private activatedRoute: ActivatedRoute,
  ) {

    this.activatedRoute.url.subscribe((s: UrlSegment[]) => {
      this.endPoint = s[0].path;
      if (this.endPoint === 'add-subtask') {
        if (s[1]) {
          // tslint:disable-next-line:radix
          this.taskId = parseInt(s[1].path);
        }
      } else {
      if (s[1]) {
        console.log('url', s[1].path);
        // tslint:disable-next-line:radix
        this.id = parseInt(s[1].path);
        if (this.id > 0) {
          console.log('at line 422222');
          this.isUpdate = true;
          this.subtaskService.getSubtaskById(this.id)
              .subscribe(response => {
                this.subtask = response.json();
                if (this.subtask) {
                  this.subtaskId = this.subtask.id,
                  this.name = this.subtask.name;
                  this.description = this.subtask.description;
                  this.startDate = this.subtask.startDate;
                  this.endDate = this.subtask.endDate;
                  this.status = this.subtask.status;

                }
              })
        }
        }
      }
    })
  }

  ngOnInit() {
    this.getAllDeveloper();
    this.createForm();
  };

  getAllDeveloper() {
     this.subtaskService.geAllDeveloper()
         .subscribe(response => {
           this.developers = response.json();
           console.log('this.developers', this.developers);
         }, error => {
           console.log('error', error);
         })
  }
  createForm() {

    // tslint:disable-next-line:max-line-length

    this.formGroup = this.formBuilder.group({
      'name': [null, [
        Validators.required,
        Validators.minLength(3),
      ]],
      'description': [null,
        [Validators.required,
          Validators.minLength(3),
          Validators.maxLength(255)
        ]],
      'startDate': [null, [Validators.required,
      ]],
      'endDate': [null, [Validators.required,
      ]],


      'status': [null, [Validators.required,
        Validators.minLength(3),
        Validators.maxLength(50)
      ]],
      'userId': [null, Validators.required]
    })
  }


  onSubmit(post) {
    this.post = post;
    console.log('post===', post);
    console.log('isupdate at 92', this.isUpdate);
    if (this.isUpdate) {
      this.updateSubtask(this.post);
    } else {
      this.createSubtask(this.post);
    }
  }

  createSubtask(subtask) {

    subtask['taskId'] = this.taskId;

    this.subtaskService.createSubtask(subtask)
        .subscribe(response => {
          console.log('response', response);
          this.router.navigate(['/subtask-list']);
        }, error => {
          console.log('error', error);
        })
  }

  updateSubtask(subtask) {
    subtask['taskId'] = 1;
    subtask['userId'] = 1;
    console.log('update user at 123==', subtask);

    subtask['id'] = this.subtaskId;
    this.subtaskService.editSubtask(subtask)
        .subscribe(response => {
          console.log('response', response);
          this.isUpdate = false;
          this.router.navigate(['/subtask-list']);
        }, error => {
          console.log('error', error);
        })
  }

  onClose() {
    this.router.navigate(['/subtask-list']);
  }
}
