import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
@Injectable({
  providedIn: 'root'
})
export class SubtaskService {


  url = 'http://localhost:8011/subtask-service/api/subtasks'
  constructor(private http: Http) { }

  createSubtask(subtask: any) {
    return this.http.post(this.url, subtask);
  }

  getSubtask() {
    return this.http.get(this.url);
  }

  getSubtaskById(id) {
    return this.http.get(this.url + '/' + id);
  }

  editSubtask(subtask: any) {
    return this.http.put(this.url, subtask);
  }

  deleteSubtask(id) {
    return this.http.delete(this.url + '/' + id);
  }

  geAllDeveloper(){
    return this.http.get(this.url + '/developers');
  }

  getByTaskId(taskId) {
    return this.http.get(this.url + '/getByTaskId/' + taskId);
  }

  getByUserId() {
    // tslint:disable-next-line:radix
    const userId = parseInt(localStorage.getItem('userId'));
    return this.http.get(this.url + '/getByUserId/ ' + userId);
  }

}

