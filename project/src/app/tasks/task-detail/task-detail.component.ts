import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UsersService } from 'app/services/users.service';
import { Router, ActivatedRoute, UrlSegment } from '@angular/router';
import { Task } from 'app/models/task.model';
import { TaskService } from 'app/services/task.service';



@Component({
  selector: 'app-task-detail',
  templateUrl: './task-detail.component.html',
  styleUrls: ['./task-detail.component.scss']
})
export class TaskDetailComponent implements OnInit {

  formGroup: FormGroup;
  post: any = '';
  teamLeaders: any[];
  id = 0;
  taskId: number;
  task: Task;
  name: String;
  description: String;
  startDate: Date;
  endDate: Date;
  status: String;
  isUpdate = false;
  minDate = new Date(2017, 0, 1);
  maxDate = new Date(2020, 0, 1);
  minDate1 = new Date(2020, 0, 1);
  maxDate1 = new Date(2025, 0, 1);
  endPoint: String;
  projectId: any;
  userId: any;

  constructor(
      private formBuilder: FormBuilder,
      private taskService: TaskService,
      private router: Router,
      private activatedRoute: ActivatedRoute,
  ) {

    this.activatedRoute.url.subscribe((s: UrlSegment[]) => {
      console.log('s=========', s);
      this.endPoint = s[0].path;
      console.log('endpoint=====', this.endPoint);
      if (this.endPoint === 'add-task') {
        if (s[1]) {
          // tslint:disable-next-line:radix
          this.projectId = parseInt(s[1].path);
        }
      } else {
        if (s[1]) {
          console.log('url', s[1].path);
          // tslint:disable-next-line:radix
          this.id = parseInt(s[1].path);

          console.log('id=====>>>>>', this.id);
          if (this.id > 0) {
            console.log('at line 422222');
            this.isUpdate = true;
            this.getTaskById();
          }
        }
      }
    })
  }

  ngOnInit() {
    this.getAllTeamLeader();
    this.createForm();
  };

  getTaskById() {
    this.taskService.getTaskById(this.id)
        .subscribe(response => {
          this.task = response.json();
          if (this.task) {
            this.taskId = this.task.id,
            this.name = this.task.name;
            this.description = this.task.description;
            this.startDate = this.task.startDate;
            this.endDate = this.task.endDate;
            this.status = this.task.status;
            this.userId = this.task.userId;
            this.projectId = this.task.projectId;
            console.log('task at 32', this.task);
          }
        })
  }
  getAllTeamLeader() {
    this.taskService.getAllTeamLeader()
        .subscribe(response => {
          this.teamLeaders = response.json();
        }, error1 => {
          console.log('error', error1);
        })
  }
  createForm() {
    const name = /^[a-zA-Z]{3,30}$/;
    // tslint:disable-next-line:max-line-length
    this.formGroup = this.formBuilder.group({
      'name': [null, [
        Validators.required,
        Validators.minLength(3)
      ]],
      'description': [null,
        [Validators.required,
          Validators.minLength(3)
        ]],
      'endDate': [null, [Validators.required

      ]],
      'startDate': [null, [Validators.required,
      ]],
      'status': [null, [Validators.required,
        Validators.minLength(3),
        Validators.maxLength(50)
      ]],
      'userId': [null, [Validators.required]]
    })
  }


  onSubmit(post) {
    this.post = post;
    console.log('post===', post);
    console.log('isupdate at 92', this.isUpdate);
    if (this.isUpdate) {
      this.updateTask(this.post);
    } else {
      this.createTask(this.post);
    }
  }

  createTask(task) {
    task['projectId'] = this.projectId;

    console.log('user at 111==', task);
    this.taskService.createTask(task)
        .subscribe(response => {
          console.log('response', response);
          this.router.navigate(['/task-list']);
        }, error => {
          console.log('error', error);
        })
  }

  updateTask(task) {
    task['projectId'] = 3;
    task['userId'] = 33
    console.log('update task at 123==', task);

    task['id'] = this.taskId;
    this.taskService.editTask(task)
        .subscribe(response => {
          console.log('response', response);
          this.isUpdate = false;
          this.router.navigate(['/task-list']);
        }, error => {
          console.log('error', error);
        })
  }

  onClose() {
    this.router.navigate(['/task-list']);
  }
}
