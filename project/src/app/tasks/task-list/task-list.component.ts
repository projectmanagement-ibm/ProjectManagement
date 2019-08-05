import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, Router, UrlSegment } from '@angular/router';
import { Task } from 'app/models/task.model';
import { TaskService } from 'app/services/task.service';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.scss']
})
export class TaskListComponent implements OnInit {

  tasks: Task[];
  projectTasks: Task[];
  teamLeadersTasks: Task[];
  projectId: any;
  role: any;
    p: any;
    filter: string;

  constructor(
      private tasksService: TaskService,
      private router: Router,
      private activatedRoute: ActivatedRoute,
      private auth: AuthService
  ) {
  }

  ngOnInit() {

      this.role = this.auth.getRole();
    // tslint:disable-next-line:radix
      this.projectId = parseInt(this.auth.getProjectId());
      if (this.role === 'team leader') {
         this.getTeamLeaderTasks();
        } else if (this.projectId) {
          this.getTaskByProjectId();
      } else if (this.role === 'admin') {
          this.getTasks();
      }

      this.activatedRoute.url.subscribe((s: UrlSegment[]) => {
          if (s[1]) {
              console.log('url', s[1].path);
              // tslint:disable-next-line:radix
              this.projectId = parseInt(s[1].path);
              this.auth.sendProjectId(this.projectId);
              console.log('id=====', this.projectId);
              if (this.projectId > 0 ) {
                  this.getTaskByProjectId();
              }
          }
      })
  }

  getTaskByProjectId() {
      this.tasksService.getTaskByProjectId(this.projectId)
          .subscribe(response => {
              this.projectTasks = response.json();
              console.log('this.projectTasks', this.projectTasks)
          }, error => {
              console.log('error', error);
          })
  }

    getTeamLeaderTasks() {
      this.tasksService.getTaskByUserId()
          .subscribe(response => {
              this.teamLeadersTasks = response.json();
              console.log('this.projectTasks', this.projectTasks)
          }, error => {
              console.log('error', error);
          })
    }

    getTasks() {
    this.tasksService.getTasks()
        .subscribe(response => {
          this.tasks = response.json();
          console.log('tasks', response);
        }, error => {
          console.log('error', error);
        })
  }

  onAddTask() {
    this.router.navigate(['/add-task', this.projectId]);
  }

  onEdit(task) {
    console.log('task onedit-------------------', task);
    this.router.navigate(['/update-task', task.id ] );
  }

  onRemove(task) {
    console.log('task onremove', task);

    this.tasksService.deleteTask(task.id)
        .subscribe(response => {
          console.log('response on delete', response);
          this.getTaskByProjectId();
        })
  }
}
