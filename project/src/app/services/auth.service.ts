import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import {parse} from 'ts-node';

@Injectable()
export class AuthService {
  constructor(private myRoute: Router) { }
  sendToken(token: string) {
    localStorage.setItem('LoggedInUser', token)
  }
  getToken() {
    return localStorage.getItem('LoggedInUser')
  }

  sendRole(role: string) {
    localStorage.setItem('role', role);
  }

  getRole() {
    return localStorage.getItem('role');
  }

  sendUserId(userId: number) {
    localStorage.setItem('userId', userId.toString());
  }

  getUserId() {
    return localStorage.getItem('userId');
  }

  sendProjectId(projectId: number) {
    localStorage.setItem('projectId', projectId.toString());
  }

  getProjectId() {
    return localStorage.getItem('projectId');
  }

  sendTaskId(taskid: number) {
    localStorage.setItem('taskId', taskid.toString());
  }

  getTaskId() {
    return localStorage.getItem('taskId');
  }

  isLoggedIn() {
    return this.getToken() !== null;
  }
  logout() {
    localStorage.removeItem('LoggedInUser');
    this.myRoute.navigate(['/']);
  }
}
