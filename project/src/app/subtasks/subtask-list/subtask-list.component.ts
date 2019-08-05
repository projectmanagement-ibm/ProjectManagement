import { Subtask } from './../../models/subtask.model';
import { SubtaskService } from './../../services/subtask.service';
import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router, UrlSegment} from '@angular/router';
import {AuthService} from '../../services/auth.service';

@Component({
  selector: 'app-subtask-list',
  templateUrl: './subtask-list.component.html',
  styleUrls: ['./subtask-list.component.scss']
})
export class SubtaskListComponent implements OnInit {

  subtasks: Subtask[];
  developerSubtasks: Subtask[];
  taskSubtasks: Subtask[];
  role: any;
  taskId: any;

  constructor(
      private subtaskService: SubtaskService,
      private auth: AuthService,
      private router: Router,
      private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit() {
      this.role = this.auth.getRole();
      // tslint:disable-next-line:radix
      this.taskId = parseInt(this.auth.getTaskId());
      if (this.role === 'developer') {
          this.getDeveloperTask();
      } else if (this.taskId) {
          this.getByTaskId();
      } else if (this.role === 'admin') {
          this.getSubtask();
      }

      this.activatedRoute.url.subscribe((s: UrlSegment[]) => {
          if (s[1]) {
              console.log('url', s[1].path);
              // tslint:disable-next-line:radix
              this.taskId = parseInt(s[1].path);
              this.auth.sendTaskId(this.taskId);
              if (this.taskId > 0) {
                  this.getByTaskId();
              }
          }
      })
  }


  getSubtask() {
    this.subtaskService.getSubtask()
        .subscribe(response => {
          this.subtasks = response.json();
          console.log('users', response);
        }, error => {
          console.log('error', error);
        })
  }

  getByTaskId() {
      this.subtaskService.getByTaskId(this.taskId)
          .subscribe(response => {
              this.taskSubtasks = response.json();
          }, error => {
              console.log('error', error);
          })
  }

    getDeveloperTask() {
      this.subtaskService.getByUserId()
          .subscribe(response => {
              this.developerSubtasks = response.json();
          }, error => {
              console.log('error', error);
          })
  }

  onAddSubtask() {
    this.router.navigate(['/add-subtask']);
  }

  onEdit(subtask) {
    console.log('user onedit', subtask);
    this.router.navigate(['/edit-subtask', subtask.id]);
  }

  onRemove(subtask) {
    console.log('user onremove', subtask);

    this.subtaskService.deleteSubtask(subtask.id)
        .subscribe(response => {
          console.log('response on delete', response);
          this.getSubtask();
        })
  }
}

