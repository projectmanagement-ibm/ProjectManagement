import { Injectable } from '@angular/core';
import {Http} from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  url = 'http://localhost:8011/project-service/api/projects'

  constructor(private http: Http) { }

  createProject(project: any) {
    return this.http.post(this.url, project);
  }

  getProjects() {
    return this.http.get(this.url);
  }

  getProjectById(id) {
    return this.http.get(this.url + '/' + id);
  }

  editProject(project: any) {
    return this.http.put(this.url, project);
  }

  deleteProject(id) {
    return this.http.delete(this.url + '/' + id);
  }

  getAllManager() {
    return this.http.get(this.url + '/managers');
  }

  getProjectByUserId() {
    // tslint:disable-next-line:radix
    const id = parseInt(localStorage.getItem('userId'));
    return this.http.get(this.url + '/getProjects/' + id);
  }





}
