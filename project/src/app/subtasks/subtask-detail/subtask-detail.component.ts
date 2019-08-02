import { SubtaskService } from './../../services/subtask.service';
import { SubtaskListComponent } from './../subtask-list/subtask-list.component';
import { Subtask } from './../../models/subtask.model';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators, Form } from '@angular/forms';
import { UsersService } from '../../services/users.service';
import { ActivatedRoute, Router, UrlSegment } from '@angular/router';

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
  projectId: number;
  taskId: number;
  priority: number;
  isUpdate: boolean;

  today=new Date();

  constructor(
    private formBuilder: FormBuilder,
    private subtaskService: SubtaskService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
  ) {

    console.log("today date==============="+this.today);
    this.activatedRoute.url.subscribe((s: UrlSegment[]) => {
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
    })
  }

  ngOnInit() {
    this.createForm();
  };


  createForm() {

    // tslint:disable-next-line:max-line-length

    this.formGroup = this.formBuilder.group({
      'name': [null, [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(15)
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
      ]]
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

    subtask['taskId'] = 1;
    subtask['userId'] = 1;
    //console.log('user at 111==', subtask);
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
}
