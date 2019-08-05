import { Injectable } from '@angular/core';
import {Http} from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  url = 'http://localhost:8011/task-service/api/tasks'

  constructor(private http: Http) { }

  createTask(task: any) {
    console.log('my data:' + task);
    return this.http.post(this.url, task);
  }

  getTasks() {
    return this.http.get(this.url);
  }

  getTaskById(id) {
    return this.http.get(this.url + '/' + id);
  }

  getTaskByProjectId(projectId) {
    return this.http.get(this.url + '/getTasksByProjectId/' + projectId);
  }

  getTaskByUserId() {
    // tslint:disable-next-line:radix
    const userId = parseInt(localStorage.getItem('userId'));
    return this.http.get(this.url + '/getTasksByUserId/' + userId);
  }
  editTask(task: any) {
    return this.http.put(this.url, task);
  }

  deleteTask(id) {
    return this.http.delete(this.url + '/' + id);
  }

  getAllTeamLeader() {
    return this.http.get(this.url + '/teamLeaders');
  }
}

