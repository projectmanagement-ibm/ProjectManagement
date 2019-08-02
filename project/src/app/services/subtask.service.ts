import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
@Injectable({
  providedIn: 'root'
})
export class SubtaskService {

 
  url = 'http://localhost:8031/subtask/api/subtasks'
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
}
